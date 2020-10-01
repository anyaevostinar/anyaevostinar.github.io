---
layout: page
title: HW 5 Solving Mazes
permalink: /classes/201-f20/hw5
---

## Logistics
25 points, due Wednesday, Oct 14th by 10PM Central time. Like all assignments, there is a 48-hour, no questions asked extensions policy. If you have a tech issue, a health issue, or some other issue that impedes making the deadline, use this policy. You need to notify me that you're using the policy. Extensions beyond the 48-hour policy will only be considered in extenuating circumstances, and circumstances that arise between the original deadline and the extension are generally not extenuating - the deadline is still the deadline, not 48 hours later.

## Goals
To gain practice with several data structures and ADTs we've learned about so far including some variety of list or array and the Stack ADT.

## Assignment Type and Collaborative Learning Expectations
This is a homework assignment that you'll be handing in on Moodle.

You're welcome to either complete this homework with input from one or more members of your collaborative learning group or to complete it on your own. You and the other members of your collaborative learning group should each write your own code, even if you're helping one another, but you may share your screens/use multiplayer mode to look at one another's code, make suggestions, and compare ideas. Take a look at the Collaboration Policies document on Moodle if you have any questions about what's permitted.

## Setup and Requirements
Repl.it Classroom (not all of Repl.it, just the Classroom functionality) is being discountinued and is apparently crashing sometimes, so instead of using a Project, you should make a new repl, make it private, and then upload the files in [this zip folder](/classes/201-f20/HW06-Starter.zip). You should follow the same process of downloading your files and uploading them to Moodle to submit your homework. 

The code that you write for this assignment will build on top of the Stack ADT and an implementation that I have provided. Java deals with Stacks rather oddly in that Stack is a class, rather than an interface. Instead of using Java's Stack, you will use the Stack interface I've provided (Stack.java) and an implementation of it called MysteryStackImplementation. You don't need to know anything about the implementation, but you can look at the interface Stack to know what methods in MysteryStackImplementation you can use and what they do. **For this assignment, you must use the Stack interface and implementation that I have provided. You may not use the built in Java Stack or Deque.**

## Specification
In this assignment, you will load in a maze from a file and solve the maze, printing the maze either with or without the solution marked. I've provided you with a `print` method and with most of the `MazeSquare` class, although you'll add some code to `MazeSquare`.

### The maze file format
Mazes are stored in text files and follow a particular format. We assume that our mazes are rectangular, and that they have walls along the entire outside of the maze, with no gaps in these outer walls. We will also specify a “start square” (S) and a “finish square” (F) to indicate the goal of the maze-solver — to get from S to F.

