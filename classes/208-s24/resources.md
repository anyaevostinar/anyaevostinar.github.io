---
layout: page
title: CS208 Intro to Systems S24 Resources
permalink: /classes/208-s24/resources
---

## Useful all term
* [CS 208 Quick Reference](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/quick-reference.html) (by Aaron Bauer, hosted by Jeff Ondich)
* [CS208 Style Guide](https://cs.carleton.edu/faculty/jondich/courses/cs208_w24/documents/style-guide.html) (by Jeff Ondich)

## Useful commands
Things you'll probably forget and want a reminder for:

* Look at the contents of any file
    ```bash
    hexdump -C filename
    ```
* Compile a C program
    ```bash
    gcc -Wall -Werror -g -o [executable-name] [source-file.c ...]
    ```
    (we will add some other command-line options later in the term).
* Compile a C file to an object module (this produces "source-file.o")
    ```bash
    gcc -Wall -Werror -g -c source-file.c
    ```
* Translate an executable or object module to assembly language
    ```bash
    objdump -d obj-module
    ```