---
layout: page
title: Interfaces Lab
permalink: /classes/201-f21/interface-lab
published: true
---



## Goals
To work out what it means to implement an interface, see one advantage of having interfaces in practice, and try out working with Lists.

In this lab, you'll be creating a simulation of a garden. Specifically you'll:
* Instantiate some plants and put the plants in a List
* Simulate several days, including some watering of the plants
* Display the plants

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Wednesday Sept 22nd, but it isn't due until Friday Sept 24th at 5:00pm Central.

This lab has [starter code](GardenLabStarter.zip). 
[Mount the COURSES drive](https://wiki.carleton.edu/pages/viewpage.action?spaceKey=carl&title=CS+111+and+201+workflow+in+CS+labs), download the code, and move it to your STUWORK folder.
Make sure to also have your reference sheet handy since you'll be starting to use more Java.

You should work on this with your in-class partner, but you both need to submit separately. 
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your `Collaborations.txt`.

## Exercise 0
Add a `Collaborations.txt` file and specify you and your partner's names and any other interactions you have on this lab. Also note any outside sources such as websites that you referenced. 

## Exercise 1
a. The starter files include a Plant interface. 
Read through the interface; you can also take a look at the [JavaDoc for the interface here](http://www.cs.carleton.edu/faculty/arafferty/cs201_spr2020/lectures/labs/gardenLab/javadoc/Plant.html). (This was generated using the `javadoc` command based on the JavaDoc method comments!)

b. Decide on a kind of `Plant` you want to implement. Carrot is already taken, so choose something else! Make a file where you'll implement your Plant:
```
public class YourPlant implements Plant {
    //stuff goes here
}
```

c. Copy over the entire body of the interface including all the method names and the comments.

d. Add the bodies of the methods but have them just do nothing but just returning null or 0 depending on what type they return:
```
public String getName() {
    return null;
}
```

e. Make sure everything compiles:
```
javac *.java
```

## Exercise 2
a. Fill in all the methods of your Plant class, feel free to get creative with the status of your plant depending on its water!

b. Create an instance of your plant in the `main` of your plant's file.

c. Compile and run your plant's file to make sure everything works and correct any errors.

## Exercise 3
Time to make your Garden!
a. In the `main` of `Garden.java` create an `ArrayList` of Plants. You will need to import some libraries to be able to use these data structures.

b. Create at least one `Carrot` and put it in your list. The `Carrot` class file is in the starter code though you may not be able to see it. If you want to see that it's there, type `ls` in the terminal prompt and you'll see all the `.class` files.

c. Create at least one of your own plant type and put it in your list.

d. Create a for loop that simulates several days time elapsing, during which you should probably water your plants as well (remember you should be compiling and running your code every time you add something).

e. Display the plants in the garden at the end of main.

## Exercise 4
In a comment in the `main` of Garden, reflect on the benefit of having an interface for Plant when creating your garden simulation.

## Submission
Compress your files as a zip, and upload that zip to Moodle under the appropriate assignment.
Remember that partners need to submit their code separately and you should share the code you wrote in class with your partner.

This activity is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaborations.txt file) and to use comments in the code to indicate things you tried but what went wrong/where you got stuck.

## Extensions
Remember to submit your code for the above requirements first before working on extensions!

Once you get the basic simulation working, there are a number of extensions you can try if you have extra time. Pick one(s) that seem interesting to you or that you're not quite sure how to do yet:

* Use object oriented style to complete the full garden simulation (putting more than only two plants in a list, simulating several days and watering of the plants on at least some days, and then displaying all plants). Jot down some notes on paper about how to design `Garden`. You should have your list of Plants be an instance variable and have methods like `addPlant(Plant)` and `waterAllPlants()`. Once you've written out what you want to include on paper, implement it!
* Add a method in `Garden` that takes the name of a plant and waters only plants with that name: `water(String plantName)`.
* Choose a random amount by which to vary the amount of water (e.g., maybe your sprinkler hits some plants more than others, or maybe the rainfall is lighter/heavier than forecasted). Check out `Random` or `Math.random()`.
* Vary the behavior of the `Plant` you implemented with an additional variable, such as age of the plant.
* Play with inheritance - e.g., you could have a `Tomato` superclass and `CherryTomato`, `HeirloomTomato`, etc that extend that class.
* Read the plants to add from a file. E.g., if you had `Tomato` and `Carrot` classes, your file could have lines saying either tomato or carrot. For each line, you add a new plant to the garden of the appropriate type.