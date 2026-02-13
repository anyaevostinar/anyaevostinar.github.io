---
layout: page
title: Flask with HTML
permalink: /classes/257-w26/flask-html
---

## Goal
Use a basic HTML template with Flask. 

## Setup
Make sure to activate your virtual environment.

Clone down the starter code linked from Moodle `Flask HTML Starter Repo`.

## Templates
As you know from your reading, Flask allows you to connect with HTML templates.
Flask handles finding these as long as you put them where it is expecting.

(Fun fact/note: because I'm using a [framework](https://jekyllrb.com/) that has very similar syntax to Jinja to make this website, I have to do a [special escape](https://www.tomordonez.com/curly-braces-markdown-jekyll/) to actually display all the {%raw%} `{{var}}` {%endraw%}, and I might have missed a few, so if you see a strangely blank spot, it is very likely that it should have some curly braces with a variable in it.)

1. Create a `templates` folder in your lab folder
2. Create a file in that folder `index.html` and put in the following boilerplate:
    ```html
    <html>
        <head>

        </head>
        <body>

        </body>
    </html>
    ```
3. Within the `heading` put in a set of `title` HTML tags and place a placeholder {%raw%}`{{title}}`{%endraw%} between them:
    ```html
    {%raw %}
    <title>{{title}}</title>
    {%endraw%}
    ```
4. If you have as many tabs open as I do regularly, you can't actual see the titles easily, so, within the `body`, put in a heading with the title as well:
    ```html
    {%raw%}
    <h1>Welcome to the {{title}}!</h1>
    {%endraw%}
    ```
5. Now you need to go edit your existing Flask app to use your new template. Open `app.py` and edit your `index()` function so that instead of just returning a plain string, it returns the result of calling `render_template` with your title of choice:
    ```python
    @app.route('/')
    def index():
        return render_template('index.html', title="Pokemon Dataset")
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
    {%raw%}{% for heading in headings: %}
    <li>{{ heading }}</li>
    {% endfor %}{%endraw%}
    ```
3. Now we need to actually pass that argument. Within `app.py`, add to the arguments that you are passing to `render_template` in `index`:
    ```python
    def index():
        return render_template('index.html', title="Pokemon Dataset", headings = data[0])
    ```
4. Restart your app to see your new fancy list!


## Data per row
1. Take the same approach to make a list of data for a particular Pokemon for the `get_pokemon` route.

2. It'd be nice to have the headings along with the data, which you kind of need to loop by index to achieve. Here is how you can do the typical `for i in range(len(my_list))` in Jinja:

```html
{%raw%}{%for i in range(my_list|length): %}
    <li>{{my_list[i]}}</li>
    {% endfor %}
{%endraw%}
```

## Submission
Submit your solutions for the previous exercises to the git repository to get an extra engagement credit.


## Applying to your project
Make a list with your team in the Google doc linked on Moodle that has:
* which templates you'll need
* what variables those templates will take as parameters
* who will be in charge of each of them

You should make sure to list out every single template that you'll need, which will likely include:
* A homepage
* An about page
* A page for each of your features that correspond to your current API calls (these can be simple and just give the basic information, like `get_pokemon`)
* A page or two for more advanced data visualization that brings multiple features together (can repeat the data from the simple pages)

Let me know when you have this list complete so that I can double check that you aren't forgetting something.

Note that you should not be worrying about style yet, that comes next class. 
However, if you really really really want to jump ahead (you just can't stand the look of the basic page), [here is a CSS primer](https://learn.shayhowe.com/html-css/building-your-first-web-page/#common-css-terms).

## Fun extra
By combining the route variables and Jinja placeholders, you can let the user display what they want on your page.
Try making a new template and route so that you can go to `your_url/greeting/your_name` and find a web page that greets whatever the user puts for `your_name`.