---
layout: page
title: INTRO TO C HW1 SELECT-COLUMN
permalink: /classes/208-s24/hw1
---

Starter code: [select-column-package.tar](select-column-package.tar)

Upload solutions via Gradescope as: `select-column.tar`

## Goals
* Get started with some of the fundamentals of C programming
* Get used to using some simple program testing automation in the form of a Makefile and sample test data
* Get experience reading [man](https://en.wikipedia.org/wiki/Man_page) pages

## Assessment
To **demonstrate proficiency**, your submission needs to:
* Pass the autograder tests
* Be somewhat [well-styled](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html)

To **demonstrate mastery**, your submission needs to:
* Be quite [well-styled](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html), particularly well-chosen variable names, naming all magic numbers, and good indentation
* Have a well-chosen algorithm (i.e. don't over-complicate this task!)
* Have thorough error-handling

## Logistics
This is an **individual** assignment, so you should write all the code individually, though you can get help, as detailed in the [collaboration](collaboration) document.

This assignment is due Friday March 29th at 10pm. As with all assignments, you will have the opportunity to [revise](revision-process) this submission based on feedback.


## GETTING STARTED WITH C
This term, nearly all of your work will involve the C programming language either directly or indirectly. As we get started with C, I am assuming that you have a working knowledge of both Python and Java, to the level they are taught in CS 111 and 201.

I also assume you will familiarize yourself with the program examples from the [Samples page](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/samples/). You should definitely study and play with those programs, and you may feel free to plunder them for code to use in your own programs.

Your first few homework assignments will focus on a few core C concepts:

* program structure: `main`, `#include`, functions, and function prototypes
* input: `scanf`, `fscanf`, `fgetc`, and `fgets`
* output: `printf`, `fprintf`, `fputc`, and `fputs`
* essential variable types: `char`, `int`, `float`, `long`, and `double`
* conditionals: `if`, `else`, and boolean expressions
* loops: `while` and `for`
* arrays
* null-terminated `char` strings along with their associated library functions `strlen`, `strcmp`, `strncpy`, and `strncat`
* command-line arguments with `argc` and `argv`
* structs
* pointers, including the operators `*`, `&`, and `->`
* memory allocation: `malloc` and `free`


## CSV FILES
The input for your first program will come in the form of a [comma-separated values](https://en.wikipedia.org/wiki/Comma-separated_values) file. CSV files give us a simple way of representing tables. Each line of text represents one row of the table, and each row is separated into columns by commas. For example, here is a simple CSV file `animals.csv` representing a table with a heading row followed by five data rows, with three data cells (or columns, if you prefer) per row:

```
Animal,leg count,eye count
dog,4,2
emu,2,2
spider,8,8
ant,6,2
sea star,5,5
```

The official CSV format has to worry about whether any of the data in the cells contain commas, but we're not going to worry about that. *For this assignment, you may assume that there are no commas in the data, so any comma in the CSV file marks a separation between adjacent data cells.*

## PROGRAMMING ASSIGNMENT #1: SELECT-COLUMN
For this assignment, you will write a C program `select-column.c` that takes a CSV file and a 1-based column number as command-line arguments, and prints the specified column of the file to standard output.

For example, suppose we run your program like so:

```bash
./select-column animals.csv 2
```

where the file `animals.csv` is as shown above. Then the expected output is:

```bash
leg count
4
2
8
6
5
```

If the specified column does not exist in a particular row of the file, print an empty line for that row.

## GETTING THE STARTER PACKAGE
For many assignments this term, you'll receive some starter code, some testing tools, or miscellaneous other materials to help you get started. These will generally be delivered to you via downloadable [tar files](https://en.wikipedia.org/wiki/Tar_(computing)). As noted in this [handy tutorial from Indiana University](https://kb.iu.edu/d/acfi), you can extract the files and folders contained in a tar file by using the command:

```bash
tar xvf whatever.tar
```

To get started on this first assignment:

* Login to `mantis.mathcs.carleton.edu` using VS Code and open your `cs208` folder
* In your VS Code terminal, run:
    ```bash
    wget https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/assignments/packages/select-column-package.tar
    ```
* Still in your VS Code terminal, extract the select-column-package folder:
    ```bash
    tar xvf select-column-package.tar
    ```
    This will create a folder named "select-column-package" with some stuff in it.

* Read the `readme.txt` file and get started.

## AUTOMATED TESTING
In the [select-column-package.tar](select-column-package.tar) file linked at the top of this page, you will find:

* Makefile: a file that you'll use to compile your program and run one very simple test
* readme.txt: an explanation of how to use the Makefile
* some test data files

For most assignments, I will only give you very simple tests in the assignment's starter package. The Gradescope autograder will run some more sophisticated tests to explore the boundaries of a given assignment. You are, of course, free to use the testing infrastructure from the starter package to add your own tests. Getting used to automated testing and to writing detailed tests of your own will serve you well in the long-run.

## SUBMITTING YOUR WORK
* put your source file select-column.c in a folder named select-column
* cd to the parent directory of select-column/
* create a tar file:
    ```bash
    tar cvf select-column.tar select-column
    ```
* download the tar file to your local machine (in Visual Studio Code while connected to mantis.mathcs.carleton.edu, you can right-click on starting-c.tar and select Download)
* use the Gradescope web interface to submit your tar file
* wait for the autograder to run and feel free to resubmit if the autograder points out an issue

## A LITTLE ADVICE
* Think ahead of time about error handling. What could go wrong with the command-line or the input file or anything else in your program? What should your program do when those things happen? (And look at the sample programs for error handling examples!)
* Think ahead of time about testing. What special cases should you test? How can you test them?
* Assume that each line ends either with a newline character `\n` (ASCII 10) or with the end of the file. You'll want your program to work even if the last line doesn't end with `\n`.
* For this program, you won't need to read entire lines into memory. This problem is solvable just reading one character at a time using `fgetc` (and you shouldn't over complicate it).

## HAVE FUN!
Don't by shy about experimenting and asking lots of questions.