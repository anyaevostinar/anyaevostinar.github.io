---
layout: page
title: Traversals Analysis
permalink: /classes/201-w24/traversal-analysis
published: true
---

## Goals
To analyze the time complexity of depth first and breadth first traversal.

## Logistics
This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and quizzes so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
Even though you haven't seen or written code for graph traversals, you can still analyze the time complexity of pseudocode.

Here is pseudocode for breadth-first search:

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

When we analyze the time and space complexity of graph algorithms, the convention is to use `|V|` for the number of vertices/nodes in the graph and `|E|` for the number of edges in the graph.
Because the complexity of graphs often depends on both the number of vertices and the number of edges, you'll often need to express the complexity in terms of `|V|` and `|E|`. 

a. Analyze the number of simple operations that are required at each step of the above algorithm. You are welcome to copy the steps above and then put your analysis on each line. 

b. Some of the lines of pseudocode are hiding a fair amount of detail, such as `frontVertex has a neighbor` and `nextNeighbor = next neighbor of frontVertex`. What assumptions are you making about the implementation details and efficiency of those lines? What could lead to those lines being more/less efficient?

c. Based on your step-by-step analysis, provide a function that describes the worst-case time complexity of the algorithm using `V` and `E`. This function should include the constants and coefficients. 

d. Identify the asymptotic order of the time complexity of the algorithm (the big-O) by finding a C,  |V|<sub>0</sub>, and |E|<sub>0</sub>.


## Exercise 2
Now you'll analyze the time complexity of depth first search.
Here is pseudocode:

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

## Exercise 3
Let's analyze the time complexity of the two graph implementations that you've seen. You should reference the code from the [Graph Implementation](graphs) lab.

a. What is the worst case time complexity of adding a vertex in an adjacency matrix graph implementation (without adding any edges)? Express your answer in big-O notation and write a sentence explaining why.

b. What is the worst case time complexity of adding a vertex in an adjacency **list** graph implementation (without adding any edges)? Express your answer in big-O notation and write a sentence explaining why.

c. What is the worst case time complexity of the `getDegree` method of the adjacency matrix graph implementation in big-O notation? Write a sentence explaining why.

d. What is the worst case time complexity of the `getDegree` method of the adjacency list graph implementation in big-O notation? Write a sentence explaining why. Remember to account for the time complexity of the underlying linked list operations!

## Exercise 4
Try out implementing breadth-first traversal.
Here is [starter code](/classes/201-f21/BFSStarter.zip) and the associated [JavaDocs](/classes/201-f20/hw-6javadoc) for a graph implementation. 
In `Main.java` I've provided code to create this graph:

![Undirected graph with edge between node 0 and 3, node 3 and 1, node 3 and 2, and node 1 and 2](/classes/201-f20/UndirectedGraph.png)

**Implement breadth first traversal** based on the pseudocode above. 
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

## Extra

If you have more time, try these:

1. The algorithm given in [homework 3 (the maze solver)](hw3) is a specialized version of depth-first search. Analyze it and determine what it's time complexity is; why is it different than general depth-first search?
2. Implement depth-first search as well.
