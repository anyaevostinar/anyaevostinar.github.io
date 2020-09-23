---
layout: page
title: Inheritance Activity
permalink: /classes/201-f20/inheritance-activity
---

## Logistics
You should complete this on Monday Sept 21st, 2020, but it isn't due until Wednesday Sept 23rd, 2020. 

You may get help from your collaborative learning group and anyone else in class, but be sure to submit your own solution and record any help or outside sources in your Collaborations.txt document.

## Goal
Get practice writing code that uses inheritance and see how the finer details of inheritance work.

## Setup
You'll complete the activity on Repl.it as always and hand it in on Moodle.
* Open the Inheritance Activity from the Projects list in our Classroom
* Create your Collaborations.txt document
* Create a document Answers.txt where you'll write your answers to some questions below

## Exercise 1
We'll first make some classes, remember to compile and run your code after each step to catch any errors early!

a. Create an `Animal` class that has the instance variables `happiness` and `age` and getters/setters for these variables.

b. Choose a species of animal and create a subclass of `Animal` in its own file. Remember that you create a subclass with `extends`. 

c. Within your subclass, make another instance variable called `happiness`. Make a getter and setter with **different** names from the `Animal` class getter and setter (so if you had `setHappiness` in Animal, you could do `setHappinessDog` in a Dog subclass).

d. In `Main.java` create an instance of your subclass to make sure everything is working.

## Exercise 2
We'll now explore what is going on with those `happiness` variables. 

a. In Main, use your setters to set the `happiness` of your instance to two different values (meaning use the `Animal` setter to set to 5 and the subclass setter to set to 10 for example)

b. Add `println` statements that demonstrate if the setters are accessing the same variable or different variables and write your answer in Answers.txt.

## Exercise 3
We'll now explore an alternative to `public` and `private` which is `protected`. 

a. In `Animal` change `age` to be `protected int age`.

b. Add statements in `Main` and your subclass that demonstrate where `protected` variables can be accessed.

c. In Answers.txt compare and contrast where `public`, `private`, and `protected` variables can be accessed. Be sure to discuss the access of subclasses vs. non-subclasses.

## Exercise 4
We'll now explore how methods in subclasses interact with methods in superclasses.

a. Create a method `printStatus` in your subclass that prints something to the terminal.

b. In `Main` create two instances of your subclass but declare one as type `Animal` and one as your subclass type:

```
Animal test = new Dog();
Dog test2 = new Dog();
```

c. Try to call `printStatus` on both objects. One will report an error. Record the error in Answers.txt.

d. Create a method `printStatus` in `Animal` that prints something different than the method in your subclass.

e. Try again to call `printStatus` on the objects you created in (b). Record in Answers.txt which method is accessed for each object.

f. In Answers.txt, reflect on why you think you got the errors that you did and what that tells you about what Java is doing when it tries to compile and when it runs a program. (Don't worry about being right, we'll talk about it!)

## Exercise 5
Let's think some more about overriding methods in a subclass.

a. In your subclass method `printStatus`, use `super` to call the `printStatus` method of `Animal`. In Answers.txt, come up with an example of when overriding a superclass method and then calling the superclass method could be useful.

b. In your subclass, add a new method `pet` using the `@Override` annotation:

```
@Override
public void pet() {
    System.out.println("Petting the dog!");
}
```

c. Report the warning that you see in Answers.txt.

d. Correct the warning by adding `pet` to the `Animal` class as well and verify the warning is resolved.

e. Reflect in Answers.txt on whether you find the `@Override` annotation useful and if you plan to use it (there is no right or wrong answer, I just am curious what you think!). 

## Hand in
Make sure that you updated Collaborations.txt as necessary. As always, download your Repl as a zip and upload the zip to the Moodle assignment.

## Grading
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the code to indicate things you tried but what went wrong/where you got stuck. Feedback on labs and activities is less detailed than on homework, as solutions are provided for you to compare to your own work.