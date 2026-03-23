---
layout: page
title: Heaps Lab
permalink: /classes/201-f25/heaps-lab
published: true
---

## Goals
To better understand a heap and priority queue by implementing them.

## Setup
Mount the COURSES drive and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HeapsLab`
* Download the [starter code](/classes/201-f25/HeapLab.kt) and put it into your lab folder
* Open your `HeapsLab` folder in VSCode

## Exercise 1
Let's start by being able to add to our heap with `insert`.

1. If the heap is empty, then just add `newNum` to the list.

2. Otherwise, add to the end of the list and then we'll need to fix the heap.

3. To fix the heap, you need to get the index of the newly added item as well as the index of its parent, which you can get like this:

    ```kotlin
    val parent : Int = (current - 1) / 2
    ```

4. Then you need repeatedly compare the current value to its parent's value and `swap` if the child is larger than the parent (there is a `swap` helper function to use). Think carefully about what your loop's stopping conditions should be.

5. Test out your code with the test code in main.

## Exercise 2
When removing from a heap, you will need to do a bit more to fix the heap structure, so the first thing to implement is the helper method `heapify`.

1. First you need to figure out which value is largest between `i` and its two children. The left child is at index location `2 * i + 1` and the right is at `2 * i + 2`. You should also make sure that both of those are valid indices in the heap (i.e. that they aren't greater than or equal to `hT.count()`).

2. Once you have the index of largest value, use the `swap` helper function to swap `i` with `largest_index`.

3. At this point, the value that was originally at `i` and is now at `largest_index` might still not be in the right spot, so call `heapify` recursively on it.

4. Make sure your code compiles, but you can't test heapify on it's own.

## Exercise 3
Finally, implement `delete`.

1. `delete` takes a value to be deleted, so you need to first search through your list for that value and save the index (you could also use a Kotlin function to achieve this, but it's the same idea).

2. Then swap the item to be deleted with the last item in the list.

3. Use `removeAt(hT.count()-1)` to delete the last item from the list

4. Use `heapify` to fix your heap.

5. Test your code by uncommenting the `delete` line in main.

## Extra
We don't have an `extractMax` which is kind of the whole point of a heap, so try implementing that, and possibly refactoring your `delete` code to reduce code duplication!



    