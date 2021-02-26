---
layout: page
title: Hashing Lab
permalink: /classes/201-w21/hashing
---

## Goals
To work with different hash code generating functions and gain a better understanding of how characteristics of the hash code relate to collisions.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday March 1st, but isn't due until Wednesday March 3rd at 5:00pm Central.

Open the Hash Lab project on Repl.it.

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced. 

You will be answering various questions in today's lab so also create a document `Answers.txt` for those.

## Exercise 1
a. Determine and write in your `Answers.txt` document the hashcode for each of the provided `hashCode` functions for each of the following words:

* ant
* tan
* mop
* tiger

b. Based on your answers above and reading through each of the `hashCode` methods, update their comments to accurately reflect how the method works. Note that `hashCode0()` has been done for you.

c. In your answers document, write down how many of the four words mapped to the same hash code for each function. Reach out to your collaborative learning group and check if everyone has the same answers, discuss any differences and come to a conclusion.

## Exercise 2
Usually you will need a compression function that takes a hash value and makes sure that it fits within a hashtable of a specific size. The function `compressToSize(int, int)` does this by performing a modulo operation (which determines the remainder of a diversion operation). Things get a bit weird with negative values, so it adjusts for that.

a. Think about how a hashtable with 1,000 slots versus 10,000 slots would affect the number of words that hash to the same value using the provided compression function. In `Answers.txt`, write your answer for each hashcode function.

b. Use the function `printCollisionInformation` to test 1000 slots (also called buckets) versus 10,000 for `words.txt` and report the results in Answers.txt. Make sure you understand what each number reported means!

c. Run the same experiment with the text file `HoundOfTheBaskervilles.txt` and report on what if any difference there is and why that would be the case. Discuss your answers for this exercise with your collaborative learning group.

## Exercise 3
Finally, repeat your experiments for hashtable sizes of 2039 (a prime number) and 2048 (a non-prime number). Report the results in Answers.txt as well as what difference if any you see between them. 

Discuss your answers for this with your collaborative learning group.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. Feedback on labs and activities is less detailed than on homework.

Submit your zip file to Moodle as always.