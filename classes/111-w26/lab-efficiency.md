---
layout: page
title: Efficiency Lab
permalink: /classes/111-w26/efficiency
---

## Setup
I recommend making a folder for today's lab in [COURSES as you usually do](getting-started).

## Exercise 0
(Finish the analysis that we started together:)

Consider the following program:

```python
def avg_list(lst):
  ''' Return the mean of a list of integers. '''
  tot = 0
  for i in range(len(lst)):
    tot = tot + lst[i]
  return tot / len(lst)
```

a. Determine the Big-O runtime by counting the number of critical operations that occur in terms of the size of the list and dropping the constants.

b. Run this program with the [`function_timer.py`](/classes/111-w26/function_timer.py) starter code with several different lengths of lists by changing the value on line 122 `input_size`. Write down the values on your worksheet.

c. Plot how the time changes as the size of the list grows with the [Desmos calculator](https://www.desmos.com/calculator) (click the + and choose "table" to enter in your timing data points, then click the magnifying glass for it to adjust the axes to show you data clearly). Record your plot on the worksheet.  Based on the plot you see, which of the Big-O common functions does it seem to fit? Does it agree with your prediction from a?

![Image of main Big-O functions](https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Comparison_computational_complexity.svg/512px-Comparison_computational_complexity.svg.png?20170623110746)

Source: [Wikimedia user Cmglee](https://commons.wikimedia.org/wiki/File:Comparison_computational_complexity.svg)



## Exercise 1-4
For each of the following functions:

a. Determine their big-O runtime by counting the number of critical operations that occur in terms of the size of the input and then dropping the constants.

b. Uncomment the lines 70-91 and 106-110 (NOT `recursive_fibonacci` yet). Run the the function timing script and plot the resulting data to compare to your prediction.


```python
# 1
def get_first_item(items):
    if items:
        return items[0]
    else:
        return None
```

```python
# 2
def find_max(items):
    max_val = items[0]
    for item in items:
        if item > max_val:
            max_val = item
    return max_val
```

```python
# 3
def find_duplicates(items):
    duplicates = []
    for i in range(len(items)):
        for j in range(i + 1, len(items)):
            if items[i] == items[j]:
                duplicates.append(items[i])
    return duplicates
```

```python
#4
def add(a, b):
  ''' Return the sum of two integers. '''
  tot = a + b
  return tot
```

## Submission
Upload a picture of your `find_max` analysis page for an extra engagement credit.

## Extra
We'll be talking about recursion next time, but it `recursive_fibonacci` is a sneak peak and an example of a function that is REALLY slow. Try uncommenting it and running it with n=10 and going up by 1. If it takes more than 30 seconds, you should stop it with Ctrl-C and try a smaller value! 

We won't have the tools in this class to determine the Big-O of recursive functions, but you can start thinking about it by drawing out all the function calls that will happen for each recursive call in a tree to get an idea of how much work is happening.