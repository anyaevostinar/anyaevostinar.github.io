---
layout: page
title: SGP-Lite Lab
permalink: /classes/361-s25/sgplite_lab
---

## Goals
To use the SGP-Lite library to create a basic digital evolution system.

## Setup
1. Open the SGP-Lite Lab assignment on Moodle to get the Git repository template. 

2. Open Terminal and clone your repository:
    ```
    git clone <your repository link>
    ```

3. Open VSCode and then open your repository folder. 

4. Open a Terminal in VSCode and pull down the submodules for the starter code:

    ```
    git submodule update --init --recursive
    ```

    (We won't be using Emscripten in this lab so you don't need to set it up.)

## Exercise 1
Much of the starter code should look familiar. In particular `native.cpp`, `Org.h` and `World.h` have mostly functionality that you've seen before. The new files `CPU.h`, `Instructions.h`, `OrgState.h` and `Task.h` add the functionality to allow for self-reproducing computer programs as our organisms. We'll look at those in later exercises. First let's look at the new things in the familiar files.

1. In `Org.h`, you'll notice a method `PrintGenome`, which prints out the organism's computer program in a somewhat user-friendly way.

2. Also in `Org.h`, you'll see `Reset` and `Mutate` methods that just pass along those calls to the organism's CPU. Tracking of points is tracked by the organism's CPU's `OrgState` also.

3. `World.h` is pretty standard with a couple of new methods. `GetPopulation` is just a simple helper method that returns the population vector. You'll implement the `CheckOutput` method in a later exercise. Finally, you'll notice that while the `Update` method calls each organism's `Process`, it handles reproduction slightly differently, using a reproduce queue. This is because the organisms will have to reproduce with an instruction, which adds them to reproduce queue.

## Exercise 2
Nothing actually happens in the experiment so far because the organism `Process` method needs to be implemented.
As the `TODO` says, you need to run the CPU in `Process`.
Note that the `Process` method takes the organism's current location as an argument now, since it is needed for the reproduction queue if the organism does reproduce.

1. If you open `CPU.h`, you'll see the class definition for a `CPU`. It holds a couple of objects from the SGP library and mostly acts as an interface between our code and the SGP code. We aren't going to worry about exactly how a lot of these methods work, but you can see that there is a method `RunCPUStep`, which is what you want to call in `Process`. It takes a number of cycles, which allow one instruction to be run each. In organism's `Process`, call run the CPU for 10 cycles:

    ```cpp
    cpu.RunCPUStep(10);
    ```

2. If you compile and run, your organisms are now able to execute instructions, but they aren't able to gather resources yet, so they won't be able to reproduce or do much of anything.

## Exercise 3
Time to specify a task for the organisms to be rewarded for doing.

1. The `Task.h` file currently only specifies a `Task` class that will end up being a super class. To make a new task, you need to define a subclass of `Task`, which you can do in this same file, after the end of the `Task` class:

    ```cpp
    class Task {
    public:
    virtual double CheckOutput(float output, float inputs[4]) = 0;
    };

    class NewTask : public Task {


    };
    ```

2. The only methods that a `Task` subclass needs to specify is its own version of the `CheckOutput` and `name` methods. The `CheckOutput` method holds the logic for figuring out if the organism actually solved the task. The method needs to return a double, which is the amount of points the organism gets whenever the task is checked. It takes two parameters, the float that the organism outputted, and an array holding the most recent 4 input values the organism received. Within your `NewTask`, start your definition for this method:

    ```cpp
    public:
        double CheckOutput(float output, float inputs[4]) override {

            return 0.0;
        }
    ```

3. Because the organism may have solved the task for any of the most recent four input values, you need to loop over those input values to check against the correct answer. For example, if you were setting up a task where the organism had to produce the square of an input value, you would need to 1) loop over the input array, 2) calculate the square of each input value, 3) check if the output value equals the square:

    ```cpp
    for (int i = 0; i < 4; i++) {
        //For each input value in the array
        //Calculate the square of it
        float square = inputs[i] * inputs[i];

        //Since these are floats, allowing for some floating point error
        if (fabs(output - square) < 0.001) {
            //They squared an input, yey!
            std::cout << "Successfully squared an input!" << std::endl;
            //Give them 5 points for solving this task
            return 5.0
        }
    }
    ```

