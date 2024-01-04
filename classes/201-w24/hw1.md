---
layout: page
title: Homework 1 - OOP Practice
permalink: /classes/201-w24/hw1-oop-practice
---

## Logistics
This is an individual assignment, so you should complete it on your own, though you are able to get help from many sources as detailed in the [collaboration](collaboration) policy.

This assignment is due on Friday January 12th at 10pm. As with all assignments, you will have the opportunity to revise this assignment based on the feedback that you get.

## Goals
Demonstrate your understanding of private variables, ability to create objects of your own making, and use other Java functionality.

## Setup
I recommend that you complete this assignment in Olin 310.

* [Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=Fall+2022%3A+CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. If you don’t do this, everything you write will disappear when you log out!!!!
* Create a folder for `HW1` in STUWORK 
* Open VSCode, and click and drag your `HW1` folder into VSCode 
* Now click `Terminal`->`New Terminal` or drag up from the bottom to get a Terminal. This is where you will be able to compile and run your Java program.
* Create a file `Collaborations.txt` and put in any help that you get on this assignment including sources that you reference and help from lab assistants or the prefect. Make sure to refer to the [Collaboration page](collaboration) on what collaborations are allowed for homework assignments.

If you really want to use your personal machine, there are instructions for installing VSCode and Java available: [Mac](https://stolafcarleton.teamdynamix.com/TDClient/3356/Portal/KB/ArticleDet?ID=153179) and [Windows](https://stolafcarleton.teamdynamix.com/TDClient/3356/Portal/KB/ArticleDet?ID=153191). You can also [remotely connect to COURSES](https://stolafcarleton.teamdynamix.com/TDClient/2092/Carleton/KB/ArticleDet?ID=148546). If you run into trouble with these setups, you can ask me or Mike Tie for help, but I do really recommend just working in Olin 310.

## Specification
For this project, you will make a simple `Book` class with the following functionality:
* Constructor that takes a `String` for the title of the book and an `Integer` for the page count and sets them to private instance variables
* `getTitle` method that returns the title of the book
* `getPageCount` method that returns the page count
* `main` method that:
    * Retrieves a command-line argument indicating how many books the user wants to enter into the program
    * Repeatedly prompts `Title?` and then `Page count?` so the user can enter in the information for each book
    * Outputs `Here are your X books!` where X is the number of books the user entered
    * Outputs a comma-separated list of the book titles
    * Outputs `Total pages: Y` where Y is the total number of pages


Here is an example interaction with this program:
```bash
% java Book 3    
Title?
test
Page count?
10
Title?
test3
Page count?
100
Title?
test4
Page count?
10
Here are your 3 books!
test, test3, test4
Total pages: 120
```

Additionally, your submission should:
* Be well-styled, considering consistency and readability 
* Have JavaDocs-style method comments for all public methods
* Have a detailed `README.md` file as specified below

### README Requirements
Writing good and detailed documentation for your code is an important skill, so important that [whole communities](https://www.writethedocs.org/) exist in industry that are focused on good documentation. 
One part of good documentation is the JavaDocs method comments that you'll already be doing. 
However, another part is a ```README``` that is generally the first thing that people look at when they look into your project.
If you are planning on applying for internships or full-time jobs in the computer science industry, a [GitHub](https://github.com/) account with projects with good READMEs is a really helpful part of your application. 
READMEs are generally written in a language called [MarkDown](https://www.markdownguide.org/), which is fairly straightforward to get the hang of and you can keep yours very simple.

In general (and so therefore for all homework in this class), a README should include:

* An overview section that describes at a high level what your program does, for someone that just found it randomly
* A small example of your code running and showing its main functionality

For this class in particular, your README must also include answers to any README prompts, which will often ask you to include discussion of the pros and cons of a certain data structure or implementation choice. 

I have an [example README](readme_example) that you can look at for a project that is a bit more involved. 

### README Prompts
For this project, there is not any additional prompt.

## Code Notes and Tips
* Command line arguments are what is captured in `args` in your `main(String[] args)` function, NOT just user input after the program is running!
* Remember that you have to construct variables before you use them. If you run into null pointer exceptions or exceptions about not using a variable before it has been initialized, one possible cause is that you have declared a variable (e.g., `List<Integer> list;`) but you haven't assigned it a value (e.g. `list = new ArrayList<>()`).
* Your code should not produce any warnings. Warnings are extra messages from the compiler like:
      ```
      Note: RandomList.java uses unchecked or unsafe operations.
      Note: Recompile with -Xlint:unchecked for details.
      ```
      
If you see a message like this, you should follow the instructions and add `-Xlint:unchecked` after your compiler command.

* If you want to turn a command line argument into something other than a String, you need to use a method to do so. You will probably want either `parseInt(String in)` or `parseDouble(String in)`:
```
    int myInt = Integer.parseInt("1");
    double myDouble = Double.parseDouble("1.0");
```
(Add this to your reference sheet!)

* Throughout the course you’ll be required to include informative comments above each method in “JavaDocs” style. This style allows for a website to be generated with those comments nicely formatted and looking like the Java documentation that you’ll become quite familiar with.

    JavaDocs style is the following:

    ```java
    /**
    * Generally descriptive few sentences about the method.
    * @param nameOfParameter description of the parameter if useful, probably should mention the type
    * @param anotherParameter if you have multiple parameters
    * @return description of what if anything is returned, should definitely mention the type
    */
    public int exampleMethod(int nameOfParameter, int anotherParameter){
    return 0;
    }
    ```


## Assessment

To **demonstrate proficiency**, your program needs to:
* Pass all tests on Gradescope
* Follow the specification of the `Book` class
* Use the `Book` class effectively
* Have a README with an overview and example
* Have JavaDocs documentation for all public methods
* Be somewhat well-styled

To **demonstrate mastery**, your program needs to:
* Demonstrate proficiency
* Use private variables correctly
* Use programming elements such as loops, conditionals, and lists effectively
* Be extremely well-styled and clear by choosing descriptive variable names and including useful comments 
* Have a thorough and well-styled README
* Have clear and thorough documentation

## Submitting
Remember to update your `Collaborations.txt` file with any sources that you consulted.

Then upload all of your files to the Gradescope link on Moodle, at which point the autograder will run and let you know if your code works correctly. You are able to submit your code as many times as you wish before the deadline to fix any issues. If you have questions about what the autograder is telling you is wrong, please ask!