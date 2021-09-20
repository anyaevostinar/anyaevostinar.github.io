/**
* A class that implements a bag using a linked structure.
Acknowledgements: Uses the private node class and method descriptions provided by Data Structures and Abstractions with Java by Frank M. Carrano, Timothy M. Henry
*/
public class LinkedBag<T> {
    Node firstNode = null;

    private class Node {
        private T    data; // Entry in bag
        private Node next; // Link to next node
    
        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor
    } // end Node


    /** Returns a String of the contents of the bag.
     * @return A String of the contents of the bag, in no particular order.
     */
    public String toString() {
        return null;
    }

    /** Adds a new entry to this bag. 
    * @param newEntry  The object to be added as a new entry. 
    * @return  True if the addition is successful, or false if not. 
    */
    public boolean add(T newEntry) {
        return false;
    }

    /** Removes one occurrence of a given entry from this bag, if possible. 
     * @param anEntry  The entry to be removed. 
     * @return  True if the removal was successful, or false if not. */ 
    public boolean remove(T anEntry) {
        return false;
    }
}