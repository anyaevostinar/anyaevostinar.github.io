---
layout: page
title: Flask with HTML
permalink: /classes/257-s22/flask-html
---

## Goal
Use a basic HTML template with Flask.

## Setup
You should continue to work in the `FlaskLab` folder that you made for the [Flask intro](flask-intro) lab.
If you don't have access to it anymore, just go through the steps to set up a basic Flask app with the `dataset.csv` file again.

## Templates
As you know from your reading, Flask allows you to connect with HTML templates.
Flask handles finding these as long as you put them where it is expecting.

1. Create a `templates` folder in your `FlaskLab` folder
2. Create a file in that folder `index.html` and put in the following boilerplate:
    ```html
    <html>
        <head>

        </head>
        <body>

        </body>
    </html>
    ```
3. Within the `heading` put in a set of `title` HTML tags and place a placeholder `{{title}}` between them:
    ```html
    <title>{{title}}</title>
    ```
4. If you have as many tabs open as I do regularly, you can't actual see the titles easily, so, within the `body`, put in a heading with the title as well:
    ```html
    <h1>Welcome to the {{title}}!</h1>
    ```
5. Now you need to go edit your existing Flask app to use your new template. Open `flask_lab_app.py` and edit your `homepage()` function so that instead of just returning a plain string, it returns the result of calling `render_template` with your title of choice:
    ```python
    @app.route('/')
    def homepage():
        return render_template('index.html', title="Silly Dataset")
    ```
6. Run your app and check out your new fancy (kind of) homepage!

## Data with Templates
Even though you don't strictly have to use Jinja, it makes displaying lists much easier.
Let's display the headings of the silly dataset on the homepage.

1. Within `index.html` make an unordered list in the `body`:
    ```html
    <ul>
    </ul>
    ```
2. Within that unordered list, we'll use Jinja to make a list item for each heading in our list `headings`:
    ```html
    {% for heading in headings: %}
    <li>{{ heading }}</li>
    {% endfor %}
    ```
3. Now we need to actually pass that argument. Within `flask_lab_app.py`, add to the arguments that you are passing to `render_template` in `homepage`:
    ```python
    def homepage():
        return render_template('index.html', title="Silly Dataset", headings = data[0])
    ```
4. Restart your app to see your new fancy list!
5. Try adding another list of the first data row of the silly dataset.

## Fun extra
By combining the route variables and Jinja placeholders, you can let the user display what they want on your page.
Try making a new template and route so that you can go to `your_url/greeting/your_name` and find a web page that greets whatever the user puts for `your_name`.

## Applying to your project
You don't need to use HTML templates for what you submit tonight and Monday, but you will need them for the team project eventually, so it's a good idea to try adding one to your individual deliverable project for practice.

Otherwise, feel free to keep working on your individual deliverable Flask app and/or your team's Flask app.