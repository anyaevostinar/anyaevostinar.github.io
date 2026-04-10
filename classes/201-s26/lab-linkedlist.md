---
layout: page
title: Linked List Lab
permalink: /classes/201-s26/linked-list-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `LinkedListLab` in your STUWORK/username folder and open it in VSCode for today's labwork.

Copy the starter code from [LinkedUL.kt](/classes/201-s26/LinkedUL.kt) in your folder. This code is slightly altered from the reading to add a couple more helpful things (`getNode`, a slightly nicer `toString`, making `head` protected).

## Exercise 1: MinMaxList
While a linked list is not ordered, we can make another variation that keeps track of the maximum and minimum of the items.

1. Create a new file `MinMaxLL.kt` and define a class `MinMaxLL`:
```kotlin
import LinkedUnorderedList
class MinMaxLL() : LinkedUnorderedList<Int>() {
    var min: Int? = null
    var max: Int? = null
}
```

2. Within your class, override the `addFirst(item: Int)` method to call `super.addFirst(item)` and then update the `min` or `max` if necessary. You'll need to deal with null safety for the `min` and `max` variables, which will be easiest to do by making local `val`s of each. You could also try out using Kotlin's `compareValues(a, b)`, which returns less than 0 if a < b and greater than 0 if a > b, but also considers null less than any non-null value (so you'll want to combine it with directly checking for `min == null`).

3. Check to make sure that your `addFirst` works correctly with this test code:
```kotlin
fun main() {
    val list = MinMaxLL()
    list.addFirst(5)
    println(list)
    println("Min: ${list.min} Max: ${list.max}\n") // Min: 5 Max: 5
    list.addFirst(3)
    println(list)
    println("Min: ${list.min} Max: ${list.max}\n") // Min: 3 Max: 5
    list.addFirst(7)
    println(list)
}
```

4. You'll also need to override `remove(item: Int)` method in case the removed item was the min or max of the list by doing the following:
    * Again first call `super.remove(item)`, 
    * then check if the item removed was the max or min,
    * if it was, you'll need to traverse through the list to reset the max and min

5. Test that your code works by adding the following to your `main`:
```kotlin
println("Min: ${list.min} Max: ${list.max}\n") // Min: 3 Max: 7
list.remove(3)
println(list)
println("Min: ${list.min} Max: ${list.max}\n") // Min: 5 Max: 7
list.remove(7)
println(list)
println("Min: ${list.min} Max: ${list.max}\n") // Min: 5 Max: 5
```

## Exercise 2: Cycle Detection
Being able to detect "cycles" in a sequences of items is fundamental to many algorithms for security and modern computing, including [cryptography](https://en.wikipedia.org/wiki/Pollard%27s_rho_algorithm_for_logarithms#:~:text=Pollard%2C%20J.%20M.%20(1978).,Handbook%20of%20Applied%20Cryptography.), [networks](https://www.inf.ufsc.br/~bosco.sobral/ensino/ine5645/Computer-Networks---A-Tanenbaum---5th-edition.pdf), and even detecting money laundering! By representing these items as nodes in a linked list, we can easily perform ["Floyd's Cycle-Finding Algorithm"](https://en.wikipedia.org/wiki/Cycle_detection).

Grab the start of the subclass [`CyclicLinkedList`](/classes/201-s26/CyclicLinkedList.kt). It has an updated `toString` that will be able to handle cycles (what would happen with the original `toString`?) once you have implemented `findCycle`. There is also some test code with possible money laundering trails!

Here is how you should approach detecting a cycle using the "tortoise and hare" approach:
* Create two variables `slow` and `fast` that initially point to the head of your list
* `slow` steps forward one node at a time, as we would usually traverse a linked list
* `fast` steps forward two nodes at a time
* If `slow` and `fast` ever point to the same node, there is a cycle!

Here is a visualization just before the `slow` tortoise and `fast` hare collide:

<center><image src="/classes/201-s26/tortoiseHare.png" alt="Diagram of cyclic linked list with tortoise and hare cartoons about to collide" height="400px"/></center>

Implement this algorithm in `findCycle` and then compile and run with the following to determine which money trail has a money laundering scheme:
```bash
kotlinc LinkedUL.kt CyclicLinkedList.kt
kotlin CyclicLinkedListKt.class 
```

## Exercise 3: CRISPR
We can also use linked lists to model strands of DNA! In this exercise, you'll implement a simplified version of the [CRISPR-Cas9 mechanism](https://medlineplus.gov/genetics/understanding/genomicresearch/genomeediting/), which allows scientists to snip out sections of a DNA strand based on a template, for example to remove a mutated gene. 

1. Copy the file [Crispr.kt](/classes/201-s26/Crispr.kt) into your lab folder. It contains the start of a class `DNAStrand` that ensures that the nodes can only have one of the four DNA bases A, C, G, and T. It also contains stubs for the methods that you'll implement and some test code.


4. Before you can snip out a mutation, you need to be able to find where a given template matches the DNA strand. Write a function `matchesTemplate` based on this stub (that is in the starter code as well):
```kotlin
/**
* Input: A node in the DNA strand to start the match at and a list of characters to check for a match
* Output: Null if no match, otherwise the node past the end of the matching sequence in the linked list
*/
fun matchesTemplate(current: Node<Char>?, template: List<Char>): Node<Char>? {
    //TODO
    return null
}
```

5. Use this section of `main` to test your code so far:
```kotlin
fun main() {
    val strand = DNAStrand()
    strand.addSequence(listOf('A', 'C', 'G', 'T'))
    println("${strand}") 
    val endNode = strand.matchesTemplate(strand.getNode(0), listOf('A', 'C')) // should return node containing 'G'
    println("Node past the end of matching template in the strand (should be G): ${endNode?.data}")
}
```
You should get:
```bash
head-> [A|-]-> [C|-]-> [G|-]-> [T|-]-> null
Node past the end of matching template in the strand (should be G): G
```

6. Now you're ready to implement `snipMutation(mutation: List<Char>)`, which needs to traverse the `DNAStrand`, checking for a match to the mutation starting at each node. If it find the mutation, it should splice out the nodes containing the mutation. Your method will be fairly similar to `remove` in `LinkedUnorderedList`, so you can look to that for guidance, but think about what you need to do differently.

7. Uncomment the rest of the test code and make sure that you get:
```bash
head-> [A|-]-> [T|-]-> null
head-> [A|-]-> [T|-]-> [A|-]-> [C|-]-> [G|-]-> [T|-]-> null
```

## Submission
Once you complete these three exercises, submit your completed files to Moodle for an extra engagement credit. Remember that the labs are open until the last day of class, so there is no rush, but it is great practice to complete these.

## Extra
There is a lot more that can be done with the CRISPR simulation:
* Sometimes we want to insert a new sequence of bases into the spot that the template matches. Make a new method `insertDNA` that takes both a template to match to and a new sequence to inject at the end of the template.
* In real life, CRISPR will affect all occurrences of the template, not just the first, update your model to reflect that. Be careful of edge cases such as overlapping templates!
* DNA is actually double-stranded where each A must pair with a T in the other strand and each C must pair with a G. In computer science, this is called a Multi-Linked List. Update your model to have two strand and each has a connection to its pair in the other list. (You'll need to get creative in how you alter `Node` and probably will want to stop inheriting from `LinkedUnorderedList` at this point, though you could also have a new `DNA` class that holds two `DNAStrands` and maintains the connection between them too.)