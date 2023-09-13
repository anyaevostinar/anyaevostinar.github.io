---
layout: page
title: Command Line Design
permalink: /classes/257-f23/command-line-design
---

## Goal
Start on a design for a command line app for your dataset. DON'T START CODING IT YET!

## First Though
If you haven't finished both parts of Git Practice, do that first.

If your team hasn't settled on a dataset yet, you should focus on that, since this lab assumes you have an idea of what data you'll be working with.

## Overview
Your command line app should allow the user to do at least two interesting things with your dataset, which probably will both involve searching the data based on some information and getting back a subset of the data that fits some criteria.
Maybe you already have an idea of a couple of interesting things that you want to support; great! This lab will walk you through coming up with a couple more and starting to design the command line interface.

## Step 1: Identify the interesting columns
In any dataset, some of the columns are more interesting than others.
In a dataset with books, I don't care a whole lot about the [ISBN](https://en.wikipedia.org/wiki/International_Standard_Book_Number) personally (though maybe you have an idea of how it could be interesting!).

First identify 3-5 columns in your dataset that are the most interesting. 
These are the columns on which a user is likely to search and want information about.
There will probably be 1-2 columns that are the absolutely most interesting, but try to also think about a couple of other columns that might be interesting because of how they relate to the 1-2 columns.

## Step 2: Identify the relationships
Some of your columns are probably interesting all on their own, but most likely a user will want to know some information about a relationship across columns (for example, which author wrote a book or all the books by a given author).

Think about all the possible combinations of your interesting columns and decide if you want to focus on that combination somehow. Do you want to let the user look up which authors published a book in 2019 or is that not particularly interesting to you?

## Step 3: Turn those relationships into features
From the interesting columns and relationships, come up with at least four features that would be interesting to support (you will only need to do two of them, but it's good to have backups). 
These would be something like allowing the user to look up a row based on a string or number, getting a list of entries based on a range, etc.

## Step 4: Design the CLI
Now, decide on the two features that you want to actually include. For each, come up with the command line options and format for them, along with a usage statement.

These two features should be independent and use a flag to mark which feature is being used. For example, if I had feature A and feature B for my app `example.py`, I should be able to do:
```
python3 example.py -a "hello"
python3 example.py -b 3
```
assuming that feature A takes a string and feature B takes a number.

## Step 5: Deciding on Function Signatures
Before you can jump into test-driven development, you need to decide as a group on *function signatures* for your features.
A function signature is the name of the function (or method if you are using a class), which variable it takes, and what it returns.

For each of your features, you should decide on function signatures. 
These functions will probably call lots of other functions, but these will be the functions that you first call from `main` based on the option that the user selects.


## Step 6: TDD
You're all set to write a first failing test for your code and then write some production code to pass the test!

## Submitting
Put your draft command line interface design and function signatures in a text file `usage.txt` and push it to your team's repository so you don't lose it. I might take a look at these and give feedback on some in class.