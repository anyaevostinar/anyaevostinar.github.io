---
layout: page
title: Stack Lab
permalink: /classes/201-s26/stack-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `StackLab` in your STUWORK/username folder and open it in VSCode for today's labwork.

## Exercise 1

1. Make a file `StackInt.kt` and copy in the [interface from the reading](https://runestone.academy/ns/books/published/kotlinds/basic-ds_the-stack-abstract-data-type.html?mode=browsing). 

2. Make another file `ListStack.kt` and copy in the [`ListStack` from the reading](https://runestone.academy/ns/books/published/kotlinds/basic-ds_implementing-a-stack.html?mode=browsing).

3. Time to use your stack to solve a problem! When you have a math equation such as `(A * B) + (C * D)`, it's only valid if the opening and closing parentheses match up. Some programming languages take this to the extreme, such as Racket (used in CS 251), for example:
    ```racket
    (define (move-pos a-pos a-direction a-speed)
        (define r (degrees->radians a-direction))
            (pos (+ (pos-x a-pos) (* a-speed (cos r)))
            (+ (pos-y a-pos) (* a-speed (sin r)))))
    ```
    Write a function `nestedParentheses` that uses a stack to see if a given string has valid nested parentheses. Here is some test code to make sure your function works:
```kotlin
fun main() {
    println(nestedParentheses("()")) // true
    println(nestedParentheses("(())")) // true
    println(nestedParentheses("(()))")) // false
    println(nestedParentheses("(()()")) // false
    println(nestedParentheses("(()(()))")) // true
    println(nestedParentheses("(A+B)*(C+D)")) // true
}
```

## Exercise 2
Deep under the hood of Kotlin, `MutableList`s are actually built on the `array` data type.  As you read about, they're tricky to work with, because they have a fixed size. You should refer to the [reading for today](https://runestone.academy/ns/books/published/kotlinds/basic-ds_implementing-an-unordered-list-arrays.html?mode=browsing) for how to create a new array with `arrayOfNulls` and generally work with arrays in this exercise.

1. Write a class `ArrayStack` that implements the `StackADT` interface using an `Array<Int?>` as its underlying data storage. Note that you can define your class to work only with `Int`s like so:
```kotlin
class ArrayStack : StackADT<Int> {

    //Your code here
}
```
Also, you may run into some difficulties with needing to return an `Int` when the array contains `Int?`. You can deal with that with either `!!` or `?:` in your return.

2. Here is a `main` function you should use to test your code:
```kotlin
fun main() {
    val s = ArrayStack()
    s.push(2025)
    s.push(4)
    s.push(16)

    println("Elements present in stack: ")
    println(s)

    println("" + s.pop() + " popped from stack")
    println("Top element is: " + s.peek())

    println("Elements present in stack: ")
    println(s)
}
```

Submit your solutions for these two exercises on Moodle for an extra engagement credit. Remember that labs are open until the end of the term, so don't stress about completing it, but it is good practice.



## Extra
If you have extra time, take the balanced parentheses a step further by generalizing it!
We can say that a sequence of operations (for example, lock/unlock requests) is "properly nested" if we complete requests in the reverse order that we start them.  For example, the following are properly nested sequences (assuming the first occurrence of a letter marks the start and the second marks the end for that pair):
* AA
* ABBA
* ABCCBA
* ABBCCA

However, the following are not properly nested sequences:
* ABAB
* ABCACB

How could you use a stack to determine whether a given input string is properly nested?  Try to write some code to solve this!