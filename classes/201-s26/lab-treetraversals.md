---
layout: page
title: Tree Traversals Lab
permalink: /classes/201-s26/tree-traversal-lab
published: true
---

## Goals
To implement different tree traversals and get practice applying them to solving problems.

## Setup
Mount the COURSES drive and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `TreeTraversalsLab`
* Download the [starter code](/classes/201-f25/treeTraversalLab.kt) and put it into your lab folder
* Open your `TreeTraversalsLab` folder in VSCode

Note, I tried out using Gemini to generate more "interesting" test data. It's certainly interesting!

## Exercise 1: Warm up
1. Look at the code in `main` for creating a tree and draw out what you think the tree will look like on the back of your worksheet.

2. Write out on paper what each traversal order (pre, post, in) should result in for your tree.

3. Implement each of the traversals, making sure to test your code as you go. (I.e. you should check after implementing each method that it works!) These will be fairly similar to the reading, but slightly different. I recommend you don't consult the reading at first to improve your own understanding of the traversals.

4. Pause for reflection: What is the worst case time complexity of traversing a tree? What about getting to just a leaf?

## Exercise 2: Table of Contents Generation
You are building a digital publishing tool. You want to create a tool `generateTOC()` that prints the items in the order they appear in a book. Create a custom `BookTree` class that implements the `generateTOC` function using the appropriate traversal. You'll need to think about how you can make a tree that is not limited to only two nodes. Here is an example book that you should be able to represent:
```
Title: History of Spaceflight
Chapter 1: The Early Years
1.1 Rocket Science Basics
1.1.1 Newton's Third Law
1.1.2 Solid vs Liquid Fuel
1.2 The First Satellites
1.2.1 Sputnik 1
1.2.2 Explorer 1
Chapter 2: The Moon Race
2.1 Project Mercury
2.2 Project Gemini
2.3 Apollo Program
2.3.1 Apollo 1 Tragedy
2.3.2 Apollo 11 Landing
2.3.3 Moon Landing
Chapter 3: The Shuttle Era
3.1 Reusable Spacecraft
3.2 The International Space Station
3.3 Assembly in Orbit
3.4 Microgravity Research
```

## Exercise 3: Cooking a Sunday Dinner
Now you're designing a kitchen helper app for creating complex dishes with many dependencies. Given a dish, you should represent it as a custom tree class and then give the directions in the order that they should be carried out. Here is an example set of nested directions for making a Beef Wellington:
* "Serve Beef Wellington"
    * "Bake and Rest"
        * "Preheat Oven to 425°F"
        * "Wrap and Shape"
            * "Layer Components"
                * "Prepare Mushroom Duxelles"
                    * "Finely Mince Mushrooms"
                    * "Sauté with Shallots and Thyme"
                    * "Reduce Moisture Completely"
                * "Prepare Chive Crepes"
                    * "Whisk Flour, Eggs, and Chives"
                    * "Cook Thin Crepes in Skillet"
                * "Prepare Seared Beef"
                    * "Trim and Tie Fillet"
                    * "Season Generously"
                    * "Hard Sear in Hot Pan"
                    * "Brush with English Mustard"
            * "Prepare Puff Pastry"
        * "Chill Log in Fridge (30 mins)"

## Exercise 4: Aircraft Weights
You need to maintain the weights of all subcomponents of an airplane and be able to update and calculate the total weight for a subcomponent or the whole plane on the fly. Create another version of the tree that is able to represent all the subcomponents of an airplane and has a function `totalWeight` that calculates the total weight of all parts, as well as `partialWeight(part)` that is able to calculate the weight for a provided subtree. Here is some sample data to amuse you:
* Left wing
    * Outer flaps: 500
    * Internal Fuel Tank: 1200
    * Left Engine
        * Turbine blades: 800
        * Engine casing: 1200
* Right wing
    * Outer flaps: 500
    * Internal fuel tank: 1200
    * Right engine
        * Turbine blades: 800
        * Engine casing: 1200
* Fuselage
    * Cockpit avionics: 1500
    * Passenger seating: 3000
    * Main hull: 15000

## Submission

Upload your completed lab to Moodle for an extra engagement credit.

## Extra
You probably have a lot of repeated code between your different classes. How could you use interfaces or inheritance or composition to reduce that repeated code while maintaining the ability for more new customized trees to be easily created?


