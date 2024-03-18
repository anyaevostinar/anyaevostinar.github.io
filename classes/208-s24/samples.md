---
layout: page
title: CS208 Intro to Systems S24 Samples
permalink: /classes/208-s24/samples
---

DRAFT PAGE

The following sample programs (adapted from those provided by Jeff Ondich) will help you explore many useful features in C.

* **STUDY THESE PROGRAMS.** Reading and understanding what's going on in these samples is part of your homework, and I will assume that you have done that work as the term progresses.
* Ask questions. You won't understand everything in these samples on first reading, so collect your questions and get them answered.
* Experiment. You won't understand everything in these samples on first reading, so play around with them. Some of your best learning will start with "I wonder what happens if I make this change...".
* Building these programs. For most of our programs, you should use the following compilation approach. We'll discuss all the parts of this command over the first few days of the term.
```bash
gcc -Wall -Werror -g -o hello hello.c
```
* Pedagogical comments vs. production comments. These programs have tons of explanatory comments, because they are intended as pedagogical programs, not production programs. Production code (i.e., code intended for use by end users or submission as homework) should follow the [commenting advice in our style guide](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html#comments). You're welcome to borrow code from these samples, but delete the original comments before you're done working.

## SAMPLES
hello.c (printf)
args.c (argc and argv)
character_counter.c (command-line arguments and reading from a file)
charstar.c (exploring the many notations for pointers to chars)
strings.c (null-terminated character strings)
output.c (what are stdout and stderr?)
pointers.c (starting to talk about pointers)
printing-bytes.c (printing one byte in hex is hard)
sizes.c (sizeof & how many bytes do standard types require?)
integers0.c (misc experiments with integers)
integers1.c (writing integers to output in various ways)
integers2.c (more integer stuff)
memory.c (*, &, ., and ->)
Relevant to the bits and encoding assignment:

bitwise.c (&, |, and >>)
sscanf-test.c
smiley.c (storing UTF-8 by hand and printing it in a couple ways)
environment.c (two ways to access environment variables in C)
Process-related samples for command-shell assignment

Makefile
Getting started with processes

forktest.c
exectest.c
getanumber.c
Redirection and piping

files.c
pipe.c
redirect.c
Helpful for writing your shell

shell208.c
argv.c
exectest_with_args.c
signaltest.c
Race conditions

race.c (shared memory and a simple race condition)
race_with_lock.c (a failed attempt to protect shared memory with a shared lock)
norace.c (protecting shared memory with a semaphore)
Threads

pthreads_test.c (using POSIX Threads)
Network programming with sockets

hello_client.c
hello_server.c
hello_server_concurrent.c
tcp_utilities.c
tcp_utilities.h