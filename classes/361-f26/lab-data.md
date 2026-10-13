---
layout: page
title: Empirical DataFiles Lab
permalink: /classes/361-f26/empirical_data_lab
---

## Goals
To use Empirical's DataFiles and DataNodes to record data from an artificial life simulation.

## Setup

* Remember to start WSL if you are on Windows
* Pull down the new `Data-Lab` starter code repository from the [361-F26](https://github.com/361-F26) GitHub Organization with `git clone --recurse-submodules [URL]` or `git submodule update --init --recursive` if you cloned without the recurse submodules command.
* (No need to setup Emscripten today)
* Open [the data reading](https://anyaevostinar.github.io/classes/361-w21/data_intro) in a new tab as reference.

## Exercise 1
I've provided starter code for a simple artificial life system (that might look familiar by now). Look through the files to see how I wrote the code, though it still doesn't actually do anything interesting.

Compile and run using `compile-run.sh` to verify everything is working. (Don't worry about the warnings.)

## Exercise 2
The first thing you'll practice is recording the count of organisms into a file.

a. Create a `DataMonitor` pointer for your organism count as an instance variable of `OrgWorld`.

b. Create a destructor for `OrgWorld` and make sure that your DataMonitor will be deleted when the world is destroyed (rather ominous sounding isn't it?).

c. Create a method `GetOrgCountDataNode()` that creates the data node if it doesn't exist according to the method in the reading. You'll want to think about what your data node should do for each occupied space in the world (don't over think it, it really is just a single number!).

d. Create a method `SetupOrgFile()` that grabs the total count from your data monitor and records it in the file according to the method in the reading.

e. Call your set up file in `native.cpp`, then compile and run your code to verify that it works.

## Exercise 3
Generally we will want to know about the traits of organisms in the population as well. Let’s imagine that you are doing a simulation of evolving cooperation among organisms.

The organisms already have a (non-functional) trait `cooperation_probability` along with accessors, which mutates upon reproduction. You may be interested in the distribution of values for the cooperation probability that the organisms currently have, even though it is just drifting around currently. 

a. Create a `DataMonitor` pointer for the cooperation values that will hold both a double and a histogram. (In your world class)

b. Add this data node to your destructor.

c. Create a method for getting the data node, remember that it has to return a type that matches the type of your data monitor.

d. Add the code to your file setup method to create the bins of your histogram and add them and the mean of the data to the file.

e. Compile and run your code to see how the distribution changes over time.

## Submission
You aren't required to submit labs in this class, but you can for an extra engagement credit. Complete the implemention of the two data files and then push it to GitHub:
```bash
git add World.h native.cpp
git commit -m "finished datafiles"
git push
```

## Extensions
Try some of the following:
* Create a second trait and another data file to track information about that trait
* Combine what you know from the configuration lab to control the name of your data file(s) with a configuration setting and include the random number seed in the file name as well so you don't overwrite your data when you run multiple experiments
* Getting data to display nicely on your web GUI is a pretty big task, but you can start to look through [Empirical's support for using D3](https://empirical.readthedocs.io/en/latest/library/web/d3/d3-intro.html) if you are interested in trying
