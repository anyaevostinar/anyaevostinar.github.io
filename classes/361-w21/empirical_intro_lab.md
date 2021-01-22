---
layout: page
title: Empirical Introductory Lab
permalink: /classes/361-w21/empirical_intro_lab
---

## Goals
To use Empirical to create a simple artificial life simulation that you'll be able to adapt to serve your purposes for your project.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Friday Jan 29th, but it isn't due until Monday Feb 1st at 5:00pm Central.

## Setup
Open the Empirical Start project on Repl.it for starter code.

Also open the reading for today and the [evolutionary algorithm lab](/classes/361-w21/evo_alg_lab) to reference the methods that will be useful.

## Exercise 1
a. The starter code includes a lot of files, but we'll be focusing on the files in the `source` directory for now. The code is currently functional, try it out using the following commands:
```
make
./evo-algo
```

You'll notice some warnings, but you can ignore those for now.

b. Nothing actually prints out currently. Open the file `native.cpp` in the `source` directory. This is the file that is run by the above commands. You can see that currently it just includes some files, makes a random number generator and a world object, but nothing else.

c. The first thing we need to do is create an organism that can be added to the world. Take a look at the `Organism` constructor in `Org.h` to see what arguments it currently takes and create an organism in `native.cpp` and `Inject()` it into the world.

d. If you didn't add any more organisms or do anything else, your world would just have space for one organism. To force your world to have room for your population to grow, use the `Resize()` method.

e. Verify that you have a population of one living organism in your world by printing out the result of `GetNumOrgs()` with a helpful message. Compile and run your code using the same commands from (a).

## Exercise 2
Now it's time to actually make time proceed for your world. 

a. Create a for-loop in `native.cpp` that loops 1,000 times and prints out what "update" it is on with an informative message.

b. Move your population number message into this loop as well.

c. Call the world's `Update()` method.

d. Recompile and run to see what happens.

## Exercise 3
Because your `Process()` method in `Organism` doesn't do any reproduction, your starting organism can't actually reproduce. We could have the world take care of that process, but with the goal of keeping our organism class highly modular, we'll have it do it instead.

a. In your `Organism` class, add a method `checkReproduction()` that returns an `emp::Ptr<Organism>`. It needs to be a pointer because sometimes we won't return anything and we can't return an empty reference, but we can return a null pointer.

b. In asynchronous reproduction models, instead of having a fitness function that determines which organisms reproduce every generation, we have resources or points that organisms accumulate and once they have enough, they reproduce. Include a check for if your organism has 1,000 points and if they do, create a new `Organism` like this:
```
emp::Ptr<Organism> offspring = new Organism(*this);
```

This is using a copy constructor, which is provided by default in C++. It takes all the instance variables set for the current Organism and sets them the same for the new Organism.

c. The copy constructor is very useful for keeping everything about the parent the same as the offspring, however it also copies the value for `points` which means that the offspring gets free resources! Change the offspring's points back to 0 as it should be.

d. Finally, we also need to make sure that the parent actually pays the cost of reproduction, so subtract 1000 points from the parent's points.

## Exercise 4
We have a reproduction method, but don't actually call it yet. For that, we need to go into the `World.h` file and add some things to its `Update()` method.

a. We don't want to give unfair advantage to organisms at the beginning of the list, since if they always get to reproduce first, genotypes could persist in the population even if they aren't actually better, but just because they happen to be first in the list and so get checked for reproduction before everything else. Empirical has a useful function for getting a permutation of a list for this purpose:
```
emp::vector<size_t> schedule = emp::GetPermutation(random, GetSize());
```

`size_t` is a special type in C++ that stands for "size type" and is appropriate for integers that will always be positive, like sizes and positions in a list.

b. Now you can use a for-loop to loop over the schedule. However if you immediately called `checkReproduction`, you would probably get an error because you'll probably run into an empty space, which doesn't have a method called that. Use the `IsOccupied` method to first make sure that you only deal with occupied spaces.

c. Then call the `Process` method so every organism gets resources. We could call the `checkReproduction` method right away as well, but this could lead to similar problems mentioned before where some organisms are lucky and get resources and the chance to reproduce right away.

d. Instead, create another schedule and loop after your first one to check reproduction after everyone has gotten resources.

e. Remember that if there is an offspring returned, you'll need to add it to the population with the `DoBirth` method. This is a good time to recompile and run to see your population size increase.

## Exercise 5
Your organisms don't actually do anything other than get resources and reproduce, they don't even mutate since there isn't anything for them to mutate, they have no genome to speak of!

a. Add some kind of instance variable to be a simple genome for your organisms. A `double` works well to start and could be the probability of them doing some action like sharing resources with a random neighbor.

b. Add a `mutate` method to your `Organism` class, using what you learned from the evolutionary algorithm lab, and call that method in your `checkReproduction` method to mutate the offspring.

c. Even though your instance variable doesn't control any behavior yet, we can observe it "drifting". Genetic drift is the idea that if a trait is under no selective pressure, it will still change over time. Within your `Update` method, total up and calculate the average value of your instance variable and print it out.

d. Run your simple artificial life simulation to observe the genetic drift of your trait.

e. Change the population structure to a Grid using `SetPopStruct_Grid` and see if that changes the dynamics of genetic drift.

## Submitting
Empirical is way too big to zip and upload to Moodle regularly, so we're going to try out Repl.it's submission functionality. Click 'Submit' in the upper right corner of your project and **on Moodle paste in the link to your project**.

## Extensions
If you have extra time, try adding to your organism's `Process` method so that it actually does something based on your instance variable genome. Ideas include:
* Donate resources to another organism
* Spend resources to steal from another organism
* Spend resources to build defense from the environment or other organisms

You can also start looking through the code from the Built with Empirical examples and see how they built their organisms and worlds.

## Credit
This lab uses the [cookie-cutter material](https://github.com/devosoft/cookiecutter-empirical-project.git) from [this tutorial](https://mmore500.com/waves/tutorials/lesson02.html) by [Matthew Andres Moreno](https://github.com/mmore500) and [Santiago Rodriguez Papa](https://github.com/rodsan0/)