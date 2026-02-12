from flask import Flask, render_template, request
import csv

app = Flask(__name__)
data = []

def load_data():
    with open('Pokemon.csv', newline='') as f:
        reader = csv.reader(f)
        for row in reader:
            data.append(row)


def get_pokemon(poke_name):
    '''
    Renders the Pokemon page
    :param poke_name: The Pokemon to display
    :return: The Pokemon's page
    '''
    for pokemon in data:
        if poke_name==pokemon[1]:
            return pokemon
    return "Pokemon not found, try Bulbasaur instead!"

def getRowTitles():
    row_titles = []
    for row in data:
        row_titles.append(row[1])

    return row_titles
    
@app.route('/displayrow')
def display_row():
    row = int(request.args['rowchoice'])

    return str(data[row]) + "You have a " + request.args['vehicle1']

@app.route('/rowbytitle')
def display_row_by_title():
    return str(get_pokemon(request.args['rowchoice']))

@app.route('/')
def index():
    '''
    Renders the index page
    :return: The index page
    '''
    return render_template('index.html', rows=getRowTitles())


if __name__ == '__main__':
    load_data()
    app.run(port=5100)