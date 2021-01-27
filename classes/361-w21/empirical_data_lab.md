---
layout: page
title: Empirical DataFiles Lab
permalink: /classes/361-w21/empirical_data_lab
---

## Goals
To use Empirical's DataFiles and DataNodes to record data from an artificial life simulation.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday Feb 1st, but it isn't due until Wednesday Feb 3rd at 5:00pm Central.

## Setup
Open the Empirical DataFiles project on Repl.it for starter code.

Also open the reading for today to reference the methods that will be useful.

## Exercise 1
I've provded solution code that follows what you wrote in the Empirical Intro lab. Look through the files in `source` to see how I wrote the code for the simple artificial life system, though it still doesn't actually do anything interesting.

Compile and run (using `make` and `./evo-algo` as before) to verify everything is working. (Don't worry about the warnings.)

## Exercise 2
The first thing you'll practice is recording the count of organisms into a file.

a. Create a `DataMonitor` pointer for your organism count as an instance variable of `OrgWorld`.

b. Create a destructor for `OrgWorld` and make sure that your DataMonitor will be deleted when the world is destroyed (rather ominous sounding isn't it?).

c. Create a method `GetOrgCountDataNode()` that creates the data node if it doesn't exist according to the method in the reading.

d. Create a method `SetupOrgFile()` that grabs the total count from your data monitor and records it in the file according to the method in the reading.

e. Call your set up file in `native.cpp`, then compile and run your code to verify that it works.

## Exercise 3
You may also be interested in the distribution of values for the cooperation probability that the organisms currently have, even though it is just drifting around currently. 

a. Create a `DataMonitor` pointer for the cooperation values that will hold both a double and a histogram.

b. Add this data node to your destructor.

c. Create a method for getting the data node, remember that it has to return a type that matches the type of your data monitor.

d. Add the code to your file setup method to create the bins of your histogram and add them and the mean of the data to the file.

e. Compile and run your code to see how the distribution changes over time.

## Submitting
Empirical is way too big to zip and upload to Moodle regularly, so we're going to try out Repl.it's submission functionality. Click 'Submit' in the upper right corner of your project and **on Moodle paste in the link to your project**.

## Extensions
If you add functionality to your organisms in the previous lab, feel free to copy that code over and try to track additional information. You can create and print to multiple data files to keep your code organized. You can also change some variables and the name of the data file to see how the changed variable changes your data results. We'll see in the next lab how to avoid having to recompile just to change values.