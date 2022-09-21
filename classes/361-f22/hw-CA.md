---
layout: page
title: Cellular Automaton Homework Assignment
permalink: /classes/361-f22/hw-ca
---

## Logistics

This is an individual assignment, so you should complete it on your own, though you are able to get help from many sources as detailed in the syllabus.

This assignment is due on Wednesday Sept 28th at 10pm. 
As with all assignments, you will have the opportunity to revise this assignment based on the feedback that you get.

## Goal
The goal of this assignment is demonstrate your understanding of cellular automata. 
You'll be making a cellular automaton that runs in the web browser, [like my example here](https://anyaevostinar.github.io/CA-Assignment/).

## Setup
We'll be using the Empirical library for this assignment and so I've provided a fair amount of starter code so that you can focus on implementing the cellular automaton. 

1. Follow the link to the GitHub Classroom assignment in Moodle to get access to the starter code.

2. Once you've cloned down your repository, you'll need to get the submodules all squared away.
First, get all your submodules downloaded:
```
git submodule update --init --recursive
```

3. Then, go to the `emsdk` folder and install and activate `emsdk`:
```
cd emsdk
./emsdk install 3.1.2
./emsdk activate 3.1.2
```

4. Then source `emsdk`. You'll need to do this command anytime you open a new Terminal, so if you are getting an error about `emcc` not existing, you probably forgot to do this:
```
source ./emsdk_env.sh
```

5. Verify that everything is set up correctly by going back to the top level of your repository and running the `compile-run.sh` file:
```
./compile-run.sh
```
You should see a grid of squares with one black square in the upper left corner and some buttons.

## Running on your own machine
I've tested this process on the lab machine build.
This means that you can definitely work on the assignment in Olin 310 and the other Olin 3rd floor labs. 
You can also make sure that you put the Git repository in the [COURSES](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=Fall+2022%3A+CS+111+and+201+workflow+in+CS+labs) drive so you don't have to reclone it each work session.

You quite possibly can also work on your own machine, but I make no guarantees since I haven't tested it on every operating system. 
I'm happy to help you try to get things setup on your machine, but if we run into too many issues, I'm going to recommend you work on the lab machines.

### Mac
If you have a Mac, you probably just need to install the XCode Command Line Tools, which you will be prompted to do when you try to compile with `g++`. 
If you run into issues with that, restarting and trying again often does the trick.

### Windows
If you have Windows, you will need [WSL] to be able to compile. 
The documentation for getting that setup is pretty good now, and you might already have it since it is needed for a lot of development.
I've tested running this on my WSL setup and had no problems.

### Linux
If you are running Linux, hopefully you won't have problems and can handle downloading anything that is needed.
I have only tested Ubuntu running on WSL.

## Assignment Specification
For this assignment, you need to add on to the code that I've provided so that, when the `compile-run.sh` file is run, a browser-based cellular automaton runs in the browser.
This will require you to write the starting conditions and update rule in `CAAnimate.cpp` such that some kind of life-like pattern is seen, specifically some kind of repeating or ordered pattern, in the 2D grid.
Examples include the classic glider, spaceship, and glider gun.
You are welcome to introduce additional states (with additional colors) as well.
This is purposefully open-ended, so that you can play around with different combinations to see what happens!

## Assessment
To demonstrate **proficiency** for this assignment, your submission should:

* Run and display a cellular automaton with a life-like pattern when the `compile-run.sh` script is run, using the web-browser and Empirical library
* Handle the toroidal spatial structure correctly (i.e. not get messed up when the pattern reaches the edge)
* Have well-documented and styled code
* Correctly implement the glider update rule described in "Complexity" reading
* Specify in a file `README.md` that the update rule is from Complexity by Melanie Mitchell

To demonstrate **mastery** for this assignment, your submission should do the first three items from the proficiency category, as well as:
* Implement an update rule and starting conditions *other than* the glider, for example the spaceship, glider gun, or any other more complex cellular automaton
* Specify in a file `README.md` what pattern your assignment is demonstrating and what sources you consulted to create it (if any)

Note that I don't expect you to reinvent the spaceship pattern (for example); you can and should look up the starting conditions and rule to make it if you want, just make sure to cite your sources.

## Submitting
You will submit your assignment by pushing your code to the GitHub Classroom repository that you start from.
If you are unsure how to use Git to push your code, please ask!

## Getting Help
Remember that you can and should ask for help on everything from annoying C++ bugs to Git to "is this a reasonable CA to implement?"
The CampusWire is probably the best place to ask, as long as you don't have to share too much of your code to do so, because you'll get faster responses on average.
You are also welcome to come to drop-in hours, Zev's help hours, and schedule a one-on-one meeting if that works better for you.