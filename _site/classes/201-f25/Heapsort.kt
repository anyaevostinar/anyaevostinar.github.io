/** Heapsort implementation
 * Author: Anya Vostinar
 * Based on Heap by Jean Salac and Dave Musicant
 */


// Max-Heap Implementation
class MaxHeap(val hT: MutableList<Int>)  {
    var heapSize = hT.count() //at first we assume heap is same size as list, but that isn't always the case

    //Note: heap doesn't build heap upon construction! Maybe you should fix that?

    /**Function to build a heap from a list in place
     * param: MutableList<Int>, the list
     */
    fun buildHeap() {
        //TODO

    }




    /**Helper function to move max value to end of heap
     * Shrinks the heap but does not shrink the underlying array
    */
    fun moveMax() {
        //TODO

    }


    /** Helper function to calculate parent */
    fun parent(child: Int) : Int{
        return (child-1) /2
    }


    /**
     * Helper function, swaps the values at two indices
     * param: MutableList<Int>, the heap
     * param: Int, the first index
     * param: Int, the second index
     */
    fun swap(index1:Int, index2: Int) {
            val temp = hT.get(index1)
            hT.set(index1, hT.get(index2))
            hT.set(index2, temp)
    }

    /**
     * Helper function, fixes the heap by sifting down
     * param: MutableList<Int>, the heap
     * param: Int, the index of the item that might be wrong compared to its children
     * param: Int, the last index of the actual heap
     */
    fun heapify(i: Int) {
        val endOfHeap = heapSize-1
        //figure out which is largest between i and it's children
        var largest = i
        var l = 2 * i + 1
        var r = 2 * i + 2
        if (l <= endOfHeap && hT.get(l) > hT.get(largest))
            largest = l
        if (r <= endOfHeap && hT.get(r) > hT.get(largest))
            largest = r

        //if i isn't the largest, swap it with the largest child
        if (largest != i) {
            swap(largest, i)

            //the location of the largest child might now be wrong, so do it again
            heapify(largest)
        }
    }
    

   

}

/** Sorts given list using heapsort, list will be from least to greatest
 * List is sorted in place
     * param: MutableList<Int>, the list to be sorted
    */
fun heapsort(listToSort: MutableList<Int>) {
    //TODO

}



fun main(){
    val listToHeap = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7)

    var heap = MaxHeap(listToHeap)
    heap.buildHeap()
    println("Should be a max heap:")
    println(listToHeap)

    val a_list = mutableListOf<Int>(11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
    heapsort(a_list)
    println("Should be sorted:")
    println(a_list)
    

}