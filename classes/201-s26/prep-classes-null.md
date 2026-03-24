---
layout: page
title: Classes and Null Preparation
permalink: /classes/201-s26/classes-null-prep
---

## Overview
Now that you’ve learned some basics syntax and semantics in Kotlin, let’s start learning how to write classes in Kotlin, why you would even want to, as well as a concept called "null safety", which may be new to you if you’re coming from Python or Java.

## Basic Learning Objectives
Before class, you should be able to:
* Explain the difference between an ADT and a data structure
* Describe how to write classes in Kotlin
* Describe at a high level the concept of null safety in Kotlin

## Advanced Learning Objectives
After class, you should be able to:
* Write basic classes in Kotlin
* Explain and apply null safety when programming in Kotlin

## Readings
To achieve the pre-class learning objectives, you should read the following sections of our textbook (remember to make note of typos!):

* [1.5 Why Study Data Structures and Abstract Data Types?](https://runestone.academy/ns/books/published/kotlinds/introduction_why-study-data-structures-and-abstract-data-types.html?mode=browsing)

* [1.15 OOP in Kotlin: Defining Classes](https://runestone.academy/ns/books/published/kotlinds/introduction_object-oriented-programming-in-java-defining-classes.html?mode=browsing)
* [1.16 Null Safety](https://runestone.academy/ns/books/published/kotlinds/introduction_null-safety.html?mode=browsing)
* Optional reference for string formatting: [1.11 Input and Output](https://runestone.academy/ns/books/published/kotlinds/introduction_input-and-output.html?mode=browsing)


## Checks
You should submit answers to the following on Moodle. You may upload your answers in one file or different files and the name of the files doesn't matter.
1. Fill in the code below for a class that maintains balances for two bank accounts: a checking account, and a savings account. The types should be `Double`, and they should each have a default value of 0.0 for each account if none are specified.

    The output of this program should be:
    ```
    Elephant checking amount = 18.5
    Elephant savings amount = 17.0
    Elephant total = 35.5
    ```
    <iframe src="https://pl.kotl.in/4ffgXyuEj" width="700" height="700"></iframe>

2. Out of the code snippets below, identify which snippet(s) will throw a compiler error.

    ```kotlin
    //Code Snippet A
    var course_number: String = "CS201"
    course_number = null

    //Code Snippet B
    var course_title: String? = "Data Structures"
    course_title = null

    //Code Snippet C
    var course_prof: String? = "Prof. Anya"
    val length = course_prof.length

    //Code Snippet D
    var course_department: String? = "Computer Science"
    val upper_case = course_department?.uppercase()
    ```
3. Did you find any typos or unclear text? List them please!
