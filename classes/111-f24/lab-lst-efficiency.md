---
layout: page
title: List and Dictionary Efficiency Lab 
permalink: /classes/111-f24/lab-efficiency2
---

This is a lab assignment and so you will not be submitting it.
However, the concepts and practice will help you on both the homework and exams so I encourage you to make a serious effort on it during class and consider finishing it outside of class.

I recommend making a folder for today's lab in COURSES as you usually do.
You can pull up the ad-supported version of the textbooks that doesn't require logging in for reference [here](https://runestone.academy/ns/books/published/fopp/index.html?mode=browsing) and [here](https://runestone.academy/ns/books/published/pythonds3/index.html?mode=browsing).

## Exercise 1
a. Download the [structuresTiming.py](/classes/111-f22/structuresTiming.py) file and put it into your lab folder.

b. The file has a couple of helper functions for creating dictionaries and lists of specific sizes and looking up items in a dictionary or list using the `in` keyword. It also has code similar to what you've seen before for timing how long a function takes to run; in this case, it is currently timing how long it takes to look up an item in a list and dictionary of size 10:

```python
print("Executing each function 10000 times and seeing how long they take.")

#Make the two structures of the specific size
generated_list = generateList(10)
generated_dict = generateDict(10)

#Get the function calls ready for the timing module, looking for -1 currently
functionCallDict = "dictionaryLookup(generated_dict, -1)"
functionCallList = "listLookup(generated_list, -1)"
#Specify the name of the function here:
functionName = "dictionaryLookup, listLookup"

# Do the timing
timing1 = timeit.timeit(functionCallDict, 
    setup="from __main__ import "+functionName+", generated_dict, generated_list", number=10000)
print(functionCallDict, timing1)
timing2 = timeit.timeit(functionCallList, 
setup="from __main__ import "+functionName+", generated_dict, generated_list", number=10000)
print(functionCallList, timing2)
```

c. Run this code with lists and dictionaries of size 10, 100, 1000, 10000, and 100000, writing down the values on your worksheet, and plot the average execution time compared to the size of the list or dictionary on [Desmos](https://www.desmos.com/calculator) (using the + table option and magnifying glass to focus on your data). Which structure should you use for storing items that you are going to look up?

## Exercise 2
In the previous exercise, you were looking for -1, which wasn't in either the list or the dictionary, leading to the worst case scenario for timing.
What about the best case scenario?

Instead of looking for -1, look for 1 and again run the code with the five sizes and plot the resulting data. Now which structure is better to use?

## Exercise 3
Let's test some other functionality common to lists and dictionaries. Edit the `listLookup` method (or create a new method and update the timing code) to test getting something from a **specific index of a list**.
There isn't really a corresponding dictionary functionality; you could loop over the keys of the dictionary to find the ith key if you want to try it with `.keys()`.

Try any other list and dictionary methods that don't make changes to the structure too!

## Extra 1
Timing making any changes to the list and dictionary lead to a tricky coding problem (since we are currently just using the same list and dictionary every time we run the experiment). If you add an item every time, but the 5000th time, the timing might be quite different!

If you want to try out this problem, you will need to make changes to the `setup` keyword parameter and switch to using `timeit.repeat` ([documentation here](https://docs.python.org/3/library/timeit.html#timeit.repeat)). Then try timing:
* Adding an item to a list and dictionary
* Deleting an item from the list/dictionary

## Extra 2
a. What about strings? Write new code that will let you experiment with the various string methods that you've used.

b. What if you knew that a list was in sorted order? Try to come up with a function that takes advantage of the list being in sorted order when looking for an item and test out how much faster you can get it.