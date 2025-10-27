---
layout: page
title: HW6 - Escape from the Zoo!
permalink: /classes/208-f25/hw6
---

**Due: Wednesday, Oct 29th, at 10:00pm**

This assignment is an adaptation of Jeff Ondich’s adaptation of Aaron Bauer’s adaptation of [this lab](https://www.cs.cmu.edu/afs/cs/academic/class/15213-f19/www/labs/bomblab.pdf) developed for the Carnegie Mellon University’s 15-213 (Introduction to Computer Systems) course, which is the course for which a fun (but not free) textbook was written.

## Goals
This assignment is designed to help you practice with the following:

* experiencing the beginnings of reverse engineering: using debugging tools (especially [`gdb`](https://www.sourceware.org/gdb/)) to study executables at the assembly language level
* deepening your understanding of the x86-64 assembly language

## Collaboration policy
For this assignment, you may work alone or with a partner, but you must complete your own individual zoo escape (more details below).

You may also discuss the assignment at a high level with other students.

For this assignment, you can talk about the assembly with others in the course, even those who aren’t your partner, but only in small chunks (e.g., 5-10 instructions, but not an entire function). You **should not spoil any of the doors** for people who aren’t your partner. That means you can make sense of a call to `sscanf` collectively, but **once you have a short description of the puzzle you can’t share that with anyone but your partner**.

You should list any student with whom you discussed the assignment, and the manner of discussion (high level, partner, etc.) in your `descriptions.txt` file.

*If you work alone, you should say so instead.*

## Assessment
The scoring on this one is a little complicated, and this rubric likely won’t make a lot of sense until you read the rest of the assignment.

The **core requirements** for your submission are:

* open doors 1–3 (inclusive)
* have accurate and concise explanations for doors 1–3 in `descriptions.txt`
* include your zoo ID in your `descriptions.txt` file
* include your name and collaboration statement in your `descriptions.txt` file

The **advanced requirements** for your submission are:

* satisfy the core requirements
* successfully complete either:
    * option 1:
        * open doors 4 and 5
        * have accurate and concise explanations for at least two of doors 4–6
    * option 2:
        * open doors 4–6 (inclusive)
        * have an accurate and concise explanation for at least one of doors 4–6

Good explanations will be succinct paragraphs describing, at a high level of abstraction, what the door puzzle is computing with your input.

If you are unable to open a door, your explanation of that door is unlikely to be clear or persuasive.

Although the doors get progressively harder to open, the expertise you gain as you move from door to door should offset this difficulty. However, the later doors will likely take quite a bit of time to work through, so **don’t wait until the last minute to start.**

## Background
*You wake up, and find yourself in a strange place. Walking around, you see signs indicating that you’re in a moose enclosure, in what appears to be a zoo. But, there’s no moose!*

*The only way out is through a door with a touchscreen on it. But how did the moose get out without fingers to activate the screen? Looking around more, you also find some suspiciously nibbled-on trees. Was there a beaver here, too?*

*This is either a really bad day, or the weirdest dream you’ve had in a while. Either way, the only way out is through that door.*

*You approach the screen…*

It would appear that the beaver and the moose are in cahoots and on the loose. They’ve trapped you in their former enclosure. To keep you trapped in their place, they’ve rigged a series of six doors, each of which requires a password to open.

To escape your zoo enclosure, you’ll need to make it through these six doors. Each door is part of one big program, and each door is opened by entering into the computer terminal a specific line of text, which we’ll call a *passcode*. If you type the correct passcode, then the door opens and you may move onto the next door. Otherwise, the doors all lock, their terminal screens display a taunting message, the alarms sound, and you’re back at square one. You can fully escape the zoo only by opening every door.

## Step 1: Access the terminal
You can access the zoo’s security terminal (i.e., obtain your program to open the doors) by filling out the form at [http://cs208u.mathcs.carleton.edu:55057/](http://cs208u.mathcs.carleton.edu:55057/).

You will need to be on campus or connected to the Carleton VPN to access this page. Once you have filled out and submitted the form, the server will build your executable and return it to your browser in a file named `zooN.tar`, where `N` is the unique ID of your zoo enclosure. (Note: **your zoo program will be different from every other student’s zoo program,** even though they have similar structures.)

Upload `zooN.tar` to your account on mantis using whatever file transfer technique you prefer. This could be clicking the upload button when you’re logged into mantis. If you prefer the command line, you could use scp ("secure copy"), like so:

```bash
scp zooN.tar YOURUSERNAME@mantis.mathcs.carleton.edu:/Accounts/YOURUSERNAME/wherever
```

where `wherever` is the path to whatever directory you want to store the file in. On Windows, Tanya always sets up WSL where `scp` is installed, but if you’re not so inclined, Powershell works pretty well nowadays, or applications like [WinSCP](https://winscp.net/eng/index.php) are still chugging along.

Put `zooN.tar` wherever you want to work with it, and then un-tar it in the usual way:

```bash
tar xvf zooN.tar
```

(`x`: extract, `v`: verbose, `f`: filename)

This will create a directory called `zooN` with the following files:

* `README`: Identifies the zoo enclosure and its occupant (that’s you).

* `zoo.c`: The source file with the door’s terminal screen’s `main` function and welcome message.

* `zoo`: The executable program controlling the doors to your zoo enclosure. It will automatically submit your progress to a scorekeeping server. Note that you can run this program on any Linux computer (including Windows Subsystem for Linux) on the Carleton network (including connections via the Carleton VPN), but it’s probably best to do your work on `mantis`.

* `zoo-quiet`: An offline version of the executable door program. You can work on this one without an internet connection. You just need to run `zoo` once while connected to have your progress recorded.

* `descriptions.txt`: The file in which you should briefly explain the functionality of each door you open, and how you opened it. (See below for further discussion of this file.)

* `passcodes.txt`: The file in which you record your door-opening inputs, one line per door puzzle.

If for some reason you request multiple door terminal programs from the web form, this is not a problem. Choose one to work on and delete the rest.

**Note:** It is possible that after extracting files, `zoo` and `zoo-quiet` will not be marked as executable in their Unix file permissions. This will prevent `gdb` from being able to run or debug them. To fix this problem, `cd` into your zoo directory and execute this command:

```bash
chmod +x zoo zoo-quiet
```

## Step 2: The great escape!
Your job for this assignment is to escape the zoo. What this means in practice is that you will accumulate a sequence of input strings, one per door, that open each door.

For each string you discover, put it in your `passcodes.txt` file. If you open all six doors, `passcodes.txt` should have six non-blank lines (note that the `zoo` program ignores blank lines, so you may space out your passcode strings if you wish.)

Note: **You must complete this assignment on Linux/WSL**. The zoo is secure enough to have tamper-proofing mechanisms build into the doors.

You can use many tools to help you escape the zoo. See the [Suggestions](#suggestions-and-hints) section below for details.

## Step 3: Write your descriptions
See the [Assessment](#assessment) section above for a description of what you should write to describe how you open each door. As noted there, you’re looking for a short description of "what is this code doing".

Put your descriptions in `descriptions.txt`, **along with your zoo enclosure number.**

## Step 4: Submit your work
To submit your work, follow these steps:

1. While connected to the Carleton network, run your `zoo` program and open as many doors as you can. This will cause your successful escape progress to get logged on the grading server. You can check to make sure your opened doors got logged properly by going to [http://cs208u.mathcs.carleton.edu:55057/progress](http://cs208u.mathcs.carleton.edu:55057/progress).

*Note:* The **zoo-quiet** program does not report your progress, so you eventually need to register your escape by running **zoo** at least once.

2. Submit `descriptions.txt` and `passcodes.txt` to Gradescope. **Make sure to include your zoo enclosure number and name/collaboration statement in your `descriptions.txt` file.**

## Suggestions and hints
* If you run your `zoo` program with a command-line argument, like:

    ```bash
    ./zoo passcodes.txt
    ```

    the program will read the input lines from `passcodes.txt` until it reaches `EOF` (end of file), and then switch over to reading from the command line. The beaver seems to have added this as a debugging feature when prepping the doors, but forgot to remove it. Either way, you can use it to keep retyping the solutions to doors you have already opened.

* The `zoo` program ignores blank input lines, both from the keyboard and from the input file. This means that you can space out your `passcodes.txt` lines if you want to. But, note that the *order* of the `passcodes.txt` lines must correspond to the order of the door puzzles.

* You have to open the doors in order.

* To avoid accidentally re-locking all doors, you will need to learn how to single-step through the assembly code and how to set breakpoints. You will also need to learn how to inspect both the registers and the memory states. One of the nice side-effects of doing this assignment is that you will get very good at using a debugger. This is a crucial skill that will pay big dividends dealing with buggy software in the future.

* If you don’t want to have the server record all of your incomplete attempts to make sense of your debugging efforts, you can debug the `zoo-quiet` program instead of `zoo`. You just need to make sure that eventually you run `zoo` once while connected to the Carleton network (e.g., on `mantis`) so that your progress gets logged.

* You may assume that functions do what their names imply. For example, `phase1()` is most likely the first puzzle (e.g., opens the first door), `printf()` is just `printf()`, and a function named `strings_not_equal()` probably takes two strings and returns a value indicating whether they are not equal. *If there is a function that looks like it may trigger the alarm, it would probably help to set a breakpoint there!*

* Most cryptic function calls you’ll see (e.g., `callq ... <_exit@plt>`) are calls to C library functions. (You can safely ignore the `@plt` as that refers to *dynamic linking* (whatever that is).)

* Most door puzzles use the C library function `sscanf` to parse the input string, so you will want to understand [how this function works](https://cplusplus.com/reference/cstdio/sscanf/).

* Avoid going through the assembly for C library functions—reading the documentation and writing your own small experimental C programs will be a much easier path to understanding them!

* Make sure to have a newline at the end of your `passcodes.txt` so that all your input gets read in correctly.

## Tools you can use
There are many tools that are designed to help you figure out both how programs work and what is wrong when they don’t work. Here is a list of some of the tools you may find useful in analyzing your `zoo` program, and hints on how to use them:

* `gdb`: This is a command-line debugger tool available on virtually every platform. You can trace through a program line by line, examine memory and registers, look at both the source code and assembly code (which will be important, as you will not have the source code for most of the `zoo` program), set breakpoints, set memory watch points, and write scripts.

    * Here’s a [good tutorial on gdb](https://beej.us/guide/bggdb/).
    * Here’s a [handy quick reference sheet](http://csapp.cs.cmu.edu/3e/docs/gdbnotes-x86-64.txt).
    * To keep the `zoo` program from triggering the alarm every time you provide a wrong passcode, you’ll want to learn how to set breakpoints.
    * For documentation, type `help` at the `(gdb)` command prompt.

* `objdump -t`

    This will print out the `zoo` program’s symbol table. The symbol table includes the names of all functions and global variables in the program, the names of all the functions called, and their addresses. You may learn something by looking at the function names! You can save the output to a file by redirecting `stdout` to a new file name, like this:

    ```bash
    objdump -t zoo > zoo_symbols.txt
    ```

* `objdump -d`

    Use this to disassemble all of the code in the `zoo` program. You can also just look at individual functions. Reading the assembly code can tell you how the `zoo` program works. Like above, you can save the output to a file for later reading (or commenting?!):

    ```bash
    objdump -d zoo > zoo_assembly.txt
    ```

    Although `objdump -d` gives you a lot of information, it doesn’t tell you the whole story. Calls to system-level functions are displayed in a cryptic form. For example, a call to `sscanf` might appear as:

    ```bash
    8048c36:  e8 99 fc ff ca  call   80488d4 <_init+0x1a0>
    ```
    To determine that the call was to `sscanf`, you likely need to disassemble within `gdb`.

* `strings`

    This utility will display all of the printable strings in a program. Use `man strings` to see the manual page for this command to understand how you might see all of the strings, including useful information like their locations in the program.

## Have fun and good luck!
