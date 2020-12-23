---
layout: page
title: First Evolutionary Algorithm
permalink: /classes/361-w21/evo_alg_lab
---

## Goals
To learn about evolutionary algorithms by making your own. Also to get more C++ practice.

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Friday Jan 8th, but it isn't due until Monday Jan 11th at 5:00pm Central.

You'll complete most of the lab on HackerRank because they have great built-in test suites. You'll then copy and paste your solutions into Repl.it to save, download, and submit on Moodle.

## Setup
Open the Evolutionary Algorithm project on Repl.it for starter code.

Create you Collaborations.txt document and enter in any sources of help you get on this lab including websites and people.

## Exercise 1
Recall that the necessary pieces for evolution by natural selection to occur are:
* Variation
* Inheritance
* Competition
* Time

Today you'll make a super simple instance of evolution of creatures that simply have a number and the higher the number, the better they are able to survive. This is obviously not a very interesting problem, but you will be able to imagine how you could change this to a more interesting behavior in the future.

a. First you'll need an `Organism` class that has an instance variable `double behavior` and a constructor that takes a `double` and sets the instance variable.

Remember that in C++, you specify public/private like this:
```
class Organism {
  public:
    ...
};
```

b. As you learned, evolution doesn't occur at the level of the individual, and so we'll need a way to hold a population of organisms. While C++ has a built-in vector that is similar to the lists and ArrayLists you've seen before, we'll use an enhanced version from the Empirical library (you'll learn more about Empirical in the future).

In `main`, create an `emp::vector<Organism>` called population.

c. Then fill your population with 100 `Organism`s with all the same starting behavior value. You add an item to a vector like this:
```
population.push_back(*new Organism(0.5));
```

(Note that you could have a vector of `Organism*` instead if you wanted and we will in the future, just trying to keep things simple for now.)

d. Print out the behavior of an organism in your population to see that everything is working. Make sure your code compiles and runs. You may see some warnings which you can ignore for now. 

## Exercise 2
Evolution requires inheritance to occur, so we'll need a way for organisms to reproduce and pass on their behavior value.

a. Create a `reproduce` function in your `Organism` class that returns a pointer to an `Organism` and takes no arguments currently.

b. In that function, create a new organism with the same behavior value as the parent and return it.

c. Verify that your reproduction function works by calling it on an Organism in your population in `main` and printing the parent and offspring's addresses and behaviors. Compile and run your code at this point.

## Exercise 3
We also need competition and time for our organisms.

a. In `main` create a for-loop that loops 100 times, which we'll call 'updates'. In more complicated programs, organisms would do some behavior every update, but currently they don't actually do anything.

b. To create competition, we need to compare the organisms' behavior values and find the best. You can loop through Empirical vectors easily like so:
```
for(Organism j : population) {
  ...
}
```

Loop through every organism in the population and find the organism with the maximum behavior. You'll want to start by declaring a variable to hold the organism with the current maximum that you can then compare to in the loop.

c. Once you find the organism with the maximum behavior value, call its reproduce method and save that new organism.

d. We don't want to just add the offspring to the end of the vector since then the population would just grow and there wouldn't actually be competition. For evolution to occur, organisms must die. You could go through again and find the minimum behavior value organism, but the first organism in the population will be fine for the moment:
```
population[0] = *new_org; //or whatever you named your new organism
```

e. Print out the size of your population using the `.size()` method after running your updates to see that it stays the same. Compile and run your code at this point.

## Exercise 3
If we left things there, we couldn't get evolution because all your organisms are the same and reproducing clones. To introduce variation, we need to be able to mutate the organisms. (We'll be focusing on a single organism reproducing 'asexually' for the most part in this class to keep things simple.)

a. To mutate organisms, you'll need access to randomness. C++ has built-in randomness of course, but Empirical provides useful tools for this as well. In `main`, create a random number generator like so:
```
emp::Random random(1); //create an object of type emp::Random called random
//and pass 1 as an argument to its constructor
//this is c++ shorthand for emp::Random random = *new emp::Random(1);
```

b. Now create a function in your `Organism` class called `mutate` that doesn't return anything but receives an `emp::Random` as input. 

c. There are a whole lot of ways of mutating organisms and whole dissertations have been devoted to what the 'best' way is. A generally good way to mutate a value that is of type double is to pull a random number from a [normal distribution/bell curve](https://en.wikipedia.org/wiki/Normal_distribution) that is centered at 0. This means that you are just as likely to mutate up as down and mutations will generally be small but have the chance at being large, which is fairly biologically accurate.

This is such a common task that Empirical provides a function for it:
```
random.GetRandNormal(0.0, 0.002); //pull a random number from a normal
//distribution with a mean of 0 and a standard deviation of 0.002.
```
Add the random number you get to the organism's `behavior` value.

d. We probably want to use our new-found power in several places. The most critical is in `reproduce`. Add an argument to `reproduce` that is of type `emp::Random` and pass the `random` that you made in `main` to `reproduce` when you call it. 

e. Within reproduce, mutate the offspring after you create it and before returning it. Remember that in C++, you use the `->` syntax to call the functions of pointers:
```
offspring->mutate(random);
```

e. Outside of your for-loop in `main`, again trace through your population to find the organism with the maximum behavior value and print it out. Compile and run your code to see what max you reach. It probably won't be very high since we don't have a whole lot of variation being introduced and are only running for 100 updates. Increase the number of updateds to 10,000 and see what you get.

Congrats, you have made your first functional evolutionary algorithm!

## Exercise 4
It is really not ideal to always be only overwriting the first organism in the population, so let's fix that really quick.

Empirical has a function for getting a random unsigned (ie always positive) integer:
```
int overwrite = random.GetUInt(0,100);
population[overwrite] = *new_org;
```

## Submitting
Empirical is way too big to zip and upload to Moodle regularly, so we're going to try out Repl.it's submission functionality. Click 'Submit' in the upper right corner of your project and on Moodle paste in the link to your project.

## Extensions
If you have extra time, there are lots of improvements that could be made to this small project, including:
* You can use your mutate function to mutate the organisms you start your population with to speed up evolution
* Try switching the 'fitness' determination to something more interesting like the solution to a math problem
* Try switching the whole problem to something more interesting like a string of 1's and 0's and the organisms have to get some specific pattern that you choose.




