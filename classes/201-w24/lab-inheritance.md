---
layout: page
title: Inheritance Lab
permalink: /classes/201-w24/inheritance-activity
published: true
---

This is a lab assignment and so you will not be submitting it. However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

## Goal
Get practice writing code that uses inheritance and see how the finer details of inheritance work.

## Setup
* [Mount the COURSES drive](getting-started)
* Create a new folder in your STUWORK called `InheritanceLab`
* Create a document Answers.txt where you'll write your answers to some questions below

## Exercise 1
We'll first make some classes, remember to compile and run your code after each step to catch any errors early!

1. Create an `Animal` class that has the instance variables `happiness` and `age` and getters/setters for these variables. (These can be `Integer`s or `String`s depending on what you think they should contain.)

2. Choose a species of animal and create a subclass of `Animal` in its own file. Remember that you create a subclass with `extends`. To compile and test your subclass, you'll need to also compile `Animal`. An easy way to do this is to type `javac *.java`, which will compile all the Java files in the directory.

3. Within your subclass, make another instance variable called `happiness`. Make a getter and setter with **different** names from the `Animal` class getter and setter (so if you had `setHappiness` in Animal, you could do `setHappinessDog` in a Dog subclass).

4. In `main` of your subclass create an instance of your subclass to make sure everything is working.

## Exercise 2
We'll now explore what is going on with those `happiness` variables. 

1. In `main`, use your setters to set the `happiness` of your instance to two different values (meaning use the `Animal` setter to set to 5 and the subclass setter to set to 10, for example)

2. Add `println` statements that demonstrate if the setters are accessing the same variable or different variables and write your answer in Answers.txt.

## Exercise 3
We'll now explore how methods in subclasses interact with methods in superclasses.

1. Create a method `printStatus` in your subclass that prints something to the terminal.

2. In `main` create two instances of your subclass but declare one as type `Animal` and one as your subclass type:

```java
Animal test = new Dog();
Dog test2 = new Dog();
```

3. Try to call `printStatus` on both objects. One will report an error. Record which one and the error in Answers.txt.

4. Create a method `printStatus` in `Animal` that prints something different than the method in your subclass.

5. Try again to call `printStatus` on the objects you created in (b). Record in Answers.txt which method is accessed for each object.

6. In Answers.txt, reflect on why you think you got the errors that you did and what that tells you about what Java is doing when it tries to compile and when it runs a program. (Don't worry about being right, we'll talk about it!)

## Exercise 4
Let's think some more about overriding methods in a subclass.

1. In your subclass method `printStatus`, use `super` to call the `printStatus` method of `Animal`. In Answers.txt, come up with an example of when overriding a superclass method and then calling the superclass method could be useful.

2. In your subclass, add a new method `pet` using the `@Override` annotation:

```java
@Override
public void pet() {
    System.out.println("Petting the animal!");
}
```

3. Report the error that you see in Answers.txt.

4. Correct the error by adding `pet` to the `Animal` class as well and verify the error is resolved.

5. Reflect in Answers.txt on whether you find the `@Override` annotation useful and if you plan to use it (there is no right or wrong answer, I just am curious what you think!). 

## Exercise 5
If you didn't already, go back and add JavaDocs method documentation for each of your methods.

## Extra

If you finish early, work on the exercises linked through Moodle. Some of them go beyond the Java syntax that we're focused on, but feel free to refer to the included readings to learn more!