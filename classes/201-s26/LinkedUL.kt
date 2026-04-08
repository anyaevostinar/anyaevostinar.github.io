/** Start of a linked list implementation
* Adapted from Problem Solving with Algorithms and Data Structures using Kotlin The Interactive Edition
*/

data class Node<T>(var data: T, var next: Node<T>? = null)

open class LinkedUnorderedList<T>  {

    // protected means that subclasses can access this variable, but code outside of the class cannot
    protected var head: Node<T>? = null

    // Add a new first item to the beginning of the list
    open fun addFirst(item: T) {
        val temp = Node<T>(item)
        temp.next = head
        head = temp
    }

    // Returns the number of items in the list.
    open fun size(): Int {
        var current = head
        var count = 0
        while (current != null) {
            count = count + 1
            current = current.next
        }
        return count
    }

    // Find index of first occurrence of item in list.
    // Returns -1 if not found.
    open fun indexOf(item: T): Int {
        var current = head
        var location = 0
        while (current != null) {
            if (current.data == item) {
                return location
            }
            current = current.next
            location++
        }
        return -1
    }

    // Removes item from list.
    open fun remove(item: T) {
        var current = head
        var previous: Node<T>? = null

        while (current != null && (current.data != item)) {
            previous = current
            current = current.next
        }
        if (current != null) {
            if (previous == null) {
                head = current.next
            } else {
                previous.next = current.next
            }
        }
    }

    // Returns true if there are no items in the list;
    // false otherwise.
    fun isEmpty(): Boolean {
        return head == null
    }

    // Called by println() to get a string representation of the list
    override fun toString(): String {
        var current: Node<T>? = head
        var result = "head-> "
        while (current != null) {
            result = result + "["+current.data.toString() + "|-]-> "
            current = current.next
        }
        result = result + "null"
        return result
    }

    // Returns the node at the given index, or null if index is out of bounds
    // Useful for directly manipulating the list, not something usually included in a linked list implementation
    fun getNode(index: Int): Node<T>? {
        var current = head
        var count = 0
        while (current != null) {
            if (count == index) {
                return current
            }
            count++
            current = current.next
        }
        return null
    }

}