4. You also need to define the name method for your new task. This just needs to be a method called `name()` that returns a `std::string` that is the name you want to call your task, such as `Square`.

4. You can make as many subclasses of `Task` in this file as you want, but let's stick to one for now and finish setting things up for this one. In `World.h` you need to specify a vector of the tasks that are available for organisms to solve. Create a new instance variable that is a vector of `Task *` and put instances of all of your tasks into it (in this case just one):

    ```cpp
    std::vector<Task *> tasks{new NewTask()};
    ```

5. Finally, you are now ready to implement the `CheckOutput` method of your world. In this method, you should loop through your vector of tasks, call each task's `CheckOutput` method, and add any points that are returned to the organism's state:

    ```cpp
    for (Task *task : tasks) {
      state.points += task->CheckOutput(output, state.last_inputs);
    }
    ```

    (The world's `CheckOutput` method is called by the `IO` instruction and therefore specified in the `Instructions.h` file. This file is a bit complicated, so you don't have to worry about it for now.)

6. Now your organisms should be able to run the instructions in their genomes and get points if they are able to square an input. Even randomly generated genomes are sometimes able to do a simpler task right away, so try running your experiment and see if you get lucky!

## Exercise 4
Your organisms currently don't mutate their programs when they reproduce, so you are just relying on the random starting variation. Changing that isn't too hard fortunately since SGP-Lite already supports mutations for the programs.

1. In `CPU.h`, go to the `Mutate` method where there is a todo about applying mutations. To mutate the whole genome, you just need to call the `ApplyPointMutations` method on the `Program`:

    ```
    program.ApplyPointMutations(0.02);
    //0.02 is percent probability that each bit
    // in the binary representation of the genome is flipped
    ```

2. With mutations occurring during reproduction, it's much more likely that your population will undergo some meaningful evolution and get better at solving your task. If you still aren't getting any solving it though, they might not be reproducing. You can go and give them 1 point just for trying to solve the task by changing the default return value in `NewTask.CheckOutput` to 1.0 instead of 0.0. The population should definitely then be able to grow and eventually solve the task.

## Exercise 5
It's not ideal to only be able to see that an organism solved a task by outputting a string. Eventually, you'll want to be able to check each organism to see if it has ever solved a task.

1. In `OrgState.h`, there is a simple `OrgState` struct that is defined (a struct is like a class but everything defaults to public and some advanced OOP functionality isn't possible). Add a boolean variable to track if this organism has performed the task or not.

2. In `World.h`, change `CheckOutput` so that it changes the `state`'s boolean variable to true if the organism does actually get points for solving the task.

3. In your world's `Update`, add a counter for how many organisms have solved the task and print it out each update so you can see if your population is getting better as a whole. This is a good time to compile and run to see how things are working and do any needed debugging! (You could also make a `DataMonitor` for this instead.)

4. Finally, if you are curious to see what one of your organisms' genomes looks like at the end of your experiment, you can print it out with the `PrintGenome()` method in `native.cpp`:

    ```
    world.GetPopulation()[0]->PrintGenome();
    ```

## Extra
If you finish early, there are lots of other things to try:
* Try making another task that requires more than just one of the input values to complete
* Look through the supplemental material section F of [this paper](https://mmore500.com/pubs/moreno2021case) to see what all the instructions do and [this documentation](https://signalgp-lite.readthedocs.io/en/latest/api/program_listing_file_include_sgpl_library_prefab_CompleteOpLibrary.hpp.html) for how to add more to `Instructions.h`
* Try changing the mutation rate and/or amount of points associated with the task(s) and/or needed to reproduce and see how evolution changes
* Study the `IO` and `Reproduce` instructions and try to make your own new instruction

## Acknowledgements
The starter code for this lab (and the associated homework assignment) was largely written by Sylvie Dirkswager, thanks Sylvie!

