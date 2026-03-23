/*
 * Loops.kt
 * Tanya Amert, 2025-03-31
 * Based on Loops.java by Jeff Ondich, Anna Rafferty
 *
 * Demonstrates a few simple loops.
 *
 * Try a few things:
 * 1) Modify the while-loop so that it counts down from 10 to 0, printing the final 0.
 *
 * 2) Make a for-loop that counts out multiples of 3.
 * 
 * 3) Explore what happens if you change the value of k or j within the corresponding for
 *    loop. How does this differ from the similar loop in Python? What happens if you try
 *    to access k inside of the loop about j? Explain to yourself the rules for where you 
 *    can access the different variables.
 *
 * This is the Kotlin half of a pair of parallel examples in Python and Kotlin.
 * See loops.py.
 */

fun main() {
    println("Counting up with a while loop")
    var m: Int = 0
    while (m < 5) {
        println(m)
        m++
    }

    println("Counting up with a for/in loop")
    for (k: Int in 0..<5) { // use ..< to stop before 5
        println(k)
    }

    println("Counting evens with a for/in loop")
    for (k: Int in 0..<5 step 2) {
        println(k)
    }

    println("Counting down with a for/in loop")
    for (k: Int in 5 downTo 1) {
        println(k)
    }
}