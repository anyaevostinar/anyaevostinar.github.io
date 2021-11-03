---
layout: page
title: Final Project
permalink: /classes/201-f21/final-project
---

## Logistics
100 points (25% of final grade), due Wednesday Nov. 24th by **5pm** Central time. Any request for an extension **must go through the Dean of Students office** as I am not otherwise permitted to consider work submitted after this college-wide deadline!

## Goals
To synthesize the knowledge about many different data structures learned in the class by 1) choosing the most appropriate data structure for an interesting task, 2) using the Java built-in versions of these data structures, and 3) using inheritance correctly and meaningfully.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You must work on this homework with your assigned partner (if you have one) via pair programming. That means that you cannot write **any** code without your partner and you must both be fully engaged and discussing the code at all times while working. See the [collaboration policy](collaboration) for details.

## Setup
Mount COURSES and create a folder `FinalProject` in your STUWORK/username folder (there is no starter code). You should follow the same process of compressing all of your files and uploading them to Moodle to submit your homework. 

Create a file `Collaborations.txt` and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.

## Requirements
The final project is purposefully open-ended so that you can implement software that is of interest to you. Your task is to implement a medium-sized (slightly larger than a homework) piece of software that does something interesting and substantial using inheritance and some of the other concepts we've learned about this term. Your project can be basically anything that incorporates the requirements below, but here are a couple of broad ideas to get you started:

* A board game (not a full AI of course, but allowing for two users at the same computer to play the game, or even just single player!)
* A simulation of some kind (my [research software is an example](https://anyaevostinar.github.io/SymbulationEmp/web/symbulation.html), though yours wouldn't have a GUI, here is [an example assignment](https://github.com/anyaevostinar/alife-assignment/tree/master) that does something similar, but you'd need to expand on it))

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

Remember that you should use Word or Google Docs or Markdown to make a nicely formatted README. 
You should not have a README in plain text!


### Prompt
Your README should also have a clearly labeled section that answers the following questions:

* What does your project do that is interesting and substantive?
* Why is inheritance useful for your previously specified superclass and subclasses?
* For each of the two additional previously-specified class concepts that you used, why is that concept the best to use in your project?

Your README may include additional information as appropriate, perhaps sample plots or output depending on the goals of your software, but you must make it clear where your answers to the above questions are.

## Getting Help
Because of the open ended nature of this project, I strongly encourage you to check with me on your ideas early on. I will be providing class time to discuss ideas with me and your classmates and you are also welcome to email me, schedule a one on one meeting, or come to drop-in office hours. 

## Grading
Your project will be graded on the following rubric:

|Item | Points |
|------|--------|
|Correct and efficient use of inheritance with at least one superclass and two subclasses | 25 |
|Correct and efficient use of two other class concepts | 25 |
|Sufficiently substantive project | 20 |
|README complete and clear | 20 |
| Good style and organization, including JavaDocs style methods comments | 10 |