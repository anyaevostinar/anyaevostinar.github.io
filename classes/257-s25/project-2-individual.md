---
layout: page
title: Individual Deliverable 2 - Flask
permalink: /classes/257-s25/project-2-ind
---

## Overview

This is the individual portion of the [Flask component](project-2-flask) of your team's project.
For this component, you need to write a basic Flask app with one potential route.
Much of this code won't end up in your team's repository because it will be duplicate. 
Instead, the goal is to get you to practice and start thinking about the Flask app individually.

## Collaboration

You should work individually on this component.
You shouldn't coordinate with your team, since the goal is that you get practice individually, and so it's fine if there is some duplication.
You can get conceptual help from your team and others, however what you submit must be all your own work.

## Due Date

The individual deliverable for this iteration is due **April 25th** at 10pm on the associated repository (link on Moodle).

## What to Submit

- [ ] Your flask app `app.py` in the top-level of your repository
- [ ] All necessary production code files in `ProductionCode`
- [ ] (For exemplary) Your tests in the `Tests` folder

*Do not specify the port when running the app, it doesn't work the same on different operating systems and so can mess up the grading. I.e., when you run your app, it should be just `app.run()` without any arguments*

## Your Task
(Remember that you will want to be in your [virtual environment](venv-guide) when working on this.)

You should write a basic Flask app with at least one route based on your team's core functionality. Specifically, you should:

1. Copy over the file(s) from your team repo that contain necessary helper functions that interact with the data and put those files into the `ProductionCode` subdirectory.
  * (P.S: The more efficient way to copy files from a repo would be a [git fork](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/fork-a-repo) of your team repo, but alas, GitHub classroom doesn’t keep track of forks & therefore, neither I nor the grader will have access.🙁)
  * You are allowed to refactor the helper functions from your team repo to work for your purposes
  * You should put in "dummy data" to make the core functions work without your full dataset. This can be by hard-coding the data in your ProductionCode files or making a data folder with the dummy data.
2. Make a Flask app in `app.py` with at least one route that uses the core functionality in `ProductionCode`
3. The home page of your app should provide instructions for what URL to go to to see the data you choose.
4. To get 'exemplary' that route should use a route parameter and you should have a couple of tests in `Tests` for your Flask-specific functions.

## Turning it in

You should submit the file with your individual Flask app to the ID2 repository through Git Classroom (link on Moodle).


## Evaluation

The criteria for "Exemplary" and "Proficiency" are below.

### Proficiency
* Functionality:
  * The Flask app is using (possibly refactored) code from the team's project
  * There is a homepage with instructions
  * There is at least one route that uses the team's code to display data from the dataset
* Design:
  * Flask app code is reasonably easy to read and understand
  * The Flask app code has appropriate [docstrings](https://peps.python.org/pep-0257/) 
  * There isn't an excessive amount of repeated code
  * Style checks are all 5 or higher

### Exemplary
* All the Proficiency criteria are met
* Functionality:
  * One route uses parameter(s) to recreate one feature from the team’s command-line interface
  * The test suite passes
  * The test suite has at least 90% coverage
* Design:
  * The Flask app code is very clear, potentially using helper functions to ensure that Flask-specific functions are at a single layer of abstraction
  * There is no unnecessary duplicated code (e.g. using helper functions, loops, etc)
  * The docstrings are thorough and clear
  * Style checks are all 10