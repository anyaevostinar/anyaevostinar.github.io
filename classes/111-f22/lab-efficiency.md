---
layout: page
title: Efficiency Lab
permalink: /classes/111-f22/efficiency
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

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

a. Run this program with the [`functionsTiming.py`](functionsTiming.py) starter code with several different lengths of lists and plot how the time changes as the size of the list grows. (You can either plot your data on paper or use a spreadsheet program.) Based on the plot you see, which of the Big-O common functions does it seem to fit?

![Image of main Big-O functions](https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Comparison_computational_complexity.svg/512px-Comparison_computational_complexity.svg.png?20170623110746)
Source: [Wikimedia user Cmglee](https://commons.wikimedia.org/wiki/File:Comparison_computational_complexity.svg)

b. Determine the Big-O runtime by counting the number of critical operations that occur in terms of the size of the list and dropping the constants. Does it agree with your plot?

## Exercise 1-4
For each of the following functions:
a. Run them using the function timing script and plot the resulting data to compare against the Big-O common functions.
b. Determine their big-O runtime by counting the number of critical operations that occur in terms of the size of the input and then dropping the constants and compare that to what you found with the benchmark timing.

```python
# 1, note that you should increase only one of the inputs for your analysis
def add(a, b):
  ''' Return the sum of two integers. '''
  tot = a + b
  return tot
```

```python
# 2
def containsDuplicates(lst):
  ''' Return whether or not there are any duplicate values in given list. '''
  for i in range(len(lst)):
    for j in range(len(lst)):
      if i != j and lst[i] == lst[j]:
        return True
  return False
```

```python
# 3
def getMin1(lst):
  ''' Return the minimum element from given list of NON-NEGATIVE integers. '''
  if len(lst) == 1:
    return lst[0]
  else:
    minRest = getMin1(lst[1:])
    if minRest > lst[0]:
      return minRest
    else:
      return lst[0]
```

```python
# 4
# This one is tricky, work through some examples and count the number 
# of comparisons!
def getMin2(lst):
  ''' Return the minimum element from given list of NON-NEGATIVE integers. '''
  if len(lst) == 1:
    return lst[0]
  else:
    mid = len(lst) // 2
    minLeft = getMin2(lst[:mid])
    minRight = getMin2(lst[mid:])
    if minLeft < minRight:
      return minLeft
    else:
      return minRight
```

## Exercise 5
Examine the two versions of functions for finding the Fibonacci numbers in the timings file. Compare them using the timing script and try to figure out why one is more efficient than the other.

## Extra
Go back to your solutions to previous labs and figure out their Big-O runtime.