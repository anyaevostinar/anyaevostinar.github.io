---
layout: page
title: Command Line Interfaces Prep
permalink: /classes/257-w26/cl-prep
---

## Overview
The first component of your team project is going to be just a command line interface to interact with your datasets. The goal will be that it can let the user get some basic/useful information from the dataset so that you are starting to think about what that information/functionality should be before you worry about making a website or a database. 

There is actually a lot that goes into making a good command line interface (and you won't need to make a super polished one), so today's reading is to get you started thinking about all that could be involved.

## Basic Learning Objectives

Before class, you should be able to:
* Get input from the command line in Python
* Identify some best practices for making a command line interface
* Explain the point of the `help` command

## Advanced Learning Objectives
After class, you should be able to:
* Design a minimal command-line interface app that includes a usage statement and several features

## Readings
To achieve the basic learning objectives, you should read the following:

* [How to use `sys.argv` in Python](https://www.geeksforgeeks.org/python/how-to-use-sys-argv-in-python/) - important if you didn't use command line arguments previously
* [Command Line Interface Guidelines (Abbreviated)](/classes/257-w26/cli-guidelines)
* Optional: [Python's `argparse` tutorial](https://docs.python.org/3/howto/argparse.html) - maybe come back to once you start actually working on the code or skim now

## Checks
Submit the following to Moodle:

* Come up with (at least) one meaningful way that a user could interact with your dataset and what the command line interface for that specific functionality could be. For example, if I had a dataset of all the dragon characters ever created and one of the columns was their name, I could have a command line interface to get a list of all of the dragon characters with the name Anya by typing:

    ```bash
    python3 dragon_characters.py --name "Anya"
    ```

    (Sadly, I don't think there are any...)

* Write a few sentences reflecting on which aspects of the CLI Guidelines you have found most helpful when you have used CLI tools and why they were helpful.

