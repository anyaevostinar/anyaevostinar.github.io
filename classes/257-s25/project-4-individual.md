---
layout: page
title: Individual Deliverable 4 - Back-end
permalink: /classes/257-f23/project-4-ind
---

## Overview

This is the individual component of the [back-end component](project-4-backend) of your team's project.
For this component, you need to create a database with at least one table with a portion of your team's data and use `psycopg2` to access some of the data.
Much of this code won't end up in your team's repository because it will be duplicate. 
Instead, the goal is to get you to practice and start thinking about the back-end individually.

## Collaboration

You should work individually on this component.
You shouldn't coordinate with your team, since the goal is that you get practice individually, and so it's fine if there is some duplication.
You can get conceptual help from your team and others, however what you submit must be all your own work.

## Due Date

The individual deliverable for this iteration is due **Friday Oct 27th** at 10pm on the ID4 git repository.

## Your Task

I recommend that you work on this component on the `stearns` server since it has all the necessary things installed already.

You should:
* Copy *some* of your team's data into your ID4 repository in the `Data` folder (should only be a couple of columns max)
* Edit the `Data/createtable.sql` file so that it creates a table with some of your team's data 
* Add the necessary `\copy` command to your `README.md` file
    (For example `\copy earthquakes FROM 'Data/earthquakeData.csv' DELIMITER ',' CSV`)
* Expand on the `datasource.py` file by adding a method that uses the `psycopg2` module to connect to the database, execute a query, and return the result (note that I've provided the `connect` method already, so you should use the instance variable `self.connection`)
* Edit the `app.py` file so that it calls your `DataSource` method and prints the result

The grader will grade your assignment by:
* Pulling down your submission for this deliverable
* Use `psql -f Data/createtable.sql` to recreate your table in their database
* Use the copy command that you specify to import your data into the table
* Create the `psqlConfig.py` file with their information and the database name `webapp`
* Run your `app.py` file
* Look through your code and database structure


## Turning it in

You should submit the files with your individual database to your ID4 repository.


## Evaluation

The criteria for "Demonstrates Proficiency" and "Demonstrates Mastery" are below.


### Proficiency
* Files:
  * Table is created with `createtable.sql`
  * `README` specifies the correct copy command
  * Code to be run is named `app.py`
* Functionality:
  * Executes the expected query correctly.
  * Data types match the types from the original dataset and/or are appropriate for the modified data from the dataset
* Design:
  * Code contains appropriate names and mostly appropriate comments. 
  * Sufficient design of individual methods, with most best practices (parameters, return values, responsibilities) followed.
  * Column names somewhat signify the data they contain
  * Docstrings exist for all methods
  

### Mastery
* All the Proficiency criteria are met
* Functionality:
  * Data is well-curated from the original dataset, with no extraneous data that isn't used by the query
  * Data types are well-chosen for the dataset
  * Data tables (if used) contain little to no overlap (higher degree of normalization)
* Design:
   * Code is strongly self-documenting. 
   * Code contains excellent and appropriate comments. 
   * Design of individual methods is strong (parameters, return values, responsibilities).  
   * There is a strong connection between the method signatures and the high-level actions of the website audience (which in turn strongly match the queries).
   * Column names strongly signify the data they contain
