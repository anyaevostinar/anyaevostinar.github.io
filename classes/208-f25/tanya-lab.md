---
layout: page
title: "Lab 8: Control flow in x86-64"
date: 2026-11-06T10:00:00-05:00
permalink: /classes/208-f25/tanya-lab
draft: false
---

## Goals

Your primary goal for this lab is to play around with Compiler Explorer to explore various control-flow structures in assembly (`if`/`else` statements and `for`/`while` loops).

## Getting started

Open up [Compiler Explorer](https://godbolt.org/).  Make sure to modify the settings following the [Setup and experimentation instructions from Lab 6](https://cs.carleton.edu/faculty/tamert/courses/cs208-f26/labs/lab6#setup-and-experimentation), using the `-Og` compiler flag.

---

## Part A: Conditional branching

For this part of the lab, you'll explore the correspondence between `if`, `if`/`else`, and `if`/`else if`/`else` statements in C and assembly.  Before you get started, **double-check that you've got the `-Og` compiler flag set** in the top-right corner.

### Exercise A1: `if`/`else`

Write a simple C function that takes in two arguments and returns the larger one, using an `if`/`else` statement.  Its signature should look like this:

```C
int f(int a, int b)
```

Remember that in x86-64 assembly:
* Names like "f(int, int)" and ".L2" are labels that effectively give names to specific instructions (the ones right after the labels) in your program.  These can be targets of jumps.
* The first six function parameters are passed in registers.  Can you tell which one corresponds to `a` and which one is for `b`?
* The return value is also stored in a register.  Do you remember which one?

Questions to ask yourself:
* Which instruction(s) correspond to the body of the `if` branch?
* What about the `else` branch?
* Why is there only one jump instruction and only one `ret`?

### Exercise A2: `if`

Change your code from the previous exercise to remove the `else`, and instead just de-dent the `else` code block.  It should look like this:

```C
    if (condition)
    {
        /* do stuff */
    }

    /* do other stuff, not indented or in the if block */
```

Questions to ask yourself:
* How did your assembly output change?
* Does this change result in more/fewer/same number of instructions for when `a` is larger?
* What about when `b` is larger?
* Does this change result in a longer/shorter/same length of instructions in the program?

Aside: You can select the setting "Compile to binary object" to see the bytes associated with each instruction.  Is the total byte count for your function different between the `if`/`else` and `if` approaches?

### Exercise A3: `cmp` versus `test`

In the previous exercises, your comparison between `a` and `b` likely resulted in a `cmp` instruction.  This computes a subtraction and sets the control flags accordingly.  The jump instruction uses those flags to decide whether to jump.

If you instead change your comparison to be relative to 0 (e.g., `a < 0` or `a == 0`) then `gcc` will likely use `test`.  This instruction performs a bitwise `and` and sets control flags accordingly.  For example, my condition `a != 0` gets turned into `testl %edi, %edi` (with a `je` after it) which computes `a & a` and sets `SF` and `ZF` based on the value of `a`.  (An `and` instruction always sets `CF=0` and `OF=0`.)

Questions to ask yourself:
* How can you change your C code to have the assembly contain `jne`?
* How can you change your C code to have the assembly contain `js`?  What about `jns`?
* Why does an `and` always set `CF=0`?
* Why does an `and` always set `OF=0`?

### Exercise A4: nested `if`s

Finally, let's make this more complex.  Turn your C function into one with nested `if` statements.  For example, you could do something like this:

```C
int f(int a, int b)
{
    if (a == 0)
    {
        if (b < 0x123)
        {
            return 1;
        }
        else
        {
            return 2;
        }
    }
    else
    {
        ...
    }
}
```

The assembly now is much more complex, which kind of makes sense---the nested structure of the code shown above has to be broken into a bunch of boxes that are listed one after the other; the only way to skip something is to jump around it.  Draw a diagram for yourself to map out where the jumps go.

Questions to ask yourself:
* Why are there as many `ret` instructions as there are?
* If you could reorganize the assembly, how would you change it to make it match the C code more closely?
* Could you optimize the assembly to have fewer instructions overall (i.e., a smaller executable file)?

---

## Part B: Loops

Now we're going to take a look a loop structures in assembly.  We'll work with `while` loops and `for` loops.  If you finish early, try the optional extensions below.

### Exercise B1: looping in assembly

To start, on paper write a simple `while` loop in C.  Before you type it in Compiler Explorer, try to list out all of the instructions for yourself.  Given what you know about `if` statements and jumps in assembly, how would you structure a sequence of assembly instructions to add looping?

_(Hint: You should have a section of code for the condition, and another for the body.)_

### Exercise B2: `while`

Now, type your code into Compiler Explorer.  (Don't forget to update whatever value is changing, to make sure it's not an infinite loop!)

As before, draw a simple diagram for yourself to map out where the jumps go.

Questions to ask yourself:
* Why would the compiler need a `jmp` instead of our usual `jle`, `jg`, etc.?
* Are the blocks of code arranged the way you expected?
* How is this similar to an `if` statement?  What about an `if`/`else`?  How is it different?

### Exercise B3: `for`

A `for` loop is a little more complicated.  You can think of the two chunks of code as equialvent:

```C
for (int i = 0; i < n; i++)
{
    /* do stuff */
}
```

```C
int i = 0;
while (i < n)
{
    /* do stuff*/ 
    i++;
}
```

Given this background, change the code in Compiler Explorer to have a `for` loop.  As before, draw a simple diagram for yourself to map out where the jumps go.

Questions to ask yourself:
* Can you find all of the blocks of code you expect?
* Which register is being used for your loop variable?
* How is this similar to the code for a `while` loop?  How is it different?

### Exercise B4: more complex loops

Now try mixing these control-flow structures.  For example, what if you have a `for` loop with an `if` statement inside of it.  What about a `while` loop with a `for` loop inside of it?  Try getting some really complex nesting going on, then take a look at the assembly.

Questions to ask yourself:
* Can you find all of the blocks of code you expect?
* Are registers getting re-used for unexpected purposes?
* Are there strange orderings of various blocks?

---

## Part C: Reverse-engineering assembly

For this last part of the lab, you'll work to reverse engineer some assembly programs by trying to figure out the C code that generates them.

To get started, download the [`assembly_lab.tar`](assembly_lab.tar) file to get the code for the lab.

```bash
wget https://anyaevostinar.github.io/classes/208-f25/assembly_lab.tar
```

Copy it into a folder for today's lab, and then un-tar the file:

```bash
tar xvf assembly_lab.tar
```

You'll do your work using Compiler Explorer, but it may be nice to save the functions you write into various `.c` files for yourself to look back at later.

### Exercise C1: making sense of assembly

Take a look at `puzzle1.asm`.  To get an idea of what is going on in this function, try to do the following:

1. Fill in the comment at the top of the assembly file, indicating which structure(s) are present in the puzzle:
	- conditional branching (`if`, `if`/`else`)
	- loop (`for`, `while`, `do-while`)
	- nested loop
	- function call
	- recursive function call (how would you tell??)
2. For each `# Next: TODO` marked in the inline comments, provide the label(s) of the instruction(s) that may be executed immediately after the instruction on the TODO line.

Questions to ask yourself:
* What are some possible orderings of labels that would be executed duringa single invocation of `function1`?
* How many parameters does this function have?
* Given the register names used for parameters, what sizes are the parameter(s) to this function?
* If this function returns, its result would be placed in `%rax` (or a subset of it); what size would the return value be?  (Note that `%rax` may be used for other things, so its presence is not a guarantee that this function returns a value.)

### Exercise C2: reverse engineering C code

Given what you just determined about the assembly in `puzzle1.asm`, try to type up some C code in Compiler Explorer that would give you something similar (e.g., if you think there is a loop but no function calls, put in a simple loop).

Can you recreate the assembly?

(Note: We added some extra labels, so you are only trying to make the instructions themselves match; it's okay if the labels don't.  Also make sure you're using the `-Og` flag.)

### Exercise C3: more assembly

There are a bunch of other puzzles.  Can you recreate other functions?  Try to do `puzzle2.asm` through `puzzle6.asm`.

If you have extra time, try to do the [optional extension below](#exercise-d4-reverse-engineering-puzzle7asm) to solve `puzzle7.asm`.

---

## Part D: Optional extensions

The exercises in this part are for your own exploration after you finish the rest of the lab.

### Exercise D1: compound conditionals

Write a function that uses a compound conditional.  For example, you might try `if (a > 0 && b != 15)`.

Take a look at the assembly for this conditional.  The `set` family of instructions read the condition flags and can set a the bottom 8 bits of a register to a 1 or 0 based on a given condition.  One way to think of it is whether a jump for that same condition would be taken; for example, a `setg %dl` instruction will put either 0x1 or 0x0 in the bottom 8 bits of register `%rdx` based on whether a `jg` would be taken at that point in the program's execution.

Try to change out your conditions.  Can you make sense of how the values being set are combined?  (Mine has a `testb` at the end---does yours?)

### Exercise D2: `cmov`

Go back to Exercise A1, and try it out with different optimization levels.  In particular, instead of using `-Og`, use `-O1` instead.  Can you tell what's going on?

_(Hint: How do you feel about ternary if statements?)_

[Read about `cmov`](https://diveintosystems.org/book/C7-x86_64/if_statements.html#_the_cmov_instructions) in the textbook to learn more.

### Exercise D3: `do while`

_**Note: Change back to `-Og` as a compiler flag before you start!**_

In C you can have `do`-`while` loops that execute the body once before checking the condition.  For example, consider this loop:

```C
int count = 0;
do
{
    count++;
} while (count < 10);
```

This is effectively the same as the following:
```C
int count = 0;
count++;
while (count < 10)
{
    count++;
}
```

Write the above `do`-`while` loop in Compiler Explorer, and then modify it.  Can you see where the different pieces go in the assembly?  What if you change it out for a `while`?

### Exercise D4: reverse engineering `puzzle7.asm`

This puzzle uses a bunch of things we haven't really talked about, specifically switch statements.  [Read this section of the textbook](https://diveintosystems.org/book/C2-C_depth/advanced_switch.html#_c_switch_), and stop at Enumerated Types.  Try to reverse engineer a switch statement that gives you the assembly you see in `puzzle7.asm`.

To make sense of what's going on, you may find it helpful to read about ["jump tables"](https://en.wikipedia.org/wiki/Branch_table).  These can be implemented nicely with arrays, they just happen to be arrays of instruction addresses rather than data.

## Next steps

We'll start the first of our two assembly assignments shortly.  For now, keep exploring and ask any questions you have!

&nbsp;