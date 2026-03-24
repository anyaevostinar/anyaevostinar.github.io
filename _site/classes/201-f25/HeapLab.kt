/** Max Heap implementation (in progress)
 * Authors: Jean Salac, Dave Musicant, Anya Vostinar
 */

interface Heap{
    fun heapify(hT: MutableList<Int>, i:Int)
    fun insert(hT: MutableList<Int>, newNum: Int)
    fun delete(hT: MutableList<Int>, num: Int)
}

class MaxHeap: Heap {

    /**
     * Helper function, swaps the values at two indices
     * param: MutableList<Int>, the heap
     * param: Int, the first index
     * param: Int, the second index
     */
    fun swap(hT: MutableList<Int>, index1:Int, index2: Int) {
            val temp = hT.get(index1)
            hT.set(index1, hT.get(index2))
            hT.set(index2, temp)
    }

    /**
     * Helper function, fixes the heap after deletion
     * param: MutableList<Int>, the heap
     * param: Int, the index of the item that might be wrong compared to its children
     */
    override fun heapify(hT: MutableList<Int>, i: Int) {
        //TODO

        //figure out which is largest between i and it's children
        

        //if i isn't the largest, swap it with the largest child
        

            //the location of the largest child might now be wrong, so do it again
            
        
    }
    

    /**
     * Add a new item to the heap and fixes heap
     * param: MutableList<Int>, the heap
     * param: Int, the new value to add
     */
    override fun insert(hT: MutableList<Int>, newNum: Int){

        
            //if the heap is empty, it's the root
            
            //otherwise, add to end
            
            //and fix the heap
    }

    /**
     * Deletes a specified index from the heap and fixes heap
     * param: MutableList<Int>, the heap
     * param: Int, the value to delete
     */
    override fun delete(hT: MutableList<Int>, num: Int){
        
    
    }
}

fun main(){
    val listToHeap = mutableListOf<Int>()

    val maxHeap = MaxHeap()

    maxHeap.insert(listToHeap, 3)
    println(listToHeap)

    maxHeap.insert(listToHeap, 4)
    println(listToHeap)
    maxHeap.insert(listToHeap, 9)
    println(listToHeap)
    maxHeap.insert(listToHeap, 5)
    println(listToHeap)
    maxHeap.insert(listToHeap, 2)
    println(listToHeap)
    maxHeap.insert(listToHeap, 20)
    println(listToHeap)
    maxHeap.insert(listToHeap, 40)
    println(listToHeap)
    maxHeap.insert(listToHeap, 90)
    println(listToHeap)
    maxHeap.insert(listToHeap, 50)
    println(listToHeap)
    maxHeap.insert(listToHeap, 20)
    println(listToHeap)
    maxHeap.insert(listToHeap, 201)
    println(listToHeap)

    // maxHeap.delete(listToHeap, 201)
    // println(listToHeap)
    

}