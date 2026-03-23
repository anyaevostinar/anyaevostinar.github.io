/*
 * LineReader.kt
 * Tanya Amert, 2025-03-31
 * Based on LineReader.java by Jeff Ondich, Anna Rafferty
 *
 * A very brief introduction to reading and writing from a file,
 * excessively commented for tutorial purposes.
 *
 * This is the Kotlin half of a pair of parallel examples in Python and Kotlin.
 * See linereader.py.
 *
 * Try a few things:
 *
 * 1. Look at the small text file called somelines.txt and then compile and run LineReader.
 *    ("kotlinc LineReader.kt" followed by "kotlin LineReaderKt.class")
 *
 * 2. What happens when you change the inputFilePath variable to "nonexistent.txt"?
 *
 * 3. What happens when you remove the try/catch blocks and just do
 *    "inputFile.forEachLine() { ... }"?
 *
 * 4. Visit the Kotlin String documentation and play around with some String
 *    methods other than uppercase.
 */

import java.io.File // it's secretly Java under the hood
import java.io.FileNotFoundException
import kotlin.system.exitProcess

fun main() {
    // Create a File object connected to the file you want to read
    val inputFilePath: String = "somelines.txt"
    val inputFile: File = File(inputFilePath)

    // Actually reading from the file can result in an exception, so
    // that's why there is a try/catch block to catch the exception.
    // It allows the programmer to build in a way for the program to
    // recover from the error (in this case, by just printing the error
    // for the user).
    var numberOfLines: Int = 0
    try {
        // Get one line at a time from the file, and print each line in upper
        // case to standard output
        inputFile.forEachLine() {
            println(it.uppercase()) // it refers to each element of the sequence from forEachLine()
            numberOfLines++
        }
    } catch (e: FileNotFoundException) {
        println(e)     // to stdout not stderr, but close enough
        exitProcess(1) // anything nonzero is an error status code
    }

    println("Number of lines: $numberOfLines")
}