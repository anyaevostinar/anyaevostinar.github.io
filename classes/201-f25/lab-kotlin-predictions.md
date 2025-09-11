---
layout: page
title: Kotlin Predictions Lab
permalink: /classes/201-f25/kotlin-predictions-lab
---

## Exercise 1: Conditionals and loops in Kotlin

#### 1a: Conditionals

Predict the output of the following code:

```kotlin
val x: Int = 4
val y: Int = 10
val z: Int = 8

if (x != y) {
    println(2+x)
} else {
    println(y-x)
}

when {
    x > y -> println("a")
    x == y -> println("b")
    y > z -> println("c")
    x < z -> println("d")
    else -> println("e")
}

z += 2

if (y == z) {
    println("They're the same now!")
}

```

[Test your predictions](https://play.kotlinlang.org/)

#### 1b: Loops

Predict the output of the following code: 

```kotlin
for (x: Int in 1..5) {
    println(x * x)
}

for (x: Int in 2..<8 step 2) {
    println(x)
}

for (x: Int in 10 downTo 1 step 3) {
    println(x)
}

for (s: String in listOf("apple", "banana", "canteloupe")) {
    println("String: $s")
}

var y = -10
while (y > 0) {
    println(y)
    y -= 4
}

var z = -10
do {
    println(z)
    z -= 4
} while (z > 0)
```

[Test your predictions](https://play.kotlinlang.org/)

## Exercise 2: Functions

Predict the output of the following program:

```kotlin
fun greet() {
    print("What is your name? ")
    val name: String? = readLine()
    println("Hi $name!")
}

fun mult(x: Int, y: Int) {
    println(x * y)
}

fun mult2(x: Int, y: Int): Int {
    return x * y
}

fun main() {
    greet()

    val res = mult(2, 3)
    println(res)

    val res2 = mult2(3, 4)
    println(res2)
}
```

[Test your predictions](https://play.kotlinlang.org/)

## Exercise 3: Maps

Try out updating the `calculateGPAmap` function to use a map. Copy this starter code into a file named `GPA.kt` and update it:

```kotlin
fun calculateGPAmap(grades:/* YOUR CODE HERE */): /* YOUR CODE HERE */{

    val gpaMap: /* YOUR CODE HERE */ = mapOf("A" to 4.0, /* YOUR CODE HERE */)

    var totalGradePoints:Double = 0.0

    for (/* YOUR CODE HERE */){
        if (gpaMap[grade] != null){
            /* YOUR CODE HERE */
        }
    }
    
    val gpa = String.format("%.2f", totalGradePoints/grades.count())
    
    return gpa
}

fun main() {


    println("Student's GPA: ${calculateGPAmap(listOf("A-", "B+", "C", "A"))}")
    println("Student's GPA: ${calculateGPAmap(listOf("C-", "B", "D+", "A-"))}")
	println("Student's GPA: ${calculateGPAmap(listOf("F", "A-", "C+", "B-"))}")

}
```

Then consult your reference sheet or the [scavenger hunt files](kotlin-lab) for how to compile and run it. Upload your completed code to Moodle for an engagement credit.