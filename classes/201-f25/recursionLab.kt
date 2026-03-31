// Given a list of numbers, return the largest number
fun findMax(numList: List<Int>): Int{
    return 0
}

// Given a list of numbers, return the sum of all the numbers in the list
fun sumList(numList: List<Int>): Int{
    return 0
}

fun main(){
    //Testing findMax()
    println("Solution to findMax: ${findMax(listOf(26, 30, 8))}")
    println("Solution to findMax: ${findMax(listOf(-19, -61))}")
    println("Solution to findMax: ${findMax(listOf(-1))}")
    println("If you get an error after this line, you probably tried to remove from the list. Don't do that, use sublist() instead.")
    val testList = listOf(26, 30, -8, -19, -61, -1)
    println("Solution to findMax: ${findMax(testList)}")

    //Testing sumList()
    //println("Solution to sumList: ${sumList(listOf(-6, 4, 12))}")
    //println("Solution to sumList: ${sumList(listOf(-47, 53))}")
    //println("Solution to sumList: ${sumList(listOf(-5))}")
    //println("Solution to sumList: ${sumList(listOf<Int>())}")

}