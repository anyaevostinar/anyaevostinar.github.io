---
layout: page
title: Empirical Introductory Lab
permalink: /classes/361-f26/empirical_intro_lab
---

## Goals
To use Empirical to create a simple growing population simulation.

## Setup

* Remember to start WSL if you are on Windows
* Pull down the new `EmpiricalWorld-Lab` starter code repository from the [361-F26](https://github.com/361-F26) GitHub Organization with `git clone --recurse-submodules [URL]` or `git submodule update --init --recursive` if you cloned without the recurse submodules command.
* Set up Emscripten as normal:
    ```
    cd emsdk
    ./emsdk install 3.1.49
    ./emsdk activate 3.1.49
    source ./emsdk_env.sh
    cd ..
    ```

### Running the native starter
With that all in place, the starter code is functional. Check it out with whichever command is correct for your setup:

```
./compile-run-mac.sh
```

```
./compile-run-wsl.sh
```

**Note: this is the command line mode now, so it will just output a couple of warnings and not do anything else, but there shouldn't be errors.**

## Exercise 1

a. Nothing actually prints out currently. Open the file `native.cpp`. This is the file that is run by the above commands. You can see that currently it just includes some files, makes a random number generator and a world object, but nothing else.

b. The first thing we need to do is create an organism that can be added to the world. Take a look at the `Organism` constructor in `Org.h` to see what arguments it currently takes and create an organism in `native.cpp` and `Inject()` it into the world:

```cpp
Organism* new_org = new Organism(&random);
world.Inject(*new_org);
```

You can double check that your organism has made it into the world by printing out the world's size:

```cpp
std::cout << world.size();
```

c. If you didn't add any more organisms or do anything else, your world would just have space for one organism. To force your world to have room for your population to grow, use the `Resize()` method:

```cpp
world.Resize(10, 10);
```

d. Verify that you have a population of one living organism in your world by printing out the result of `world.GetNumOrgs()`. Compile and run your code with `./compile-run.sh`.

## Exercise 2
Now it's time to actually make time proceed for your world. 

The starter code has a simple `Update` method in your world that doesn't do much other than call the superclass' method. 

1. Add to this method so that it goes through every organism in the population and calls their `Process` method. You can get the size of the world with `GetSize()` and the population of organisms is stored in the variable `pop`. You'll need to check if a location is occupied before processing it (there are ghost organisms in all the 'empty' spots). Go back to `World.h` and add a check to your `Update` loop that if a position isn't occupied, it skips that position in `pop`:

    ```
    if(!IsOccupied(i)) {continue;}
    ```

2. Go back to `native.cpp` and call your world's `Update` method.

3. Compile and run again to make sure that the correct number of organisms are processing (i.e. just one!).

4. Now you are ready to run for more updates. Write a for loop in `native.cpp` that calls `Update` 10 times.

## Exercise 3
Because your `Process()` method in `Organism` doesn't do any reproduction, your starting organism can't actually reproduce. We could have the world take care of that process, but with the goal of keeping our organism class highly modular, we'll have it do it instead.

a. In your `Organism` class, add a method `CheckReproduction()` that returns an `emp::Ptr<Organism>`. It needs to be a pointer because sometimes we won't return anything and we can't return an empty reference, but we can return a null pointer. The Empirical pointer is nearly identical to the standard pointer, but has some additional debugging functionality.

b. In asynchronous reproduction models, instead of having a fitness function that determines which organisms reproduce every generation, we have resources or points that organisms accumulate and once they have enough, they reproduce. Include a check for if your organism has 1,000 points and if they do, create a new `Organism` like this:

```cpp
emp::Ptr<Organism> offspring = new Organism(*this);
```

This is using a copy constructor, which is provided by default in C++. It takes all the instance variables set for the current Organism and sets them the same for the new Organism.

c. The copy constructor is very useful for keeping everything about the parent the same as the offspring, however it also copies the value for `points` which means that the offspring gets free resources! Change the offspring's points back to 0 as it should be.

d. Finally, we also need to make sure that the parent actually pays the cost of reproduction, so subtract 1000 points from the parent's points.

e. Since you need to return something even if you don't make a new offspring, make sure to return a `nullptr` in the situation where reproduction doesn't occur.

## Exercise 4
We have a reproduction method, but don't actually call it yet. For that, we need to go into the `World.h` file and add some things to its `Update()` method.

a. We don't want to give unfair advantage to organisms at the beginning of the list, since if they always get to reproduce first, genotypes could persist in the population even if they aren't actually better, but just because they happen to be first in the list and so get checked for reproduction before everything else. Empirical has a useful function for getting a permutation of a list for this purpose:

```cpp
emp::vector<size_t> schedule = emp::GetPermutation(random, GetSize());
```

b. Now you can use a for-loop to loop over the schedule:

```cpp
emp::vector<size_t> schedule = emp::GetPermutation(random, GetSize());
for (int i : schedule) {
    //do stuff
}
```

c. Organisms don't have anyway of gaining points yet though. Change the `Process` method in `Organism` so that it takes an argument `points` and adds those points to what the organism has already. Give them 100 points per update for now. We could call the `CheckReproduction` method right away as well, but this could lead to similar problems mentioned before where some organisms are lucky and get resources and the chance to reproduce right away.

d. Instead, in `World.h`, create another schedule and loop after your first one to check reproduction after everyone has gotten resources.

e. Remember that if there is an offspring returned, you'll need to add it to the population with the `DoBirth` method. 

```cpp
emp::Ptr<Organism> offspring = pop[i]->CheckReproduction(); 
//this is implemented in Organism

if(offspring) {
    DoBirth(*offspring, i);  //i is the parent's position in the world
}
```

This is a good time to recompile and run to make sure things are working.

## Exercise 5: Data

Now try out recording the count of organisms into a file:

a. Create a `DataMonitor` pointer for your organism count as an instance variable of `OrgWorld`.

b. Create a destructor for `OrgWorld` and make sure that your DataMonitor will be deleted when the world is destroyed (rather ominous sounding isn't it?).

c. Create a method `GetOrgCountDataNode()` that creates the data node if it doesn't exist according to the method in the reading. You'll want to think about what your data node should do for each occupied space in the world (don't over think it, it really is just a single number!).

d. Create a method `SetupOrgFile()` that grabs the total count from your data monitor and records it in the file according to the method in the reading.

e. Call your set up file in `native.cpp`, then compile and run your code to verify that it works.

## Exercise 6: Web GUI
Because Empirical supports cross-compiling from C++ to Javascript, you can visualize your simulation without a lot of extra code. The `web.cpp` file contains the typical starter code for a browser visualization that you've seen before. You just need to add a few things from `native.cpp` and draw your rectangles.

2. In the constructor for your animator, create your new organism, inject it into the world, and resize the world, just like you did in `native.cpp` (you can literally copy and paste the code!).

5. I've provided you with another file for compiling and running the web version of your code: `compile-run-web.sh`. Run this and make sure that you are getting a growing population of organisms.

6. You probably noticed that your organisms are just popping up all over the place in your grid. This is because by default you have a *well-mixed* spatial structure, kind of like they are all floating in water. To enforce neighbors, change the population structure to a Grid using `SetPopStruct_Grid` in the constructor and see what that looks like:

    ```
    world.SetPopStruct_Grid(num_w_boxes, num_h_boxes);
    ```

7. Remember to `git add *`, `git commit -m "message"` and `git push` so your code is saved since you'll probably want it for the assignment!

## Submission
You aren't required to submit labs in this class, but you can for an extra engagement credit. Complete through exercise 6 and then push it to GitHub:
```bash
git add World.h native.cpp web.cpp Org.h
git commit -m "finished basic Empirical world"
git push
```

## Extensions
If you have extra time, try adding mutation to your organism's reproduction or adding to your organism's `Process` method so that it actually does something based on your instance variable genome. Ideas include:
* Donate resources to another organism
* Spend resources to steal from another organism
* Spend resources to build defense from the environment or other organisms
* Have the shade of the color depend on how many points the organism has or their instance variable genome

You could also try out Empirical's [Canvas image support](https://empirical.readthedocs.io/en/latest/api/classemp_1_1web_1_1Canvas.html?highlight=canvas#_CPPv4IDpEN3emp3web6Canvas5ImageER6CanvasRKN3emp8RawImageE5PointDpRR2Ts) so your organisms can be more than just colored boxes!

## Credit
This lab uses the [cookie-cutter material](https://github.com/devosoft/cookiecutter-empirical-project.git) from [this tutorial](https://mmore500.com/waves/tutorials/lesson02.html) by [Matthew Andres Moreno](https://github.com/mmore500) and [Santiago Rodriguez Papa](https://github.com/rodsan0/)