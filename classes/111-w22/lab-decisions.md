---
layout: page
title: Decisions Lab 
permalink: /classes/111-w22/decisions
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1

Say the policy for speeding tickets in Northfield is $50, plus $5 for each mph over the limit, plus an extra penalty of $200 for any speed over 90 mph.

* Create a file called `speeding.py` containing a program that accepts a speed limit and a clocked speed and either prints a message indicating that the speed was legal or prints the amount of the fine if the speed was illegal.

* In order to see if your program works, come up with a list of test inputs that account the variety of different values a user might provide. In the comments at the top of `speeding.py`, list these input values and the result that gets printed to the screen.


## Exercise 2
A formula for computing Easter in the years 1982–2048, inclusive, is as follows. Let:

* a = year % 19
* b = year % 4
* c = year % 7
* d = (19a + 24) % 30
* e = (2b + 4c + 6d + 5) % 7

The date of Easter is March 22 + d + e (which could be in April).

* Create a file called `easter.py` that inputs a year, verifies it is in the proper range, and then prints out the date of Easter that year.
* The above formula works for every year inside the range 1900-2099 except for 1954, 1981, 2049, and 2076. For these four years, it produces a date that is one week too late. Modify your program to work for the entire range 1900-2099.
* Identify a list of test inputs for your program to verify that it works for the variety of values that a user might provide. In the comments of `easter.py`, list these input values and the results that get printed to the screen.
* You may have ended up with a lot of repeated code in the process of making modifications. It's always good to 'refactor' your code after you complete a first draft by going and trying to streamline and improve it. See what repeated code you can streamline, if any.

## Exercise 3
In a file called `validDate.py`:

1. Write a program that accepts a date in the form of a month, a day, and a year, and outputs whether or not the date is valid. For example, 5/24/1988 is valid, but 9/31/2000 is not. (September has only 30 days.)
(Note: you can either take the number in the form <month>/<day>/<year> and parse the string, or just use three input statements.)
It may help to know that a year is a leap year if it is divisible by 4, unless it is a century year that is not divisible by 400. (1800 and 1900 are not leap years while 1600 and 2000 are.)

2. Identify a list of test inputs for your program to verify that it works for the variety of values that a user might provide. In the comments of `validDate.py`, list these input values and the results that get printed to the screen.

## Acknowledgements
These exercises are adapted from a lab by Prof. Eric Alexander and problems from Python Programming: An Introduction to Computer Science by John Zelle.