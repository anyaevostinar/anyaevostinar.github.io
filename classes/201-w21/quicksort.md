---
layout: page
title: Quicksort Debugging
permalink: /classes/201-w21/quicksort
---

## Goals
To better understand quicksort and practice debugging.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Friday Feb 12th, but it isn't due until Monday Feb 15th at 5:00pm Central.

Open the Quicksort Lab on Repl.it.

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced. If you do not collaborate or check any outside websites, you should state that in Collaborations.txt.

## Exercises 1 - 6
You have a very buggy version of quicksort. It is similar but not identical to the code from your reading, but you should not reference the code from your reading as you solve this activity (that would very much defeat the purpose).

Debugging is best done with your collaborative learning group. Have one person share screen so that you can all talk the bugs through together.

You should first run the `Main` class to see how your quicksort currently performs. You should notice that you currently get a StackOverflowError, which means that you have 'infinite recursion' where the program never hits the base case and just keeps making recursive calls until it is killed. Once you sort out that error, you'll likely find that the quicksort doesn't actually sort correctly either.

Combine your understanding of how quicksort works and your debugging skills to find the cause(s) of each of these problems. The bugs are confined to the `quicksort` and `partition` methods and there are 6 lines with bugs total.

Create a document `BugHunt.txt` and in it document:
* The code you change
* The behavior the buggy code caused
* How your change fixed the bug

Remember, do not compare this code to the reading code as that would defeat the purpose of the lab in strengthening your understanding of how quicksort works!

Here is a (non-exhaustive) list of debugging strategies to try:
* Reading the errors and seeing what line they occur on
* Print statements everywhere to determine the state of the variables
* Walking through an example on paper and comparing to your print statements
* Trying different lists (simpler, mostly sorted, shorter), you don't have to use the `fillAndShuffle` method!


## Exercise 5
In addition to all the other problems, there is also a serious lack of documentation for this code. Correct this with proper JavaDocs method comments. An example is below if you need a refresher:
```
/**
* Generally descriptive few sentences about the method.
* @param nameOfParameter description of the parameter if useful, probably should mention the type
* @param anotherParameter if you have multiple parameters
* @return description of what if anything is returned, should definitely mention the type
*/
public int exampleMethod(int nameOfParameter, int anotherParameter){
  return 0;
}
```

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. 

Submit your zip file to Moodle as always.