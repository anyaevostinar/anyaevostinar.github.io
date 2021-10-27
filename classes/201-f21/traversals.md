---
layout: page
title: Traversals Analysis
permalink: /classes/201-f21/traversal-analysis
published: false
---

## Goals
To analyze the time complexity of depth first and breadth first search.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday Nov 1st, but it isn't due until Wednesday Nov 3rd at 5:00pm Central.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday Oct 11th, but it isn't due until Wednesday Oct 13th at 5:00pm Central.

There is no coding in this assignment, so you will submit a PDF of your solutions. You have several options for how to produce this PDF:
* Write it by hand and scan it into a PDF. If you do this, you must write very neatly and clearly. Make sure to check that your scan is completely legible!
* Write it in a word processing program, then export or print it to PDF.
* Write it in LaTeX and typeset it as a PDF. LaTeX is complicated to use at first but allows you to format math very nicely. [Overleaf.com](https://www.overleaf.com/) is a nice website to use for writing LaTeX. 

I recommend just using a word processing program and exporting/printing to PDF!

You should work on this with your in-class partner, but you both need to submit separately and therefore, if you are writing on paper, you both need to be writing your own copies.
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your Collaborations section.

## Exercise 0
Create a Collaborations section of your document and describe any people you get help from on this lab. Also note any outside sources such as websites that you referenced. 

## Exercise 1
Even though you haven't seen or written code for graph traversals, you can still analyze the time complexity of pseudocode.
When we analyze the time and space complexity of graph algorithms, the convention is to use `|V|` for the number of vertices/nodes in the graph and `|E|` for the number of edges in the graph.
Because the complexity of graphs often depends on both the number of vertices and the number of edges, you'll often need to express the complexity in terms of `|V|` and `|E|`. 

Here is the pseudocode for breadth-first search from the reading:

```
Algorithm getBreadthFirstTraversal(originVertex)
traversalOrder = a new queue for the resulting traversal order
vertexQueue = a new queue to hold vertices as they are visited
Mark originVertex as visited
traversalOrder.enqueue(originVertex)
vertexQueue.enqueue(originVertex)
while (!vertexQueue.isEmpty())
{
   frontVertex = vertexQueue.dequeue()
   while (frontVertex has a neighbor)
   {
      nextNeighbor = next neighbor of frontVertex
      if (nextNeighbor is not visited)
      {
         Mark nextNeighbor as visited
         traversalOrder.enqueue(nextNeighbor)
         vertexQueue.enqueue(nextNeighbor)
      }
   }
}
return traversalOrder
```

Remember that for this class, we aren't doing formal proofs of time complexity, but we do want to have some justification for the answers.

a. Analyze the number of simple operations that are required at each step of the above algorithm. You are welcome to copy the steps above and then put your analysis on each line. 

b. Some of the lines of pseudocode are hiding a fair amount of detail, such as `frontVertex has a neighbor` and `nextNeighbor = next neighbor of frontVertex`. What assumptions are you making about the details and efficiency of those lines? What could lead to those lines being more/less efficient?

c. Based on your step-by-step analysis, provide a function that describes the worst-case time complexity of the algorithm using `V` and `E`. This function should include the constants and coefficients. 

d. Identify the asymptotic order of the time complexity of the algorithm (the big-O) by finding a C,  |V|<sub>0</sub>, and |E|<sub>0</sub>.


## Exercise 2
Now you'll analyze the time complexity of depth first search.
Here is the pseudocode from the book:

```
Algorithm getDepthFirstTraversal(originVertex)
traversalOrder = a new queue for the resulting traversal order
vertexStack = a new stack to hold vertices as they are visited
Mark originVertex as visited
traversalOrder.enqueue(originVertex)
vertexStack.push(originVertex)
while (!vertexStack.isEmpty())
{
   topVertex = vertexStack.peek()
   if (topVertex has an unvisited neighbor)
   {
      nextNeighbor = next unvisited neighbor of topVertex
      Mark nextNeighbor as visited
      traversalOrder.enqueue(nextNeighbor)
      vertexStack.push(nextNeighbor)
   }
   else // All neighbors are visited
      vertexStack.pop()
}
return traversalOrder 
```
a. Again analyze the number of simple operations that are required at each step of the algorithm. If there are lines that require you to make assumptions about their efficiency, note those.

b. Based on your step-by-step analysis, provide a function that describes the worst-case time complexity of the algorithm using `|V|` and `|E|`. This function should include the constants and coefficients. 

c. Identify the asymptotic order of the time complexity of the algorithm (the big-O) by finding a C,  |V|<sub>0</sub>, and |E|<sub>0</sub>.

## Extensions
When you finish with the above two exercises, work on implementing breadth first traversal.
Here is [starter code](BFSStarter.zip) and the associated [JavaDocs](/classes/201-f20/hw-6javadoc) for a graph implementation. 
In `Main.java` I've provided code to create this graph:

![Undirected graph with edge between node 0 and 3, node 3 and 1, node 3 and 2, and node 1 and 2](/classes/201-f20/UndirectedGraph.png)

**Implement breadth first traversal** based on the book's pseudocode. 
You can use the `getNeighbors` graph method like so:
```
for(Integer neighbor : inputGraph.getNeighbors(frontVertex)) {
    ...
}
```

Here are the JavaDocs for `Map` and `Queue`:
* [Queue interface](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html)
* [Map interface](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html)

You'll probably want to use a map to store if a vertex is visited.


If you have more time, try these:

1. The algorithm given in [homework 3 (the maze solver)](hw3) is a specialized version of depth-first search. Analyze it and determine what it's time complexity is; why is it different than general depth-first search?
2. Implement depth-first search as well.

## Submitting
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations section) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck. 

Submit your PDF to Moodle as always. (If you did the extensions, just submit the PDF please.)