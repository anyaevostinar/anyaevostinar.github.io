---
layout: page
title: Command Line Interfaces Prep
permalink: /classes/257-s25/cl-prep
---

## Overview
The first component of your team project is going to be just a command line interface to interact with your dataset. The goal will be that it can let the user get some basic/useful information from the dataset so that you are starting to think about what that information/functionality should be before you worry about making a website or a database. 

There is actually a lot that goes into making a good command line interface (and you won't need to make a super polished one), so today's reading is to get you started thinking about all that could be involved.

## Basic Learning Objectives

Before class, you should be able to:
* Explain the difference between a command-line interface and a graphical interface
* Get input from the command line in Python
* Identify some best practices for making a command line interface
* Explain the point of the `help` command

## Advanced Learning Objectives
After class, you should be able to:
* Design a minimal command-line interface app that includes a usage statement and several features

## Readings
To achieve the basic learning objectives, you can read the following before class (this is a topic where [Gemini](https://gemini.google.com/u/1/app) is likely quite a good resource as well):

* [Python Command Line Interface](https://realpython.com/python-command-line-arguments) - focus on "The sys.argv Array" section
* [Exploring CLI Best Practices, by Kevin Deisz.](https://eng.localytics.com/exploring-cli-best-practices/) There are many articles about this topic online. This one is a good place to start because the author gives you a numbered list of pretty straight-forward general principles to work with. You can stop reading after principle #12, since the rest is less generally about the topic at hand.

## Checks
Come up with (at least) one meaningful way that a user could interact with your dataset and what the command line interface for that functionality could be. **Submit this to Moodle.** For example, if I had a dataset of all the dragon characters ever created and one of the columns was their name, I could have a command line interface to get a list of all of the dragon characters with the name Anya by typing:

```bash
python3 dragon_characters.py --name "Anya"
```

(Sadly, I don't think there are any...)