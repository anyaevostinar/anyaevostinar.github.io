/**
* A class that implements a linked structure.
Acknowledgements: Uses the private node class and method descriptions provided by Data Structures and Abstractions with Java by Frank M. Carrano, Timothy M. Henry
*/
public class LinkedStructure<T> {
    Node firstNode = null;

    private class Node {
        private T    data; // Entry in collection
        private Node next; // Link to next node
    
        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor
    } // end Node

}