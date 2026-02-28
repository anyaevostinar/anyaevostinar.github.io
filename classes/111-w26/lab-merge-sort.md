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

2. Implement a `while` loop that does the following. You will need to **create some variables before the start of your loop**.
    ```
    # while there are still items in both the left and right halves
        # check if the next left item is less than or equal to the next right item
            # if so, append the next left item to the merged list
            # otherwise, append the next right item to the merged list
    ```

3. Your `merge` isn't quite done since you aren't grabbing the remaining elements of one of the lists, but this is a good time to **make sure that you code currently is able to merge up until one of the lists is empty**.

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

4. Now complete your `merge` so that it **appends the remaining items from whichever list isn't empty and returns your merged list**. Once you have, add the following tests and run them:
    ```python
    print(merge([1, 7, 8], [0, 20, 26]))
    print(merge(["ant", "dragon", "zero"], ["azure", "boy", "cold", "fix"]))
    ```

    You should get back:

    ```bash
    python merge_sort.py
    [0, 1, 7, 8, 20, 26]
    ['ant', 'azure', 'boy', 'cold', 'dragon', 'fix', 'zero']
    ```

## Exercise 2
Now it's time to implement merge sort! Implement the `merge_sort` function based on the high-level that we discussed in class:
* The parameter is an unsorted list `lst`.
* The return value is a sorted list.
* The base case is when the list is length 1 or 0.
* In the recursive case, you should make recursive calls on the **first half** and **second half** of the list, which will both return sorted sublists. (Hint, remember you can use `[:midpoint]` if you have defined `midpoint` to get the first half of a list.)
* You should then use your `merge` to **merge those sorted sublists and return the sorted list**.

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
print(merge_sort([(2, 'a'), (1, 'b'), (2, 'c')])) # Note, your existing comparison will work for tuples already, cool huh?
# should print [(1, 'b'), (2, 'a'), (2, 'c')] 
```

## Exercise 3
Now it's time to see how fast your implementation of merge sort is! 

1. Download the [sort_function_timer.py](/classes/111-w26/sort_function_timer.py) program and **copy in** your `merge` and `merge_sort` functions. I've also provided implementations of insertion, selection, and bubble sort for you to compare with. 

2. After you copy in your merge sort functions, **run the program** and you should see something similar to this (though probably faster times since the lab machines are more powerful than my laptop!):
    ```bash
    python sort_function_timer.py
    Working on input size: 10
    ------------------------------------
    Average time for insertion sort with input size 10: 0.001133 milliseconds
    Average time for merge sort with input size 10: 0.003450 milliseconds
    Average time for selection sort with input size 10: 0.001443 milliseconds
    Average time for bubble sort with input size 10: 0.001925 milliseconds
    ```

3. This is running 10,0000 trials for a very small list. Based on your data (and mine), **which sort would you want to use for very small lists**? Why do you think that is the case?

4. Now increase the size of the input on **line 105** to see how the efficiency of the different sorts changes as the size of the input increases. You may want to **decrease the number of trials** somewhat to not have to wait quite so long. You can also **stop running the slowest sort** (which one is it?) at very large input sizes.

5. Plot your data (on [Desmos calculator](https://www.desmos.com/calculator) or another plotting software of your choosing) to see how it compares to the Big O times that we discussed for these sorting algorithms. Remember in Desmos, **click the + and choose "table"** to enter in your timing data points, then click the **magnifying glass** for it to adjust the axes to show you data clearly.

## Submission
Submit your completed `merge` and `merge_sort` to Moodle for an extra engagement credit.

## Extra

### Merge Sort in Place
As we have discussed previously, creating new sublists is expensive both in time and memory usage, so it isn't ideal to be doing that so many time in merge sort. You can fix that by creating a single temporary list and using index pointers similar to how we did binary search.

1. Define a function `def merge_inplace(lst, left_start, left_end, right_end, tmp)`, which takes the full list, an index pointer to mark the start of the left *sublist*, an index pointer to mark the end of the *left* sublist (which is also the start of the *right* sublist), and index pointer to mark the end of the *right* sublist, and a temporary list that is the same size as the full list. You can make the original temporary list with `lst.copy()`. Your function should do the same process as your original merge, but do the merging into `tmp` and then copy that section of `tmp` back into `lst`. Make sure your new merge works correctly with the same tests as above, though you'll have to modify them to pass all the new parameters.

2. Now define a function `def merge_sort_inplace(lst, first, last, tmp)`, which implements merge sort, but instead of creating new sublists, it adjusts the `first` and `last` index pointers to indicate the sublists.

### Insertion Sort Optimization
As you noticed, merge sort isn't actually the fastest with small lists, due to the extra work of splitting and making recursive calls. Because of this, the built-in sorting generally uses a *hybrid* approach where insertion sort is used once the size of the list gets small enough (the built in doesn't use merge sort since there is a slightly faster practical sorting called quick sort, but it does use insertion sort at the smaller list sizes). 

1. Make a copy of your merge sort function and call it `hybrid_sort`. Then switch to using insertion sort when the size of the sublist is less than 10 items.

2. See if you can detect a difference in the speed of your hybrid sort compared to merge sort!