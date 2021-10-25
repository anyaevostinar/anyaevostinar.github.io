---
layout: page
title: Traversals Analysis
permalink: /classes/201-f21/traversal-analysis
---

## Goals
To analyze the time complexity of depth first and breadth first search.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday Nov 1st, but it isn't due until Wednesday Nov 3rd at 5:00pm Central.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday Oct 11th, but it isn't due until Wednesday Oct 13th at 5:00pm Central.

There is no coding in this assignment, so you will submit a PDF of your solutions. You have several options for how to produce this PDF:
* Write it by hand and scan it into a PDF. If you do this, you must write very neatly and clearly. Make sure to check that your scan is completely legible!
* Write it in a word processing program, then export or print it to PDF.
* Write it in LaTeX and typeset it as a PDF. LaTeX is complicated to use at first but allows you to format math very nicely. [Overleaf.com](https://www.overleaf.com/) is a nice website to use for writing LaTeX. 

I recommend just using a word processing program and exporting/printing to PDF!

You should work on this with your in-class partner, but you both need to submit separately and therefore, if you are writing on paper, you both need to be writing your own copies.
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your Collaborations section.

## Exercise 0
Create a Collaborations section of your document and describe any people you get help from on this lab. Also note any outside sources such as websites that you referenced. 

## Exercise 1
First we'll analyze the time complexity of the two graph implementations that you've seen. You are welcome to reference the code from the Graph Implementation activity.

When expressing the time complexity of graph algorithms, use `V` to mean the number of vertices in the graph and `E` to mean the number of edges in the graph.

a. What is the worst case time complexity of adding a vertex in an adjacency matrix graph implementation (without adding any edges)? Express your answer in big-O notation and write a sentence explaining why.

b. What is the worst case time complexity of adding a vertex in an adjacency **list** graph implementation (without adding any edges)? Express your answer in big-O notation and write a sentence explaining why.

c. What is the worst case time complexity of the `getDegree` method of the adjacency matrix graph implementation in big-O notation? Write a sentence explaining why.

d. What is the worst case time complexity of the `getDegree` method of the adjacency list graph implementation in big-O notation? Write a sentence explaining why. Remember to account for the time complexity of the underlying linked list operations!

## Exercise 2
Now we'll analyze the time complexity of depth first search. Remember that for this class, we aren't doing formal proofs of time complexity, but we do want to have some justification for the answers.

a. The algorithm given in "Solving the maze" of HW5 is depth first search. Analyze the number of simple operations that are required at each step of that algorithm. You are welcome to copy the steps from the homework description and then put your analysis on each line.

b. Based on your step-by-step analysis, provide a function that describes the time complexity of the algorithm using `V` for the number of maze squares. (You should not need `E`, make sure you know why!) This function should include the constants and coefficients. 

c. Identify the asymptotic order of the algorithm (the big-O) by finding a C and n<sub>0</sub> and be sure to show your work.

## Exercise 3
Finally, we'll analyze the time complexity of breadth first search. 

a. Analyze the number of simple operations that are required for each step of the algorithm that you implemented in the Breadth First Search lab.

b. Provide a function that describes the time complexity of the algorithm using `V` and `E`.

c. Identify the asymptotic order of the algorithm, be sure to show your work as before.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations section) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. 

Submit your PDF to Moodle as always.