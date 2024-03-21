---
layout: page
title: INTRO TO C 3 READLINE
permalink: /classes/208-s24/hw3
---

No starter code

Upload solutions via Gradescope as: `readline.tar`

## GOALS
* Yet more C practice
* Thinking in terms of functional interfaces rather than complete programs
* Using `malloc` and `free`

## Assessment
To **demonstrate proficiency**, your submission needs to:
* Pass the autograder tests
* Be somewhat [well-styled](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html)
* Follow the specified algorithm

To **demonstrate mastery**, your submission needs to:
* Demonstrate proficiency
* Be quite [well-styled](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html), particularly well-chosen variable names, naming all magic numbers, and good indentation
* Free memory correctly
* Return a null-terminated C string
* Have thorough error-handling

## Logistics
This is an **individual** assignment, so you should write all the code individually, though you can get help, as detailed in the [collaboration](collaboration) document.

This assignment is due Friday April 5th at 10pm. As with all assignments, you will have the opportunity to [revise](revision-process) this submission based on feedback.

## THE PROBLEM WITH FGETS
You used `fgets` during the last assignment, but there was a big problem: you could only read as many bytes (minus one, to account for the null-termination) from the file as your buffer would hold. That's why I told you to assume that no line would be longer than 200 bytes including the newline character.

But what if we could read a whole line, no matter how long? That would be cool, right? We don't have infinite memory, of course, so there will still be constraints on just how long our lines can be. But we ought to be able to create something more convenient than `fgets`. That's the goal of this assignment.

## PROGRAMMING ASSIGNMENT #3: READLINE
For this assignment, you will write one C function, not a whole program. Here's its specification.

```c
// Reads bytes from the input stream until encountering
// either a newline character '\n' or the end of the stream, or
// an error condition. Returns a pointer to a dynamically allocated
// (i.e., malloc'd) buffer containing the bytes, including the newline
// character (if any) and a null-terminator.
//
// If any error occurs during reading from the stream or memory 
// allocation, or if the first byte the input stream is at end-of-file
// when readline is called, then readline frees any allocated memory
// and returns NULL.
//
// It is the caller's responsibility to free the returned buffer when 
// the caller no longer needs it.


char *readline(FILE *input_stream);
```

If you have a function like that, you can do things like this:

```c
while (1) {
    char *line = readline(input_file);
    if (line == NULL) {
        break;
    }
    // ... do something interesting with line ...
    free(line);
}
```

So far, so good. But I'm going to add more constraints on this function. Here's how I want your `readline` implementation to work.

```c
buffer = malloc(16)
while we're not yet at the end of the line
    read a byte b
    if buffer doesn't have space to hold b and a '\0':
        allocate a new buffer two times as big as buffer
        copy the contents of the old buffer to the new buffer
        free the old buffer
        make the new buffer the current buffer
null-terminate the buffer
return buffer
```

**IMPORTANT:** put your implementation of `readline` alone in a file named `readline.c`. To test your function, use a separate file called `main.c` that looks like this:

```c
#include <whatever-you-need.h>

char *readline(FILE *input_stream);

int main() {
    // ... do whatever testing of readline you want to do ...

    return 0;
}
```

To compile your `readline.c` and `main.c` into a single executable program, you do this:

```bash
gcc -Wall -Werror -o readline readline.c main.c
```

That is, include both `.c` files as command-line arguments for the `gcc` command.

**IMPORTANT, PART 2:** you may not call the standard library function `realloc`, but you might want to read about what it does. (It's pretty cool!)

## NOW WAIT A SECOND...
If this `readline` is so cool, why isn't it part of the standard library?

The big reason is that doing what I've described above is super-slow, and if you want to write slow code, you should probably just pick a language that does this automatic resizing for you, like Java or Python. (Burn...)

But doing this exercise in this class has two benefits.

* You learn about the "double + copy" algorithm for dynamically increasing the memory size of a data structure. This is a very important algorithm, and we'll discuss its big-O performance in class. (You've perhaps heard of it already depending on previous classes.)
* You get to practice using `malloc` and `free` in a reasonably natural context.

## SUBMITTING YOUR WORK
You know the drill by now. See the expected tar file name shown at the top of the page. You may but need not include your `main.c`. The autograder will ignore it anyway.

## ADVICE
Think carefully about when errors can occur naturally, and what to do when they do. As usual, consult the samples and reading for examples of error-handling.

## HAVE FUN!
Keep experimenting! Keep asking questions!