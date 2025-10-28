---
layout: page
title: OS and Processes Prep
permalink: /classes/208-f25/os-processes-prep
---

## Overview
The last section of the course will be focused on how the various larger specialized software systems work. We'll start with thinking a little bit about how your computer's operating system manages all those programs that you are running.

## Basic Learning Objectives
Before class, you should be able to:
* Explain the idea of an interrupt-driven system
* Explain what the `fork` call does

## Advanced Learning Objectives
* Predict the behavior of a program with multiple fork calls
* Implement a simple process handling system

## Resources
Read the following:
* [DIS 13.0](https://diveintosystems.org/book/C13-OS/index.html)
* [DIS 13.1](https://diveintosystems.org/book/C13-OS/impl.html)
* [DIS 13.2](https://diveintosystems.org/book/C13-OS/processes.html)
* `man` pages for: `fork`, `wait`, `execlp`

## Checks
Submit your answer to the following on Moodle.

Given the following code, write out two of the possible orderings of the printed output.
```c
#include <stdio.h>
#include <stdlib.h>
#include <sys/_types/_pid_t.h>
#include <unistd.h>

int main() {
    printf("charmander\n");
    pid_t pid = fork();
    printf("squirtle\n");
    if (pid != 0) {
        printf("pikachu\n");
    }
    else {
        printf("bulbasaur\n");
    }

    printf("pidgey\n");

    return 0;
}
```