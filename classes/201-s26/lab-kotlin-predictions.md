---
layout: page
title: Kotlin Predictions Lab
permalink: /classes/201-s26/kotlin-predictions-lab
---

## Set up
Follow the steps from the [Scavenger Hunt](kotlin-lab) to mount the COURSES drive. Make a folder `PredictionsLab` in your STUWORK/username folder and open it in VSCode for today's labwork.

## Exercise 1: Conditionals and loops in Kotlin

#### 1a: Conditionals

Predict the output of the following code.

```kotlin
fun main() {
    val x: Int = 4
    val y: Int = 10
    var z: Int = 8

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
}

```

Test your predictions by creating a new file in your `PredictionsLab` folder, copying the code into it and running with:
```bash
kotlinc YOUR_FILENAME.kt
kotlin YOUR_FILENAMEKt
```


#### 1b: Loops

Predict the output of the following code: 

```kotlin
for (x: Int in 1..5) {
    println(x * x)
}

println("----")

for (x: Int in 2..<8 step 2) {
    println(x)
}

println("----")

for (x: Int in 10 downTo 1 step 3) {
    println(x)
}

println("----")

for (s: String in listOf("apple", "banana", "canteloupe")) {
    println("String: $s")
}

println("----")

var y = -10
while (y > 0) {
    println(y)
    y -= 4
}

println("----")

var z = -10
do {
    println(z)
    z -= 4
} while (z > 0)
```

Test your predictions by copying the code into another file and running it. Remember that you'll need to create a `main`.

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

Test your predictions as usual. Anything unexpected?

## Exercise 3: Maps

Try out updating the `calculateGPAmap` function to use a map. Copy this starter code into a file named `GPA.kt` and update it:

```kotlin
fun calculateGPAmap(grades: Missing collection type): Missing return type{

    // We'll talk about the ? on Friday
    val gpaMap: Map<String, Double?> = mapOf("A" to 4.0,
                                            "A-" to 3.667,
                                            "B+" to 3.333,
                                             "B" to 3.0,
                                             "B-" to 2.667,
                                             "C+" to 2.0, 
                                             "C" to 2.0,
                                             "C-" to 1.667,
                                             "D+" to 1.333, 
                                             "D" to 1.0,
                                             "D-" to 0.667,
                                             "F" to 0.0)

    var totalGradePoints:Double = 0.0

    // Missing code to iterate over the list of grades {
        var grade_point = //Missing code to look up value in gpaMap
        if (grade_point != null){ // Necessary check, we'll discuss on Friday
            totalGradePoints += grade_point
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

Upload your completed code for Exercise 3 to Moodle for an extra engagement credit.

## Acknowledgements
This is based on labs from Profs Tanya Amert and Jean Salac.