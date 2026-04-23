---
layout: page
title: Hashing Lab
permalink: /classes/201-s26/hashing-lab
published: true
---

## Goals
To *refactor* an existing codebase to use a hash table instead of a list. Along the way, you will need to think about what should be part of a hash function for a custom class and the pros and cons of different collision resolution approaches given a specific problem.

## Setup
Mount the COURSES drive and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HashingLab`
* Download the [starter code](/classes/201-s26/HashingStarter.zip) and put it into your lab folder
* Open your `HashingLab` folder in VSCode

## Scenario
You're starting at a new job for a shipping distribution company. Their existing tracking software keeps all the packages in a list and just iterates over it to find a package. The previous intern had an idea for improving the performance using a hash table, but they didn't get very far before they got distracted by the latest Pokemon game (can't blame them really). 

The company also had a contractor design a simulation to measure the performance of the software, but it doesn't actually work apparently.

Your new boss has been noticing some serious slow downs as they have been getting more and more package tracking jobs, so they want you to revisit the intern's code and see if you can get it working.

## Exercise 1: `hashCode`
You'll want to start in `Package.kt` to make this custom class hashable at all. 

1. Remember that to make a hashcode for a custom class, you'll need to decide what properties of the instances should be part of the hashcode. Take a look through the class to see what all properties it has and determine which ones you'll use for your hashcode function. It's a good idea to use the `.hashCode` of those properties as part of your custom hash code.

2. Once you've decided, add a hashcode function to the class like so:
```kotlin
override fun hashCode(): Int {
    // Your code here
}
```

3. It's important at this point to make sure that your new code works as you expect. Before jumping into writing test code, however, come up with as many types of scenarios that you can think of and what should happen, similar to the existing test code for the starter code. Here are some questions to get you starter:
    * When should two `Package` objects have the same hashcode?
    * When should two objects have different hashcodes? (You can't guarantee this in general, but you can come up with specific ones that will be different.)
    * When do you anticipate a collision of unequal objects? Is there anything reasonable that you can do to avoid it?

4. Once you have your list (written down as comments to guide you!), write your test code and see if it works as expected. Remember you can compile a single file with `kotlinc Package.kt`.

## Exercise 2: Capturing Current Behavior
It's almost time to dive into this refactoring! You'll be working in `ShippingTracker.kt` now.

1. The intern got a few things written in here fortunately. Take a look through the file and make sure that you have found the code that does the following:
    * Creates an array of linked lists (so what was the intern planning for collision resolution?)
    * Compresses a hashcode to fit in the hash table
    * Provides access to a list of all of the packages in the system

2. You are in the situation of refactoring where you have existing code (that apparently works), but there is no test code for it, so you won't know if your changes break existing functionality. You need to write *characterization tests* to capture the current behavior of the system so you know if you break it. Write code for the following in `main`:
    * Create a `Package` object 
    * Create a `ShippingTracker` object
    * Add the package to the tracker
    * Make sure you can find the package
    * Add a duplicate package and make sure that the information is updated when you find it again
    * Change some of the mutable properties of the package and make sure you can still find it
    * Create some non-duplicate packages and make sure they all can be found still
    * Remove a package and make sure it can't be found anymore

3. To compile all of these files and make sure that your tests are outputting what you expect, use the following:
```bash
kotlinc ShippingTracker.kt Package.kt LinkedUL.kt
```

## Exercise 3: `add` Refactor
Let's start with `add` (since it will be hard to test anything else if there aren't packages in the tracker!). 

Think through answers to the following (and write them as comments) before diving into the code:
    * How will you know if there is not already an item at that location in the hash table? What should your code do in that scenario?
    * If there is already an item at that location, how will you know if this is a collision of two different packages or the same package that needs to be updated?

The provided `LinkedUnorderedList` has an additional function `getByValue` that you will likely find useful. I recommend you start with when there isn't a collision and make sure that works before handling collisions.

To test your `add` before you've updated `find`, you'll probably want to use `getAllPackages`.

## Exercise 4: Finish the Refactor
Go through the same process for `find` and `remove`. First think about the scenarios and make your plan, then write your code and test.

You may find yourself writing some duplicate code along the way or realizing there are some aspects that would be easier with a change to the linked list. I encourage you to make note of those realizations as comments so that you can go back and do another round of refactoring after you have a first draft with your hash table.

Once you've finished this implementation, you can switch `getAllPackages` to work with the hash table and then see if `Simulator.kt` works now.

## Exercise 5: Pause for Reflection
You put a lot of trust in that previous intern that chaining was the right collision resolution strategy for this problem. Discuss (and make some notes) what would need to change to switch to open addressing with either linear or quadratic probing. What do you think are the pros and cons to each approach for this particular problem?

## Submit
Submit your completed `Package.kt` and `ShippingTracker.kt` to Moodle for an extra engagement credit. Remember that the labs are not required and are open until the last day of classes, so there is no rush, but they are good practice.

## Extra
Here are some more things to try if you want more practice:
* Try out the open chaining implementation, then you can really show your boss you are going above and beyond!
* Would a doubly-linked list be better for `remove`? And perhaps some further refactoring and improvements to the linked list while you are at it to make it customized for this purpose?
