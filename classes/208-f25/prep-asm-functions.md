---
layout: page
title: Assembly Functions Preparation
permalink: /classes/208-f25/asm-functions-prep
---

## Overview
Our final new topic of assembly will be digging deep into how the call stack is managing everything and what that means for functions and recursion!

## Basic Learning Objectives
Before class, you should be able to:
* Explain the significance of `%rsp` and `%rbp`
* Explain what `push` and `pop` do
* Identify how a recursive function is tracked on the call stack

## Advanced Learning Objectives
After class, you should be able to:
* Explain how the call stack will be changed based on `push` and `pop`
* Explain how `%rsp` and `%rbp` manage the call stack


## Resources
Read the following:
* [DIS 7.5 Functions in Assembly](https://diveintosystems.org/book/C7-x86_64/functions.html)
* [DIS 7.6 Recursion](https://diveintosystems.org/book/C7-x86_64/recursion.html)

## Checks
Submit your answer to the following to Moodle.

Given this call stack:

![Diagram of call stack](/classes/208-f25/call_stack.png)

Assuming `%rsp` has a value of `0x110` and `%rdi` has a value of `0x7890`, draw the call stack after the instruction `push %rdi` is executed. Be sure to also indicate the values in `%rsp` and `%rbx` as well.