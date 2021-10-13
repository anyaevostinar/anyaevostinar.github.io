---
layout: page
title: Binary Search Tree Lab
permalink: /classes/201-f21/BST-lab
published: false
---

## Goals
To better understand binary search trees by implementing some of their methods yourself. You will also get more practice with recursive methods and thinking.

## Logistics
You should complete this on Wednesday Oct 20th, 2021, but it isn't due until Friday Oct 22nd, 2021 at 5pm. 

You should work on this with your in-class partner, but you both need to submit separately. 
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your `Collaborations.txt`.

## Setup
[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `BSTLab`
* Create your `Collaborations.txt` document in that folder
* Download the [starter code](BST-Starter.zip) and put it into your BSTLab folder
* Open your BSTLab folder in VSCode
 

## Exercise 1
I've provided you with a class `BSTNode` that holds four things:
* a `String` which is the key for the node and what will be used for ordering the nodes
* an `int` which is the value for the node, and you can imagine is something that you are trying to store, such as the number of times the key has appeared in a document
* a `BSTNode` left, which is the left child of this node
* a `BSTNode` right, which is the right child of this node

I've also provided you with the start of the `BST` class, which includes a couple of useful methods already:
* `printTree()` prints the tree fairly nicely. It only works if the keys are single character strings, so I recommend sticking with capital letters, but it should help you visualize the tree. There is a lot of helper code for this method that appears at the end of the class that you shouldn't worry about.
* `test()` manually adds some nodes to the tree so that you can see what it looks like before you've implemented `add`
* `add` is the public method for adding to the tree. It checks if the root node is null and then just calls the recursive helper function `addHelper`

**Your task:** In `main` you should first create a `BST`, call the `test` method on it, and then call the `printTree()` method to see how things work. Make sure that you understand why the tree prints out the way that it does.

## Exercise 2
You will next implement the `getHelper` method.
There are four cases that you need to handle in `getHelper`: the base case and the cases for if the keys are equal, one is less than the other, and vice versa.

1. Think about what the two base cases should be for this recursive method. What is the simplest situation when looking for a node in the tree? Implement those first. Remember that since you're dealing with `String`s, you should use `.equals` to check for equality.

2. Now decide on what the two recursive cases are. What are the situations where you aren't done and you need to make another call to `getHelper` that moves you closer to the base cases? You should use the `compareTo` method because the keys are `String`s. However, it isn't limited to returning only -1, 0, or 1. With strings, it can return any positive or negative value, so you need to just check if it returns a value less than or greater than 0. 

3. In `main` test your `get` method by retrieving the values associated with the keys that are set in the `test` method.

## Exercise 3
You will now implement the `addHelper` method.
The construction of this recursive method is a bit more complicated than `get` because you need to attach the node to the tree in the right place.
 
1.  One of your base cases is if the keys are equal, because this version of a binary search tree just doesn't add the new node and returns false. Implement that functionality first.

2. If the keys aren't equal, you need to figure out if you are going to insert the new node to the left or to the right of the `subRoot`. This could lead to either a base case (if there is room) or a recursive case (if there is already a child there).

3. Once you know which side of the subtree you are going to be adding the new node, you also need to check if there is already a child node there or not. If there isn't a child on that side, you have a base case and you should set the child as `newNode`. 

4. If there is already a child on that side, you should make a recursive call to `addHelper` with the appropriate parameters. Also be sure to think about what you should return in both these cases.

5. If you haven't already, implement the code for adding the node to the other side of the tree as well.

6. Test your code by adding several more nodes to the tree

7. Think about why you couldn't have a base case that just checks if `subRoot` is null and sets `subRoot` equal to the new node. We'll discuss as a class.

## Submission
Compress your files as a zip, and upload that zip to Moodle under the appropriate assignment.
Remember that partners need to submit their code separately and you should share the code you wrote in class with your partner.

This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the code to indicate things you tried but what went wrong/where you got stuck.

## Extensions
If you have extra time, try changing `add` and `addHelper` so that instead of returning a `boolean`, they return a `BSTNode` and have a structure more similar to `getHelper`. Be careful with making sure that a duplicate key doesn't erase the previous key.