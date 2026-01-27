---
layout: page
title: Records Prep
permalink: /classes/257-w26/records-prep
---

## Overview
We'll be using a specific Python module, `records` to interact with your databases. It is a very light-weight module, so there isn't a lot of reading today, the goal is just to get an idea for its syntax.

## Basic Learning Objectives

Before class, you should be able to:
* Explain the basic `records` workflow
* Explain how your Python program will access your database

## Advanced Learning Objectives
After class, you should be able to:
* Use `records` to connect your Flask app and database


## Readings
To achieve the basic learning objectives, you should read the following:
* [`records` README](https://github.com/kennethreitz/records/blob/master/README.md)

For your reference, this is what the Database connection string will look like for you:
```python
    import psql_config as config #this will be a file with your database information
    connect_str = f"postgresql://{config.user}:{config.password}@localhost:5432/{config.database}"
    db = records.Database(connect_str)
```




## Checks
Submit your answer to Moodle
* Assuming the connection above has been made, write the snippet of code needed to send the query `SELECT * FROM dragons WHERE age>6 ORDER BY age DESC;` and return the result in `csv` format.