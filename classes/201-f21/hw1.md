---
layout: page
title: Homework 1 - OOP Practice
permalink: /classes/201-f21/hw1-oop-practice
---

## Logistics
25 points, due Friday, Sept 24th by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy. You or your partner need to notify me that you're using the policy via email, CC'ing the partner. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still Friday, not 48 hours later.

You must work on this homework with your assigned partner (if you have one) via pair programming. That means that you cannot write **any** code without your partner and you must both be fully engaged and discussing the code at all times while working. See the [collaboration policy](collaboration) for details.

## Goals
Demonstrate your understanding of private and class variables, ability to create objects of your own making, and use other Java functionality.

## Setup
Create a folder for HW1 on the COURSES drive. Remember to save here so that you don't lose your work!

Create a file Collaborations.txt and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.

## Specification
For this project you have the opportunity to be creative! Instead of telling you a specific thing to make, since the goal is just to get some practice making a Java class and using it, you can come up with your own example. Below I have listed the things that your code must incorporate, but you are encouraged to go beyond these requirements and have some fun making a small project that is of interest to you. The cool thing about object-oriented programming is that you can simulate nearly anything in the real world, so while I give some example ideas if you are stuck, you really can make a class for anything that interests you.

## Requirements
* Create a new class in its own file, which I'll refer to here at `YourClass`
* `YourClass` has and uses at least one private variable
* `YourClass` tracks how many instances of `YourClass` have been created (using a class variable which uses the `static` keyword!) and uses that number
* `YourClass`'s `main` creates at least one instance of `YourClass` (more would be great!)
* `main` takes at least one command line argument and uses it meaningfully
* `YourClass` takes user input while the program is running and uses it meaningfully (not sure how? Check the [Jumping into Java](jumping_java) reading)
* `YourClass` prints out something useful 
* Follows style guide
* JavaDocs-style method comments for all public methods

## Ideas
* Library catalog
* Sport stats displayer
* Song recommender
* Tweak the above ideas to be about cooking recipes, video games, workouts, or anything else that interests you

## Code Notes and Tips
* Command line arguments are what is captured in `args` in your `main(String[] args)` function, NOT just user input after the program is running!
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
(Add this to your reference sheet!)

## Rubric

| Item | Points |
| ------ | -------- |
| Compiles without warnings and runs | 4 |
| New class created correctly | 3 |
| Private variable used correctly | 3 |
| Class variable used correctly | 4 |
| Instance of class created correctly | 2 |
| User input used correctly | 2 |
| Command line argument used correctly | 2 |
| Useful output | 1 |
| Sufficient JavaDocs-style documentation | 2 |
| Follows style guide | 2 |

## Submitting
Remember to update your Collaborations.txt file with any sources that you consulted.

Then make a .zip of your files and upload it to Moodle.