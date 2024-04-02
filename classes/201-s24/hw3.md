---
layout: page
title: HW 3 Solving Mazes
permalink: /classes/201-s24/hw3
---

## Logistics
This is a paired assignment, so you should complete it with your assigned partner, if you have one, via paired programming (the same partners as HW2). The whole time that you are working, you should both be present and actively working on the problem at hand. (Two brains, one keyboard.) Switch off the typing duties so that you each type for roughly half of the time.

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is due on April 17th at 10pm. As with all assignments, you will have the opportunity to [revise](revision-process) this assignment individually based on the feedback that you get.

## Goals
To gain practice with Stacks and see how they can be useful.

## Assessment
To demonstrate proficiency, your program needs to:

* Pass all tests on Gradescope
* Display mazes and solutions as specified
* Work on unsolvable mazes correctly
* Follow the specifications for the command-line
* Implement `LinkedStack` correctly
* Be object-oriented
* Have a README with an overview, example, and [response to the prompt](#prompt)
* Be somewhat [well-styled](style-reference)

To **demonstrate mastery**, your program needs to:
* Demonstrate proficiency
* Have JavaDocs documentation for all public methods
* Include two distinct mazes and one unsolvable maze
* Create and use helper methods correctly and effectively
* Use `LinkedStack` effectively
* Be extremely [well-styled](style-reference) and clear by choosing descriptive variable names, using helper methods, and including useful comments 
* Have a thorough, well-styled README with thoughtful prompt response
* Have clear and thorough documentation

## Setup and Requirements
Mount COURSES, download the [HW3 starter code](HW3Starter.zip) and move it to your StuWork/username folder.

The code that you write for this assignment will build on top of the Stack ADT and an interface that I have provided. Java deals with Stacks rather oddly in that Stack is a class, rather than an interface. Instead of using Java's Stack, you will use the Stack interface I've provided (`Stack.class`) and make your own implementation. **For this assignment, you must use the Stack interface and your own implementation. You may not use the built in Java Stack or Deque.** Ignore VSCode's red squiggles!

Create a file Collaborations.txt and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.

You may find [resources on this list](resources) helpful for Java-specific things.

## Specification
In this assignment, you will load in a maze from a file and solve the maze, printing the maze either with or without the solution marked. I've provided you with a `load` and `print` method and with most of the `MazeSquare` class.
You will implement a `LinkedStack` and the method for solving the maze.

### The maze file format
Mazes are stored in text files and follow a particular format. We assume that our mazes are rectangular, and that they have walls along the entire outside of the maze, with no gaps in these outer walls. We will also specify a “start square” (S) and a “finish square” (F) to indicate the goal of the maze-solver — to get from S to F.

Maze files have the following structure:
```
<Number of rows> <Number of columns>
<0-based row number of the start square> <0-based column number of the start square>
<0-based row number of the finish square> <0-based column number of the finish square>
<Row 0 description>
<Row 1 description>
...
```       
Each row description includes a single character for each square in that row, and each character describes the right and top walls for its square. Specifically:

* `7` means that the square has both a top wall and a right wall
*  `|` (vertical bar or pipe) means that the square has a right wall, but no top wall
* `_` (underscore) means that the square has a top wall, but no right wall
* `*` (asterisk) means that the square has neither a top wall nor a right wall
Putting this together in a small example, if the input file contains the following:

| File	| Interpretation |
|-------|----------------|
| `2 3` | The maze has 2 rows and 3 columns |
| `1 1`| The start square is in the bottom middle. |
| `0 2`| The finish square is in the upper right. |
| `__7` | (0,0) has a top wall; (0,1) has a top wall; (0,2) has a top and right wall |
| `*_7 `| (1,0) has neither top or right walls; (1,1) has a top wall; (1,2) has a top and right wall |

then the resulting maze would be printed as follows:
```
+-----+-----+-----+
|                 |
|              F  |
|                 |
+     +-----+-----+
|                 |
|        S        |
|                 |
+-----+-----+-----+
```

Note that we specify only the top and right walls for each square, and not the bottom and left walls. This is sufficient to describe the whole maze; make sure to understand why this is.

### JavaDocs
There is a lot of provided code, but the documentation is missing for many of the methods.
Read through the methods and fill in the JavaDocs documentation.

### LinkedStack
I've provided a `Stack.class` file with the Stack interface and a starter file `LinkedStack.java` with the necessary stubs for the Stack interface and the private `Node` class. Implement each of the methods as specified by the JavaDocs method comment.

Note that VSCode won't quite understand that `Stack.class` exists without `Stack.java` so there might be a squiggly error line underneath `Stack`, but the code will compile just fine still. Don't trust the squiggles!

### Solving the maze
Stacks are very useful when solving a maze and a classic algorithm is actually based on this idea. We'll talk about the algorithm more later in the term, but I'll just give you the steps for now:

1. Create an empty stack of maze squares.
2. Get the start square.
3. Add the start square to the stack and mark the start square as 'visited'.
4. While the stack isn't empty:
    5. Check if the top item is the finish square, if it is, you're done and the stack contains a solution to the maze.
    6. Look at each square adjacent to the top item (up, down, right, and left, not diagonals) and look for one that is neither blocked (by a wall) nor already visited. If you find one, mark it as visited and put it on the stack. Go back to step 4. (I recommend you make methods to check in each direction to keep your code more organized.)
    7. If there are no squares adjacent to the top item that are neither blocked nor already visited, remove the top item from the stack and go back to step 4. (This is like hitting a dead end in a maze and backtracking.) 
8. If the stack becomes empty before you find the finish square, the maze is unsolvable and you should return the empty stack.

You should implement these steps in `getSolution()`.
As you are working on implementing these steps, you should definitely create new methods in `Maze.java` that are called within `getSolution()` to make the method shorter and easier to read.
You should also test your code frequently to make sure that small pieces are working as you expect.

You may encounter an infinite while loop when you try to run your code for the first time (where the program just keeps running and doesn't stop). A helpful debugging approach is to temporarily add a `count` variable that cuts the while loop off after a reasonable number of steps based on your maze and put in print statements to track through what your code is doing and find where it is getting stuck.

You should at least make sure that you code stops looping before moving on.

### Printing the solution
A solution isn't very helpful if you can't see it! You should update `getSolution` so that it marks `MazeSquare`s appropriately and your `main` so that, when the user includes the command-line argument `--solution`, your program produces a solved maze like this:
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

Check that you are now able to print a solution to the maze and successfully solved the example maze.

If the maze is not solvable, your program should print a friendly message stating that. **Your message must include the string "Unsolvable".**

### User Input
You should edit the `main` method of `Maze.java` so that it takes in information from the user on which maze they want solved and whether they want it displayed as solved or not with the following command-line argument structure: `java Maze mazefile --solution`. The first command line argument is the name of the maze file and the second command line argument is *optional* and indicates the user wants the solution shown. Here are two example interactions that you should support:

```bash
% java Maze maze.txt
+-----+-----+-----+
|                 |
|              F  |
|                 |
+     +-----+-----+
|                 |
|        S        |
|                 |
+-----+-----+-----+
% java Maze maze.txt --solution
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

If the maze is unsolvable, your program should state that instead of displaying the solution (including the string "Unsolvable" in the output).

## Stress testing
You should create at least one unsolvable maze to verify and demonstrate how your program handles those, which you should name `unsolvable.txt`.

You should also create at least 2 of your own mazes that are more complicated and test your program in unique ways (for example, needing to go right to find the finish instead of left, or needing to move down). You are welcome to create more maze files, but you must create at least 2 and verify that your program behaves correctly. You must name them `maze2.txt` and `maze3.txt`.

## README
As always, you should include a detailed README for this homework. 
It should include a brief overview of your project and a short example of how to run your program and see its interesting behavior.

### Prompt
Your solver may not find the shortest path through a complex maze, but it does find a path if there is one (as long as its implemented correctly). We'll discuss more on why that is in the coming weeks, but for this README, **explain why the Stack is an appropriate ADT to use to simulate a human solving a maze (as opposed to a Queue).** 

## Submission
Remember to update your Collaborations.txt file with any sources that you consulted.

Then upload all of your files to the Gradescope link on Moodle, at which point the autograder will run and let you know if your code works correctly. You are able to submit your code as many times as you wish before the deadline to fix any issues. If you have questions about what the autograder is telling you is wrong, please ask!