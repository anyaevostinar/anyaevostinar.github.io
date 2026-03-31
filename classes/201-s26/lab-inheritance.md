---
layout: page
title: Inheritance Lab
permalink: /classes/201-s26/inheritance-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `InheritanceLab` in your STUWORK/username folder and open it in VSCode for today's labwork.

Download the [starter code](garden-starter.zip), unzip it, and drag it into your `InheritanceLab` folder.

I recommend you pull out your reference sheet as well.

## Goals

The purpose of this lab is to explore what it means to work with an abstract super class, see an advantage of using inheritance, and get more practice working with `List`s in Kotlin.

In this lab, you'll be creating a simulation of a garden.  In doing so, you will:
* instantiate some plants and put the plants in a `List`
* simulate several days, including watering the plants
* display the plants

## Part A

First, we'll do some planning and basic setup.

1. The starter files include a `Plant` abstract class.  Read through this class to get an idea for what methods are provided and what you will need to define. The files also include a `Carrot.class` file, which I have already written and compiled, and which inherits and completes implementation of the `Plant` class.

2. Decide on two **additional** kinds of `Plant`s that you want to implement (not `Carrot`, that's taken!).  Make a file where you'll implement your `Plant`, for example `Eggplant.kt`:

    ```kotlin
    class Eggplant : Plant() {
        // defining abstract instance variable
        override val species: String = "Eggplant"


        // abstract method implementation goes here
    }
    ```

3. You are required to define at least the things marked `abstract`, so define your `species` as well as copying over the *signature* of `getStatus()`.

4. Add in a stub body of the method, having it just return a default value (like `""`) for the return type:
    ```kotlin
        override fun getStatus() {
            return ""
        }
    ```

5. Make sure everything compiles:
    ```bash
    kotlinc Plant.kt Eggplant.kt
    ```

## Part B

Now, start implementing!

1. Fill in the `getStatus` method of your `Plant`-implementing class.  Get creative with the status of your plant depending on its water! Remember that you can define additional functions and access the super class' variables with `super`. 

2. Create an instance of your plant in the `main` function of `Garden.kt`.

3. Compile and run `Garden.kt` to make sure everything works and correct any errors.

4. Finally, repeat with a second class implementing the `Plant` interface.

## Part C

Now, replace your code in `main` with code to create a garden!

1. In `main` of `Garden.kt`, create a `List` of `Plant`s:
    ```kotlin
    val myPlants : MutableList<Plant> = mutableListOf()
    ```

2. Create at least one instance of each of your classes and put them in your list. There is a provided `Carrot` class that you should use, too, even without looking at its code; just know that it inherits from `Plant` too.

3. Test your code by printing each plant in the list, since the `toString` method is provided in `Plant`.  Compile via `kotlinc -cp . Garden.kt`.  (Don't forget to import your classes at the top of `Garden.kt`!)

4. Add a `for` loop that simulates several days of time elapsing, during which you should probably water your plants (make sure to recompile and run to test every change you make along the way!).

5. Display the plants in the garden at the end of `main`.

6. Reflect: why is it beneficial to use inheritance for `Plant` when creating your garden simulation? How would it being an interface have changed things? We'll discuss as a class, so be ready to share your thoughts.

## Submission

Submit your completed `.kt` files to the link on Moodle for an engagement credit. You should make sure to share whatever code you write in class with both partners via email. Remember that labs are optional to complete and remain open until the last day of classes, but are great practice.

## Want more to do?

Once you have the basic simulation working, you can add some extensions!  Try one out, and ask questions anywhere you have them.

* Use object-oriented style to complete the full garden simulation (with more than two plants in a list, simulating several days and watering at least sometimes, then displaying all plants).  Write down some notes on paper about how to design `Garden`.  You should have your list of `Plant`s be an instance variable and have methods like `addPlant(plant: Plant)` and `waterAllPlants()`.  Once you've designed it on paper, go ahead and code it up!

* Add a method in `Garden` that takes the name of a plant and waters only plants of species: `water(plantSpecies: String)`.

* Choose a random amount by which to vary the amount of water (e.g., maybe the sprinkler hits some plants more than others, or maybe the rainfall is lighter/heavier than expected).  Try using a [`Random` library function](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.random/-random/) like `Random.nextInt()` for this.

* Vary the behavior of the `Plant` that you implemented with an additional variable, such as the age of the plant.

* Play with inheritance -- for example, you could have a `Tomato` superclass and `CherryTomato`, `HeirloomTomato`, etc. to extend that class.

* Play with interfaces -- you could have a `Container` interface for plants that are in containers and so can be moved around.

* Read the plants to add from a file.  For example, if you had `Tomato` and `Eggplant` classes, your file could have lines saying either tomato or eggplant.  For each line, you could add to the garden a new plant of the appropriate type.
