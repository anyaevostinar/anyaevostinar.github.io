---
layout: page
title: Array Efficiency Lab
permalink: /classes/201-w24/array-efficiency
published: true
---

## Goals
To get a better understanding of the time complexity of operations with an array-based list compared to a linked list. 

## Setup
* [Mount the COURSES drive](getting-started)
* Create a new folder in your STUWORK called `ArrayLab`
* Create a document Answers.txt where you'll write your answers to some questions below

## Exercise 1
Here is a function from an array-based list implementation for getting the item at a particular index:

```java
public String get(int position) {
    if(position<0){
        throw new IndexOutOfBoundsException();
    } else if(position<numItems) {
        return array[position];
    } else {
        throw new IndexOutOfBoundsException();
    }
}
```
This array-based list maintains the following instance variables:
* `numItems` is an integer representing the number of items in the list
* `capacity` is an integer representing the actual size of the array (i.e. `array.length`)
* `array` is the array that holds the items in the list

a. In terms of the number of items in the array, which you should call `n`, how many basic operations are executed by this function in the worst case? (Don't over think this!)

b. What is the Big-O of this function? Justify your answer by demonstrating values for C and n<sub>0</sub>, as you did in the [Analysis Lab](analysis-activity).

c. How does this compare to the time complexity of retrieving an item from a linked list?

## Exercise 2
Here is a function from the same array-based list implementation for adding to the end of the array:
```java
    public void add(String newItem) {
        if(numItems == capacity) {
            String[] oldArray = array;
            capacity = capacity * 2;
            array = new String[capacity];
            for(int i = 0; i<numItems; i++){
                array[i] = oldArray[i];
            }
        }
        array[numItems] = newItem;
        numItems++;
    }
```

a. In terms of the number of items in the array, which you should call `n`, how many basic operations are executed by this function in the worst case?

b. What is the Big-O of this function? Justify your answer by demonstrating values for C and n<sub>0</sub>, as you did in the [Analysis Lab](analysis-activity).

c. How does this compare to adding to the end of a linked list if you have a `tail` or `lastNode` pointer?


## Exercise 3
It's your turn to write some code. Download the file [`StringArrayList.java`](StringArrayList.java). This class has the two methods that you already analyzed and a whole bunch of not-yet-implemented methods. 

a. First, implement a method of the array-based list for adding an item at a specific position in the array: `add(int index, String newItem)`

b. In terms of the number of items in the array, which you should call `n`, how many basic operations are executed by this function in the **worst case**?

c. What is the Big-O of this function? Justify your answer by demonstrating values for C and n<sub>0</sub>, as you did in the [Analysis Lab](analysis-activity).

d. How does this compare to adding to a specific position of a linked list?

## Extensions
If you finish early and want to get more practice, figure out the answers for the other not-yet-implemented methods.