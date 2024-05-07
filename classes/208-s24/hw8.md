---
layout: page
title: HW8 EXPLOITING BUFFER OVERFLOWS
permalink: /classes/208-s24/hw8
---

This assignment is an adaptation and contraction by Jeff Ondich of Aaron Bauer's adaption of a lab developed for the Carnegie Mellon University's 15-213 (Introduction to Computer Systems) course.

## GOALS
* Learn some of the ways that carefully designed malicious input can cause a vulnerable program to behave in ways not intended by the program's creators.
* Use that knowledge to learn how to avoid creating similar vulnerabilities in your own programs.
* Learn a little bit about how x86-64 machine language is structured.
* Deepen your understanding of the stack structures used to implement C function-calling in x86-64.
* Revisit your gdb skills.

## Logistics
This is a **paired** assignment, so you should work with your partner (either chosen by you or set up by me depending on your form response). If you indicated you would work alone, you can change your mind and join with someone, but you need to let me know asap. As usual, you can get help as detailed in the [collaboration](collaboration) document. You should submit only one assignment to Gradescope for your pair and add your partner to the submission. If for some reason you and your partner can't make things work, you can split, but you have to let me know asap.

This assignment is due Wednesday May 15th at 10pm. As with all assignments, you will have the opportunity to **individually** [revise](revision-process) this submission based on feedback.

## Assessment
To **demonstrate proficiency**, your submission needs to:
* Pass phases 1 and 2

To **demonstrate mastery**, your submission needs to:
* Pass all three phases

Your progress through the phases will be automatically tracked as it was during the zoo escape assignment. For this assignment, your entire score will be based on your completion of the three phases of the assignment; all you need to hand in is a document `info.txt` that includes your target number (we can see it as well, but it makes it easier on the grader).

