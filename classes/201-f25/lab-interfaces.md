---
layout: page
title: Interfaces Lab
permalink: /classes/201-f25/interfaces-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `InterfacesLab` in your STUWORK/username folder and open it in VSCode for today's labwork.

Download the [starter code](garden-starter.zip), unzip it, and drag it into your `Interfaces Lab` folder.

I recommend you pull out your reference sheet as well.

## Submission

You will be able to submit the completed lab individually on Moodle for an extra engagement. You should make sure to share whatever code you write in class with both partners via email.

## Goals

The purpose of this lab is to explore what it means to implement an interface, see an advantage of using interfaces, and get more practice working with `List`s in Kotlin.

In this lab, you'll be creating a simulation of a garden.  In doing so, you will:
* instantiate some plants and put the plants in a `List`
* simulate several days, including watering the plants
* display the plants

## Part A

First, we'll do some planning and basic setup.

1. The starter files include a `Plant` interface.  Read through this interface to get an idea for what methods any implementing class needs to provide.

2. Decide on two kinds of `Plant`s that you want to implement.  Make a file where you'll implement your `Plant`, for example `Eggplant.kt`:

    ```kotlin
    class Eggplant : Plant {
        // methods go here
    }
    ```

3. Copy over the entire body of the interface, including all method names and the comments.

4. Add in stub bodies of the methods, having them just returning a default value (like `0` or `""`) for their return type:
>```kotlin
>    override getName(): String {
>        return ""
>    }
>```

5. Make sure everything compiles:
>```bash
>kotlinc Plant.kt Eggplant.kt
>```

## Part B

Now, start implementing!

1. Fill in all of the methods of your `Plant`-implementing class.  Get creative with the status of your plant depending on its water!

2. Create an instance of your plant in the `main` function of `Garden.kt`.

3. Compile and run `Garden.kt` to make sure everything works and correct any errors.

4. Finally, repeat Exercise 2 with a second class implementing the `Plant` interface.

## Part C

Now, replace your code in `main` with code to create a garden!

1. In `main` of `Garden.kt`, create a `List` of `Plant`s.  There is a provided `Carrot` class that you can use, too, even without looking at its code; just know that it implements the `Plant` interface.

2. Create at least one instance of each of your classes and put them in your list.

3. Test your code by printing the name of each plant in the list.  Compile via `kotlinc -cp . Garden.kt`.  (Don't forget to import `Plant` and your classes at the top of `Garden.kt`!)

4. Add a `for` loop that simulates several days of time elapsing, during which you should probably water your plants (make sure to recompile and run to test every change you make along the way!).

5. Display the plants in the garden at the end of `main`.

6. Reflect: why is it beneficial to have an interface for `Plant` when creating your garden simulation? How would inheritance have changed things? We'll discuss as a class, so be ready to share your thoughts.

7. Submit your completed `.kt` files to the link on Moodle for an engagement credit.

## Want more to do?

Once you have the basic simulation working, you can add some extensions!  Try one out, and ask questions anywhere you have them.

* Use object-oriented style to complete the full garden simulation (with more than two plants in a list, simulating several days and watering at least sometimes, then displaying all plants).  Write down some notes on paper about how to design `Garden`.  You should have your list of `Plant`s be an instance variable and have methods like `addPlant(plant: Plant)` and `waterAllPlants()`.  Once you've designed it on paper, go ahead and code it up!

* Add a method in `Garden` that takes the name of a plant and waters only plants with that name: `water(plantName: String)`.

* Choose a random amount by which to vary the amount of water (e.g., maybe the sprinkler hits some plants more than others, or maybe the rainfall is lighter/heavier than expected).  Try using a [`Random` library function](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.random/-random/) like `Random.nextInt()` for this.

* Vary the behavior of the `Plant` that you implemented with an additional variable, such as the age of the plant.

* Play with inheritance -- for example, you could have a `Tomato` superclass and `CherryTomato`, `HeirloomTomato`, etc. to extend that class.

* Read the plants to add from a file.  For example, if you had `Tomato` and `Eggplant` classes, your file could have lines saying either tomato or eggplant.  For each line, you could add to the garden a new plant of the appropriate type.
