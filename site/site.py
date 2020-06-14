import flask as fsk
from flask import request, jsonify, render_template

app = fsk.Flask(__name__, static_url_path='/static')
app.config["DEBUG"] = True

@app.route('/', methods=['GET'])
def home():
    return render_template('index.html')

app.run(host='0.0.0.0')
