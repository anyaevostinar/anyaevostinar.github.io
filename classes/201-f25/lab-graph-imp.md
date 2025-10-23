---
layout: page
title: Graph Implementation Lab
permalink: /classes/201-f25/graph-imp-lab
published: true
---

## Goals
To better understand the tradeoffs of the adjacency matrix and adjacency list graph implementations by implementing them yourself.

## Setup
[Mount the COURSES drive](scavenger-hunt) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK/username called `GraphImpLab`
* Download the [starter code `GraphsLab.kt`](/classes/201-f25/GraphsLab.kt) and put it into your GraphImpLab folder
* Open your `GraphImpLab` folder in VSCode

## Exercise 1
Take a look at `main`, which has two different versions of a graph. Start off by drawing (on the worksheet's last page):
* The graph abstractly, with circles for vertices and lines for edges
* The graph as an adjacency matrix
* The graph as an adjacency list

## Exercise 2
Now implement `addEdge` for both the `AdjMatrixGraph` and `AdjListGraph`. These will be short methods; you aren't adding a node. 

Once you have them implemented, compile and run the file to make sure that what is printed matches your drawings.

## Exercise 3
Implement the following methods for both implementations:
* `hasEdge` 
* `removeEdge`
* `getNeighbors`

What is the worst-case time complexity for each of these methods in the two implementations? Write them down on your worksheet and make sure that they are in terms of `|V|` (the number of vertices) and/or `|E|` (the number of edges).

## Exercise 4
1. Implement `addVertex` for each of the versions. 

For `AdjMatrixGraph`, you will need to grow the array, which you can do fairly easily in Kotlin like so:
```kotlin
adjMatrix = adjMatrix + Array<Boolean>(adjMatrix.size + 1) {false}
```

The above adds a new row to the array and fills it with `false`. You will also need to expand each of the existing rows and should think carefully about how to do that.

2. Write down the worst case time complexity for each of the versions of `addVertex`. 

Submit your completed implementations to Moodle for an extra engagement credit.

## Extra
We've been focused on undirected and unweighted graph implementations. You can also allow edges to have a value, i.e. a "weight" and/or a direction, so 0->1 but the reverse isn't guaranteed. Try making changes to your implementations to support one or both of those functionalities.