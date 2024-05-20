---
layout: page
title: HW9 A SIMPLE COMMAND SHELL PART 1
permalink: /classes/208-s24/hw9
---

* Upload via Gradescope as: `shell208.c`

## GOALS
* Practice manipulating Linux processes in C
* Demystify command shells like bash, zsh, etc.
* Understand how command-line arguments are arranged in memory

## Logistics
This is a **paired** assignment, so you should work with your partner from HW8. If you indicated you would work alone, you can change your mind and join with someone, but you need to let me know asap. As usual, you can get help as detailed in the [collaboration](collaboration) document. You should submit only one assignment to Gradescope for your pair and add your partner to the submission. If for some reason you and your partner can't make things work, you can split, but you have to let me know asap.

This assignment is due **Monday May 20th** at 10pm. As with all assignments, you will have the opportunity to **individually** [revise](revision-process) this submission based on feedback.

## Assessment

To **demonstrate proficiency**, your submission needs to:
* Pass the tests on Gradescope (though see [Addendums](#addendums))
* Support "help", printing a short summary of your shell's current features
* Implement the simplest mode: print prompt; get one-word command from user; execute
    command (or print an error message); repeat forever
* Support single commands with command-line arguments (e.g., "wc -l file.txt" or "ls -l -a")

To **demonstrate mastery**, your submission needs to:
* Demonstrate proficiency
* Support "command > file" (redirecting command's stdout to a file)
* Be [well-styled](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html) and documented

## BACKGROUND
When you interact with a Unix (or other similar) command prompt, you are interacting with a program known as a *command shell*. This might be [bash](https://en.wikipedia.org/wiki/Bash_(Unix_shell)) in a WSL or Linux terminal, [bash](https://en.wikipedia.org/wiki/Bash_(Unix_shell)) in the terminal in VS Code, [zsh](https://en.wikipedia.org/wiki/Z_shell) in a macOS Terminal, [PowerShell](https://en.wikipedia.org/wiki/PowerShell) in Windows, [cmd](https://en.wikipedia.org/wiki/Cmd.exe) in a Windows "command prompt" window, etc.

Though command shells are typically sophisticated programs with many features and they often implement their own full-fledged programming languages (e.g., "bash scripting"), their flow of control is, at heart, conceptually very simple:

1. print a prompt for the user
2. read the user's command
3. execute the command
4. wait for the command to finish
5. go to step 1

## YOUR ASSIGNMENT
You will write a simple command shell, named shell208, that performs the most common operations that shells perform. For Part 1 of this project, you will implement the styles of operation listed in the rubric above.

For Part 1, your shell should be able to handle single-word commands, commands with command-line arguments, and redirection of standard output to a file. For example, each of the following should work as they do in bash on mantis:

```bash
shell208$ help
shell208$ ls
shell208$ ls -l mysubdirectory
shell208$ ls -l > listing.txt
```

## SUBMITTING YOUR WORK
Submit your program via Gradescope as a single C source file named `shell208.c`. This program should compile without warnings on mantis using:

```bash
gcc -Wall -Werror -g -Og -o shell208 shell208.c
```

## HELP
There is a [collection of sample programs](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/samples/index.html#processes) that demonstrate all of the essential techniques you will need to complete this assignment. You'll mostly be repurposing the sample programs and making sure the logic fits together. We'll also, as usual, go through many of the techniques in class, which will be recorded and posted to Moodle.

## HAVE FUN!
This program is pretty cool once you get it working.

## Addendums
It's not straightforward to have an autograder that works without some kind of "exit" functionality in your shell program, so to make the autograder work correctly, your shell should `exit` when the user types "exit". If you don't have this implemented, however, we'll just manually test your submission instead, so you'll still ultimately be evaluated on the rubric specified above. 