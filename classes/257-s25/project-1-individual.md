---
layout: page
title: Individual Deliverable 1
permalink: /classes/257-s25/project-1-ind
---

## Overview

This individual deliverable is focused on assessing your ability to write tests in Python using the `unittest` module.
You will write tests for the Silly Dataset, however the skills you will practice and demonstrate in this deliverable will be used in the command-line component of your team project.

You should have already completed the [Git Practice Lab](lab-git) before starting this.
You should refer to the [TDD Lab](tdd) for help on this assignment.

## Collaboration

You should work individually on this deliverable.
You can get conceptual help from your team and others, however what you submit must be all your own work.

Like all assignments, you are allowed to use GitHub Copilot and Google Gemini when working on this. However, in my experience, Copilot will be the worst kind of team member by pretending it knows the answers but being off in subtle or not-so-subtle ways. Make sure to double check its work!

## Due Date

The this deliverable is due Monday April 14th at 10pm on your individual git repo.

## What to Submit
- [ ] Your modified `test_cl.py` in the `Tests` subdirectory of your individual git repo. Do NOT change anything in the `ProductionCode` subdirectory.

## Your Task

You should write several tests for the Basic Command Line App specified below.
Remember that tests should follow the same design and style principles as production code. 

Your tests should be in the `Tests` subdirectory. When you push changes to your repository, GitHub will automatically run your tests to see if they pass. You will then be able to make any further updates needed.

Specifically:
* Write several tests that would test the functionality of the function signatures of the Basic Command Line App (`ProductionCode/basic_cl.py`) based on the data in `Data/dataset.csv`.
* When thinking about your tests, remember that Python supports negative indexing in lists, i.e. Python will not throw an error with `my_list[-1]`.
* Use the starter structure provided in the Git Classroom Individual Deliverable - Tests assignment
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

def get_row_titles():
'''Arguments: None
Return: List of row titles
Purpose: Get a list of the row titles
'''

def get_row_by_title(title):
'''Arguments: title (string)
Return value: list of values of a row based on the title (yes, a row, not a column as you would expect :) ); if row title isn't in table, returns empty list
Purpose: to get a row based on the first value in that row
'''

def get_silly():
'''Arguments: None
Return value: 2
Purpose: just a simple silly function
'''

def main():
'''Arguments: None
Return value: None
Purpose: Maintains command line interface, loads data. 
Usage statement: "Usage: python3 basic_cl.py row column". 
Prints cell value specified.
If invalid indices are given as command-line arguments, main prints the usage statement 
above.
'''

```

## Turning it in

You should submit the file(s) with the tests that you wrote to the Individual Deliverable 1 repository.

You shouldn't include any production code; the grader will place my production code into the correct folder.

## Evaluation
The criteria for "Proficiency" and "Exemplary" are below. I will put your grade (and only your grade) on Moodle. Because the evaluation criteria exceeds the Moodle character limit, I'll put feedback on your deliverable as a [Pull Request](https://anyaevostinar.github.io/classes/257-f23/pr-guide) on your repo.

### Proficiency
* Functionality:
  - [ ] The directory structure and filenames are as specified
  - [ ] The tests run with production code that has the signature specified above
  - [ ] One standard unit test for each of the `get` methods (4 tests total)
  - [ ] One standard unit test for the command line method `main`
  - [ ] At least one edge case for `get_row_by_title`, `get_cell`, and `main` (docstring should mention they are edge cases and make clear what edge they are testing)
* Design:
  - [ ] Tests have [docstrings](https://peps.python.org/pep-0257/) describing what they are testing
  - [ ] Style - Proficiency test passes

### Exemplary
- [ ] All the Proficiency criteria are met
* Functionality:
  - [ ] Coverage above 90%. See [this guide](test-guide) (step 6) for how to see your coverage.
* Design:
  - [ ] Style - Exemplary test passes
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

See my guide on understanding [GitHub Actions and tests](test-guide).

* I'm not at high enough coverage, but how can I know what to add without seeing the production code?

It is an unusual challenge to hit high coverage without seeing production code, but I believe in you. By testing just standard cases and reasonable edge cases (invalid input to the functions and main, no input at all, etc.), I was able to hit 98% coverage. If you are really stuck, feel free to reach out for a hint.