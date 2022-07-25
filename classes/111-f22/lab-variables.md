---
layout: page
title: Variables Lab 
permalink: /classes/111-f22/variables
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and quizzes so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
Debugging poorly written and buggy code is a valuable skill.
To help you practice it, I've written a painfully bad program called `bad.py` (or is it??) that attempts to convert Celsius temperature to Fahrenheit.
That calculation should be `(C * 9/5) + 32` where `C` is the value in Celsius.
Download [this code](bad-1.py), move it to your folder for today, and open it in VSCode.

This code is both badly styled, making it very difficult to read, and has a bug or two.
You should aim to improve it, which will probably involve:
* Drawing out a memory diagram of what is going on with each of the variables
* Fixing variable names
* Getting it to output something
* Fixing a logical bug
* Making the variable names useful and rearranging things
* Writing comments and documentation

## Exercise 2
Consider a bizarro alternate universe in which an hour is 47 minutes long. Each day still has 24 hours and each year still has 365 days (you can ignore leap years).

Write a Python program that will print out how many minutes longer a year is in the 60-minute universe than in the 47-minute universe.
Extend your program to print out how many days that value is equal to (in both worlds).

## Exercise 3
Sometimes it is useful to add and subtract times. For example, if you are trying to measure a runner’s lap time, you might record the start time and the end time for the lap and use that information to find the amount of time that elapsed.

Write some code that asks the user for four integer inputs:
* The minutes of the start time.
* The seconds of the start time.
* The minutes of the end time.
* The seconds of the end time.

Your code should then calculate the difference between the end time and start time, and print out the elapsed time in minutes and seconds.

Note that the seconds should be a value between 0 and 59, which means simply subtracting minutes and seconds will not work! Think carefully about what you need to calculate here, and perhaps write out the algorithm on paper or in a text file before you attempt to code it up. 

Hint: consider what you may be able to do with the `//` (integer division) and `%` (modulo) operators.

Try to come up with test input that will check for all the types of cases that your code should be able to handle (for example, input that would have messed up the strategy of just subtracting the minutes and seconds).


## Acknowledgements
This lab is adapted from labs by Profs. James Ryan and Eric Alexander.