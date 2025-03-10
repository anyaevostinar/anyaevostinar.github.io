---
layout: page
title: Project Component 4 - Backend
permalink: /classes/257-f23/project-4-backend
---

## Overview

The goal of this component of your project is to add the database back-end component to your Flask app.

The learning objectives for this component of your project are to be able to 1) create a well-structured database, 2) connect that database appropriately to your Flask app controller, and 3) continue to create code that follows the principles of good design.

## Collaboration

You should work with your team on this portion of the project.
You are able to get help from outside sources, as specified in the syllabus, but everything that your team submits should be your own.

## Due Date

This component of the project is due Wednesday November 1st at 10pm on GitHub.

## Your Task

Your team should create a Postgres database back-end for your Flask app using the [psycopg2](https://www.psycopg.org/docs/index.html) module. Specifically, you should:
* Put your data into a well-structured database named based on your team name on `stearns` (as specified on Moodle) (most likely with multiple tables)
* Use `psycopg2` to connect your existing functionality to the database and update your code to make appropriate queries on the database
* Update your test suite if necessary based on the refactoring that you do on your code

The grader will assess your project with the following workflow:
* Connect to `stearns`
* Pull down your repository from the appropriate tag
* Create the `psqlConfig.py` file with your team database name and information
* Run your Flask app `app.py`
* Run your test suite
* Look at your code

You should be building off of your existing code and focusing mostly on the database component, though you may find that you need to update some of your core functionality to work with your data in the format that you want now. Remember to then adjust your tests too!

## Turning it in

Your team should submit this component of the project on your team repo with the tag `database` by typing the following:

```
git tag -a database -m "back-end Flask app"
git push origin database
```

## Evaluation

The criteria for "Demonstrates Proficiency" and "Demonstrates Mastery" are below.

### Proficiency
* Files:
  * Database is in correct team database on `stearns`
  * Code is written to work for the database to be named as specified on Moodle
  * Flask app file named `app.py`
* Functionality:
  * Previous subcomponents still work with the new database (i.e. command line works with database too)
  * Executes the expected queries correctly most of the time. Some strange queries may fail to execute completely correctly.
  * The automated test suite passes (no additional tests are required)
  * Data types match the types from the original dataset and/or are appropriate for the modified data from the dataset
  * Some separation of data into tables where applicable
* Design:
  * Good separation of responsibilities. Some minor tweaks to class design could improve the code (i.e., tighter cohesion and/or looser coupling). 
  * Model-view-controller paradigm followed.
  * Code contains appropriate names and mostly appropriate comments. 
  * Sufficient design of individual methods, with most best practices (parameters, return values, responsibilities) followed.
  * Method signatures adequately match most high-level queries
  * Column names somewhat signify the data they contain
  * Docstrings for each method
  

### Mastery Criteria
* All the Proficiency criteria are met
* Functionality:
  * Executes robustly, without error or with very rare errors. All queries either succeed or fail gracefully.
  * Data is well-curated from the original dataset, with no extraneous data
  * Data types are well-chosen for the dataset
  * Data tables contain little to no overlap (higher degree of normalization)
* Design:
   * Strong separation of responsibilities between classes, and between methods within classes. 
   * Tight cohesion in each class, and loose coupling between classes. 
   * Code is strongly self-documenting. 
   * Code contains excellent and appropriate comments. 
   * Design of individual methods is strong (parameters, return values, responsibilities). 
   * Code is appropriately tagged. 
   * There is a strong connection between the method signatures and the high-level actions of the website audience (which in turn strongly match the queries).
   * Column names strongly signify the data they contain
   * Docstrings are clear and consistent for each method
