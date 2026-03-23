---
layout: page
title: Doubly Linked List Lab
permalink: /classes/201-f25/doubly-ll-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `DLLLab` in your STUWORK/username folder and open it in VSCode for today's labwork.


In this lab, you will add functionality to a doubly linked list.

## Goals

The purpose of this lab is to get practice working with `next` and `prev` pointers in a doubly linked list, as well as thinking carefully about updates to the `head` and `tail`.

## Getting started

For this lab, you'll start with a simple skeleton of a doubly linked list, given below.  Copy this to a file `DoublyLinkedList.kt`.

```kotlin
class DoublyLinkedList<T> {

    // We'll keep this class a secret to ourselves; no one using
    // a doubly linked list has to know about how we've stored the
    // data and pointers.
    //
    // Food for thought: why do we need next and prev, in particular,
    // to be declared with var instead of val?
    private data class Node<T>(
        var item: T,
        var next: Node<T>?,
        var prev: Node<T>?)

    // The list knows which nodes, if any, are at its
    // head and tail
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    // Let's make it easy to print
    override fun toString(): String {
        var result: String = ""
        var current: Node<T>? = head
        while (current != null) {
            result = result + current.item + " "
            current = current.next
            // ponder: why don't we need !! in the above two lines?
        }
        return result.trim() // take off that extra " "
    }

    // We should, at the least, be able to insert somewhere
    fun insertAtBeginning(item: T) {
        // Our new node has the current head as its next (which may be null)
        // and no prev, because it'll be at the beginning
        val newNode = Node(item, head, null)

        // Wire up the previous head to have our new node as its prev
        val oldHead: Node<T>? = head
        if (oldHead != null) {
            oldHead.prev = newNode
        }

        // Now see if this new node is also the tail (ponder: it what
        // situation is this true?)
        if (tail == null) {
            tail = newNode
        }

        // Now properly update the head pointer for the list
        head = newNode
    }
}
```

## Part A

To get started, let's make some sense of what we've got and try our hand at a small list-walking function.

#### Time complexity

What is the time complexity of `insertAtBeginning`, assuming there are already `n` elements in the list?

What should be the time complexity of a method `insertAtEnd`, assuming there are already `n` elements in the list, given that we have an instance variable `tail`?  What if we didn't?

#### Warm up

First, implement the `length` method.  For extra fun, see if you can compute the length by walking backwards instead of forwards.

Here's the code to add:

```kotlin
    // TODO: get the length of the list
    fun length(): Int {
        return 0
    }
```

## Part B

Now, let's dig in.  Try implementing each of the `insertAtEnd`, `search`, and `insertAtPosition` methods (the last one should use `findNodeAtPosition`, which you should implement, as well).  Make sure to keep careful track of both the `head` and `tail`, as well as any `next` and `prev` pointers you need to update.

```kotlin
    // TODO: insert at the tail
    fun insertAtEnd(item: T) {

    }

    // TODO: find an element in the list
    fun search(target: T): Boolean {
        return false
    }
    
    // TODO: look up the node at a given position
    private fun findNodeAtPosition(position: Int): Node<T>? {
        return null
    }

    // TODO: insert at a given position
    fun insertAtPosition(position: Int, item: T) {

    }
```

Here is a `main` function to help you test it out:

```kotlin
fun main() {
    // First, test basic inserts and prints
    val mylist = DoublyLinkedList<String>()

    mylist.insertAtBeginning("Lulu")
    mylist.insertAtBeginning("Hobbes")
    mylist.insertAtBeginning("Cheddar")

    println()
    println("List with 3 elements: $mylist")

    // Now try checking the length and inserting at the end
    println("Length: ${mylist.length()}")
    mylist.insertAtEnd("Marshmallow")
    println()
    println("List with 4 elements: $mylist")
    println("Length: ${mylist.length()}")

    // What if we look for an element?
    println()
    println("List contains \"Lulu\": ${mylist.search("Lulu")}")
    println("List contains \"LULU\": ${mylist.search("LULU")}")

    // Can we insert just anywhere?
    mylist.insertAtPosition(2, "Sadie")
    mylist.insertAtPosition(1, "Therese")
    println()
    println("List with 6 elements: $mylist")
}
```

## Part C

Now that you've gotten some practice working with all of the various pointers available in a doubly linked list, trying writing the method `swapWithNeighbor`:

```kotlin
    // TODO: swap the given node with its next neighbor
    // (make sure to update head/tail if appropriate)
    // NOTE: assumes curr is not the tail
    private fun swapWithNeighbor(curr: Node<T>) {

    }

    // Swap the node at the given position with its next neighbor
    // (fails if position is out of bounds or corresponds to the tail)
    fun swapPositionWithNeighbor(position: Int) {
        // Find the node, if it exists
        val current: Node<T>? = findNodeAtPosition(position)

        // If the node to swap is the tail, that's a problem
        if (current == tail) {
            throw RuntimeException("Cannot swap the tail with its next!")
        }

        // Swap the node with its next neighbor
        swapWithNeighbor(current!!)
    }
```

Here is an addition to main that you can use to test this function:

```kotlin
    // What if we swap some nodes?
    mylist.swapPositionWithNeighbor(1)
    println()
    println("List after swapping node at position=1 with its next: $mylist")
    mylist.swapPositionWithNeighbor(4)
    mylist.insertAtEnd("Milo")
    println("List after swapping node at position=4 with its next and adding to tail: $mylist")
```

Submit your completed `DoublyLinkedList.kt` to Moodle for an engagement credit.

## Deque
Now that you have a doubly-linked list, try implementing a deque with your doubly-linked list as the underlying data store.

## Want more to do?

If you finish early, try out implementing deletion from a doubly linked list, either at the beginning/end or at a given position in the middle.

As before, make extra careful to handle `next` and `prev`, as well as `head` and `tail`, carefully for any node you're touching, and the list as a whole.

&nbsp;