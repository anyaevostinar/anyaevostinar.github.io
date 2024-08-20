---
layout: page
title: Binary Search Lab
permalink: /classes/111-w24/binary-search
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 0
For the list `[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]`, work through the process of binary search when looking for `1`.
You should identify what the midpoint is of the current section of the list as well as the first and last positions are.
Here is a table with the first line filled out:

| First position | Midpoint | Last position | Explanation |
|---------------|----------|----------------| ------------|
| 0 | 6  | 13 | Section to search starts as entire list |
|  |  |  | |
|    |    |      |

Algorithmically, the steps of binary search are:
* set the first position as 0
* set the last position as the length of the list - 1
* while the first position is less than or equal to the last position (i.e. the first position "pointer" hasn't gone past the last position "pointer"):
    * set the midpoint as halfway between the first and last position, rounded down if needed
    * check if the item at the midpoint is the item we're looking for, if it is we're done and can return true
    * if not, check if the item comes before (i.e. is 'less than') the item at the midpoint
        * if it is, change the last position pointer to point to the position just before the midpoint
        * otherwise the item we're looking for is greater than the midpoint item, so set the first position pointer to just after the midpoint
        * go through the loop steps again
* Once the first position pointer has gone past the last position pointer and you haven't returned True, that means the item isn't in the list, so return False

## Exercise 1
This version of binary search has approximately 7 bugs:
```python
def binarySearch(alist, item):
    last = len(alist)
    found = False

    while first<=last and not found:
        midpoint = (first + last)/2 
        if alist[midpoint] == item:
            found = True
        else:
            if item > alist[midpoint]:
                last = midpoint 
            else:
                first = midpoint 
                return found 

print(binarySearch([1, 2, 3, 4, 5], 1))
#should print True
```

Use your debugging skills to figure out and fix all the errors without referring to the reading.
I highly recommend pasting this into [PythonTutor](https://pythontutor.com/visualize.html#mode=edit) to see what it is doing!

There is space on the back of your worksheet to note each bug as you fix it.

## Exercise 2
Here is a recursive version of binary search that also has several bugs (approximately 4):
```python
def binarySearch(alist, item):
    if len(alist) == 1: 
        return False
    else:
        midpoint = len(alist)//2
        if item>alist[midpoint]:
            return binarySearch(alist[:midpoint],midpoint)
        else:
            return binarySearch(alist[midpoint+1:],item)

testlist = [0, 1, 2, 8, 13, 17, 19, 32, 42]
print(binarySearch(testlist, 3)) #should print False
print(binarySearch(testlist, 13)) #should print True
```

## Extra
If you have extra time, adapt the binary search functions so that they return the index of the item found, not just True or False (if the item isn't in the list, you could return False or -1).

You could also try returning all the indices if the item is in the list multiple times.