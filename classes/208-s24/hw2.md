---
layout: page
title: INTRO TO C 2 MINIGREP
permalink: /classes/208-s24/hw2
---

Starter code: [minigrep-package.tar](minigrep-package.tar)

Upload solutions via Gradescope as: `minigrep.tar`

## GOALS
* More C practice
* Using `fgets`, and learning its limitations
* Keep reading those [man](https://en.wikipedia.org/wiki/Man_page) pages!

## Assessment
To **demonstrate proficiency**, your submission needs to:
* Pass the autograder tests
* Be somewhat [well-styled](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html)

To **demonstrate mastery**, your submission needs to:
* Be quite [well-styled](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html), particularly well-chosen variable names, naming all magic numbers, and good indentation
* Use `fgets` in a memory-safe way
* Have thorough error handling

## Logistics
This is an **individual** assignment, so you should write all the code individually, though you can get help, as detailed in the [collaboration](collaboration) document.

This assignment is due Monday April 1st at 10pm. As with all assignments, you will have the opportunity to [revise](revision-process) this submission based on feedback.

## GREP
If you ever want to search for strings in one or a million files in a Unix environment, you should get to know [grep](https://en.wikipedia.org/wiki/Grep).

Let me be more direct: you should get to know [grep](https://en.wikipedia.org/wiki/Grep), period.

Here are some example grep commands:

```bash
grep moose myfile
    prints every line of myfile that contains the string "moose"
grep -v moose myfile
    prints every line of myfile that does NOT contain the string "moose"
grep -i moose myfile
    prints every line of myfile that contains "moose" case-insensitively
    ("Moose", "MoOsE", "mOOSe",...)
grep -r moose mydirectory
    prints every line containing "moose" for every file in mydirectory or
    any of its descendant directories
grep '^A' myfile
    prints every line starting with A
grep 'B^' myfile
    prints every line ending with B
grep 'moose.*goat' myfile
    prints every line containing "moose" followed eventually by "goat"
etc.
```

## READING LINES OF TEXT WITH FGETS
For your previous assignment, you could do the whole thing reading one byte (i.e., one `char`) at a time from the input file. Thus, the standard library function `fgetc` was exactly what you needed.

But sometimes, you need a whole line of text. In those cases, `fgets` is often the right tool. Here's a quick reminder of how to use it (though you should also refer to your reading):

```c
FILE *input_file = fopen(input_file_name, "r");
// ... skipping the error-handling code ...

char buffer[100];
if (fgets(buffer, 100, input_file) != NULL) {
    // Do something with the null-terminated string now in buffer
}
```

Read the description of `fgets` on its man page to answer questions like: does the newline character get stored in `buffer`? is the string in `buffer` always null-terminated? what happens if the line in the the file is longer than the size of the buffer?

## PROGRAMMING ASSIGNMENT #2: MINIGREP
For this assignment, you will write a C program `minigrep.c` that takes the name of an input file and a search string as command-line parameters (in that order) and prints to standard output every line of the input file that contains the search string, preceded by the (1-based) line number of the line.

For example, suppose you have this file named `animals.txt`:

```
moose
coatimundi
starling
dingo
parrot
flamingo
dorking chicken
goat
```

Then running your `minigrep` program on this file should look like this:

```bash
$ ./minigrep animals.txt ing
3: starling
4: dingo
6: flamingo
7: dorking chicken
```

**You may assume that no line of your file contains more than 200 bytes/chars, including the newline character.**

## SUBMITTING YOUR WORK
As you did for your [first homework assignment](hw1), put all the files you want to submit in a folder named `minigrep` (this should probably just be a single source file `minigrep.c`), run `tar cvf minigrep.tar minigrep`, and then submit the tar file via Gradescope.

## REMEMBER THAT ADVICE FROM LAST TIME?
* Think ahead of time about error handling. What could go wrong with the command-line or the input file or anything else in your program? What should your program do when those things happen?
* Think ahead of time about testing. What special cases should you test? How can you test them?
* Assume that each line ends either with a newline character `\n` (ASCII 10) or with the end of the file. You'll want your program to work even if the last line doesn't end with `\n`.

## HAVE FUN!
Keep experimenting! Keep asking questions!