---
layout: page
title: Homework 7 - IMDB Graph
permalink: /classes/201-f25/hw7
---

**Due: Monday, Nov 10th at 10pm**

* Starter code: [imdb_graph.zip](/classes/201-f25/imdb_graph.zip)  
* Upload solutions via Gradescope as: `IMDBGraph.kt`

## Goals

This assignment is designed to help you with the following:
* practice with graph implementations
* practice with shortest path algorithms

## Collaboration policy

For this assignment, you may work alone or with a partner, but you must type up all of the code yourself.  (It is therefore unexpected for two code submissions to be completely identical.)  You may have at most one partner.

You may also discuss the assignment at a high level with other students.  You can discuss the assignment with Anya, our prefect, or any course staff.

You should list any student or course staff with whom you discussed the assignment (you don't have to include prefect sessions), and the manner of discussion (high level, partner, etc.) in comments at the top of your `IMDBGraph.kt` file.  You also need to include your name.

_If you work alone, you should say so instead._

## Note on style:

The following style guidelines are expected moving forward:

0. You submit only the requested file(s).
1. Variable names should be clear and easy to understand, should _not_ start with a capital letter, and should only be a single letter when appropriate (e.g., `i` or `j` as indices, `x` and `y` as coordinates).
2. The indentation, spacing, and location of curly braces is consistent.
3. There are no extra print statements in your program.
4. There is no commented-out code that is no longer being used (e.g., debugging print statements).
5. Your program has a comment at the top of each function with at least 5 words describing what the function does.
6. There is good use of comments to explain the "why" of your code and empty lines to break up logical chunks.
7. The code doesn't have "magic numbers" -- these are numbers in the code by themselves, rather than stored in a variable.
8. The code doesn't compute the right answer by doing extra work (e.g., having a computation in a loop when it could have been done only once, after the loop).
9. Helper functions are used to reduce code duplication.

## Assessment

The **core** requirements for your submission are:

* complete Parts A and C
    * `connectedPerformers`
    * Reflection
* satisfy the code style expectations #0-#4 above
* include a reflection in comments at the bottom of your `IMDBGraph.kt` file

The **advanced** requirements for your submission are:

* satisfy the core requirements
* complete all of Parts A-C
    * `shortestPath`
* satisfy all code style expectations listed above (#0-#9)
* include your name and collaboration statement at the top of your `IMDBGraph.kt` file

## Assignment overview

There is a classic game called [Six Degrees of Kevin Bacon](https://en.wikipedia.org/wiki/Six_Degrees_of_Kevin_Bacon), where players attempt to find connections between performers (actors) in movies.  A connection is made if two performers appear in a movie together, and the goal is to find the shortest path between two performers.

Here are some examples:

* Michelle Yeoh was in the movie "Wicked" with Jeff Goldblum.  Jeff Goldblum was in the movie "The Life Aquatic with Steve Zissou" with Bill Murray.  So there is a path from Michelle Yeoh to Bill Murray with a distance of 2.
* Eva Mendes was in "My Brother the Pig" with Scarlett Johannson, who was in "The Prestige" with Michael Caine, who was in "Gnomeo & Juliet" with Ozzy Osbourne.  So there is a path from Eva Mendes to Ozzy Osbourne with a distance of 3.

Both of the above examples are also shortest paths, in that there is no shorter path connecting the performers shown.  There may be alternative paths of the same length, but there are no shorter ones.

For this assignment, you will use data from [IMDb.com](https://www.imdb.com/) to build a graph connecting performers with movies and movies with performers.  You'll then implement a shortest path algorithm to find the shortest path between two performers.

## Getting started

Find your `CS201` folder for assignments.  Maybe it contains an `assignments` folder inside of it.

Download [this `imdb_graph.zip` file](/classes/201-f25/imdb_graph.zip) to get the starter code.  Put it in the `CS201` folder and unzip it.  This should give you a folder named `imdb_graph`.  Make sure that you actually unzip / extract the code, don't just open up the .zip file in another window.

Now open your folder in VS Code.  There are multiple ways to do this, so pick one:
* Open VS Code, then select `File` -> `Open Folder` and navigate to the `imdb_graph` folder you just made.
* Open VS Code, then drag and drop the folder (e.g., from Finder in MacOS or File Explorer in Windows) into VS Code to open it.

Either way, if you are asked, click that you trust the authors.  If you have any issues getting started, ask the lab assistants for help -- any of them should be able to help you get started, even if they aren't super familiar with Kotlin.

## Building your code with Maven

Like most of our assignments, this project structure uses Maven, so you can use the following commands (in the VS Code terminal) to execute your code (note that you must be in the top-level folder `imdb_graph` for these commands to work):

* `mvn test` runs the tests that we provided (see below)

* `mvn compile exec:java` compiles and runs the `main` function, which will prompt you for two performers and then show you the shortest path between them (if your code works)

## The data

You'll find in the `src/main/resources` folder a set of files with a cleaned-up version of IMDb data that I'm providing:
* `performer-names.tsv` contains performer IDs and their names
* `movie-titles.tsv` contains movie IDs and their names
* `performances.tsv` contains pairs of movie IDs and performer IDs, indicating that a particular performer appeared in a particular movie

The data in the above files does not represent everything from IMDb.  It was obtained from the [IMDB data download website](https://datasets.imdbws.com/), and then we preprocessed it in the following ways:
* we kept only actual performers, removing people who served all kinds of other roles in movies (director, producer, etc.)
* we removed all movies that had IMDb's "adult" flag set to true
* we removed all movies with words in their title that could be considered "not safe for work", based on matching them against an online database of unacceptable words
* to reduce the size of the dataset, we kept only movies made in 1970 or later

The above explanation is to help get you oriented, but you don't need to access these files directly; **code to read in this dataset is being provided to you.**

## The graph

The graph that you will be constructing is known as a [bipartite graph](https://en.wikipedia.org/wiki/Bipartite_graph), which means that there are two types of nodes, and each node only links to nodes of the other type.  To represent the graph, we will use adjacency lists.

Here is the shell of the class you'll need to complete (which you'll find in `IMDBGraph.kt`):
```kotlin
class IMDBGraph {

    val performersToMovies = HashMap<String, MutableList<String>>()
    val moviesToPerformers = HashMap<String, MutableList<String>>()

    fun connectedPerformers(performerId: String, maxDistance: Int): Set<String> {
        // TODO: Part A
    }

    data class Connection(val performerId: String, val movieId: String)

    fun shortestPath(startPerformer: String, endPerformer: String): List<Connection> {
        // TODO: Part B
    }
}
```

The `performersToMovies` map is a set of adjacency lists: each performer ID maps to a list of movie IDs.  Likewise,  `moviesToPerformers` maps from each movie ID to a list of performer IDs.

## Part A: Connections for a given performer

First, you'll need to implement the `connectedPerformers` function.  This function should return a list of IDs for all performers that connect to a given performer within a certain number of steps.  Here are some examples:
* `connectedPerformers("nm0026511", 1)` returns a list of all of the performers that have appeared with `nm0026511` (Ingemar Andersson) in a film.  According to our dataset, that answer is 6.  (The list should not include the original performer.)
* `connectedPerformers("nm0026511", 2)` returns a list of all of the performs that have performed with Ingemar Andersson in a film (i.e., all of the answers above), plus additionally all performers that have appeared with any of those.

Once you have this function implemented, you should pass the `testConnectedPerformers` test when you run `mvn test`.

## Part B: Shortest path between two performers

Next, you will implement the `shortestPath` function.  This function should return a list of the connections between two performers on the shortest path between those two performers.  This should be returned in a list of `Connection` objects, where a `Connection` object contains a performer and the movie that connects them.

Here is the explanation you'll find in your starter code (note that you should remove this long explanation from your finished code):
```kotlin
/*
   For example, consider a possible shortest path from Jack Nicholson to
   Elizabeth Olsen:

   nm0000197 Jack Nicholson
     tt0082934 The Postman Always Rings Twice
   nm0001448 Jessica Lange
     tt0409379 In Secret
   nm0647634 Elizabeth Olsen

   If this function were called with nm0000197 and nm0647634, the return value
   could be this list of Connections:
   [Connection(nm0000197, tt0082934), Connection(nm0001448, tt0409379)]

   (It is possible the code might find a different set of connections between
   the two performers, but the length must be the same as the above, as the
   above is a shortest path.)

   The endPerformer is not included in the connections returned.

   If there is no connection between the two, return an empty list.
*/
```

Once you have this function working, all tests should pass when you run `mvn test`.

## Part C: Reflection

Were there any particular issues or challenges you dealt with in completing this assignment?  How long did you spend on this assignment?

Write a brief discussion (a sentence or two is fine) at the bottom of your `IMDBGraph.kt` file (in comments, so each line should start with `//` or be in a `/* */` block).

Here are some examples:

```kotlin
// Reflection:
// I got really mixed up working with the two maps.
// I couldn't figure out what the Connection class was.
// I spent 8 hours on this assignment.
```

```kotlin
// Reflection:
// I started late, so I had to rush to make sure I knew how to test my code.
// It may be good to start early next time.
// I spent 6 hours on this assignment.
```

```kotlin
// Reflection:
// It went fine; I found what I needed in my notes.
// I spent 3 hours on this assignment.
```

&nbsp;