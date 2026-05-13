---
layout: page
title: Traversals Lab
permalink: /classes/201-s26/traversal-lab
published: true
---

## Goals
To analyze breadth-first traversal (and possible depth-first as well) and consider how to apply them to solve problems.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
First let's think more in-depth about the time complexity of breadth-first traversal (or breadth-first search in the worst case). Here is the code from the reading:

```
class BfsSolver<V>(val graph: GraphADT<V>, val start: V) {
    val previous = mutableMapOf<V, V?>()
    val distance = mutableMapOf<V, Int>()

    init {
        bfs(start)
    }

    private fun bfs(start: V) {
        previous[start] = null
        distance[start] = 0
        val queue = ListQueue<V>()
        queue.enqueue(start)
        while (queue.size() > 0) {
            val current = queue.dequeue()
            val neighbors = graph.getNeighbors(current)!!
            for (neighbor in neighbors) {
                if (neighbor !in previous) {
                    previous[neighbor] = current
                    distance[neighbor] = distance[current]!! + 1
                    queue.enqueue(neighbor)
                }
            }
        }
    }
}
```


Remember that when we analyze the time and space complexity of graph algorithms, the convention is to use `|V|` for the number of vertices/nodes in the graph and `|E|` for the number of edges in the graph.
Because the complexity of graphs often depends on both the number of vertices and the number of edges, you'll often need to express the complexity in terms of `|V|` and `|E|`. 

a. Analyze the number of simple operations that are required at each step of the above algorithm and note them on your worksheet

b. Some of the lines of code are hiding a fair amount of detail, such as `graph.getNeighbors(current)!!`. What assumptions are you making about the efficiency of the graph implementation?

c. What is the Big-O time complexity of BFS in terms of `V` and `E` based on your analysis?

## Exercise 2
To do the same analysis on depth-first traversal, we need to switch it to being iterative instead of recursive. Download this simplified version of the [`DfsSolver` from the reading](GraphSearchLab.kt), along with this graph implementation [`AdjacencyMap.kt`](AdjacencyMap.kt). I

You can switch DFS to being iterative by doing something very similar to HW3 with a stack. Within `dfs` create a stack with a `mutableListOf<V>` and refactor the function to place vertices on the stack instead of recursing. (You will likely notice that it is extremely similarly structured to BFS with that one key difference!)

Remember that you can compile and make sure your code is functional with the following:
```bash
kotlinc AdjacencyMap.kt GraphSearchLab.kt
kotlin GraphSearchLabKt
```

## Exercise 3
Now that you have an iterative version of depth-first traversal, perform the same line by line analysis (as comments in your code) to demonstrate it's worst case time complexity. Include the Big-O as a comment at the top of the function.

## Submission
Submit your completed `GraphSearchLab.kt` file to Moodle for an extra engagement credit.

## Extra

If you have more time, try these:

1. The algorithm given in [homework 3 (the maze solver)](hw3) is a specialized version of depth-first search. Analyze it and determine what it's time complexity is; why is it different than general depth-first search?
2. Which search would be best for detecting if a directed graph has a cycle in it? Implement a cycle detector to try it out.