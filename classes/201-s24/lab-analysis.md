---
layout: page
title: Analysis Lab
permalink: /classes/201-s24/analysis-activity
published: true
---

## Goals
To get a better understanding of how to calculate the efficiency of algorithms - developing both your ability to work through calculations mathematically and your intuitive sense of estimating big-O, as well as refreshing on the time complexity of some familiar algorithms.

## Setup
There is no coding for this lab. Instead you should get out paper and pencil to work out your solutions.

## Exercise 1
For each of the code snippets below answer the following: 

1) How many times is the output statement printed? Your answer should be in terms of n. 

2) How does the number of times the statement is **printed** grow with the size of n, in big-O notation? Write the tightest bound you can (e.g., if the statement is printed O(n) times, saying it's printed O(n<sup>500</sup>) times will not be considered correct here, even though it's technically accurate).

a.
```
for (int i=0; i < 2*n; i++) {
    for (int j=0; j < n; j++) {
        System.out.println(i + " " + j);
    }
}
```

b.
```
for (int i=0; i < n; i++) {
    for (int j=0; j < 5; j++) {
        System.out.println(i + " " + j);
    }
}
```

c.
```
for (int i=0; i < 7*n; i++) {
    System.out.println(i);
}               
for (int j=0; j < n; j++) {
    System.out.println(j);
}
```

## Exercise 2
Given the following implementation of `pop` for a stack, with an `ArrayList` as `items`:
```java
    public T pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Stack is empty.");
        }
        return this.items.remove(items.size - 1);
    }
```

a. For each line of the code above, indicate next to the line the number of critical operations that will occur in terms of `n`, the size of the stack, in the worst case.

b. Write a function `T(n)` for the critical operations you identified for this method.

c. What is the Big-O worst-case time complexity of this `pop` method?

d. How would your analysis change if the top of the stack was index 0 of the `ArrayList`? (What do you think is involved with removing the first element from an `ArrayList`?)

## Exercise 3

Given the following implementation of `add` for a linked list:

```java
    public void add(T item) {
        Node<T> temp = new Node<T>(item);
        temp.setNext(this.head);
        this.head = temp;
    }
```

a. For each line of the code above, indicate next to the line the number of critical operations that will occur in terms of `n`, the size of the list, in the worst case.

b. Write a function `T(n)` for the critical operations you identified for this method.

c. What is the Big-O worst-case time complexity of this `add` method?

## Exercise 4

Given the following implementation of `enqueue` for a queue, with a linked list as `items`, where index 0 is the head of the linked list:

```java
    public void enqueue(T item) {
        this.items.add(0, item);
    }
```

a. For each line of the code above, indicate next to the line the number of critical operations that will occur in terms of `n`, the size of the queue, in the worst case.

b. Write a function `T(n)` for the critical operations you identified for this method.

c. What is the Big-O worst-case time complexity of this `enqueue` method?

d. How would your analysis be impacted if you used an `ArrayList` instead?


## Exercise 5
The following two programs are two different ways of searching for an item in a sorted list:

```java
public class SequentialSearchExample {

    public static boolean sequentialSearch(int[] list, int item) {
        int index = 0;
        while (index < list.length) {
            if (list[index] == item) {
                return true;
            }
            index = index + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] testList = {1, 2, 32, 8, 17, 19, 42, 13, 0};

        System.out.println("Search for 3 returns " +
            sequentialSearch(testList, 3));
        System.out.println("Search for 13 returns " +
            sequentialSearch(testList, 13));
    }
}
```

```java
public class BinarySearchExample {

    public static boolean binarySearch(int[] list, int item) {
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

    public static void main(String[] args) {
        int[] testList = {0, 1, 2, 8, 13, 17, 19, 32, 42};

        System.out.println("Binary search for 3 returns " +
            binarySearch(testList, 3));
        System.out.println("Binary search for 13 returns " +
            binarySearch(testList, 13));
    }
}
```

Analyze the time complexity of each (you'll have to think about how many times the while loop in Binary Search will actually run) in the same way you did for the previous several problems. How does your analysis change if the list isn't already sorted?

