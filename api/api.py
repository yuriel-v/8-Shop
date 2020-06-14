"""
api.py: API RESTful para o sistema 8-Shop
As primeiras versões dessa API foram baseadas em templates encontrados
no endereço abaixo:

https://programminghistorian.org/en/lessons/creating-apis-with-python-and-flask

Tais primeiras versões são somente para testes. A API completa será no mesmo
estilo, mas com código completamente diferente.

"""
import flask as fsk
from flask import request, jsonify, render_template

app = fsk.Flask(__name__)
app.config["DEBUG"] = True

books = [
    {'id': 0,
     'title': 'A Fire Upon the Deep',
     'author': 'Vernor Vinge',
     'first_sentence': 'The coldsleep itself was dreamless.',
     'year_published': '1992'},
    {'id': 1,
     'title': 'The Ones Who Walk Away From Omelas',
     'author': 'Ursula K. Le Guin',
     'first_sentence': 'With a clamor of bells that set the swallows soaring,'
                        ' the Festival of Summer came to the city Omelas, '
                        'bright-towered by the sea.',
     'published': '1973'},
    {'id': 2,
     'title': 'Dhalgren',
     'author': 'Samuel R. Delany',
     'first_sentence': 'to wound the autumnal city.',
     'published': '1975'}
]

@app.route('/', methods=['GET'])
def home():
    return "<h1>Distant Reading Archive</h1><p>ecks fuckin' dee</p>"

@app.route('v1/resources/books/all', methods=['GET'])
def api_all():
    return jsonify(books)

@app.route('v1/resources/books', methods=['GET'])
def api_search():
    if not ('id' in request.args):
        return "No ID field provided: please specify one."
    
    return jsonify([book for book in books if book['id'] == int(request.args['id'])])

app.run(host='0.0.0.0')
