---
layout: page
title: Homework 2 - OOP Practice
permalink: /classes/201-f20/hw2-oop-practice
---

## Logistics
15 points, due Monday, Sept 21st by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy. You need to notify me that you're using the policy. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still Friday, not 48 hours later.

## Goals
To get some practice using and designing classes and gain more experience working with Java.

## Setup
You should complete this assignment on repl.it. Go to our classroom, click on Projects, and then click on HW02: Object Oriented Practice. Make sure the repl is private after you open it.

Create a file Collaborations.txt and put in any help that you get on this assignment including sources that you reference and help from your Collaborative Learning Group. Make sure to refer to the Collaboration page on what collaborations are allowed for homework assignments.

## Specification
For this project you have the opportunity to be creative! Instead of telling you a specific thing to make, since the goal is just to get some practice making a Java class and using it, you can come up with your own example. Below I have listed the things that your code must incorporate, but you are encouraged to go beyond these requirements and have some fun making a small project that is of interest to you. The cool thing about object-oriented programming is that you can simulate nearly anything in the real world, so while I give some example ideas if you are stuck, you really can make a class for anything that interests you.

## Requirements
* Create a new class in its own file, which I'll refer to here at YourClass
* YourClass has and uses at least one private variable
* YourClass tracks how many instances of YourClass have been created (using a class variable)
* Main.java's main creates at least 5 instances of YourClass
* Main takes at least one command line argument and uses it meaningfully
* Either Main or YourClass use a loop meaningfully 
* Either Main or YourClass prints out something useful 
* Follows style guide
* Program has a short description of the class at the top of each class in comments

## Ideas
* Library catalogue where command line argument is how many new books to enter and outputs the average length of the titles entered
* Sport stats calculator where command line argument is how many players to enter and outputs some stat about the players (sorry I don't follow professional sports much!)
* Song recommender where command line argument is type of song someone wants to hear and output is the song of that category 
* Tweak the above ideas to be about cooking recipes, video games, workouts, or anything else that interests you

## Code Notes and Tips
* Remember that you have to construct variables before you use them. If you run into null pointer exceptions or exceptions about not using a variable before it has been initialized, one possible cause is that you have declared a variable (e.g., `List<Integer> list;`) but you haven't assigned it a value (e.g. `list = new ArrayList<>()`).
* Your code should not produce any warnings. Warnings are extra messages from the compiler like:
      ```
      Note: RandomList.java uses unchecked or unsafe operations.
      Note: Recompile with -Xlint:unchecked for details.
      ```
      
If you see a message like this, you should follow the instructions and add `-Xlint:unchecked` after your compiler command.

* If you want to turn a command line argument into something other than a String, you need to use a method to do so. You will probably want either `parseInt(String in)` or `parseDouble(String in)`:
```
    int myInt = Integer.parseInt("1");
    double myDouble = Double.parseDouble("1.0");
```

## Rubric

| Item | Points |
| ------ | -------- |
| Compiles without warnings and runs | 2 |
| New class created correctly | 1 |
| Private variable used correctly | 2 |
| Class variable used correctly | 1 |
| 5 instances of class created correctly | 1 |
| Command line argument used correctly | 1 |
| Loop used correctly | 1 |
| Useful output | 1 |
| Sufficient documentation | 3 |
| Follows style guide | 2 |
