---
layout: page
title: Bits and Bytes
permalink: /classes/208-f25/hw1

---

**Due: Friday Sept 19th at 10pm**

Starter code: [a1.tar](a1.tar)

Upload solutions via Gradescope as: `bits.c`

This assignment is an adaptation of a lab developed for the Carnegie Mellon University’s 15-213 (Introduction to Computer Systems) course, which is the course for which a fun (but not free) textbook was written. These labs are great, but they come with a lot of infrastructure, which may take you a little while to get used to. We’ll talk about this in class.

## Goals
This assignment is designed to help you practice the following:

* some of the fundamentals of C programming
* thinking of your data in terms of bits and bytes
* working with bit operations (`~`, `|`, `&`, `^`, `<<`, `>>`) in C

## Collaboration policy
As with most assignments in this class, you may work alone or with a partner, but you **must type up all of the code yourself**. (It is therefore unexpected for two code submissions to be completely identical.)

You may also discuss the assignment at a high level with other students. Consult the [collaboration policy](collaboration) for more details.

You should list any student with whom you discussed the assignment, and the manner of discussion (high level, partner, etc.) **in comments at the top of your C source file(s).** You should also specify your chosen partner if you had one.

*If you work alone, you should say so instead.*

## Assessment
The **core** requirements for your submission are:

* implement the first three functions in `bits.c` while satisfying the operator count and availability constraints
* be somewhat [well-styled](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/style-guide/)

The **advanced** requirements for your submission are:

* meet the core requirements
* implement the remaining four functions in `bits.c` while satisfying the operator count and availability constraints
* be quite [well-styled](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/style-guide/), particularly with well-chosen variable names, good identation, and comments to explain your operator choices
* include your name and collaboration statement at the top of your C source file(s)

## Assignment overview
Your task is to implement the seven functions in `bits.c`. You cannot use any conditional statements or loops. For most functions, you have only the following operators bitwise, logical, and shift operators available: `! ~ & ^ | + << >>`; for some functions, you have even fewer. Additionally, you cannot use any constant outside of the range 0 to 255 (0xFF).

For the core requirements, you must implement the following three functions:

* `isZero(x)`: returns 1 if x has value 0, or 0 otherwise
* `bitNor(x, y)`: computes nor(x,y) using only `~` and `&`
* `specialBits()`: returns the bit pattern `0xFFCA3FFF`

For the advanced requirements, you must additionally implement the following four functions:

* `isEqual(x, y)`: returns 1 if x==y, or 0 otherwise
* `oddBits()`: returns an integer with a 1 in all odd-numbered bit positions
* `anyEvenBit(x)`: returns 1 if any even-numbered bit position has a 1 in the given integer, or 0 otherwise
* `conditional(x, y, z)`: implements `x ? y : z` without an `if` statement

