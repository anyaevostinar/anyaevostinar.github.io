---
layout: page
title: Empirical DataFiles Lab
permalink: /classes/361-f22/empirical_data_lab
---

## Goals
To use Empirical's DataFiles and DataNodes to record data from an artificial life simulation.

## Setup
1. Open the Empirical Data Lab starter link on Moodle to get the Git repository template. 

2. Open Terminal and clone your repository:
    ```
    git clone <your repository link>
    ```

3. Open VSCode and then open your repository folder. 

4. Open a Terminal in VSCode and pull down the submodules for the starter code:

    ```
    git submodule update --init --recursive
    ```

    (We won't be using Emscripten in this lab so you don't need to set it up.)

You'll probably want to have [the reading](/classes/361-w21/data_intro) open as reference.

## Exercise 1
I've provided starter code for a simple artificial life system (that might look familiar by now). Look through the files in `source` to see how I wrote the code, though it still doesn't actually do anything interesting.

Compile and run using `compile-run.sh` to verify everything is working. (Don't worry about the warnings.)

## Exercise 2
The first thing you'll practice is recording the count of organisms into a file.

a. Create a `DataMonitor` pointer for your organism count as an instance variable of `OrgWorld`.

b. Create a destructor for `OrgWorld` and make sure that your DataMonitor will be deleted when the world is destroyed (rather ominous sounding isn't it?).

c. Create a method `GetOrgCountDataNode()` that creates the data node if it doesn't exist according to the method in the reading. You'll want to think about what your data node should do for each occupied space in the world (don't over think it!).

d. Create a method `SetupOrgFile()` that grabs the total count from your data monitor and records it in the file according to the method in the reading.

e. Call your set up file in `native.cpp`, then compile and run your code to verify that it works.

## Exercise 3
Generally we will want to know about the traits of organisms in the population as well.
Let's imagine that you are doing a simulation of evolving cooperation among organisms.


a. Add a trait to the Organism class that is a double called `cooperation_probability`. Assume that this value goes from 0 to 1 and is the probability that the organism cooperates (though we won't immediately implement the actual cooperation). Take an initial value for the trait in as a parameter to the constructor and set it.

b. Make an accessor and mutator method for the trait, since you'll need them later.

c. Set up mutation on the trait during reproduction. Refer back to the [Evolutionary Algorithm Lab](evo_alg_lab) for how to do this.

d. Verify that your trait is mutating with print statements in `native.cpp` before moving on to making a data file for it.


## Exercise 4
You may also be interested in the distribution of values for the cooperation probability that the organisms currently have, even though it is just drifting around currently. 

a. Create a `DataMonitor` pointer for the cooperation values that will hold both a double and a histogram.

b. Add this data node to your destructor.

c. Create a method for getting the data node, remember that it has to return a type that matches the type of your data monitor.

d. Add the code to your file setup method to create the bins of your histogram and add them and the mean of the data to the file.

e. Compile and run your code to see how the distribution changes over time.

## Extensions
Try some of the following:
* Create a second trait and another data file to track information about that trait
* Combine what you know from the configuration lab to control the name of your data file(s) with a configuration setting and include the random number seed in the file name as well so you don't overwrite your data when you run multiple experiments
* Getting data to display nicely on your web GUI is a pretty big task, but you can start to look through [Empirical's support for using D3](https://empirical.readthedocs.io/en/latest/library/web/d3/d3-intro.html) if you are interested in trying
