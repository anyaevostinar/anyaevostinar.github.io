---
layout: page
title: Homework 1 - Lunar Lander
permalink: /classes/201-f25/hw1
---

**Due Friday, Sept 26th at 10pm**

Starter code: [lunar_lander.zip](lunar_lander.zip)  
Upload solutions via Gradescope as: `LunarLander.kt`

## Goals

This assignment is designed to help you practice the following:
* building comfort writing Kotlin code
* refreshing object-oriented programming
* working with larger programs than small classroom examples

## Collaboration policy

For this assignment, you may work alone or with a partner, but you must type up all of the code yourself.  (It is therefore unexpected for two code submissions to be completely identical.)  You may have at most one partner.

You may also discuss the assignment at a high level with other students.  You can discuss the assignment with Anya, our prefect, or any course staff.

You should list any student or course staff with whom you discussed the assignment (you don't have to include prefect sessions), and the manner of discussion (high level, partner, etc.) in comments at the top of your `LunarLander.kt` file.  You also need to include your name.

_If you work alone, you should say so instead._

## Note on style:

The following style guidelines are expected moving forward:

1. Variable names should be clear and easy to understand, should _not_ start with a capital letter, and should only be a single letter when appropriate (e.g., `i` or `j` as indices, `x` and `y` as coordinates).
2. The indentation, spacing, and location of curly braces is consistent.
3. There are no extra print statements in your program.
4. There is no commented-out code that is no longer being used (e.g., debugging print statements).
5. Your program has a comment at the top of each function with at least 5 words describing what the function does.
6. There is good use of comments to explain the "why" of your code and empty lines to break up logical chunks.
7. The code doesn't have "magic numbers" -- these are numbers in the code by themselves, rather than stored in a variable.
8. The code doesn't compute the right answer by doing extra work (e.g., having a computation in a loop when it could have been done only once, after the loop).

## Assessment

The **core** requirements for your submission are:

* complete Part A and the Reflection
* pass the basic `LunarLander` class autograder tests (see the six tests in the provided code)
* satisfy the code style expectations #1-#4 above
* include a reflection in comments at the bottom of your `LunarLander.kt` file

The **advanced** requirements for your submission are:

* satisfy the core requirements
* complete Parts B and C
* have a playable game (you won't see any autograder tests for this, as the exact text of your game is up to you -- see the example game below for what it should look like)
* satisfy all code style expectations listed above (#1-#8)
* include your name and collaboration statement at the top of your `LunarLander.kt` file

## Assignment overview

Computer _simulation_ is used by engineers to test out ideas before actually building expensive machines or putting people in dangerous situations.  Simulation is a critical part of the space program by NASA, for example.

For this program, you will create a simulation of a vehicle landing on the moon.  (It turns out that this assignment is also a rather old computer game that has been around for decades.)

Here is how it works: You are in control of a lunar lander ship, descending to the surface of the moon for a landing.  Gravity steadily accelerates your ship faster and faster toward the surface of the moon.  You, the astronaut piloting the ship, have a single control: a button with the label "burn" on it.  Burning fuel slows your ship down.  Your goal is to get your ship to land on the moon at a slow enough speed so that it doesn't crash on impact.  What's the catch?  You have only a limited amount of fuel.  If you slow your ship too much too early, you will run out of fuel and crash into the surface of the moon.

Your mission: Program this simulation in Kotlin.

## Getting started

Create a folder in which to store your work for course assignments.  For example, I created a folder `CS201` on my computer for this course, and made a folder `HW1` inside of it.  I've got other folders there, too, like `InClass`.

Where you put the `CS201` folder depends on the machine you're working on:
* If you're on your own computer, anywhere is fine.  You could put it on your `Desktop`, in `Documents`, or somewhere else you can find it easily. (Or you could have a `Classes` folder for everything!)
* If you're working in the labs in Olin, make sure to first mount the `COURSES` folder so that you won't lose your code when you log out.  Then, open up Finder, navigate to your personal `StuWork` folder, and create `CS201` there.

Download [this `lunar_lander.zip` file](lunar_lander.zip) to get the starter code.  Put it in the `CS201` folder you just created and unzip it.  This should give you a folder named `lunar_lander`.  Make sure that you actually unzip / extract the code, don't just open up the `.zip` file in another window.

Now open your folder in VS Code.  There are multiple ways to do this, so pick one:
* Open VS Code, then select `File` -> `Open Folder` and navigate to the `lunar_lander` folder you just made.
* Open VS Code, then drag and drop the folder (e.g., from Finder in MacOS or File Explorer in Windows) into VS Code to open it.

Either way, if you are asked, click that you trust the authors.  If you have any issues getting started, ask the lab assistants for help -- any of them should be able to help you get started, even if they aren't super familiar with Kotlin.

## Building your code with Maven

The provided project structure uses Maven, which adds some extra packaging around our regular `kotlinc`+`kotlin` way to run a program.  For this assignment, you can use the following commands (in the VS Code terminal) to execute your code (note that you must be in the top-level folder `lunar_lander` for these commands to work):

* `mvn test` runs the tests that we provided (see below)

* `mvn compile exec:java` compiles and runs your code, as specified in your `main` function

If you want to see less output from Maven, you can add `-q` (for "quiet") flag:

* `mvn -q test` run tests, with less output

* `mvn -q compile exec:java` runs your `main` function, with less output (but still any print statements you have)

If you run the tests with the starter code, you should have errors, as you haven't written any code yet.

## Part A: `LunarLander` class

You have been given a file named `LunarLander.kt` in which to put your code.  It contains an empty class named `LunarLander` and a place for a `main` function at the bottom.

In your `LunarLander` class, you will need to keep the following information in instance variables:

* `altitude`: how far the ship is from the surface of the moon, in meters (default initial value: 1000 meters)

* `velocity`: how fast the ship is moving, in meters/second; a positive velocity means the ship is moving toward the moon's surface, and a negative velocity means it is moving away from the surface (default initial value: 40 meters/second)

* `fuel`: how many units of fuel are left in the tank (default initial value: 25)

Your `LunarLander` class should also have the following methods (although you may define more if you wish):

* Some sort of a constructor so you can instantiate a `LunarLander` object, with specified starting altitude, velocity, and fuel.  For example, the following code should work in your `main` function:

    ```kotlin
    // Create some landers with specified initial altitude, velocity, and fuel values
    val lander1 = LunarLander(1000, 40, 25)
    val lander2 = LunarLander(2000, 20, 16)

    // Create a lander with initial altitude = 900, velocity = 30, and default fuel (25)
    val lander3 = LunarLander(900, 30)

    // Create a lander with initial altitude = 900, default velocity (40), and default fuel (25)
    val lander4 = LunarLander(900)

    // Create a lander with all default initial values: altitude (900), velocity (40), and fuel (25)
    val lander5 = LunarLander()
    ```

* A function `burn(fuelRequested)` that simulates one complete second of activity, where the astronaut has requested to burn `fuelRequested` units of fuel.  Specifically, it should do the following:
  1. Make sure you check to see if you actually have this much fuel.  If not, just burn all that you have in the steps below.
  2. Subtract the amount of fuel being burned.
  3. Decrease your velocity by 4 meters/second for each unit of fuel used.
  4. Modify your velocity to add the effect of gravity, which adds an additional 2 meters/second.
  5. Determine the new altitude for your lander.  Your new altitude is your old altitude **minus** your velocity after the above adjustments.

* A function `status()` that returns the condition of the lander:
  1. If the altitude is greater then 0, then it returns the string `"inflight"`.
  2. If instead (meaning the altitude is 0 or negative) the velocity is greater than or equal to 5, it returns the string `"crashed"`.
  3. Otherwise, if none of the above conditions are true, it returns the string `"landed"`.

A series of tests have been provided to help you determine if your `LunarLander` class is correct.  They are in the file `LanderTest.kt`; you should take a look at them to see what's in there.

Once your code works, running `mvn test` should give the following output (I didn't copy over the beginning, just the last part):

```bash
[INFO] -------------------------------------------------------     
[INFO]  T E S T S
[INFO] -------------------------------------------------------     
[INFO] Running LanderTest
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.139 s -- in LanderTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 6, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  12.109 s
[INFO] Finished at: 2025-04-02T21:38:18-05:00
[INFO] ------------------------------------------------------------------------
```

## Part B: One-player simulation

After your `LunarLander` class works, you should implement a `main` function that creates a new `LunarLander` object and provides the player with a welcome message.  Then, your code should repeatedly show the player the current information for the lander, followed by a question as to how many units of fuel to burn.

If the lander ends up hitting the surface of the moon with a velocity of 4 meters/second or less, the ship lands successfully!  If the lander hits the surface with a velocity of 5 meters/second or more, the ship crashes.

Here's a sample one-player game:

```bash
Welcome to Lunar Lander!

    Alt = 1000 Vel = 40 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 958 Vel = 42 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 914 Vel = 44 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 868 Vel = 46 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 820 Vel = 48 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 770 Vel = 50 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 718 Vel = 52 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 664 Vel = 54 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 608 Vel = 56 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 550 Vel = 58 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 490 Vel = 60 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 428 Vel = 62 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 364 Vel = 64 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 298 Vel = 66 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 230 Vel = 68 Fuel = 25
    How much fuel to burn this round? 0
    Alt = 160 Vel = 70 Fuel = 25
    How much fuel to burn this round? 2
    Alt = 96 Vel = 64 Fuel = 23
    How much fuel to burn this round? 0
    Alt = 30 Vel = 66 Fuel = 23
    How much fuel to burn this round? 0
    Alt = -38 Vel = 68 Fuel = 23
    Oh no, you crashed!
```

## Part C: Two-player simulation

As a final step, you should modify `main` so that it gives an option for it to be a one-player or a two-player game.  If the user chooses one player, it should be just as described in Part B.  If the user chooses two player, the game should have _two_ `LunarLander` objects descending to the moon, each controlled by different users.  The two players alternate back and forth, entering the amount of burn for their own landers, until something triggers an end of the game, such as a successful landing or a crash.

# Required Reflection

1. Were there any particular issues or challenges you dealt with in completing this assignment?  
2. How long did you spend on this assignment?

Write a brief discussion (a sentence or two is fine) at the bottom of your `LunarLander.kt` file (in comments, so each line should start with `//` or be in a `/* */` block) where you answer at least those two questions.

Here are some examples:

```kotlin
// Reflection:
// I had trouble getting the LunarLander constructor to work.
// I had to look up how to get user input in Kotlin documentation and scavenger hunt examples.
// I spent 6 hours on this assignment.
```

```kotlin
// Reflection:
// I started late, so I had to rush to make sure I knew how to test my code.
// It may be good to start early next time.
// I spent 5 hours on this assignment.
```

```kotlin
// Reflection:
// It went fine; I found what I needed in my notes.
// I spent 3 hours on this assignment.
```

## Hints and suggestions

* Landing without crashing is tricky.  To test your program, make the initial altitude smaller and the initial fuel amount bigger.  This makes the game quicker to play and easier to win.

* Any numbers that you see scattered throughout this assignment that are not used for initializing the lander (gravity increases velocity by 2 meters/second, the velocity must be 4 meters/second or less to land successfully, etc.) should be stored as variables in your program, not as magic numbers hard-coded in the code.  (See [Style point #7](#note-on-style) at the top.)

* It is useful to be able to automatically exit the program, rather than having to wait until a successful land or crash.  You can change your program so that if the player enters -1 for fuel to burn, the game automatically ends.  This isn't necessary at all, but can be handy.
