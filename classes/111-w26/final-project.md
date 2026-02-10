---
layout: page
title: Final Project 
permalink: /classes/111-w26/final-project
---

* [Overview](#overview)
* [Logistics](#logistics)
* [Assessment](#assessment)
* [Requirements](#project-requirements)
* [Proposal](#project-proposal)
* [Peer Review](#project-peer-review)
* [Report](#project-report)
* [Resources](#resources)

## Overview
For your final project, you’ll be working on a program of your own design with or without a partner. 
To provide some structure, I’ll be expecting projects of a specific type discussed below. 
**Your project code must be object-oriented, meaning it centers on the use of two or more classes that you have created and it must use the provided `graphics.py` library.**
It’s okay to have additional functions, too, but your core functionality should be handled by classes.

(This project description has been adapted, with permission, from earlier descriptions by Profs. Amy Csizmar Dalal, Titus Klinge, James Ryan, and Eric Alexander.)

## Logistics
You have the option of working with a partner for the final project and choosing that partner.
You are not required to hold to pair programming for this project (i.e. you are allowed to split up the project and work on parts separately).

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

The final project is a programming deliverable in the course, however there won't be the same amount of time for revising after feedback. Because the project is large and open-ended, you will have several opportunities for feedback along the way:
* Project proposal **due 2/18 at 10pm**
* Project initial submission **due 3/2 at 10pm**
* Projects peer review **3/9 in class**
* Final project submission **due 3/11 at 10pm** (plus one hour grace period)

## Assessment
You will be assessed on the following rubric.

### Core
The core requirements for your project are:

* Use the `graphics.py` library to implement a game
* Create at least two classes and use objects from those classes
* Run without errors during basic user interaction
* Have a [`README.txt` report](#project-code-and-report) that includes all required information
* Generally follow the rules described in your `README`

### Advanced
The advanced requirements for your project are:

* Satisfy the core requirements
* Use meaningful interactions between objects, as described below
* *Descriptive* header for each file
* *Descriptive* docstrings for each function and method
* Useful comments
* Descriptive variable names that follow `snake_case`
* Good line grouping and spacing
* Use iteration, conditionals, functions, and classes to organize your program and prevent any unnecessary duplication of code
* Use instance variables and methods effectively
* Have a clear and thorough `README.txt`
* Consistently follow the rules of the game described in your `README`
* You have submitted the partner feedback form (linked through Moodle, assessed individually)

## Project Requirements
Your project must be an object-oriented game and use at least two classes of your own design meaningfully.
You must also include graphics using the [graphics.py](/classes/111-w22/graphics.py) library that you've been provided.
You will find the [documentation for the graphics module](/classes/111-w24/graphics.pdf) helpful and should look through it!

Your game should incorporate **meaningful interaction between objects of your two (or more) classes** (meaning one object causes another object to react differently than it otherwise would have). These classes can be ones that support the graphics component as well.
This requirement is easiest to explain with some examples:
* In [Snake](https://en.wikipedia.org/wiki/Snake_(video_game_genre)), the `Snake` object eats `Food` objects. You could also have a `SnakeHead` object that pulls the `SnakeBody` objects forward
* In Chess, `Pawn` objects can only move forward if they aren't blocked by another piece
* In [Battleship](https://en.wikipedia.org/wiki/Battleship_(game)), `Ship` objects are attacked by the other `Player` object. You could also have a `Board` object that determines if the `Ship` objects are hit or not (and draws or undraws them appropriately).

Remember that your time is limited, so pick a game that you will be able to implement between now and the end of the term. 

**Your game must incorporate [graphics.py](/classes/111-w22/graphics.py)** as the main user interaction. 

### Ideas
To get you started with project ideas, here are some examples that students have successfully implemented in previous offerings of this course:
* [Snake](https://en.wikipedia.org/wiki/Snake_(video_game_genre))
* [Battleship](https://en.wikipedia.org/wiki/Battleship_(game))
* [Connect Four](https://en.wikipedia.org/wiki/Connect_Four)
* [Mastermind](https://en.wikipedia.org/wiki/Mastermind_(board_game))
* [Checkers](https://en.wikipedia.org/wiki/Checkers)
* Simplified farming game, inspired by [Stardew Valley](https://en.wikipedia.org/wiki/Stardew_Valley)
* Simplified sports game

**Note**: You can't do Tic Tac Toe, since we all already did it ;-). Plus, it's too simple for this project.

## Project Proposal
To make sure that you are poised for success, you must write a short proposal of what you plan to do. 
You will submit this through Gradescope as a PDF. 
Your proposal is due by Wednesday 2/18, at 10pm, and should have **clearly indicated sections** answering each of the following questions:

1. Who’s working on the project?
    * If you are working individually, state that
2. What is the game you plan to implement for your final project?
    * Include a brief description of the game and the version of rules that you plan to implement (you don't have to include all the rules of more complex games)
3. What are the (at least) two classes you will implement and what methods will they have? 
4. How will objects of your two classes meaningfully interact with each other?
5. What kind of graphics will be incorporated into your project?
6. What are some "stretch goal(s)" for the project? These are outcomes that you hope to achieve, but that you realize may be too difficult given the time frame and your current programming expertise.

I'll give you feedback on your proposal and let you know if it seems feasible or if I have any concerns.

## Project Peer Review
During class on March 9th, you will present your project draft in a "gallery walk".
I'll provide more details as that approaches, but the basic idea will be that half of you will get your game or simulation running on a lab computer and tell the other half about the project and then we'll switch partway through. 
You'll be required to both present your project and learn about a specific number of other projects.
An initial submission of a basic version of your project will be due **March 2nd at 10pm**, so that you have something in working order for the presentation.
You should aim to have your project at this point be a complete draft so that you can get feedback and show off the cool project that you are working on.

## Project Report
Finally, your programming deliverable will be the code for the project, along with documentation of that code in the form of a report. 
**The report is required!** 
Specifically, you will include a `README` file with your project submission, which will contain your report.  
The `README` file should be named `README.txt`, and it should include the following in **clearly labeled sections**:

1. Your names.
2. The kind of game that you made
3. The rules of the game as you've implemented it (can be simplified from the "real" version)
4. How to play the game
    * This should include information such as what extra files, if any, are needed to run the program. (If your program requires extra files, such as images, please include these with your project submission.)
5. How objects of your two classes meaningfully interact in your game
6. A brief description of any known bugs or issues with the program.

I recommend that you start working on your project as soon as I’ve signed off on your idea. 
Any revisions for the project are due March 11th at 10pm (+1 hour grace window).
You are encouraged to submit sooner than the deadline.

You will submit your project and report through Gradescope.

## Resources
In addition to the normal resources you have for getting help, I recommend you consult the lecture recording and labs from the following days:
* [Graphics Intro Lab](graphics-intro)
* [Creating Flower Classes](creating-classes-lab)
* [Making Simulations](lab-simulations)


