---
layout: page
title: Binary Search Tree Lab
permalink: /classes/201-s26/bst-lab
published: true
---

## Goals
To implement a binary search tree. You should not consult the reading during the lab, since the goal is for you to practice implementing this yourself to improve your understanding.

## Setup
Mount the COURSES drive and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `BSTLab`
* Download the [starter code](/classes/201-f25/BSTLab.kt) and put it into your lab folder
* Open your `BSTLab` folder in VSCode

## Exercise 1
Look at the code in `main` and draw out what the binary search tree will look like after all the insertion steps.

## Exercise 2
1. Start with implementing `insertKey`. Remember to save the values from the recursive calls and set them to the appropriate variables! 

2. Try out running your code and make sure that you get a correct in-order traversal.

## Exercise 3
1. Now implement `minValue`, a helper function that you'll want. 

2. Remember to test your code by adding a call to `minValue` in main.

## Exercise 4
Finally implement `deleteRec` and make sure that everything works. Remember that you should aim to do this by figuring it out for yourself based on the starter comments, not by consulting the reading. Hint: Since our node class doesn't keep track of its parent, you'll need to track that within your functions. You should definitely also make some helper functions for the different pieces of the delete function.


Upload your completed lab to Moodle for an extra engagement credit.

## Extra
Binary search trees can easily become imbalanced and lose all their benefits. How could you detect that your tree was becoming imbalanced and fix it?


