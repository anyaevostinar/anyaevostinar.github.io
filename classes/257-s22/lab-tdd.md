---
layout: page
title: Test-Driven Development
permalink: /classes/257-s22/tdd
---

## Goal
Engage in test-driven development as you start on the team and individual deliverables for your command-line version of your project.

## First Though
As a team, you should already have come up with the function signatures and command line interface design for your project.
You also should already have an individual deliverables and team deliverables git repo setup.

## Overview
In this lab, you'll practice test-driven development to get started on your individual tests and the team project.

## Step 1: A First Failing Test
In TDD, you always want to start with a failing test: 
* In your individual deliverables repository, make a Python file with a name that starts with `test`
* Add the following boilerplate code:
    ```
    import unittest

    if __name__ == '__main__':
        unittest.main()
    ```
* Verify that this runs and prints "OK"
* Import your (non-existent) production code file
* Verify that your tests now crash

## Step 2: Passing that test
Awesome, you have a failing test, great job! Now it's time to write the bare minimum code that passes that test:
* Make a file for your production code (leave it empty!)
* Verify that your test file now runs and prints "OK"

## Step 3: Writing a real failing test
Okay, fine, that wasn't very exciting and was probably taking TDD too far, but it's a good example of how you should go about this.
To get to your first real failing test case, you'll need to make a tester class in your test file:

```
class TestSOMETHING(unittest.TestCase):
    def test_A_GOOD_NAME(self):
        """ A GOOD DOCSTRING """
        #make a bit of dummy data
        #call your non-existent function
        #check if the result of the call is what it should be
        #   probably using self.assertEqual(something, something_else)
```

(You should change the things that are all caps.)

* Write the actual test
* Verify that it fails

## Step 4: Repeat
Now you are ready to write some real production code, which you'll want to do in coordination with your team to make sure that you all don't end up with horrendous merge conflicts.
At this point, what you do will depend on your project structure, but try to keep writing your individual tests before or shortly after you write production code with your team.

## Where to put this code?
Because of the way that I am assessing you, we're going to have to do some unfortunate copy-and-pasting with your tests.
Your tests should be in both:
* Your team deliverables repo with the rest of the team's tests
* And your individual deliverables repo all on their own

I recommend that you work in your team's repo (since that will have the production code that you'll want to use) and then you copy your tests over to a new file in your individual repository.
Feel free to check with me on if you have things structured correctly.