---
layout: page
title: SQL and Database Lab
permalink: /classes/257-w26/database-lab
---

## Objectives
* Become familiar with SQL statements and syntax.
* Become familiar with the postgresql database and with `psql` commands.
* Learn how to set up and test your own database tables on the web server.
* Set up your database for your [individual back-end deliverable](project-3-ind).

## Contents
* [Working with `stearns`](#working-with-stearns-server)
* [Working in your database](#working-in-your-database)
* [Larger dataset](#larger-dataset)
* [Multiple tables](#multiple-tables)
* [Starting on ID3](#starting-on-id3)


## Working with `stearns` server
First, we'll make sure that you can connect to the remote server.

You will ultimately be working on the `stearns` server, but to connect to `stearns`, you need to go through a gateway server called `fern` via your web browser. (If you are used to using VSCode to connect to servers, sorry, you can't anymore because VSCode ultimately crashes the server due to a bug.)

### Step 1: Connect to `fern`

(If you get stuck, there are screenshots in [this guide](https://stolafcarleton.teamdynamix.com/TDClient/3356/Portal/KB/ArticleDet?ID=168271).)

**Go** to [https://fern.mathcs.carleton.edu/jupyter/hub/login](https://fern.mathcs.carleton.edu/jupyter/hub/login) and log in with your Carleton credentials

`fern` shares a filesystem with all the other servers and so you'll possibly see things from previous classes and anything you do on `fern` will also show up on `stearns`.


### Step 2: Set up your working space on the file system

* **Open a `Terminal`** by clicking the icon with a $ sign and a black box.

* **Set up a long-term working directory named cs257:** In that terminal, create a folder named `cs257`, where you will do your work for the term:

    ```bash
    mkdir cs257
    ```

    If you type the command `ls` in the terminal after that (and then hit enter/return), you’ll see the new folder listed. You can also look at the file explorer, and the folder should show up there, too.

### Step 3: Log in to `stearns`

In the Terminal, type (change to your Carleton username)
```bash
ssh YOUR_USER_NAME@stearns.mathcs.carleton.edu
```

and then your **Carleton** password. This is where you will be running your code going forward.

### Step 4: Getting set up
Accept the Database Lab Git Classroom assignment through Moodle and clone the starter repository onto `stearns` as you usually do. You will need to **enter the PAT that you made at the start of class for your password**. 

```bash
git clone [URL of repository]
```

In this starter repository I've included the `Pokemon.csv` dataset along with a smaller section of it (`Pokemon_small.csv`) for you to work with initially. It is a good idea to always work with a subset of your data at first as you are figuring things out!

**Make sure to `cd` into your git repository at this point.**

## Working in your database
You're now ready to create the first table in your database. In this class you'll have both an individual database and a team database. Today, you'll be creating a practice table about Pokemon in your individual database. 

<span style="color:blue">The name of your **individual database** is the same as your username. The password you can find in the feedback on the 'assignment' Individual Database information on Moodle for today's class.</span> 

### Step 1: Creating a table
In this part of the lab, we'll be interacting directly with the database via `psql`. This [cheatsheet](https://www.postgresonline.com/downloads/special_feature/postgresql83_psql_cheatsheet.pdf) contains all of the psql commands in case you want to explore more later.  

1. Open the file `Pokemon_small.csv` and note how many columns it has, what types they should be, and what good names for them would be.

2. Type `psql` (and Enter) to enter the "interpreter". You will need to enter your database password if prompted. (Sometimes you aren't prompted for it, which is fine, and I have yet to figure out when you will or won't be, so good to be prepared...) You will now be in your individual database, which has the same name as your user name, for example my prompt looks like this:
  ```psql
  vostinar=> 
  ```
  (Note the `=>`, which means its ready for a new prompt. If you ever see `->`, a prompt is still in progress and you might have forgotten a `;`.)

3. You will write a series of SQL statements into a file to create the table and then run the file. (You could write these directly in the interpreter, but it would be inconvinient if you wanted to change something.) Open the file `createtable.sql` and complete it based on the columns of `Pokemon_small.csv`. Here is what it starts with:
  ```sql
  DROP TABLE IF EXISTS pokemon; --Remove the table if it already exists--
  CREATE TABLE pokemon ( --Create the table--
    --Define the columns--
    number INTEGER,
    --Your code here--
  );
  ```
  You can refer to the [prep reading](https://sqlbolt.com/lesson/creating_tables) to refresh on `CREATE TABLE`, though we're using a simpler setup to start.


4. In the `psql` interpreter run the command:
  ```psql
  \i createtable.sql
  ```
   You're successful if you see:
  ```psql
  NOTICE:  table "pokemon" does not exist, skipping
  DROP TABLE
  CREATE TABLE
  ```

5. Type `\dt` at the prompt to make sure you see your table in the database:
  ```psql
                      List of relations
  Schema |            Name            | Type  |  Owner   
  --------+----------------------------+-------+----------
  public | pokemon                    | table | your_user_name
  ```

6. At the prompt, run the copy command to load the data from `Pokemon_small.csv` into the table `pokemon`:
  ```psql
  \copy pokemon FROM 'Pokemon_small.csv' CSV HEADER
  ```
  This command is also specifying that the file is a CSV with a header line (which shouldn't be loaded into the data).
  (Note that unlike SQL queries, \copy does not require a semicolon at the end of the statement.)
  You should then see:
  ```psql
  COPY 14
  ```
  which is how many lines were in the data file.

7. Let's test to see if it worked. Type the necessary SQL query statement at the prompt to just get all the data and make sure that you see data about the first 10 Pokemon, like so:
  ```sql
  number |           name            | type  
  --------+---------------------------+-------
        1 | Bulbasaur                 | Grass
        2 | Ivysaur                   | Grass
        3 | Venusaur                  | Grass
        3 | VenusaurMega Venusaur     | Grass
        4 | Charmander                | Fire
        5 | Charmeleon                | Fire
        6 | Charizard                 | Fire
        6 | CharizardMega Charizard X | Fire
        6 | CharizardMega Charizard Y | Fire
        7 | Squirtle                  | Water
        8 | Wartortle                 | Water
        9 | Blastoise                 | Water
        9 | BlastoiseMega Blastoise   | Water
      10 | Caterpie                  | Bug
  (14 rows)
  ```

## Larger Dataset
You've now gone through the process with a small dataset, great! The next step is to do it with a larger "real" dataset, `Pokemon.csv`. 

### Loading in full dataset
Go through the same process, but now with something closer to your project datasets:

1. Check `Pokemon.csv` to see what columns it has and think about what good column names and types would be. You can consult the [Postgres Types documentation](https://www.postgresql.org/docs/current/datatype.html) to see what the options are.

2. Update your `createtable.sql` to work with the full dataset.

3. Run your `createtable.sql` script again to recreate your table.
  Note that you can run `createtable.sql` from within `psql` with:
  ```psql
  \i createtable.sql
  ```

4. Run an updated `\copy` command to load in the full dataset, which is 800 lines.

### Practicing SQL with full dataset
Try writing single SQL queries to accomplish the following (remember to lean on your team and reference the [prep readings](intro-database-prep) if you aren't sure where to start):
* Find all the Legendary Pokemon that are water types. Include both their types in your output:
  ```psql
          name         | type_1 | type_2 
  ---------------------+--------+--------
  Suicune             | Water  | 
  Kyogre              | Water  | 
  KyogrePrimal Kyogre | Water  | 
  Palkia              | Water  | Dragon
  Volcanion           | Fire   | Water
  (5 rows)
  ```
* Find all the Pokemon with HP less than or equal to 10 (there are two).
* Find the 10 fire Pokemon with the highest special attack (remember to check both types). Make sure to order them highest to lowest.
* Explore the [aggregate functions](https://sqlbolt.com/lesson/select_queries_with_aggregates) to find the average `hp` of each Type 1 group. Try to order by the average hp from greatest to least.

## Multiple Tables
It's time to practice working with multiple tables in a single database. For both `Teams.csv` and `Trainers.csv`, go through the same steps to load the data into tables:
1. Check what columns they have.
2. Update `createtable.sql` to create three tables.
3. Rerun your `createtable.sql` script.
4. Run three `\copy` commands to load in all the data.

### Practicing INNER JOIN
Let's do your first inner join by finding the Pokemon that are on each trainers' team. Here is how to think through constructing this query. Remember the overall structure of an inner join query is:

```psql
SELECT <columns you want> FROM <table 1> INNER JOIN <table 2> ON <table 1>.<col1> = <table 2>.<col2>;
```

Here's how to think it through:
1. What column data do you want showing in your final result? The Pokemon names from the `teams` table and the trainer names from the `trainers` table, so you use those for your `SELECT` clause.
2. You want data from both the `teams` and `trainers` tables, so you use one in your `FROM` clause and one in your `INNER JOIN` clause (it doesn't matter which goes where for inner join).
3. Which column has the connecting data? The `teams` table has a trainer id and the `trainers` table has an id, so that is your connection for your `ON` subclause.

Here are the results that you should get:
```psql
--------------+----------------
 Pikachu      | Ash Ketchum
 Charizard    | Ash Ketchum
 Bulbasaur    | Ash Ketchum
 Staryu       | Misty
 Starmie      | Misty
 Onix         | Brock
 Geodude      | Brock
 Garchomp     | Cynthia
 Lucario      | Cynthia
 Rattata      | Youngster Joey
 Pidgeot      | Blue
 Alakazam     | Blue
 Rhydon       | Blue
 Arcanine     | Blue
 Exeggutor    | Blue
 Blastoise    | Blue
(16 rows)
```

There is so much that you can find out now, so feel free to try things out! Here are some ideas to start you off:
* Find the average and max level of the Pokemon on each trainers' team(be sure to include the trainer's name in your output).
* Find all of "Ash Ketchum"'s Pokemon.
* Find the average total of each trainers’ team ordered from largest to smallest (you'll need two inner joins for this one).
* Find all of the types of Pokemon that each trainer uses (you can get fancy by using the [`string_agg` function](https://www.postgresql.org/docs/9.4/functions-aggregate.html) to have this display more nicely).
* Find out if any trainers have legendary or "Mega" Pokemon.
* Find out which trainers didn't give one or more of their Pokemon nicknames, sad!

## Submission
Include your queries from the previous sections in the file `examples.sql` and push your changed files to the lab repository to complete this lab.

## Starting on ID3
Once you finish the lab, you should start going through the same steps for ID3:
* Identify a *small* subset of your team's data and copy it into a new `.csv` file in your ID3 repository.
* Create a `createtable.sql` file to create a table for your small dataset.
* Determine the `\copy` command needed to load the data into the table and place that in the `README.md` of the repository.

We'll discuss on Wednesday how to do the rest of ID3. For now, practice your SQL more by testing out queries that will grab the necessary data from your database:

1. Identify a simple query that your users might want to do on your data, for example one of your core functions from your team project, or the data route that you chose for your flask deliverable.
2. Can it be boiled down to a single SQL statement? If not, break the query down into simpler parts.
3. Construct the SQL statement (or part of it, if you had to break your original query into smaller parts).
4. Run the query and see what results you get back.
5. If you didn't get the expected results, or you got an error, fix the query and try again.
6. Repeat with other potential queries. Make your queries more complex as you gain confidence.


