---
layout: page
title: HW 3 Solving Mazes
permalink: /classes/201-f21/hw3
---

## Logistics
30 points, due Friday, Oct 8th by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy.  You or your partner need to notify me that you're using the policy via email, CC'ing the partner. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still Friday, not 48 hours later.

## Goals
To gain practice with Stacks and see how they can be useful.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You must work on this homework with your assigned partner (if you have one) via pair programming. That means that you cannot write **any** code without your partner and you must both be fully engaged and discussing the code at all times while working. See the [collaboration policy](collaboration) for details.

## Setup and Requirements
Mount COURSES, download the [HW3 starter code](HW3Starter.zip) and move it to your StuWork/username folder. You should follow the same process of compressing your files and uploading them to Moodle to submit your homework. 

The code that you write for this assignment will build on top of the Stack ADT and an interface that I have provided. Java deals with Stacks rather oddly in that Stack is a class, rather than an interface. Instead of using Java's Stack, you will use the Stack interface I've provided (`Stack.class`) and make your own implementation. **For this assignment, you must use the Stack interface and your own implementation. You may not use the built in Java Stack or Deque.**

Create a file Collaborations.txt and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.

## Specification
In this assignment, you will load in a maze from a file and solve the maze, printing the maze either with or without the solution marked. I've provided you with a `load` and `print` method and with most of the `MazeSquare` class.
You will implement a `LinkedStack` and the method for solving the maze.

### The maze file format
Mazes are stored in text files and follow a particular format. We assume that our mazes are rectangular, and that they have walls along the entire outside of the maze, with no gaps in these outer walls. We will also specify a “start square” (S) and a “finish square” (F) to indicate the goal of the maze-solver — to get from S to F.

Maze files should have the following structure:
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
A solution isn't very helpful if you can't see it! You should update `getSolution` so that it marks `MazeSquare`s appropriately and your `main` so that when the user indicates that they want a solution, it prints the solved maze:
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

If the maze is not solvable, your program should print a friendly message stating that.

### User Input
You should edit the `main` method of `Maze.java` so that it takes in information from the user on which maze they want solved and whether they want it displayed as solved or not. You can choose how you get this user input and what extra flavor text you include. At a minimum, you need:

* a way for the maze to be displayed without a solution shown,
* a way for the maze to be displayed with the solution, marked with *, if there is a solution,
* a way for the user to be told that the maze is not solvable.

## Stress testing
You should create at least one unsolvable maze to verify and demonstrate how your program handles those.

You should also create at least 2 of your own mazes that are more complicated and test your program in unique ways (for example, needing to go right to find the finish instead of left, or needing to move down). You are welcome to create more maze files, but you must create at least 2 and verify that your program behaves correctly.

## README
As always, you should include a detailed README for this homework. 
It should include a brief overview of your project, a short example of how to run your program and see its interesting behavior, and a more detailed section that has **demonstration input for each of the rubric items**. Remember, you want to make it as easy as possible for the grader to see that your homework does everything its supposed to!

### Prompt
Your solver may not find the shortest path through a complex maze, but it does find a path if there is one (as long as its implemented correctly). We'll discuss more on why that is in the coming weeks, but for this README, **explain why the Stack is an appropriate ADT to use to simulate a human solving a maze (as opposed to a Queue).** 

## Rubric
Your assignment will be graded as follows:

| Item | Points |
|------|-------|
| README is clear and complete, including answer to prompt | 6 |
| Mazes can be displayed without a solution shown | 5 |
| Solved mazes found and displayed correctly | 5 |
| Program works on unsolvable mazes | 5 |
| Two distinct mazes provided | 4 |
| JavaDocs documentation filled in | 4 |
| Otherwise good style | 1 |

## Submission
Remember to update your Collaborations.txt file with any sources that you consulted.

Then make a .zip of your files and upload it to Moodle. If you are working with a partner, only one of you should submit on Moodle, the grader will handle giving you both the same score.