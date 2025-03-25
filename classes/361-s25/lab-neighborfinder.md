---
layout: page
title: Neighbor Finder
permalink: /classes/361-s25/nf-lab
---

## Goals
Get familiar with using Empirical for visualizations and working with toroidal neighborhood structures.

## Setup
(A lot of this is similar/identical to how you will set things up for your CA homework.)

1. Open the Neighbor Finder Classroom Link (linked on Moodle), which will make a GitHub repository with starter code.

2. Open Terminal and clone your repository:
```
git clone <your repository link>
```

3. Open VSCode and then open your repository folder. 

4. Open a Terminal in VSCode and pull down the submodules for the starter code:
```
git submodule update --init --recursive
```

5. Then, go to the `emsdk` folder and install and activate `emsdk`:
```
cd emsdk
./emsdk install 3.1.2
./emsdk activate 3.1.2
```

6. Then source `emsdk`. You'll need to do this command anytime you open a new Terminal, so if you are getting an error about `emcc` not existing, you probably forgot to do this:
```
source ./emsdk_env.sh
```

7. Verify that everything is set up correctly by going back to the top level of your repository and running the `compile-run.sh` file:
```
./compile-run.sh
```

You will see just a blank page currently if you go to [http://localhost:8000/](http://localhost:8000/), but soon you'll be putting content onto that page!

## Exercise 1

First look through the starter code provided in `NFAnimate.cpp`.
This is the file that you'll be making changes to.

```cpp
#include "emp/web/Animate.hpp"
#include "emp/web/web.hpp"
```

These two lines are including files from the Empirical library that provide a lot of functionality for making animations in the web browser.

```cpp
emp::web::Document doc{"target"};
```

This is a bit of strange syntax, but it is making an object of type `emp::web::Document` called `doc` and passing the constructor the string `"target"` as an argument.
Using the `{}` to pass actual parameters is a shorthand that C++ allows.

```cpp
class NFAnimator : public emp::web::Animate {

};
```

This is declaring your new class `NFAnimator`, which inherits from `emp::web::Animate`.
Within those curly braces is where you'll be defining your code.

```cpp
NFAnimator animator;

int main() {
    animator.Step();
}
```

These lines are declaring and creating an instance of your `NFAnimator` class called `animator` and calling the `Step` method in `main`.
Even though you haven't defined the `Step` method, it is inherited from the parent class.

## Exercise 2

There are a couple of things that you'll need to define to get your Neighbor-finder animation working. 

1. First you need to create an *instance variable* in your `NFAnimator` class that will be your canvas:
    ```cpp
    emp::web::Canvas canvas{100, 100, "canvas"};
    ```

    The first two arguments are the width and height and the third argument is the HTML `id` (don't worry if you don't know what that means, we aren't going to need it).

2. Next, you need to define a constructor for your class and have your `canvas` placed into your `doc`:

    ```cpp
    public: 

        NFAnimator() {
            doc << canvas;
        }
    ```

    You probably recognize the `<<` from how you send things to standard output and the Empirical `Document` class supports the same syntax. Anytime you want to add things to the webpage that you are making, you will use this syntax.

3. To actually see that something is showing up on your webpage, send a quick message to your `doc` after you send the `canvas`:
    ```cpp
    doc << "Hi";
    ```

    Then run the `compile-run.sh` script in the Terminal and make sure that you see your message showing up on the webpage.

## Exercise 3

Time to make a grid of cells! Or just one cell to start...

1. Empirical makes it easy to draw [your typical shapes](https://empirical.readthedocs.io/en/latest/api/classemp_1_1web_1_1Canvas.html#exhale-class-classemp-1-1web-1-1canvas) on the canvas.
To draw a rectangle, you just need to call `Canvas`' `Rect` method:
    ```cpp
    canvas.Rect(0, 0, 10, 10, "white", "black");
    ```

    The first two arguments are the x and y coordinates for the upper left corner (0,0 in this case), the next two arguments are the width and height of your rectangle (10 x 10 in this case), the next argument is the fill color, and the final argument is the line color. 
    All the typical colors are supported, so feel free to play around making a more colorful rectangle!

2. To get a grid of squares, you'll need some nested for loops and to think about how the upper left corner of each square is going to be positioned. 
Remember that the syntax for a for loop in C++ is the same as in Java: `for(int x = 0; x < 10; x++) {}`. (Remember also that you can use Copilot to help, but double check what it suggests!)
See if you can get a grid of cells to show up!

## Exercise 4
You're now ready to find some neighbors!
Create a new method `void FindNeighbors(x, y)` that:
1. Sets the color of the x,y cell to black (just make a new rectangle at the correct location, you can't easily change the color of the existing one).
2. Calculates each of the x,y cell's neighbors and sets them to a different color, for example red.

I recommend you get it working for a cell that is in the middle of your grid first and then figure out how you need to change your code to work for cells along the edge of your grid.
Remember that it's fine to make an inelegant solution first (that probably uses a bunch of if-else statements) and then think about how to revise it to be more elegant.
This is a place where writing a clear comment and leaning on Copilot can be actually quite helpful, so give it a try!

If along the way, you wish you could see the x,y position of each cell, use Empirical's text drawing method:
```cpp
canvas.CenterText(x+5, y+5, std::to_string(x)+","+std::to_string(y), "black", "black");
```

You may also want to use modulus (you can solve the problem with a bunch of nested conditionals, and that's fine, but you can make it more elegant using modulus). [C++ actually does modulus weirdly with negative numbers](https://www.geeksforgeeks.org/modulus-on-negative-numbers/), so you should use Empirical's modulus instead:
```cpp
#include "emp/math/math.hpp"

emp::Mod(x, y); //Will do x % y, handling negative numbers as you would expect
```

## Wrapping up
Make sure to push your code to the remote repository (`git add *`, `git commit -m "message about your code"`, `git push`) both so that I can see how far everyone got and so you will continue to have access to the code.

## Extra
If you finish early, see if you can incorporate an animation into your current visualization. For example, have the focal cell and each neighbor light up one at a time.

To send buttons to your document:
    ```cpp
    doc << GetToggleButton("Toggle");
    doc << GetStepButton("Step");
    ```

And to specify what should happen in each animation frame, you need to override and define your own `DoFrame` method:

```cpp
void DoFrame() override {
        canvas.Clear();
        //Draw something new!
}
```