---
layout: page
title: Integer Overflow Preparation
permalink: /classes/208-f25/int-overflow-prep
---

## Overview
As you know, integers only have 4 bytes to work with and so you can easily run into issues when you are trying to add together two large integers if you aren't careful. Today, we'll be focusing on how addition is actually carried out at the bit level and what happens when we try to store numbers that are too large for their type.

## Basic Learning Objectives
Before class, you should  be able to:
* Demonstrate binary addition with a carry
* Explain the high-level situation that leads to integer overflow
* Summarize an historical example of an integer overflow bug

## Advanced Learning Objectives
After class, you should be able to:
* Identify when overflow will occur in addition (signed or unsigned)
* Explain the general rules that a system uses to detect overflow


## Resources
You should read the following in DIS: 
* [4.4.1 Addition](https://diveintosystems.org/book/C4-Binary/arithmetic_addition.html)
* [4.5 Overflow](https://diveintosystems.org/book/C4-Binary/overflow.html)


## Checks
Submit answers to the following on Moodle:

Given two 5-bit signed integers in binary: `01010` and `10110`.

1. Does overflow occur? Why or why not?
2. What is the resulting 5-bit value from this addition in decimal?
3. What are the values of the two operands in decimal?