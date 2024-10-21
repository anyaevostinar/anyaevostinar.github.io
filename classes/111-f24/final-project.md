---
layout: page
title: Final Project 
permalink: /classes/111-w24/final-project
---
## Overview
For your final project, you’ll be working on a program of your own design with or without a partner. 
To provide some structure, I’ll be expecting projects of a specific type discussed below. 
**Your project code must be object-oriented, meaning it centers on the use of one or more classes that you have created and it must use the provided graphics.py library.**
It’s okay to have additional functions, too, but your core functionality should be handled by classes.

(This project description has been adapted, with permission, from earlier descriptions by Profs. Amy Csizmar Dalal, Titus Klinge, James Ryan, and Eric Alexander.)

## Logistics
You have the option of working with a partner for the final project and choosing that partner.
You are not required to hold to pair programming for this project (i.e. you are allowed to split up the project and work on parts separately).

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

The final project is a programming deliverable in the course, however there won't be the same amount of time for revising after feedback. Because the project is large and open-ended, you will have several opportunities for feedback along the way:
* Project proposal **due 11/11 at 10pm**
* Project initial submission **due 11/15 at 10pm**
* Projects peer review **11/18 in class**
* Project revisions **due 11/25 at 8:30pm**

## Assessment
You will be assessed on the following rubric.

### Proficiency
To demonstrate proficiency, your project must:

* Use the `graphics.py` library
* Create at least two classes
* Run without errors during basic user interaction
* Have a `README.txt` report that includes all required information

### Mastery
To demonstrate mastery, your program must meet all the 'proficiency' requirements, as well as:

* Use meaningful interactions between objects, as described below
* *Descriptive* header for each file
* *Descriptive* docstrings for each function and method
* Useful comments
* Descriptive variable names that follow `snake_case`
* Good line grouping and spacing
* Use iteration, conditionals, functions, and classes to organize your program and prevent any unnecessary duplication of code
* Use instance variables and methods effectively

## Project Requirements
Your project must be an object-oriented game and use at least two classes of your own design meaningfully.
You must also include graphics using the graphics.py library that you've been provided.
You will find the [documentation for the graphics module](/classes/111-w24/graphics.pdf) helpful and should look through it!

Your game should incorporate **meaningful interaction between objects of your two (or more) classes** (meaning one object causes another object to react differently than it otherwise would have). These classes can be ones that support the graphics component as well.
This requirement is easiest to explain with some examples:
* In [Snake](https://en.wikipedia.org/wiki/Snake_(video_game_genre)), the Snake object eats Food objects. You could also have a SnakeHead object that pulls the SnakeBody objects forward
* In Chess, Pawn objects can only move forward if they aren't blocked by another piece
* In [Battleship](https://en.wikipedia.org/wiki/Battleship_(game)), Ship objects are attacked by the other Player object. You could also have a Board object that determines if the Ship objects are hit or not.

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


## Project Proposal
To make sure that you are poised for success, you must write a short proposal of what you plan to do. 
You will submit this through Gradescope (it's a fill in the blank on Gradescope assignment, so you don't need to create a separate document first, though you can). 
Your proposal is due by Wednesday Feb 28th, at 10pm, and will include the following components:

* Who’s working on the project, and how you plan to divide the work.
* The game or simulation you plan to implement for your final project. Include a brief description of the game and its rules (or, for a simulation, what you aim to model and a basic overview of how it will run).
* A brief development plan: what sort of classes and methods you will need to write and generally how these will work together.
* What kind of graphics will be incorporated into your project.
* A description of your primary outcome(s) for the project. I’ll raise concerns if these outcomes seem too ambitious or not ambitious enough.
* A description of your stretch goal(s) for the project. These are outcomes that you hope to achieve, but that you realize may be too difficult given the time frame and your current programming expertise.

After confirming the details and making sure you’re poised to succeed, I’ll officially sign off on your project, which means you’re free to start working on the project. **Feel free to submit this early and I will be aiming to get feedback to you sooner than the due date.**

## Project Peer Review
During class on March 6th, you will present your project draft in a "gallery walk".
I'll provide more details as that approaches, but the basic idea will be that half of you will get your game or simulation running on a lab computer and tell the other half about the project and then we'll switch partway through. 
You'll be required to both present your project and learn about a specific number of other projects.
An initial submission of a basic version of your project will be due **March 4th at 10pm**, so that you have something in working order for the presentation.
I will be aiming to get feedback back to you quickly on this initial submission so that you can make revisions before the end of term.
You should aim to have your project at this point be a first draft so that you can get feedback and show off the cool project that you are working on.

## Project Code and Report
Finally, your programming deliverable will be the code for the project, along with documentation of that code in the form of a report. 
**The report is required!** 
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
* How to play the game (also describe the game rules) and/or how to run the simulation. This should include information such as what extra files, if any, are needed to run the program. (If your program requires extra files, such as images, please include these with your project submission.)
* A brief description of any known bugs or issues with the program.

I recommend that you start working on your project as soon as I’ve signed off on your idea. 
Any revisions for the project are due March 13th at 6pm and no extensions are possible except through the Dean of Students office.
You are encouraged to submit sooner than the deadline and I will be aiming to get feedback on early submissions before the deadline.

You will submit your project and report through Gradescope.

## Resources
In addition to the normal resources you have for getting help, I recommend you consult the lecture recording and labs from the following days:
* [Graphics Intro Lab](graphics-intro)
* [Creating Flower Classes](creating-classes)
* [Making Simulations](lab-simulations)


