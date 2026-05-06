---
layout: page
title: 2-3 Trees Preparation
permalink: /classes/201-s26/2-3-prep
---

## Overview
The main issue with binary search trees is that they have to be relatively balanced to maintain their efficient time complexity and keeping them balanced can be complicated. There are many solutions to this issue, and for today you'll read about two of them.

## Basic Learning Objectives
Before class, you should be able to:
* Explain the high-level idea of an AVL tree
* Explain what nodes in a 2-3 tree consist of
* Explain at a high-level how values are added to a 2-3 tree

## Advanced Learning Objectives
After class, you should be able to:
* Implement a basic 2-3 tree

## Resources
You should read the following:
* [8.6 Balanced Binary Search Trees](https://runestone.academy/ns/books/published/kotlinds/trees_balanced-binary-search-trees.html?mode=browsing) - this section introduces one idea for how to balance a BST, the AVL tree
* [OpenDSA 12.5 2-3 Trees](https://opendsa-server.cs.vt.edu/OpenDSA/Books/CS3/html/TwoThreeTree.html) - this is a section from a different book that introduces a different way of achieving a balanced search tree: a 2-3 Tree. Note you can skip the Java code, but the walk through diagrams are nice, make sure click through the arrows to see the visualizations!

## Checks
Submit answers to the following to Moodle.
    
1. Given the following 2-3 tree:
    ![Diagram of 2-3 tree](/classes/201-f25/2-3treecheck.png)

    Draw the tree after adding each of the following. Your subsequent trees should include the previous additions, so you should draw out three trees, the first with 4 keys, the second with 5 keys, the third with 6 keys.
    * 5
    * 3
    * 9

2. There is a certain amount of inescapable complexity required to implement a self-balancing search tree. You've read about two (and there are many more variations). Compare and contrast the high-level ideas of how AVL trees and 2-3 trees maintain balance and what functions and properties are more complex in order to achieve that balance. Aim for 2-3 sentences.

