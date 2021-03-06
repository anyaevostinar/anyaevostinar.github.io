---
layout: page
title: More Comparing Python and Java Activity
permalink: /classes/201-f20/comparing_python_java
---

## Goals
To get started understanding the differences between Java and Python and prepare you to start writing your own Java code by studying examples.

## Java Basics
Learning your second programming language is different from learning your first. Assuming your first language isn't one of the many so-called esoteric programming languages or a more specialized language like SQL, you start out already knowing about many of the nearly-universal language constructs: assignments, loops, conditionals, functions, operators, (often) classes, etc. Learning the second language involves a lot of learning new syntax for old ideas, rather than learning both the ideas and the syntax at the same time.

As a result, learning your second language typically goes more quickly than learning the first. That doesn't mean the second one is easy to learn — “easy” starts to happen around the fourth or fifth language — but there are definitely opportunities to learn more efficiently the second time around.

For this class, I will assume that you are making a transition from Python (which we teach in CS 111) to Java (which we will use in CS 201). In fact, I imagine that a few of you met Java in high school, and some of you may even have skipped CS 111 and thus not know Python. If you're one of the latter and you plan to take courses beyond CS 201, you'll eventually want to teach yourself Python, since later classes in the department will assume knowledge of Python; you may find some of these exercises useful for that in a backwards sort of way.

During the first few days of class, we're going to focus our attention on the differences between Python and Java to help get you started in Java. Some key differences include:

* Explicit types (e.g. int, String, ...) are specified for all variables, parameters, return values, etc.
* There's an awkward distinction between “primitive types” (int, short, long, float, double, byte, char, boolean) and "reference types" (everything else).
* Program structure requires the use of classes.
* Braces { } are used instead of indentation to delimit if/else/for/while/etc. bodies (though indentation remains an essential element of good programming style)
* Miscellaneous syntactical differences: semi-colons to terminate instructions, // and /* ... */ for comments, only "..." for string literals, try/catch for exceptions, etc.
* No easy built-in lists [ ] or dictionaries { }

## Language-Learning Strategies
*This list is by Jeff Ondich; he's the “I” in this case. Thanks Jeff!*

One strategy used by many people is to find a good tutorial and work through it from beginning to end. This is a great approach.

My personal language-learning approach is intended to keep my start-up time investment as low as possible, so I can move into serious projects right away. I won't know the whole language, not by a long shot, until I have written thousands of lines of code in various contexts. But my goal is to move from the "just studying" mode into the "doing serious work" mode as fast as I can.

To that end, I start by finding the official reference documentation for the language. Next I find a collection of simple sample programs (search for “name-of-language tutorial” or “name-of-language samples” or “name-of-language examples”). Then, with my browser handy, I study the examples just enough to enable me to write the following programs:

* Hello World: just a program that compiles, runs, and produces output that I can see
* Line Reader: open a text file, read from it one line at a time, and either print out the lines in upper case or just count the lines and print the result
* Word Counter: open a text file, read from it one word at a time with punctuation stripped, keep a count for each word, and print the list of words and their counts sorted from highest to lowest count

Hello World gets me to “I can create, compile, and run a program in this language.”

Line Reader teaches me to open and read from files, which is essential for writing interesting programs in most languages. It also teaches me at least one loop syntax.

Word Counter teaches me loops, conditionals, functions, classes (I intentionally use a simple class to store (word, count) pairs so I will learn the class syntax), and a little bit about formatted strings (to produce a pretty report). After that, I'm ready to get going on serious work.

These days, I can usually write these three programs in under an hour in a new language, with most of the time going into polishing and experimenting with the third program. Of course, I wasn't nearly so speedy when I learned my second language back at the dawn of time.

## Your Task
You'll be continuing your comparison of pairs of programs in Python and Java to try to make sense of Java and relate it to what you already know about Python. 
Like all code-based activities, this activity is available on repl.it; go to our classroom and open the project entitled Comparing Python and Java Programs.
For each of the Python/Java program pairs in the project, read the programs, run the programs (both Python and Java!), and write down questions you have about the Java code. Remember that to run the Java programs, you need to compile them first: `javac Hello.java`. Then you can run the compiled class: `java Hello`. The Python programs are written for Python 3 (e.g., to run hello.py, type `python3 hello.py` on the command line). Many of the programs have suggestions for things to try in the comments - use them as a starting point for your exploration.

When you're done, submit your questions to the Moodle assignment More Comparing Python and Java. You need to submit a minimum of three questions to receive full credit. Then check on Piazza to see if anyone else has posted your questions. If no one has, post them each in their own question. Also see if there are any unanswered questions that you can answer! If someone did already post your question, check to see what the answer is.

You may use the questions that your group came up with in class, but you must credit your group members! I suspect you'll be able to come up with more questions though.

Take this exercise seriously. Figure out what you know, what you don't know, what's easy, what's confusing, etc. If you pay careful attention to these starter programs and I can get you quick turn-around on your main questions, you'll have a great start on writing your own Java programs. You may find it helpful to do this exercise in conjunction with looking at the Java Reference Information on Moodle. This reference information may be able to help you answer some of your or your classmates' questions, and looking at the examples in this homework may help you recognize what parts of that reference information you already know and what you should pay closer attention to.

## Parting Notes
This activity is graded entirely on effort. The absolute baseline is that you submit three questions on Moodle and either post them to Piazza or see what the answers are on Piazza. Please submit lots more than that, but three will give you full credit.

Throughout the course, I'll mainly be answering Piazza questions on Piazza (and also hoping that you and your classmates all answer questions on Piazza too), but I imagine that some of the questions this time may be more general. Thus, I may also give bigger picture answers to some of the questions during the Q&A during our in-class time; these sessions are recorded so while you're encouraged to come if you're in a compatible time zone, you can get all the info you need even if you aren't able to be there.

## And don't forget...

Start early, ask lots of questions, and have fun!

*This activity originally designed by Jeff Ondich. Thanks for sharing!*