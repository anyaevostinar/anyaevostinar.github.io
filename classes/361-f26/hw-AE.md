---
layout: page
title: Artificial Ecologies Homework Assignment
permalink: /classes/361-s25/hw-ae
---

## Logistics
This is an individual assignment, so you should complete it on your own, though you are able to get help from many sources as detailed in the syllabus.

This assignment is due on Friday April 25th at 10pm. 
As with all assignments, you will have the opportunity to revise this assignment based on the feedback that you get.

## Goal
The goal of this assignment is demonstrate your understanding of artificial ecologies. 
You'll be making an artificial ecology that runs in the web browser, [like my example here](https://anyaevostinar.github.io/AE-Assignment/).

## Setup
The setup process will be the same as for the cellular automata assignment, except you'll use the Artificial Ecologies Github Classroom link on Moodle. Follow the [same steps as described in the previous assignment](hw-ca) after that.

## Assignment Specification
For this assignment, you need to add on to the code that I've provided so that, when the `compile-run.sh` file is run, a browser-based artificial ecosystem runs in the browser.
This will require you to write code for your world, organisms, and interactions between organisms.
This is purposefully open-ended, so that you can make a system that is of interest to you!

## Assessment

### Proficient
Your submission should:

* Run and display an artificial ecosystem with at least two species of organisms when the `compile-run.sh` script is run, using the web-browser and Empirical library
* Handle the toroidal spatial structure correctly (i.e. organisms don't get caught on edges and move from location to location reasonably)
* Have somewhat well-documented and styled code
    * Lack of duplicate code (i.e. using inheritance) is part of being somewhat well-styled
* Specify in a file `README.md` what your two species of organisms are and how they interact with each other

### Exemplary
Your submission should do everything from the proficient category, as well as:
* Have starting settings that result in persistence of at least two species for a reasonable amount of time (obviously we can't test if they will persist forever, but I should be able to run your simulation for a minute or two and still see two species)
* Have text on your webpage explaining thoroughly what the user is seeing. Imagine that this is a basic demonstration for the public and you are explaining this ecological dynamic.
* Have very well-documented and styled code
    * This requires all methods to be less than ~15 lines of code, have doc strings and inheritance to be used effectively

## Submitting
You will submit your assignment by pushing your code to the GitHub Classroom repository that you start from.
If you are unsure how to use Git to push your code, please ask!

## Getting Help
Remember that you can and should ask for help on everything from annoying C++ bugs to Git to "is this a reasonable artificial ecosystem to implement?"
The CampusWire is probably the best place to ask, as long as you don't have to share too much of your code to do so, because you'll get faster responses on average.
You are also welcome to come to drop-in hours, and schedule a one-on-one meeting if that works better for you.

## Addendums
Since there was only a style component on Proficiency, most of you scored Not Yet Proficient on the first submission. I am updating the requirements to split out the style for revisions so there is a "Proficient" that is less than what I expect for "Exemplary". I have therefore added the specifics of what is necessary for exemplary style. Feel free to check with me on if your code already hits the new Proficient requirement.