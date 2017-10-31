#!/usr/bin/python3
from flask import render_template, flash, redirect, request, send_from_directory, url_for
import uuid
import os
import subprocess
from flask import Flask


text_path = 'data/%s/text'
zip_path = 'data/%s/zip'

huffman_cmd = 'java Main %s | tail -n 1 > %s'

app = Flask(__name__)

@app.route('/result', methods=['GET', 'POST'])
def result():
    my_uuid = request.args['my_uuid']
    with open(zip_path % my_uuid, 'r') as f:
        content = f.read()
    return render_template('result.html', encoded=content, my_uuid=my_uuid)

@app.route('/compress', methods=['POST'])
def do_compress():
    content = request.form['content']
    fid = uuid.uuid4().hex
    zip_ = zip_path % fid
    text_ = text_path % fid
    target_dir = 'data/' + fid
    if not os.path.exists(target_dir):
        os.makedirs(target_dir)
    
    with open(text_, 'wb') as f:
        f.write(content.encode('utf8'))

    cmd = huffman_cmd % (text_, zip_)
    subprocess.call(cmd, shell=True)
    return redirect(url_for('.result', my_uuid=fid))

@app.route('/decompress', methods=['POST'])
def decompress():
    my_uuid = request.form['my_uuid']
    if os.path.exists('data/' + my_uuid):
        with open(text_path % my_uuid, 'r') as f:
            return render_template("decode.html", text=f.read())
    else:
        return "Not Found"

@app.route('/', methods=['GET'])
def huffman():
    return render_template('index.html')


if __name__ == '__main__':
    app.run(host='0.0.0.0', port=55555, debug=False)
