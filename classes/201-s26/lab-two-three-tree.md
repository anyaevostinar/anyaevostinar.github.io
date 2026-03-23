---
layout: page
title: 2-3 Tree Lab
permalink: /classes/201-f25/two-three-tree-lab
published: true
---

## Goals
To better understand 2-3 Trees by implementing the insert method.

## Setup
[Mount the COURSES drive](scavenger-hunt) and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK/username called `23TreeLab`
* Download the [starter code `TwoThreeTreeLab.kt`](/classes/201-f25/TwoThreeTreeLab.kt) and put it into your 23TreeLab folder
* Open your `23TreeLab` folder in VSCode

## Exercise 1
You will ultimately implement all of the `insert` methods. Note that there are `add` methods already implemented for you that handle the process of splitting nodes and promoting values for you. You are welcome to look at them, but don't worry about understanding them completely (managing the nodes of a 2-3 Tree is complicated!).

a. You'll start by implementing part of `insertHelp`. The first case you should consider is inserting a key into an empty tree. Check if `subroot` is null and if so, set it to be a new `Node` that has the key as the left value (using the provided Node constructor) and return it. (You'll frequently be returning the root, it's part of managing the splitting of nodes.)

b. Compile and run your code to verify that the number 15 is inserted as the left value of the root of the tree:

```bash
-----------------------
 |15-null| 

--------------------------
```

c. The second case you should consider is if the root doesn't have any children (which you can check by just checking if `left` is null, make sure you understand why). In this case, you should call the `add()`, passing the root and a new `Node` with the key as the left value. The `add()` method will take care of either adding the key to open space in the root or creating a child. You should read the documentation for the `add()` method to understand how to use it.

d. Go down to the `main` method and uncomment the next insert line and verify that your code compiles and runs correctly:

```
-----------------------
 |1-15| 

--------------------------
```

You can also compare your tree to this [2-3 tree visualization](https://www.cs.usfca.edu/~galles/visualization/BTree.html). (Sorry that our print method isn't quite as fancy!)

## Exercise 2
Next you will need to handle the cases where the root has children and so you need to recursively call insert on the appropriate one.

a. Start with the case of inserting to the left. You should compare the key to left value of the root and if the key is less than the left value of the root, you should call the `insertLeft` method.

b. In the `insertLeft` method, you should first call `insertHelp` on the root's left child and the key. You should save what is returned from this call because it will be the new left child of the root.

c. You should then check if the thing returned is the same object as the root's current left child (using `==`). If it is, that means that the left child didn't need to split to insert the key and you can just return the root and be done.

d. If the objects are not the same, the left child had to split and the node returned contains the promoted value that will need to be added to the root. Call the `add` method on the root and pass the new left child. You can't just set the child yourself because the values of the split left child may need to be shuffled around, which `add` takes care of for you.

e. Look at the possible values that you could add in the `main` method and choose a line(s) to uncomment that will use your `insertLeft` method and verify that your code compiles and runs correctly.

```bash
-----------------------
 |1-null| 
 |0-null|  |15-null| 

--------------------------
```

## Exerise 3
Next you'll implement the `insertCenter` method.

a. There are two cases when you should call `insertCenter`: if the root doesn't have a right value or if the key is greater than the left value but less than the right value. Add these checks and call `insertCenter` in your `insertHelp` method.

b. `insertCenter` will be implemented the same way that `insertLeft` was implemented: Call `insertHelp` and pass the center child of the root, save what is returned, check if the center child had to split, and if so, use `add` to place the promoted center value into the correct spot.

c. Decide on another line(s) to uncomment in `main` to test your `insertCenter` method and verify that your code compiles and runs correctly, for example:

```bash
-----------------------
 |5-null| 
 |1-null|  |15-null| 

--------------------------
```

## Exercise 4

a. Finally, if the key doesn't go anywhere else, it goes in the right side of the tree. Implement `insertRight` and call it in `insertHelp`.

b. Uncomment the last lines or add additional lines to test your `insertRight` method and verify that your code compiles and runs correctly.

## Submission
Submit your completed 2-3 Tree to Moodle for an extra engagement credit.

## Extensions
If you have extra time, try figuring out how to delete a key from the 2-3 tree.