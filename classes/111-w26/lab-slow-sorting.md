---
layout: page
title: Slow(ish) Sorting Lab
permalink: /classes/111-w26/slow-sorting
---

I recommend making a folder for today's lab in COURSES as you usually do.

There is room on your class worksheet to write down answers to the following exercises.

## Exercise 1
Here is the code for insertion sort from the reading:

<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=def%20insertion_sort%28a_list%29%3A%0A%20%20%20%20for%20i%20in%20range%281,%20len%28a_list%29%29%3A%0A%20%20%20%20%20%20%20%20cur_val%20%3D%20a_list%5Bi%5D%0A%20%20%20%20%20%20%20%20cur_pos%20%3D%20i%0A%0A%20%20%20%20%20%20%20%20while%20cur_pos%20%3E%200%20and%20a_list%5Bcur_pos%20-%201%5D%20%3E%20cur_val%3A%0A%20%20%20%20%20%20%20%20%20%20%20%20a_list%5Bcur_pos%5D%20%3D%20a_list%5Bcur_pos%20-%201%5D%0A%20%20%20%20%20%20%20%20%20%20%20%20cur_pos%20%3D%20cur_pos%20-%201%0A%20%20%20%20%20%20%20%20a_list%5Bcur_pos%5D%20%3D%20cur_val%0A%0A%0Aa_list%20%3D%20%5B54,%2026,%2093,%2017,%2077,%2031,%2044,%2055,%2020%5D%0Ainsertion_sort%28a_list%29%0Aprint%28a_list%29&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=nevernest&origin=opt-frontend.js&py=311&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>


Answer the following questions about the program itself:
* Why doesn't this function require a return value?
* Why are we using a while loop for `cur_pos` rather than a for loop?
* Why doesn't `i` start at 0?

## Exercise 2
a) Come up with two lists of length 5 with the following properties:
* One for which insertion sort will go as *fast* as possible
* One for which insertion sort will go as *slow* as possible

b) How many times does insertion sort need to shift values when performed on each of the two lists you created?

## Exercise 3
a) Using big-O analysis, determine what is the **best case** runtime of insertion sort.

b) Using big-O analysis, determine what is the **worst case** runtime of insertion sort.

## Exercise 4
Here is another version of selection sort:
```python
def selection_sort(lst):
  for i in range(len(lst)):
    small = i
    for j in range(i+1, len(lst)):
      if lst[j] < lst[small]:
        small = j
    if small != i:
      lst[i], lst[small] = lst[small], lst[i]
```
a) Using big-O analysis, determine what is the **best case** runtime of selection sort.

b) Using big-O analysis, determine what is the **worst case** runtime of selection sort.

c) Given these best- and worst-case runtimes, do you think insertion sort is better or worse than **selection sort**? (The code for selection sort is below.)

## Submission
Submit your answers for Exercises 3 and 4 to Moodle for an extra engagement credit.

## Extra 1
Adapt the code from [function_timer.py](/classes/111-w26/function_timer.py) and the reading to perform benchmark tests on each of the sorting algorithms in the best and worst case to see how they do.

## Extra 2
If you have extra time, try coming up with a sorting algorithm that has a similar 'divide and conquer' approach as binary search (i.e. makes two recursive calls to split the list into two halves).