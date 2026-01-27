---
layout: page
title: Individual Deliverable 3 - Database
permalink: /classes/257-w26/project-3-ind
---

## Overview

This is the individual component of the [back-end component](project-3-backend) of your team's project.
For this component, you need to create a database with at least one table with a portion of your team's data and use `records` to access some of the data.
Much of this code won't end up in your team's repository because it will be duplicate. 
Instead, the goal is to get you to practice and start thinking about the back-end individually.

## Collaboration

You should work individually on this component.
You shouldn't coordinate with your team, since the goal is that you get practice individually, and so it's fine if there is some duplication. You can get conceptual help from your team and others, however what you submit must be all your own work.
**What you submit for this component, especially for revisions, cannot duplicate what another team member had previously submitted for the team deliverable. Duplicating another team member's code will be considered academic dishonesty.** You can certainly use your code from this component for the team deliverable though.


## Due Date

The individual deliverable for this iteration is due **Friday February 6th** at 10pm on the ID3 git repository.

## Your Task

You should work on this component on the `stearns` server since it has all the necessary things installed already. You should connect to `stearns` through [`fern`](https://fern.mathcs.carleton.edu/jupyter/) by logging in to `fern` with your Carleton log in information and then ssh'ing to `stearns`. See the Database lab for more details.

You should:
* Copy *some* of your team's data into your ID3 repository in the `Data` folder (should only be a couple of columns max)
* Edit the `Data/createtable.sql` file so that it creates a table with some of your team's data 
* Add the necessary `\copy` command to your `README.md` file
    (For example `\copy earthquakes FROM 'Data/earthquakeData.csv' DELIMITER ',' CSV`)
* Expand on the `datasource.py` file by adding a method that uses the `records` module to execute a query and return the result.
* Edit the `app.py` file so that it calls your `DataSource` method and prints the result.
* Note that somewhere along the way, you will need to convert the `records` result to a more useful format, such as csv.

The grader will grade your assignment by:
* Pulling down your submission for this deliverable
* Use `psql -f Data/createtable.sql` to recreate your table in their database
* Use the copy command that you specify to import your data into the table
* Create the `psql_config.py` file with their information and the database name `webapp`
* Run your `app.py` file
* Look through your code and database structure


## Turning it in

You should submit the files with your individual database to your ID3 repository.


## Evaluation

The criteria for "Core" and "Advanced" are below.


### Core
* Functionality:
  * Table is created with `createtable.sql`
  * `README` specifies the correct copy command with a **relative file path**
  * Code to be run is named `app.py`
  * Executes the expected query correctly
  * Data types match the types from the original dataset and/or are appropriate for the modified data from the dataset
* Design:
  * All style checks at 5 or higher
  * Sufficient design of individual methods, with most best practices (parameters, return values, responsibilities) followed.
  * Column names somewhat signify the data they contain
  * Docstrings exist for all methods
  

### Advanced
* All the Core criteria are met
* Functionality:
  * Data is well-curated from the original dataset, with no extraneous data that isn't used by the query
  * Data types are well-chosen for the dataset
* Design:
  * All style checks are at a 10
  * Function/method docstrings all provide the required information (i.e. functionality, arguments if applicable)
  * Function/method signatures match the SQL queries (i.e. `get_events_by_type()` correspond to a SQL query that selects all events of that type)
  * Column names strongly signify the data they contain (e.g. clear names, no obscure acronyms)
