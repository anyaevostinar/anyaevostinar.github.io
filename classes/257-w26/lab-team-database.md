---
layout: page
title: Team Database Lab
permalink: /classes/257-w26/team-database-lab
---

## Objectives:
* Set up your team's database

## Deciding on Structure
The first thing you need to do as a team is decide how you will actually translate your dataset into tables in your database. You'll want to keep things simple and as close to your original structure as possible to make it easier to adapt your current functionality to work with the database. However, you might want to make some changes to structure to improve database normalization based on what you learned from the reading. You can always go and make changes after a first version too.

**DO THIS:** 
* As a team, decide on what tables you will have in the database and what the columns of those tables will be (it's fine to just have tables matching your existing files for now). Decide on what the `createtable.sql`  script should contain as a team.
* One of you should then create the `createtable.sql` script and push it to the team repository

## On Stearns

**ONE OF YOU** should:

* connect to stearns (through [fern](https://fern.mathcs.carleton.edu/jupyter/)), 
* clone your TEAM repository, 
* change into that directory
* execute the following:
```bash
psql -U YOURTEAMDATABASENAME -h localhost -d YOURTEAMDATABASENAME < createtable.sql
```

**ALL OF YOU** should then:

* connect to stearns (if not already)
* execute the following to get into the psql interpreter in your team database:
```bash
psql -U YOURTEAMDATABASENAME -h localhost -d YOURTEAMDATABASENAME
```
* Enter your team database password if/when prompted
* Type `\dt` to see if the tables are there

## Preparing/cleaning Data
Just like with the individual setup, as a team you need to prepare your data so that it can be loaded into your tables. Now that you've decided on how you are going to structure your data into tables, **ONE OF** you should (you can work together, but only one person should actually make the changes and setup the database on stearns):

* Locally, make sure your data is in the structure that you want it to be in your database (i.e. if you are going to have multiple tables, make separate files that have the information for those tables, have the columns set up how you want them, etc)
* Remove any extraneous data that you aren't going to use in your team project
* Save as a csv
* Add, commit, and push 
* Get back onto `stearns`
* enter your TEAM database password if/when prompted
* execute the following to get into the psql interpreter
```bash
psql -U YOURTEAMDATABASENAME -h localhost -d YOURTEAMDATABASENAME
```
* execute the copy command(s) to load the data into the table(s):
```sql
\copy [your table name] FROM '[data file name]' CSV HEADER
```

**ALL OF YOU** should then:

* connect to stearns (if not already)
* execute the following to get into the psql interpreter:
```bash
psql -U YOURTEAMDATABASENAME -h localhost -d YOURTEAMDATABASENAME
```
* Enter your team database password if/when prompted
* Try out some queries to make sure that you can access the database

You are now all set up to connect your existing Flask app to your database using records! Get started on the changes you'll need to make for team deliverable 3!

**NOTE:**
You'll need to switch to running your Flask app with the following command to be able to run on `stearns` using one of the ports assigned to each member of your team:
```python
app.run(host='0.0.0.0',port=YOUR_NUMBER)
```

