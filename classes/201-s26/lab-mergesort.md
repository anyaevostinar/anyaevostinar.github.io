---
layout: page
title: Mergesort Lab
permalink: /classes/201-s26/mergesort-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive.

Download and unzip the [starter code](/classes/201-s26/MergesortLabStarter.zip), place it in your STUWORK/username folder and open it in VSCode for today's labwork

## Mergesort
1. Warm up by completing the implementation in `Mergesort.kt` by filling in `mergeSort`. Do not consult the reading for this, instead work on remembering the steps of mergesort. This is a nearly identical implementation as you read about, but wrapped in a class so that we can work with it in the follow exercises.

2. Make sure that your code compiles and correctly sorts the test lists at this point:
```bash
kotlinc Mergesort.kt SorterInt.kt
kotlin MergesortKt.class
```

## Timing
Let's see how fast mergesort really is. In the starter code, I've adapted code from the textbook for insertion sort and [shell sort](https://runestone.academy/ns/books/published/kotlinds/sort-search_the-shell-sort.html?mode=browsing) and created a timing framework so you can see how much time it takes to sort lists of various sizes.

1. Compile all the files and run the timing program. You should see something similar to this (though probably faster times since the lab machines are more powerful than my laptop!):

```bash
kotlinc *.kt         
kotlin TimingKt.class
Timing sorting algorithms with size 10 lists
Average time for Mergesort with size 10 over 30 reps: 0.010848 ms
Average time for InsertionSort with size 10 over 30 reps: 0.003183 ms
Average time for Shellsort with size 10 over 30 reps: 0.006031 ms
Average time for MergesortNewLists with size 10 over 30 reps: 0.028462 ms
Average time for built-in sort with size 10 over 30 reps: 8.16E-4 ms
```

2. This is running 1,000 trials for a very small list. Based on your data (and mine), **which of your sorts would you want to use for very small lists?** Why do you think that is the case? (If you are intrigued at how the built-in is so fast, look at the extra exercises later!)

3. Now increase the size of the input on **line 42** to see how the efficiency of the different sorts changes as the size of the input increases. You may want to **decrease the number of trials** somewhat to not have to wait quite so long. You can also **stop running the slowest sort** (which one is it?) at very large input sizes.

4. Plot your data (on [Desmos calculator](https://www.desmos.com/calculator) or another plotting software of your choosing) to see how it compares to the Big O times that we discussed for these sorting algorithms. Remember in Desmos, **click the + and choose “table”** to enter in your timing data points, then click the **magnifying glass** for it to adjust the axes to show you data clearly.

## New Lists
A more intuitive way to implement mergesort is by creating new lists instead of using pointers to trace through the single list. We have discussed that that is slower due to the creation of new lists, but let's find out how much so and practice generalizing your knowledge of mergesort along the way.

1. Create a new file `MergesortNewLists.kt` and copy in the contents from `Mergesort.kt` but change the name of the class to be `MergesortNewLists`.

2. Change the implementation of `mergeSort` so that it only takes in a single list (and no other parameters) and returns that single list sorted. Remember that you can make new lists with `subList` and turn a `List` into a `MutableList` with `.toMutableList()`. You'll also need to update `sort` in this class so that it captures what `mergeSort` returns and replaces what is in the `list` parameter with the contents of the sorted list (using `clear` and `addAll` is probably easiest, but you might find a different way!).

3. Make sure that your new implementation still correctly sorts the test lists:
```bash
kotlinc MergesortNewLists.kt SorterInt.kt
kotlin MergesortNewListsKt.class         
[17, 20, 26, 31, 44, 54, 55, 77, 93]
[ant, azure, boy, cold, dragon, fix, zero]
[1, 1, 2, 2, 2, 3]
[-10, -5, -1, 0, 2]
```

## Submission
Submit you completed `Mergesort.kt` and `MergesortNewLists.kt` for an extra engagement credit.

## Extra
### Insertion Sort Optimization
As you noticed, merge sort isn't actually the fastest with small lists, due to the extra work of splitting and making recursive calls. Because of this, the built-in sorting generally uses a *hybrid* approach where insertion sort is used once the size of the list gets small enough. 

1. Make a copy of your merge sort function and call it `hybrid_sort`. Then switch to using insertion sort when the size of the sublist is less than 10 items.

2. See if you can detect a difference in the speed of your hybrid sort compared to merge sort!

### Bottom Up Merge Sort
As we've discussed, recursion adds a lot of overhead to a program, so it is more efficient to avoid it if possible. You can do that with merge sort by skipping the splitting step and thinking of your list as already a bunch of single items and then using index pointers to track the locations of your "sublists". Try out implementing it and compare the timing! This is very close to how one of [Kotlin's built-in](https://en.wikipedia.org/wiki/Timsort) sorts actually works.