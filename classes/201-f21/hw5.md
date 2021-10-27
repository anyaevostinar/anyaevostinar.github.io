---
layout: page
title: HW 5 Experiments with Quicksort
permalink: /classes/201-f21/hw5
---

## Logistics
30 points, due Friday Oct 22nd by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy. You need to notify me that you're using the policy. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still the deadline, not 48 hours later.

## Goals
To study the performance characteristics of quicksort with several different pivot choices and hone your analysis skills.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You will be able to start the code for this assignment with a partner, however the bulk of the assignment will be done individually.
Specifically, you can implement the `MedianOf3PivotSelector` class with your in-class partner. However, the rest of the assignment (conducting experiments and writing the memo) must be completed individually and treated as an individual homework assignment. See the [collaboration policy](collaboration) for details.

## Setup and Requirements
Mount COURSES, download the [HW5 starter code](HW5Starter.zip) and move it to your StuWork/username folder. You should follow the same process of compressing your files and uploading them to Moodle to submit your homework. 

Create a file `Collaborations.txt` and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.
In particular, make sure to record the name of your in-class partner in the `Collaborations.txt`.

In this assignment, you'll be doing a mixture of coding, designing timing experiments, and analyzing your results. You'll be thinking through what timing data makes sense to collect, and writing your reasoning in a short report. You will need to create a PDF file with your report and include it in the zip of your code.

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

## Experimenting
(Remember that this portion of the homework must be completed individually.)

Now you should change the code in `main` of `Quicksort.java` to test all three pivot selector approaches on a variety of arrays, including those with:

* varying numbers of duplicate items
* varying amounts of sortedness (in both directions)
* varying lengths 

You can use many different array sizes to explore the questions in this assignment. Make sure the arrays you're choosing are big enough to show real differences. If all of your experiments take only 1 or 2 milliseconds, it will be very hard to understand how your variations are related to differences in timing. Instead, use an array that's big enough to take at least hundreds of milliseconds to sort.

## Memo
(Remember that this portion of the homework must be completed individually.)

You should now write an approximately 2 page (single-spaced) memo recommending which pivot selection method should be used and presenting evidence to support your position. Your evidence might include plots and/or tables of timing data. The page number recommendation includes any charts and plots; it can be shorter as long as your communicate all of the needed information, it can also be longer if you would like. (All that means that I expect that to answer the prompt, you'll need about 2 pages, but it isn't a hard rule.)

Your memo should assume that average run time is the most important consideration, but if run times are similar, it might discuss other reasons to prefer or disprefer a particular method. The memo should at least briefly discuss whether the length of the array to sort influences which selection method to choose and whether characteristics of the numbers in the array or their initial ordering (e.g., many duplicates, degree of sortedness) impact which selection method to choose.

In your report, you should describe the timing experiments you performed and the data you collected. You should make sure to explain how the evidence you collected supports your claims, and explain your choices about what evidence to collect for each question. I encourage you to think carefully about how to connect evidence and explanations. Imagine your report is intended to help someone make decisions related to this investigation - what information do they need to know? Why do you think the timing data looks the way it does based on what you know about how the algorithm works? You should try to design your experiments in a way that will be convincing to the reader. How could you compensate for the fact that timing data is "noisy," with the same code sometimes taking a little longer or shorter to run? You're welcome to chat with me or your prefect about your approach.

Your memo will be evaluated based on its clarity and how well you use evidence to support your claims, including whether you collected appropriate evidence for those claims. Your evidence collection will be evaluated based on your descriptions.

You must turn your memo into a PDF for submission.

## README
As always, you should include a README for this homework, though it will be shorter than normal and focused on the `MedianOf3PivotSelector`. 
It should include a brief overview of the code, and a short example of how to run your program and see its interesting behavior.

## Grading
Here is how your assignment will be graded:

| Item | Points |
|-------|--------|
| Median of 3 pivot selector implemented correctly | 5 |
| Analyzed effect of length of array | 4 |
| Analyzed effect of initial ordering | 6 |
| Analyzed effect of duplicated items | 4 |
| Explains convincingly why evidence supports the claim | 3 |
| Memo makes a recommendation of which pivot approach to use | 2 |
| Evidence presented clearly | 2 |
| Memo organized well | 1 |
| README complete | 3 |


## Submission
Remember to update your `Collaborations.txt` file with any sources that you consulted, especially who you worked with on your `MedianOf3PivotSelector`, if anyone.

Then make a .zip of your files and upload it to Moodle. Even if you started the homework with a partner in class, you must upload project individually for this homework assignment.

## Extensions
There are lots of other ways of choosing a pivot, so if you are interested, you are welcome to implement more and test them as well.