---
layout: page
title: Project Component 1 - Command Line
permalink: /classes/257-w26/project-command-line
---

## Overview

The goal of this component of your project is to create a command-line app to allow a user to interact with your data via the command line.
Your app should also include an automated test suite.

The learning objectives for this subcomponent of your project are to be able to 1) create an automated test suite, 2) create an app with a command line interface, and 3) create code that follows the principles of good function design.

## Collaboration

You should work with your team on this portion of the project.
You are able to get help from outside sources, as specified in the syllabus, but everything that your team submits should be your own.

## Due Date

This subcomponent of your project is due Monday Jan 26th at 10pm on GitHub.

## What to Submit
### Individual
* [Sprint Feedback Form](https://docs.google.com/forms/d/e/1FAIpQLSeA_XztxPcqzW-sx_tPOR2RbZJwBnm9UIp43yekK1VjoB0ljg/viewform?usp=publish-editor)

### Team
On your team repository, you should have (at least) the following files:
- [ ] `command_line.py` 
- [ ] One or more files in `ProductionCode` to support `command_line.py`
- [ ] `test_command_line.py` in `Tests`
- [ ] `README.md`
- [ ] `UserStories.md`

## Your Task

Your team should write a program that:
* Fulfills the user stories that you originally proposed by supporting at least three independent features; each of these features should enable the user to get information from your datasets via the command line interface
* Has a usage statement and help information
* Has an automated test suite with good coverage
* Follows the function design principles and has generally good style
* Has documentation through [docstrings](https://peps.python.org/pep-0257/) and in-line comments where appropriate
* Follows the [recommended Python style](https://peps.python.org/pep-0008/)
* Your README.md needs to include (at least) an example of how to run your code to demonstrate each of your features, i.e.

  ```zsh
  python3 command_line.py --name "Anya"
  python3 command_line.py --color "purple"
  ```
  These may be repeated in a `help` command or separate examples. **You should have examples in both places.**

## Tips
You may find the [`csv`](https://docs.python.org/3/library/csv.html) module useful for dealing with your dataset (assuming it's a `.csv`).

Your command line interface can either use the `sys.argv` list directly or you can use one of the many modules for parsing command line arguments.
The [`argparse`](https://docs.python.org/3/library/argparse.html) module is probably the easiest to use and is standard for all installations of Python. (I recommend against other modules such as Click and Typer since they are more complex than we need.)

You can and should create 'dummy data' that allows you to test your production code more easily and quickly. Make sure to include that dummy data in what you submit.

## Turning it in

Your team should submit this subcomponent of the project on your team repo with the tag `cl` by typing the following:

```bash
git tag -a cl -m "command line interface"
git push origin cl
```

If you forgot to tag your comment, you can [retroactively tag](https://docs.google.com/document/d/1gt8cAmhFV9YxFE5ml2ReiGyVvwoum1MH9L0wzttqdkA/edit?usp=sharing).

## Evaluation

The requirements for "Core" and "Advanced" are below.
When evaluating your project, the grader will consult the GitHub action output regarding tests and style. They will also separately pull down your team's repo, checkout the `cl` tag, and run both your production code and test suite, and further look through your code for style.

#### Core
* Functionality:
  * There is a usage statement in both the README and at the command line
  * The `README` contains specific runnable examples for each feature (these can be repeated in a `help` command)
  * There are three independent features controlled by a command line interface that allows the user to get information from the chosen dataset
  * There is an automated test suite that achieves 75% coverage
* Design:
  * The correct directory structure is used (`Tests` and `ProductionCode`)
  * All style checks have a score of at least 5
  * The functions/methods are mostly written at a single layer of abstraction
  * Function names, return values, and parameters generally follow the principles of good design
  * Function/method [docstrings](https://peps.python.org/pep-0257/) generally provide the required information
  * There isn't an excessive amount of repeated code

#### Advanced
* All the Core requirements are satisfied
* The commit to evaluate is correctly tagged with the tag `cl`
* The `UserStories.md` file contains (at least) three of the user stories from your proposal and information about where their acceptance tests are
  * If you have needed to change your user stories, you need to get approval from Anya
* Functionality:
  * The test suite has over 90% coverage
  * There is comprehensive instruction on how to use the command-line interface in both the README and with a `help` command
  * There are acceptance tests for each user story, which are clearly marked
* Design:
  * All style checks are 9 or above
  * The functions/methods are all written at a single layer of abstraction
  * Function names, return values, and parameters all follow the principles of good design
  * Function/method [docstrings](https://peps.python.org/pep-0257/) all provide the required information
  * There is barely any duplicated code