---
layout: page
title: Graphs Activity
permalink: /classes/201-f21/graphs
published: false
---

## Goals
To better learn about how graphs work by thinking about and then adding to two implementations.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday Nov 1st, but it isn't due until Wednesday Nov 3rd at 5:00pm Central.

You should work on this with your in-class partner, but you both need to submit separately. 
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your `Collaborations.txt`.

## Setup
[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `GraphsLab`
* Create your `Collaborations.txt` document in that folder
* Download the [starter code](Graphs-Lab.zip) and put it into your GraphsLab folder
* Open your `GraphsLab` folder in VSCode


## Exercise 1
First let's look at the files in the starter code.

a. Open `AdjacencyListGraphImplementation.java` and note what instance variables are there and how the constructor and `addVertex` initializes the variables.

b. Open `AdjacencyMatrixGraphImplementation.java` and note what instance variables this implementation has and how they differ from the Adjacency List. Also look at the constructor and `addVertex` and note the similarity/difference in initialization.

## Exercise 2
Now you'll draw out some graph implementations on paper. You don't need to submit these, but I highly recommend you actually do this to improve your understanding of how these implementations work!

Here is the graph you'll be implementing on paper:

![Undirected graph with edge between node 0 and 3, node 3 and 1, node 3 and 2, and node 1 and 2](/classes/201-f20/UndirectedGraph.png)

a. Draw the Adjacency Matrix implementation of this graph, making sure to accurately reflect the types of the underlying lists. You can assume that any array lists start with arrays of length 5.

When you're done, check against my solution:
<details><summary>Show solution</summary>
<p>
<img src="/classes/201-f20/AdjacencyMatrixImplementation.png">
</p>
</details>


<br>
b. Draw the Adjacency List implementation of this graph, again showing the underlying list types correctly. Note that the ordering of the edges in the adjacency lists isn't mandated by the graph representation, so any ordering of the nodes within each linked list is fine.

When you're done, check against my solution:
<details><summary>Show solution</summary>
<p>
<img src="/classes/201-f20/AdjacencyListImplementation.png">
</p>
</details>

## Exercise 3
Now let's implement some of the remaining methods.

a. First implement `addEdge` for `AdjacencyMatrixImplementation` assuming there isn't already an edge. Run `AdjacencyMatrixImplementation` to see if you pass the `addEdge` tests. There are other tests that will still be failing, in particular many that rely on `hasEdge`, don't worry about those for now. (Remember to refer to the [Java Docs for ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html) if you don't remember how to do something with them.)

b. Now implement `hasEdge` in the same implementation file and run the tests again. You should now be passing the relevant tests, though not all of them.

c. Even though you are passing the tests, you are not actually matching what the comment for `addEdge` says it will do, update your code using `hasEdge` to work correctly. (This is a place where there should really be a test, but I didn't have a chance to write it yet. Feel free to write it if you want!) To throw an exception when the user tries to call `addEdge` for vertices that don't exist, you can use the following:
```
throw new IndexOutOfBoundsException();
```

d. Finally, implement `getDegree` and verify you are passing all the tests for this implementation. 


## Exercise 4
Finally, implement the same methods for `AdjacencyListImplementation`. You'll find they are somewhat similar, but you'll need to adapt to the different implementation details of having linked lists instead of array lists.

## Extensions
If you have time and interest, here are some other things to do:
* Complete the other methods, `getInDegree` and `numEdges`
* Try to adapt your code to work with the `WeightedGraph` interface
* Read the note about `getNeighbors` in the adjacency list implementation and determine why there is a problem
* Think about how you would have to adapt your code for a directed graph

## Submission
Compress your files as a zip, and upload that zip to Moodle under the appropriate assignment.
Remember that partners need to submit their code separately and you should share the code you wrote in class with your partner.

This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the code to indicate things you tried but what went wrong/where you got stuck.

