---
layout: page
title: Empirical Introduction
permalink: /classes/361-w21/empirical_intro
---

# Introduction 
[Empirical](https://empirical.readthedocs.io/en/latest/index.html) is an open-source software library of tools for scientific software development that currently provides tools for building evolutionary algorithms and artificial life models in the "Evolve" directory, though the plan is to eventually have the evolutionary tools be their own sublibrary. It also provides tools for creating web interfaces on top of scientific software easily by allowing the programmer to program in C++ and Empirical then uses Mozilla's Emscripten compiler to convert the C++ into Javascript.

A list of examples of things built with Empirical is [here](https://empirical.readthedocs.io/en/latest/BuiltWithEmpiricalGallery/index.html).

Empirical is a work in progress (as all open-source software pretty much continually is) that has not actually been officially released yet and the documentation is still in development. 

# World
One of the useful tools that Empirical provides is the [`World`](https://empirical.readthedocs.io/en/latest/api/classemp_1_1World.html#class-documentation) class. 
This class is a container that holds a class that you will specify for how you want your organisms to behave. You will usually want to add additional functionality to the `World` class, so you will use inheritance to grab all the functionality of the `World` class and also add your own:

```
class MyWorld : public emp::World<Organism> {

}
```

This code snippet is assuming you have an `Organism` class defined as well, which I'll discuss later in this document.

The `World` class has a lot of provided functions, which you can search through in the [documentation](https://empirical.readthedocs.io/en/latest/api/classemp_1_1World.html#class-documentation). The `World` class has the ability to hold multiple populations of organisms, which are contained in the instance variable `pop`. For now, we'll only worry about having one population, which is the default behavior. `pop` is a special `vector` provided by the Empirical tools that does all the same things a standard `vector` does while also providing extra debugging tools. You can see the methods it provides in its documenation [vector documenation](https://empirical.readthedocs.io/en/latest/api/classemp_1_1vector.html#class-documentation). The important thing for now is that you can access things in `pop` list so:
```
pop[i]->OrgMethod()
```

## World Constructor
When you are creating constructor for a subclass of `World`, you'll want to call the constructor of `World` and C++ has a shortened way of doing that as well as setting instance variables based on the parameters in the constructor, which you often want to do:

```
    OrgWorld(emp::Random &_random) : emp::World<Organism>(_random), random(_random) {
        random_ptr.New(_random);
    }
```

There's a lot going on in there, so let's put in some extra lines so that we can talk about each piece:

```
OrgWorld(emp::Random &_random) //taking in an emp::Random object reference called _random
    : emp::World<Organism>(_random) //Calling the super class' constructor, passing in _random
    , random(_random) //setting the instance variable random to _random
    
    {
    random_ptr.New(_random); //demonstrating creating a new emp::Ptr object to point at _random
}
```

## Update
`World` also provides an `Update()` method that does various housekeeping tasks. We'll want to do other things in `Update()` as well, so you can call the super class method in your own method:

```
void Update() {
    emp::World<Organism>::Update();
    // other stuff to do every update
}
```

## IsOccupied
`IsOccupied(i)` tells you if there is a living organism in the ith position of the world. This will be important to check before trying to call any methods on an organism in that position to avoid segmentation faults when you try to access memory that you don't actually have permission to access.

## DoBirth
`DoBirth` is a useful method of `World` that places an offspring into the population based on the rules of spatial structure in the world. Two main types of spatial structure are grid and mixed. Grid is where the organisms are placed on a 2D grid of size that you specify and are considered neighbors with the organisms one grid space away from them. Mixed is where organisms are all considered neighbors of each other like they are constantly being mixed around in liquid. The spatial structure can be considered for many things, but one of the first you'll encounter is where offspring are allowed to be placed. In a grid, offspring are only placed immediately adjacent to the parent, whereas in mixed, offspring can be placed anywhere. `DoBirth` takes care of all of that for you, you just have to give it the offspring and the location of the parent:
```
emp::Ptr<Organism> offspring = pop[i]->CheckReproduction(); 
//this is implemented in Organism

if(offspring) {
    DoBirth(*offspring, i);
}
```

## SetPopStruct_Grid
Empirical has built-in support for having a grid spatial structure for organisms as discussed above. To set your world to be a grid of 100x200, you would write:
```
SetPopStruct_Grid(100, 200);
```


## Inject
If you aren't reproducing an organism and just want to put a specific organism into the world, you can use the `Inject()` method and pass an organism:
```
emp::Ptr<Organism> new_org = new Organism();
Inject(*new_org);
```

## AddOrgAt
If you need to pass a pointer instead of a reference to the world, you'll need to use `AddOrgAt`, which takes a pointer to the organism and the position that you want it added at:
```
emp::Ptr<Organism> new_org = new Organism();
AddOrgAt(new_org, 4);
```

## Resize
If you want a certain amount of space to be available in your world, not necessarily full of organisms, you can use `Resize(100,200)` which would force your world back to the size of 100 x 200. This will cut down as well if you have more organisms than fit!

## GetNumOrgs
Since your world can be full of living organisms and empty spots, you might want just how many actually alive organisms there are, which `GetNumOrgs()` will do for you.


# native.cpp
Empirical projects are well-suited to having a 'native' version that runs without a GUI in the console as well as a 'web' version that builds a GUI that can be run in a web browser. We'll focus on the native version for now.

In `native.cpp` you'll handle things like the configuration options (once we get to that), initializing the random number generator, creating the world, the first organism(s), and actually run the update loop.

To create a new world, assuming you named your `World` subclass `OrgWorld`, you need to first declare and initialize your random number generator, which we'll use Empirical's tools for:
```
emp::Random random(2); //declaring and intializing a variable random with a seed of 2
OrgWorld world(random); //declaring and initializing a variable world, passing in argument random
```

You'll also want to initialize and inject at least one organism to get your world started and include a for loop that loops the desired number of time steps, calling your world's `Update` method each loop at least.

# Organism
The main place that will define your project will be what your Organism does.
We'll be focused on an asynchronous generation style of model where organisms get resources/points each update, can perform behaviors with those resources/points that are focused on what you are trying to study, and then when they have enough resources/points, they are able to reproduce. Thus, organism genotypes that collect resources/points more quickly are the ones most likely able to reproduce and persist in the population. I'll use resources and points interchangably, sorry in advance!

We'll be taking the software design approach of trying to have the Organism class handle as much about itself as possible, which means that it will hold a pointer to the random number generator, a mutation rate, deal with its own reproduction and anything else that you want to add. This can be a bit counter-intuitive since some of these things seem like something the world should control, but it makes it easier to mix and match if you want to allow multiple different organism classes in your world.

# The future
There are several other very helpful tools that Empirical provides that we'll focus on in future readings including DataFiles that save data generated from your experiment into specified files in convinient ways and configuration managers that allow you to have a file of settings that can be changed without needing to recompile.
