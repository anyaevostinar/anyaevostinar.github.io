---
layout: page
title: Binary Search Lab
permalink: /classes/111-w26/binary-search
---


I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
This version of binary search has approximately 7 bugs:
```python
def binary_search(alist, item):
    '''Performs binary search to find the item
    @param a sorted list
    @param item to find in the list
    @return the index of the item if found, otherwise -1
    '''
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
                return -1

print(binary_search([1, 2, 3, 4, 5], 1))
#should print 0
print(binary_search(["bat", "data", "egg", "fig", "hat", "joke", "let", "no", "pig", "quiz", "rag"], "egg"))
#should print 2
print(binary_search(["bat", "data", "egg", "fig", "hat", "joke", "let", "no", "pig", "quiz", "rag"], "elephant"))
#should print -1

letters = ['a', 'b', 'c', 'f', 'h', 'k', 'o', 'p', 't', 'w', 'z']
res1 = binary_search(letters, 'a')
res2 = binary_search(letters, 'y')
res3 = binary_search(letters, 't')

print(res1) #should print 0
print(res2) #should print -1
print(res3) #should print 8
```

Use your debugging skills to figure out and fix all the errors without referring to the reading.
I highly recommend pasting this into [PythonTutor](https://pythontutor.com/visualize.html#mode=edit) to see what it is doing!

There is space on the third page of your worksheet to note each bug as you fix it.

## Exercise 2
Here is a recursive version of binary search that also has several bugs (approximately 4):
```python
def binary_search_rec(alist, item):
    '''Performs binary search to find the item recursively
    @param a sorted list
    @param item to find in the list
    @return whether the item is in the list
    '''
    if len(alist) == 1: 
        return False
    else:
        midpoint = len(alist)//2
        if item>alist[midpoint]:
            return binary_search_rec(alist[:midpoint],midpoint)
        else:
            return binary_search_r(alist[midpoint+1:],item)

testlist = [0, 1, 2, 8, 13, 17, 19, 32, 42]
print(binarySearch(testlist, 3)) #should print -1
print(binarySearch(testlist, 13)) #should print 4
```

## Submission
Submit your corrected versions of both functions to Moodle for an extra engagement credit.

## Extra
If you have extra time, try adapting the two functions to return all the indices if the item is in the list multiple times.

Use the [function_timer.py](/classes/111-w26/function_timer.py) to time both of your functions on long lists, how do they compare to sequential sorting?