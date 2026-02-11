---
layout: page
title: Individual Deliverable 4 - Front-end
permalink: /classes/257-w26/project-4-ind
---

## Overview

This is the individual component of the [Front end component](project-4-front-end) of your team's project.
For this component, you need to write a basic front-end for a portion of your website.
Much of this code won't end up in your team's repository because it will be duplicate. 
Instead, the goal is to get you to practice and start thinking about the front-end individually.

## Collaboration

You should work individually on this component.
You shouldn't coordinate with your team, since the goal is that you get practice individually, and so it's fine if there is some duplication.
You can get conceptual help from your team and others, however what you submit must be all your own work.
**What you submit for this component, especially for revisions, cannot duplicate what another team member had previously submitted for the team deliverable. Duplicating another team member's code will be considered academic dishonesty.** You can certainly use your code from this component for the team deliverable though.

## Due Date

The individual deliverable for this iteration is due **Friday February 20th** at 10pm on the ID4 git repository.

## Your Task

In your ID4 repository, you should:
*  write a new Flask app, `app.py` 
* that app should have a front-end design that follows the best principles for web design and 
* you should use **mock data** instead of calling your team's project code
  * i.e. you should have a single data function in `core.py` that simply returns hard-coded data (explained with example below)

You are welcome to copy over code from your ID2 Flask app for `app.py`, since the goal is for you to focus on implementing the front-end design.

### Example
If I was doing this for my books and authors dataset, one of the features that I would be interested in would be allowing the user to get information for any of the books in the dataset via a page for each book. For this assignment, I could focus on creating the book information page for a book that I've previously read, [The Fifth Season by N. K. Jemisin](https://en.wikipedia.org/wiki/The_Fifth_Season_(novel)) (it's great, you should read it).
I would create a function `get_book_data(book_title)` that would ONLY EVER return a list with the information for this particular book, hard-coded.

In my Flask app, I would call this function and pass it the title and get back the correct result.
I could then focus on making an awesomely designed homepage that indicated to the user that they could get information on all these cool books and there would actually only be the one book that they could choose from, which would then lead them to the beautifully-designed page about that book.

How the user navigates from the homepage to the book page would depend on whether I was going for 'core' or 'advanced':
* 'core' option: just a good ol' fashioned hyperlink
* 'advanced' option: a form/dropdown/other interactive option that goes beyond a hyperlink (check with me if you want to do something other than a form/dropdown)

## Turning it in

You should submit the file with your individual front-end app to the ID4 repository.

## Evaluation
The grader will grade your assignment by doing the following:
* Pull down your submission for this deliverable from ID4 repository
* Run your new Flask app file `app.py`
* Navigate from your homepage to your other page
* Examine your code for style and requirements

### Core Criteria
* Functionality:
  * The Flask app `app.py` works and relies on a dummy function from `core.py`
  * There is a styled homepage
  * There is at least one additional styled page that displays hard-coded data from the dataset
* Code Design:
  * The HTML and CSS are in separate files
  * Flask code is reasonably easy to read and understand
  * The Flask app code has appropriate [docstrings](https://peps.python.org/pep-0257/) 
  * The Flask code style check is at 5 or higher

### Advanced Criteria
* All the Core criteria are met
* Functionality:
  * The site has a navigation bar (feel free to add extra links to dead pages)
  * **One** of the following:
    * Can navigate from homepage to other page through HTML `form` (which could be drop-down box, text box, etc)
    * Data displayed in format other than text/static images, for example a generated plot, map, or word cloud
  * Accessibility addressed with [matching id tags and labels](https://www.w3schools.com/accessibility/accessibility_labels.php)
* Code Design:
  * The Flask code style check is at 10
  * HTML only deals with content structure and not any aspect of presentation.
  * All tags used appropriately.
  * CSS clearly captures the look-and-feel of the site and renders correctly.