---
layout: page
title: Final Project 
permalink: /classes/111-w22/final-project
---
## Overview
For your final project, you’ll be working on a program of your own design with or without a partner. 
To provide some structure, I’ll be expecting projects of one of the two types discussed below. 
If you have something else in mind that you think makes sense for the class, drop me a line and we can discuss the prospect. 
**In any event, your project code must be object-oriented, meaning it centers on the use of one or more classes that you have created.**
It’s okay to have additional functions, too, but your core functionality should be handled by classes.

(This project description has been adapted, with permission, from earlier descriptions by Profs. Amy Csizmar Dalal, Titus Klinge, James Ryan, and Eric Alexander.)

## Logistics
You have the option of working with a partner for the final project and choosing that partner.
You are not required to hold to pair programming for this project (i.e. you are allowed to split up the project and work on parts separately).

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

The final project is 25% of your grade in the course and that is broken up into several pieces:
* Project proposal **due 2/28 at 10pm**
* Project presentation **during exam period**
* Project code and report **due 3/16 at 2pm**

## Project Requirements
You have two options for categories of projects.
Regardless of option, your project must be object-oriented and use classes of your own design meaningfully.
You must also include graphics.
You will probably find the [documentation for the graphics module](https://mcsp.wartburg.edu/zelle/python/graphics/graphics/graphref.html) helpful and should look through it!

### Option 1 - Game
The first type of project is a computer game. 
Your game should incorporate some level of actual AI decision making. 
By this, I mean that the computer should play against you or manage your game in a moderately intelligent way. 
You don't need the computer to be a world-class player — or even close! 
That's what CS 321: Artificial Intelligence is for. 
But you should make a concerted effort on this front, meaning that your AI will go above and beyond a simple random strategy. 
Remember that your time is limited, so pick a game that you will be able to implement between now and the end of the term. 

**Your game must incorporate graphics** in some way. 
If you have questions about the suitability of a particular game, feel free to ask me about it!

### Option 2 - Simulation
One of the things computers excel at is simulation of systems that change over time. 
Consider, as just one example, a simulation of the solar system. 
You give the program the initial positions, masses, and velocities of the largest objects in the solar system, plus a computational mechanism for simulating the effects of Newton’s law of gravitation. 
Then you set the system running, and your solar system will go through its motions, with the positions of the planets being animated at each time step in the simulation. 
You could then try adding a comet with a mouse click or two, and watch how the comet’s orbit is perturbed by close encounters with planets or asteroids. 
If the simulation takes relevant physical laws into account, the evolution of the system will be a good representation of the workings of the real solar system!

If you choose this option for your final project, you will simulate some time-dependent system that can be represented effectively in a rectangular display. 
You could show a top-down view of a solar system or traffic on a street grid, or a side view of an aquarium, or a landscape with rain, clouds, plants, and birds. 
Your system will need to be animated, and there will need to be a diverse enough collection of elements in your system such that the objects will have interactions of some kind. 
To give a few examples, planets interact gravitationally, big fish eat little fish, cars avoid one another, and raindrops cause plants to grow.

Your simulation may include pretty much any features you can cook up, but it must be graphical and must have the following minimal features:
* More than one type of moving object.
* “Interactions” between objects (one object causes another object to react in a certain way).
* Some feature that allows either mouse-clicks or keystrokes or some other form of user input to affect the simulation in some way (click to create a plant, set the animation speed, etc.).

If you have questions about the suitability of a particular simulation domain, feel free to ask me about it!

### Ideas
To get you started with project ideas, here are some examples that students have successfully implemented in previous offerings of this course:
* Games
    * [Snake](https://en.wikipedia.org/wiki/Snake_(video_game_genre))
    * [Battleship](https://en.wikipedia.org/wiki/Battleship_(game))
    * [Connect Four](https://en.wikipedia.org/wiki/Connect_Four)
    * [Mastermind](https://en.wikipedia.org/wiki/Mastermind_(board_game))
    * [Concentration](https://en.wikipedia.org/wiki/Concentration_(card_game))
    * [Guess Who?](https://en.wikipedia.org/wiki/Guess_Who%3F)
        * More generally, games in which the player guesses a person that the computer is thinking of based on characteristics like hair color or class year. This is a variation of [20 Questions](https://en.wikipedia.org/wiki/Twenty_questions), essentially.
    * [Hammurabi](https://en.wikipedia.org/wiki/Hamurabi_(video_game))
* Simulations
    * Fish tank
    * Garden
        * User does things like waters plants or moves them into limited sunlight
    * Biological simulations
        * diseased vs. white blood cells
        * change of seasons
        * [evolving organisms](https://anyaevostinar.github.io/SymbulationEmp/web/symbulation.html)
    * Agricultural simulations
        * given a set of initial conditions, a choice of crop, etc., will you be able to harvest your crop and get it to market?
    * Sports simulations
        * Something akin to the simulation of a broomball league
    * Traffic simulations

If you’re stuck for ideas, or have questions about the suitability of a particular idea, shoot me a DM on Slack and we can talk it over!

## Deliverable 1: Project Proposal
As the first deliverable for your project, you must write a short proposal of what you plan to do. 
You will submit this through Gradescope. 
Your proposal is due by Monday, February 28th, at 10pm, and it should include the following components:

* Who’s working on the project, and how you plan to divide the work.
* The game or simulation you plan to implement for your final project. Include a brief description of the game and its rules (or, for a simulation, what you aim to model and a basic overview of how it will run).
* A brief development plan: what sort of classes and methods you will need to write and generally how these will work together.
* What kind of graphics will be incorporated into your project.
* A description of your primary outcome(s) for the project. I’ll raise concerns if these outcomes seem too ambitious or not ambitious enough.
* A description of your stretch goal(s) for the project. These are outcomes that you hope to achieve, but that you realize may be too difficult given the time frame and your current programming expertise.

After some back and forth (over Slack) to confirm the details and make sure you’re poised to succeed, I’ll officially sign off on your project, which means you’re free to start working on the project.

## Deliverable 2: Presentation
During our final exam period, Tuesday March 15th 3:30-5 (yes it officially goes until 6, but we will end at 5), you will present your project in a "gallery walk".
I'll provide more details as that approaches, but the basic idea will be that half of you will get your game or simulation running on a lab computer and tell the other half about the project and then we'll switch partway through. 
You'll be required to both present your project and learn about a specific number of other projects.
This deadline means that your project should be in working order for the presentation!

## Deliverable 3: Project Code and Report
Finally, your major deliverable will be the code for the project, along with documentation of that code in the form of a report. 
**To be clear, the report is required!** 
Specifically, you will include a `README` file with your project submission, which will contain your report. 
A `README` file is a simple text file that describes your project in more detail. 
The `README` file should be named `README.txt`, and it should include the following:

* The name of your project.
* Your names.
* Whether your project is a game or a simulation.
* The particular type of complexity that is represented in your program. Per the grading rubric below, your program must exhibit complexity in at least one of the following ways:
    * Rich "AI" strategy in the case of a computer game.
    * Rich and varied results in the case of a computer simulation.
        * That is, the simulation results are quite different every time the program is run.
    * Impressive graphics and/or graphical interface (e.g., interface allowing interesting user interactions).
* How to play the game (also describe the game rules) and/or how to run the simulation. This should include information such as what extra files, if any, are needed to run the program. (If your program requires extra files, such as images, please include these with your project submission.)
* A brief description of any known bugs or issues with the program.

I recommend that you start working on your project as soon as I’ve signed off on your idea. 
The final project is due Wednesday, March 16th at 2pm and no extensions are possible except through the Dean of Students office.

You will submit your project and report through Gradescope.

## Resources
In addition to the normal resources you have for getting help, I recommend you consult these sections of Zelle:
* 4.7 "Interactive Graphics" includes subsections on Getting Mouse Clicks, Handling Textual Input, and the entire Graphics Module Reference to peruse
* 8.6 "Example: A Simple Event Loop" show how to make a window that changes color whenever the mouse is clicked
* 10.6 "Widgets" has code for graphically rolling dice
* 10.7 "Animated Cannonball" simulates a cannonball being shot in a graphics window
* 11.5 "Case Study: Python Calculator" has code for making a calculator tool with lots of buttons
* 11.6 "Case Study: Better Cannonball Animation" shows how to improve the cannonball animation to have multiple cannonballs at once
* 12.3.5 "Developing a GUI" shows how to expand the dice roller to make a poker game

## Grading
You will be graded on the following rubric. The final project is a total of 100 points and is weighted as 25% of your final grade in the class.

| Requirement | Points |
|------------|---------|
| Project proposal contains required information | 10   |
| Project presentation | 10 |
| Reviewed 5 other presentations | 10 |
| Report is detailed and includes required information |  10   |
| Project conforms to required programming style | 10 |
| Project runs without errors and exhibits complexity in at least one of the ways described above | 50 |