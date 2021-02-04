---
layout: page
title: Recursion Review
permalink: /classes/201-w21/recursion
---

## Goals
To refresh on thinking recursively and writing recursive code.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Wednesday Feb 10th, but it isn't due until Friday Feb 12th at 5:00pm Central.

Open the Recursion Lab on Repl.it.

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced. If you do not collaborate or check any outside websites, you should state that in Collaborations.txt.

## Exercise 1
The website [CodingBat](https://codingbat.com/) has several good practice problems for recursion. Solve the [bunny ears](https://codingbat.com/prob/p107330) problem. You can type your code either in Repl or the website, but you should test your code on the website and then paste your solution into your Repl file in `Main.java`

## Exercise 2
Write a recursive function that performs exponentiation: it should return a<sup>b</sup> for input parameters `a` and `b`, which are both positive integers. You should not use built-in exponentiation and are limited to only using multiplication.

## Exercise 3
The Fibonacci sequence is the sequence 0, 1, 1, 2, 3, 5, 8, 13,... where the number at index k is equal to the sum of the numbers at k−1 and k−2. Write a recursive function for calculating the kth Fibonacci number that does as little repeated work as possible.

The way the reading does it repeats a lot of work, so instead you should implement a version that counts up instead of down to reduce the amount of work. You should start with a method signature:
```
public static int fibonacci(int index, int curValue, int prevValue, int targetIndex)
```

where `targetIndex` is `k` and `index` starts at a small number to track where you currently sequence.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. 

Submit your zip file to Moodle as always.

## Extensions
* There are several more recursion activites on CodingBat to try if you'd like more practice with recursion.