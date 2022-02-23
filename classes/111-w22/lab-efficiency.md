---
layout: page
title: Efficiency Lab
permalink: /classes/111-w22/efficiency
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.
I also recommend opening the [readings](https://runestone.academy/ns/books/published/pythonds/AlgorithmAnalysis/WhatIsAlgorithmAnalysis.html) [for today](https://runestone.academy/ns/books/published/pythonds/AlgorithmAnalysis/BigONotation.html) for reference.

## Exercise 0
(This is a repeat of what we did together.)

Consider the following program:

```
def avgList(lst):
  ''' Return the mean of a list of integers. '''
  tot = 0
  for i in range(len(lst)):
    tot = tot + lst[i]
  return tot / len(lst)
```

What is the big-O runtime of this algorithm?

## Exercise 1-4
For each of the following functions:
a. Identify the error in them and fix it
b. Determine their big-O runtime

```
# 1
def add(a, b):
  ''' Return the sum of two integers. '''
  tot = a + b
```

```
# 2
def containsDuplicates(lst):
  ''' Return whether or not there are any duplicate values in given list. '''
  for i in range(len(lst)):
    for j in range(len(lst)):
      if lst[i] == lst[j]:
        return True
  return False
```

```
# 3
def getMin1(lst):
  ''' Return the minimum element from given list of NON-NEGATIVE integers. '''
  if len(lst) == 0:
    return 0
  else:
    minRest = getMin1(lst[1:])
    if minRest > lst[0]:
      return minRest
    else:
      return lst[0]
```

```
# 4
# This one is tricky, work through some examples and count the number 
# of comparisons!
def getMin2(lst):
  ''' Return the minimum element from given list of NON-NEGATIVE integers. '''
  if len(lst) < 0:
    return 0
  else:
    mid = len(lst) // 2
    minLeft = getMin2(lst[:mid])
    minRight = getMin2(lst[mid:])
    if minLeft < minRight:
      return minLeft
    else:
      return minRight
```

## Extra
If you have extra time, implement a **recursive** version of sequential search.

If you still have extra time, try coming up with a more efficient way of searching through a list assuming that the list is **sorted**. *Hint: think about a strategy you could use for the guessing game.*