---
layout: page
title: Inheritance and Interfaces
permalink: /classes/201-f25/inheritance-prep
---

## Overview
Kotlin is an example of an '**o**bject-**o**riented **p**rogramming' language. You've used some objects before, but Kotlin forces you to really get into objects. Today, we'll focus on the concepts core to "OOP", which you'll use heavily in Kotlin but apply across lots of other programming languages.

## Basic Learning Objectives
Before class, you should be able to: 
* Describe at a high level how classes can "inherit" code from another class
* Describe the difference between an interface and a class


## Advanced Learning Objectives
After class, you should be able to:
* Create a subclass
* Implement an interface
* Explain how instance variables work with inheritance


## Readings
You should read the following:
* [Constructors](https://www.programiz.com/kotlin-programming/constructors)
* [Inheritance](https://www.geeksforgeeks.org/kotlin/kotlin-inheritance/)
* [Interfaces](https://www.geeksforgeeks.org/kotlin/kotlin-interfaces/)


## Checks
You should submit answers to the following on the Gradescope assignment linked through Moodle. You may upload your answers in one file or different files and the name of the files doesn't matter.

1. Given the base class `Person`, complete the derived class `Student` below.

    `Student` should have the following properties:
    * `classYear`: Student’s anticipated graduation year
    * `major1`: Student’s first major.
    * `major2`: Student’s second major, if applicable.
    * `minor`: A list of a student’s minors (because apparently, there isn’t a limit to the number of minors at Carleton...)

    `Student` should have one member function `declareMajor` that:
    * sets `major1` to the declared major if the student’s first major is "Undeclared"
    * sets `major2` to the declared major if the student already has a first major but the student’s second major is "Undeclared"
    * prints "You have too many majors! Talk to your advisor." if the student already two majors

    <iframe src="https://pl.kotl.in/DqPuYDMuU" width="700" height="700"></iframe>

2. Given the interface `RegistrarRecord`, implement the member function `printCourses` for `StudentRecord` and `ProfessorRecord`. 
    * Both `StudentRecord` and `ProfessorRecord` should have the same property `courses`, which is a list of courses.
    * However,  `printCourses` for `StudentRecord` first prints "I’m currently *taking* these courses:", followed by the list of courses, while `printCourses` for `ProfessorRecord` first prints "I’m currently *teaching* these courses:" followed by the list of courses instead.

    <iframe src="https://pl.kotl.in/zQEfeFjWe" width="700" height="700"></iframe>