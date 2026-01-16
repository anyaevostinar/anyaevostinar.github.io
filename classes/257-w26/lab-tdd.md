---
layout: page
title: Test-Driven Development
permalink: /classes/257-w26/tdd-lab
---

## Goal
Engage in test-driven development with a simple example. For this lab, you are going to write some basic functions for reversing the words in a phrase, but you are going to write the tests first!

## First Though

1. If you haven't finished the Git setup from the [previous lab](lab-git), go do that. 

2. Remember to activate your [virtual environment](venv-guide) for this class:

```bash
source ~/.venvs/cs257_venv/bin/activate
```

## Step 1: A First Failing Test
a. Accept the assignment by clicking on the `TDD Lab Classroom Link` on Moodle and clone down the repository. 

b. In TDD, you always want to start with a failing test. I've included the start of your test class for you in `test_production.py`. Your first goal is to eventually have a function `reverse_word` that takes a word and returns it reversed. However, you are going to write the test first. Recall that your tests should be structured like this:

```python
class MyFirstTests(unittest.TestCase):

    def test_custom_num_list(self): #method name must start with test
            self.assertEqual(len([1,2,3]), 3) #you should probably test something more interesting than len
```

**Write at least three tests in `test_production.py` in the `TestReverseWord` class.** Remember, you know exactly what a reverse word function should do, so you can definitely write the tests even though you haven't written the production code. (Hint, if I give it "hello", it should return "olleh".)

c. Verify that your tests fail because your function isn't doing what it should do. Excellent, you are now at the "red" stage and can be confident that your tests are actually testing the code. You also have perfect clarity on what your production code should do.

## Step 2: Passing that test
Now you can finally write the code to implement `reverse_word` in `production.py`. There are lots of ways of doing this and this is a place where it's okay to ask your favorite gen AI for its suggestion; you'll be able to check if it is correct! Or brush up on your Python by implementing it yourself.

Verify that your tests are now passing!

## Step 3: Repeat
It would normally be good to have some edge case tests as well, though it's a little tricky to think of edge cases for this function, perhaps the empty string?

In any case, you can move on to a new test class, `TestReverseAllWords` that includes tests for `reverse_all_words(phrase)`, which should take a phrase and return the reverse of each word in the phrase, but leave them in the correct order, i.e. "this is a test" becomes "siht si a tset".

Remember to make sure the tests fail, then write the production code, then verify that they pass.

## Step 4: Command-line testing
You'll also need to test command-line functionality for multiple deliverables.
Testing command-line functionality is a bit trickier than at the function level, though you basically can just treat `main` like a function. (Note that these snippets are outside of a function for brevity, you should put the code in a better location!)

Your goal is to allow the user to enter a phrase at the command line and then print out the phrase in the correct order but with the words reversed.

a. It turns out, you can change the value of `sys.argv` directly:

```python
import sys
sys.argv = ['production.py', 'this is a test'] #setting the command-line argument "this is a test"
```

b. Checking what is printed is a little bit more difficult, but not much. You just change where `sys.stdout` goes so that you can grab the results:

```python
from io import StringIO
sys.stdout = StringIO() #make a StringIO object and have sys.stdout point to it instead of the usual spot

printed_output = sys.stdout.getvalue() #I can get what is printed as a normal string!
```

c. You then can compare `printed_output` to whatever you think should be printed. (Note you should call `main` first, which you can call like any other function.) You should NOT use your `reverse_all_words` function to check against what is printed, why do you think that is?

## Step 5: Coverage checking
When you are writing tests, you want to make sure that you have tests for all lines and scenarios of your code. One tool for making sure you at least execute each line of code (the bare minimum check) is "coverage". Python has a module for automatically checking [coverage](https://coverage.readthedocs.io/en/7.7.1/), which you hopefully already have installed.

a. You run your tests with coverage, so first run this command:
```bash
python3 -m coverage run --source production -m unittest discover Tests
```

Note that it is `production` not `production.py`, but if it was a folder, it would be `ProductionCode`.

This runs the tests while collecting coverage data, so it will just tell you that the tests passed as usual.

b. To see the coverage data:
```bash
python3 -m coverage report -m
```

This will tell you what percentage of lines of the file were called during the tests and which lines weren't called. You should aim for 100% coverage in this lab.

## Step 6: Push to Classroom

You should now (if you hadn't already) push your code to the remote repository. I have it set up to automatically run your tests, check style, and check coverage, just like it will for the deliverables. Make sure that you understand the results that you are getting and check out the [GitHub Tests](/classes/257-s25/test-guide) and [PR](/classes/257-s25/pr-guide) guides.

## Start on ID1
You are now all set to start on [Individual Deliverable 1 - Tests](project-1-ind)

