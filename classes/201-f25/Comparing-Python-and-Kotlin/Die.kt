/*
 * Die.kt
 * Tanya Amert, 2025-03-31
 * Based on Die.java by Jeff Ondich, Anna Rafferty
 *
 * A simple class representing an n-sided die (as used in various board games).
 * 
 * After running this class, make a variable that represents a 9-sided die, and
 * then print out the result of rolling it.  Which lines in the file represent the 
 * constructor for the die object?
 *
 * This is the Kotlin half of a pair of parallel examples in Python and Kotlin.
 * See die.py.
 */

import kotlin.random.Random

class Die(val n: Int) {
    // These are the instance variables (like the "self.*" stuff in Python)
    val numberOfSides: Int = n // val: always has value n
    var currentValue: Int = 1  // var: its value will vary
    
    fun roll(): Unit { // returns nothing
        currentValue = Random.nextInt(1, numberOfSides+1) // exclusive end of range
    }

    fun getValue(): Int {
        return currentValue
    }

    fun setValue(newValue: Int): Unit {
        currentValue = newValue
    }
}

fun main() {
    // Let's play Yahtzee
    val dice: MutableList<Die> = mutableListOf()
    dice.add(Die(6))
    dice.add(Die(6))
    dice.add(Die(6))
    dice.add(Die(6))
    dice.add(Die(6))

    for (die: Die in dice) {
        die.roll()
    }

    var total: Int = 0
    for (die: Die in dice) {
        print("${die.getValue()} ")
        total += die.getValue()
    }
    println("\nTotal: $total")

    if (dice[0].getValue() == dice[1].getValue() &&
        dice[1].getValue() == dice[2].getValue() &&
        dice[2].getValue() == dice[3].getValue() &&
        dice[3].getValue() == dice[4].getValue()) {
        println("Yahtzee!");
    }
}