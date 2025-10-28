---
layout: page
title: Signals and Messages Prep
permalink: /classes/208-f25/os-signals-prep
---

## Overview
We'll continue thinking about how the operating system manages different programs by exploring some of the ways that processes can communicate with each other, including learning about how the `|` actually works.

## Basic Learning Objectives
Before class, you should be able to:
* Explain the high-level idea of signals
* Explain how piping works

## Advanced Learning Objectives
After class, you should be able to:
* Implement signal handling
* Set up a pipe in C

## Resources
Read the following:
* [DIS 13.4.0](https://diveintosystems.org/book/C13-OS/ipc.html)
* [DIS 13.4.1](https://diveintosystems.org/book/C13-OS/ipc_signals.html)
* [DIS 13.4.2](https://diveintosystems.org/book/C13-OS/ipc_msging.html)
* `man` page for `signal`

## Checks
Submit to Moodle what happens when the following program is compiled and run and why that happens:

```c
#include <signal.h>
#include <stdio.h>
#include <unistd.h>

const long limit = 2e10; // 20,000,000,000 (2 with 10 zeros)
const long frequency = 5e7; // 500,000,000 (5 with 7 zeros)

void interrupt_handler(int);

int main()
{
    long i;

    pid_t process_id = getpid();

    /* The initial handler for the SIGINT signal is
       assuredly the default, so confusion will not reign */
    if (signal(SIGINT, interrupt_handler) != SIG_DFL) // register for CTRL-C
    {
        fprintf(stderr, "I'm confused.\n");
    }

    /* Start counting */
    for (i=0; i < limit; i++)
    {
        if (i % frequency == 0)
        {
            fprintf(stderr, "[PID %d] %ld\n", process_id, i);
            fflush(stderr);
        }
    }

    return 0;
}

// Handle registered interrupts
void interrupt_handler(int sig)
{
    fprintf(stderr, "Sorry, but I just don't want to quit.\n");
    fflush(stderr);
}
```