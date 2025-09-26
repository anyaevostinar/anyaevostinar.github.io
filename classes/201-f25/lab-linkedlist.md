---
layout: page
title: Linked List Lab
permalink: /classes/201-f25/linked-list-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `LinkedListLab` in your STUWORK/username folder and open it in VSCode for today's labwork.

## Implementing a linked list

Consider the following start of a linked-list implementation in Kotlin:

```kotlin
class SinglyLinkedList<T> {

    // This "private" "data class" is visible only within the SinglyLinkedList
    // class, and contains only data with no additional functions (besides a
    // few that Kotlin provides, like for printing it)
    private data class Node<T>(
        var item: T,
        var next: Node<T>?)

    // We'll maintain just a reference to the head of the linked list
    // (which may be null, in the case the list is empty)
    private var head: Node<T>? = null

    fun insertAtBeginning(item: T) {
        // The current head will be the next node after this new node
        val newNode = Node(item, head)

        // Put this new node at the head, inserting it
        head = newNode
    }

    fun insertAtEnd(item: T) {
        // The new node will be at the end, so it won't have anywhere
        // to point (hence, its next is null)
        val newNode = Node(item, null)

        // If the list is empty, we just make the new node the head
        if (head == null) {
            head = newNode
            return
        }

        // If not, we need to step through the list until we find
        // a node with its next set to null (that's the end)
        var current: Node<T>? = head
        while (current!!.next != null) { // at first current isn't null
            current = current.next
        }

        // We found the end!  Put the new node just after it
        current.next = newNode
    }
}
```

## Time complexity

1. What is the time complexity of `insertAtBeginning`, assuming there are already `n` elements in the linked list?

2. What about `insertAtEnd`?

## Iterating through a linked list

Implement the following functions based on what you know about iterating through a linked list (and refer to `insertAtEnd` for help):

```kotlin
    override fun toString(): String { }

    fun length(): Int { }

    fun search(target: T): Boolean { }
```

Here is some additional code to help you test:

```kotlin
fun main() {
    val list = SinglyLinkedList<String>()

    // Try adding some things
    list.insertAtBeginning("apple")
    list.insertAtBeginning("banana")
    list.insertAtBeginning("canteloupe")

    // Now try searching
    println(list.search("apple"))
    println(list.search("banana"))
    println(list.search("canteloupe"))
    println(list.search("durian"))

    // Let's print some things
    println(list)
    println(list.length())

    // What if we put something at the end?
    list.insertAtEnd("starfruit")
    println(list)
}
```

Submit your completed linked list implementation to Moodle for an engagement credit.

## Extra

If you finish early, try out implementing these methods:

* `removeFirstNode()`
* `removeLastNode()`
* `insertAtPosition(position: Int, item: T)`
* `deleteAtPosition(position: Int)`
* `deleteSubList(start: Int, end: Int)`