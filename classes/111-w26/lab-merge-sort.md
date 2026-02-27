---
layout: page
title: Merge Sort Lab
permalink: /classes/111-w26/merge-sort-lab
---

I recommend making a folder for today's lab in COURSES as you usually do.

Make a file in it name `merge_sort.py`.

## Goals
Today's lab aims to have you implement merge sort for yourself to improve your understanding of how it works. In addition, you will compare the number of comparisons and real timing of merge sort and insertion sort.

## Exercise 1
As you know, the merging is where the sorting is actually happening with merge sort.
Therefore, you will start by implementing a `merge` function in this exercise.

1. Define a function `merge` that takes two lists, `left_half` and `right_half`, as parameters.

2. Implement a `while` loop that does the following. You will need to create some variables before the start of your loop.
    ```
    # while there are still items in both the left and right halves
        # check if the next left item is less than or equal to the next right item
            # if so, append the next left item to the merged list
            # otherwise, append the next right item to the merged list
    ```

3. Your `merge` isn't quite done since you aren't grabbing the remaining elements of one of the lists, but this is a good time to make sure that you code currently is able to merge up until one of the lists is empty.

    a. Add a line that **prints your final merged list** at the end of your `merge` function.
    
    b. Add this test code to your file:

    ```python
    merge([1, 3, 5, 7], [0, 2, 4, 6, 8])
    ```

    c. Run it and make sure that you get the following:

    ```bash
    python merge_sort.py
    [0, 1, 2, 3, 4, 5, 6, 7]
    ```

    d. Make sure to remove your print line so it doesn't confuse you later.

4. Now complete your `merge` so that it appends the remaining items from whichever list isn't empty and returns your merged list. Once you have, add the following tests and run them:
    ```python
    print(merge([1, 7, 8], [0, 20, 26]))
    print(merge(["ant", "dragon", "zero"], ["cold", "azure", "boy", "fix"]))
    ```

    You should get back:

    ```bash
    python merge_sort.py
    [0, 1, 7, 8, 20, 26]
    ['ant', 'cold', 'azure', 'boy', 'dragon', 'fix', 'zero']
    ```

## Exercise 2
Now it's time to implement merge sort! Implement the `merge_sort` function based on the high-level that we discussed in class:
* Parameter is an unsorted list
* Return value is a sorted list
* Base case is when the list is length 1 or 0
* In the recursive case, you should make recursive calls on the first half and second half of the list, which will both return sorted sublists
* You should then use your `merge` to merge those sorted sublists and return the sorted list.

Once you've implemented your `merge_sort`, make sure it is able to sort the following correctly:

```python
print(merge_sort([5, 4, 3, 2, 1]))
# should print [1, 2, 3, 4, 5]
print(merge_sort(["ant", "dragon", "zero", "cold", "azure", "boy", "fix"]))
# should print ['ant', 'azure', 'boy', 'cold', 'dragon', 'fix', 'zero']
print(merge_sort([2, 2, 1, 3, 2, 1]))
# should print [1, 1, 2, 2, 2, 3]
print(merge_sort([-5, 2, -1, 0, -10]))
# should print [-10, -5, -1, 0, 2]
print(merge_sort([(2, 'a'), (1, 'b'), (2, 'c')])) # Note, your existing <= will work for tuples already, cool huh?
# should print [(1, 'b'), (2, 'a'), (2, 'c')] 
```