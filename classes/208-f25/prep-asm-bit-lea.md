---
layout: page
title: Assembly LEA Preparation
permalink: /classes/208-f25/asm-lea-prep
---

## Overview
There are a few remaining core assembly instructions that you might encounter. In particular, we will be focusing on the `lea` instruction, which is a funny example of "exaptation" within human-designed systems, since it is generally not used for its original purpose. 

## Basic Learning Objectives
Before class, you should be able to:
* Solve a given `lea` operation

## Advanced Learning Objectives
After class, you should be able to:
* Explain the difference between `mov` and `lea`
* Analyze assembly that has `lea` instructions

## Resources
Read the following:
* [DIS 7.3](https://diveintosystems.org/book/C7-x86_64/arithmetic.html)

This is a good time to also make sure that you have read and absorbed the [previous reading assignment](asm-basics-prep), in case you weren't able to before.

## Checks
Submit answers to the following on Moodle. Suppose register `%rax` contains the constant value `0x5`, register `%rdx` contains the constant value `0x4`, and register `%rcx` contains the value `0x808` (which happens to be an address). What do the following operations do?
* `lea 3(%rcx), %rcx`
* `lea (, %rdx, 2), %rcx`
* `lea -0x2(%rax), %rdx`