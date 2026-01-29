---
layout: page
title: Databases Intro Prep
permalink: /classes/257-w26/intro-database-prep
---

## Overview
It's finally time to start thinking about organizing your data better than just a giant list or dictionary!
Today we'll be getting started with putting your data into a database and using a model to access it.

## Basic Learning Objectives

Before class, you should be able to:
* Identify basic SQL commands
* Identify how to create a database table using postgres

## Advanced Learning Objectives
After class, you should be able to:
* Create a postgres database and load data into it
* Execute basic SQL commands on your database 


## Readings
To achieve the basic learning objectives, you should read the following:
* The following sections of the SQLBolt tutorial:
    * [Intro to SQL](https://sqlbolt.com/lesson/introduction)
    * [Lesson 1: SELECT queries 101](https://sqlbolt.com/lesson/select_queries_introduction)
    * [Lesson 2: Queries with constraints](https://sqlbolt.com/lesson/select_queries_with_constraints)
    * [Lesson 3: Queries with constraints part 2](https://sqlbolt.com/lesson/select_queries_with_constraints_pt_2)
    * [Lesson 4: Filtering and Sorting](https://sqlbolt.com/lesson/filtering_sorting_query_results)
    * [Lesson 16: Creating tables](https://sqlbolt.com/lesson/creating_tables)
    * [SQL Create Table](http://www.w3schools.com/sql/sql_create_table.asp), note that Postgres has some small differences, so here is the [Postgres Data Types](https://www.postgresql.org/docs/current/datatype.html) for future reference
* Other sections of the tutorial may be useful reference depending on what you want to do for your project




## Checks
Submit your answer to the following on Moodle:
* What does the following command (likely) do? 
    ```sql
    SELECT * FROM dragons WHERE age>6 ORDER BY age DESC;
    ```
* You have many exisiting functions that access your data in your team project. Identify one that you can turn into a SQL query. What is the function currently doing (at a high level) and what would the query be?

You should also be able to answer the [relevant exercises on W3Schools](https://www.w3schools.com/sql/exercise.asp)