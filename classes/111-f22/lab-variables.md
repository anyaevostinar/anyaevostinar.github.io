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
For each of the following code snippets, predict answers to the following:
* When will evaluation of each variable occur?
* What value(s) will each variable be assigned?
* What will the reference diagram look like?

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=x%20%3D%201%20%2B%201%0Ay%20%3D%203%20%2B%200%0Az%20%3D%20x%20%2B%20y%0Aprint%28z%29&codeDivHeight=400&codeDivWidth=350&cumulative=true&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=a%20%3D%202%0Ab%20%3D%20a%0Aa%20%3D%20a%20%2B%203%0Aprint%28a,%20b%29&codeDivHeight=400&codeDivWidth=350&cumulative=true&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>


In this last snippet, PythonTutor reorders the values a bit strangely (and unnecessarily), but the values are still correct, so be sure to go through the steps slowly to catch that and be sure of what is happening.
<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=variable1%20%3D%2010%0Avariable2%20%3D%20variable1%0Avariable1%20%3D%20variable2%20-%203%0Avariable2%20%3D%20variable1%20%2B%205%0Avariable1%20%3D%2010%0Avariable3%20%3D%20variable2%0Avariable4%20%3D%201%0Avariable3%20%3D%20variable3%20-%202&codeDivHeight=400&codeDivWidth=350&cumulative=true&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

## Exercise 3
The word 'variable' is used in mathematics, programming, and everyday speech and each use is slightly different.
List out as many similarities and differences as you can between what 'variable' means in each of these contexts.

## Exercise 4
Consider a bizarro alternate universe in which an hour is 47 minutes long. Each day still has 24 hours and each year still has 365 days (you can ignore leap years).

Write a Python program that will print out how many minutes longer a year is in the 60-minute universe than in the 47-minute universe.
Extend your program to print out how many days that value is equal to (in both worlds).

## Exercise 5
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