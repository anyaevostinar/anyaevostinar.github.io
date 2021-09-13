---
layout: page
title: Inheritance Activity
permalink: /classes/201-f21/inheritance-activity
published: false
---

## Logistics
You should complete this on Monday Sept 20th, 2021, but it isn't due until Wednesday Sept 22nd, 2021. 

You should work on this with your in-class partner, but you both need to submit separately. 
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your `Collaborations.txt`.

## Goal
Get practice writing code that uses inheritance and see how the finer details of inheritance work.

## Setup
[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `InheritanceActivity`
* Create your Collaborations.txt document in that folder
* Create a document Answers.txt where you'll write your answers to some questions below

## Exercise 1
We'll first make some classes, remember to compile and run your code after each step to catch any errors early!

a. Create an `Animal` class that has the instance variables `happiness` and `age` and getters/setters for these variables. (These can be `int`s or `String`s depending on what you think they should contain.)

b. Choose a species of animal and create a subclass of `Animal` in its own file. Remember that you create a subclass with `extends`. To compile and test your subclass, you'll need to also compile `Animal`. An easy way to do this is to type `javac *.java`, which will compile all the Java files in the directory.

c. Within your subclass, make another instance variable called `happiness`. Make a getter and setter with **different** names from the `Animal` class getter and setter (so if you had `setHappiness` in Animal, you could do `setHappinessDog` in a Dog subclass).

d. In `main` of your subclass create an instance of your subclass to make sure everything is working.

## Exercise 2
We'll now explore what is going on with those `happiness` variables. 

a. In `main`, use your setters to set the `happiness` of your instance to two different values (meaning use the `Animal` setter to set to 5 and the subclass setter to set to 10, for example)

b. Add `println` statements that demonstrate if the setters are accessing the same variable or different variables and write your answer in Answers.txt.

## Exercise 3
We'll now explore how methods in subclasses interact with methods in superclasses.

a. Create a method `printStatus` in your subclass that prints something to the terminal.

b. In `main` create two instances of your subclass but declare one as type `Animal` and one as your subclass type:

```
Animal test = new Dog();
Dog test2 = new Dog();
```

c. Try to call `printStatus` on both objects. One will report an error. Record which one and the error in Answers.txt.

d. Create a method `printStatus` in `Animal` that prints something different than the method in your subclass.

e. Try again to call `printStatus` on the objects you created in (b). Record in Answers.txt which method is accessed for each object.

f. In Answers.txt, reflect on why you think you got the errors that you did and what that tells you about what Java is doing when it tries to compile and when it runs a program. (Don't worry about being right, we'll talk about it!)

## Exercise 4
Let's think some more about overriding methods in a subclass.

a. In your subclass method `printStatus`, use `super` to call the `printStatus` method of `Animal`. In Answers.txt, come up with an example of when overriding a superclass method and then calling the superclass method could be useful.

b. In your subclass, add a new method `pet` using the `@Override` annotation:

```
@Override
public void pet() {
    System.out.println("Petting the animal!");
}
```

c. Report the error that you see in Answers.txt.

d. Correct the error by adding `pet` to the `Animal` class as well and verify the error is resolved.

e. Reflect in Answers.txt on whether you find the `@Override` annotation useful and if you plan to use it (there is no right or wrong answer, I just am curious what you think!). 

## Hand in
Make sure that you updated `Collaborations.txt` as necessary.
Send the code to your partner if relevant.
As always, turn your folder into a zip and upload the zip to the Moodle assignment.
Remember that each partner needs to upload their own lab.

## Grading
This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the code to indicate things you tried but what went wrong/where you got stuck. 