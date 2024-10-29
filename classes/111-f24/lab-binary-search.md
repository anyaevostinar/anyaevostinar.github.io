---
layout: page
title: Binary Search Lab
permalink: /classes/111-f24/binary-search
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
This version of binary search has approximately 7 bugs:
```python
def binary_search(alist, item):
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

print(binary_search([1, 2, 3, 4, 5], 1))
#should print True
print(binary_search(["bat", "data", "egg", "fig", "hat", "joke", "let", "no", "pig", "quiz", "rag"], "egg"))
#should print True
print(binary_search(["bat", "data", "egg", "fig", "hat", "joke", "let", "no", "pig", "quiz", "rag"], "elephant"))
#should print False
```

Use your debugging skills to figure out and fix all the errors without referring to the reading.
I highly recommend pasting this into [PythonTutor](https://pythontutor.com/visualize.html#mode=edit) to see what it is doing!

There is space on the third page of your worksheet to note each bug as you fix it.

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