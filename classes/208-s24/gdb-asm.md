---
layout: page
title: GDB Assembly Lab
permalink: /classes/208-s24/lab-gdb-asm
---

## Goals
Your primary goal for this lab is to get familiar with using the GNU debugger (`gdb`) to explore and debug x86-64 programs, in which you may not be able to view the original C source. As a secondary goal, you’ll get some practice that may help with any sneaky escapades you may undertake.

This lab is based on [this lab](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-f23/labs/lab6/) from Tanya Amert!

## Documentation and tutorials
You will find some potentially [useful gdb resources](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/resources.html#gdb) posted on our Resources page. 

## Getting started
In this lab, we’ll be working with a pre-compiled program named `call_proc`. Grab the program and what source code I’m giving you, and copy them to mantis, following the steps below:

* SSH into `mantis` via VS Code and open a terminal in your `cs208` folder.

* Make a new directory for this lab:

    ```bash
    mkdir lab6
    ```
* Change to your new directory:

    ```bash
    cd lab6
    ```

* Grab the compiled program and source code:

    ```bash
    wget https://anyaevostinar.github.io/classes/208-s24/call_proc.tar
    ```
* Un-tar it:

    ```bash
    tar xvf call_proc.tar
    ```

* Look at the source code in `call_proc.c`. You should see the `proc` function, and some other stuff we’ll explore soon.

* You won’t be able to compile the program yourself, as you don’t have a definition for the function `phase_0`. You do have the executable, however. Try to run `call_proc`. Unless you get really lucky, you won’t win. :)

    ```bash
    ./call_proc
    ```

* Note: If you have any issues running `call_proc`, you can use the following command to make it executable:

    ```bash
    chmod +x call_proc
    ```

## Step 1: Exploring `proc` with `gdb`

We’ll now explore the proc function.

* Open the file `call_proc.c`. You’ll find the `proc` function on lines 5–14.

* Open a Terminal window in VS Code.

* Run `gdb`, ready to step through `call_proc`:

    ```bash
    gdb call_proc
    ```

We want to explore the inputs to `proc`. We expect to find the first six arguments in registers, with arguments 7 and 8 (x4 and p4, respectively) instead on the stack. In this case, `proc` is called on line 23, as follows:

```c
proc(10, &a, 20, &b, 30, &c, 40, &d);
```

Here is a reasonable hypothesis of a drawing to represent the state of the stack at the start of a call to `proc`: 

![Stack diagram](/classes/208-s24/proc_arguments.png)

Let’s find the arguments!

* We’re using `gdb`, so set a breakpoint at the start of `proc`:

    ```bash
    (gdb) b proc
    ```
* Run the `call_proc` program:

    ```bash
    (gdb) r
    ```

* You’ll have to enter a number, and then you should hit the breakpoint. We expect the first argument to be in register `%rdi`; we should find the value 10 there due to our call to `proc`:

    ```bash
    (gdb) print $rdi
    ```
    (Note the very silly convention in `gdb` that you use `$` for registers instead of `%`.)

* The next argument should be in register `%rsi`. This one is an address, and we don’t have a good sense of what the address is yet. We’ll explore that later, in Step 2:

    ```bash
    (gdb) print $rsi
    ```

By default, this seems to display in decimal, which is kind of useless for addresses. Use `/x` to make it display in hex instead:

```bash
(gdb) print /x $rsi
```

* Arguments 3–6 should be in registers `%rdx`, `%rcx`, `%r8`, and `%r9`, respectively. It’s tedious to view each individually, so let’s look at all registers instead:

    ```bash
    (gdb) i r
    ```

* You’ll likely notice that the contents of `%rdx` and `%r8` don’t look like what we expect. Keep in mind that they’re in hex, not decimal! Conveniently, using `i r` in gdb displays both, one per column. Make sure you know which one you’re reading.

* Now let’s look at the stack to find our 7th and 8th arguments (when I ran this, `%rsp` contained the value `0x7fffffffe458`):

    ```bash
    (gdb) x/3gx 0x7fffffffe458
    ```

* The first 64 bits (a “giant” word in `gdb`, hence the `g`) contain the return address for when `proc` is done. The next 8 bytes are our 7th parameter (0x28 in hex is 2*16+8 = 40 in decimal), followed by an address that is our 8th parameter.

* If you type `list`, you’ll see the C code for the `proc` function:

    ```bash
    (gdb) list
    ```

* If instead you want to see the assembly, you can type `layout asm`. This gives us a split screen with the assembly code on the top and the `(gdb)` command prompt on the bottom. Note that it can be a bit erratic, so if it gets messed up visually, press the key combination Ctrl-L to redraw the screen.

    ```bash
    (gdb) layout asm
    ```

