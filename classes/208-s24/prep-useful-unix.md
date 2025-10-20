---
layout: page
title: Useful Unix Preparation
permalink: /classes/208-f25/useful-unix-prep
---

## Overview
You have probably picked up quite a few commands that you write at the Terminal, such as `cd` and hopefully you have some what of an understanding of how file systems are organized. In a week or two, we'll be thinking about how the Terminal program actually works, so in preparation for that, let's solidify some of those random commands that you have memorized in your CS journey so far.

## Basic Learning Objectives
Before class, you should be able to:
* Identify the relative and absolute path to a file
* Define `stdin`, `stdout`, and `stderr`
* Predict what various redirects and pipes will do

## Advanced Learning Objectives
After class, you should be able to:
* Explain how file output and input works
* Write unix commands that chain together several pipes for a desired outcome

## Resources
Review the following:
* [DIS 17.1 Unix Command Line and Files](https://diveintosystems.org/book/Appendix2/cmdln_basics.html)
* [DIS 17.12 I/O Redirection](https://diveintosystems.org/book/Appendix2/ioredirect.html)
* [DIS 17.13 Pipes](https://diveintosystems.org/book/Appendix2/pipe.html)

Feel free to look through other sections of 17 that catch your interest as you have time. Things that might be interesting to learn more about: remote access, make, file permissions, etc. This is a great resource for learning more about all those commands that you've been learning haphazardly!

## Checks
Submit answers to the following on Moodle.

Given the following directory structure, where filled-in boxes represent directories and open boxes represent files:

![Diagram of files](/classes/208-f25/fs.png)

1. Give an absolute path to the file `f5.csv`, assuming that directory `r` is the only child of `/`.
2. Give a relative path to the file `f5.csv` from the directory `b`.
3. What will the following command do? `./prog < f4.txt > ../e/f5.csv 2> ./e.txt`
