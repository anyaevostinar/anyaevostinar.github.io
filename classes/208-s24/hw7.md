---
layout: page
title: HW7 ESCAPE FROM THE ZOO - A REVERSE ENGINEERING ADVENTURE
permalink: /classes/208-s24/hw7
---


This assignment is an adaptation by Jeff Ondich and Tanya Amert of Aaron Bauer's adaptation of [this lab](https://www.cs.cmu.edu/afs/cs/academic/class/15213-f19/www/labs/bomblab.pdf) developed for the Carnegie Mellon University's 15-213 (Introduction to Computer Systems) course, which is the course for which another Systems textbook was written. 

## GOALS
* Experience the beginnings of reverse engineering: using debugging tools (especially [gdb](https://www.sourceware.org/gdb/)) to study compiled software at the assembly language level.
* Deepen your understanding of the x86-64 assembly language

## Logistics
This is a **paired** assignment, so you should continue to work with your assigned partner from HW6, if you have one. If you chose not to be assigned a partner, you must work individually (you can't pick your own partner!). As usual, you can get help as detailed in the [collaboration](collaboration) document. You should submit only one assignment to Gradescope for your pair and add your partner to the submission. If for some reason you and your partner can't make things work, you can split, but you have to let me know asap.

(HW8, the next homework, will be the start of the assignments where you choose your own partner by the way.)

This assignment is due Wednesday May 8th at 10pm. As with all assignments, you will have the opportunity to **individually** [revise](revision-process) this submission based on feedback.

## Assessment
Scoring on this one is a little complicated, and this rubric won't make a lot of sense until you read the rest of the assignment.

To **demonstrate proficiency**, your submission needs to:
* Open doors 1-3 (inclusive)
* Have accurate and concise explanations for doors 1-3

To **demonstrate mastery**, your submission needs to:
* Demonstrate proficiency
* Open at least two of the doors 4-6
* Have accurate and concise explanations for at least two of the doors 4-6

Good explanations will be succinct paragraphs describing, at a high level of abstraction, what the door puzzle is computing with your input.

If you are unable to open a door, your explanation of that door is unlikely to be clear or persuasive.

Although the doors get progressively harder to open, the expertise you gain as you move from door to door should offset this difficulty. However, the later doors will likely take quite a bit of time to work through, so don’t wait until the last minute to start.

## BACKGROUND
*You wake up and find yourself in a strange place. Walking around, you see signs indicating that you’re in a moose enclosure, in what appears to be a zoo. But there’s no moose!*

*The only way out is through a door with a touchscreen on it. But how did the moose get out without fingers to activate the screen? Looking around more, you find some suspiciously-nibbled trees. Was there a beaver here, too?*

*This is either a really bad day, or the weirdest dream you’ve had in a while. Either way, the only way out is through that door.*

*You approach the screen…*

It would appear that the beaver and the moose are in cahoots and on the loose. They’ve trapped you in their former enclosure. To keep you trapped, they have rigged a series of six locked doors, each of which requires a password to open.

To escape your zoo enclosure, you’ll need to make it through these six doors. Each door is part of one big program, and each door is opened by entering a line of text that we'll call a passcode. If you type the correct passcode, then the door opens and you may move on to the next door. Otherwise, the doors all lock, their terminal screens display a taunting message, the alarms sound, and you’re back at square one. You can fully escape the zoo only by opening every door.

## STEP 1: ACCESS THE DOOR-CONTROL SYSTEM
You can access the zoo's security terminal (i.e., obtain your program to open the doors) by filling out the form at [http://cs208.mathcs.carleton.edu:55057/](http://cs208.mathcs.carleton.edu:55057/).

You will need to be on campus or connected to the [Carleton VPN](https://stolafcarleton.teamdynamix.com/TDClient/2092/Carleton/KB/ArticleDet?ID=137157) to access this page. Once you have filled out and submitted the form, the server will build your executable and return it to your browser in a file named `zooN.tar`, where `N` is the unique ID of your zoo enclosure. (Note: **your zoo program will be different from every other student's zoo program**, though they will have similar structures.)

Upload `zooN.tar` to your account on mantis using whatever file transfer technique you prefer. This could be drag-and-drop onto VS Code when you’re logged into mantis. If you are a dedicated command-line user, you could use `scp` ("secure copy"), like so:

```bash
scp zooN.tar YOURUSERNAME@mantis.mathcs.carleton.edu:/Accounts/YOURUSERNAME/wherever
```

where `wherever` is the path to whatever directory you want to store the file in. 

Put `zooN.tar` wherever you want to work with it, and then un-tar it in the usual way:

```bash
tar xvf zooN.tar
(x: extract, v: verbose, f: filename)
```

This will create a directory called `zooN` with the following files:

* `README`: Identifies the moose enclosure and its occupant (that's you).
* `zoo`: The executable program controlling the doors to your zoo enclosure. It will automatically submit your progress to a scorekeeping server. Note that you can run this program on any Linux computer on the Carleton network (including connections via the Carleton VPN), but it's probably best to do your work on mantis.
* `zoo-quiet`: An offline version of the executable door program. You can work on this one without an internet connection. You just need to run zoo once while connected to have your progress recorded.
* `zoo.c`: The source file with the door's terminal screen's main function and welcome message.
* `descriptions.txt`: The file in which you should briefly explain the functionality of each door you open, and how you opened it. (See below for further discussion of this file.)
* `passcodes.txt`: The file in which you record your door-opening inputs, one line per door puzzle.

If for some reason you request multiple zoo programs from the web form, this is not a problem. Choose one to work on and delete the rest.

**IMPORTANT NOTE**: For many of you, the `zoo` and `zoo-quiet` files will not be marked as executable in their Unix permissions. This will prevent `gdb` from being able to run or debug them. To fix this problem, `cd` into your zoo directory and execute this command:

```bash
chmod +x zoo zoo-quiet
```

## STEP 2: THE GREAT ESCAPE!
Your job for this assignment is to escape the zoo. What this means in practice is that you will accumulate a sequence of input strings, one per door, that open each door.

For each string you discover, put it in your `passcodes.txt` file. If you open all six doors, `passcodes.txt` should have six non-blank lines (note that the zoo program ignores blank lines, so you may space out your passcode strings if you wish.)

You can use many tools to help you unlock all the doors. See the [Suggestions](#suggestions-and-hints) section below for details.

## STEP 3: WRITE YOUR DESCRIPTIONS
See the [Assessment](#assessment) section above for a description of descriptions. As noted there, you're looking for a short description of "what is this code doing".

Put your descriptions in `descriptions.txt` **along with your zoo number**.

## STEP 4: SUBMIT YOUR WORK
* While connected to the Carleton network, run your zoo program and unlock as many doors as you can. This will cause your successful escape progress to get logged on the grading server. You can check to make sure your opened doors got logged properly by going to [http://cs208.mathcs.carleton.edu:55057/progress](http://cs208.mathcs.carleton.edu:55057/progress).
* NOTE: your `zoo-quiet` program will not report your progress, so you eventually need to submit your solutions via `zoo`, at least once.
* Submit `descriptions.txt` and `passcodes.txt` to Gradescope (one submission per partnership please! Though you can resubmit as much as you want). **Make sure to include your zoo number in your descriptions document.**

## SUGGESTIONS AND HINTS
* If you run your zoo program with a command line argument, like:

    ```bash
    ./zoo passcodes.txt
    ```

    the program will read the input lines from `passcodes.txt` until it reaches EOF (end of file), and then switch over to reading from the command line. The beaver seems to have added this as a debugging feature when prepping the doors, but forgot to remove it. Either way, you can use it to avoid retyping the solutions to doors you have already opened.

* The `zoo` program ignores blank input lines, both from the keyboard and from the input file. This means that you can space your `passcodes.txt` lines out if you want to. But note that the order of the `passcodes.txt` lines needs to correspond to the order of the door puzzles.
* You have to open the doors in order.
* To avoid accidentally re-locking all doors, you will need to learn how to single-step through the assembly code and how to set breakpoints. You will also need to learn how to inspect both the registers and the memory states. One of the nice side-effects of doing this assignment is that you will get very good at using a debugger. This is a crucial skill that will pay big dividends dealing with buggy software in the future.
* If you don't want to have the server record all your incomplete attempts to make sense of the program, you can debug the `zoo-quiet` program instead of `zoo`. You just need to make sure that eventually, you run `zoo` once while connected to the Carleton network (e.g., on mantis) so your progress gets logged.
* You may assume that functions do what their names imply. For example, `phase1()` is most likely the first phase, `printf()` is just `printf()`, and a function named `strings_not_equal()` probably takes two strings and returns whether they are not equal. If there is a function that looks like it might trigger the alarm, it would probably help to set a breakpoint there!
* Most cryptic function calls you'll see (e.g. `callq ... <_exit@plt>`) are calls to C library functions. (You can safely ignore the @plt as that refers to *dynamic linking* (whatever that is).)
* Most phases use the C library function `sscanf` to parse the input string, so you will want to understand [how this function works](https://cplusplus.com/reference/cstdio/sscanf/).
* Avoid going through the assembly for C library functions—reading the documentation and writing your own small experimental C programs will be a much easier path to understanding them!

## TOOLS YOU CAN USE
There are many tools designed to help you figure out how programs work and what is wrong when they don't work. Here are some tools you may find useful while analyzing your door puzzles.

* `gdb`: the GNU debugger

    This is a command-line debugger tool available on virtually every platform. You can trace through a program line by line, examine memory and registers, look at both the source code and assembly code (which will be important, since I am not giving you the source code for most of your `zoo` program), set breakpoints, set memory watch points, and write scripts.

    * The [GDB section](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/resources.html#gdb) on the Resources page has lots of good stuff, especially [gdb help](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/gdb-help.html)
    * Here's a [good tutorial on gdb](http://beej.us/guide/bggdb/).
    * Here's a [handy quick reference sheet](http://csapp.cs.cmu.edu/3e/docs/gdbnotes-x86-64.txt).
    * To keep the zoo program from triggering the alarm every time you provide a wrong input, you'll want to learn how to set breakpoints.
    * For documentation, type `help` at the `(gdb)` command prompt.


* `objdump -t`

    This will print out the zoo program's symbol table. The symbol table includes the names of all functions and global variables in the program, the names of all the functions called, and their addresses. You may learn something by looking at the function names!

* `objdump -d`

    Use this to disassemble all of the code in the `zoo` program. You can also just look at individual functions. Reading the assembly code can tell you how the `zoo` program works. Although `objdump -d` gives you a lot of information, it doesn’t tell you the whole story. Calls to system-level functions are displayed in a cryptic form. For example, a call to `sscanf` might appear as:

    ```
    8048c36:  e8 99 fc ff ca  call   80488d4 <_init+0x1a0>
    ```
    To determine that the call was to `sscanf`, you likely need to disassemble within `gdb`.

* `strings`

    This utility will display the printable strings in an executable program, including your zoo program.

HAVE FUN AND GOOD LUCK!