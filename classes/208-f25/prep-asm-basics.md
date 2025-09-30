---
layout: page
title: Assembly Basics Preparation
permalink: /classes/208-s24/asm-basics-prep
---

## Overview
It's time to dive deeper under the hood and find out about what is between C and binary: assembly!

## Basic Learning Objectives
Before class, you should be able to:
* Explain what registers are
* List the parts of an instruction
* Explain at a high-level how conditional control works in assembly

## Advanced Learning Objectives
After class, you should be able to:
* Explain how registers are used during program execution
* Explain how pointers relate to memory form operands
* Interpret operands with constants, registers, and basic memory lookups

## Resources
Read the following:
* [DIS 7.0 64-bit x86 Assembly](https://diveintosystems.org/book/C7-x86_64/index.html)
* [DIS 7.1 Assembly Basics](https://diveintosystems.org/book/C7-x86_64/basics.html)
* [DIS 7.2 Common Instructions](https://diveintosystems.org/book/C7-x86_64/common.html)
* [DIS 7.4 Conditional Control and Loops](https://diveintosystems.org/book/C7-x86_64/conditional_control_loops.html)

## Checks
Submit answers the following on Moodle.

1. Given the following values in memory and registers:
    ![Layout of registers and memory](/classes/208-f25/memory_values.png)

    Write the value of each of the following:
    * `$0x31B0`
    * `%rsi`
    * `(%rdi)`
    * `0x8(%rdi)`
    * `(%rdi, %rsi)`
    * `(%rdi, %rsi, 2)`

2. Assuming `%rdx` contains `0x32A0` and `%rax` contains `0x8`, what will both registers contain after `addq %rdx %rax`?

3. Assuming `rdx` contains `0x6` and `%rax` contains `0x8`, what will both registers contain after `subq %rdx %rax`?
