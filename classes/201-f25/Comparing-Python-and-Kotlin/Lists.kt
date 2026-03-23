/*
 * Lists.kt
 * Tanya Amert, 2025-03-31
 * Based on Lists.java by Jeff Ondich, Anna Rafferty
 *
 * Demonstrates a few operations with Kotlin lists.
 *
 * This is the Kotlin half of a pair of parallel examples in Python and Kotlin.
 * See lists.py.
 */

fun main() {
    // Initialize
    val animalList: MutableList<String> = mutableListOf("goat", "moose", "emu", "kudu")

    // Add an item
    animalList.add("beaver")

    // Insert an item in the third position
    animalList.add(2, "gnat")

    // Iterate over the items in the list using a for loop
    println("Animals iterated using a for/in loop")
    for (animal: String in animalList) {
        println(animal)
    }

    println()
    println("Animals iterated using an index")
    for (k: Int in 0..<animalList.count()) {
        println(animalList[k])
    }
}