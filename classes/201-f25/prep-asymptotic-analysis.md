---
layout: page
title: Asymptotic Analysis Preparation
permalink: /classes/201-s24/analysis-prep
---

## Overview
There are many ways to compare programs that solve the same problem, but computer scientists are usually most interested in the speed with which the program can solve the problem. Asymptotic analysis, also called Big-O analysis, is the main way that we analyze the speed of a program. Today we'll review/dive deeper into this form of analysis.

## Basic Learning Objectives
Before class, you should be able to: 
* Explain what worst-case performance is at a high level
* Identify the Big-O category of a for-loop
* Explain why asymptotic analysis can be better than benchmark testing

## Advanced Learning Objectives
After class, you should be able to:
* Analyze the worst-case time complexity of more complex programs
* Demonstrate the underlying mathematical logic of asymptotic analysis


## Readings
You should read the following. Note that the textbook uses Python instead of Kotlin (we're working on a Kotlin version!), but the ideas are the same:
* [2.2 What is Algorithm Analysis?](https://runestone.academy/ns/books/published/pswadsup/algorithm-analysis_what-is-algorithm-analysis.html?mode=browsing)
* [2.3 Big O Notation](https://runestone.academy/ns/books/published/pswadsup/algorithm-analysis_big-o-notation.html?mode=browsing)
* [2.4 An Anagram Detection Example](https://runestone.academy/ns/books/published/pswadsup/algorithm-analysis_an-anagram-detection-example.html?mode=browsing) - there are a few checks at the end that are good practice

## Checks
Submit your answers to the following on Moodle:

1. What is the time complexity of `calculateGPA` below? Why?

    ```kotlin
    fun calculateGPA() {
        // Number of classes with each letter grade in transcript
        val numA = 12
        val numAminus = 14
        val numBplus = 6
        val numB = 4

        var totalGradePoints:Double = 0.0

        totalGradePoints = totalGradePoints + numA * 4.0
        totalGradePoints = totalGradePoints + numAminus * 3.667
        totalGradePoints = totalGradePoints + numBplus * 3.333
        totalGradePoints = totalGradePoints + numB * 3.0

        val totalClasses = numA + numAminus + numBplus + numB

        val gpa = String.format("%.2f", totalGradePoints / totalClasses)

        println("Student's GPA: $gpa")
    }
    ```

2. Below is a different implementation of `calculateGPA`. What is the time complexity of this implementation of `calculateGPA`? Why?

    ```kotlin
    fun calculateGPA(grades:List<String>): String{
    var totalGradePoints :Double = 0.0
    for (grade in grades) {
            when (grade){
                "A" -> totalGradePoints += 4.0
                "A-" -> totalGradePoints += 3.667
                "B+" -> totalGradePoints += 3.333
                "B" -> totalGradePoints += 3.0
                "B-" -> totalGradePoints += 2.667
                "C+" -> totalGradePoints += 2.333
                "C" -> totalGradePoints += 2.0
                "C-" -> totalGradePoints += 1.667
                "D+" -> totalGradePoints += 1.333
                "D" -> totalGradePoints += 1.0
                "D-" -> totalGradePoints += 0.667
                "F" -> totalGradePoints += 0.0
            }
    }
    val gpa = String.format("%.2f", totalGradePoints/grades.count())
    println("Student's GPA: $gpa")
    }
    ```

