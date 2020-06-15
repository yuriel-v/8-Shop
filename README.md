# 8-Shop
Repositório para os artefatos relacionados ao projeto do Grupo VIII da Hackathon Online do BNDES, processo de seleção de estagiários.
## Integrantes:
- Leonardo Braga Valim
- Douglas Melo Silva
- Júlia Costa de Souza
## O Problema
Nos tempos de pandemia atuais, muitas lojas e comércios físicos estão com dificuldades em manter seus negócios. A questão apresentada ao Grupo foi, "Como possibilitar a atuação do comércio e serviço baseado em lojas físicas em época de isolamento social?".
Logo a solução proposta foi a seguinte.
## A solução
Uma plataforma que aproximasse clientes de lojistas físicos, que facilitasse a organização de entregas via agendamento e auxiliasse nas vendas, tanto com uma maior exposição da loja quanto na redução da exposição de pessoas ao COVID-19.  
Isso, seria muito útil nos tempos atuais.  
E é o que nós propomos através desse marketplace virtual. Um sistema onde qualquer loja e qualquer cliente pode se cadastrar e achar/vender o que quiser, com visitas agendadas e sem cobranças abusivas.
## A técnica
O sistema é composto de 3 camadas:
- O front-end, composto pelas páginas e interfaces de usuário, feito em Java, HTML e CSS;
- O back-end, que consiste em uma API feita em Python e Flask, que compõe a ponte entre front e back-end;
- O banco de dados, construído em cima de MySQL.

## Como rodar
A API e o site são hospedados na framework Flask, que possibilita a execução facilmente através de uma instalação padrão de Python (pacote Anaconda).  
Basta instalar o Anaconda, ativar o ambiente base (conda activate base) e rodar site.py e/ou api.py por um dos commandos:
```text
python site.py
python api.py
```

No momento, eu, Leonardo, hospedo o site na minha própria máquina no site:```text
http://189.60.213.246/
http://189.60.213.246:5000  (API)
```
  
Podem haver possíveis quedas de sistema, entretanto. Vou tentar hospedar o site o máximo que puder durante a próxima semana.  

Fique em casa, não se esqueça da higienização e boas compras!