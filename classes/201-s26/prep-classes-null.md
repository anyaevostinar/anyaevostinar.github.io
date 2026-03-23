---
layout: page
title: Classes and Null Preparation
permalink: /classes/201-f25/classes-null-prep
---

## Overview
Now that you’ve learned some basics syntax and semantics in Kotlin, let’s start learning how to write classes in Kotlin, as well as a concept called “null safety”, which may be new to you if you’re coming from Python or Java.

## Basic Learning Objectives
Before class, you should be able to:
* Describe how to write classes in Kotlin
* Describe at a high level the concept of null safety in Kotlin

## Advanced Learning Objectives
After class, you should be able to:
* Write basic classes in Kotlin
* Explain and apply null safety when programming in Kotlin

## Readings
To achieve the pre-class learning objectives, you should read the following sections in the Kotlin tour:

* [Classes](https://kotlinlang.org/docs/kotlin-tour-classes.html)
* [Null safety](https://kotlinlang.org/docs/kotlin-tour-null-safety.html)
* [HW1](hw1) - Read the page, download the starter code and make sure you can compile it (there will be errors in the tests until you complete the assignment)


## Checks
You should submit answers to the following on the Gradescope assignment linked through Moodle. You may upload your answers in one file or different files and the name of the files doesn't matter.
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

