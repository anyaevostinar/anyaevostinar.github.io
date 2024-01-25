---
layout: page
title: HW 5 Experiments with Quicksort
permalink: /classes/201-w24/hw5
---

## Logistics
You will be able to start the code for this assignment with a partner, however the bulk of the assignment will be done individually.
Specifically, you can implement the `MedianOf3PivotSelector` class with your in-class partner. However, the rest of the assignment (conducting experiments and writing the memo) must be completed individually and treated as an individual homework assignment. See the [collaboration policy](collaboration) for details.

This assignment is due on Friday Feb 9th at 10pm. As with all assignments, you will have the opportunity to revise this assignment individually based on the feedback that you get.

## Goals
To study the performance characteristics of quicksort with several different pivot choices and hone your analysis skills.

## Setup and Requirements
Mount COURSES, download the [HW5 starter code](HW5Starter.zip) and move it to your StuWork/username folder.

Create a file `Collaborations.txt` and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.
In particular, make sure to record the name of your in-class partner in the `Collaborations.txt`.

In this assignment, you'll be doing a mixture of coding, designing timing experiments, and analyzing your results. You'll be thinking through what timing data makes sense to collect, and writing your reasoning in a short report. You will need to create a PDF file with your report and include it with your code.

## Provided Code
There are a variety of different ways that the pivot can be selected in quicksort. In this investigation, you'll explore the consequences of the pivot selection method on quicksort's run time.

I've provided you with an implementation of quicksort in `Quicksort.java`. The public quicksort method takes in two arguments: an array of `int`s to sort and a `PivotSelector` instance. `PivotSelector` is an interface that I've provided that has one method: `choosePivotIndex`, which returns the **index** (not value!) of the `int` that we'll use as the pivot. Your job is to examine how variations in pivot selection impact run time for different arrays. I've included an example of how to collect timing data in `main` of `Quicksort.java`, and you'll change or replace my code to collect the data that you want.

You should first compile everything and run the `Quicksort.java` file to see what it does.

## MedianOf3PivotSelector

Your next task is to implement a new `PivotSelector` named `MedianOf3PivotSelector` in its own `.java` file. It should return the **index** of the median of the first, middle, and last **elements** between indices `first` and `last` in the array.

You should be sure to test your pivot selector, for example:
```
MedianOf3PivotSelector test = new MedianOf3PivotSelector();
int[] array = {20, 0, 10};
System.out.println(test.choosePivotIndex(array, 0, 2)); // Should print 2
```

I highly recommend you upload your `MedianOf3PivotSelector` to Gradescope at this point to be sure that it passes the tests and your implementation is behaving as expected. (You really don't want to run all your experiments and find out afterward that your implementation was incorrect.)

## Experimenting
(Remember that this portion of the homework must be completed individually.)

Now you should change the code in `main` of `Quicksort.java` to test all three pivot selector approaches on a variety of arrays, including those with:

* varying numbers of duplicate items
* varying amounts of sortedness (in both directions)
* varying lengths 

You can use many different array sizes to explore the questions in this assignment. Make sure the arrays you're choosing are big enough to show real differences. If all of your experiments take only 1 or 2 milliseconds, it will be very hard to understand how your variations are related to differences in timing. Instead, use an array that's big enough to take at least hundreds of milliseconds to sort.

## Memo
(Remember that this portion of the homework must be completed individually.)

You should now write an approximately 2 page (single-spaced) memo recommending which pivot selection method should be used and presenting evidence to support your position. Your evidence might include plots and/or tables of timing data. The page number recommendation includes any charts and plots; it can be shorter as long as you communicate all of the needed information, it can also be longer if you would like. (Tldr: I expect that to answer the prompt, you'll need about 2 pages, but it isn't a hard rule.)

Your memo should assume that average run time is the most important consideration, but if run times are similar, it might discuss other reasons to prefer or disprefer a particular method. The memo should at least briefly discuss:
* whether the length of the array to sort influences which selection method to choose
* whether characteristics of the numbers in the array (e.g., many duplicates) impact which selection method to choose
* whether the numbers initial ordering (e.g., degree of sortedness) impacts which selection method to choose

In your report, you should describe the timing experiments you performed and the data you collected. You should make sure to explain how the evidence you collected supports your claims, and explain your choices about what evidence to collect for each question. I encourage you to think carefully about how to connect evidence and explanations. Imagine your report is intended to help someone make decisions related to this investigation - what information do they need to know? Why do you think the timing data looks the way it does based on what you know about how the algorithm works? You should try to design your experiments in a way that will be convincing to the reader. How could you compensate for the fact that timing data is "noisy," with the same code sometimes taking a little longer or shorter to run? You're welcome to chat with me or your prefect about your approach.

Your memo will be evaluated based on its clarity and how well you use evidence to support your claims, including whether you collected appropriate evidence for those claims. Your evidence collection will be evaluated based on your descriptions.

You must turn your memo into a PDF for submission and name it `Memo.pdf`.

## README
As always, you should include a README for this homework, though it will be shorter than normal and focused on the `MedianOf3PivotSelector`. 
It should include a brief overview of the code, and a short example of how to run your program and see its interesting behavior.

## Assessment
To demonstrate proficiency, your submission needs to:

* Pass all tests on Gradescope
* Memo demonstrates analysis of the effects of the length of the array, the initial ordering, and duplicated items
* Memo makes recommendation of which pivot approach to use and explains why evidence supports that claim
* Have a README with an overview and example
* Have JavaDocs documentation for all public methods
* Be somewhat [well-styled](style-reference)

To **demonstrate mastery**, your submission needs to:
* Demonstrate proficiency
* Memo explains *convincingly* why the evidence supports the claim
* Evidence is presented clearly
* Memo is organized well
* Be extremely [well-styled](style-reference) and clear by choosing descriptive variable names and including useful comments 
* Have a thorough, well-styled README 
* Have clear and thorough documentation

## Submission
Remember to update your Collaborations.txt file with any sources that you consulted, especially who you worked with on your `MedianOf3PivotSelector`, if anyone.

Then upload all of your files to the Gradescope link on Moodle as usual. Remember that this is an individual assignment.