The assembly is very similar to what we looked at on [Compiler Explorer](https://godbolt.org/z/T64oqxh9q). Read through it (it’s just seven lines) and make sure you can follow what it’s doing.

Next, we’ll look at a function that calls `proc`; this function is aptly named `call_proc`.

## Step 2: Exploring `call_proc` with `gdb`
We’re going to step through `call_proc` to see how well it lines up with our understanding of its use of local variables and argument prep on the stack. 

If you peek at `call_proc`, you'll see it first makes four local variables:

```c
long call_proc(long n)
{
    long  a = 1;
    int   b = 2;
    short c = 3;
    char  d = 4;
```
Let's figure out where those variables are stored.

* If you’re continuing from Step #1, type `c` to continue the program (this should complete its execution), then type `d` to delete all breakpoints. If you’re starting fresh, run `gdb call_proc`.

* Set a breakpoint in the function `call_proc`:

    ```bash
    (gdb) b call_proc
    ```

* Run the program, and enter a number:

    ```bash
    (gdb) r
    Guess a number: 123
    ```

* This should hit the breakpoint. Take a look at the assembly with `layout asm`. Where is it storing `$0x1`? 

* Draw a picture for yourself that shows the state of the stack based on the assembly, showing where each of the constants are stored.

* Let’s move down to check the stack. Type `ni` for next instruction, and repeat it several times until you’re about to execute the first `lea` instruction, i.e. you've executed all the instructions saving the constants to the stack.

* Time to inspect the stack. Let’s look at the 32 bytes starting at the top of the stack (for me, `%rsp` has value `0x7fffffffe7c0` as I run this, remember you can find what `%rsp` is for you with `i r rsp`):

    ```bash
    (gdb) x/32bx 0x7fffffffe7c0
    ```

* One one of the lines, you should see `0x01` followed by 7 `0x00`s. That’s `a`. On the line above, you’ll see each of `b` (4 bytes), `c` (2 bytes), and `d` (1 byte), all next to each other.

* Let’s keep going, and see the argument building to prep for calling `proc`. Notice the `lea` instructions; for example, address `0x10(%rsp)` (that’s `a`) is put in `%rsi`, as `&a` is provided as our second argument on line 23 of the source code. Additionally, we see that `%rax` and `$0x28` (that’s 40 in hex) are pushed to the stack; these are arguments 8 and 7, in that order. Update your drawing of the stack based on those changes.

* Finally, let’s print out the state of the stack right before the `callq` to jump to `proc` executes. Hit return several more times (and/or type `ni` again) to get there, then get the new value of the stack pointer:

    ```bash
    (gdb) print $rsp
    ```

* Finally, let’s look at the stack (my new value of `%rsp` is `0x7fffffffe7b0`):

    ```bash
    (gdb) x/48bx 0x7fffffffe7b0
    ```
    How does it compare to your diagram? Can you find all the constants and arguments 7 and 8 for the call to `proc`?

## Step 3: What is `phase_0`?

Let's figure out `phase_0`!

* Looking at the assembly itself can be helpful. Get the assembly with:

    ```bash
    objdump -d call_proc > call_proc.asm
    ```

    Then open up `call_proc.asm` and look through it a bit for the overall structure

* Another helpful tool is `strings`. This tool can tell you the location of every string in a program with `-t` (and you need to tell it what base you want the info in, `x` for hex):

    ```bash
    strings -t x call_proc > call_proc_strings.txt
    ```

    Take a look at the resulting file and find the location for "Guess a number: ". Compare that to your `call_proc.asm`. You should see a line:

    ```
    1357:	48 8d 35 b9 0c 00 00 	lea    0xcb9(%rip),%rsi        # 2017 <_IO_stdin_used+0x17>
    ```

    This is telling you that `0xcb9(%rip)` is pointing at that string.

* Let's look at `phase_0` in the assembly. Search in the file for the section labeled `phase_0`. You can see that `phase_0` is doing something with `sscanf`, which grabs out chunks of a string based on the format string (and you should [read up about it](https://cplusplus.com/reference/cstdio/sscanf/) and its man page). Make notes to yourself in the assembly with `#` on what the assembly is doing with the result of the call to `sscanf`.

* What argument is getting passed to `call_proc`?

* What happens with the return value from `call_proc`? (0x13a is 314 in decimal) Under what conditions do you get to the string "You win!"?

* With that, you should be able to reverse engineer what number you need to guess to win!

If you've gotten this far, feel free to work on your zoo escape with these new tools!