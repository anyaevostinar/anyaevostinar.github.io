---
layout: page
title: Binary Search Tree Debugging
permalink: /classes/201-f20/bst-activity
---

## Goals
To better understand binary search trees and practice debugging. Time for another Bug Hunt!

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Wednesday Oct 28th, but it isn't due until Friday Oct 30th at 5:00pm Central.

Create a new repl and make it private. Upload the [starter code](/classes/201-f20/BSTActivity.zip) for this activity.

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen/use multiplayer mode with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced. If you do not collaborate or check any outside websites, you should state that in Collaborations.txt.

## Exercises 1 - 4
You have a very buggy version of a binary search tree. It is similar but not identical to the code from your reading, but you should not reference the code from your reading as you solve this activity (that would very much defeat the purpose). In particular, it only works for Strings to make things a bit easier (that's not a bug).

You should first draw out an example binary search tree for Strings in alphabetical order and create that tree in the `main()` method of `BST.java`. You can start with a simple tree but will likely need to make it more complex to see all the bugs. You should use the `print` method to print it. It may just not work or it may hang depending on what your tree looks like.

Combine your understanding of how binary search trees work and your debugging skills to find the causes of the nodes not being placed into the correct positions, reporting the correct size of the tree, and/or infinite looping depending on which bugs you catch first.

Create a document `BugHunt.txt` and in it document:
* The code you change
* The behavior the buggy code caused
* How your change fixed the bug

There are at least four bugs across all the different methods. Remember, do not compare this code to the reading code as that would defeat the purpose of the lab in strengthening your understanding of how binary search trees work!

## Exercise 5
In addition to all the other problems, there is also a serious lack of documentation for this code. Correct this with proper JavaDocs method comments for the public methods (in general, private methods don't need JavaDocs comments since they shouldn't be featured on the JavaDocs page).

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. Feedback on labs and activities is less detailed than on homework.

Submit your zip file to Moodle as always.