---
layout: page
title: Final Project
permalink: /classes/201-w21/final-project
---

## Logistics
100 points (25% of final grade), due Monday March 15th by **5pm** Central time. Any request for an extension must go through the Dean of Students office as I am not otherwise permitted to consider work submitted after this college-wide deadline!

## Goals
To synthesize the knowledge about many different data structures learned in the class by choosing the most appropriate for an interesting task and practice using the Java built-in versions of these data structures in addition to using inheritance correctly and meaningfully.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You're welcome to either complete this homework with input from one or more members of your collaborative learning group or to complete it on your own. You and the other members of your collaborative learning group should each write your own code, even if you're helping one another, but you may share your screens to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Setup
Open the Final Project Repl. You should follow the same process of downloading your files and uploading them to Moodle to submit your homework. 

Create a file Collaborations.txt and put in any collaboration with your learning group or references to outside websites.

## Requirements
The final project is purposefully open-ended so that you can implement software that is of interest to you. Your task is to implement a medium-sized (slightly larger than a homework) piece of software that does something interesting and substantial using inheritance and some of the other concepts we've learned about this term. Your project can be basically anything that incorporates the requirements below, but here are some ideas to get you started:

* A board game (not a full AI of course, but allowing for two users at the same computer to play the game, or even just single player!)
* A simulation of some kind (my [research software is an example](https://anyaevostinar.github.io/SymbulationEmp/web/symbulation.html), though yours wouldn't have a GUI, here is [an example assignment](https://github.com/anyaevostinar/alife-assignment/tree/master) that does something similar, but you'd need to expand on it))

### Inheritance
If you took CS111, this may sound fairly familiar, so it is important to keep in mind that this needs to be an object-oriented project that uses classes and objects effectively. In particular, inheritance (using `extends`) is a major concept in this course that your project must use meaningfully. 

Your project **must** incorporate at least one superclass with at least **two** meaningful subclasses. It would be great for you to have more, but you absolutely need to have at least two. This means using the `extends` keyword, NOT `implements` (which would be an interface, NOT inheritance).

### Other class concepts
Your project must also correctly and efficiently use the Java built-in version (if there is one) of at least one of the concepts from this list:

* [HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
* Stack or Queue using a [Deque](https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html)
* Graph (doesn't have a Java built-in so use the code from [HW5](https://anyaevostinar.github.io/classes/201-w21/hw5))
* Breadth-first search (see above)
* Sorting (use Java built-in [sort](https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html))
* One of the various trees we've seen (there aren't built-in Java ones)
* [PriorityQueue](https://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html)


## Report
You must include in the zip of your code a report that answers the following questions:

* What does your project do that is interesting and substantive?
* How do I run your project to see it's interesting and substantive behavior?
* What are the superclass and two subclasses your project uses?
* Why is inheritance useful for your superclass and subclasses?
* What is the other class concept your project uses?
* Why is that concept the best to use in your project?

Your report may include additional information as appropriate, perhaps sample plots or output depending on the goals of your software, but you must make it clear where your answers to the above questions are.

## Getting Help
Because of the open ended nature of this project, I strongly encourage you to check with me on your ideas early on. I will be providing class time to discuss ideas and check with me and you are also welcome to email me, schedule a one on one meeting, or come to drop-in office hours. 

## Grading
Your project will be graded on the following rubric:

|Item | Points |
|------|--------|
|Correct and efficient use of inheritance with at least one superclass and two subclasses | 25 |
|Correct and efficient use of other class concept | 25 |
|Sufficiently substantive project | 20 |
|Report answers questions thoroughly | 18 |
| Good style and organization, including JavaDocs style methods comments | 12 |