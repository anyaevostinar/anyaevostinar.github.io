---
layout: page
title: 2-3 Tree Lab
permalink: /classes/201-s26/two-three-tree-lab
published: true
---

## Goals
To better understand 2-3 Trees by implementing the insert method. There are some extensions and applications in the extra if you are curious for more!

## Setup
[Mount the COURSES drive](scavenger-hunt) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK/username called `23TreeLab`
* Download the [starter code `TwoThreeTreeStarter.kt`](/classes/201-s26/TwoThreeTreeLab.kt) and [TwoThreeTreeImplement.kt](/classes/201-s26/TwoThreeTreeImplement.kt) and put them in your folder
* Open your `23TreeLab` folder in VSCode

You'll be filling in methods in `TwoThreeTreeImplement.kt`, but your class inherits from `TwoThreeTreeStarter`, which has some useful methods such as `printTree` as well as the `Node` class that you'll be using in your tree.

## Exercise 1: Finding a leaf
You'll ultimately be completing all the necessary helper methods for `insert` to work correctly (which is in the superclass).
To start, you'll implement `findLeaf`, which finds the leaf where a new key should be inserted.

1. Go down to TEST0 in `main`. This test manually creates a small tree to test `findLeaf`. Draw out this tree on your worksheet and make sure you understand which child each of these calls should return:
    * `testTree.findLeaf(parent0, 16)`
    * `testTree.findLeaf(parent0, -1)`
    * `testTree.findLeaf(parent0, 100)`

2. You'll need to be familiar with aspects of the `Node` class for your implementation. Look in the starter file and find answers to these questions:
    * How are the keys and children of a `Node` stored?
    * How can you determine if a `Node` is a leaf?
    * How can you determine if a `Node` is a 2-node or 3-node?

3. Now you're ready to implement `findLeaf`. Use the answers to these questions to guide you:
    * When do you know that you have found the node to return?
    * When do you know you need to move to each of the children of the current node?
    * What changes if a node is a 3-node instead of a 2-node? How do you know which scenario you are in?

4. Once you have `findLeaf` implemented, uncomment `TEST0` and compile and run your code with:
```bash
kotlinc TwoThreeTreeStarter.kt TwoThreeTreeImplement.kt
kotlin TwoThreeTreeImplementKt
```

## Exercise 2: Split high-level
As you know, 2-3 trees grow by splitting and promoting, so the bulk of the work of `insert` actually will occur in `split`. This implementation handles splitting by first adding the third key to the node and then calling `split`. This exercise will walk you through getting the high-level structure of `split` figured out, before you go implement specific helper functions.

1. Answer these questions as comments in your `split` method:
    * Where should each of the three keys go? Two of them should go into new nodes and one should be promoted, which is which?
    * If the root is splitting, you'll need to make a new root. How do you know if you are currently splitting the root?
    * If you aren't currently splitting the root, you need to delete the current node from its parent. What will you need to put in its place?
    * In the case when you aren't splitting the root, what do you ultimately need to do with that key that should be promoted?

2. You will ultimately be implemented the following helper functions, make notes in your comments of where each of these should be used (there is documentation to give you more information about each if that is helpful):
    * `makeNewRightNode`
    * `makeNewLeftNode`
    * `createNewRoot`
    * `replaceChild`

3. At this point, you can either write out your first draft of `split` (even though the helper functions aren't implemented) or move on to implement the helper functions in the later exercises and come back to split. It is tricky to think about how to use a function before it exists, though it is good practice to try!

## Exercise 3: Making new nodes
As you know, you'll need to make new children nodes during a split. Note that `Node` has a useful function `addChild` that handles updating the `parent` as well. 

1. Implement the functions `makeNewRightNode` and `makeNewLeftNode` by answering the following questions:
    * What key from `splitNode` should be going into each new node?
    * Which children, if any, from `splitNode` should be going into each node and how do you know if there even are any?

2. Uncomment `TEST1` and `TEST2`, recompile and run your code to see if your functions are working correctly.


## Exercise 4: Replacing a node
Next, you'll need to replace the split node with the newly created nodes with `replaceChild`. You'll likely find the `indexOf(element)` and `removeAt(index)` list functions useful for this part. Also note that `Node`'s `addChild` takes an optional `index` second parameter if you want to add the child at a specific index location.

1. Answer these questions to guide your implementation:
    * Where should the new left and right nodes go in the parent's children list if the split node was a right node?
    * What about if the split node was a left node?
    * Could it be the case that the split node is a center node at this point?

2. Uncomment `TEST4`, recompile, and run your code to see if your `replaceChild` is working as expected. There isn't test code for testing the `makeNew` functions combined with `replaceChild`, but there could be. Try it out if you are curious.

## Exercise 5: Splitting the root
As you know, 2-3 trees grow by splitting the root and growing up, so now it's time to implement `createNewRoot`. 

1. Answer the following questions to guide your implementation:
    * What should be the key of the new root?
    * What should be the children?
    * How do you attach the new root to the tree instance?

2. Uncomment `TEST5` to directly test your `createNewRoot`

3. At this point, you need to revisit your `split` and either complete it or check if it needs updating based on your improved understanding of the helper functions.

4. Uncomment the rest of the tests to verify your entire `split` works!


## Submission
Submit your completed 2-3 Tree to Moodle for an extra engagement credit.

## Extra 0
In reality, we usually want a search tree because we want values associated with each key. Update your code to have an `Entry` class that holds a key/value pair and replace all your `Int` keys with `Entry`. You'll need to make sure to compare the keys within your `Entry`s or make `Entry` `Comparable`.

## Extra 1
Balanced search trees are critical when you want to do fast range look ups. Implement a `getRange(min: Int, max: Int): List<Int>` method for your 2-3 tree that leverages the tree's structure to get the range without doing a full traversal.

## Extra 2
A B+ Tree is an extension of a 2-3 tree that stores all data in leaf nodes, links the leaves together as a linked list, and uses the non-leaf nodes as guideposts to enable O(log n) searching:

![A B+ example](https://upload.wikimedia.org/wikipedia/commons/thumb/3/37/Bplustree.png/500px-Bplustree.png)

This structure is used in [many many fundamental systems](https://en.wikipedia.org/wiki/B%2B_tree#Applications), including file system organization, databases, and Internet of Things devices. Try expanding your 2-3 tree to be a B+ tree!

## Extra 3
Try figuring out how to delete a key from the 2-3 tree. Here are some hints:
* You only want to delete from a leaf node, just like you only insert at a leaf node
* If the key is in a non-leaf node, you need to swap with the inorder successor, just like with a BST
* The trickiest part is deleting from a 2-node leaf. In that case, you need to either rotate keys around from a sibling 3-node or merge a sibling and parent key to get a 3-node. The merging, just like splitting, might lead to the parent being underfull, requiring recursive merging. 
* Just like with splitting, you may recursively merge all the way up the tree and need to shrink the root, thus decreasing the height of the tree by one level.