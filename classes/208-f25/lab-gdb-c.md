---
layout: page
title: Debugging C with GDB Lab
permalink: /classes/208-f25/c-gdb-lab
---

In this lab, you’ll get some practice suing the GNU Debugger (`gdb`), which allows us to debug C, C++, and raw assembly code on Linux from the terminal. You’ll use `gdb` to explore some bitwise operations in C.

## What’s a debugger?
A *debugger* is a tool designed to help you debug your programs. Debuggers tend to have a lot of sophisticated features, but the core of what you need to know is this: a debugger allows you to run your program one line at a time, enabling you to examine your variables along the way. If you can watch your variables evolve one slow line of code at a time, you can usually track down your errors.

## Documentation and tutorials
You will find some potentially useful [gdb](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources#gdb) resources posted on the [Resources](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources) page. Take a look at these after class.

## Getting started
To get started, launch [https://fern.mathcs.carleton.edu/jupyter/hub/login](https://fern.mathcs.carleton.edu/jupyter/hub/login) and connect to mantis. Go back and look at [Lab 0](mantis-lab) again if you don’t remember how.

We’ll work with two programs in this lab. First is a new sample, [gdb_test.c](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources/samples/gdb_test.c). Second, we’ll play around with your code for [homework 1](hw1).

* Grab the code for `gdb_test.c` (by right-clicking, selecting "Save Link As" and then uploading on `fern`), and compile it using the following command:

    ```bash
    gcc -Wall -Werror -g -Og -o gdb_test gdb_test.c
    ```

    The `-g` means "include debugging info in the executable". The `-Og` (that’s a capital O, not a zero) means "optimize this code for the best debugging experience".

* Try running the program to compute the factorial of 6:

    ```bash
    ./gdb_test 6
    ```

* Open up `gdb`:

    ```bash
    gdb gdb_test
    ...lots of notices print out...
    (gdb) [this is the gdb prompt]
    ```
    Note that I’ll use `[` and `]` to delineate comments to you in terminal interactions with gdb.

* Run the program to compute 6! again:

    ```bash
    (gdb) run 6
    ```

* Most `gdb` commands can be executed using abbreviations:

```bash
(gdb) r 6
```

* You can show 10 lines (the default count) of the source code:

    ```bash
    (gdb) list
    ```

    The `list` command makes guesses about which 10 lines you want to see. For example, it selects the “current” source file and starting line (whatever that may mean in context).

* Instead, show lines 10 through 25:

    ```bash
    (gdb) list 10,25
    ```

* You can also explicitly name the source file if your executable comes from multiple sources:

    ```bash
    (gdb) list gdb_test.c:10,25
    ```

For all `gdb` commands, if you hit return at the next prompt, `gdb` tries to repeat the previous command. So, for example, try this:

    ```bash
    (gdb) list 1,20
    ...[listing of source code]...
    (gdb) [hit return]
    ...[what do you see?]
    ```

## Working with breakpoints
Let’s set our first breakpoint and explore. A breakpoint is a place where gdb will pause execution of your code and let you look at the values in variables, registers (we’ll learn about these later), and memory at that moment.

* Set a breakpoint at line 31 (revisit your `list` results, why is this a good spot?):

    ```bash
    (gdb) br gdb_test.c:31
    [or]
    (gdb) br 31 [if the filename were unambiguous]
    ```

* Run the program, which will pause at your breakpoint:

    ```bash
    (gdb) r 6    [recall that r=run]
    ```

* Look at the code just before and after your breakpoint:

    ```bash
    (gdb) list
    ```

* We can also look at the current contents of a parameter or local variable:

    ```bash
    (gdb) print n   [what does this tell you?]
    ```

* We can also look at the current "backtrace" (i.e., the list of function calls that are currently active, which is especially handy for recursion):

    ```bash
    (gdb) bt    [what is this telling you?]
    ```

* Let’s continue the program’s execution:

    ```bash
    (gdb) continue
    [or]
    (gdb) c
    ```

* Again, this breaks (i.e., pauses) at line 31. Take a look at the backtrace (also known as a stack trace), to see that there’s a new call to `factorial(5)` on the stack:

    ```bash
    (gdb) bt
    ```

* Personally, I find it hard to remember where I’m at in the code. You can view it in a split vertical pane:

    ```bash
    (gdb) layout src
    ```
    Note: sometimes this will get messed up as you are doing other things, Ctrl+l (lower case L) will fix it

* Let’s also change our breakpoint. First, list them out:

    ```bash
    (gdb) info breakpoints
    ```

* You can clear an existing breakpoint by number:

```bash
(gdb) del 1
```

* Now set a new breakpoint at the start of factorial:

    ```bash
    (gdb) b factorial
    ```

* Now, step through your code. Try restarting and stepping through line by line, watching where your program is at:

    ```bash
    (gdb) r 6
    The program being debugged has been started already.
    Start it from the beginning? (y or n)       [hit y, then return]
    ...
    ...            [hits your breakpoint]
    ...
    (gdb) s        [s = step]
    (gdb)          [hit return to repeat the step]
    (gdb)
    ```

* Using `s` for "step into" will go into function calls. If you go too far, use `up` to go back out (like if you go into `sscanf`).

* Inside factorial, let’s print out the value of n:

    ```bash
    (gdb) p n
    ```

* Do this a bunch more – go through a few recursive calls, print the value of n, and once you start going back up, look at the value of result. Don’t forget to print the backtrace (bt) if you get lost with where you are in the recursion!

* Take a screenshot of your `gdb` screen at this point and upload it to Moodle for an engagement credit.

* At any point, you can leave `gdb` by typing `quit` at the prompt, and confirming you want to end the currently running (if any) program.

## Debugging `bits.c`
Try this out in `bits.c`. Can you inspect the values of variables as you step through your functions?

For example, assume you have this (incorrect) code for `isZero`:

```c
int isZero(int x) {
    int a = x >> 2;
    int b = x & (0xFF);
    int c = x || 0x123;
    return 2;
}
```

* Create a simple file that calls your `bits.c` code, which we’ll use in `gdb`. Name it `bits_caller.c` and put this code in it:

    ```c
    #include <stdio.h>
    #include "bits.h"

    int main()
    {
        int res = isZero(0x208);
        printf("result: 0x%x\n", res);

        return 0;
    }
    ```

* Compile this code at the terminal:

    ```bash
    gcc -g -Og -o bits_caller bits.c bits_caller.c
    ```

* Now run it in `gdb`:

    ```bash
    gdb bits_caller
    ...
    (gdb) layout src
    (gdb) b isZero
    (gdb) run
    ```

* From here, you can step through the lines of code, and then print out the values of the variables. When you’re about to return, print the value of `a`:

    ```bash
    (gdb) p a
    ```

* That was kind of useless, because by default `gdb` prints in decimal (base 10) – let’s print in hexadecimal instead!

    ```bash
    (gdb) p/x a
    ```

* If you’d prefer, you can also print in binary:

    ```bash
    (gdb) p/t a
    ```

## That’s it!
There is a lot more to learn about using a debugger, but this should give you a good start. Keep practicing, and as always, ask questions you may have!


## Acknowledgements
This lab is from Prof. Tanya Amert.