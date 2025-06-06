---
layout: page
title: Command Line Design
permalink: /classes/257-s25/command-line-design
---

## Goal
Start on a design for a command line app for your dataset. DON'T START CODING IT YET!

## Overview
Your command line app should allow the user to do at least two interesting things with your dataset, which probably will both involve searching the data based on some information and getting back a subset of the data that fits some criteria.
Maybe you already have an idea of a couple of user stories that you want to support; great! This lab will walk you through coming up with a couple more and starting to design the command line interface.

## Step 1: Identify the interesting columns
In any dataset, some of the columns are more interesting than others.
In a dataset with books, I don't care a whole lot about the [ISBN](https://en.wikipedia.org/wiki/International_Standard_Book_Number) personally (though maybe you have an idea of how it could be interesting!).

First identify 3-5 columns in your dataset that are the most interesting. 
These are the columns on which a user is likely to search and want information about.
There will probably be 1-2 columns that are the absolutely most interesting, but try to also think about a couple of other columns that might be interesting because of how they relate to the 1-2 columns.

## Step 2: Identify the relationships
Some of your columns are probably interesting all on their own, but most likely a user will want to know some information about a relationship across columns (for example, which author wrote a book or all the books by a given author).

Think about all the possible combinations of your interesting columns and decide if you want to focus on that combination somehow. Do you want to let the user look up which authors published a book in 2019 or is that not particularly interesting to you?

## Step 3: Turn those relationships into user stories
From the interesting columns and relationships, come up with at least four user stories that would be interesting to support (you will only need to support two of them, but it's good to have backups). 

## Step 4: Design the CLI
Now, decide on the two user stories you want to support first. For each, come up with the command line options and format for them, along with a usage statement.

These two options should be independent and use a flag to mark which feature is being used. For example, if I had feature A and feature B for my app `example.py`, I should be able to do:
```
python3 example.py -a "hello"
python3 example.py -b 3
```
assuming that feature A takes a string and feature B takes a number.

## Step 5: Deciding on Function Signatures
Before you can jump into test-driven development, you need to decide as a group on *function signatures* for your features.
A function signature is the name of the function (or method if you are using a class), which variable it takes, and what it returns.

For each of your features, you should decide on function signatures. 
These functions will probably call lots of other functions, but these will be the functions that you first call from your argument parsing function based on the option that the user selects.


## Step 6: TDD
You're all set to write a first failing test for your code and then write some production code to pass the test, so you should start on the [command line component](project-command-line) of your group project.

## Submitting
Put your draft command line interface design in the Google doc linked from Moodle; I'll go through and give feedback on some at the end of class.