---
layout: page
title: Individual Deliverable 1
permalink: /classes/257-w26/project-1-ind
---

## Overview

This individual deliverable is focused on assessing your ability to write tests in Python using the `unittest` module.
You will write tests for the Silly Dataset, however the skills you will practice and demonstrate in this deliverable will be used in the command-line component of your team project.

You should have already completed the [Git Practice Lab](lab-git) before starting this.
You should refer to the [TDD Lab](tdd) for help on this assignment.

## Collaboration

You should work individually on this deliverable.
You can get conceptual help from your team and others, however what you submit must be all your own work.

## Due Date

The this deliverable is due Friday Jan 23rd at 10pm in the ID1 - Tests repository **not the TDD Lab repository**.

## What to Submit
- [ ] Your modified `test_cl.py` in the `Tests` subdirectory of your ID1 - Tests repository. Do NOT change anything in the `ProductionCode` subdirectory.

## Your Task

You should write several tests for the Basic Command Line App specified below.
Remember that tests should follow the same design and style principles as production code. 

Your tests should be in the `Tests` subdirectory. When you push changes to your repository, GitHub will automatically run your tests to see if they pass. You will then be able to make any further updates needed.

Specifically:
* Write several tests that would test the functionality of the function signatures of the Basic Command Line App (`ProductionCode/basic_cl.py`) based on the data in `Data/dataset.csv`.
* When thinking about your tests, remember that Python supports negative indexing in lists, i.e. Python will not throw an error with `my_list[-1]`.
* Use the starter structure provided in the Git Classroom ID1 - Tests assignment
* Make sure your tests are in the `Tests` subdirectory. The autograder only will find tests in that directory.
* Remember: You should NOT write any production code for this deliverable.

### Specification

The Basic Command Line App has the following functions with these exact signatures:

```python
def load_data():
    '''Arguments: None
    Return value: None
    Purpose: Loads the data from a file'''

def get_cell(row, column):
    '''Arguments: row (int), column (int)
    Return value: the value at that cell
    Purpose: get the value at a specified cell
    Raises: IndexError if row or column outside of bounds'''

def get_row_by_title(title):
    '''Arguments: title (string)
    Return value: list of values of a row based on the title, 
    i.e. the first cell in the row
    (yes, a row, not a column as you would expect :) );
    if row title isn't in table, returns empty list
    Purpose: to get a row based on the first value in that row
    '''

def main():
    '''Arguments: None
    Return value: None
    Purpose: Maintains command line interface, loads data. 
    Usage statement: "Usage: python3 basic_cl.py row column". 
    Prints cell value specified.
    If invalid indices are given as command-line arguments, 
    main prints the usage statement above.
    '''
```

## Submission

You should submit the file(s) with the tests that you wrote to the ID1 - Tests repository.

You shouldn't include any production code; the grader will place my production code into the correct folder.

## Evaluation
The requirements for "Core" and "Advanced" are below. I will put your grade (and only your grade) on Moodle. Because the evaluation criteria exceeds the Moodle character limit, I'll put feedback on your deliverable as a [Pull Request](https://anyaevostinar.github.io/classes/257-f23/pr-guide) on your repo.

### Core
* Functionality:
  - [ ] The directory structure and filenames are as specified
  - [ ] The tests run with production code that has the signature specified above
  - [ ] One standard unit test for each of the `get` methods (2 tests total)
  - [ ] One standard unit test for the command line method `main`
  - [ ] At least one edge case for `get_row_by_title`, `get_cell`, and `main` (docstring should mention they are edge cases and make clear what edge they are testing)
* Design:
  - [ ] Tests have [docstrings](https://peps.python.org/pep-0257/) describing what they are testing
  - [ ] Style - Core test passes

### Advanced
- [ ] All the Core requirements are met
* Functionality:
  - [ ] Coverage above 90%. See [this guide](/classes/257-s25/test-guide) (step 6) for how to see your coverage.
* Design:
  - [ ] Style - Advanced test passes
  - [ ] Method [docstrings](https://peps.python.org/pep-0257/) all provide the required information (i.e. functionality, arguments if applicable)
  - [ ] There is no unnecessary duplicated code (e.g. please use helper functions, loops, etc to reduce duplicated code)

## Q & A
Here are questions that have previously come up about this assignment:

* Does `load_data` need a test?

No, `load_data` doesn't need a specific test. 

* Are the column headers included in the data?

Yes, the column headers are row 0 of the data and can be accessed as such.

* Is the data 0-indexed or 1-indexed?

Even though the data values are 1-indexed, you should still use Python's typical 0-indexing. The data is just being read into a nested list; nothing fancy!

* It says my tests are failing, but how do I see which one?

See my guide on understanding [GitHub Actions and tests](/classes/257-s25/test-guide).

* I'm not at high enough coverage, but how can I know what to add without seeing the production code?

It is an unusual challenge to hit high coverage without seeing production code, but I believe in you. By testing just standard cases and reasonable edge cases (invalid input to the functions and main, no input at all, etc.), I was able to hit 97% coverage. If you are really stuck, feel free to reach out for a hint (email or DM on campuswire).

* What about negative index values?

Remember that Python can handle negative indices fine, so -1 and -2 and -3 are fine.