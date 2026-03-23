/*
 * Conditionals.kt
 * Tanya Amert, 2025-03-31
 * Based on Conditionals.java by Jeff Ondich, Anna Rafferty
 *
 * A tiny illustration of if-statements and console input.
 *
 * This is the Kotlin half of a pair of parallel examples in Python and Kotlin.
 * See conditionals.py.
 */

fun main() {

    // Get the number from the user
    print("Number, please: ")
    val numberString: String? = readLine()   // it could be null
    val number: Int = numberString!!.toInt() // so we assume it's not, forcefully :)

    // Print a message based on the number
    when {
        number > 100 -> println("Gosh, $number is a big number")
        number == 3 -> println("3 is my lucky number")
        number >= 0 -> println("$number is pretty little")
        else -> println("$number is negative")
    }
}