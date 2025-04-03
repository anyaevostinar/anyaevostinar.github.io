---
layout: page
title: Inheritance Lab
permalink: /classes/361-s25/inheritance_lab
---

## Goals
To be able to use inheritance in C++ effectively.

## Setup
1. Open the Inheritance Lab assignment on Moodle to get the Git repository template. 

2. Open Terminal and clone your repository:
    ```bash
    git clone <your repository link>
    ```

3. Open VSCode and then open your repository folder. 

4. Open a Terminal in VSCode and pull down the submodules for the starter code:

    ```
    git submodule update --init --recursive
    ```

    (We won't be using Emscripten in this lab so you don't need to set it up.)

## Exercise 1
For this lab, you'll make an `Animal` superclass and a couple of subclasses of it. Let's start with `Animal`.

1. Make a new file `Animal.h` and define an `Animal` class with a private instance variable `age`:

    ```cpp
    class Animal {
        int age;
    };
    ```

2. Create a constructor for your class and set the age from a parameter. Remember that you can do this in the fancy C++ way like so:

    ```cpp
    public:
    Animal(int _age) : age(_age) {
        //doesn't do anything else
    }
    ```

3. We want to be able to easily tell which class is being accessed, so also make a method `GetType()` that returns the string "Animal":

    ```cpp
    std::string GetType() {return "Animal";}
    ```

## Exercise 2
Now we need to make a subclass to experiment with.

