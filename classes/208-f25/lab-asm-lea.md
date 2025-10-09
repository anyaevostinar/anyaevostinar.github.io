---
layout: page
title: Exploring Assembly Lab
permalink: /classes/208-f25/asm-lea-lab
---

## Goals
Your primary goal for this lab is to play around with Compiler Explorer to write C code that corresponds to specific assembly structures. Through this lab, you will get practice thinking about how different assembly structures are used to work with different sizes and types of data.

## Getting started
Open up [Compiler Explorer](https://godbolt.org/). Make sure to modify the settings following the [Getting Started instructions from HW5](hw5/#getting-started), using the `-Og` compiler flag.

1. Type the following function in the left-hand text editor:

    ```c
    char f(char x)
    {
    return x;
    }```
    
    You should see the following assembly code in the right-hand panel:
    ```c
    f(char):
        movl    %edi, %eax
        ret
    ```

2. Now make a small change to the function in C: change it to return an `int` instead of a `char`.
    ```c
    int f(char x)
    {
    return x;
    }
    ```
    How does the assembly change?

3. Make one more change to your function – have it take in an `unsigned char` instead of a `char`. Again, how does the assembly change?

4. Finally, play around with the input and output type to try to result in other `movXYZ` commands.

## Arrays in assembly
Let’s look at how arrays (or addresses treated as arrays) work in assembly.

1. Define a new function that takes in an address of an `int` (to be treated as an array).
    ```c
    int g(int *arr)
    {
        return arr[2];
    }
    ```
    Take a look at the assembly:
    
    ```
    h(int*):
       movl    8(%rdi), %eax
       ret
    ```

2. What can you change to have it work with `%rax` instead of `%eax`? Does this change its use of `%rdi`?

3. Now try changing the index used. If you change it to `3` what happens to the assembly? Predict the change and then try it out.

4. Now try passing an index as a parameter:

    ```c
    int g(int *arr, long i)
    {
    return arr[i];
    }
    ```

    Does the resulting assembly match your intuition?

5. Now change the type of the index to an `int`. Does this match your intuition? What if the input index is of type `unsigned int`?

6. Finally, try doing a relative index:

    ```c
    int g(int *arr, int i)
    {
        arr[i] = arr[i-1];
        return arr[i];
    }
    ```

## Structs in assembly
What about structs? Let’s see how that pointer math works out.

1. Type this C code:
    ```c
    typedef struct {
    long a;
    int b[2];
    short c;
    } my_struct_t;

    int h(my_struct_t *s)
    {
    s->a = 12;
    s->b[0] = 15;
    s->b[1] = 0xabcdef01;
    s->c = 0xFEDC;

    return 'A';
    }
    ```

2. Sketch for yourself how the struct is laid out in memory. Focus on the members, not the individual bytes. Can you make sense of the assembly?

3. Now change the code to take in an index to access within the array `b`:

    ```c
    int h(my_struct_t *s, unsigned int i)
    {
    s->a = 12;
    s->b[0] = 15;
    s->b[1] = 0xabcdef01;
    s->c = 0xFEDC;

    return s->b[i];
    }
    ```

    How does the assembly change? Is this what you expect?

4. What if you change the index to be just an `int` instead of an `unsigned int`?

## The `lea` instruction
Now let's explore how `lea` works.

1. Make one change to your function from before: have it return the address of `s->b[i]` instead of the value stored at that location:

    ```c
    int * h(my_struct_t *s, unsigned int i)
    {
    s->a = 12;
    s->b[0] = 15;
    s->b[1] = 0xabcdef01;
    s->c = 0xFEDC;

    return &(s->b[i]);
    }
    ```
    What changes in the assembly?

2. Now write a simpler function:

    ```c
    int h2(int a, int b)
    {
    return 3*a + b;
    }
    ```
    Look at the assembly. What is going on here?

## Next steps
Try out more variations of functions. What can you change to result in more types of assembly instructions?

Then, try plugging in your functions from previous assignments. What do you get for the different functions from [HW1](hw1)? What about functions from the [Queues](hw4) assignment? (Don’t forget to copy over the struct definition with any functions you want to try.)

Be creative in your explorations, and ask questions!