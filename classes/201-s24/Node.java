/**
* A class that implements a node for a linked structure.
Acknowledgements: Uses the node class and method descriptions provided by Data Structures and Abstractions with Java by Frank M. Carrano, Timothy M. Henry
*/

public class Node<T> {
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