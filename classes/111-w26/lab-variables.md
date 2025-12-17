---
layout: page
title: Variables Lab 
permalink: /classes/111-f24/variables
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and quizzes so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in [COURSES as you usually do](getting-started).

## Exercise 1
Debugging poorly written and buggy code is a valuable skill.
To help you practice it, I've written a painfully bad program called `bad.py` (or is it??) that attempts to convert Celsius temperature to Fahrenheit.
That calculation should be `(C * 9/5) + 32` where `C` is the value in Celsius.
Download [this code](/classes/111-w24/bad-1.py), move it to your folder for today, and open it in VSCode.

This code is both badly styled, making it very difficult to read, and has a bug or two.
You should aim to improve it, which will probably involve:
* Drawing out a memory diagram of what is going on with each of the variables
* Fixing variable names
* Getting it to output something
* Fixing a logical bug
* Making the variable names useful and rearranging things
* Writing comments and documentation

Draw your reference diagram on the worksheet.

## Exercise 2
For each of the following code snippets, predict answers to the following:
* When will evaluation of each variable occur?
* What value(s) will each variable be assigned?
* What will the reference diagram look like?

Be sure to draw your reference diagrams on the worksheet.

Then click through the steps to check your predictions and figure out anything that you got wrong.

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=x%20%3D%201%20%2B%201%0Ay%20%3D%203%20%2B%200%0Az%20%3D%20x%20%2B%20y%0Aprint%28z%29&codeDivHeight=400&codeDivWidth=350&cumulative=true&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=a%20%3D%202%0Ab%20%3D%20a%0Aa%20%3D%20a%20%2B%203%0Aprint%28a,%20b%29&codeDivHeight=400&codeDivWidth=350&cumulative=true&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>


In this last snippet, PythonTutor reorders the values a bit strangely (and unnecessarily), but the values are still correct, so be sure to go through the steps slowly to catch that and be sure of what is happening.
<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=variable1%20%3D%2010%0Avariable2%20%3D%20variable1%0Avariable1%20%3D%20variable2%20-%203%0Avariable2%20%3D%20variable1%20%2B%205%0Avariable1%20%3D%2010%0Avariable3%20%3D%20variable2%0Avariable4%20%3D%201%0Avariable3%20%3D%20variable3%20-%202&codeDivHeight=400&codeDivWidth=350&cumulative=true&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

## Exercise 3
The word 'variable' is used in mathematics, programming, and everyday speech and each use is slightly different.
List out as many similarities and differences as you can between what 'variable' means in each of these contexts on the worksheet.

## Exercise 4
Consider a bizarro alternate universe in which an hour is 47 minutes long. Each day still has 24 hours and each year still has 365 days (you can ignore leap years).

Write a Python program that will print out how many minutes longer a year is in the 60-minute universe than in the 47-minute universe.
Extend your program to print out how many days that value is equal to (in both worlds).


## Extra
If you finish early, work on some more of the [end of chapter exercises](https://moodle.carleton.edu/mod/lti/view.php?id=961111) for more practice.


## Acknowledgements
This lab is adapted from labs by Profs. James Ryan and Eric Alexander.