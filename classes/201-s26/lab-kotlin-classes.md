---
layout: page
title: Kotlin Classes Lab
permalink: /classes/201-f25/kotlin-classes-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `ClassesLab` in your STUWORK/username folder and open it in VSCode for today's labwork.

## Exercise 1: `Pet`

Your goal is to write a class named `Pet`, which allows us to store information about our pets.

The `Pet` class should have the following methods:
* `Pet(name, age, kind)` constructor: takes `name` (a string), `age` (an integer, in years), and `kind` (a string, like `"dog"` or `"cat"`), with all three as instance variables
* `rename(name)`: updates the name of a pet; returns nothing
* `updateAge()`: updates the age when the pet has a birthday; returns nothing

Create a file `Pet.kt` and put your code there.  To get you started, here is a `main` function you can use to test part of your implementation:
```kotlin
fun main() {
    // Make a few Pet objects
    val lulu: Pet = Pet("Lulu", 13, "cat")
    val hobbes: Pet = Pet("Hobbes", 12, "cat")
    val cheddar: Pet = Pet("Cheddar", 1, "dog")
    val mal: Pet = Pet("Marshmallow", 1, "dog")

    // Print some info
    println("Hobbes is currently ${hobbes.age} years old, and Lulu is ${lulu.age}.")
    
    print("The dogs are: ")
    for (pet: Pet in listOf(lulu, hobbes, cheddar, mal)) {
        if (pet.kind == "dog") {
            print("${pet.name} ")
        }
    }
    println()

    // Hobbes has a birthday next Tuesday!
    hobbes.updateAge()
    println("On Tuesday Hobbes will be older!  (${hobbes.age} years)")
}
```

## Exercise 2: `MyMap`

If you finished Exercise 1 early, you can start Exercise 2 for fun.  We won't go over it in class.

Your goal is to write a class named `MyMap`, which allows us to associate _keys_ with _values_.  For example, we may want to map the string `"blue"` to the number `3` and the string `"yellow"` to the number `4`. Note that you should not use any built-in Kotlin map, you are implementing your own instead!

The `MyMap` class should have the following methods:
* `MyMap()` constructor: takes no actual parameters, but initializes necessary data structures; returns `None`
* `add(key, value)`: adds a new mapping from `key` (assume it's a `String`) to `value` (assume it's an `Int`), or updates the mapping if `key` is already present; returns `None`
* `get(key)`: looks up the value mapped to by `key`; returns the value for `key` or `None` if no mapping exists for `key`
* `getSize()`: calculates the number of key-value pairs; returns that number (an `int`)

Think carefully about what you need to store to be able to handle any number of key-value pairs.

You should create a new file named `Map.kt` and put your class definition there.  It should start like this:
```kotlin
class MyMap {
    // TODO: initiailize any necessary data structures

    // TODO: add methods
}
```

Here's a simple `main` function you can use to try some of the `MyMap` functions out:
```kotlin
fun main() {
    val map: MyMap = MyMap()

    map.add("blue", 314)
    map.add("yellow", 271)

    println("There are ${map.getSize()} pairs in the map.")
}
```

How would you write code to test the rest of the class definition?

## Submitting
You aren't required to submit this lab, but if you do upload both of your completed programs to Moodle, you will get an extra engagement credit.

## Acknowledgements
This lab is from Prof Tanya Amert. She has the fun pet names, not me :(. I thought about updating the lab to be about plants instead, but that didn't seem as much fun....