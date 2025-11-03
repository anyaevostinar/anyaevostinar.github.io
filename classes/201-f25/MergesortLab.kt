// Adapted from Dave Musicant's in-class lab by Jean Salac and Anya Vostinar

/**
 * Sorts the provided list in place with mergesort
 * param: MutableList of a Comparable type
 */
fun <T: Comparable<T>> mergesort(list: MutableList<T>) {

    // copies list; just a brief way to make a list of the right size,
    // don't care about contents
    val tempList = list.toMutableList()

    mergesort(list, tempList, 0, list.count()-1)
}

/**
 * Helper function for mergesort, sorts subsection of list in place using tempList
 * param: MutableList of Comparable Type, the list to be sorted
 * param: MutableList of Comparable Type, a temp list of the same size as the first list
 * param: Int, the index of the start of the sublist to sort
 * param: Int, the index of the end of the sublist to sort
 */
fun <T: Comparable<T>> mergesort(list: MutableList<T>,
                                 tempList: MutableList<T>,
                                 left: Int, right: Int) {
    if (left < right) {
        //TODO
    }
}


/**
 * Helper function for mergesort, does the merging
 * Merge together two sorted runs of integers: one starting
 * at leftStart, and ending at rightStart-1; the second starting at
 * rightStart, and ending at rightEnd
 * param: MutableList of Comparable type, the list to sort
 * param: MutableList of Comparable type, a temp list of the same size
 * param: Int, the start of the left sublist to merge
 * param: Int, the start of the right sublist to merge
 * param: Int, the end of the right sublist to merge
 */

fun <T: Comparable<T>> merge(list: MutableList<T>,
                             tempList: MutableList<T>,
                             leftStart: Int,
                             rightStart: Int,
                             rightEnd: Int) {
    val leftEnd = rightStart - 1
    var cur = 0    // Current location in tempList
    var left = leftStart //Current location in left sublist
    var right = rightStart //Current location in right sublist

    // Start merging until one of the halves is exhausted

    //TODO
   

    // If above loop exits, either left half or right half is
    // done. Finish copying other half that's not done.

    // Copy rest of first half

    //TODO

    // Copy rest of second half
    //TODO

    // Copy temp list over original

    //TODO
}
  
fun main(){
    var list = mutableListOf(46, 9, 22, 5, 15, 1, 96, 34)
    mergesort(list)
    println(list)

    var list = mutableListOf(54, 26, 93, 17)
    mergesort(list)
    println(list)

    var list = mutableListOf(46, 23, 18, 35, 37)
    mergesort(list)
    println(list)
}