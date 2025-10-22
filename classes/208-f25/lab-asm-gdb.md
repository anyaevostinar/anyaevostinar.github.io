---
layout: page
title: Assembly in GDB Lab
permalink: /classes/208-f25/asm-gdb-lab
---

## Goals
Your primary goal for this lab is to get familiar with using the GNU debugger (`gdb`) to explore and debug x86-64 programs, focusing on arithmetic operations and `set`/`cmp`/`test` instructions.

## Documentation and tutorials
You will find some potentially useful [gdb resources](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources#gdb) posted on our [Resources](https://www.cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources) page.

## Getting started
In this lab, we’ll be working with the sample `struct_math.c`, which showcases a little bit of each topic in assembly that we’ve seen so far. Grab the source code and copy it to `mantis`. Here’s the easiest way:

* SSH into `mantis` via VS Code and open a terminal in your `CS208` folder.

* Make a new directory for this lab:

    ```bash
    mkdir lab5
    ```

* Change to your new directory:

    ```bash
    cd lab5
    ```
* Grab the source code:

    ```bash
    wget https://cs.carleton.edu/faculty/tamert/courses/cs208-s25/resources/samples/struct_math.c
    ```

* Compile it to assembly:

    ```bash
    gcc -Wall -Werror -Og -S -o struct_math.s struct_math.c
    ```

## Step 1: Review `movX`, `movXYZ`, and `leaX` instructions
Look at the source code in `struct_math.c`. There are five different functions called, starting with `func0`. For this function, could you predict what the assembly will look like?

### Exploring `func0`

Open the file `struct_math.s` and find the function `func0`. Let’s comment the lines:

```bash
func0:                              # we found func0!
.LFB23:                             # (ignore)
    .cfi_startproc                  # (ignore)
    endbr64                         # (ignore)
    movl    %esi, %esi              # copy %esi into %esi (why?!??)
    leaq    16(%rsi,%rdi), %rax     # puts 16 + R[%rsi] + R[%rdi] in %rax
    ret                             # returns...something
    .cfi_endproc
```

The first question to ask is why does it copy `%esi` into itself? A `movl`, due to changes going from 32-bit x86 to 64-bit x86-64, clears the top 32 bits of the register. This makes sure we can use the 32-bit int passed in via `%esi` as a pointer.

Why is the next instruction an `lea`? What would happen if it were a `mov` instead?

Now we grab the address given by `%rdi + %rsi + 16` and copy it into `%rax`. Take a look at the struct definition:

```c
typedef struct
{
    int a;          // start + 0 (bytes 0-3)
    int b;          // start + 4 (bytes 4-7)
    int *p;         // start + 8 (bytes 8-15)
    char s[8];      // start + 16 (bytes 16-23, each char is 1)
    short v[4];     // start + 24 (bytes 24-31, each short is 2)
} data_t;
```

Therefore, `%rdi` must be the address of the struct itself, and looking 16 bytes after its start gives us the `s` member of the struct. We’re using `%rsi` as the index, with a scale of `1` because it’s an array of `char`.

This matches our line of code:

```c
    return &(data->s[i]);
```

Pause for a moment – what questions do you have?

### Exploring `func1`
Now let’s look at `func1`. You’ll notice that it does an array lookup and ends with an xor operation. Can you map that to its assembly? Try commenting each (relevant) line of the assembly (before looking at the example below)...

```bash
func1:
.LFB24:
    .cfi_startproc
    endbr64
    movl    %esi, %esi                  # clear the top half of %rsi
    movzwl  24(%rdi,%rsi,2), %eax       # %eax <- M[24+%rdi+2*%rsi]
    xorw    4(%rdi), %ax                # %ax <- %ax ^ M[4+%rdi]
    ret
    .cfi_endproc
```

After making a first pass, let’s match this up with what we know about the function signature:
`short func1(data_t *data, unsigned int i)`.

```bash
func1:
.LFB24:
    .cfi_startproc
    endbr64
    movl    %esi, %esi                  # clear the top half of %rsi
    movzwl  24(%rdi,%rsi,2), %eax       # %eax <- data->v[i]
    xorw    4(%rdi), %ax                # %ax <- %ax ^ data->b
    ret
    .cfi_endproc
```

Make sure to remember that arithmetic operations are of the form `OP src, dst`, and the action performed is `dst <- dst OP src`. If you read it backwards like this, then `sub` and `cmp` instructions make much more sense!

Again, pause to determine which questions you have.

## Step 2: More mathematical operations
Now look at `func2`. Most of this is relatively straightforward, but we want to focus on the math at the bottom.

### Arithmetic operations
See if you can separate out the relevant blocks. Put in blank lines to separate each of the four assignments to `data->v` elements from each other in assembly.

What questions do you have about the first three?

### Logical operations and set instructions
Now let’s look at the last assignment statement:

```c
data->v[3] = x && y;
```

This one gets a little weird. We need to check if `x` is non-zero and if `y` is non-zero, and, if they’re both non-zero, put a 1 in `data->v[3]` (or a 0 otherwise).

Let’s break down the corresponding assembly:

```bash
# Determine if x is "true"
testq   %rdi, %rdi      # set flags using x & x
setne   %cl             # %cl <- ~ZF (0 if x&x==0, 1 otherwise)

# Determine if y is "true"
testq   %rsi, %rsi      # set flags using y & y
setne   %al             # %al <- ~ZF (0 if y&y==0, 1 otherwise)

# Perform an "and" on the two individual bits
andl    %ecx, %eax      # %eax <- %eax & %ecx (y!=0 & x!=0)

# We did the "and" using 32-bit values, but we only stored
# stuff in the bottom 8 bits originally, so there could be
# garbage bytes still living in the top 24 bits -- extend
# %al to the full 32 bits
movzbl  %al, %eax

# Copy the 16 bits we actually care about for our "short" result
# in data->v[3]
movw    %ax, 30(%rdx)
```

### Checking register values in gdb
Now let’s step through the assembly to make sense of all of this.

1. Compile the program if you haven’t already:
    ```bash
    gcc -o struct_math struct_math.s
    ```

2. Start `gdb`:
    ```bash
    gdb struct_math
    ```

3. Set a breakpoint at the start of `func2` (here the `(gdb)` is the prompt – don’t type that):
    ```bash
    (gdb) b func2
    ```

4. Run the program, causing it to break once it gets into `func2`:
    ```bash
    (gdb) r
    ```

5. Now let’s inspect what we’ve got. The function signature is `void func2(int *x, int *y, data_t *data)`. Check the C code in `main` to see what values are passed in within the addresses `x` and `y`.

6. Let’s print these values (in hex) in `gdb` (note that we have to use `$`, not `%`, with register names in `gdb`):

    ```bash
    (gdb) p /x $rdi
    $1 = 0x7fffffffe938
    (gdb) p /x $rsi
    $2 = 0x7fffffffe93c
    ```

7. These values are the addresses. Pretty soon you’ll start recognizing numbers that start with `0x7ffff...` as addresses on the stack. Let’s instead “eXamine” the values at those locations (in decimal and hex, respectively):

    ```bash
    (gdb) x/d $rdi
    0x7fffffffe938: 3
    (gdb) x/x $rsi
    0x7fffffffe93c: 0x00000ace
    ```
    This should match the inputs we’ve passed from `main`.

8. Let’s move on to see how the string (the `char` array `data->s`) looks in `gdb`. Use `ni` to move to the next instruction until after it stores the two `'\0'` values in `data->s`.

9. We can print out this string if we know where it is. It’s been stored starting at `0x10(%rdx)`, so let’s figure that out (recall that `data` is passed in as the third parameter, so it’s in `%rdx`):

    ```bash
    (gdb) p /x $rdx
    $3 = 0x7fffffffe940
    (gdb) x/s 0x7fffffffe950
    0x7fffffffe950: "hobbes"
    (gdb) x/s $rdx+0x10
    0x7fffffffe950: "hobbes"
    ```

10. Finally, let’s take a look at the values we’ve put in `data->v` right before returning. Use `ni` until the highlighted line is the `ret` (so that’s the next instruction executed).

11. We can examine several bytes of memory at once, in groups. Let’s start by looking at the 4 shorts in `data->v`, in hex:

    ```bash
    (gdb) x/4hx $rdx+0x18
    0x7fffffffe958: 0xffff 0xcafe 0x00c4 0x0001
    ```

    Note that gdb has its own silly set of prefixes: `b` means “byte”, `h` means “halfword” (two bytes), `w` means “word” (four bytes), and `g` means “giant word” (eight bytes). The expression above `x/4hx` says “examine four half-word (two byte) chunks, starting at the given address”.

    You can find more info here: [https://ftp.gnu.org/old-gnu/Manuals/gdb/html_node/gdb_55.html](https://ftp.gnu.org/old-gnu/Manuals/gdb/html_node/gdb_55.html).

12. We could instead look at this chunk of memory in individual bytes:
    ```bash
    (gdb) x/8bx $rdx+0x18
    0x7fffffffe958: 0xff   0xff    0xfe    0xca    0xc4    0x00    0x01    0x00
    ```

    Is this using little-endian or big-endian byte ordering? How can you tell?

13. Let’s do one more silly thing and treat `data->v` as a single `long`. Before you run this, predict the output!
    ```bash
    (gdb) x/1gx $rdx+0x18
    <output not shown -- run it yourself!>
    ```

## Step 3: Explore the loops
Finally, take some time to explore the loops in `func3` and `func4`. Try to answer these questions for yourself:

1. Which registers are used to store the variable `i`?
2. What changes when we use `unsigned int` versus `int` for `i`?
3. How does our comparison line up with the `i < 8` and `i < 4` comparisons in the C code?
4. Which instruction corresponds to the `i++`?
5. Is there anything special about `+` versus `*`?

As always, try to explore, ask any questions you have, and have fun!