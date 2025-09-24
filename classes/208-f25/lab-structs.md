---
layout: page
title: Structs and Files Lab
permalink: /classes/208-f25/structs-files-lab
---

## Overview
In this lab, you’ll get some more practice with C, focusing on "strings" and file I/O.

As usual, I recommend you do this on `mantis` through `fern`.

## Part A: Playing with `structs` and strings
### Getting started
First, make a new file, let’s call it `lab2_struct.c`. Define the following `struct` (retype this, don’t just copy it!):

```c
typedef struct
{
    int a[2];
    long b;
    char c[8];
    char d[5];
} data_t;
```

Now, write a function `print_data` that takes in a `data_t` and prints out the elements of this `struct`. You’ll need to remember a couple of things:

* You have to import `<stdio.h>` to get `printf` to work.
* You can print an `int` with `%d` or `%x` without trouble, but a `long` is big – use `%ld` or `%lx` for something so "long".
* You can print a string (which is really just a null-terminated sequence of `char`) using `%s`.

Once this works, create a new variable `data` using this `struct` definition in `main`, fill it with values, and print it. Use whatever you want for `a` and `b`, but store `"systems"` in C as follows:

```c
data.c[0] = 's';
data.c[1] = 'y';
...
```

Don’t forget to null-terminate `data.c`! Then go ahead and put some bytes in `d`. Some UTF-8 encoded bytes would work nicely:

```c
data.d[0] = 0xeb;
data.d[1] = 0xb4;
data.d[2] = 0x84;
data.d[3] = '\0';
```

Finally, call your `print_data` function, and make sure to return `1` from `main` to indicate a successful program completion.

To compile your code, we’ll use a shorter version of the `gcc` command than usual (we don’t want it checking for nefarious things we’ll do later): `gcc -o lab2_struct lab2_struct.c`.

Run your program (`./lab2_struct`). Does it print what you expect?

### How "strings" print
When `printf` finds a `%s` format specifier, it starts printing characters at the location provided, reading bytes one by one until it finds a null terminator (`'\0'`).

1. Take a moment and write out the memory diagram for this `struct`. Where are the bytes of `c` and `d` relative to each other?

2. Okay, let’s be nefarious. Add this line of code just before the return of `main`: `data.c[7] = '#';`.

3. Add another call to `print_data`. What has changed? Why does this happen?

### Copying strings
One way to copy string data around is to use the `strcpy` function (you’ll need to import `<string.h>`). It blindly copies the `src` string into the `dst`, including the null terminator, regardless of the size of `dst`.

There’s a variant called `strncpy` in which you have to specify the number of bytes to copy. This copies the provided `src` string; if you say to copy more bytes than `src` has before it hits a null terminator, it pads with 0s at the end (effectively null terminators).

1. Add another line to copy a new string into `c`: `strcpy(data.c, "Lulu");`.

2. Call `print_data`. Does the result make sense?

3. Now add another line: `strncpy(data.c, "weRsneaky", 9);`.

4. Call `print_data` one more time. Can you still make sense of the result?

5. All the documentation for C functions is available through your terminal. In the terminal, type `man strcpy` and read through the "DESCRIPTION" to see what is going on with `strcpy` and `strncpy`.

## Part B: File I/O
### Getting started
Take a look at the `line_counter.c` sample (remember you can find it linked from the Samples page on Moodle), and write down answers to the following questions:

1. What is EOF?
2. How are lines separated in a file?
3. How would you count the number of vowels instead of the number of lines? (At a high level, you don't need to write the code if you don't want to)

### Parsing lines
Modify the `line_counter.c` sample to additionally print out the first character of each line, both as a character (`%c`) and in hex (`%x`). Try out your changes on this simple text file (actually copy these lines, as one has a tab and another has a space, then save it in the same folder as `line_counter.c`):

```
Good morning!
 
	
How are you  
  doing
    today??
```

Submit your `lab2_struct.c`, `line_counter.c`, and answers to the questions on Moodle for an engagement credit.

### More practice
How would you modify the `line_counter.c` program further to print out the length of each line? What about the last character? Make sure to think carefully through your logic to ensure you’re handling the last line in the file, too.

