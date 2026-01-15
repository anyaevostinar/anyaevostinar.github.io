---
layout: page
title: Mutating Lists Preparation
permalink: /classes/111-w26/mutating-lists-prep
---

<script type="module" src="https://pyscript.net/releases/2025.11.2/core.js"></script>

## Overview
Many problems are best solved by making changes to an existing lists or *mutating* it. Because lists are *mutable*, there are some complications and additional considerations for working with them, which will be the focus of today. We'll also discuss the main way that strings differ from lists: they are *immutable*.

## Basic Learning Objectives
Before class, you should be able to:
* Explain what *mutable* means
* Change the contents of a list using indexing, slicing, deleting, and appending

## Advanced Learning Objectives
After class, you should be able to:
* Draw a reference diagram to explain changes to a simple list
* Use the accumulator pattern to build up lists and strings
* Use a simple nested list
* Explain what *immutable* means

## Resources
You should read/watch the following and complete the embedded checks [through Moodle](https://moodle.carleton.edu/mod/lti/view.php?id=967831):
* [9.1 Transforming Sequences](https://runestone.academy/ns/books/published/foppff/transforming-sequences_introduction-transforming-sequences.html?mode=browsing)
* [9.2 Mutability](https://runestone.academy/ns/books/published/foppff/transforming-sequences_mutability.html?mode=browsing)
* [9.3 List Element Deletion](https://runestone.academy/ns/books/published/foppff/transforming-sequences_list-element-deletion.html?mode=browsing)
* [9.5 Aliasing](https://runestone.academy/ns/books/published/foppff/transforming-sequences_aliasing.html?mode=browsing)
* [9.6 Cloning Lists](https://runestone.academy/ns/books/published/foppff/transforming-sequences_cloning-lists.html?mode=browsing)
* [9.7 Mutating Methods](https://runestone.academy/ns/books/published/foppff/transforming-sequences_mutating-methods.html?mode=browsing)
* [9.8 Append vs Concatenate](https://runestone.academy/ns/books/published/foppff/transforming-sequences_append-versus-concatenate.html?mode=browsing)

## Checks
Submit answers to the following on Moodle:
1. Assume I have a list already defined `real_animals` that has at
least 2 items in it (though it could have more). Write a program that changes the first item to the string "unicorn" and the last item to the string "dragon".
    <script type="py-editor">
    real_animals = ["dog", "cat", "horse"] #etc, could be more
    #your edits here
    print(real_animals)
    </script>
2. Checkpoint 9.2.1: What is printed by the following?
    ```python
    alist = [4,2,8,6,5]
    alist[2] = True
    print(alist)
    ```
3. Checkpoit 9.5.2: What is printed by the following?
    ```python
    alist = [4,2,8,6,5]
    blist = alist
    blist[3] = 999
    print(alist)
    ```