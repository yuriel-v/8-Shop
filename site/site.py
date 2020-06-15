import flask as fsk
from flask import request, jsonify, render_template

app = fsk.Flask(__name__, static_url_path='/static')
app.config["DEBUG"] = True

@app.route('/', methods=['GET'])
def home():
    return render_template('index.html')


@app.route('/agendamento', methods=['GET'])
def agendamento():
    return render_template('agendamento.html')


@app.route('/compra', methods=['GET'])
def compra():
    return render_template('compra.html')


@app.route('/lojas', methods=['GET'])
def lojas():
    return render_template('lojas.html')


@app.route('/pedido', methods=['GET'])
def pedido():
    return render_template('pedido.html')

app.run(host='0.0.0.0', port=80)
