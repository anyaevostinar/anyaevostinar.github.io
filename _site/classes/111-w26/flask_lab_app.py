from flask import Flask, render_template
import csv

app = Flask(__name__)

data = []

def load_data():
    '''Loads data from Pokemon.csv into data global variable'''
    with open('Pokemon.csv', newline='') as f:
        reader = csv.reader(f)
        for row in reader:
            data.append(row)

@app.route('/')
def homepage():
    return "hello, this is the homepage"

if __name__ == '__main__':
    load_data()
    app.run(port=5100)