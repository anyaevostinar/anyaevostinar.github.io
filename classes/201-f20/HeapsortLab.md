---
layout: page
title: HeapSort Lab
permalink: /classes/201-f20/heapsort
---

## Goals
To better learn about how heapsort works by implementing the removeMax function of a tree-like heap.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Friday Nov 6th, but isn't due until Monday Nov 9th at 5:00pm Central.

Please create a new Repl project and make it private. Today's lab relies on Monday's lab. If you didn't finish Monday's, you may upload the [starter code](/classes/201-f20/HeapsortStarter.java) for the activity. If you did finish on Monday, you can just use your own code instead.

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen/use multiplayer mode with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced. 

## Exercise 1
The main driver of Heapsort is being able to efficiently remove the maximum value from a heap and then restore the heap to proper form so that you can do it again. Therefore, this lab will focus on implementing the `removeMax` functionality for the tree-like heap that you started on Monday. If you didn't finish Monday's lab, the starter code has the barebones functionality for you.

a. To implement `heapifyDown`, nodes will need to be able to track their children, so first you'll need to add that functionality. Add instance variables to the `Node` class to track the right and left children of the node.

b. Write a small method `addChild(Node)` for the `Node` class. The method can assume that it is only being called if there is room. Remember that a heap maintains a complete binary tree, so it should first check if there is a left child and only if there is should it place the new node as the right child.

c. You'll want your `addChild` method to be called whenever a new node is created, so add it to your Node constructor. Remember your constructor takes a parent argument, so a new Node should all the `addChild` method on its parent, passing `this` as the argument:

```
parent.addChild(this);
```

d. Finally, you'll also need to remove children in the later methods, so implement the `removeChild` method, again maintaining the complete binary tree property by first checking if there is a right child and removing it, or removing the left child if there isn't a right child.

e. Write a `test` method or update your existing one to check that the above functionality is working. Remember to compile and run your code at this point.

## Exercise 2
Now it's time to implement `removeMax`. There is a lot of shifting around of values in this method, so if you get confused or run into a bug, remember to print the nodes or entire heap to track what is going on. Remember that all your variables are just pointers to objects, so if you change the underlying object later in your code, your variable may not return what you expect it to. Also note that this is one way of implementing this method, but there are many others as well that would also work.

a. Create a new blank node called `toReturn`.

b. Use `swap` to swap the contents of `toReturn` and the root of your heap so that you now have an empty node as the root.

c. Decrease your number of items counter.

d. You now need to swap the empty root node with the node at the end of your Node list. 

e. You can now safely remove the last item in your Node list and find the parent of that node and call `removeChild` on it.

f. You should then call the `heapifyDown` method on your root and return `toReturn`. (Create a stub of `heapifyDown` that does nothing for now so you can make sure your swapping is working.)

g. In `main` create a heap, call `removeMax`, print what it returns and the heap afterward to make sure that things are working. Note that a small value will be the root of the heap because you haven't implemented `heapifyDown` yet!

## Exercise 3
Finally, you'll need to implement `heapifyDown` to get your heap back into shape.

a. First check if your `newNode` has a left child; if it doesn't, its a leaf and you can just return because you're done.

b. Otherwise, check if it has a right child. If it doesn't, you only need to check if it is less than its left child. If it is a lower priority, swap them. If it isn't a lower priority, you don't have to do anything. In either case, you can safely return.

c. If the node has a right and a left child, you need to check which child has the higher priority and then compare the new Node to the child with higher priority. If the new node is lower priority, swap, otherwise you don't have to do anything.

d. Test if your method is working correctly by printing your heap after calling `removeMax` and verifying that your heap has the highest priority item as the root again.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. Feedback on labs and activities is less detailed than on homework.

Submit your zip file to Moodle as always.

## Extensions
While this isn't the most efficient way of implementing a heap, you now have everything needed to implement Heapsort and grab the highest priority X number of items if you have the time and interest.