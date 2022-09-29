---
layout: page
title: Mutating Lists Lab 
permalink: /classes/111-f22/lab-mutating-lists
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and quizzes so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.

## Exercise 1
Predict what the reference diagram will look like after the following code snippet has run:
<iframe width="800" height="500" frameborder="0" src="https://pythontutor.com/iframe-embed.html#code=my_list%20%3D%20%5B1,%202,%203,%204%5D%0Amy_other_list%20%3D%20my_list%0Amy_list%5B0%5D%20%3D%205%0Amy_other_list%5B1%5D%20%3D%204&codeDivHeight=400&codeDivWidth=350&cumulative=false&curInstr=0&heapPrimitives=true&origin=opt-frontend.js&py=3&rawInputLstJSON=%5B%5D&textReferences=false"> </iframe>

## Exercise 2
In the game Pokemon, you have a team of creatures (i.e. Pokemon) that battle other teams of
Pokemon. 
Most rounds are 1-on-1 and so you have to choose which of your Pokemon will fight in
a round. 
Imagine that I’ve developed an algorithm that scores each of the Pokemon on my team
for how well they will do against an opponent, and I’ve compiled those scores in a nested list, for
example:

```python
my_team = [["Bulbasaur", 32], ["Chimchar", 45], ["Pidgey", 36],
["Articuno", 57], ["Drifloon", 20], ["Pikachu", 18]]
```

Write Python code that will determine from such a list which Pokemon I should choose for a
round and print out its name. The Pokemon that should be chosen is the one with the highest
score. Note that your program should work for any list in this format, not just this example list;
in particular, the list can include more or less than 6 Pokemon, though you can assume that it is
stored in the variable `my_team`. For the example, your program should print out `Articuno`.

## Exercise 3
Imagine you have a list `example = [1, 2, 3, 4]`. Write a program that rotates the items of that list to the left by one position and then prints `example`:

```python
example = [1, 2, 3, 4]

#your code here

print(example) #should print [2, 3, 4, 1]
```

## Exercise 4
Many of the functions for lists aren't actually needed since you can implement them yourself, though they are convenient.
Try writing code snippets which accomplish the same things as the built-in list methods:
* Reverse a list
* Loop through and print the index of an item in a list
* Loop through and print the count of an item in a list
* Remove a specific item from a list - use `del` for this
* Insert an item into a list
* Slicing (that makes a new list remember!)
* Sort a list - we'll talk about sorting in a few weeks, but think about how you could do it

## Extra
If you have extra time, work through some of the [end of chapter exercises](https://runestone.academy/ns/books/published/intro-cs/TransformingSequences/Exercises.html) and [assessments](https://runestone.academy/ns/books/published/intro-cs/TransformingSequences/week4a1.html) or the [image processing](https://runestone.academy/ns/books/published/intro-cs/Projects/image_processing.html#image-processing) project from the book.