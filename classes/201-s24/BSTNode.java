import java.util.*;

/**
 * A class for binary search tree nodes that hold String keys and int values.
 */
public class BSTNode {
    private String key; // Key for this node
    private int value; // Value for this node
    private BSTNode left;          // Pointer to left child
    private BSTNode right;         // Pointer to right child

    // Constructors
    BSTNode() {left = right = null; }
    BSTNode(String key, int val) { 
        left = right = null; 
        this.key = key;
        this.value = val;
    }
    BSTNode(String key, int val, BSTNode l, BSTNode r) { 
        left = l;
        right = r;
        this.key = key; 
        this.value = val;
    }

    // Get and set the key and value
    public String key() { return key; }
    public int value() {return value;}
    public void setKey(String k) {key = k;}
    public void setValue(int v) { value = v; }


    // Get and set the left child
    public BSTNode left() { return left; }
    public void setLeft(BSTNode p) { left = p; }

    // Get and set the right child
    public BSTNode right() { return right; }
    public void setRight(BSTNode p) { right = p; }

    // return TRUE if a leaf node, FALSE otherwise
    public boolean isLeaf() { return (left == null) && (right == null); }
}