---
layout: page
title: HW 5 Wikipedia Paths
permalink: /classes/201-w21/hw5
---

## Logistics
25 points, due Friday Feb 12th by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy. You need to notify me that you're using the policy. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still the deadline, not 48 hours later.

## Goals
To gain practice with several data structures and ADTs we've learned about so far and implement breadth-first search.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You're welcome to either complete this homework with input from one or more members of your collaborative learning group or to complete it on your own. You and the other members of your collaborative learning group should each write your own code, even if you're helping one another, but you may share your screens to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Setup and Requirements
Open the HW 5 project on Repl.it. 

The code that you write for this assignment will build on top of a graph implementation that I have provided. You will again find a Mystery implementation, the MysteryUnweightedGraphImplementation. You don't need to know anything about the implementation, but you can look at the [JavaDocs](/classes/201-f20/hw-6javadoc) for it and the Graph and UnweightedGraph interfaces it implements to know what methods it provides.

Create a file Collaborations.txt and put in any collaboration with your learning group or references to outside websites.

You'll probably want to open these JavaDoc pages to refer to throughout the homework:

* [UnweightedGraph interface](/classes/201-f20/hw-6javadoc)
* [Queue interface](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html)
* [Map interface](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)

## Specification
There is a 'game' where you start from a Wikipedia page and try to get to another specific Wikipedia page in as few pages as possible (here is a [Wikipedia page](http://en.wikipedia.org/wiki/Wikipedia:Six_degrees_of_Wikipedia) about it!). You can think about Wikipedia pages as a graph where each page is a vertex in the graph and each link is a directed edge from one node to another. In this assignment, you will use that idea and breadth first search to find the shortest path between from one page to another.

You'll write your code in the `PathFinder` class and ultimately should be able to specify via command line arguments the vertices and edges, a start vertex, and an end vertex:
```
java PathFinder vertexFile edgeFile startVertex endVertex
```

For example:
```
java PathFinder articles.tsv links.tsv Canada_Goose Duran_Duran
[Canada_Goose, Animal, Latin, The_Adventures_of_Tintin, Duran_Duran]
```

The above means that the shortest path between the article about Canada Goose and the article about Duran Duran goes through three intervening articles. There may be other paths of the same length and it would be fine if your program returned those instead, but it must return a shortest path.

## Testing files
I've provided you with a [small subset](https://snap.stanford.edu/data/wikispeedia.html) of the Wikipedia articles and links from 2007. But you should make an even smaller set of files that specify around 5 articles and around 5 links between articles. The starter code assumes the articles file is formatted with one article name per line with '_' standing in for spaces in the article name. It also assumes the links file has one link per line, where the line
```
a   b
```
means there is a link on page 'a' to page 'b'.

On paper, draw out a graph of the information in your test file including the direction of the links. Trust me, you're going to want it!

## toString
The toString() method won't be used in the final version of your code, but it is helpful in making sure that everything gets read in properly.

Implement the toString method so that it returns a String with the number of nodes and numbers of edges in the `wikiGraph`. Check the documentation (linked above) on what methods will give you that information.

Create an instance of PathFinder with your test files and verify that it reads in the files properly by printing the number of nodes and edges. Note that you can just pass your PathFinder instance to `println` without calling `toString` manually and Java will use your `toString` method.

You'll notice that I left in a print statement in the read methods to show each line being read. Feel free to remove it once you know that everything is working.

## breadthFirstSearch
As we've learned in class, the way to find the shortest path between two nodes in a graph is to perform breadth-first search. Your breadthFirstSearch method will return a map of the predecessor of each node on the shortest path from the start node.

First, fill in the documentation for the method with the correct JavaDocs style of specifying the `@param` and `@return` along with what the method actually does.

Then, adapt your code from the BFS activity to work for PathFinder. Note that the `wikiGraph` only knows about node numbers, it doesn't track article titles, and you need to look up the node number of an article title in the `articleVertex` map.

I recommend putting in some print statements and then calling your breadthFirstSearch method to make sure that it is working as your expect. Remove the print statements after it works however.

## getShortestPath
This method should first call your `breadthFirstSearch` method with your start article and save the resulting map of predecessor nodes.

Now you have a map of the node that comes before each node on a shortest path from the start node and you just need to trace through them.
Since you can only look up the predecessor of a given node, you need to start at the end article and look up its predecessor node until you get to the start article node.

Note that there is a static method that belongs to the `Collections` class that allows you to reverse a collection:
```
Collections.reverse(myList);
```

Test your algorithm on your test data where you know what the correct answer is. Note that you should return an empty list if there is not a path between the start and end article.

## Command line arguments
Finally, set up your command line arguments to match the specification:
```
java PathFinder vertexFile edgeFile startVertex endVertex
```

## Rubric
Your homework will be graded by the following:

| Item | Points |
|-------|--------|
| Correct use of Queue | 2 |
| Finds example shortest path correctly | 6 |
| Finds various test shortest paths | 10 |
| Returns empty list if no path | 2 |
| toString implemented correctly | 1 |
| Doesn't have repeated code | 1 |
| Sufficient documentation | 2 |
| Otherwise good style | 1 |

The graders will check your code on a number of different graphs that have only one correct shortest path and you are encouraged to check your code against several different graphs to make sure everything works.
