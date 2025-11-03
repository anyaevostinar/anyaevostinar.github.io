---
layout: page
title: HW8 - A Simple Command Shell
permalink: /classes/208-f25/hw8
---

* Due **Friday Nov 14th at 10pm**
* Upload via Gradescope as: `shell208.c`

## GOALS
This assignment is designed to help you practice the following: 
* Manipulating Linux processes in C
* Demystify command shells like bash, zsh, etc.
* Understand how command-line arguments are arranged in memory
* Learn how to use pipes for inter-process communication
* Learn how to handle signals

## Collaboration policy
For this assignment, you may work alone or with a partner, but you must type up all of the code yourself.  (It is therefore unexpected for two code submissions to be completely identical.)

You may also discuss the assignment at a high level with other students.

You should list any student with whom you discussed the assignment, and the manner of discussion (high level, partner, etc.) in comments at the top of your C source file(s).

_If you work alone, you should say so instead._

## Assessment

The **core requirements** for your submission are:
* Pass the core tests on Gradescope 
* Include your name and collaboration statement at the top of `shell208.c`
* If the user types "exit", your shell exits
* Implement the basic mode: print prompt; get one-word command from user; execute
    command (or print an error message); repeat forever
* Support a single command-line argument
* Support "command > file" (redirecting command's stdout to a file)
* Do NOT use `system` or any other built-in command that defeats the point of the assignment

The **advanced requirements** of your submission are:
* Satisfy the core requirements
* Pass the advanced tests on Gradescope
* Support multiple command-line arguments
* Support "`command < file`" (redirecting command's stdin from a file)
* Support "`command1 | command2`" (piping command1's stdout to command2's stdin, **including command-line arguments for each command**)
* If a `SIGINT` signal is sent to the parent (shell) process, respond by printing "`^C`" to stderr and printing the prompt again (note that this has to be tested manually so there isn't an autograder for it)



## Background
When you interact with a Unix (or other similar) command prompt, you are interacting with a program known as a *command shell*. This might be [bash](https://en.wikipedia.org/wiki/Bash_(Unix_shell)) in a WSL or Linux terminal, [bash](https://en.wikipedia.org/wiki/Bash_(Unix_shell)) in the terminal in VS Code, [zsh](https://en.wikipedia.org/wiki/Z_shell) in a macOS Terminal, [PowerShell](https://en.wikipedia.org/wiki/PowerShell) in Windows, [cmd](https://en.wikipedia.org/wiki/Cmd.exe) in a Windows "command prompt" window, etc.

Though command shells are typically sophisticated programs with many features and they often implement their own full-fledged programming languages (e.g., "bash scripting"), their flow of control is, at heart, conceptually very simple:

1. print a prompt for the user (e.g. `$` or `%`)
2. read the user's command
3. execute the command
4. wait for the command to finish
5. go to step 1

## Your Assignment
You will write a simple command shell, named `shell208`, that performs the most common operations that shells perform. 

## Core
The core requirements for your shell are that it can handle:
* if the user types `exit`, your shell exits,
* single-word commands (e.g., `ls`, `pwd`),
* commands with a single command-line argument (e.g., `ls -l`, `echo dog`), and
* redirection of standard output (`stdout`, via `>`) to a file.

 For example, each of the following should work as they do in `bash` on `mantis`:

```bash
shell208$ pwd
shell208$ ls
shell208$ ls -l mysubdirectory
shell208$ ls -l > listing.txt
shell208$ exit
```

## Advanced
The advanced requirements are that your shell can additionally handle:

* multiple command-line arguments,
* redirection of standard input (`stdin`, via `<`) from a file,
* capturing `SIGINT` signals, and
* piping commands via `|`. 

For example, each of the following should work as they do in bash on mantis:

```bash
shell208$ ls
shell208$ ls -l mysubdirectory
shell208$ ls -l > listing.txt
shell208$ wc < myfile.txt
shell208$ ls -lah | wc
shell208$ ^C                                   /* user pressed ctrl-c */
shell208$ ^C                                    /* your shell printed ^C to stderr */
shell208$ exit
```

## SUBMITTING YOUR WORK
Submit your program via Gradescope as a single C source file named `shell208.c`. This program should compile without warnings on mantis using:

```bash
gcc -Wall -Werror -g -Og -o shell208 shell208.c
```

## HELP
There is a [collection of sample programs](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/samples#samples) that demonstrate all of the essential techniques you will need to complete this assignment. You'll mostly be repurposing the sample programs and making sure the logic fits together. We'll also, as usual, go through many of the techniques in class, which will be recorded and posted to Moodle.

Some tips:
* Note that there isn't a style requirement on this assignment, so feel free to just have a bunch of gross conditionals checking for each thing.
* If you are getting weird/inconsistent behavior, make sure that your shell parent is the only thing calling `fork`. You shouldn't have child processes calling `fork` and therefore having "grandchildren" processes because this can lead to race conditions or deadlock (due to the children blocking). Each child needs to be able to run in parallel, which can only be achieved by the parent managing them (and waiting for both of them!).



## HAVE FUN!
This program is pretty cool once you get it working. Take it slow, and handle only one part of the rubric at a time. You can do this!
