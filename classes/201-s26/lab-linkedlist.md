---
layout: page
title: Linked List Lab
permalink: /classes/201-f25/linked-list-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `LinkedListLab` in your STUWORK/username folder and open it in VSCode for today's labwork.

Copy the starter code from [LinkedUL.kt](/classes/201-s26/LinkedUL.kt) in your folder. This code is slightly altered from the reading to add a couple more helpful things (`getNode`, a slightly nicer `toString`, making `head` protected).

## Exercise 1: Cycle Detection
Being able to detect "cycles" in a sequences of items is fundamental to many algorithms for security and modern computing, including [cryptography](https://en.wikipedia.org/wiki/Pollard%27s_rho_algorithm_for_logarithms#:~:text=Pollard%2C%20J.%20M.%20(1978).,Handbook%20of%20Applied%20Cryptography.), [networks](https://www.inf.ufsc.br/~bosco.sobral/ensino/ine5645/Computer-Networks---A-Tanenbaum---5th-edition.pdf), and even detecting money laundering! By representing these items as nodes in a linked list, we can easily perform ["Floyd's Cycle-Finding Algorithm"](https://en.wikipedia.org/wiki/Cycle_detection).

Grab the start of the subclass [`CyclicLinkedList`](/classes/201-s26/CyclicLinkedList.kt). It has an updated `toString` that will be able to handle cycles (what would happen with the original `toString`?) once you have implemented `findCycle`. There is also some test code with possible money laundering trails!

Here is how you should approach detecting a cycle using the "tortoise and hare" approach:
* Create two variables `slow` and `fast` that initially point to the head of your list
* `slow` steps forward one node at a time, as we would usually traverse a linked list
* `fast` steps forward two nodes at a time
* If `slow` and `fast` ever point to the same node, there is a cycle!

## Extra

If you finish early, try out implementing these methods:

* `removeFirstNode()`
* `removeLastNode()`
* `insertAtPosition(position: Int, item: T)`
* `deleteAtPosition(position: Int)`
* `deleteSubList(start: Int, end: Int)`