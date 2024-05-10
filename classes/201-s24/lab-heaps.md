---
layout: page
title: Heap Lab
permalink: /classes/201-s24/heap
published: true
---

## Goals
To better learn about how heaps work by implementing a more tree-like heap.

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.
## Setup
[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HeapLab`
* Download the [starter code](/classes/201-f21/Heap.java) and put it into your HeapLab folder
* Open your `HeapLab` folder in VSCode


## Exercise 1
In this lab, you'll make a heap that uses Nodes like we've seen in other tree data structures. **This is not an efficient way of making a heap at all**, the goal is just to practice with the concepts of a heap.

a. First you'll want to get your Node's `compareTo` set up so that you can use it later. You should compare Nodes based on their priority and since the `priority` is an `Integer` it also supports `compareTo` so you can just use that:
```
this.priority.compareTo(b.priority);
```

b. You'll also need to set up your `Node` constructor by setting the instance variables.

c. Next you'll need to set up the `parent` method of `Heap`, which takes a position and returns the `Node` at the parent position of `nodes`. Recall that the parent is at `(index -1)/2`.

d. Finally implement the `test` method by having it put three `Node`s manually into your `nodes` `ArrayList` and setting all the other things up correctly about those `Node`s, such as which is the root and the parent of the second two nodes, assuming a max heap based on priority. Within `test` also call `compareTo` and `parent` to verify those methods are working correctly.

## Exercise 2
Now you'll implement the main pieces of your heap.

a. Implement the `swap` method so that it swaps the priorities and values of the nodes, but not the nodes themselves. Think of the nodes as the offices, which don't change, and just the occupants of the office change. This means you won't have to change the parent settings at all.

b. Update your test method so that it checks that `swap` is working.

c. Implement `heapifyUp`, which takes a Node, checks if it is a higher priority than its parent, and if so, swaps the node with its parent and then continues to do so recursively until the node isn't higher priority than its parent or the node is the root.

d. Update your test method so that it checks that `heapifyUp` is working.

e. Finally implement `insert`, which should call `heapifyUp` after some initial work. Remember to implement `insert` using the **tree structure**, not using the `ArrayList`. You will need to add the new node to the `ArrayList`, but should then attach it to your tree structure and use `heapifyUp`.

f. Test that you are able to insert nodes into your heap and that the top value of the heap's `ArrayList` is the highest priority item you've inserted.

## Extensions
You might have noticed that our heap implementation is missing a rather large functionality of a heap, which is removing the top item and then fixing the heap. If you have extra time, implement `heapifyDown` and `removeMax`.


