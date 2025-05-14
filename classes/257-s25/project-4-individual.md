---
layout: page
title: Individual Deliverable 4 - Front-end
permalink: /classes/257-s25/project-4-ind
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

## Due Date

The individual deliverable for this iteration is due **Friday May 16th** at 10pm on the ID4 git repository.

## Your Task

In your ID4 repository, you should write a new Flask app, `app.py` that has a front-end design that follows the best principles for web design and uses **mock data** instead of calling your team's project code. You are welcome to copy over code from your original basic Flask app, but you should ultimately have a single data function in `core.py` that simply returns hard-coded data, allowing you to focus on implementing the front-end design.

### Example
If I was doing this for my books and authors dataset, one of the features that I would be interested in would be allowing the user to get information for any of the books in the dataset via a page for each book. For this assignment, I could focus on creating the book information page for a book that I've previously read, [Ancillary Justice by Ann Leckie](https://en.wikipedia.org/wiki/Ancillary_Justice) (it's great, you should read it).
I would create a function `get_book_data(book_title)` that would do nothing except return a list with the information for this particular book.
In my Flask app, I would call this function and pass it the title and get back the correct result.
I could then focus on making an awesomely designed homepage that indicated to the user that they could get information on all these cool books and there would actually only be the one book that they could choose from, which would then lead them to the beautifully-designed page about that book.
How the user navigates from the homepage to the book page would depend on whether I was going for 'proficiency' or 'exemplary':
* 'proficiency' option: just a good ol' fashioned hyperlink
* 'exemplary' option: a form/dropdown/other interactive option that goes beyond a hyperlink (check with me if you want to do something other than a form/dropdown)

### Specifics
Now that you have that example, here are the specifics of the task to demonstrate proficiency:
* Flask `app.py` that runs and relies on a single dummy function in `core.py`
* Front-end that is designed following the principles of good web design that we've discussed in class
* A homepage and at least one other page that has data from your dataset (but hard coded)
* Navigation between the homepage and the other page can be via hyperlink 

For exemplary you should do at least one of the following:
* Have a fancier way of getting from the homepage to the other page (form/dropdown/something else)
* Have a fancier display of your data other than text ([displaying a plot](https://towardsdatascience.com/how-to-easily-show-your-matplotlib-plots-and-pandas-dataframes-dynamically-on-your-website-a9613eff7ae3) for example); note that adding a static image doesn't count!

For exemplary you also need:
* Explanations in your `README.md` of how your page enables "scanability, satisficing, and muddling through".
* A navigation bar 
* [Matching id tags and labels](https://webaim.org/techniques/forms/controls#input) for accessibility

The grader will grade your assignment by doing the following:
* Pull down your submission for this deliverable from ID4 repository
* Run your new Flask app file `app.py`
* Navigate from your homepage to your other page
* Examine your code for style and requirements

## Turning it in

You should submit the file with your individual front-end app to the ID4 repository.

## Evaluation

### Proficiency Criteria
* Functionality:
  * The Flask app `app.py` works and relies on a dummy function from `core.py`
  * There is a homepage
  * There is at least one additional page that displays hard-coded data from the dataset
* Code Design:
  * The HTML and CSS are in separate files
  * Flask code is reasonably easy to read and understand
  * The Flask app code has appropriate [docstrings](https://peps.python.org/pep-0257/) 
  * The Flask code style check is at 5 or higher

### Exemplary Criteria
* All the Proficiency criteria are met
* Functionality:
  * The site has a navigation bar (feel free to add extra links to dead pages)
  * One of the following:
    * Can navigate from homepage to other page through HTML `form` (which could be drop-down box, text box, etc)
    * Data displayed in format other than text/static images, for example a generated plot, map, or word cloud
  * Accessibility addressed with [matching id tags and labels](https://webaim.org/techniques/forms/controls#input)
* Front-end:
  * `README.md` explains how your page enables:
    * scanability
    * satisficing
    * muddling through
* Code Design:
  * The Flask code style check is at 10
  * HTML only deals with content structure and not any aspect of presentation.
  * All tags used appropriately.
  * CSS clearly captures the look-and-feel of the site and renders correctly.