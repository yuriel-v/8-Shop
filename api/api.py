"""
api.py: API "RESTful" (mais ou menos) para o sistema 8-Shop
As primeiras versões dessa API foram baseadas em templates encontrados
no endereço abaixo:

https://programminghistorian.org/en/lessons/creating-apis-with-python-and-flask

Tais primeiras versões são somente para testes. A API completa será no mesmo
estilo, mas com código completamente diferente.

"""
import flask as fsk
from flask import request, jsonify, render_template
import mysql.connector
#import sqlalchemy as sqla
#from sqlalchemy.ext.declarative import declarative_base
# tentei usar sqlalchemy mas não tenho tempo de aprender as peculiaridades da ferramenta,
# mas é uma ferramenta brilhante.

app = fsk.Flask(__name__)
app.config["DEBUG"] = True

cnx = mysql.connector.connect(user='api', password='api@eightstore', database='eightshop')
cursor = cnx.cursor()


@app.route('/v1/mercadorias/buscar', methods=['GET'])
def buscar_mercadoria():
    """
    Busca informações de mercadorias por categoria, nome ou loja no banco de dados.\n
    Chaves obrigatórias: Pelo menos uma das chaves listadas abaixo.\n
        - categoria
        - nome
        - loja
    \n
    Exemplos: http://api.net/v1/mercadorias/buscar?categoria=eletronicos\n
    http://api.net/v1/mercadorias/buscar?nome=PenDrive\n
    http://api.net/v1/mercadorias/buscar?loja=Prado&categoria=ferramentas\n
    """
    cnt = 0
    for val in ('categoria', 'nome', 'loja'):
        if val in request.args.keys() or str(request.args[val]).upper() != "NULL":
            cnt += 1
    
    if cnt == 0:
        return jsonify([])

    req = "SELECT * FROM mercadoria WHERE "
    if 'categoria' in request.args.keys():
        req += f"categoria = {str(request.args['categoria'])} AND"
    
    if 'loja' in request.args.keys():
        req += f"cnpj = {str(request.args['loja'])} AND"
    
    if 'nome' in request.args.keys():
        req += f"nome = {str(request.args['nome'])} AND"

    req = req[:-4] + ";"
    
    cursor.execute(req)
    return jsonify(cursor.fetchall())


@app.route('/v1/catalogos/cliente/buscar', methods=['GET'])
def buscar_cliente():
    """
    Busca o cadastro de um cliente no banco de dados.
    Chaves obrigatórias: cpf.
    Exemplo: http://api.net/v1/catalogos/cliente/buscar?cpf=000.000.000-00
    """
    if 'cpf' not in request.args.keys() or str(request.args['cpf']).upper() == "NULL":
        return jsonify([])
    
    req = f"SELECT * FROM cliente WHERE cpf = {str(request.args['cpf'])};"
    cursor.execute(req)
    return jsonify([val for val in cursor])


@app.route('/v1/catalogos/lojas/buscar', methods=['GET'])
def buscar_loja():
    """
    Busca o cadastro de uma loja no banco de dados.\n
    Chaves obrigatórias: cnpj (use '_' em vez de '/').
    Exemplo: http://api.net/v1/catalogos/lojas/buscar?cnpj=00.000.000_0001-00
    """
    if 'cnpj' not in request.args.keys() or str(request.args['cnpj']).upper() == "NULL":
        return jsonify([])
    
    req = f"SELECT * FROM loja WHERE cnpj = {str(request.args['cnpj'])};"
    cursor.execute(req)
    return jsonify(cursor.fetchone())


