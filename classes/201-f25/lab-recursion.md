---
layout: page
title: Recursion Lab
permalink: /classes/201-f25/recursion-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `ClassesLab` in your STUWORK/username folder and open it in VSCode for today's labwork.

## Exercise 1
Identify the base case, recursive call, and how you know the function works towards the base case for the following recursive functions:

```kotlin
// Computes a*b by adding b to itself a times.
fun mult(a: Int, b: Int): Int {
    if (a == 0) {
        return 0
    }

    return b + mult(a-1, b)
}

// Computes n! = n * (n-1) * (n-2) * ... * 1.
fun fact(n: Int): Int {
    if (n == 1) {
        return 1
    }

    return n * fact(n-1)
}
```

## Exercise 2
Download [recursionLab.kt](recursionLab.kt) and move it to your folder for today's work.

a) Implement `findMax` recursively and compile and run your code to see if it works:

```bash
kotlinc recursionLab.kt
kotlin RecursionLabKt.class
```
b) Afterwards, identify the base case, recursive call, and how you know it works towards the base case. Write down your explanation in a comment


## Exercise 3
a) Implement `sumList` recursively, uncomment its tests, and see if it works.

b) Afterwards, identify the base case, recursive call, and how you know it works towards the base case. Write down your explanation in a comment


## Exercise 4
a) Write a recursive method that performs exponentiation: it should return a<sup>b</sup> for input parameters `a` and `b`, which are both positive integers. You should not use built-in exponentiation and are limited to only using multiplication.

b) Afterwards, identify the base case, recursive call, and how you know it works towards the base case. Write down your explanation in a comment


## Exercise 5
Write a **recursive** function called `countdown(n)` that takes a positive integer `n` and prints out each value from `n` to 0, decreasing by 1 at each step, printing each value on its own line. (Note: this function asks you to print values, not return them. What, if anything, needs to be returned in that case?)

## Exercise 6
Write a recursive function called `fib(n)` that returns the `n`th Fibonacci number. For the record, the first and second Fibonacci numbers are defined to be `0` and `1`, respectively. 
After that, the `n`th Fibonacci number is defined as the sum of the two Fibonacci numbers that precede it. For example, the sequence begins `0 1 1 2 3 5 8 13`...

## Exercise 7
Write a recursive function called `countVal(val, lst)` that returns a count representing the number of times that the value `val` is present in the list `lst`.

## Exercise 8
Write a recursive function called `countup(n)` that takes a positive integer `n` and prints out each value from 0 to `n`, increasing by 1 at each step, printing each value on its own line.

## Exercise 9
Write a recursive function called `getMin(lst)` that returns the minimum element from a given list of integers.

## Exercise 10
Write a modified version of the recursive Fibonacci function from Problem 2 above, and call it `countFib(n)`. This function should return a list with two items (or a tuple if you prefer) containing a) the `n`th Fibonacci number and b) the number of times `countFib()` is called. The easiest approach will be to modify the `fib(n)` from above.

## Exercise 11
Write a recursive function called `mod(a, b)` that computes the remainder we get when we divide `a` by `b`. This is precisely what the `%` operator does, but your function should instead use recursion to compute this remainder.

## Exercise 12
For this exercise, write a **recursive** function called `power(b, n)` that returns `b` raised to the `n`th power. You can assume that they are both non-negative integers. (You should not use the built-in `**` functionality for this one.)


Submit the completed file `recursionLab.kt` to Moodle for an extra engagement credit.

## Extra
Write a recursive that will generate all the anagrams (rearrangements of the letters) of a string. For example, all the anagrams of the string `abca` are `['abca', 'abac', 'acba', 'acab', 'aabc', 'aacb', 'baca', 'baac', 'bcaa', 'bcaa', 'baca', 'baac', 'caba', 'caab', 'cbaa', 'cbaa', 'caba', 'caab', 'abca', 'abac', 'acba', 'acab', 'aabc', 'aacb']`.

This is a tricky problem! I recommend you take the following approach:

1. What is your base case? What string has the simplest list of anagrams?
2. If the string is longer than your base case:
    a. For each character in that string:
        i. Create a copy of the string with the character removed (you can do this with `string.replace(letter, "", 1)` to replace `letter` with the empty string one time)
        ii. Generate all the anagrams of the remaining letters with a recursive call
        iii. For each of those generated anagrams, attach the removed character to the front of the anagram
