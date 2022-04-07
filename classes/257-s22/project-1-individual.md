---
layout: page
title: Project Version 1 - Individual
permalink: /classes/257-s22/project-1-ind
---

## Overview

This is the individual component of the [command line iteration](project-command-line) of your team's project.
For this component, you need to write some of the unit tests for your team's project.
These tests should end up in the test suite submitted for your team's deliverable, but you will submit them in your individual repository as well.

## Collaboration

You should work individually on this component, though you should coordinate with your team to ensure that you are not duplicating effort and that your tests will work for the interface that you all decide on.
You can get conceptual help from your team and others, however what you submit must be all your own work.

## Due Date

The individual deliverable for this iteration is due Monday April 18th at 10pm on your individual GitHub.

## Your Task

You should write 3-5 tests for your team's project (about 1/4).
These tests should include **at least one typical case and one edge/boundary case**.
Ideally these tests will be all for the same feature, but if that doesn't work out based on how your team project is organized, that's okay.
Remember that tests should follow the same design and style principles as production code.

## Turning it in

You should submit the file(s) with the tests that you individually wrote to your individual deliverables repository with the tag `tests` by typing the following:

```
git tag -a tests -m "tests for command line interface"
git push origin tests
```
You shouldn't include the production code, the grader will pull down both the team's production code and your test suite.

## Evaluation

The criteria for "Meets Expectations" and "Exceeds Expectations" are below.

### Meets Expectations Criteria
* Functionality:
* * The tests work with the team's production code
* * There are a sufficient number of tests
* * There is at least one typical case and one edge case tested
* Design:
* * Test code is reasonably easy to read and understand
* * There isn't an excessive amount of repeated code
* * Style mostly follows the [style guide](https://peps.python.org/pep-0008/)

### Exceeds Expectations Criteria
* All the Meets Expectations criteria are met
* Functionality:
* * Dummy data is used well to improve clarity and efficiency
* Design:
* * The test code is very clear, potentially using helper functions to ensure that test functions are at a single layer of abstraction
* * There is barely any duplicated code