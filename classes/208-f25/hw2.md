---
layout: page
title: HW2 - Bits and Character Encodings
permalink: /classes/208-f25/hw2

---

**Due: Wednesday, Sept 24th, 10pm**

Starter code: [a2.tar](a2.tar)

Upload solutions via Gradescope link on Moodle as: `bits.c`

## Goals
This assignment is designed to help you practice the following:

* further working with bit operations (`~, |, &, ^, <<, >>`) in C
* digging into the details of the [UTF-8](https://en.wikipedia.org/wiki/UTF-8) character encoding
* practicing writing your own tests

## Collaboration policy
For this assignment, you may work alone or with a partner, but you must type up all of the code yourself. (It is therefore unexpected for two code submissions to be completely identical.)

You may also discuss the assignment at a high level with other students.

You should list any student with whom you discussed the assignment, and the manner of discussion (high level, partner, etc.) in comments at the top of your C source file(s).

*If you work alone, you should say so instead.*

## Assessment
The **core** requirements for your submission are:

* pass the happy-path autograder tests (these have names starting with `"_CR`")
* follow the requirements for each function (especially using only bitwise operations where specified)
* be somewhat [well-styled](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/style-guide)

The **advanced** requirements for your submission are:

* meet all the core requirements
* pass all autograder tests
* be quite [well-styled](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/style-guide), particularly with well-chosen variable names, naming all magic numbers, good identation, and using helper methods/loops to reduce code duplication
* have thorough error-handling
* include your name and collaboration statement at the top of your C source file(s)

## Your assignment
This assignment is based on the same original codebase as [Homework 1](hw1), but without all of the machinery around it.

In this assignment, your job is to implement the five functions described in `bits.h`; all of your coding will be done in `bits.c`.

The only file you are required to submit is `bits.c`. We will use our own `main.c` and `Makefile` to do our testing and grading.

Keep the following in mind as you do your work:

* You should only write code in `bits.c` (the starter version is provided for you).
* Do not change `bits.h`.
* You will submit your `bits.c` via Gradescope.

## Getting the starter package
Like the previous assignment, this one has multiple files to comprise its starter code, including some testing tools. Like before, you can access the code package as a downloadable `.tar` file.

To get started on this assignment:

1. Login to `mantis.mathcs.carleton.edu` through [fern](https://fern.mathcs.carleton.edu/jupyter) and open your cs208 folder. Go back and look at [Lab 0](mantis-lab) if you have any questions about how to do this.

2. In your fern terminal, run:
    ```bash
    wget https://anyaevostinar.github.io/classes/208-f25/a2.tar
    ```

3. Still in your terminal, extract the `a2` folder:
    ```bash
    tar xvf a2.tar
    ```

This will create a folder named `a2` with some stuff in it.

4. Read the `readme.txt` file and the function documentation in `bits.h` and get started.

## Testing your code
There are some simple tests provided for you in `main.c`. These test our first three functions. You can modify this file as you see appropriate to add more tests.

As explained in the `readme.txt` file, you can take advantage of the `Makefile` to run these tests:

* use `make` to just build the `bits` executable with the code in `main.c`

* use `make test` to run all tests defined in the `Makefile` – you can add tests here following these examples to test `to_utf8` and `from_utf8`

## Submitting your work
To submit this assignment, you should upload your `bits.c` to Gradescope.

## Advice
* **Read the function definitions in `bits.h`. They are there to help you!**

* Start with `to_lower`, `to_upper`, and `middle_bits`. These don’t require any understanding of UTF-8, and just involve bit operations.

* To get more practice with bit operations in your program, write out examples on paper or use [CTutor](https://pythontutor.com/c.html) with “byte-level view of data” selected (from the dropdown that starts with “none default view” showing).

* For UTF-8, try out Jeff’s [UTF-8 encoder](https://sandbox.jeffondich.com/encoder/) to check different values.

* For `to_utf8` and `from_utf8`, start by getting single-byte codepoints to work, then two-byte codepoints, etc. Worry about cleaning up your duplicated code *after* you have everything working.