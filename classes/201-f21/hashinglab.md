---
layout: page
title: Hashing Lab
permalink: /classes/201-f21/hashing
published: false
---

## Goals
To work with different hash code generating functions and gain a better understanding of how characteristics of the hash code relate to collisions.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday Nov 8th, but isn't due until Wednesday Nov 10th at 5:00pm Central.

You should work on this with your in-class partner, but you both need to submit separately. 
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your `Collaborations.txt`.

## Setup
[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HashingLab`
* Create your `Collaborations.txt` document in that folder
* Download the [starter code](Hashing-Lab.zip) and put it into your lab folder
* Open your `HashingLab` folder in VSCode

You will be answering various questions in today's lab so also create a document `Answers.txt` for those.

## Exercise 1
a. Determine and write in your `Answers.txt` document the hashcode for each of the provided `hashCode` functions for each of the following words:

* ant
* tan
* mop
* tiger

b. Based on your answers above and reading through each of the `hashCode` methods, update their comments to accurately reflect how the method works. Note that `hashCode0()` has been done for you.

c. In your answers document, write down how many of the four words mapped to the same hash code for each function.

## Exercise 2
Usually you will need a compression function that takes a hash value and makes sure that it fits within a hashtable of a specific size. The function `compressToSize(int, int)` does this by performing a modulo operation (which determines the remainder of a diversion operation). Things get a bit weird with negative values, so it adjusts for that.

a. Think about how a hashtable with 1,000 slots versus 10,000 slots would affect the number of words that hash to the same value using the provided compression function. In `Answers.txt`, write your answer for each hashcode function.

b. Use the function `printCollisionInformation` to test 1000 slots (also called buckets) versus 10,000 for `words.txt` and report the results in Answers.txt. Make sure you understand what each number reported means!

c. Run the same experiment with the text file `HoundOfTheBaskervilles.txt` and report on what if any difference there is and why that would be the case. 

## Exercise 3
Finally, repeat your experiments for hashtable sizes of 2039 (a prime number) and 2048 (a non-prime number). Report the results in Answers.txt as well as what difference if any you see between them. 

## Extensions
If you finish early, try actually implementing your own hashmap class that uses one of these ways of calculating a hashcode (or a different one that you come up with) to store key/value pairs similar to the Java built-in HashMap.

## Submission
Compress your files as a zip, and upload that zip to Moodle under the appropriate assignment.
Remember that partners need to submit their code separately and you should share the code you wrote in class with your partner.

This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the code to indicate things you tried but what went wrong/where you got stuck.