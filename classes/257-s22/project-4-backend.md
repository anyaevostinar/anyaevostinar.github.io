---
layout: page
title: Project Version 4 - Backend
permalink: /classes/257-s22/project-4-backend
---

## Overview

The goal of this iteration of your project is to add the database back-end component to your Flask app.

The learning objectives for this iteration of your project are to be able to 1) create a well-structured database, 2) connect that database appropriately to your Flask app controller, and 3) continue to create code that follows the principles of good design.

## Collaboration

You should work with your team on this portion of the project.
You are able to get help from outside sources, as specified in the syllabus, but everything that your team submits should be your own.

## Due Date

This iteration of the project is due Monday May 18th at 10pm on GitHub.

## Your Task

Your team should create a Postgres database back-end for your Flask app using the [psycopg2](https://www.psycopg.org/docs/index.html) module. Specifically, you should:
* Put your data into a well-structured database named `webapp` (most likely with multiple tables)
* Use psycopg2 to connect your existing functionality to the database and update your code to make appropriate queries on the database
* Use the `pg_dump` command to save your database into a `data.sql` file for the grader to recreate your database
    ```
    pg_dump --no-owner --no-privileges -U YOURUSERNAME YOURDATABASE > data.sql
    ```
* Update your test suite if necessary based on the refactoring that you do on your code

The grader will assess your project with the following workflow:
* Pull down your repository from the appropriate tag
* Use `psql -U their_username webapp < data.sql` to recreate your database
* Create the `config.py` file with their information and the database name `webapp`
* Run your Flask app based on what you specify in your README
* Run your test suite
* Look at your code

You should be building off of your existing code and focusing mostly on the database component, though you may find that you need to update some of your core functionality to work with your data in the format that you want now. Remember to then adjust your tests too!

## Turning it in

Your team should submit this iteration of the project on your team repo with the tag `database` by typing the following:

```
git tag -a database -m "back-end Flask app"
git push origin database
```

## Evaluation

The criteria for "Meets Expectations" and "Exceeds Expectations" are below.

### Meets Expectations Criteria
* Files:
  * Database is contained in `data.sql`
  * Code is written to work for the database to be named `webapp`
  * Flask app file specified in the README
* Functionality:
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
  

### Exceeds Expectations Criteria
* All the Meets Expectations criteria are met
* Functionality:
  * Executes robustly, without error or with very rare errors. All queries either succeed or fail gracefully.
  * Data is well-curated from the original dataset, with no extraneous data
  * Data types are well-chosen for the dataset
  * data tables contain little to no overlap (higher degree of normalization)
* Design:
   * Strong separation of responsibilities between classes, and between methods within classes. 
   * Tight cohesion in each class, and loose coupling between classes. 
   * Code is strongly self-documenting. 
   * Code contains excellent and appropriate comments. 
   * Design of individual methods is strong (parameters, return values, responsibilities). 
   * Code is appropriately tagged. 
   * There is a strong connection between the method signatures and the high-level actions of the website audience (which in turn strongly match the queries).
   * Column names strongly signify the data they contain
