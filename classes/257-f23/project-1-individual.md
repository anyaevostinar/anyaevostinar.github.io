---
layout: page
title: Individual Deliverable 1
permalink: /classes/257-f23/project-1-ind
---

## Overview

This individual deliverable is focused on assessing your ability to write tests in Python using the 'unittest' module.
You will write tests for the Silly Dataset, however the skills you will practice and demonstrate in this deliverable will be used in the command-line component of your team project.

## Collaboration

You should work individually on this deliverable.
You can get conceptual help from your team and others, however what you submit must be all your own work.

## Due Date

The individual deliverable 1 is due Monday Sept 25th at 10pm on your individual GitHub.

## Your Task

You should write several tests for the Basic Command Line App specified below.
Remember that tests should follow the same design and style principles as production code. You should use the starter structure provided in the Git Classroom Individual Deliverable 1 assignment. You should refer to the [TDD](tdd) lab for tips.

Your tests should be in the `Tests` subdirectory. The grader will assess your tests by placing the app code in the `ProductionCode` subdirectory and then running `python3 -m unittest discover -s Tests` from the top-level of your project folder.

### Specification

The app has the following functions with these exact signatures:

```python
load_data()
'''Arguments: None
Return value: None
Purpose: Loads the data from a file'''

get_cell(row, column)
'''Arguments: row (int), column (int)
Return value: the value at that cell
Purpose: get the value at a specified cell
Raises: IndexError if row or column outside of bounds'''

get_row_titles()
'''Arguments: None
Return: List of row titles
Purpose: Get a list of the row titles
'''

get_row_by_title(title)
'''Arguments: title (string)
Return value: list of values of a row based on the title (yes, a row, not a column as you would expect :) ); if row title isn't in table, returns empty list
Purpose: to get a row based on the first value in that row
'''

get_silly()
'''Arguments: None
Return value: 2
Purpose: just a simple silly method
'''

main()
'''Arguments: None
Return value: None
Purpose: Maintains command line interface, loads data. Usage statement: "Usage: python3 basic_cl.py row column". Prints cell value specified.
'''

```

## Turning it in

You should submit the file(s) with the tests that you wrote to the Individual Deliverable 1 repository.

You shouldn't include any production code; the grader will place my production code into the correct folder.

## Evaluation

The criteria for "Demonstrates Proficiency" and "Demonstrates Mastery" are below.

### Proficiency
* Functionality:
  * The directory structure and filenames are as specified
  * The tests run with production code that has the signature specified above
  * There is one basic unit test for each of the `get` methods (4 tests total)
* Design:
  * Test code is reasonably easy to read and understand
  * There isn't an excessive amount of repeated code
  * Tests have docstrings describing what they are testing

### Mastery
* All the Proficiency criteria are met
* Functionality:
  * One basic unit test for the command line method `main`
  * At least one edge case for `get_row_by_title`, `get_cell`, and `main` (docstring should mention they are edge cases and make clear what edge they are testing)
* Design:
  * The test code is very clear, potentially using helper functions to ensure that test functions are at a single layer of abstraction
  * There is barely any duplicated code
  * Style mostly follows the [style guide](https://peps.python.org/pep-0008/)


  ## Questions
  Here are questions that have previously come up about this assignment:

  * Does `load_data` need a test?

  No, `load_data` doesn't need a specific test.

  * Are the column headers included in the data?

  Yes, the column headers are row 0 of the data and can be accessed as such.