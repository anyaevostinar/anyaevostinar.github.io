---
layout: page
title: Test-Driven Development
permalink: /classes/257-s25/tdd
---

## Goal
Engage in test-driven development as you start on the team and individual deliverables for your command-line component of your project. Get a good start on [Individual Deliverable 1](project-1-ind).

## First Though

If you haven't finished the Git setup from the [previous lab](lab-git), go do that.

## Overview
In this lab, you'll practice test-driven development to get started on your [first individual deliverable](project-1-ind).

## Step 1: A First Failing Test
* Accept the assignment by clicking on the `Individual Deliverable - Tests Assignment` on Moodle and clone down the repository.

In TDD, you always want to start with a failing test: 
* In your Individual Deliverable 1 repository, navigate to the `Tests` subdirectory
* Run `test_cl.py` and verify that this runs and prints "NO TESTS RAN"
* Try to import your production code file with the following line:
    ```from ProductionCode.basic_cl import *```
    (As a Python refresher, this line imports all the functions ( `*` or the asterisk means all) from `basic_cl` in the `ProductionCode` folder)
* Verify that your tests now crash with a `ModuleNotFoundError`

## Step 2: Passing that test
Awesome, you have a failing test, great job! The reason your code is crashing is because Python is a bit odd about handling code in subdirectories, but we want to keep things nicely organized. Therefore, to run your tests for real, you will need to use some special functionality of `unittest`, i.e. its ability to discover tests and handle subdirectories during that process. 

* Navigate back to your top level directory
* To run your tests type the following:
```python3 -m unittest discover Tests/```
* Verify that 0 tests have run OK

## Step 3: Writing a real failing test
Okay, fine, that wasn't very exciting and was probably taking TDD too far, but it's a good example of how you should go about this.
To get to your first real failing test case, you'll need to make a tester class in your test file:

```python
class TestFUNCTION_NAME(unittest.TestCase):
    def setUp(self):
         load_data() # Loads data before each test 

    def test_A_DESCRIPTIVE_NAME(self):
        """ A DESCRIPTIVE DOCSTRING """
        # test one of the functions
```

(You should change the things that are all caps.)

* Write the actual test
* Verify that it fails by running it locally

## Step 4: Write tests for Basic Command Line App
You are all set to get started on the [Tests Individual Deliverable](project-1-ind).
Remember: you shouldn't write any production code for the first individual deliverable. Instead, you should think carefully about the tests that would test the functionality of the function signatures in `ProductionCode/basic_cl.py` based on the data in `Data/dataset.csv`. The function signatures are also specified in the [Individual Deliverable 1](project-1-ind) details.

You should aim to complete as much of the requirements for the first individual deliverable as you can in class!

## Step 5: Command-line testing
You'll also need to test command-line functionality for multiple deliverables.
Testing command-line functionality is a bit trickier than at the function level, though you basically can just treat `main` like a function. (Note that these snippets are outside of a function for brevity, you should put the code in a better location!)

1. It turns out, you can change the value of `sys.argv` directly:

```python
import sys
sys.argv = ['basic_cl.py', '1', '1'] #setting the command-line arguments to 1 1
```

2. Checking what is printed is a little bit more difficult, but not much. You just change where `sys.stdout` goes so that you can grab the results:

```python
from io import StringIO
sys.stdout = StringIO() #make a StringIO object and have sys.stdout point to it instead of the usual spot

printed_output = sys.stdout.getvalue() #I can get what is printed as a normal string!
```

3. You then can compare `printed_output` to whatever you think should be printed. (Note you should call main first, which you can call like any other function.)