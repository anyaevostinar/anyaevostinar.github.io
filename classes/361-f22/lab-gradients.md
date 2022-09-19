---
layout: page
title: Gradient Lab
permalink: /classes/361-f22/gradient-lab
---

## Goals
This lab is focused on some advanced features of Empirical, specifically how to generate more than the basic colors and animate a web build, to enable the creation of continuous cellular automata.

## Setup
Follow the same set up as all the recent work:

1. Open the Gradient Lab Github classroom assignment (linked on Moodle), which will make a GitHub repository with starter code.

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

You will see just a blank page currently if you go to [http://[::]:8000/](http://[::]:8000/), but soon you'll be putting content onto that page!

## Exercise 1
This time, your code will go in `GradientAnimate.cpp` but it is completely blank.

1. Whenever you make a web GUI with Empirical, you'll need to include the two files you've already seen:

```
#include "emp/web/Animate.hpp"
#include "emp/web/web.hpp"
```

2. You'll also always need a `Document` as a global variable:
```
emp::web::Document doc{"target"};
```

3. Now declare your `GradientAnimator` class that inherits from `emp::web::Animate`. If you don't remember that syntax, feel free to check the [Neighbor Finder lab](nf-lab).

4. After your class, you'll need to create an instance of your class and make a main method that calls the `Step()` method of your class.

5. This is a good time to make sure that everything builds by running the provided `compile_run.sh`.

## Exercise 2

1. You'll again need a `Canvas` to draw on and a constructor for your class. Create those now (and check the previous lab if you aren't sure what to do).
Also send your canvas to your document with the `<<`.

2. Since we'll be aiming to animate this time, you'll want some buttons to control turning the animation on and going one step at a time. Fortunately, Empirical provides built-in buttons for just those purposes that are already hooked up to control the animation once you put them in your document:
```
doc << GetToggleButton("Toggle");
doc << GetStepButton("Step");
```

3. Next you need a `DoFrame` method, which is what is called at each step of the animation. This is a `void` method that takes no parameters.

4. In your `DoFrame` method, you will eventually draw some shapes, but to get a basic idea of how it works, create a instance variable (up above the constructor) to just hold a number. In `DoFrame`, first clear the canvas with `canvas.Clear();`, then increment your number variable. Then add a `Text` object to your canvas with your number:
```
canvas.Text(*new emp::Point(10,10), std::to_string(number));
```

Verify that each time you step, your number increases.

## Exercise 3

To create a continuous cellular automaton, you will need to have more colors than the typical color words describe.
Fortunately, Empirical lets you color your shapes with any color using the `ColorRGB` and `ColorHSV` functions.
We'll focus on HSV, since it makes greyscale easier to depict, but you could also use RGB if you want.

1. Get rid of the incrementing number and instead draw a rectangle on your canvas with the color specified as a shade of grey using HSV:

    ```
    canvas.Rect(10, 10, 10, 10, emp::ColorHSV(0, 0, 0.5), "black");
    ```

    [HSV](https://en.wikipedia.org/wiki/HSL_and_HSV) stands for hue, saturation, and value. You can get somewhat of a greyscale by having the value go from 0 to 1. 

2. Make sure that you are getting a grey rectangle and then try changing your code so that the rectangle gets slightly darker or lighter each step. You will eventually get an assert error when you go beyond 0 to 1, but don't worry about that right now.

## Exercise 4

Time to make a proper grid of cells that you can have change over time.

1. Create an instance variable that is a vector of vectors of floats:

    ```
    std::vector<std::vector<float>> cells;
    ```

2. In the constructor for you animator, set the number of cells you want in the width (`num_w_boxes` in the example) and height (`num_h_boxes` in the example) and set them all to start with 0:

    ```
    cells.resize(num_w_boxes, std::vector<float>(num_h_boxes, 0));
    ```

3. In `DoFrame` make a nested set of for-loops that go through all your cells and draw a rectangle using the `ColorHSV` argument, similar to how you did for the Neighbor Finder Lab, but with the color being based on the cell value instead. Make sure to compile and run to make sure that you see your grid of cells.

4. You probably want to make a couple of the cells a different value to start. In your constructor, set a few of them to be something other than 0 and make sure that that shows up correctly when you compile and run.

## Exercise 5
You're now ready to set an update rule so that your cell values change each step.
There are an infinite number of rules that you could try. Start out by doing something simple like getting the shade to just move horizontally across the screen and then falling off the edge (by having the new cell value determined by its immediate neighbor).

You probably will want another vector of vectors to hold onto the state that things should be in the next time step, so you don't make changes to `cells` while you are still calculating each cell's next value.


