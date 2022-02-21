---
layout: page
title: Recursion Lab
permalink: /classes/111-w22/recursion-lab
---

## Logistics
This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do and opening the [reading for today](https://runestone.academy/ns/books/published/thinkcspy/IntroRecursion/toctree.html) for reference.

## Exercise 0
(As always, this is a repeat from the start of class.)
This lab has you try writing many recursive functions.
This is a really tricky concept, and you'll probably need lots of practice to start getting comfortable with it.
[PythonTutor](https://pythontutor.com/) is your friend for understanding what is going on with your functions!

For this exercise, write a **recursive** function called `power(b, n)` that returns `b` raised to the `n`th power. You can assume that they are both non-negative integers. (You should not use Python's `**` functionality for this one.)

If you get stuck, walk through [this solution on PythonTutor](http://pythontutor.com/visualize.html#code=def%20power%28b,%20n%29%3A%0A%20%20%20%20%22%22%22Return%20b%20raised%20to%20the%20power%20of%20n.%22%22%22%0A%20%20%20%20if%20n%20%3D%3D%200%3A%20%20%23%20Base%20case%0A%20%20%20%20%20%20%20%20return%201%0A%20%20%20%20else%3A%20%20%23%20General%20case%0A%20%20%20%20%20%20%20%20return%20b%20*%20power%28b,%20n-1%29%0A%0A%0Aprint%28power%28b%3D3,%20n%3D3%29%29&cumulative=false&heapPrimitives=nevernest&mode=edit&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false).

## Exercise 1
Write a **recursive** function called `getMin(lst)` that returns the minimum element from a given list of integers.

## Exercise 2
Write a recursive function called `fib(n)` that returns the `n`th Fibonacci number. For the record, the first and second Fibonacci numbers are defined to be `0` and `1`, respectively. 
After that, the `n`th Fibonacci number is defined as the sum of the two Fibonacci numbers that precede it. For example, the sequence begins `0 1 1 2 3 5 8 13`...

## Exercise 3
Write a recursive function called `countVal(val, lst)` that returns a count representing the number of times that the value `val` is present in the list `lst`.

## Exercise 4
Write a recursive function called `countdown(n)` that takes a positive integer `n` and prints out each value from `n` to 0, decreasing by 1 at each step, printing each value on its own line. (Note: this function asks you to print values, not return them. What, if anything, needs to be returned in that case?)

## Exercise 5
Write a recursive function called `countup(n)` that takes a positive integer `n` and prints out each value from 0 to `n`, increasing by 1 at each step, printing each value on its own line.

## Exercise 6
Write a modified version of the recursive Fibonacci function from Problem 3 above, and call it `countFib(n)`. This function should return a list with two items (or a tuple if you prefer) containing a) the `n`th Fibonacci number and b) the number of times `countFib()` is called. The easiest approach will be to modify the `fib(n)` from above.

## Exercise 7
Write a recursive function called `mod(a, b)` that computes the remainder we get when we divide `a` by `b`. This is precisely what the `%` operator does in Python, but your function should instead use recursion to compute this remainder.
