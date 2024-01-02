---
layout: page
title: Building Blocks Lab 
permalink: /classes/111-w24/building-blocks
---

Make a folder for today's lab in COURSES ([here are the instructions from the previous lab](getting-started)).

## Exercise 1
Work through the expressions listed below, one at a time, with your partner. For each expression, you should work together to predict a) the value produced by the expression, and b) the data type of that value. **Write down your predictions on the worksheet.** For instance, the expression `2 + 2` produces the value 4, which has the type `int` (for integer). Once you’ve made your prediction(s) for an expression, **type in the corresponding Python code to see if you’re right and write down the actual output** and type on your worksheet.

The easiest way to test your predictions will be to type in the code in an interactive session with the Python interpreter. As a reminder, you can start an interactive session with a Python interpreter by typing the command `python3` in Terminal, which you can pull up from the bottom of VSCode. To check the type of the value produced by an expression, use a command like `type(2 + 2)` (this will return the value `int`). 

Can you explain any of them that you may have gotten wrong? Wave Anya or Mika over to ask about any that seem surprising or don't make sense!

```
5 / 2
5 // 2
5 ** 2
5 % 2
5 // 2.0
2 * 3 
2 * float(3)
6 / 2
int(6 / 2)
int(3.5) * 2
int(3.5) * 2.0
round(3.5) % 2
36 % 5
36 % 5.0
6 / 3
int(6 / 3)
6 // 3
6.0 // 3
5.3 % 4
```

## Exercise 2
Sometimes it is useful to add and subtract times. For example, if you are trying to measure a runner’s lap time, you might record the start time and the end time for the lap and use that information to find the amount of time that elapsed.

Write some code that asks the user for four integer inputs:
* The minutes of the start time.
* The seconds of the start time.
* The minutes of the end time.
* The seconds of the end time.

Your code should then calculate the difference between the end time and start time, and print out the elapsed time in minutes and seconds.

Note that the seconds should be a value between 0 and 59, which means simply subtracting minutes and seconds will not work! Think carefully about what you need to calculate here, and perhaps write out the algorithm on your worksheet or in comments before trying to code it up. 

Hint: consider what you may be able to do with the `//` (integer division) and `%` (modulo) operators.

Try to come up with test input that will check for all the types of cases that your code should be able to handle (for example, input that would have messed up the strategy of just subtracting the minutes and seconds).


## Extra
If you finish early, work on some of the [end of chapter exercises](https://runestone.academy/ns/books/published/intro-cs/SimplePythonData/Exercises.html) for more practice.

## Acknowledgements
This lab is adapted from labs by Profs. James Ryan and Eric Alexander.