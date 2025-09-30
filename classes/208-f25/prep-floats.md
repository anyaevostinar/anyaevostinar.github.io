---
layout: page
title: Floats Preparation
permalink: /classes/208-f25/floats-prep
---

## Overview
You probably noticed that we've been very focused on integers and have been ignoring the idea of "floating point" or "real" numbers, such as 3.3333 or 1/6. That's because they are really hard to work with! Today, we'll just scratch the surface regarding their representation.

## Basic Learning Objectives
Before class, you should  be able to:
* Explain the issue with representing real numbers in binary
* Describe the high-level idea of floating-point representation
* Summarize a historical example of a rounding error


## Advanced Learning Objectives
After class, you should be able to:
* Identify the parts of a floating-point binary sequence
* Convert between floating point and binary


## Resources
You should read the following in DIS: 
* [4.8 Real Numbers in Binary](https://diveintosystems.org/book/C4-Binary/floating_point.html)


## Checks
Submit answers to the following on Moodle.

1. Given the hexadecimal number `0x40533333`, identify the sign, exponent, and mantissa/significand for these bits. Give your answer in hex or binary and indicate which it is.

2. Convert that hexadecimal number `0x40533333` to decimal based on the IEEE standard 754.

3. You can get additional practice with [this calculator](https://www.h-schmidt.net/FloatConverter/IEEE754.html) (and check your work, but I recommend doing it by hand first!)