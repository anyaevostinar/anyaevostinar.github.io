---
layout: page
title: Project Version 4 - Individual
permalink: /classes/257-s22/project-4-ind
---

## Overview

This is the individual component of the [back-end component](project-4-backend) of your team's project.
For this component, you need to create a database with at least one table with a portion of your team's data and use psycopg2 to access some of the data.
Much of this code won't end up in your team's repository because it will be duplicate. 
Instead, the goal is to get you to practice and start thinking about the back-end individually.

## Collaboration

You should work individually on this component.
You shouldn't coordinate with your team, since the goal is that you get practice individually, and so it's fine if there is some duplication.
You can get conceptual help from your team and others, however what you submit must be all your own work.

## Due Date

The individual deliverable for this iteration is due **Friday May 13th** at 10pm on your individual GitHub.

## Your Task

I recommend that you work on this component on the `perlman` server since it has all the necessary things installed already.

You should:
* Create a `createtable.sql` file that will create a table with some (or all) of your team's data 
* Write a simple Python file named `datasource.py` that uses the `psycopg2` module to connect to the database, execute a query, and print the result

The grader will grade your assignment by:
* Pulling down your submission for this deliverable that should be tagged 'database'
* Use `psql -f createtable.sql` to recreate your table in their database
* Create the `config.py` file with their information and the database name `webapp`
* Run your `datasource.py` file
* Look through your code and database structure


## Turning it in

You should submit the files with your individual database to your individual deliverables repository with the tag `database` by typing the following:

```
git tag -a database -m "basic database"
git push origin database
```


## Evaluation

The criteria for "Meets Expectations" and "Exceeds Expectations" are below.

* Files:
  * Table is created with `createtable.sql`
  * Code is written to work for the database to be named `webapp`
  * Code to be run is named `datasource.py`
* Functionality:
  * Executes the expected query correctly.
  * Data types match the types from the original dataset and/or are appropriate for the modified data from the dataset
* Design:
  * Code contains appropriate names and mostly appropriate comments. 
  * Sufficient design of individual methods, with most best practices (parameters, return values, responsibilities) followed.
  * Column names somewhat signify the data they contain
  * Docstrings exist for public methods
  

### Exceeds Expectations Criteria
* All the Meets Expectations criteria are met
* Functionality:
  * Data is well-curated from the original dataset, with no extraneous data
  * Data types are well-chosen for the dataset
  * Data tables (if used) contain little to no overlap (higher degree of normalization)
* Design:
   * Code is strongly self-documenting. 
   * Code contains excellent and appropriate comments. 
   * Design of individual methods is strong (parameters, return values, responsibilities). 
   * Code is appropriately tagged. 
   * There is a strong connection between the method signatures and the high-level actions of the website audience (which in turn strongly match the queries).
   * Column names strongly signify the data they contain
