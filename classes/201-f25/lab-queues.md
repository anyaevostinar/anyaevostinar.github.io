---
layout: page
title: Queues Lab
permalink: /classes/201-f25/queues-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `QueuesLab` in your STUWORK/username folder and open it in VSCode for today's labwork.

## Implementing a circular queue

1. Copy this interface for a Queue into a file `QueueInt.kt`:

    ```kotlin
    interface Queue<T> {
        fun isEmpty(): Boolean
        fun enqueue(item: T)
        fun dequeue(): T?
        override fun toString(): String
    }
    ```

2. Create a new file `CircularQ.kt` and create a class `CircularQueue<T>` that implements the `Queue<T>` interface (remember to start with just "stubs" of methods that don't do anything but return the right thing so that you can compile and test as you go.) **Don't jump into implementing all the methods yet!**

3. Create the following instance variables: 
    * `items` that is a `MutableList<T>` to hold your data
    * `front` that starts with -1
    * `rear` that also starts with -1 (make sure you understand why that is a good value to start with) 

4. `enqueue` has quite a few cases that you need to consider, so start with just implementing the situation where the queue is empty and you are adding the first item.

5. Make sure that your code compiles with the following test code:

    ```kotlin
    fun main() {
        val q = CircularQueue<Int>()
        q.enqueue(1)
    }
    ```

6. Implement a preliminary version of `toString` that ignores the fact that `front` could move and then use that to make sure that your queue has "1" in it.

7. Circular queues need to grow carefully to keep their items in the right locations relative to each other. Implement the case for `enqueue` when the queue is full, keeping the following in mind:
    * How do you know the queue is full based on the values of `front` and `rear`?
    * If `front` is 0, you can just call `add` normally
    * If `front` isn't 0, you need to grab the items from `items` in two sections, one from `front` to the end of `items` and another from `0` to `rear`, using `subList`
    * You can append another list with `addAll`
    * Make sure to test your code by adding some more `enqueue` lines to your `main`

8. Now is a good time to also implement the case when there is room in the queue and it wasn't empty.

8. It's time to implement `dequeue`. Be sure to consider the case where you are removing the last item from the queue and when the queue is already empty.

9. Once you start dequeuing, you need your `toString` to take that into account. Update your `toString` to handle the case where `front` isn't 0 and make sure your `dequeue` is working correctly.

10. There is one more case for `enqueue` that you need to consider. Implement the case where the queue has become empty but `items.size` isn't 0.

11. Make sure that your code correctly works for these tests:

    ```kotlin
    fun main() {
        val q = CircularQueue<Int>()
        q.enqueue(1)
        q.enqueue(2)
        q.dequeue()
        q.enqueue(3)
        q.enqueue(4)
        q.enqueue(5)

        println(q)

        q.dequeue()

        println(q)
        q.dequeue()
        q.dequeue()
        q.dequeue()

        q.enqueue(6)
        println(q)
    }
    ```

## Implementing a linked queue

1. Create a new file `LinkedQ.kt` and implement the `Queue<T>` interface with `LinkedQueue<T>`. Note that you can and should add a variable `rear` that tracks the end of the linked list for dequeuing. You'll want to use the `Node<T>` data class from before:

    ```kotlin
        private data class Node<T>(
        var item: T,
        var next: Node<T>?)
    ```

2. Test your code with the same tests as the circular queue:

    ```kotlin
    fun main() {
        val q = LinkedQueue<Int>()
        q.enqueue(1)
        q.enqueue(2)
        q.dequeue()
        q.enqueue(3)
        q.enqueue(4)
        q.enqueue(5)

        println(q)

        q.dequeue()

        println(q)
        q.dequeue()
        q.dequeue()
        q.dequeue()

        q.enqueue(6)
        println(q)
    }
    ```


## Extra
Submit your queue implementations to Moodle for an engagement credit and then try out implementing the following for both of your classes:
* `peek()`
* `clear()`
* `size()`

How does the time complexity for each implementation compare for these methods? How would any of them be impacted if your reversed the `front` and `rear` of your queues?
