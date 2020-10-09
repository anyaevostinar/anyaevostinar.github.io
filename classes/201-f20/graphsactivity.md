---
layout: page
title: Graphs Activity
permalink: /classes/201-f20/graphs
---

## Goals
To better learn about how graphs work by thinking about and then adding to two implementations.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday Oct 12th, but it isn't due until Wednesday Oct 14th at 5:00pm Central.

Please create a new Repl project and make it private. Upload the [starter code](/classes/201-f20/Graph-Implementation-Activity.zip) for the activity.

You're welcome to work on this lab with input from one or more members of your collaborative learning group. You should write all of your own code, but you're welcome to share your screen/use multiplayer mode with members of your collaborative learning group to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Exercise 0
Using the Add File button on repl.it, add a Collaborations.txt file and describe any interactions you have with your collaborative learning group on this lab. Also note any outside sources such as websites that you referenced. 


## Exercise 1
First let's look at the files in the starter code.

a. Open `AdjacencyListGraphImplementation.java` and note what instance variables are there and how the constructor initializes the variables.

b. Open `AdjacencyMatrixGraphImplementation.java` and note what instance variables this implementation has and how they differ from the Adjacency List. Also look at the constructor and note the similarity/difference in initialization.

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

a. First implement `addEdge` for `AdjacencyMatrixImplementation` assuming there isn't already an edge. Run `AdjacencyMatrixImplementation` to see if you pass the `addEdge` tests. There are other tests that will still be failing, don't worry about those for now.

b. Now implement `hasEdge` in the same implementation file and run the tests again. You should now be passing the relevant tests, though not all of them.

c. Even though you are passing the tests, you are not actually matching what the comment for `addEdge` says it will do, update your code using `hasEdge` to work correctly. (This is a place where there should really be a test, but I didn't have a chance to write it yet. Feel free to write it if you want!) 

d. Finally, implement `getDegree` and verify you are passing all the tests for this implementation.

## Exercise 4
Finally, implement the same methods for `AdjacencyListImplementation`. You'll find they are somewhat similar, but you'll need to adapt to the different implementation details of having linked lists instead of array lists.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. Feedback on labs and activities is less detailed than on homework.

Submit your zip file to Moodle as always.

## Extensions
If you have time and interest, here are some other things to do:
* Complete the other methods, `getInDegree` and `numEdges`
* Try to adapt your code to work with the `WeightedGraph` interface
* Read the note about `getNeighbors` and determine why there is a problem
* Think about how you would have to adapt your code for a directed graph