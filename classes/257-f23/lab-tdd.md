---
layout: page
title: Test-Driven Development
permalink: /classes/257-f23/tdd
---

## Goal
Engage in test-driven development as you start on the team and individual deliverables for your command-line component of your project. Get a good start on [Individual Deliverable 1](project-1-ind).

## First Though

You should already have an Individual Deliverable 1 and team deliverable git repo setup. If you haven't finished the Git setup from the previous lab, go do that.

## Overview
In this lab, you'll practice test-driven development to get started on your [first individual deliverable](project-1-ind).

## Step 1: A First Failing Test
In TDD, you always want to start with a failing test: 
* In your Individual Deliverable 1 repository, in the `Tests` folder, make a Python file with a name that starts with `test`
* Add the following boilerplate code:
    ```
    import unittest

    if __name__ == '__main__':
        unittest.main()
    ```
* Verify that this runs and prints "OK"
* Try to import your production code file with the following line:
    ```from ProductionCode.basic_cl import *```
* Verify that your tests now crash

## Step 2: Passing that test
Awesome, you have a failing test, great job! The reason your code is crashing is because Python is a bit odd about handling code in subdirectories, but we want to keep things nicely organized. Therefore, to run your tests for real, you will need to use some special functionality of `unittest`, i.e. its ability to discover tests and handle subdirectories during that process. 

* To run your tests type the following:
```python3 -m unittest discover Tests/```
* Verify that 0 tests have run OK

## Step 3: Writing a real failing test
Okay, fine, that wasn't very exciting and was probably taking TDD too far, but it's a good example of how you should go about this.
To get to your first real failing test case, you'll need to make a tester class in your test file:

```
class TestSOMETHING(unittest.TestCase):
    def test_A_GOOD_NAME(self):
        """ A GOOD DOCSTRING """
        # test one of the functions
```

(You should change the things that are all caps.)

* Write the actual test
* Verify that it fails

## Step 4: Repeat
You shouldn't write any production code for this deliverable. Instead, you should think carefully about the tests that would test the functionality of the function signatures in `ProductionCode/basic_cl.py` based on the data in `Data/dataset.csv`. The function signatures are also specified in the [Individual Deliverable 1](project-1-ind) details.

You should aim to complete as much of the requirements for the first individual deliverable as you can in class!

## Command-line testing
Testing command-line functionality is much trickier than at the function level. 
You need to use the [`subprocess`](https://docs.python.org/3/library/subprocess.html) Python module to do so. 
Here is an annotated example of a test for checking if an intro assignment has produced the correct output:

```python
def test_caesar_normal(self):
    """Check if caesar.py works for valid command line arguments"""
    #First use subprocess to make the command line call
    code = subprocess.Popen(['python3', '-u', 'caesar.py', "This is the way the world ends, dontcha know?", '25'], #give it a list of the exact things you want to be "typed" on the command line, -u keeps stdout unbuffered so it goes through all at once
                            stdin=subprocess.PIPE, stdout=subprocess.PIPE, #you are piping stdin and stdout so subprocess can use them
                            encoding='utf8') #use the normal utf8 text
    output, err = code.communicate() #interact with the process, which runs it, and save the things returned to output and err
    self.assertEqual(output.strip(), "Sghr hr sgd vzx sgd vnqkc dmcr, cnmsbgz jmnv?") #strip extra whitespace from the output and compare it to what you think it should be
    code.terminate() #stop the process to clean up after yourself
```