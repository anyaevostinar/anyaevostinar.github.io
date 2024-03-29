public class Node<T> {
    public T    data; // Entry in bag
    public Node<T> next; // Link to next node

    public Node(T dataPortion) {
        this(dataPortion, null);
    } // end constructor

    public Node(T dataPortion, Node<T> nextNode) {
        data = dataPortion;
        next = nextNode;
    } // end constructor
} // end Node