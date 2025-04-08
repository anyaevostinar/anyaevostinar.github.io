---
layout: page
title: Project Component 2 - Flask
permalink: /classes/257-s25/project-2-flask
---

## Overview

The goal of this component of your project is to create a basic Flask app to allow a user to interact with your data via a web browser.
Your Flask app should also include an expanded automated test suite that tests your Flask functions and has been updated for any refactoring that you did.

The learning objectives for this iteration of your project are to be able to 1) create a basic Flask app using variable routes, 2) further expand your automated test suite, and 3) continue to create code that follows the principles of good function design.

## Collaboration

You should work with your team on this portion of the project.
You are able to get help from outside sources, as specified in the syllabus, but everything that your team submits should be your own.

## Due Date

This component of the project is due Monday April 28th at 10pm on your team's repository.

## What to submit
### Individual
* [Sprint Feedback Form](https://docs.google.com/forms/d/e/1FAIpQLSc-BRKK_0TJzMYL_DTiJElwL216B8CRkHcchna5jzh3P-6QGg/viewform?usp=dialog)

### Team
On your team repository, you should have (at least) the following files:
- [ ] `cl.py` - probably remains unchanged
- [ ] `app.py` - your Flask app
- [ ] One or more files in `ProductionCode` to support both `cl.py` and `app.py`
- [ ] At least `test_cl.py` and `test_app.py` in `Tests`
- [ ] `README.md` - should be updated to include information for running the flask app
- [ ] `UserStories.md` - can be updated if things have changed

*Do not specify the port when running the app, it doesn't work the same on different operating systems and so can mess up the grading. I.e., when you run your app, it should be just `app.run()` without any arguments*

## Your Task

Your team should write a program that:
* Uses the [Flask](https://flask.palletsprojects.com/en/2.1.x/) framework to build a browser app
* Supports at least two independent features via [Flask routes](https://pythonbasics.org/flask-tutorial-routes/); each of these features should enable the user to get information from your dataset(s) via the web browser
* Has at least one route that uses at least one route parameter meaningfully
* Has a useful message when the user enters an incorrect URL
* Has an automated test suite with at least 90% coverage for both the core functions and the Flask-specific functions
* Follows the function design principles and has generally good style
* Has documentation through [docstrings](https://peps.python.org/pep-0257/) and in-line comments where appropriate
* Follows the [recommended Python style](https://peps.python.org/pep-0008/)
* Has the correct directory structure

You should largely be able to build from and reuse/refactor your existing code. Your core functionality should be in separate file(s) in your `ProductionCode` folder and your Flask app should be in the file `app.py` at the top level of your repository. You might need to adjust some of your functions to return strings if they had been returning lists (and adjust your tests in the process).

## Turning it in

Your team should submit this component of the project on your team repo with the tag `flask` by typing the following:

```
git tag -a flask -m "basic Flask app"
git push origin flask
```

If you forgot to tag your comment, you can [retroactively tag](https://docs.google.com/document/d/1gt8cAmhFV9YxFE5ml2ReiGyVvwoum1MH9L0wzttqdkA/edit?usp=sharing).

## Evaluation

The criteria for "Proficiency" and "Exemplary" are below.

### Proficiency
* Functionality:
  * Uses the Flask framework correctly
  * There is a useful 404 page
  * There are two independent features controlled by separate routes that allows the user to get information from the chosen dataset
  * One of the routes uses a route parameter that changes what is displayed
  * There is an automated test suite that has 50% coverage
  * The test suite passes
  * The command-line interface still works
  * The correct directory structure is used
* Design:
  * All style checks at at 5 or higher
  * The functions/methods are mostly written at a single layer of abstraction
  * Function names, return values, and parameters generally follow the principles of good naming
  * Function/method [docstrings](https://peps.python.org/pep-0257/) generally provide the required information
  * There isn't an excessive amount of repeated code

### Exemplary
* All the Proficiency criteria are met
* Functionality:
  * The test suite has 90% coverage
  * The test suite includes integration tests
  * The 404 page has clear instructions on how to use the website features
  * The features are interesting and enable the user to gain a large amount of information from the dataset
  * The features support the specified user stories
  * The route parameter(s) are highly effective in enabling the user to gain specific information from the dataset
* Design:
  * All style checks are at a 10
  * The functions/methods are all written at a single layer of abstraction
  * Function names, return values, and parameters all follow the principles of good design
  * Function/method [docstrings](https://peps.python.org/pep-0257/) all provide the required information
  * There is barely any duplicated code




