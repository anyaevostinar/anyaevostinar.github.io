---
layout: page
title: Cellular Automaton Homework Assignment
permalink: /classes/361-s25/hw-ca
---

## Logistics

This is an individual assignment, so you should complete it on your own, though you are able to get help from many sources as detailed in the syllabus.

This assignment is due on Wednesday April 16th at 10pm. 
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

## Assignment Specification
For this assignment, you need to add on to the code that I've provided so that, when the `compile-run.sh` file is run, a browser-based cellular automaton runs in the browser.
This will require you to write the starting conditions and update rule in `CAAnimate.cpp` such that some kind of life-like pattern is seen, specifically some kind of repeating or ordered pattern, in the 2D grid.
Examples include the classic glider and spaceship.
You are welcome to introduce additional states (with additional colors) as well.
This is purposefully open-ended, so that you can play around with different combinations to see what happens!

## Assessment
To demonstrate **proficiency** for this assignment, your submission should:

* Run and display a Game of Life cellular automaton with a life-like pattern when the `compile-run.sh` script is run
* Use the web-browser and Empirical library
* Handle the toroidal spatial structure correctly (i.e. not get messed up when the pattern reaches the edge). This requires you pick a pattern that handles wrapping
* Have well-documented and styled code

For your assignment to be **exemplary**, your submission should:
* Implement a continuous cellular automata
* Use the web-browser and Empirical library
* Handle the toroidal spatial structure correctly
* Have well-documented and styled code
* Specify in a file `README.md` what CA pattern your assignment is demonstrating and what sources you consulted to create it (if any)

Note that I don't expect you to reinvent the spaceship pattern (for example); you can and should look up the starting conditions and rule to make it if you want, just make sure to cite your sources.

## Submitting
You will submit your assignment by pushing your code to the GitHub Classroom repository that you start from.
If you are unsure how to use Git to push your code, please ask!

## Getting Help
Remember that you can and should ask for help on everything from annoying C++ bugs to Git to "is this a reasonable CA to implement?"
The CampusWire is probably the best place to ask, as long as you don't have to share too much of your code to do so, because you'll get faster responses on average.
You are also welcome to come to drop-in hours, Kai's help hours, and schedule a one-on-one meeting if that works better for you.