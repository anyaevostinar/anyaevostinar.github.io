---
layout: page
title: Processes Lab
permalink: /classes/208-f25/processes-lab
---

## Goals

Your primary goal for this lab is to explore some process-related sample code.  This will hopefully help you understand how processes are created.  It can also be handy at helping you start on the last assignment.

## Getting started

There are a lot of "Process-related" samples listed on the [Samples page](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/samples/).  For this lab, we'll explore the first few of them.

First, download/copy the relevant samples to `mantis`.  You'll want the following:
* [`forktest.c`](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources/samples/forktest.c)
* [`exectest.c`](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources/samples/exectest.c)
* [`getanumber.c`](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources/samples/getanumber.c)
* [`Makefile`](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources/samples/Makefile)

Note that for the `Makefile`, the command `make all` won't work until you download all the relevant samples.

## Part 1: creating new processes with `fork`

First, let's take a look at an example that uses `fork`.

* Read through `forktest.c` and predict what the code will do when run.

* Now, either use the command `make lab8` to compile the executables for this lab, or type the following command in the shell:
    ```bash
    gcc -Wall -Werror -O1 -g -o forktest forktest.c
    ```

* Run the program `forktest` and observe the output.  Does it do what you expected?

* How does the child process determine its process ID?

* How could the parent process determine the child's process ID?

## Part 2: Executing a program with `exec*`

In addition to `fork` and `wait`, there is a family of functions, which we'll call `exec*` (where the `*` here means a wildcard, e.g., that there are lots of options) that spawn a new process to execute a specific command.

### Part 2a: executing a user-defined program

Next, take a look at the code for `getanumber.c`.

* Read through the code and predict what its output will be.

* Use the command `make lab8` to compile the remaining samples for this lab, if you haven't already.

* Run the program `getanumber` and observe the output.  Does it do what you expected?

Now, let's take a look at a sample that uses `execlp` to execute `getanumber`.  Open up `exectest.c`.

* Read through the code.  Which process executes `getanumber`?

* Why do both the parent and the child call `fflush`?  Check out the man page by typing `man fflush` in the Terminal to get more information (type `q` to quit the man page view).

* Run the program `exectest` and observe the output.  Does it do what you expected?

### Part 2b: executing a shell command

Instead of executing a specific user-provided program, we can also execute shell commands from C code using `exec*`.

* In `exectest.c` comment out line 31 and uncomment line 32, so that we're no longer executing `getanumber`, but instead executing `ls`.  Predict what the output should be.

* Run the program `exectest` again and observe its output now.  Does it do what you expected?

## Part 3: a simple shell

There is a shell of a shell (hah!) provided for you in the samples.  Copy to `mantis` the following additional files to explore:
* [`shell208.c`](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources/samples/shell208.c)
* [`exectest_with_args.c`](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources/samples/exectest_with_args.c)

Let's explore these files.

* Look through `shell208.c`.  What do you think will happen when you run it?

* Run `shell208.c`.  Does it do what you expected? 

* Make notes for where in `shell208.c` you might make changes to allow you to execute commands.  What about redirecting output?

* Now explore the other file, `exectest_with_args.c`.  How does this change what we already know about working with processes and executing commands?

* You have actually already worked on this assignment, but you didn't know it.  Go back and look at the String Splitter in [Homework 3](hw3#part-b-string-splitter).  Do you see how you can use this to build up the argument vector `argv` that you'd want to use for the shell?

## Next steps

There are many more process-related samples already on the [Samples page](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/samples/).  Take a look and play around with them.  Gather your questions, and ask away!

&nbsp;

## Acknowledgements
Lab written by Prof. Tanya Amert.