1. Create a new file for a `Dog` subclass. In that subclass, define a `Dog` class that inherits from `Animal` (you'll need to `#include Animal.h` as well):

    ```cpp
    class Dog : public Animal {

    };
    ```

2. Let's have our dog have an additional instance variable `num_spots`. To allow our dog's constructor to set both num_spots and age, we need to take them both as parameters and then set them in two slightly different ways:

    ```cpp
    int num_spots;

    public:
        Dog(int _age, int _num_spots) : Animal(_age), //Calls Animal constructor and gives it age
        num_spots(_num_spots) { //Sets num_spots
            //Doesn't do anything else
        }
    ```

    This code is calling the `Animal` constructor and passing the `_age` variable to it since `Animal` is in charge of that variable. Then it sets the dog specific variable. 

3. Also create a `GetType()` method that returns "Dog" so that we can tell the difference easily.

## Exercise 3
Okay, let's see what we get with this setup.

1. In `main.cpp`, create an Empirical vector of Empirical pointers to `Animal` called `population`:

    ```cpp
    emp::vector<emp::Ptr<Animal>> population;
    ```

2. Create a new `Dog` instance and add it to the vector. Note that because the vector holds pointers to the superclass of `Dog`, it's fine to put `Dog` objects in it:

    ```cpp
    population.push_back(new Dog(5, 2));
    ```

3. While you could get away with just including `Dog.h`, this is a good time to observe and fix one problem you'll eventually run into. At the top of your file, make sure you have included both `Animal.h` and `Dog.h`:

    ```cpp
    #include "Animal.h"
    #include "Dog.h"
    ```

4. Then run the `compile-run.sh` script. You should get an error `redefintion of Animal`. This is because `Animal` is included in `Dog`, and so C++ thinks you are trying to define the `Animal` class twice. The slick way of getting around this is with the use of C++ macros, which are instructions run by the preprocessor. At the top of `Animal.h`, add the following:

    ```cpp
    #ifndef ANIMAL
    #define ANIMAL
    ```

    This macro is saying "check if the ANIMAL name is already defined, if it isn't, define it and run all the following code", which means that if it's already been defined, the code won't run!

5. You also need to close your if at the very end of your `Animal.h` file:

    ```cpp
    #endif
    ```

6. You should now be able to compile and run without a problem.

## Exercise 4
You need to now check which class' methods are getting accessed (and make some fixes).

1. In `main.cpp`, call the `GetType()` method of the only item in your population and print it out:

    ```cpp
    std::cout << population[0]->GetType() << std::endl;
    ```

2. It should be printing "Animal" meaning it's calling the `Animal` method instead of the `Dog` method! Because C++ "bundles" both types together when it makes a subclass object, it is defaulting to the superclass method since that is what the vector knows that it is holding. You can tell C++ that you want it to actually default to the subclass method with the `virtual` keyword. In `Animal.h` add the keyword `virtual` before the return type of the `GetType()` method:

    ```cpp
    virtual std::string GetType() {return "Animal";}
    ```

3. Now when you compile and run, you should get "Dog" printing out. This means that anytime you have a superclass method that you want the base class method to be called instead, you should put `virtual` in front of it.

4. This process only works because these are pointers! If you ever dereference the pointer and save it to an `Animal` variable, C++ cuts off the `Dog` portion. Test this out in `main.cpp`:

    ```cpp
    Animal test = *population[0];
    std::cout << test.GetType() << std::endl;
    ```

## Exercise 5
What about those instance variables that you made? How do the two classes deal with those?

1. If we want to be able to get access to the `age` variable, we'll need an accessor method, since it's private (and should stay that way). Make a `GetAge()` method in `Animal`:

    ```cpp
    int GetAge() {return age;}
    ```

2. What if you want to print out the dog's age? You didn't define a `GetAge()` function for the `Dog` class, but you didn't have to, because the super class is in charge of that! In `main.cpp` call and print out the age of your dog using `GetAge()`:

    ```cpp
    std::cout << population[0]->GetAge() << std::endl;
    ```

    This is the great thing about inheritance: you can have functionality in `Animal` that is shared across all the subclasses (once you have more of them) and only need to implement it once (and you can keep them all in the same vector).

3. What if you wanted to make a custom `GetAge` method for dog, for example to express the dog's age in dog years (multiplied by 7) instead? You can't access the `age` variable directly since it is private to the `Animal` class. Instead, you need to use the same accessor method, but specify that you want to call the super class version in `Dog`'s `GetAge()` method:

    ```cpp
    int GetAge() {
        return Animal::GetAge() * 7;
    }
    ```

4. Try compiling and running your code again. Are you getting the correct age calculation? Probably not if you forgot to go back to `Animal` and put in the `virtual` keyword. Go do that and make sure that you are getting the correct age now.

## Exercise 6
What about when you want your animals to make new animals? Time to make a reproduction method and think more about how subclasses interact with superclasses!

1. Make a virtual `Reproduce` method in the `Animal` class that return a new `Animal` (you could argue that this shouldn't do anything, or throw an exception, but we're assuming that maybe you do want to make just animals sometimes):

    ```cpp
    virtual emp::Ptr<Animal> Reproduce() {
        return new Animal(0);
    }
    ```

2. Go into your `Dog` class and make a `Reproduce` method. It needs to *return* the same type as `Animal`, but it should *make* a dog, because we can again make an actual *instance* of type `Dog`, but pass it around as an `Animal` without a problem. Note also that you can use the `Dog` specific method `GetSpots()` without a problem because it is a `Dog` instance and C++ knows that at this point:

    ```cpp
    emp::Ptr<Animal> Reproduce() {
        return new Dog(0, GetSpots()); //assuming it should have the same number of spots as parent
    }
    ```

3. In `main.cpp`, call the `Reproduce` method of your existing dog and add the offspring to the population, then make sure that it is the correct type:

    ```cpp
    population.push_back(population[0]->Reproduce());
    std::cout << population[1]->GetType() << std::endl;
    ```

## Exercise 7
What if you want to access dog specific methods? While it's generally best to avoid needing to access methods special to the subclasses in this kind of setup, sometimes you need to. Fortunately, Empirical's pointer makes that fairly easy to do.

1. First, let's see the problem. In `main.cpp` try to print the number of spots of your dog:

    ```cpp
    std::cout << population[0]->GetSpots() << std::endl;
    ```

2. You should be seeing an error that `Animal` has no member `GetSpots()`. This is because C++ only knows that this object is of type `Animal`, it doesn't know that it's actually a `Dog`. Because you know for sure that the object is a dog at this point in the code, you can cast it to type `Dog` and then call the `Dog` specific method (you should only do this when you know for sure!):

    ```cpp
    std::cout << population[0].DynamicCast<Dog>()->GetSpots() << std::endl;
    ```

3. You should avoid dynamic casting whenever you can, and instead override methods of the superclass for subclass specific behavior. So for example, we could have a `GetAttributes` method that all `Animals` have and gets whatever the subclass specific attributes are.

## Exercise 8
The big reason that you're going to be wanting to use inheritance is so that you can have objects of multiple different types all in the same vector (the `pop` vector of your world), but you aren't actually doing that right now. Create another subclass of `Animal` and play around with having both it and `Dog`s in the same vector and accessing their methods correctly.