---
layout: page
title: Efficiency Lab
permalink: /classes/111-w22/efficiency
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.
I also recommend opening the [readings](https://runestone.academy/ns/books/published/pythonds/SortSearch/sorting.html) for today for reference.

## Exercise 0
(Repeat of what we talked about at the beginning of class.)
For class today, you should have read about a sorting algorithm called *selection sort*. 
In this lab, you will explore a different algorithm which accomplishes the same task.

### Insertion Sort Overview
Insertion sort follows the following general algorithm:

* Going from left to right:
    * For each value you reach, **insert it** into its proper place in the list to its left (by continuously swapping it with smaller values until it is in place).

### An example
For instance, here are the steps to sort the list `[3, 5, 1, 2, 4]`

1) Start with item at index 0:

* [**3**, 5, 1, 2, 4] *Nothing to the left of index 0, so no swaps necessary*

2) Process item at index 1:

* [3, **5**, 1, 2, 4] *5 > 3, so no swaps necessary*

3) Process item at index 2:

* [3, 5, **1**, 2, 4] *1 < 5, so swap them*
* [3, **1**, 5, 2, 4] *1 < 3, so swap them*
* [**1**, 3, 5, 2, 4] *Nothing to the left of 1, so no more swaps*

4) Process item at index 3:

* [1, 3, 5, **2**, 4] *2 < 5, so swap them*
* [1, 3, **2**, 5, 4] *2 < 3, so swap them*
* [1, **2**, 3, 5, 4] *2 > 1, so no more swaps needed*

5) Process item at index 4:

* [1, 2, 3, 5, **4**] *4 < 5, so swap them*
* [1, 2, 3, **4**, 5] *4 > 3, so no more swaps needed*

Note that at each step of the way, we are maintaining a list that is fully sorted to the **left** of the index that we are currently considering. This means that as soon as we find a value that is less than the one we are currently considering, we can stop swapping!

### The code
Here is the code for insertion sort being used to sort a small list of strings:

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=def%20insertionSort%28lst%29%3A%0A%20%20for%20i%20in%20range%28len%28lst%29%29%3A%0A%20%20%20%20j%20%3D%20i%0A%20%20%20%20while%20j%20%3E%200%20and%20lst%5Bj%5D%20%3C%20lst%5Bj-1%5D%3A%0A%20%20%20%20%20%20lst%5Bj%5D,%20lst%5Bj-1%5D%20%3D%20lst%5Bj-1%5D,%20lst%5Bj%5D%0A%20%20%20%20%20%20j%20%3D%20j%20-%201%0A%20%20%20%20%20%20%0AinsertionSort%28%5B%22c%22,%20%22b%22,%20%22a%22%5D%29&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

Familiarize yourself with this code and try to understand how it works. (It might help to try out the algorithm on a few small lists of your own creation.)

## Exercise 1
Answer the following questions about the program itself:
* Why doesn't this function require a return value?
* Why are we using a while loop for `j` rather than a for loop?
* Does `i` really need to start at 0? Why or why not?

## Exercise 2
a) Come up with two lists of length 5 with the following properties:
* One for which insertion sort will go as *fast* as possible
* One for which insertion sort will go as *slow* as possible

b) How many times does insertion sort need to swap values when performed on each of the two lists you created?

## Exercise 3
a) Using big-O analysis, determine what is the **best case** runtime of insertion sort?

b) Using big-O analysis, determine what is the **worst case** runtime of insertion sort?

## Exercise 4
Given these best- and worst-case runtimes, do you think insertion sort is better or worse than the algorithms you read about, **bubble sort and selection sort**? (The code for selection sort is below.)

```
def selectionSort(lst):
  for i in range(len(lst)):
    small = i
    for j in range(i+1, len(lst)):
      if lst[j] < lst[small]:
        small = j
    lst[i], lst[small] = lst[small], lst[i]
```

## Extra
If you have extra time, try coming up with a sorting algorithm that has a similar 'divide and conquer' approach as binary search (i.e. makes two recursive calls to split the list into two halves).