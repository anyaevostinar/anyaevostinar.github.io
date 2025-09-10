---
layout: page
title: Kotlin Basics Preparation
permalink: /classes/201-f25/kotlin-basics-prep
---

## Overview
As you now know, there are some core things that every programming language has. You've seen the syntax already during the scavenger hunt, but now it's time to think a bit more deeply about what all the syntax was doing.

## Basic Learning Objectives
Before class, you should be able to explain the following in Kotlin:
* Basic types
* Collections
* Control flow
* Functions

## Advanced Learning Objectives
After class, you should be able to:
* Write Kotlin using basic types, collections, control flow, and functions

## Readings
To achieve the pre-class learning objectives, you should read the following sections in the Kotlin tour:

* [Hello World](https://kotlinlang.org/docs/kotlin-tour-hello-world.html)
* [Basic Types](https://kotlinlang.org/docs/kotlin-tour-basic-types.html)
* [Collections](https://kotlinlang.org/docs/kotlin-tour-collections.html)
* [Control Flow](https://kotlinlang.org/docs/kotlin-tour-control-flow.html)
* [Functions](https://kotlinlang.org/docs/kotlin-tour-functions.html) - Up to but not including Lambda expressions


## Checks
You should submit answers to the following on the Gradescope assignment linked through Moodle (note that you can and should [try typing up and running your answers](https://pl.kotl.in/2YMTJHlUF)). You may upload them in the same file or different files and the name of the files doesn't matter.
* The code below computes a student’s GPA, but some lines are in the wrong order. Put the lines in the correct order. The output of this program should be: 

    ```
    Student’s GPA: 3.65
    ```

    ```kotlin
    fun main() {
    // Number of classes with each letter grade
    val numA = 12
    val numAminus = 14
    val numBplus = 6
    val numB = 4

    // Start of lines in wrong order

    totalGradePoints = totalGradePoints + numBplus * 3.333

    val gpa = String.format("%.2f", totalGradePoints / totalClasses)

    totalGradePoints = totalGradePoints + numB * 3.0

    var totalGradePoints :Double = 0.0

    totalGradePoints = totalGradePoints + numAminus * 3.667

    val totalClasses = numA + numAminus + numBplus + numB

        totalGradePoints = totalGradePoints + numA * 4.0

    // End of lines in wrong order

    println("Student's GPA: ${gpa}")
    }
    ```

* Given a list of letter grades from a student’s transcript, the function `calculateGPA` computes a student’s GPA based on [Carleton’s grading system](https://www.carleton.edu/handbook/academics/?policy=385&a=student), but some parts are missing. Fill in the blanks for the code for the function `calculateGPA`. (`main` is already complete.)  The output of this program should be:
    ```
    Student’s GPA: 3.25
    Student’s GPA: 2.42
    Student’s GPA: 2.17
    ```


    ```kotlin
    fun calculateGPA(grades: Missing collection type) : Missing return type {
        
    var totalGradePoints:Double = 0.0

        //Missing code to iterate over the list
        
        // Missing the conditions for other letter grades
        when(grade){
    "A" -> totalGradePoints += 4.0
    }

    val gpa = String.format("%.2f", totalGradePoints / grades.count())
    
    return gpa
    }


    fun main() {
    println("Student's GPA: ${calculateGPA(listOf("A-", "B+", "C", "A"))}")

    println("Student's GPA: ${calculateGPA(listOf("C-", "B", "D+", "A-"))}")

        println("Student's GPA: ${calculateGPA(listOf("F", "A-", "C+", "B-"))}")

    }
    ```
