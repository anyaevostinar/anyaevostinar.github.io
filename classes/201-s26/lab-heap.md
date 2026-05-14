---
layout: page
title: Heaps Lab
permalink: /classes/201-s26/heaps-lab
published: true
---

## Goals
To better understand a heap and priority queue by implementing different versions and applying them to solve problems.

## Setup
Mount the COURSES drive and remember to save everything into STUWORK. **If you don't do this, everything you write will disappear when you log out!!!!**
* Create a new folder in your STUWORK called `HeapsLab`
* Download the [starter code](/classes/201-s26/HeapStarter.kt) and put it into your lab folder
* Open your `HeapsLab` folder in VSCode

## Exercise 1: Max Heap
The reading showed you a min heap implementation, but we are going to want to have access to both a max and min heap for some of these problems. 
Since a max heap differs in very small ways from a min heap, this is a great time for inheritance!

1. Your first task is to edit the `Heap` in `HeapStarter` to be an [**abstract** class](https://runestone.academy/ns/books/published/kotlinds/oop_abstract_interfaces.html?mode=browsing) with all the functionality that differs between min and max isolated in an `abstract` function. Determine the answers to these questions to guide you:
    * Which functions will differ between a min and a max heap?
    * How can you make a helper function that can *encapsulate* that difference? (Note, we want only one function to need to be abstract to reduce code duplication.)

2. Once you have your plan in place, edit `Heap` to be abstract and create two new files `MinHeap.kt` and `MaxHeap.kt` that inherit from `Heap` (and `import Heap`), but have just a single function implemented.

3. Test both of them by **adapting** the test code from the reading:
```
fun main() {
    val myPq = BinaryHeapPriorityQueue<Int>()
    myPq.insert(5)
    myPq.insert(7)
    myPq.insert(3)
    myPq.insert(11)
    println("Min value: " + myPq.peek())

    println("Deleting items: ")
    println(myPq.delete())
    println(myPq.delete())
    println(myPq.delete())
    println(myPq.delete())
}
```

4. Remember that you can compile multiple Kotlin files together by just including them all on the `kotlinc` line:
```bash
kotlinc HeapStarter.kt MinHeap.kt
kotlinc HeapStarter.kt MaxHeap.kt
kotlin MinHeapKt
kotlin MaxHeapKt
```

## Exercise 2: MedianTracker
A combination of a min and a max heap can be used to efficiently track the median of a sequence of numbers on the fly. Create a new class (in a new file) called `MedianTracker` that contains the following:
* a `MinHeap` and `MaxHeap` of `Int`s,
* a function `fun insert(element: Int)` that places the new element in the appropriate heap and rebalances the heaps if necessary,
* a function `fun getMedian(): Double? ` that returns the middle value if there are an odd number of elements in the `MedianTracker` or the mean of the two middle values if there are an even number of elements; if the tracker is empty, you should return `null`,
* a `toString` that returns a string representation of both of the heaps (you can just call their `toString` functions here).

Here is some basic test code, though you should add to it to be sure of your functionality:
```kotlin
fun main() {
    val tracker = MedianTracker()
    tracker.insert(5)
    println(tracker.getMedian()) // 5.0
    tracker.insert(7)
    println(tracker.getMedian()) // 6.0
    tracker.insert(3)
    println(tracker.getMedian()) // 5.0
    tracker.insert(11)
    println(tracker.getMedian()) // 6.0

    println("Tracker state: $tracker")
    tracker.insert(1)
    println(tracker.getMedian()) // 5.0

}
```

## Exercise 3: To-do list
Let's implement that todo list tracker! You'll want a small class to track tasks along with their priority that can also compare itself, so here you go:
```kotlin
data class Task(val description: String, var priority: Int): Comparable<Task> {
    override fun compareTo(other: Task): Int {
        return this.priority - other.priority
    }
}
```
1. You should first:
    * Create a `ToDoList` class that inherits from `MinHeap<Task>`
    * Create some wrapper functions `addTask(task: Task)`, `checkNextTask()` and `completeNextTask()` that call the appropriate `MinHeap` functions

2. Sometimes you need to update the priority of tasks (like when a due date gets extended!). Update your `ToDoList` class to have an `updateTaskPriority(description: String, newPriority: Int)` function. To do this efficiently, you'll need to also have a map that keep track of the indices of tasks within the heap, so that you can go right to them. Think carefully about how you can implement that by answering these questions:
    * Where in the `Heap` code does the index of an item change? How can you make sure that your indices get properly updated then?
    * How can you correctly move the updated task up or down in the heap?

3. Another useful functionality for your to-do list would be to adjust everything else when something really important comes up. Figure out how to implement a `increaseAllGreaterPriorities` function that would increment the priority levels of everything less important than the new item. 

## Submission
Submit your completed `MedianTracker` and `ToDoList` to Moodle for an extra engagement credit.

## Extra: Alternate Priority Queue
While a heap is a great way to implement a priority queue if all you want is the top priority item, it doesn't work as well if you want a specific range of priority items. For example, if I'm making my to-do list for the day, I might want the items that are priority 1-3 and then 4-10. In this case, you would actually want to use a balanced binary search tree to implement the priority queue. Adapt either your 2-3 tree code or the reading's AVL tree code to serve as a priority queue for your todo list.