---
layout: page
title: Empirical Introductory Lab
permalink: /classes/361-f22/empirical_intro_lab
---

## Goals
To use Empirical to create a simple artificial ecology simulation.

## Setup
Open the Empirical World Lab assignment on Moodle to get the Git repository template. You'll need to do the [usual setup](gradient-lab) of the submodules and emscripten.

Also open [this reference document](/classes/361-w21/empirical_intro) and the [evolutionary algorithm lab](evo_alg_lab) to reference the methods that will be useful.

## Exercise 1
a. The code is currently functional, try it out using the following commands:
```
./compile-run.sh
```

You'll notice some warnings, but you can ignore those for now.

b. Nothing actually prints out currently. Open the file `native.cpp`. This is the file that is run by the above commands. You can see that currently it just includes some files, makes a random number generator and a world object, but nothing else.

c. The first thing we need to do is create an organism that can be added to the world. Take a look at the `Organism` constructor in `Org.h` to see what arguments it currently takes and create an organism in `native.cpp` and `Inject()` it into the world:

```cpp
Organism* new_org = new Organism(&random);
world.Inject(*new_org);
```

You can double check that your organism has made it into the world by printing out the world's size:

```cpp
std::cout << world.size();
```

d. If you didn't add any more organisms or do anything else, your world would just have space for one organism. To force your world to have room for your population to grow, use the `Resize()` method:

```cpp
world.Resize(10, 10);
```

e. Verify that you have a population of one living organism in your world by printing out the result of `world.GetNumOrgs()`. Compile and run your code using the same commands from (a).

## Exercise 2
Now it's time to actually make time proceed for your world. 

The starter code has a simple `Update` method in your world that doesn't do much other than call the superclass' method. 

1. Add to this method so that it goes through every organism in the population and calls their `Process` method. You can get the size of the world with `GetSize()` and the population of organisms is stored in the variable `pop`.

2. Go back to `native.cpp` and call your world's `Update` method, then compile and run to see what happens.

3. You should notice that way more than one organism seems to be processing. This is because you need to check if a location is occupied before processing it (there are ghost organisms in all the 'empty' spots). Go back to `World.h` and add a check to your `Update` loop that if a position isn't occupied, it skips that position in `pop`:

    ```
    if(!IsOccupied(i)) {continue;}
    ```


4. Compile and run again to make sure that the correct number of organisms are processing (i.e. just one!).

5. Now you are ready to run for more updates. Write a for loop in `native.cpp` that calls `Update` 10 times.

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

`size_t` is a special type in C++ that stands for "size type" and is appropriate for integers that will always be positive, like sizes and positions in a list.

b. Now you can use a for-loop to loop over the schedule:

```cpp
emp::vector<size_t> schedule = emp::GetPermutation(random, GetSize());
for (int i : schedule) {
    //do stuff
}
```

c. Organisms don't have anyway of gaining points yet though. Change the `Process` method so that it takes an argument `points` and adds those points to what the organism has already. Give them 100 points per update for now. We could call the `CheckReproduction` method right away as well, but this could lead to similar problems mentioned before where some organisms are lucky and get resources and the chance to reproduce right away.

d. Instead, create another schedule and loop after your first one to check reproduction after everyone has gotten resources.

e. Remember that if there is an offspring returned, you'll need to add it to the population with the `DoBirth` method. 

```cpp
emp::Ptr<Organism> offspring = pop[i]->CheckReproduction(); 
//this is implemented in Organism

if(offspring) {
    DoBirth(*offspring, i);  //i is the parent's position in the world
}
```

This is a good time to recompile and run to see your population size increase.

## Exercise 5
Because Empirical supports cross-compiling from C++ to Javascript, you can visualize your simulation without a lot of extra code. The `web.cpp` file contains the typical starter code for a browser visualization that you've seen before. You just need to add a few things from `native.cpp` and draw your rectangles.

1. Create two private instance variables underneath the ones provided for your random number generator and world:

    ```cpp
    emp::Random random{5};
    OrgWorld world{random};
    ```

2. In the constructor for your animator, create your new organism, inject it into the world, and resize the world, just like you did in `native.cpp` (you can literally copy and paste the code!).

3. All the updating logic will go in `DoFrame` but without the for loop. Call your world's `Update` method there.

