---
layout: page
title: Analysis Lab
permalink: /classes/201-f25/analysis-lab
published: true
---

## Goals
To get a better understanding of how to calculate the efficiency of algorithms - developing both your ability to work through calculations mathematically and your intuitive sense of estimating big-O, as well as refreshing on the time complexity of some familiar algorithms.

## Setup
There is no coding for this lab. Instead you should write your answers on the worksheet.

## Exercise 1
For each of the following Kotlin code fragments, indicate how many times the output statement is displayed.

```kotlin
for (x: Int in 1..4) {
    println(x)
}

for (x: Int in 1..<20) {
    if (x % 2 == 0) {
        println(x)
    }
}

for (x: Int in 0..<10) {
    for (y: Int in 1..x) {
        println("$x $y")
    }
}
```


## Exercise 2
For each of the following Kotlin code fragments, indicate how many times the output statement is displayed relative to n. What function could you use to describe this?

```kotlin
for (x: Int in 0..<n) {
    println(x)
}

for (x: Int in 0..<n) {
    for (y: Int in 0..<n) {
        if (x != y) {
            println("$x $y")
        }
    }
}

for (x: Int in 0..<n) {
    for (y: Int in x..<n) {
        println("$x $y")
    }
}
```

## Exercise 3
For this Kotlin code, 

a. how many times is output displayed relative to `n` if `n` is the size of `students`? 

b. What is the Big-O runtime of the function as a whole? How does that compare to the amount of printing?
```kotlin
fun pairStudents(students:List<String>){
    for (student1 in students){
    	for(student2 in students){
        	if (student1 != student2){
            	println("Pair: $student1 and $student2")
        	}
    	}
	}
}
```

## Exercise 4
Considering the following Java code for binary search (don't worry about the places where the syntax is a little different, you can get the right general idea)
```java
public boolean binarySearch(int[] list, int item) {
    int first = 0;
    int last = list.length - 1;
    while (first <= last) {
        int midpoint = (first + last) / 2;
        if (list[midpoint] == item) {
            return true;
        } else if (list[midpoint] < item) {
            last = midpoint - 1;
        } else {
            first = midpoint + 1;
        }
    }
    return false;
}
```

Analyze the time complexity (you'll have to think about how many times the while loop in Binary Search will actually run) in the same way you did for the previous several problems. How does your analysis change if the list isn't already sorted?

## Extra
You should submit what you've completed above and then think about this one. We'll come back to these ideas a little later in the term.

The following is a function for sorting two lists of numbers, which you might have seen in CS 111: [mergesort](https://runestone.academy/ns/books/published/pythonds3/SortSearch/TheMergeSort.html?mode=browsing). It uses recursion to do the sorting. 

Think about the following:

1. How many recursive calls are going to be made on list `A`?
2. For a given pair of sublists, how much work is that for-loop doing?
3. Why do we want to use `temp` instead of making new lists?

```kotlin
fun mergesort(A: MutableList<Int>, temp: MutableList<Int>, left: Int, right: Int) {
    if (left == right) {        // List has one record
        return
    }
    val mid = (left+right)/2          // Select midpoint
    mergesort(A, temp, left, mid)     // Mergesort first half
    mergesort(A, temp, mid+1, right)  // Mergesort second half
    for (i in left..right) {    // Copy subarray to temp
        temp[i] = A[i]
    }
    // Do the merge operation back to A
    var i1 = left
    var i2 = mid + 1
    for (curr in left..right) {
        if (i1 == mid+1) {                 // Left sublist exhausted
            A[curr] = temp[i2++]
        }
        else if (i2 > right) {             // Right sublist exhausted
            A[curr] = temp[i1++]
        }
        else if (temp[i1] < temp[i2]) {     // Get smaller value
            A[curr] = temp[i1++]
        }
        else{
            A[curr] = temp[i2++]
        }
    }
}
```