@app.route('/v1/compras/realizar', methods=['GET'])
def comprar():
    """
    Realiza uma compra.\n
    Chaves obrigatórias: cpf (cliente), cnpj (vendedor, use '_' em vez de '/'), qtd (quantidade), 
    codmerc (código da mercadoria), metpag (método de pagamento).\n
    Exemplo: http://api.net/v1/compras/realizar?cpf=000.000.000-00&cnpj=00.000.000_0001-00&qtd=3&codmerc=14&metpag=CartaoCredito
    """
    for val in ('cpf', 'cnpj', 'qtd', 'codmerc', 'metpag'):
        if val not in request.args.keys():
            return jsonify(1)  # faltando campos obrigatórios
        elif str(request.args[val]).upper() == "NULL":
            return jsonify(2)  # campos nulos em campos obrigatórios
    
    try:
        cpf = str(request.args['cpf'])
        cnpj = str(request.args['cnpj'])
        metpag = str(request.args['metpag'])
        codmerc = str(request.args['codmerc'])
        qtd = str(request.args['qtd'])

        cursor.execute(f"SELECT preco FROM mercadoria WHERE codmercadoria = {codmerc}")
        preco = float(cursor.fetchone()[0] * int(qtd))

        req = f"INSERT INTO pedido(cpf, cnpj, pagamento, pago, totalpreco) VALUES({cpf}, {cnpj}, {metpag}, FALSE, )"
        cursor.execute(req)
        pk = cursor.execute("SELECT MAX(codpedido) FROM pedido;").fetchone()

        if request.args['metpag'] == "CartaoCredito":  # cartão pré-aprovado
            req = f"UPDATE pedido SET pago = TRUE WHERE codpedido = {pk};"
            cursor.execute(req)
    
        req = f"INSERT INTO contem(codPedido, codMerc, qtd) VALUES({pk}, {codmerc}, {qtd})"
        cursor.execute(req)
    except:
        return jsonify(-1)  # erro desconhecido
    else:
        return 0  # sucesso


@app.route('/v1/agendamentos/realizar', methods=['GET'])
def agendar():
    """
    Realiza um agendamento para um certo pedido.\n
    Chaves obrigatórias: data (data/hora -> HH:mm_dd/mm/aaaa), codped (código do pedido).\n
    Exemplo: http://api.net/v1/agendamentos/realizar?data=16:00_20/06/2020&codped=123
    """
    for val in ('data', 'codped'):
        if val not in request.args.keys() or str(request.args[val]).upper() == "NULL":
            return jsonify([])
    
    # verifica se o pedido realmente existe no BD
    cursor.execute(f"SELECT EXISTS (SELECT * FROM pedido WHERE codpedido = {str(request.args['codped'])})")
    if not bool(cursor.fetchone()[0]):
        return jsonify(1)  # pedido inexistente
    
    try:
        codped = str(request.args['codped'])
        data = str(request.args['data'])

        cursor.execute(f"INSERT INTO agendamento(codpedido, horario, status) VALUES({codped}, {data}, 1)")
        # status de agendamento:
        # 0: pedido entregue
        # 1: aguardando confirmação do vendedor
        # 2: aguardando visita do cliente (produto)
        # 3: aguardando visita do vendedor (serviço)
    except:
        return jsonify(-1)  # erro desconhecido
    else:
        return jsonify(0)  # sucesso
    

@app.route('/v1/pedidos', methods=['GET'])
def acompanhar_pedido():
    """
    Retorna um ou vários pedidos e detalhes sobre acompanhamento para um cliente específico.\n
    Chaves obrigatórias: cliente (cpf), codped (código do pedido).\n
    Exemplo: http://api.net/v1/pedidos?cpf=000.000.000-00&codped=123
    """
    for val in ('cliente', 'codped'):
        if val not in request.args.keys() or str(request.args[val]).upper() == "NULL":
            return jsonify([])
    
    if request.args['codped'] == "all":
        cursor.execute(f"SELECT * FROM pedidos WHERE cpf = {str(request.args['cliente'])}")
        values = cursor.fetchone()
        res = dict({
            'codpedido': values[0],
            'pago': values[4],
            'totalpreco': values[5]
        })
    
    return jsonify(0)  # não ainda implementado
    # a gente decidiu, por falta de tempo, deixar essa funcionalidade de lado.


"""
@app.route('/testapi', methods=['GET'])
def test():
    for val in ('cpf', 'cnpj', 'qtd'):
        if val not in request.args.keys():
            return "Erro 1!"  # faltando campos obrigatórios
        elif str(request.args[val]).upper() == "NULL":
            return "Erro 2!"  # campos nulos em campos obrigatórios
    
    return "Sucesso!"
"""
app.run(host='0.0.0.0')
cursor.close()
cnx.close()
