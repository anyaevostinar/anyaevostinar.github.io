---
layout: page
title: 2-3 Tree Documenting
permalink: /classes/201-f20/twothreetree
---

## Goals
To better understand 2-3 Trees by documenting code.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Friday Oct 30th, but it isn't due until Monday Nov 2nd at 5:00pm Central.

Create a new repl and make it private. Upload or copy/paste the [starter code](/classes/201-f20/Node.java) for this activity (to save it, right click on the link and select save link as, or something similar).

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen/use multiplayer mode with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced. If you do not collaborate or check any outside websites, you should state that in Collaborations.txt.

## Exercise 1
I've provided you a simplified version of the code from the reading for a basic Node class (the reading calls it TTNode) that creates a 2-3 Tree. I've also provided a `printTree` method that attempts to clearly print the 2-3 Tree (though I didn't have time to center it, sorry!).

To begin, insert a few nodes to and compile and run Node.java to see the code work. If you ever want to see your tree better visualized, I highly recommend you put it into the visualizer linked from Moodle.

## Exercise 2
The reading's code is frightfully poorly documented and therefore really difficult to follow (which you probably already noticed). One recommendation about documentation is to have inline `//` comments for lines that ARE NOT self-explanatory and/or confusing to understand. First seek to understand then put inline documentation for each of the following sections of `add`:

a. After the line ending in `add` that reads `//Only one key, add here`, what are the two cases the if/else is handling?

b. In that same section, why is `this` returned?

c. In the `// Add left` section, what is `N1`? Feel free to give it a better name if you'd like in addition to an inline comment. 

d. In the same section, what is all the shuffling of variables doing at a high level?

e. Complete c and d for the `//Add center` section

f. Complete c and d for the `//Add right` section

g. Add a JavaDocs comment for this version of `add`. Note that the book's isn't particularly helpful or relevant to this version, so I don't recommend copying it. 

## Exercise 3
Now that you understand the `add` method better, document the following sections of `insertHelp`:

a. What is `retval` in `insertHelp`?

b. In `insertHelp` in the `//Insert left` if statement, what is happening on each line?

c. Similarly for the `//Insert right` else statement.

d. The even more confusing `else if` between b and c.

e. Add a JavaDocs comment for `insertHelp`.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. Feedback on labs and activities is less detailed than on homework.

Submit your zip file to Moodle as always.

## Extensions
If you have time, here are some other things to do with this code:
* `insertHelp` is annoying to use, create an `insert` method that is less annoying and calls `insertHelp`. There are several ways you could do that, one is by making a new class that holds `Node`s and therefore tracks the root.
* Try implementing deletion.
