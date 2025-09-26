---
layout: page
title: HW4 - Queues in C
permalink: /classes/208-f25/hw4

---

**Due: Friday, October 10th, at 10:00pm**

Starter code: [hw4.tar](hw4.tar)  
Upload solutions via Gradescope as: `queue.c` and `queue.h`

This assignment is an adaptation of [this lab](https://www.cs.cmu.edu/afs/cs/academic/class/15213-f19/www/labs/cprogramminglab.pdf) developed for the Carnegie Mellon University's 15-213 (Introduction to Computer Systems) course, which is the course for which a fun (but not free) textbook was written.  These labs are great, but they come with a lot of infrastructure, which may take you a little while to get used to.  We'll talk about this in class.

## Goals

In this assignment, you will implement a double-ended queue supporting both last-in-first-out (LIFO) and first-in-first-out (FIFO) queueing operations.  The underlying data structure is a singly linked list, enhanced to make some of the operations more efficient.

When it comes to data structure sophistication, this queue is completely suitable for study during the first half of CS 201.  We're not aiming at algorithmically complicated structures here.  Rather, this assignment is intended to give you practice in the style of C programming that we'll be continuing all term: pointer-based, memory-aware, and robust with respect to system errors.  Specifically, this assignment will help you practice:
* explicit memory management with `malloc` and `free`
* creating and manipulating pointer-based data structures
* working with strings
* enhancing the performance of key operations by storing redundant information in data structures
* handling system errors appropriately when they occur

## Collaboration policy

For this assignment, you may work alone or with a partner, but you must type up all of the code yourself.  (It is therefore unexpected for two code submissions to be completely identical.)

You may also discuss the assignment at a high level with other students.

You should list any student with whom you discussed the assignment, and the manner of discussion (high level, partner, etc.) in comments at the top of your C source file(s).

_If you work alone, you should say so instead._

## Assessment

The **core requirements** for your submission are:

* score at least 7 on the tests (verified by Gradescope)
* be somewhat [well-styled](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/style-guide)

The **advanced requirements** for your submission are:

* satisfy the core requirements
* score the full 13 points on the tests (verified by Gradescope)
* be quite [well-styled](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/style-guide), particularly with well-chosen variable names, good identation, using helper methods/loops to reduce code duplication, and not having any memory leaks
* include your name and collaboration statement at the top of your C source file(s)

Your program will be evaluated for correctness and efficiency using the "traces" described below.  The program will list a score (between 0.0 and 2.0 points, depending on the trace) for each one that executes correctly and fast enough.  The provided `driver.py` runs `qtest` on the traces and computes the overall score.  You can invoke the driver directly with the command:
```bash
./driver.py
```
or with the command:
```bash
make test
```

## Getting started

The starter code in [hw4.tar](hw4.tar) contains many files.  Almost all of these files are part of a testing infrastructure that will give you detailed feedback as you write your code.  You should feel free to look at all of these files if you're interested in how a big university CS department thinks about automated grading.  However, to complete the assignment, _you should only change the contents of `queue.h` and `queue.c`_.

The queue data structure that we will work with looks like this:
```C
/* Linked list element */
typedef struct list_ele {
    char *value;
    struct list_ele *next;
} list_ele_t;

/* Queue structure */
typedef struct {
    list_ele_t *head;  /* Linked list of elements */
} queue_t;
```

These are combined to implement a queue of strings, as illustrated in the diagram below.  The top-level representation of a queue is a structure of type `queue_t`.  In the starter code, this structure contains only a single field `head`, but you will want to add other fields.  The queue contents are represented as a singly linked list, with each element represented by a structure of type `list_ele_t`, having fields `value` and `next`, storing a pointer to a string and a pointer to the next list element, respectively.  The final list element has its `next` pointer set to `NULL`.  you may add other fields to the structure `list_ele`, although you need not do so.

![Diagram of a queue](/classes/208-s24/queue-diagram.png)

Each list element has a `value` field, pointing to a C string (i.e., a null-terminated array of `char`) and a `next` field pointing to the next list element.  For this diagram and this assignment, we encode characters using ASCII, which are shown in the diagram as 2-digit hexadecimal integers.  Observe how the two instances of the string `"cab"` are represented by separate arrays---each list element must have a separate copy of its string.

In our C code, a queue is a pointer of type `queue_t *`.  We distinguish two special cases: a _NULL_ queue is one for which the pointer has value `NULL`.  An _empty_ queue is one pointing to a valid struture, but the `head` field has value `NULL`.  Your code will need to deal properly with both of these caes, as well as queues containing one or more elements.

## Assignment overview

Your task is to modify the code in `queue.h` and `queue.c` to fully implement the following functions.  I recommend working on them in the order they're listed here, testing using `./driver.py` after you complete each one.  (You can look at the headers of the first few trace files for the functionality that they specifically test.)

* `q_new`: Create a new, empty queue.

* `q_free`: Free all storage used by a queue.

* `q_insert_head`: Attempt to insert a new element at the head of the queue (LIFO discipline).

* `q_insert_tail`: Attempt to insert a new element at the tail of the queue (FIFO discipline).

* `q_remove_head`: Attempt to remove the element at the head of the queue.

* `q_size`: Compute the number of elements in the queue.

* `q_reverse`: Reorder the list so that the queue elements are reversed in order.  This function should not allocate or free any list elements (either directly for via calls to other functions that allocate or free elements).  Instead, it should rearrange the existing elements.

More details can be found in the comments in `queue.h` and `queue.c`, including how to handle invalid operations (e.g., removing from an empty or NULL queue), and what side effects and return values the functions should have.

## Getting the starter package

Like the previous assignment, this one has multiple files comprising its starter code, so it is distributed to you as a `.tar` file.  To get started on this assignment:

1. Login to `mantis.mathcs.carleton.edu` using VS Code and open your `cs208` folder.  Go back and look at [Lab 0](../../labs/lab0) if you have any questions about how to do this.

2. In your VS Code terminal, run:

    ```bash
    wget https://cs.carleton.edu/faculty/tamert/courses/cs208-f24/resources/assignments/a4.tar
    ```

3. Still in your VS Code terminal, extract the `a4` folder:

    ```bash
    tar xvf a4.tar
    ```

>This will create a folder named `a4` with some stuff in it.

4. Read the `README` file and the function documentation in `queue.h` and get started.

## Your assignment

Your assignment is divided into several functions.  You can find more information about them in `queue.h`.  What follows are some (hopefully) helpful notes.

For functions that provide strings as arguments, you must create and store a copy of the string by calling `malloc` to allocate space (remember to include space for the null character) and then copying from the source to the newly allocated space.  You cannot assume any fixed upper bound on the length of a string---you must allocate space for each string based in its length.

When it comes time to free a list element, you must also free the space used by the string.  The general rule to follow is that every call to `malloc` needs to be matched by a call to `free` elsewhere in your code.  I expect `q_new`, `q_insert_head`, and `q_insert_tail` to contain calls to `malloc`, and `q_free` and `q_remove_head` to contain calls to `free`.

Two of the functions, `q_insert_tail` and `q_size`, will require some effort on your part to meet the required performance standards.  Naive implementations would require `O(n)` steps for a queue with `n` elements.  We require that your implementations operate in `O(1)` time, i.e., that the operation will require only a fixed number of steps, regardless of the number of items in the queue.  You can do this by including other fields in the `queue_t` data structure and managing these values properly as list elements are inserted, removed, and reversed.

Your program will be tested on queues with over 1,000,000 elements.  You will find that you cannot operate on such long lists using recursive functions, as that would require too much stack space.  Instead, you'll need to use a loop to traverse the elements in a list.

## Additional resources

Did any of the terminology above not make sense?  Here are a few links that may help.

Structs:
* [C for Java programmers](https://www.cs.rochester.edu/u/ferguson/csc/c/c-for-java-programmers.pdf) - Chapter 7, Structured Types (it's only two pages)  
* [Pointers and Structs](https://diveintosystems.org/book/C2-C_depth/structs.html)

Memory management:
* [C for Java programmers](https://www.cs.rochester.edu/u/ferguson/csc/c/c-for-java-programmers.pdf) - Chapter 8, Memory Management (longer but very useful)  
* [Dynamic Memory Allocation](https://diveintosystems.org/book/C2-C_depth/dynamic_memory.html)  
* [C Strings](https://diveintosystems.org/book/C2-C_depth/strings.html)

If you find any other really helpful resources, please let me know and I'll add them!

## Testing

It will be very useful to test your code incrementally as you implement each function.  The `traces` directory contains 14 trace files, with names of the form `trace-k-cat.txt`, where _k_ is the trace number and _cat_ specifies the category of properties being tested.  Each trace consists of a sequence of commands to interact with the queue.  They test different aspects of the correctness, robustness, and performance of your program.  You can use these, your own trace files, and direct interactions with the provided `qtest` program to test and debug your implementation.  Read the comment at the top of each trace file to see a description of what it tests.

You can compile your code using the command:
```bash
make
```

If there are no errors, the compiler will generate an executable program `qtest`, providing a command interface with which you can create, modify, and examine queues.  Documentation on the available commands can be found by starting this program and running the help command:
```bash
./qtest
cmd>help
```

The file `traces/trace-eg.cmd` illustrates an example command sequence.  You can see the effect of these commands by operating `qtest` in batch mode on a trace file:
```bash
./qtest -f traces/trace-eg.cmd
```

With the starter code, you will see that many of these operations are not implemented properly.

## Segmentation faults

A hallmark of C programming is the ominous _segmentation fault_.  This error crashes the program immediately, and provides no information as to the cause.

Fortunately, `gdb` (the GNU debugger) can help us discover the line of code where the fault occurs and even which pointer dereference is responsible ("segfaults" are usually the result of dereferencing a null or invalid pointer).  Our [CS 208 resources page](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources/) has a good tutorial video, a cheat sheet, and some other links to help you get started.

You'll use `gdb` a lot later in the term.  For now, however, here's something you can do to track down segfaults:

* `cd a4`

* `make qtest`

* Suppose `make test` is telling you that you have a segmentation fault for `"trace-10-malloc"`.  In that case, you can run the specific test without using `make` like so:
    ```
    ./qtest -v 1 -f traces/trace-10-malloc.cmd
    ```
>This is exactly what the `driver.py` program executes for trace #10 when you do `make test`, but now you're doing it manually.  You should see another report of a segmentation fault.

* Launch the for-now-mysterious program `gdb`, ready to help you debug the executable program `qtest` (which itself includes your `queue.c` file):
    ```
    gdb qtest
    ```

* After a bunch of copyright text, you will see the prompt (`gdb`).  Here, you're going to run your program inside the debugger, using the command `run` and specifying the command-line arguments you want to pass to `qtest`:
    ```
    (gdb) run -v 1 -f traces/trace-10-malloc.cmd
    ```

* Maybe now, you'll see a result like this:
    ```
    (gdb) run -v 1 -f traces/trace-10-malloc.cmd
    Starting program: /Accounts/tamert/cs208/a4/qtest -v 1 -f traces/trace-10-malloc.cmd
    # Test of malloc failure on new

    Program received signal SIGSEGV, Segmentation fault.
    0x00005555555598b7 in q_new () at queue.c:29
    29	    q->head = NULL;
    (gdb)
    ```
>There it is, the specific line number (`29`, in this case) that is causing trouble.

* You can use `gdb` to inspect the values of variables at this point in the code.  In this specific example, the only local variable is `q`.  You can see its value like so:
    ```
    (gdb) print q
    ```

* Once you've found the problematic line of code, how should you fix it?  That's up to you.  (But reach out for help if you're stuck!)

## Submitting your work

To submit this assignment, you should upload your `queue.c` and `queue.h` files to Gradescope.

## Q & A

Here are some frequently asked questions:

* I'm getting `ERROR: Corruption detected in block with address 0x7ff436f060a0 when attempting to free it`, what does that mean???
>
>That means the end of your strings aren't formed correctly.  You should think carefully about how much space they need and how to make sure the null terminator ends up in the right spot.

* I'm getting something about a loop in my list but I definitely didn't make a loop.
>
>Make sure that you are setting things to `NULL` that should be; you never know what is lurking in uninitialized pointer variables :/.

&nbsp;