Check your progress here: [http://cs208.mathcs.carleton.edu:1866/progress](http://cs208.mathcs.carleton.edu:1866/progress)

## BUFFER OVERFLOW ATTACKS
Suppose you write a program that includes this function:

```c
int some_function(int a, int b) {
    int j;
    char str[100];
    int k;

    ...
}
```

When you call `some_function`, a stack frame gets allocated on the system stack (typically via `sub $0xSOMETHING,%rsp`) to store the return address, the local variables, and the values saved from the miscellaneous registers that `some_function` needs to use (so those registers can be restored to their original values before the function returns). Depending on the specific code in `some_function`, the parameters `a` and `b` might also get stored in the stack frame.

As you might imagine, it would be typical for a compiler to position the local variables `j`, `str`, and `k` adjacent to one another in the memory occupied by the stack frame.

Suppose then that `some_function` has been written sloppily and reads user input into `str` without checking to make sure the user input fits in the 100 bytes of `str`. The excess bytes in the user input will spill over the end of `str` and corrupt the contents of `j` or `k`, depending on whether one of them is stored in memory immediately after `str`. If the user input is long enough, it might also corrupt a lot more of the stack (including the stack frames of previous function calls).

Another piece of data in the stack frame is the *return address*. That is, the stack frame includes the 8-byte address of the instruction immediately following the `call` instruction that brought us to `some_function` in the first place. When the `ret` instruction gets executed by `some_function` to return to the function from which it was called, `ret` uses the return address as the destination to which to return.

If our users are clever enough, they can type input that will (1) overflow `str` and (2) overwrite the return address with the address of some other function. This would cause `some_function` to "return" to the wrong place, which could lead to all sorts of mayhem depending on what code resides at that wrong place.

This kind of sneaky user is engaged in what is known as a [buffer overflow attack](https://owasp.org/www-community/attacks/Buffer_overflow_attack). In this assignment, you are going to play the role of buffer-overflow attacker. In the process, you'll get more familiar with the way function calling works at the assembly language level.

## WHAT TO DO
1. **Get your attack target.** Fill out the form at [http://cs208.mathcs.carleton.edu:1866/](http://cs208.mathcs.carleton.edu:1866/) to download your `targetN.tar file`. This file is analogous to the `zooN.tar` file you obtained during the the [zoo-escape assignment](hw7).
2. **Move your `targetN.tar` file to mantis** and expand it there (with `tar xvf targetN.tar`). The `targetN.tar` file contains a whole bunch of files, some of which you will not need because we're doing only a portion of the original lab. The files you will need are:
    * `ctarget` — the executable program that you will attack. This program is vulnerable to code injection attacks.
    * `ctarget.phaseN` for N = 1, 2, and 3 — files where you can put your solutions to the phases as you work (analogous to the `passcodes.txt` file from the zoo assignment).
    * `cookie.txt` — an 8-digit hex code that you will use as a unique identifier in your attacks.
    * `hex2raw` — a utility program that will help you to generate attack strings.
Ignore `rtarget*` and `farm.c`

3. **For each phase:**
    * Read about the phase. ([Phase1](#phase-1-make-ctarget-call-the-wrong-function), [Phase2](#phase-2-make-ctarget-call-the-wrong-function-with-an-int-parameter), [Phase3](#phase-3-make-ctarget-call-the-wrong-function-with-a-string-parameter))
    * Use gdb (and [gcc for some phases](#appendix-b-generating-byte-codes)) to figure out what bytes you want to write into (and past) the input buffer so as to corrupt the stack frame in whatever way is required to achieve your goal.
    * Store the bytes you want to input as space-delimited bytes (2 hexadecimal digits each) in the `ctarget.phaseN` file (with N for whichever phase you're working on).

    Note that your exploit strings must not contain the byte value 0x0a, since this is the ASCII code for newline ('\n') and `ctarget` will consider it the end of your input.

    * Perform your attack like so:
    ```
    cat ctarget.phaseN | ./hex2raw | ./ctarget
    ```

    If you're successful, ctarget will let you know.
    * Make sure you run the attack on mantis so your success will get recorded.
    * Check out your progress at [http://cs208.mathcs.carleton.edu:1866/progress](http://cs208.mathcs.carleton.edu:1866/progress)
    Unless you run `ctarget` with the `-q` flag, your exploit string will be sent to the assignment server and tested. The server will then update your status on the progress page.

    There is no penalty for making mistakes in this assignment, nor are mistakes even recorded anywhere. Experiment at will!

    The progress server expects you to work on mantis.mathcs.carleton.edu. You can certainly do your work on any Linux x86-64 computer, but eventually, you'll need to submit your solution to each phase from mantis.

4. **Celebrate!**

## GENERAL INFORMATION ABOUT CTARGET
`ctarget` reads strings from standard input. It does so using the function `getbuf`:

```c
unsigned getbuf() {
    char buf[BUFFER_SIZE];
    Gets(buf);
    return 1;
}
```

The function `Gets` is similar to the standard library function `gets` — it reads a string from standard input (terminated by '\n' or end-of-file) and stores it including a null terminator at the specified destination address. In this code, you can see that the destination is an array `buf`, declared as having `BUFFER_SIZE` bytes. At the time your `ctarget` was generated, `BUFFER_SIZE` was a compile-time constant unique to your version of the program.

Functions `Gets` and `gets` have no way to determine whether their destination buffers are large enough to store the string they read. They just keep copying input bytes to the buffer until they encounter '\n' or end-of-file. **People who program using these input functions are at risk of buffer overflow attacks.** (So you should never do that!)

(Note that `getbuf()` is really weird in a "this-is-a-classroom-exercise" sort of way. It reads data into the local variable `buf`, and then immediately returns without doing anything with the data. That seems dumb, right? What you need to imagine is that this same operation — declare a buffer and read data into it — is happening in the context of a real-life program, where the dangerous `Gets(buf)` line is followed by code that does something important with the contents of `buf`. This scenario — uncontrolled input followed by critical computation — is disturbingly common in important code that runs the world.)

For this assignment, we will refer to the bytes entered by the user as the *exploit string*. If your exploit string is sufficiently short, it won't overrun the buffer `buf`, so `getbuf` will finish normally and return 1, as shown by this execution example (user input in yellow):

```bash
./ctarget
Cookie: 0x1a7dd803
Type string: Look! A moose!
No exploit. Getbuf returned 0x1
Normal return
```

Typically, though, an error occurs if you type a long string:

```bash
./ctarget
Cookie: 0x1a7dd803
Type string: This string may not express moose-related content concisely, but it is plenty long blah blah blah ... 
Ouch!: You caused a segmentation fault!
Better luck next time
FAILED
```

As the error message indicates, overrunning the buffer typically causes the program state to be corrupted, leading to a memory access error.

Because many of the bytes you are going to want to feed to `ctarget` will not be printable ASCII characters, you will usually use the technique mentioned in the previous section and elaborated in [Appendix A](#appendix-a-using-hex2raw) — store your bytes in hexadecimal in a text file called `ctarget.phaseN` and use `hex2raw` to convert your text data to the desired bytes before piping the result to `ctarget`'s `stdin`. Here, for example, is what you might see if you have a correct solution to Phase 2:

```bash
cat ctarget.phase2 | ./hex2raw | ./ctarget
Cookie: 0x1a7dd803
Type string:Touch2!: You called touch2(0x1a7dd803)
Valid solution for level 2 with target ctarget
PASS: Sent exploit string to server to be validated.
NICE JOB!
```

`ctarget` has some command-line flags that might be handy. You can execute `ctarget -h` to read about them.

## PHASE 1: MAKE `CTARGET` CALL THE WRONG FUNCTION
For phase 1, your exploit string will redirect the program to execute an existing function that it's not intended to execute. Function `getbuf` is called within `ctarget` by a function `test`:

```c
1 void test() {
2     int val;
3     val = getbuf();
4     printf("No exploit. Getbuf returned 0x%x\n", val);
5 }
```

When `getbuf` executes its return statement, the program ordinarily resumes execution within function `test` (at line 4 of this function). We want to change this behavior. Within the file `ctarget`, there is code for a function `touch1`:

```c
1 void touch1() {
2     vlevel = 1; /* Part of validation protocol */
3     printf("Touch1!: You called touch1()\n");
4     validate(1);
5     exit(0);
6}
```

Your task is to get `ctarget` to execute the code for `touch1` when `getbuf` executes its return statement, rather than returning to test. Note that your exploit string may also corrupt parts of the stack not directly related to the this modified return statement, but that's OK with us, since `touch1` causes the program to exit directly.

Some Advice:

* All the information you need to devise your exploit string for this phase can be determined by examining a disassembled version of `ctarget`. Use `objdump -d ctarget` to get this disassembled version. (More specifically, I recommend `objdump -d ctarget > disassembly.s` instead, so you can open the disassembled code in an editor so it's easy to explore.)
* The idea is to position a byte representation of the starting address for `touch1` so that the `ret` instruction at the end of the code for `getbuf` will transfer control to `touch1`.
* Be careful about byte order. Remember little-endian!
* You will certainly want to use `gdb` to step through the program through the last few instructions of `getbuf` to make sure it is doing what you want. You'll be modifying the contents of the stack on purpose, so don't forget "`x/1ss $rsp`", "`x/20dw 0x1234567`", and similar `gdb` commands to see whether you're modifying it the way you intend.
* The placement of `buf` within the stack frame for `getbuf` depends on the value of compile-time constant `BUFFER_SIZE`, as well the stack allocation strategy used by GCC. You will need to examine the disassembled code to determine its position.

## PHASE 2: MAKE `CTARGET` CALL THE WRONG FUNCTION WITH AN INT PARAMETER
Phase 2 involves placing a small amount of machine-language code on the stack as part of your exploit string, and then inducing the program to execute this *injected* code.

Within `ctarget` there is code for a function `touch2`:

```c
1  void touch2(unsigned val) {
2     vlevel = 2;       /* Part of validation protocol */
3     if (val == cookie) {
4         printf("Touch2!: You called touch2(0x%.8x)\n", val);
5         validate(2);
6     } else {
7         printf("Misfire: You called touch2(0x%.8x)\n", val);
8         fail(2);
9     }
10    exit(0);
11 }
```

Your task is to get `ctarget` to execute the code for `touch2` rather than returning to `test`. In this case, however, you must make it appear to `touch2` as if you have passed your cookie as its argument.

Some advice:

* Your program's cookie is in the file `cookie.txt` included in your `targetN.tar`.
* You will want to position a byte representation of the address of your injected code in such a way that `ret` instruction at the end of the code for `getbuf` will transfer control to it.
* As you may remember, the first argument to a function is passed in register `%rdi`. Your injected code should set `%rdi` to your cookie, and then use a `ret` instruction to transfer control to the first instruction in `touch2`.
* Do not attempt to use `jmp` or `call` instructions in your exploit code. The encodings of destination addresses for these instructions are difficult to formulate. Use `ret` instructions for all transfers of control, even when you are not returning from a `call`.
* See the instructions in [Appendix B](#appendix-b-generating-byte-codes) on how to use tools to generate the byte-level representations of instruction sequences.

## PHASE 3: MAKE CTARGET CALL THE WRONG FUNCTION WITH A STRING PARAMETER
Like Phase 2, Phase 3 involves a code injection attack, but this time passing a string rather than an integer as a parameter.

`ctarget` contains functions `hexmatch` and `touch3`:

```c
/* Compare string to hex represention of unsigned value */
1  int hexmatch(unsigned val, char *sval) {
2      char cbuf[110];
3      /* Make position of check string unpredictable */
4      char *s = cbuf + random() % 100;
5      sprintf(s, "%.8x", val);
6      return strncmp(sval, s, 9) == 0;
7  }
8
9  void touch3(char *sval) {
10     vlevel = 3;    /* Part of validation protocol */
11     if (hexmatch(cookie, sval)) {
12         printf("Touch3!: You called touch3(\"%s\")\n", sval);
13         validate(3);
14     } else {
15         printf("Misfire: You called touch3(\"%s\")\n", sval);
16         fail(3);
17     }
18     exit(0);
19 }
```

Your task is to get `ctarget` to execute the code for `touch3` rather than returning to `test`. You must make it appear to `touch3` as if you have passed a string representation of your cookie as its parameter.

Some Advice:

* You will need to include a string representation of your cookie in your exploit string. The string should consist of the eight hexadecimal digits (ordered from most to least significant) without a leading "0x."
* Recall that a string is represented in C as a sequence of bytes followed by a byte with value 0. Type `man ascii` on any Linux machine (or a Mac) to see the byte representations of the characters you need.
* Your injected code should set register `%rdi` to the address of your cookie string.
* When functions `hexmatch` and `strncmp` are called, they push data onto the stack, overwriting portions of memory that held the buffer used by `getbuf`. As a result, you will need to be careful where you place the string representation of your cookie.

## APPENDIX A: USING HEX2RAW
`hex2raw` is a command-line utility that takes as input a hex-formatted string. In this format, each byte value is represented by two hex digits. For example, the string "012ABC" could be entered in hex format as "30 31 32 41 42 43 00".

The hex characters you pass to `hex2raw` should be separated by whitespace (blanks or newlines). I recommend separating different parts of your exploit string with newlines while you're working on it. `hex2raw` supports C-style block comments, so you can mark off sections of your exploit string. For example:

```
48 c7 c1 f0 11 40 00 /* mov $0x40011f0,%rcx */
```

Be sure to leave space around both the starting and ending comment strings ("/*", "*/"), so that the comments will be properly ignored.

Don't forget that byte order matters in many contexts. If, say, a phase is expecting a 4-byte int to be stored at a particular memory location, you'll want to make sure you put the lowest-order byte of the int first in memory.

If you generate a hexformatted exploit string in the file `ctarget.phase1`, you can apply the raw string to `ctarget` in a couple different ways:

* You can set up a series of pipes to pass the string through `hex2raw`

    ```bash
    cat ctarget.phase1 | ./hex2raw | ./ctarget
    ```

* You can store the raw string in a file and provide the filename as a command-line argument:

    ```bash
    ./hex2raw < ctarget.phase1 > ctarget.phase1.raw
    ./ctarget -i ctarget.phase1.raw
    ```

    This approach also can be used when running from within GDB.

## APPENDIX B: GENERATING BYTE CODES
For phases 2 and 3, you need to send machine-language instructions as part of your input to `ctarget`. But how can you determine what bytes the desired instructions consist of?

You can use `gcc` as an assembler and `objdump` as a disassembler to make it convenient to generate the bytes in your desired instruction sequences. For example, suppose you write a file `example.s` containing the following assembly code:

```
# Example of hand-generated assembly code
pushq   $0xabcdef  # Push value onto stack
addq    $17,%rax   # Add 17 to %rax
movl    %eax,%edx  # Copy lower 32 bits of %eax to %edx
```

The code can contain a mixture of instructions and data. Anything to the right of a '#' character is a comment. You can now assemble and disassemble this file:

```bash
gcc -c example.s
objdump -d example.o > example.d
```

The generated file `example.d` contains the following:

```
example.o: file format elf64-x86-64

Disassembly of section .text:
0000000000000000 <.text>:
    0: 68 ef cd ab 00        pushq  $0xabcdef
    5: 48 83 c0 11           add    $0x11,%rax
    9: 89 c2                 mov    %eax,%edx
```

The lines at the bottom show the machine code generated from the assembly language instructions. Each line has a hexadecimal number on the left indicating the instruction's starting address (starting with 0), while the hex digits after the ':' character indicate the actual bytes that make up the machine-language version of the instruction. Thus, we can see that the instruction `push $0xABCDEF` has hex-formatted machine-language code 68 ef cd ab 00.

From this file, you can get the byte sequence for the code:

```
68 ef cd ab 00 48 83 c0 11 89 c2
```

This string can then be passed through `hex2raw` to generate an input string for the target programs. Alternatively, you can edit `example.d` to omit extraneous values and to contain C-style comments for readability, yielding:

```
68 ef cd ab 00   /* pushq  $0xabcdef  */
48 83 c0 11      /* add    $0x11,%rax */
89 c2            /* mov    %eax,%edx  */
```

This is also a valid input you can pass through `hex2raw` before sending to one of the target programs.

## SOME FINAL NOTES
* Section [7.10](https://diveintosystems.org/book/C7-x86_64/buffer_overflow.html) of the textbook provides useful reference material for this assignment.
* This stuff feels weird at first, but you can figure it out! Draw pictures, step slowly through the code, take a look at the stack and the registers, figure out where function parameters are stored, and just gradually put together a picture of what's going on for yourself. Talk to each other, talk to me, step away and take a walk, and come back to it again.
* Learning how to exploit software vulnerabilities helps you to understand those vulnerabilities and how to prevent them. At the same time, of course, this knowledge could potentially be used to harm other people. [Don't do that.](https://apps.carleton.edu/handbook/community/?a=student&policy_id=6131)

## HAVE FUN!