---
layout: page
title: HW5 - Bits and Characters
permalink: /classes/208-s24/hw5
---

* Starter code: [bits-package.tar](bits-package.tar)
* Upload via Gradescope: `bits.c`

## GOALS
* Practice bit operations (`~`, `|`, `&`, `^`, `<<`, `>>`) in C
* Dig into the details of the [UTF-8](https://en.wikipedia.org/wiki/UTF-8) character encoding

## Logistics
This is an **individual** assignment, so you should write all the code individually, though you can get help, as detailed in the [collaboration](collaboration) document.

This assignment is due Wednesday April 17th at 10pm. As with all assignments, you will have the opportunity to [revise](revision-process) this submission based on feedback.

## Assessment
To **demonstrate proficiency**, your submission needs to:
* Pass all the autograded tests on Gradescope
* Follow requirements for each function (especially using only bitwise operations where specified)
* Be somewhat [well-styled](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html)

To **demonstrate mastery**, your submission needs to:
* Demonstrate proficiency
* Be quite [well-styled](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html), particularly well-chosen variable names, avoiding magic numbers, and helper methods/loops to reduce code duplication
* Have thorough error-handling


## YOUR ASSIGNMENT
* Implement the five functions documented in the `bits.h` file in [bits-package.tar](bits-package.tar).
* Put your implementations in `bits.c` (a starter version of which is provided in the package).
* Do not change `bits.h`.
* Submit your file as `bits.c` via Gradescope.

## Tips
* Start with `to_lower`, `to_upper`, and `middle_bits`
* Write out examples on paper or use [CTutor](https://pythontutor.com/c.html#mode=edit) with 'byte-level view of data' selected (dropdown that starts with "none default view" showing)
* Use Jeff's [UTF-8 encoder](https://sandbox.jeffondich.com/encoder/) to check different values
* For the UTF-8 converting functions, start with getting just single byte codepoints to work, then two byte, etc. Worry about cutting down on duplicated code AFTER things are working