---
layout: page
title: HW4 - QUEUES IN C LINKED LISTS WITH *'S AND &'S
permalink: /classes/208-s24/hw4
---

Starter code: [queues-package.tar](queues-package.tar)
Upload via Moodle as: `queue.c` and `queue.h`

This assignment is an adaptation of [this lab](https://www.cs.cmu.edu/afs/cs/academic/class/15213-f19/www/labs/cprogramminglab.pdf) developed for the Carnegie Mellon University's 15-213 (Introduction to Computer Systems) course, which is the course for which a previous textbook was written. These labs are great, but they come with a lot of infrastructure, which will take you a little while to get used to. We'll talk about this in detail in class.

## GOALS
In this assignment, you will implement a double-ended queue supporting both last-in-first-out (LIFO) and first-in-first-out (FIFO) queueing operations. The underlying data structure is a singly-linked list, enhanced to make some of the operations more efficient.

When it comes to data structures sophistication, this queue is completely suitable for study during the first half of CS 201. We're not aiming at algorithmically complicated structures here. Rather, this assignment is intended to give you practice in the style of C programming that we'll be doing all term: pointer-based, memory-aware, and robust with respect to system errors. Specifically, this assignment will help you practice:

* Explicit memory management with `malloc` and `free`
* Creating and manipulating pointer-based data structures
* Working with strings
* Enhancing the performance of key operations by storing redundant information in data structures
* Handling system errors appropriately when they occur

## Logistics
This is a **paired** assignment, so you should work with your assigned partner, if you have one. If you chose not to be assigned a partner, you must work individually (you can't pick your own partner!). As usual, you can get help as detailed in the [collaboration](collaboration) document. You should submit only one assignment to Gradescope for your pair and add your partner to the submission. If for some reason you and your partner can't make things work, you can split, but you have to let me know asap.

This assignment is due Wednesday April 10th at 10pm. As with all assignments, you will have the opportunity to *individually* [revise](revision-process) this submission based on feedback.

## Assessment
To **demonstrate proficiency**, your submission needs to:
* Score at least 7 on the tests (also checked by Gradescope)
* Be somewhat [well-styled](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html)

To **demonstrate mastery**, your submission needs to:
* Demonstrate proficiency
* Score the full 13 points on the tests (check by Gradescope)
* Be quite [well-styled](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html), particularly well-chosen variable names, naming all magic numbers, and good indentation

Your program's correctness and efficiency will be evaluated using the "traces" described below. You will get credit (between 0 and 2 points, depending on the trace) for each one that executes correctly and fast enough. The provided `driver.py` runs `qtest` on the traces and computes the score. This is the same program that will be used to compute your correctness/efficiency scores. You can invoke the driver directly with the command:

```bash
./driver.py
```

or with the command:

```
make test
```

## GETTING STARTED
The starter code in `queues-package.tar` contains many files. Almost all of these files are part of a testing infrastructure that will give you detailed feedback as you write your code. You should feel free to look at all of these files if you're interested in how a big university CS department thinks about automated grading. However, to complete the assignment, you will only change the contents of `queue.h` and `queue.c`.

The queue data structure that we will work with looks like this:

```c
/* Linked list element */
typedef struct list_ele {
    char *value;
    struct list_ele *next;
} list_ele_t;

/* Queue structure */
typedef struct {
    list_ele_t *head; /* Linked list of elements */
} queue_t;
```

These are combined to implement a queue of strings, as illustrated in the diagram below. The top-level representation of a queue is a structure of type `queue_t`. In the starter code, this structure contains only a single field `head`, but you will want to add other fields. The queue contents are represented as a singly-linked list, with each element represented by a structure of type `list_ele_t`, having fields `value` and `next`, storing a pointer to a string and a pointer to the next list element, respectively. The final list element has its next pointer set to `NULL`. You may add other fields to the structure `list_ele`, although you need not do so.

![Diagram of a queue](/classes/208-s24/queue-diagram.png)

Each list element has a `value` field, pointing to a C string (i.e. a null-terminated array of `char`) and a `next` field pointing to the next list element. For this diagram and this assignment, we encode characters using ASCII, which are shown in the diagram as 2-digit hexadecimal integers. Observe how the two instances of the string `"cab"` are represented by separate arrays — each list element must have a separate copy of its string.

In our C code, a queue is a pointer of type `queue_t *`. We distinguish two special cases: a *NULL* queue is one for which the pointer has value `NULL`. An empty queue is one pointing to a valid structure, but the `head` field has value `NULL`. Your code will need to deal properly with both of these cases, as well as queues containing one or more elements.

## YOUR JOB
Your task is to modify the code in `queue.h` and `queue.c` to fully implement the following functions. I recommend working on them in the order they're listed here, testing after you complete each one. (Look at the headers of the first few traces files for the functionality that they specifically test.)

* `q_new`: Create a new, empty queue.
* `q_free`: Free all storage used by a queue.
* `q_insert_head`: Attempt to insert a new element at the head of the queue.
* `q_insert_tail`: Attempt to insert a new element at the tail of the queue.
* `q_remove_head`: Attempt to remove the element at the head of the queue.
* `q_size`: Compute the number of elements in the queue.
* `q_reverse`: Reorder the list so that the queue elements are reversed in order. This function should not allocate or free any list elements (either directly or via calls to other functions that allocate or free list elements.) Instead, it should rearrange the existing elements.

More details can be found in the comments in `queue.h` and `queue.c`, including how to handle invalid operations (e.g., removing from an empty or NULL queue), and what side effects and return values the functions should have.

For functions that provide strings as arguments, you must create and store a copy of the string by calling `malloc` to allocate space (remember to include space for the null character) and then copying from the source to the newly allocated space. You cannot assume any fixed upper bound on the length of a string — you must allocate space for each string based on its length.

When it comes time to free a list element, you must also free the space used by the string. The general rule to follow is that every call to `malloc` needs to be matched by a call to `free` elsewhere in your code. I expect `q_new`, `q_insert_head`, and `q_insert_tail` to contain calls to `malloc` and `q_free` and `q_remove_head` to contain calls to free.

Two of the functions: `q_insert_tail` and `q_size` will require some effort on your part to meet the required performance standards. Naive implementations would require `O(n)` steps for a queue with `n` elements. We require that your implementations operate in time `O(1)`, i.e., that the operation will require only a fixed number of steps, regardless of the queue size. You can do this by including other fields in the `queue_t` data structure and managing these values properly as list elements are inserted, removed and reversed.

Your program will be tested on queues with over 1,000,000 elements. You will find that you cannot operate on such long lists using recursive functions, since that would require too much stack space. Instead, you need to use a loop to traverse the elements in a list.

## TESTING
It will be very useful to test your code incrementally as you implement each function. The `traces` directory contains 14 trace files, with names of the form `trace-k-cat.txt`, where `k` is the trace number, and `cat` specifies the category of properties being tested. Each trace consists of a sequence of commands, similar to those shown above. They test different aspects of the correctness, robustness, and performance of your program. You can use these, your own trace files, and direct interactions with `qtest` to test and debug your program. Read the comment at the top of each trace file to see a description of what it tests.

You can compile your code using the command:

```bash
make
```

If there are no errors, the compiler will generate an executable program `qtest`, providing a command interface with which you can create, modify, and examine queues. Documentation on the available commands can be found by starting this program and running the help command:

```bash
./qtest
cmd>help
```

The file `traces/trace-eg.cmd` illustrates an example command sequence. You can see the effect of these commands by operating `qtest` in batch mode:

```bash
./qtest -f traces/trace-eg.cmd
```

With the starter code, you will see that many of these operations are not implemented properly.

## SEGMENTATION FAULT
A hallmark of C programming is the ominous segmentation fault. This error crashes the program immediately, and provides no information as to the cause.

Fortunately, `gdb` (the GNU debugger) can help us discover the line of code where the fault occurs and even which pointer dereference is responsible (seg faults are usually the result of dereferencing a null or invalid pointer). Jeff's [CS208 resources page](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/resources.html/#gdb) has a good tutorial video, a cheat sheet, and some other links to help you get started.

You'll use gdb a lot later in the term. But for now, here's a thing you can do to find your segmentation fault problem.

* `cd queues-package`
* `make qtest`
* Suppose `make test` is telling you that you have a segmentation fault for "trace-10-malloc". Then you can run the specific test without using make like so:

    ```bash
    ./qtest -v 1 -f traces/trace-10-malloc.cmd
    ```

This is is exactly what the `driver.py` program executes for trace #10 when you you do make test, but now you're doing it manually. You should see another report of a segmentation fault (with possibly some more detail of what happens before).

* Launch the for-now-mysterious program `gdb`:

    ```bash
    gdb qtest
    ```

    The point here is that `gdb` is going to help you work on the executable program `qtest`, which itself includes your `queue.c` code.

* After a bunch of copyright stuff, you will see the prompt `(gdb)`. Here, you're going to run your program inside the debugger:

    ```bash
    (gdb) run -v 1 -f traces/trace-10-malloc.cmd
    ```

* Maybe now, you'll see a result like this:
    ```bash
    (gdb) run -v 1 -f traces/trace-10-malloc.cmd
    
    Starting program: /Accounts/vostinar/cs208/queues-package/qtest -v 1 -f traces/trace-10-malloc.cmd
    
    # Test of malloc failure on new

    Program received signal SIGSEGV, Segmentation fault.
    0x00005555555598b7 in q_new () at queue.c:29
    29	    q->head = NULL;
    (gdb)
    ```
    And look at that! You can see the specific line number where your code is causing trouble.

* Want to see the values of your variables at this point in the code? In this specific example, the only local variable is `q`. You can see its value like so.
    ```bash
    (gdb) print q
    ```
    And so on.

* Fixing the problem? That's up to you. (But reach out for help if you're stuck!)

## HANDING IT IN
To submit this homework (probably after you have run `make test` and made sure you have the score you want), upload your `queue.c` and `queue.h` files to the HW4 assignment on Gradescope.

## Q & A
Here are some frequently asked questions:

I'm getting `ERROR: Corruption detected in block with address 0x7ff436f060a0 when attempting to free it`, what does that mean???
* That means the end of your strings aren't formed correctly. You should think carefully about how much space they need and how to make sure the null ends up in the right spot.

I'm getting a bunch of errors that say something about `multiple definition of` in the starter code, what gives?
* You aren't running on `mantis` are you? Certain versions of `gcc` don't work with this starter code, make sure to do everything on `mantis`.

I'm getting something about a loop in my list but I definitely didn't make a loop.
* Make sure that you are setting things to `NULL` that should be, you never know what is lurking in uninitialized pointer variables >.> <.<