Maze files should have the following structure:
```
<Number of columns> <Number of rows>
<0-based column number of the start square> <0-based row number of the start square> 
<0-based column number of the finish square> <0-based row number of the finish square> 
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
| `3 2` | The maze has 3 columns and 2 rows |
|` 1 1 `| The start square is in the bottom middle. |
|` 2 0 `| The finish square is in the upper right. |
|` __7` | (0,0) has a top wall; (0,1) has a top wall; (0,2) has a top and right wall |
|` *_7 `| (1,0) has neither top or right walls; (1,1) has a top wall; (1,2) has a top and right wall |

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

## Load and print the maze
Before you can solve a maze, you need to be able to load in the text file and print out the maze as specified above.

### Saving your squares
First decide how you will store the `MazeSquare`s that represent the maze. You could use any of the lists/arrays that we've learned about, but you'll probably want it to be two-dimensional so that you have a list of lists with MazeSquares or an array of arrays with MazeSquares so that you can represent the rows and columns most intuitively.
Remember that in Java to have a nested data structure such as an ArrayList, you would do:
```
List<ArrayList<String>> nestedList = new ArrayList<ArrayList<String>>();
```
or for arrays:
```
String[][] nestedArray = new String[4][4];
```

### Constructing a MazeSquare
You'll probably want to make a constructor for `MazeSquare` that takes in all the instance variables and sets them.

### load method
Now you're ready to write the `load` method of `Maze`. You should open the file and process through each line, setting the instance variables of `Maze` first and then creating a new `MazeSquare` and saving it. 
Because the lines are not comma or white-space separated, you will probably find the `substring` method helpful for getting each character out:
```
String example = "hi";
String firstLetter = example.substring(0,1); //firstLetter now contains "h"
```

You may assume that provided files are always correctly formatted.

### getMazeSquare method
The `print` method I've provided relies on the `getMazeSquare` method, which isn't implemented since it depends on what data structure you chose to store your MazeSquares. Complete the `getMazeSquare` method so that it returns the appropriate MazeSquare.

### Check everything works so far
You should now create a new `Maze` in the main() method of `Maze.java` and call `load` with `maze.txt`. Then call `print` and makes sure that what you get looks like the example above.

## Solving the maze
Stacks are very useful when solving a maze and a classic algorithm is actually based on this idea. We'll talk about the algorithm more later in the term, but I'll just give you the steps for now:

1. Mark every square in the maze as 'unvisited'
2. Create an empty stack of maze squares.
3. Add the start square to the stack and mark the start square as 'visited'.
4. While the stack isn't empty:
5. Check if the top item is the finish square, if it is, you're done and the stack contains a solution to the maze.
6. Look at each square adjacent to the top item (up, down, right, and left, not diagonals) and look for one that is neither blocked (by a wall) nor already visited. If you find one, mark it as visited and put it on the stack. Go back to step 4.
7. If there are no squares adjacent to the top item that are neither blocked nor already visited, remove the top item from the stack and go back to step 4. (This is like hitting a dead end in a maze and backtracking.) 
8. If the stack becomes empty before you find the finish square, the maze is unsolvable and you should return the empty stack.

You should implement these steps in `getSolution()`.
As you are working on implementing these steps, you should definitely create new methods in `Maze.java` that are called within `getSolution()` to make the method shorter and easier to read. 

You may encounter an infinite while loop when you try to run your code for the first time (where the program just keeps running and doesn't stop). A helpful debugging approach is to temporarily add a `count` variable that cuts the while loop off after a reasonable number of steps based on your maze and put in print statements to track through what your code is doing and find where it is getting stuck.

You should at least make sure that you code stops looping before moving on.

### Printing the solution
A solution isn't very helpful if you can't see it! You should edit the `print` method so that it takes a boolean that indicates if a solution should be printed or not.

You should then edit the `MazeSquare` class to contain an instance variable `solutionPiece` that indicates if it belongs to the solution found and update `getSolution` so that it marks `MazeSquare`s appropriately.

Finally, you should edit `print` so that when it is supposed to print the solution, it checks if a `MazeSquare` is a solution piece and prints an `*` if so:
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

Make sure you update `print`'s comment to reflect your changes.

Check that you are now able to print a solution to the maze and successfully solved the example maze.

If the maze is not solvable, your program should print a friendly message stating that.

## Command line arguments
You should edit the `main` method of `Maze.java` so that it takes in one or two command line arguments:
```
java Maze <mazeFile> [--solve]
```
Where `<mazeFile>` is the name of a file that contains a maze and `[--solve]` is an optional argument that, when included, causes the solution to be printed and when it isn't included, the maze is printed without the solution.

For example `java Maze maze.txt` should print out:
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

and `java Maze maze.txt --solve` should print out:
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

## Stress testing
You should now create at least 2 of your own mazes that are more complicated and test your program in unique ways (for example, needing to go right to find the finish instead of left). You are welcome to create more maze files, but you must create at least 2 and verify that your program solves them. Please give them clear names so that the graders can identify them and test them.

## Rubric
Your assignment will be graded as follows:

| Item | Points |
| load method works | 2 |
| getSolution works on example | 2 |
| print works on example | 2 |
| print solution works on example | 2 |
| command line functionality | 2 |
| Two distinct mazes provided | 2 |
| Solver works on student mazes | 4 |
| Solver works on other mazes | 2 |
| Solver handles unsolvable correctly | 2 |
| Doesn't have repeated code | 2 |
| Sufficient documentation | 2 |
| Otherwise good style | 1 |