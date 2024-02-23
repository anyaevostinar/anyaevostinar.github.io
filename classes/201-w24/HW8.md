---
layout: page
title: HW 8 Wikipedia Paths
permalink: /classes/201-w24/hw8
---

## Logistics
This is a paired assignment, so you should complete it with your assigned partner, if you have one, via paired programming. The whole time that you are working, you should both be present and actively working on the problem at hand. (Two brains, one keyboard.) Switch off the typing duties so that you each type for roughly half of the time.

You are able to get help from many sources as detailed in the [collaboration policy](collaboration).

This assignment is due on Friday February 23rd at 10pm. As with all assignments, you will have the opportunity to revise this assignment individually based on the feedback that you get.

## Goals
To gain practice with several data structures and ADTs we've learned about so far and implement breadth-first search.

## Setup and Requirements
Mount COURSES, download the [HW 8 Starter Code](/classes/201-f21/HW8-Starter.zip) and move it to your StuWork/username folder. You should follow the same process of compressing your files and uploading them to Moodle to submit your homework. 

Create a file `Collaborations.txt` and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.

The code that you write for this assignment will build on top of a graph implementation that I have provided, the `MysteryUnweightedGraphImplementation`. You don't need to know anything about the implementation, but you can look at the [JavaDocs](/classes/201-f20/hw-6javadoc) for it and the `Graph` and `UnweightedGraph` interfaces it implements to know what methods it provides.

You'll probably want to open these JavaDoc pages to refer to throughout the homework:

* [UnweightedGraph interface](/classes/201-f20/hw-6javadoc)
* [Queue interface](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html)
* [Map interface](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)

## Specification
There is a 'game' where you start from a Wikipedia page and try to get to another specific Wikipedia page in as few pages as possible (here is a [Wikipedia page](http://en.wikipedia.org/wiki/Wikipedia:Six_degrees_of_Wikipedia) about it!). You can think about Wikipedia pages as a graph where each page is a vertex in the graph and each link is a directed edge from one node to another. In this assignment, you will use that idea and breadth first traversal to find the shortest path between from one page to another.

You'll write your code in the `PathFinder` class and ultimately should be able to specify the vertices and edges via filenames, a start vertex, and an end vertex via command-line arguments:
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
The `toString()` method won't be used in the final version of your code, but it is helpful in making sure that everything gets read in properly.

Implement the `toString` method so that it returns a `String` with the number of nodes and numbers of edges in the `wikiGraph`. Check the documentation (linked above) on what methods will give you that information.

Create an instance of `PathFinder` with your test files and verify that it reads in the files properly by printing the number of nodes and edges. Note that you can just pass your PathFinder instance to `println` without calling `toString` manually and Java will use your `toString` method.

## breadthFirstSearch
The way to find the shortest path between two nodes in a graph is to perform breadth-first search. Your `breadthFirstSearch` method should return a `Map<Integer, Integer>` of the *predecessor* of each node on the shortest path from the start node.

First, fill in the documentation for the method with the correct JavaDocs style of specifying the `@param` and `@return` along with what the method actually does.

Then, implement the `breadthFirstSearch` method. Note that the `wikiGraph` only knows about node numbers, it doesn't track article titles, and you need to look up the node number of an article title in the `articleVertex` map.

I recommend putting in some print statements and then calling your `breadthFirstSearch` method to make sure that it is working as your expect. Remove the print statements after it works however.

## getShortestPath(String start, String end)
This method should return a `List<String>` containing the list of articles that the user needs to click on to get from the start node to the finish node. Note that you should return an empty list if there is not a path between the start and end article.

You should first call your `breadthFirstSearch` method with your start article and save the resulting map of predecessor nodes.

Now you have a map of the node that comes before each node on a shortest path from the start node and you just need to trace through them.
Since you can only look up the predecessor of a given node, you need to start at the end article and look up its predecessor node until you get to the start article node.

Note that there is a static method that belongs to the `Collections` class that allows you to reverse a collection:
```
Collections.reverse(myList);
```

Test your algorithm on your test data where you know what the correct answer is. 

## main
Your main should handle the following command line interface:
```bash
java PathFinder articles.tsv links.tsv startNode endNode
```

Your program should output the article names of the links the user should click on to follow a shortest path from the starting page to the ending page or tell the user `There isn't a path`.

## README
As always, you should include a detailed README for this homework. 
It should include a brief overview of your project and a short example of how to run your program and see its interesting behavior.

There is no additional prompt for this homework.

## Assessment
To demonstrate proficiency, your program needs to:

* Pass all tests on Gradescope
* States if no path is possible
* Follow the specifications for the command-line
* Use `Queue` correctly
* Be object-oriented
* Have a README with an overview and example
* Have JavaDocs documentation for all public methods
* Be somewhat [well-styled](style-reference)

To **demonstrate mastery**, your program needs to:
* Demonstrate proficiency
* Use helper methods correctly and effectively
* Be extremely [well-styled](style-reference) and clear by choosing descriptive variable names and including only useful comments 
* Have a thorough, well-styled README 
* Have clear and thorough documentation

## Submission
Remember to update your Collaborations.txt file with any sources that you consulted.

Then upload all of your files to the Gradescope link on Moodle, at which point the autograder will run and let you know if your code works correctly. You are able to submit your code as many times as you wish before the deadline to fix any issues. If you have questions about what the autograder is telling you is wrong, please ask!

