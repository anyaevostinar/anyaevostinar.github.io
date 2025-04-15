---
layout: page
title: Digital Evolution Homework Assignment
permalink: /classes/361-s25/hw-de
---

## Logistics
This is an individual assignment, so you should complete it on your own, though you are able to get help from many sources as detailed in the syllabus.

This assignment is due on Wednesday May 7th at 10pm. 
As with all assignments, you will have the opportunity to revise this assignment based on the feedback that you get.

## Goal
The goal of this assignment is to demonstrate your understanding of digital evolution.
You'll be making a digital evolution project that runs in the web browser using the SignalGP-Lite framework, which is built with the Empirical framework.

## Setup
The setup process will at first be the same as for the previous assignments, except you'll use the "Get DE Project Starter Code" Github Classroom link on Moodle. Follow the [same steps as described in the previous assignments](hw-ca) after that.

## Supplemental info
As you are working on this project, you may find the supplemental material section F of [this paper](https://mmore500.com/pubs/moreno2021case) a helpful reference for what operations are available and what they do, as well as the [SGP-Lite lab](sgplite_lab).

## Assignment Specification
For this assignment, you need to create both a web GUI (in web.cpp) and a data only "native" version (in native.cpp). 

For the web GUI, add on to the code that I've provided so that, when the new `compile-run-web.sh` file is run, a browser-based digital evolution system runs in the browser.
This will require you to write code for tasks that the organisms can do to gather resources and the visual interface of the system.
This project is somewhat constrained so that you don't have to implement most of the pieces of a digital evolution system and can focus on what tasks you want the organisms to be rewarded for and how you want to visually represent your system.

For the native data-only version, you need to add some data file support to your world so that when `compile.run.sh` is run, data files with information about your organism's task performance are created and filled.

## Assessment
**Proficiency** for this assignment, requires your submission to:

* Run and display a digital evolution system when the `compile-run-web.sh` script is run, using the web-browser, SignalGP-Lite, and Empirical libraries
* Handle the toroidal spatial structure correctly (i.e. organisms reproduce and/or move correctly across the edges of the grid when using a grid spatial structure)
* Have at least two tasks that organisms evolve to perform within a reasonable amount of time (running your code for about 10 minutes) which are visually represented in your GUI
* Have well-documented and styled code
* Specify in a file `README.md` what your tasks are and how they are visually represented in your GUI

**Exemplary** for this assignment, requires your submission to do everything from the proficiency category, as well as:
* Run a command-line experiment when the `compile-run.sh` script is run that uses `DataMonitor` and `DataFile` to output data files with information on the tasks the organisms have performed
* Have at least five tasks that organisms can evolve to perform
* Have a configuration panel on the GUI that allows the user to change at least two settings that impact the evolution of the population
* Have text on your webpage explaining the tasks and what the user is seeing

## Submitting
You will submit your assignment by pushing your code to the GitHub Classroom repository that you start from.
If you are unsure how to use Git to push your code, please ask!

## Getting Help
Remember that you can and should ask for help on everything from annoying C++ bugs to Git to "is this a reasonable artificial ecosystem to implement?"
The CampusWire is probably the best place to ask, as long as you don't have to share too much of your code to do so, because you'll get faster responses on average.
You are also welcome to come to drop-in hours, Kai's help hours, and schedule a one-on-one meeting if that works better for you.

## Acknowledgements
Most of the starter code was implemented by Sylvie Dirkswager, thanks Sylvie!