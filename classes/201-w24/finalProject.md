---
layout: page
title: Final Project
permalink: /classes/201-w24/final-project
---

## Overview
For your final project, you’ll be working on a program of your own design with or without a partner. 
The goals of this assignment are to synthesize the knowledge about many different data structures learned in the class by 1) choosing the most appropriate data structure for an interesting task, 2) using the Java built-in versions of these data structures, and 3) using inheritance correctly and meaningfully.

## Logistics
You have the option of working with a partner for the final project and choosing that partner. You are not required to hold to pair programming for this project (i.e. you are allowed to split up the project and work on parts separately).

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

The final project is a programming deliverable in the course, however there won’t be the same amount of time for revising after feedback. Because the project is large and open-ended, you will have several opportunities for feedback along the way:

* Project proposal due Wednesday 2/28 at 10pm
* Project peer review Wednesday 3/6 in class
* Project initial submission Wednesday 3/6 at 10pm
* Final submission due Wednesday 3/13 at 6pm (hard deadline!)

## Requirements
The final project is purposefully open-ended so that you can implement software that is of interest to you. Your task is to implement a medium-sized (slightly larger than a homework) piece of software that does something interesting and substantial using inheritance and some of the other concepts we've learned about this term. Your project can be basically anything that incorporates the requirements below, but here are a couple of broad ideas to get you started:

* A board game (not a full AI of course, but allowing for two users at the same computer to play the game, or even just single player!)
* A simulation of some kind (my [research software is an example](https://anyaevostinar.github.io/SymbulationEmp/web/symbulation.html), though yours wouldn't have a GUI, here is [an example assignment](https://github.com/anyaevostinar/alife-assignment/tree/master) that does something similar, but you'd need to expand on it)

### Inheritance
If you took CS111, this may sound fairly familiar, so it is important to keep in mind that this needs to be an object-oriented project that uses classes and objects effectively. In particular, inheritance (using `extends`) is a major concept in this course that your project must use meaningfully. 

Your project **must** incorporate at least one superclass with at least **two** meaningful subclasses. It would be great for you to have more, but you absolutely need to have at least two. This means using the `extends` keyword, NOT `implements` (which would be an interface, NOT inheritance).

### Other class concepts
Your project must also correctly and efficiently use the Java built-in version (if there is one) of at least **two** of the concepts from this list:

* [HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
* Stack or Queue using a [Deque](https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html)
* Graph (doesn't have a Java built-in so use the code from [HW8](hw8))
* Breadth-first search (see above)
* Sorting (use Java built-in [sort](https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html))
* One of the various trees we've seen (there aren't built-in Java ones)
* [PriorityQueue](https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html)

## README
As always, you should include a detailed README for this project. 
It should include a brief overview of your project, a short example of how to run your program and see its interesting behavior, and a more detailed section that has **demonstration input or code/line numbers for each of the coding-related rubric items**. Remember, you want to make it as easy as possible for the grader to see that your project does everything its supposed to!


### Prompt
Your README should also have a clearly labeled section that answers the following questions:

* What does your project do that is interesting and substantive?
* Why is inheritance useful for your previously specified superclass and subclasses?
* For each of the two additional previously-specified class concepts that you used, why is that concept the best to use in your project?

Your README may include additional information as appropriate, perhaps sample plots or output depending on the goals of your software, but you must make it clear where your answers to the above questions are.

## Getting Help
Because of the open ended nature of this project, I strongly encourage you to check with me on your ideas early on. I will be providing class time to discuss ideas with me and your classmates and you are also welcome to email me, schedule a one on one meeting, or come to drop-in office hours. 

## Grading
Your project will be assessed on the following rubric:

### Proficiency
To demonstrate proficiency, your project must:

* Compile and run without error under normal conditions
* Have at least one superclass and two subclasses
* Use at least two other class concepts from the list
* Be at least a medium-sized piece of software (slightly larger than a homework)
* Be object-oriented
* Have a README with an overview, examples, and prompt responses
* Have JavaDocs documentation for all public methods
* Be somewhat [well-styled](style-reference)

### Mastery
To demonstrate mastery, your project must:
* Meet proficiency requirements
* Efficiently and effectively use inheritance and object-oriented programming
* Efficiently and effectively use at least two other class concepts
* Use helper methods correctly and effectively
* Be extremely [well-styled](style-reference) and clear by choosing descriptive variable names and including only useful comments 
* Have a thorough, well-styled README 
* Have clear and thorough documentation
