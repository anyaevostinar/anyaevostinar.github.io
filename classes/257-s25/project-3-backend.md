---
layout: page
title: Project Component 3 - Database Backend
permalink: /classes/257-s25/project-3-backend
---

## Overview

The goal of this component of your project is to add the database back-end component to your Flask app.

The learning objectives for this component of your project are to be able to 1) create a well-structured database, 2) connect that database appropriately to your Flask app controller, and 3) continue to create code that follows the principles of good design.

## Collaboration

You should work with your team on this portion of the project.
You are able to get help from outside sources, as specified in the syllabus, but everything that your team submits should be your own.

## Due Date

This component of the project is due Wednesday May 7th at 10pm on GitHub.

## What to submit
### Individual
* [Sprint Feedback Form](https://docs.google.com/forms/d/e/1FAIpQLSc-BRKK_0TJzMYL_DTiJElwL216B8CRkHcchna5jzh3P-6QGg/viewform?usp=dialog)

### Team
* Dataset in database on `stearns`
* `ProductionCode` updated to work with database
* `cl.py`, `app.py`, `Tests` still functional and updated if necessary

## Your Task

Your team should create a Postgres database back-end for your Flask app using the [psycopg2](https://www.psycopg.org/docs/index.html) module. Specifically, you should:
* Put your data into a well-structured database named based on your team name on `stearns` (as specified on Moodle)
* Use `psycopg2` to connect your existing functionality to the database and update your code to make appropriate queries on the database
* Update your test suite if necessary based on the refactoring that you do on your code

The grader will assess your project with the following workflow:
* Connect to `stearns`
* Pull down your repository from the appropriate tag
* Create the `psql_config.py` file with your team database name and information
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

The criteria for "Proficiency" and "Exemplary" are below.

### Proficiency
* Files:
  * Database is in your team's database on `stearns`
  * Code is written to work for your team's database name as specified on Moodle
  * Flask app file named `app.py`
* Functionality:
  * Command line interface works with the new database
  * Flask app interface works with the new database
  * Executes queries for standard cases correctly
  * The automated test suite passes (no additional tests are required) and has 50% coverage
  * SQL data types match the types from the original dataset and/or are appropriate for the modified data from the dataset
* Design:
  * Good separation of responsibilities. Some minor tweaks to class design could improve the code (i.e., tighter cohesion and/or looser coupling). 
  * Model-view-controller paradigm followed.
  * Functions/methods follow the principles of good design (e.g. descriptive names, only necessary arguments)
  * Function/method signatures match the SQL queries (i.e. get_events_by_type() correspond to a SQL query that selects all events of that type)
  * Column names strongly signify the data they contain (e.g. clear names, no obscure acronyms)
  * Docstrings for each method
  * Style checks all at 5 or higher
  

### Exemplary
* All the Proficiency criteria are met
* The commit to evaluate on the team repo is tagged with `database` (See instructions in [How to Submit](https://docs.google.com/document/d/1WJfFKe-xE7ytKzmMba3vMOORZe6_m-0v854SnAb6mWk/edit?tab=t.0#heading=h.h8jfjcdyduzb))
* Functionality:
  * Failing queries have helpful error messages
  * Data is well-curated from the original dataset, with no extraneous data
    * By "extraneous data", we mean data that won’t be used for the final project website.
    * If you have columns that aren’t being used in this deliverable but have plans to be used in the front-end deliverable, let us know in `README.md`
  * Data types are well-chosen for the dataset
  * The test coverage is at 90% or higher
* Design:
   * Strong separation of responsibilities between classes, and between methods within classes. 
   * Tight cohesion in each class, and loose coupling between classes. 
   * Design of individual methods is strong (parameters, return values, responsibilities). 
   * There is a strong connection between the method signatures and the high-level actions of the website audience (which in turn strongly match the queries).
   * Only necessary data is pulled from the database
    * This means that the filtering should be done with SQL query logic, not Python
   * Column names strongly signify the data they contain
   * Docstrings are clear and consistent for each method
   * Style checks are all at 10


## Addendums
You weren't penalized for this on the initial submissions, but revisions need to hold to it:
* You need to remove your old code that references your data files (in general, you should always remove "dead code" that isn't used anymore)

## Q&A

* How do I get the names of the columns?

You can get the names of the columns with this command:
```sql
select column_name from INFORMATION_SCHEMA.COLUMNS where table_name = 'YOUR_TABLE_NAME_HERE';
```