4. Finally, you'll want to draw your squares for your organisms and loop over the spaces to color them if there is an organism there. You'll need to keep track of where you are in the world's position in addition to your 2D grid:

    ```cpp
    int org_num = 0;
    for (int x = 0; x < num_w_boxes; x++){
        for (int y = 0; y < num_h_boxes; y++) {
            if (world.IsOccupied(org_num)) {
                canvas.Rect(x * RECT_SIDE, y * RECT_SIDE, RECT_SIDE, RECT_SIDE, "black", "black");
            } else {
                canvas.Rect(x * RECT_SIDE, y * RECT_SIDE, RECT_SIDE, RECT_SIDE, "white", "black");
            }
            org_num++;
        }
    }
    ```

5. I've provided you with another file for compiling and running the web version of your code: `compile-run-web.sh`. Run this and make sure that you are getting a growing population of organisms.

6. You probably noticed that your organisms are just popping up all over the place in your grid. This is because by default you have a *well-mixed* spatial structure, kind of like they are all floating in water. To enforce neighbors, change the population structure to a Grid using `SetPopStruct_Grid` in the constructor and see what that looks like:

    ```
    world.SetPopStruct_Grid(num_w_boxes, num_h_boxes);
    ```

7. Remember to `git add *`, `git commit -m "message"` and `git push` so your code is saved since you'll probably want it for the assignment!

## Exercise 6
Organisms just sitting around isn't the most exciting, so how do you get them to move?
It's unfortunately a little bit awkward because Empirical doesn't have the exact built-in functions that we need.

1. First, you'll need to make a new method in your `World` subclass that removes an organism from the population and returns it. I recommend calling it `ExtractOrganism`. You already know how to get an organism at a particular position in the world, and 'removing' it from the population just involves setting its spot to null:

    ```
    pop[i] = nullptr;
    ```

    Then you just need to return the organism that you grabbed.

2. Once you've extracted an organism that you want to move, you need to decide where you want to put it. Assuming that you want to place it in a neighboring location to it according to your grid world structure, you can use `World`'s `GetRandomNeighborPos(i)` which takes the organism's current index location and returns an `emp::WorldPosition` that can be treated as an index location (it's not quite just a number, but you can pass it around like it is).

3. Now you need to put your organism back into the world at the location that you've chosen. You can use `World`'s `AddOrgAt` method to place it at a particular location:

    ```
    AddOrgAt(Organism, position);
    ```

    You'll need to decide if you let an organism move into a space that is already occupied!

4. To test your movement, I recommend preventing reproduction and having just one organism so you can watch them scoot around the grid!

## Exercise 7
For your assignment, you're going to need more than one species. Empirical's `World` can only hold one type, so you have to get a little bit creative to have multiple species and there are two main ways of going about it: an instance variable in `Organism` and subclasses.

1. The instance variable approach is simpler but less elegant, so let's do that first. Create an instance variable `int species` in `Organism` along with a `GetSpecies` method and set the species in the constructor. Make sure your species is set correctly during reproduction too!

2. Update your `.cpp` files so that they make one of each species to start.

3. Update your `web.cpp` so that it draws a different color rectangle based on the species of the organism and make sure that you are seeing your two species. You'll find the `GetOrg(position)` method of `World` helpful for this.

4. Species aren't interesting if they don't do something different, so make a conditional statement in `Process` and/or `CheckReproduction` so that something is different based on the species. Maybe one of your species doesn't get all the points each update or takes more points to reproduce.

5. Make sure that you are seeing the difference between your species' behavior in the web GUI.

## Exercise 8
Having to use conditionals to check on the species all over the place is very inelegant and this is a perfect situation for inheritance! Create two subclasses (probably in their own files) that inherit from `Organism` and move your different behaviors into those files. You'll need to think about what can be shared in the superclass and what needs to be defined in the subclasses. You'll also need to update your `.cpp` files so that they create the correct types of organisms. 

## Extensions
If you have extra time, try adding mutation to your organism's reproduction or adding to your organism's `Process` method so that it actually does something based on your instance variable genome. Ideas include:
* Donate resources to another organism
* Spend resources to steal from another organism
* Spend resources to build defense from the environment or other organisms

You could also try out Empirical's [Canvas image support](https://empirical.readthedocs.io/en/latest/api/classemp_1_1web_1_1Canvas.html?highlight=canvas#_CPPv4IDpEN3emp3web6Canvas5ImageER6CanvasRKN3emp8RawImageE5PointDpRR2Ts) so your organisms can be more than just colored boxes!

## Credit
This lab uses the [cookie-cutter material](https://github.com/devosoft/cookiecutter-empirical-project.git) from [this tutorial](https://mmore500.com/waves/tutorials/lesson02.html) by [Matthew Andres Moreno](https://github.com/mmore500) and [Santiago Rodriguez Papa](https://github.com/rodsan0/)