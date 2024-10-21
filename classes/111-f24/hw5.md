---
layout: page
title: HW5 
permalink: /classes/111-f24/hw5
---

## Logistics
This is a paired assignment, so you should complete it with your assigned partner (same one as from HW4), if you have one, via **paired programming**. 
The whole time that you are working, you should both be present and actively working on the problem at hand. 
(Two brains, one keyboard.) 
Switch off the typing duties so that you each type for roughly half of the time. 

You are able to get help from many sources as detailed in the [collaboration](collaboration) policy.
This assignment is due on Wednesday Oct 23rd at 10pm. 
As with all assignments, you will have the opportunity to *individually* [revise](revision-process) this assignment based on the feedback that you get.

## Goals
Get practice with indefinite loops, functions, and command-line arguments.

## Assessment
To **demonstrate proficiency**, your program needs to pass all the tests on Gradescope, which test:
* Correct functionality
* Header with three lines that start with `#`
* Contain docstrings for each function (checked automatically)
* Other basic style that can be checked automatically

To **demonstrate mastery**, your program needs to demonstrate proficiency as well as having:
* *Descriptive* header (and removal of non-useful starter content)
* *Descriptive* docstrings for each function
* Useful comments (and removal of non-useful starter comments)
* Descriptive variable names that follow `snake_case`
* Good line grouping and spacing
* Use iteration, conditionals, and functions to organize your programs and prevent any unnecessary duplication of code
    * In particular, try to get down to just one `while` loop

## Setup
Again, I recommend that you complete this assignment in Olin 310, though it isn't required to do so.

[Mount the COURSES drive](getting-started) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HW5`
* Open your `HW5` folder in VSCode
* Download the starter code that is linked on Moodle and place it in your folder

This program uses command-line parameters as input to the program. 
Remember, those are things typed at the prompt. 
Clicking the run button won’t work for this program (which is why hopefully you haven't been using it this whole time anyway). 
If you've forgotten how to run in the Terminal, open a terminal window (in VSCode: Terminal -> New Terminal, or ask the lab assistant if you’re having trouble). 
Then type something like `python3 name_of_program.py argument1 argument1`.

## Caesar

### Overview

One crucially important application of computer science to day-to-day life — with billions of dollars at stake
every day — is in the area of digital security. 
When you log on to your bank’s website, pay your cell phone bill online, or log on to The Hub, you are typing secure information that you would like to (1) be readable to the
trusted party on the other end of the line, and (2) not be readable to anyone else. 
Cryptography is the broad area of computer science that attempts to design algorithms and build systems for these operations. 
If you decide to take CS 202 (Mathematics of Computer Science), CS 231 (Computer and Network Security), or CS 341 (Cryptography), you’ll learn more about some of the cryptographic systems that are actually in use today; here, you’ll explore a simpler approach that reaches all the way back to Julius Caesar.

Here is the idea of what is called the *Caesar cipher*. 
To encrypt a message written in English, you will take each letter that appears in the message and shift it forward alphabetically by some predetermined number of letters. 
For example, the “plaintext” `We are discovered; flee at once!` shifted forward by one letter becomes the “ciphertext” `Xf bsf ejtdpwfsfe; gmff bu podf!` because `X` is alphabetically one letter after `W`, `f` is alphabetically one letter after `e`, etc. 
(Notice that if you were to shift, say, `w` by five, you’d end up with `b`: `b` is after `a` is after `z` is after `y` is after `x` is after `w`.) 
Once your colleague receives the ciphertext `Xf bsf ejtdpwfsfe; gmff bu podf!`, they can decode it by shifting each of the letters backwards by one letter in the alphabet, and they will immediately know to head to the safe house that you’ve set up in Hoboken.

### Your Task
First, read through the provided starter code for `caesar.py`. 
Your task will be to complete this program.
Note that command-line arguments that are strings need to be in single quotes, for example:
```bash
python3 caesar.py 'We are discovered; flee at once!' 3
```
(Depending on your computer setup, you may experience trouble if you use double quotes at the terminal and put an exclamation point inside. So, if weird things are happening, be sure you’re using `'We are discovered; flee at once!'` instead of `"We are discovered; flee at once!"` .)

Next, work on the function `caesar`. 
Right now, it goes through each character of plaintext and, one by one, adds that character to the end of ciphertext. 
The function then returns that computed ciphertext. 
Modify the function `caesar` so that it instead returns a string that matches plaintext, except that every letter is shifted `shift` letters forward in the alphabet (wrapping around to the beginning of the alphabet as necessary). 
You should leave all non-alphabetic characters unchanged, and you should maintain the capitalization of all letters. 
Make the changes to the function `caesar` so that it constructs ciphertext, again one character at a time, to use this new specification.

Here are some examples of how the function should work:
```bash
>>> caesar("This is the way the world ends, dontcha know?", 0)
’This is the way the world ends, dontcha know?’
>>> caesar("This is the way the world ends, dontcha know?", 1)
’Uijt jt uif xbz uif xpsme foet, epoudib lopx?’
>>> caesar("This is the way the world ends, dontcha know?", 25)
’Sghr hr sgd vzx sgd vnqkc dmcr, cnmsbgz jmnv?’
>>> caesar("This is the way the world ends, dontcha know?", 26)
’This is the way the world ends, dontcha know?’
```

Here are a few hints. 
The easier situation to handle is the one in which there’s no “wrapping around” the alphabet: that is, when you don’t have to go from `z` to `a`. 
Start by getting your code working when there are no shifts. You might consider the following general outline of code:
```
if we have a lower-case letter,
    add the offset
    while the resulting character isn’t in "a" ... "z",
    subtract 26
if we have an upper-case letter,
    do the analogous thing
otherwise,
    do nothing
```

The `ord()` function converts characters into their ASCII value (e.g., `ord("a")` will return 97, `ord("z")` will return 122). 
The `chr()` function goes in the opposite direction, converting an ASCII value to a string (e.g., `chr(97)` returns "a", `chr(122)` returns "z").
<details>
<summary><strong>Click here to view a character to ASCII reference table</strong></summary>
<p>
<img src="/classes/111-f24/ASCIIChart.png">  
</p>
</details>


Note that the outline above has a bit of duplication, in particular two while loops that look very similar. See if you can make a small function that reduces that duplication of code.

Finally, you should add error-checking code to the main function. 
What happens if the user enters a non-integer as the shift? Make your program robust, so that it doesn’t crash regardless of what the user tries to enter as the number of letters by which to shift and informs the user of the problem with the following message:
```bash
$ python3 caesar.py "hi" a
Invalid argument, shift must be a number, given a.
```

### Cleaning up
You should remember to go and clean up the file once you've finished. In particular you should:
* Update the header to include your name(s)
* Remove/rewrite the comments that described what you needed to do in the file if you haven't already

## Submission
You should submit your file through the Gradescope link on Moodle for this assignment (just one partner needs to submit!).
You are able to submit your code as many times as you wish before the deadline to fix any issues (and you should do so).
If you have questions about what the autograder is telling you is wrong, please ask!

If you have a partner for this assignment, you can indicate who they are via Gradescope, so be sure to set that up correctly and then between the two of you, you should only need to submit once.