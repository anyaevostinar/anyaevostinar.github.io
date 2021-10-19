---
layout: page
title: Heap Lab
permalink: /classes/201-w21/heap
---

## Goals
To better learn about how heaps work by implementing a more tree-like heap.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday Feb 22nd, but it isn't due until Wednesday Feb 24th at 5:00pm Central.

Open the Heap Lab on Repl.it.

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced. 

## Exercise 1
In this lab, you'll make a heap that uses Nodes like we've seen in other tree data structures. **This is not an efficient way of making a heap at all**, the goal is just to practice with the concepts of a heap (without doing another bug hunt ;) ).

a. First you'll want to get your Node's `compareTo` set up so that you can use it later. You should compare Nodes based on their priority and since the `priority` is an `Integer` it also supports `compareTo` so you can just use that:
```
this.priority.compareTo(b.priority);
```

b. You'll also need to set up your Node constructor by setting the instance variables.

c. Next you'll need to set up the `parent` method of `Heap` which takes a position and returns the Node at the parent position of `nodes`. Refer to the reading for how to calculate what position that will be.

d. Finally implement the `test` method by having it put three `Node`s manually into your `nodes` `ArrayList` and setting all the other things up correctly about those `Node`s, such as which is the root and the parent of the second two nodes, assuming a max heap based on priority. Within `test` also call `compareTo` and `parent` to verify those methods are working correctly.

## Exercise 2
Now you'll implement the main pieces of your heap.

a. Implement the `swap` method so that it swaps the priorities and values of the nodes, but not the nodes themselves. Think of the nodes as the offices, which don't change, and just the occupants of the office change. This means you won't have to change the parent settings at all.

b. Update your test method so that it checks that swap is working.

c. Implement `heapifyUp` which takes a Node, checks if it is a higher priority than its parent, and if so, swaps the node with its parent and then continues to do so recursively until the node isn't higher priority than its parent or the node is the root.

d. Update your test method so that it checks that heapifyUp is working.

e. Finally implement `insert` which should call `heapifyUp` after some initial work. Remember to implement insert using the tree structure, not using the ArrayList like the reading does. You will need to add the new node to the ArrayList, but should then attach it to your tree structure and use `heapifyUp`.

f. Test that you are able to insert nodes into your heap and that the top value of the heap's ArrayList is the highest priority item you've inserted.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck.

Submit your zip file to Moodle as always.

## Extensions
You might have noticed that our heap implementation is missing a rather large functionality of a heap, which is removing the top item and then fixing the heap. If you have time and interest, implement `heapifyDown` which should check the root against its children and shift it down to the correct place. You'll need to have nodes track their children in addition to their parent for this most likely.