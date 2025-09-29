---
layout: page
title: Homework 3 - Maze Solver
permalink: /classes/201-f25/hw3
---

**Due: Friday, Oct 10th, at 10:00pm**

Starter code: [maze_solver.zip](maze_solver.zip)  
Upload solutions via Gradescope as: `SolvableMaze.kt` and `Main.kt`

## Goals

This assignment is designed to help you practice the following:
* using stacks
* implement an example application of stacks

## Collaboration policy

For this assignment, you may work alone or with a partner, but you must type up all of the code yourself.  (It is therefore unexpected for two code submissions to be completely identical.)  You may have at most one partner.

You may also discuss the assignment at a high level with other students.  You can discuss the assignment with Anya, our prefect, or any course staff.

You should list any student or course staff with whom you discussed the assignment (you don't have to include prefect sessions), and the manner of discussion (high level, partner, etc.) in comments at the top of your `Main.kt` file.  You also need to include your name.

_If you work alone, you should say so instead._

## Note on style:

The following style guidelines are expected moving forward:

1. Variable names should be clear and easy to understand, should _not_ start with a capital letter, and should only be a single letter when appropriate (e.g., `i` or `j` as indices, `x` and `y` as coordinates).
2. The indentation, spacing, and location of curly braces is consistent.
3. There are no extra print statements in your program.
4. There is no commented-out code that is no longer being used (e.g., debugging print statements).
5. Your program has a comment at the top of each function with at least 5 words describing what the function does.
6. There is good use of comments to explain the "why" of your code and empty lines to break up logical chunks.
7. The code doesn't have "magic numbers" -- these are numbers in the code by themselves, rather than stored in a variable.
8. The code doesn't compute the right answer by doing extra work (e.g., having a computation in a loop when it could have been done only once, after the loop).
9. **You should use helper functions to reduce how big `solveMaze` is. It shouldn't be longer than 40 lines including empty lines.**

## Assessment
Note that on this assignment, the Gradescope tests can only run your code and display the output. **Just because they are green, doesn't mean that you have correctly implemented the Maze.** A human grader will review the output to make sure that you are displaying the right thing and **you should look at the output and make sure that it meets the requirements.**

The **core** requirements for your submission are:

* complete Parts B, C, and E
    * B: implementing `solveMaze`
    * C: printing the solution
    * E: reflection
* satisfy the code style expectations #1-#4 above
* include a reflection in comments at the bottom of your `Main.kt` file

The **advanced** requirements for your submission are:

* satisfy the core requirements
* complete all of Parts B-E
    * D: getting command line arguments
* satisfy all code style expectations listed above (#1-#9)
* include your name and collaboration statement at the top of your `Main.kt` file

## Assignment overview

In this assignment, you will load in a maze from a file and solve the maze, printing the maze either with or without the solution marked.  We've done a lot of the work for you; you're given code for a Stack, as well as code to store a maze and print it.

Your goal: write code to find a solution path through the maze, if one exists.

## Getting started

Find your `cs201` folder for assignments.  Maybe it contains an `assignments` folder inside of it.

Download [this `maze_solver.zip` file](maze_solver.zip) to get the starter code.  Put it in your `cs201` folder and unzip it.   Make sure that you actually unzip / extract the code, don't just open up the .zip file in another window.

Now open your folder in VS Code.  There are multiple ways to do this, so pick one:
* Open VS Code, then select `File` -> `Open Folder` and navigate to the folder you just made.
* Open VS Code, then drag and drop the folder (e.g., from Finder in MacOS or File Explorer in Windows) into VS Code to open it.

Either way, if you are asked, click that you trust the authors.  If you have any issues getting started, ask the lab assistants for help -- any of them should be able to help you get started, even if they aren't super familiar with Kotlin.

## Building your code with Maven

Like Assignment #1, this project structure uses Maven, so you can use the following commands (in the VS Code terminal) to execute your code **(note that you must be in the top-level folder `maze_solver` for these commands to work)**:

* `mvn test` runs the tests that we provided (see below)

* `mvn compile exec:java` compiles and runs your code, as specified in your `main` function

* `mvn compile` compiles your code, but doesn't run it (this is like `kotlinc` by itself)

If you want to see less output from Maven, you can add `-q` (for "quiet") flag:

* `mvn -q test` run tests, with less output

* `mvn -q compile exec:java` runs your `main` function, with less output (but still any print statements you have)

If you run the tests with the starter code, you should have errors, as you haven't written any code yet.

## Specification: maze file format

The mazes for this assignment are stored in text files and follow a particular format.  We assume that our mazes are rectangular, and that they have walls along the entire outside of the maze, with no gaps in these outer walls.  We will also specify a "start square" (S) and a "finish square" (F) to indicate the goal of the maze solver: to get from S to F.

Maze files should have the following structure:
```
<number of rows> <number of columns>
<0-based row number of S> <0-based column number of S>
<0-based row number of F> <0-based column number of F>
<row 0 description>
<row 1 description>
...
```

Each row description includes a single character for each square in that row, and each character describes the right and top walls for its square.  Specifically:
* `7` means that the square has both a top wall and a right wall
* `|` (vertical bar or "pipe") means that the square has a right wall, but no top wall
* `_` (underscore) means that the square has a top wall, but no right wall
* `*` (asterisk) means that the square has neither a top wall nor a right wall

Putting this together in a small example, if the input file contains the following:
```
2 3
1 1
0 2
__7
*_7
```

then we can interpret it as:
* 2 rows and 3 columns
* S is at (1,1) (bottom middle)
* F is at (0,2) (top right)
* (0,0) has a top wall; (0,1) has a top wall; (0,2) has top and right walls
* (1,0) has neither top nor right walls; (1,1) has a top wall; (1,2) has top and right walls

In this case, the resulting maze would be printed as:
```
+-----+-----+-----+
|                 |
|               F |
|                 |
+     +-----+-----+
|                 |
|        S        |
|                 |
+-----+-----+-----+
```

Note that we specify only the top and right walls for each square, and not the bottom and left walls.  This is sufficient to describe the whole maze; make sure to understand why this is.

## Part A: Working with the stack and maze squares

To get yourself started, you should not actually attempt to solve the maze, but instead fill in a solution path that starts at the start square and goes to the right until it hits a dead end.  It should stop there, even if it isn't the finish square.  For example, if this is your maze:
```
+-----+-----+-----+
|                 |
|               F |
|                 |
+     +-----+-----+
|                 |
|  S              |
|                 |
+-----+-----+-----+
```

then your first pass on code should fill in asterisks as follows:
```
+-----+-----+-----+
|                 |
|               F |
|                 |
+     +-----+-----+
|                 |
|  S     *     *  |
|                 |
+-----+-----+-----+
```

## Part B: Solving the maze

Stacks are very useful when solving a maze and a classic algorithm is actually based on this idea.  Here are the steps, modified only slightly from what we saw in class:

1. Create an empty stack of maze squares, and get the start square for the maze.
2. Add the start square to the stack and mark it as "visited".
3. While the stack isn't empty:
    * Check if the top item is the finish square, and if it is, you're done and the stack contains a solution to the maze.
    * Otherwise, look at each square adjacent to the top (up, down, right, and left, but not diagonals) until you find one that is neither blocked (by a wall) nor already visited.
        - If you find such a square, mark it as visited and put it on the stack.  Go back to step 3.  (For cleanest style, you should add functions to check each direction.)
        - Otherwise, if there are no squares adjacent to the top item that are neither blocked nor already visited, remove the top item from the stack and go back to step 3.  (This is like hitting a dead-end in a maze and backtracking.)
4. If the stack becomes empty before you find F, the maze is unsolvable and you should return the empty stack.

You should implement these steps in the `solveMaze()` function within `SolvableMaze.kt`.  As you are working on implementing these steps, you should definitely create new functions that are called from `solveMaze()` to make that function shorter and easier to read.

Make sure to also test your code frequently, to make sure that small pieces are working as you expect.  You may encounter an infinite while loop when you try to run your code for the first time (when the program just keeps running and doesn't stop).  A helpful debugging approach is to temporarily add a `count` variable that `break`s out of the while loop after a reasonable number of steps based on your maze, and put in print statements to track through what your code is doing and find where it is getting stuck.  You should at least make sure that your code stops looping before moving on.

## Part C: Printing the solution

A solution isn't very helpful if you can't see it!  You should update `solveMaze` so that it marks each `MazeSquare` appropriately so that it prints the solved maze, like so:
```
+-----+-----+-----+
|                 |
|  *     *     F  |
|                 |
+     +-----+-----+
|                 |
|  *     S        |
|                 |
+-----+-----+-----+
```

Check that you are now able to print a solution to the maze and successfully solved the example maze.  If the maze is not solvable, your program should print a friendly message stating that.
```
This maze has no solution.
+-----+-----+-----+
|                 |
|              F  |
|                 |
+-----+-----+-----+
|     |           |
|     |  S        |
|     |           |
+-----+-----+-----+
```

## Part D: Getting user input

The user may not actually want to see the solution (maybe they want to run it first to see the maze, then run it again to see the solution).

Your code should support the following:
* a first *command-line argument* for which maze to solve -- this is the name of a file (default: `maze1.txt`)
* a second command-line argument for whether to display the solved path -- this is given as `--solve` (default: do not show the solution)


To implement these, you should edit the `main` function in `Main.kt` so that it takes in information from the user on which maze they want solved and whether they want it displayed as solved or not. Here is how you get command-line arguments:

```kotlin
fun main(args: Array<String>) {
    //args contains all the things you typed after kotlin MainKt.class
    println(args.contentToString())
}
```

To test your command line argument, first compile your code with `mvn compile`, then you should be able to test this part as follows:

1. Make sure you're in the top level of the folder.

2. Type in the terminal:
    ```bash
    cd target/classes
    ```

3. Try running it while specifying a maze:
    ```bash
    kotlin MainKt.class maze2.txt
    ```

4. Try running it with both a maze and showing the solution:
    ```bash
    kotlin MainKt.class maze2.txt --solve
    ```

5. Need to make fixes?  Use this at the terminal to get back to the top-level folder:
    ```bash
    cd ../..
    ```
    then go back to step 1.



# Part E: Reflection

Were there any particular issues or challenges you dealt with in completing this assignment?  How long did you spend on this assignment?

Write a brief discussion (a sentence or two is fine) at the bottom of your `Main.kt` file (in comments, so each line should start with `//` or be in a `/* */` block).

Here are some examples:

```kotlin
// Reflection:
// I had trouble getting figuring out how to find neighbor squares.
// I had to look up how to get user input in Kotlin documentation and scavenger hunt examples.
// I spent 6 hours on this assignment.
```

```kotlin
// Reflection:
// I started late, so I had to rush to make sure I knew how to test my code.
// It may be good to start early next time.
// I spent 5 hours on this assignment.
```

```kotlin
// Reflection:
// It went fine; I found what I needed in my notes.
// I spent 3 hours on this assignment.
```

# Hints and suggestions

* Try to complete Part A (just working with the stack and maze squares) early.  This doesn't require any actual implementation of the maze-solving algorithm, so the logic can be much simpler.  It's not the final version that you'll submit, but it should help you get comfortable with the basics.

* Take a look at the `MazeSquare` class to see what it has available.

* For Part B, don't try to solve it all at once.  First, try to get it working while checking only neighbor to the top.  Then add in additional directions to check one at a time.

* As you are working on `solveMaze`, break it up into helper functions to make the conditional logic easier to think about.

&nbsp;