## Getting the starter code
This first assignment has multiple files to comprise its starter code, including some testing tools. You can access the code package as a downloadable [`.tar` file](https://en.wikipedia.org/wiki/Tar_(computing)). As noted in [this handy tutorial from Indiana University](https://kb.iu.edu/d/acfi), you can extract the files and folders contained in a tar file by using the command (note the `$` is the prompt – don’t type that):

```bash
$ tar xvf whatever.tar
```

To get started on this assignment:

1. Login to `mantis.mathcs.carleton.edu` through [fern](https://fern.mathcs.carleton.edu/jupyter) and open your cs208 folder. Go back and look at [Lab 0](mantis-lab) if you have any questions about how to do this.

2. In your terminal, run:

    ```bash
    $ wget https://anyaevostinar.github.io/classes/208-f25/a1.tar
    ```

3. Still in your terminal, extract the `a1` folder:

    ```bash
    $ tar xvf a1.tar
    ```

    This will create a folder named a1 with some stuff in it.

4. Read the `README` file and the function documentation in `bits.c` and get started.

## Testing your code
For some assignments in this course, I will give you simple tests. For this one, there is a whole testing suite to check that your code does the right thing (using a program called `btest`) and that it doesn’t violate the requirements on operators and available numbers (`dlc`). You can run both of these together using `driver.pl`.

Here is what it looks like when you first untar the folder:

```bash
$ make
gcc -O -Wall -m32 -lm -o btest bits.c btest.c decl.c tests.c
gcc -O -Wall -m32 -o fshow fshow.c
gcc -O -Wall -m32 -o ishow ishow.c

$ ./driver.pl
1. Running './dlc -z' to identify coding rules violations.

2. Compiling and running './btest -g' to determine correctness score.
gcc -O -Wall -m32 -lm -o btest bits.c btest.c decl.c tests.c

3. Running './dlc -Z' to identify operator count violations.

4. Compiling and running './btest -g -r 2' to determine performance score.
gcc -O -Wall -m32 -lm -o btest bits.c btest.c decl.c tests.c


5. Running './dlc -e' to get operator count of each function.

Correctness Results     Perf Results
Points  Rating  Errors  Points  Ops     Puzzle
0       1       1       0       0       isZero
0       1       1       0       0       bitNor
0       1       1       0       0       specialBits
0       2       1       0       0       isEqual
0       2       1       0       0       oddBits
0       2       1       0       0       anyEvenBit
0       3       1       0       0       conditional

Score = 0/26 [0/12 Corr + 0/14 Perf] (0 total operators)
```

Once you have completed the core functions, the end of the output from running `./driver.pl` should look like this:

```bash
Correctness Results     Perf Results
Points  Rating  Errors  Points  Ops     Puzzle
1       1       0       2       1       isZero
1       1       0       2       3       bitNor
1       1       0       2       2       specialBits
0       2       1       0       0       isEqual
0       2       1       0       0       oddBits
0       2       1       0       0       anyEvenBit
0       3       1       0       0       conditional

Score = 9/26 [3/12 Corr + 6/14 Perf] (6 total operators)
```

**Note: You will very possibly use more operators than I have. Check the function documentation in `bits.c` for the maximum allowed for each function.**

Once you’ve completed all seven functions, you should get this output (again with possibly varying operator count, but the same score):

```bash
Correctness Results     Perf Results
Points  Rating  Errors  Points  Ops     Puzzle
1       1       0       2       1       isZero
1       1       0       2       3       bitNor
1       1       0       2       2       specialBits
2       2       0       2       2       isEqual
2       2       0       2       4       oddBits
2       2       0       2       7       anyEvenBit
3       3       0       2       8       conditional

Score = 26/26 [12/12 Corr + 14/14 Perf] (27 total operators)
```

## Submitting your work
You’ll need to follow these steps to submit your work:

1. Upload your `bits.c` file to Gradescope.

2. Wait for the autograder to run.

3. Feel free to resubmit if the autograder points out an issue.

## Advice
* There are some handy identities to remember with bitwise operators:
    * `x & (~x)` gives all 0s
    * `x | (~x)` gives all 1s
    * `x & x` gives `x`
    * `x | x` gives `x`
    * `x ^ (~x)` gives all 1s
    * `x ^ x` gives all 0s

* Some of these puzzles are tricky – start early enough that you can go for a walk, go get dinner, etc. and think about it. There may be multiple ways to solve a given puzzle, with varying numbers of operators.

* You should not include `<stdio.h>` for print statements because `dlc` gets confused when checking operators; you can still use `printf` in `bits.c` and just ignore the warnings.

* You can put snippets of your code into [C Tutor](https://pythontutor.com/c.html#mode=edit) and change the view to "byte-level view of data" to step through and watch the bytes change.

* Better yet, we’ll be doing a lab in class Wednesday about debugging with `gdb` – that can help you figure out what numbers you’re working with.

* The `dlc` program requires a stricter version of C than we’ll usually work with. Specifically, plan to declare all of your variables at the start of a function, and be careful about the operators you use. For example, this code will cause issues:

    ```c
    int someFunction(int x) {
    int a = x;
    a *= 3;    // not an allowed operator, and not a declaration
    int b = a; // put declarations first!
    }
    ```

* This assignment is meant to help acclimate you to the process you’ll follow when submitting assignments in this course, and help you get familiar with C. If you are struggling, please reach out! Also, don’t be shy about experimenting and asking lots of questions!