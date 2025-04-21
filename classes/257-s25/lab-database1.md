---
layout: page
title: SQL and Database Lab
permalink: /classes/257-s25/database-lab
---

## Objectives
* Become familiar with SQL statements and syntax.
* Become familiar with the postgresql database and with `psql` commands.
* Learn how to set up and test your own database tables on the web server.
* Set up your database for your [individual back-end deliverable](project-3-ind)


## Setting up your database
First, we'll make sure that you can connect to the remote server.

### Step 1: SSH Login
VSCode has a handy extension for making it easy to connect to a remote server through VSCode, and you hopefully already have [Remote-SSH installed](https://code.visualstudio.com/docs/remote/ssh). 

Therefore, you should open the Command Palette (View->Command Palette...) and then select `Remote-SSH: Connect to Host...`

You can also click this button in the lower-left corner:

![Button with > < icons](/classes/257-s25/RemoteButton.png)

If it asks you what system to use, select Linux (it will reject your request if you select Windows!). 

You should then enter:

`yourCarletonUserName@stearns.mathcs.carleton.edu`
And your **Carleton** password if prompted.

If it asks you about authorizes the fingerprint, confirm.

### Step 2: Getting setup
It might take a minute for the login to complete. Once you are on stearns, you can 'ls' to get an idea of what is already there (there might be a lot if you've worked with other servers on campus since they share a file structure). I recommend you make a folder to keep all your work in for today called 'webProject'.

Before we go any further, we need to get our code and data into our working directory on stearns. Once you've ssh'ed in and you've navigated to your working directory, clone your ID3 repository by grabbing the URL from GitHub and typing the following into your connected Terminal: 

```bash
git clone [URL of repository]
```

### Step 3: Creating a table
Now we're going to get ready to import your data into the database! In this part of the lab, we'll be interacting directly with the database via psql. This [cheatsheet](https://www.postgresonline.com/downloads/special_feature/postgresql83_psql_cheatsheet.pdf) contains all of the psql commands. 

The name of your database is the same as your username. The password you can find in the feedback on the 'assignment' Individual Database information, along with the port numbers that you'll need later.

First, we need to write a series of SQL statements that will actually create a table. 

1. Make a script called `createtable.sql` for this purpose and put in the following:
```sql
DROP TABLE IF EXISTS test;
CREATE TABLE test (
  col1 text,
  col2 int
);
```

Here's what this script does

* Make sure the table doesn't already exist in the database. If it does, remove it from the database. (This is what the first line in the script does.)
* Create the table in the database and give it a name. (This is what the second line does.)
* Tell the database which data to import, what its name in the database should be, and the type of data to import. (Refer to the [SQL tutorial](http://www.w3schools.com/sql/default.asp) for information on [available data types](http://www.w3schools.com/sql/sql_datatypes_general.asp).)


2. Modify this script so that it reflects your own data. 

3. Run the command:
```bash
psql -f createtable.sql
```
You will need to enter your database password if prompted. (Sometimes you aren't prompted for it, which is fine, and I have yet to figure out when you will or won't be, so good to be prepared...)

4. Run `psql` to enter the "interpreter".

5. Type `\dt` at the prompt. Do you see your table in the database? If not, raise your hand for help.

## Preparing/cleaning the data
Now we're going to get your data ready. Some preparation of your data files locally will make it easier for you to load your data into a database on the server. You'll be dealing with both an individual deliverable with a database and a team deliverable with a database, but today we are going to focus on just the individual deliverable.

For the individual deliverable, you will use some (or all) of your team's data to get practice creating and working with a database. It's very important that the data you use for your individual deliverable is **less than 20MB!** (Otherwise the server will run out of room!)

### Step 1: Make sure it's CSV
Most of your datasets are already in CSV format, but if the portion that you want to use isn't in CSV, you can most likely open it in Microsoft Excel (or Google Sheets, or other Excel-like program) and then save it to 'csv' format to convert it.

### Step 2: Thinking about structure
Next, while you have the data open in a spreadsheet or text editor, think about how you want to structure your database table. Which columns do you want to import? What data types would you like to store this data as? Will you have one table or multiple tables? 

**Modify your data file** so that it only contains the columns that you want to import into your database. (You can do this in Excel/Google Sheets/a text editor, or if you're really feeling ambitious you can write a program in your favorite language to modify the data file.)

### Step 3: Removing column headers
You will need to remove the headers for columns from the dataset that you import to your database, so do that now.

### Step 4: Push to individual repo
Once you are happy with the size and structure of your data (make sure it is less than 20MB!), add, commit, and push it to your ID3 repository.

Verify on GitHub that it is there since that's how we'll be getting it onto the server.


## Working with your data
Now you're ready to import your data onto the server. 

1. Connect back to stearns if you are no longer connected and navigate back to your ID3 repository.

2. Get back into the psql interpreter with `psql`.

3. At the prompt, type the following exactly as you see here, all on one line (replacing the values in [ ] with the correct names, and getting rid of the []):
```sql
\copy [your table name] FROM '[data file name]' DELIMITER ',' CSV 
```

For example, to import some dragon data into the dragon table, I would type in the following:
```sql 
\copy dragons FROM 'dragonData.csv' DELIMITER ',' CSV
```

(Note that unlike SQL queries, \copy does not require a semicolon at the end of the statement.)

4. You will need to specify your copy command in the README for your individual deliverable, so you might as well add it right now

5. Let's test to see if it worked. Type a simple SQL query statement at the prompt. Did you get the expected data back? If you were using the dragon data, you could do something like:
```sql
SELECT * FROM dragons WHERE age>6 ORDER BY age DESC;
```

## Testing your database
Now is a good time to try out some of the queries that you intend to allow users to do on your data. We'll eventually be using a Python library to script our SQL queries, but for now, it's useful to learn how to construct SQL queries directly, in the psql interpreter

1. Identify a simple query that your users might want to do on your data, for example one of your core functions from your team project, or the data route that you chose for your flask deliverable.
2. Can it be boiled down to a single SQL statement? If not, break the query down into simpler parts.
3. Construct the SQL statement (or part of it, if you had to break your original query into smaller parts).
4. Run the query and see what results you get back.
5. If you didn't get the expected results, or you got an error, fix the query and try again.
6. Repeat with other potential queries. Make your queries more complex as you gain confidence.

## Next steps
On Friday, you'll be setting up your team's database together. In preparation for that, you all should coordinate on cleaning and preparing your data. It would be good to start figuring out what queries can recreate your Python methods that grab data from your dataset. If you want to get ahead on connecting a Flask app to a database, feel free to start looking at [Wednesday's lab](psycopg2).


**Acknowledgements: This lab was based off one made by Prof Amy Csizmar Dalal.**