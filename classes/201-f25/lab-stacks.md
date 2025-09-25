---
layout: page
title: Stack Lab
permalink: /classes/201-f25/stack-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `StackLab` in your STUWORK/username folder and open it in VSCode for today's labwork.

## Exercise 1

1. Make a file `StackInt.kt` and copy in the following interface:

    ```kotlin
    interface Stack {
    fun push(item: Int)
    fun pop(): Int?
    fun peek(): Int?
    fun isEmpty(): Boolean
    override fun toString(): String
    }
    ```

2. Make another new file `ListStack.kt` and implement that interface using a `MutableList` as the underlying data store. Here is a `main` function to test your code:

    ```kotlin
    fun main() {
    val s = ListStack()
    s.push(2025)
    s.push(4)
    s.push(16)
    
    println("Elements present in stack: ")
    println(s) //This implicitly calls your toString
    
    println("" + s.pop() + " popped from stack")
    println("Top element is: " + s.peek())

    println("Elements present in stack: ")
    println(s)
    }
    ```

## Exercise 2
Deep under the hood, all lists are actually built on the `array` data type.  They're tricky to work with, though, because they have a fixed size (so you can't make it any bigger -- instead, you have to copy all elements to a new, bigger array).

You can make a new array that holds 10 `Int`s, with all values initially null (signifying that you don't have a valid value in those elements), using the [`arrayOfNulls` function](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/array-of-nulls.html):
```kotlin
    val myarr: Array<Int?> = arrayOfNulls<Int>(10)
```

Once you have an array, you can access/modify elements using square brackets (e.g., `myarr[2]`) and get the number of elements (some of which may be null) with `.count()` (like `myarr.count()`).

Write a class `ArrayStack` that implements this interface using an `Array<Int?>` as its underlying data store.

Here is a `main` function you could use to test your code:
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

Submit your solutions for these two stack implementations on Moodle for an engagement credit.

## Exercise 3
In your implementations, you had to make a decision about where the "top" of the stack was. Reflect on what you think the Big O time complexity of your current implementations is and how the other choice of "top" would change it. Note, you have to make some assumptions about how `MutableList` works and its time complexity, what are those assumptions?

## Extra
We can say that a sequence of operations (for example, lock/unlock requests) is "properly nested" we complete requests in the reverse order that we start them.  For example, the following are properly nested sequences (assuming the first occurrence of a letter marks the start and the second marks the end for that pair):
* AA
* ABBA
* ABCCBA
* ABBCCA

However, the following are not properly nested sequences:
* ABAB
* ABCACB

How could you use a stack to determine whether a given input string is properly nested?  Try to write some code to solve this!