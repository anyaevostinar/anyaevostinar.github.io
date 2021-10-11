---
layout: page
title: Array Efficiency Lab
permalink: /classes/201-f21/array-efficiency
published: true
---

## Goals
To get a better understanding of the time complexity of operations with an array-based list compared to a linked list. 

## Logistics
This is a lab assignment that you'll be handing in on Moodle. You should complete it on Monday Oct 11th, but it isn't due until Wednesday Oct 13th at 5:00pm Central.

There is no coding in this assignment, so you will submit a PDF of your solutions. You have several options for how to produce this PDF:
* Write it by hand and scan it into a PDF. If you do this, you must write very neatly and clearly. Make sure to check that your scan is completely legible!
* Write it in a word processing program, then export or print it to PDF.
* Write it in LaTeX and typeset it as a PDF. LaTeX is complicated to use at first but allows you to format math very nicely. [Overleaf.com](https://www.overleaf.com/) is a nice website to use for writing LaTeX. 

I recommend just using a word processing program and exporting/printing to PDF!

You should work on this with your in-class partner, but you both need to submit separately and therefore, if you are writing on paper, you both need to be writing your own copies.
If you finish it outside of class without your partner, note which sections you completed together and which you completed separately in your Collaborations section.

## Exercise 0
Create a Collaborations section of your document and describe any people you get help from on this lab. Also note any outside sources such as websites that you referenced. 

## Exercise 1
Here is a function from an array-based list implementation for getting the item at a particular index:

```
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
```
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
Here is another method of the array-based list for adding an item at a specific position in the array:
```
   public void add(int index, String newItem) {
        if(index == numItems) {
            add(newItem);
            return;
        } else if(index>numItems) {
            throw new IndexOutOfBoundsException();
        }
        
        if(numItems == capacity) {
            String[] oldArray = array;
            capacity = capacity * 2;
            array = new String[capacity];
            for(int i = 0; i<index; i++){
                array[i] = oldArray[i];
            }
            array[index] = newItem;
            for(int i = index; i<numItems; i++) {
                array[i+1] = oldArray[i];
            }
        } else {
            for(int i = numItems-1; i>=index; i--) {
                array[i+1] = array[i];
            }
            array[index] = newItem;
        }
        numItems++;
        
    }
```

a. In terms of the number of items in the array, which you should call `n`, how many basic operations are executed by this function in the **worst case**?

b. What is the Big-O of this function? Justify your answer by demonstrating values for C and n<sub>0</sub>, as you did in the [Analysis Lab](analysis-activity).

c. How does this compare to adding to a specific position of a linked list?

## Submitting
This lab is not a homework assignment. That means that you're evaluated on whether you attempted all parts of it, but your work will not be graded for correctness as long as a clear effort has been made. If you aren't able to complete some parts, great ways to indicate clear effort are to reach out for help before the deadline (note ways you did so in your Collaboration section) and to use comments in the document to indicate things you tried but what went wrong/where you got stuck.

Remember that you need to submit your lab separately from your partner.

## Extensions
If you finish early and want to get more practice, figure out the answers for removing an item from the list as well.