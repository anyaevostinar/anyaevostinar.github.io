import java.util.*;

public class Node {
  private Integer lval;
  private Integer rval;
  private Node left;
  private Node right;
  private Node center;

  /*
  * Default constructor for a Node, sets all pointers to null.
  */
  public Node() {center=left=right=null;}

  /*
  * Constuctor for a Node
  * @param  leftVal   the Integer that should be the left value of the node
  * @param  rightVal  the Integer that should be the right value of the node
  * @param leftNode   the Node that should be the left child of the current node
  * @param centerNode   the Node that should be the center child
  * @param rightNode    the Node that should be the right child
  */
  public Node(Integer lv, Integer rv, Node l, Node c, Node r) {
    lval = lv;
    rval = rv;
    left = l;
    right = r;
    center = c;
  }

  /*
  * Determines if the node is a leaf or not, ie if it has children
  * @return returns true if it is a leaf, ie doesn't have children
  */
  public boolean isLeaf() {return left ==null;}

  private static Node insertLeft(Node rt, Integer key) {
    /*Implement me!*/
    
    throw new UnsupportedOperationException();
  }

  private static Node insertCenter(Node rt, Integer key) {
    /*Implement me!*/
    
    throw new UnsupportedOperationException();
  }

  private static Node insertRight(Node rt, Integer key) {
    /* Implement me! */
  
    throw new UnsupportedOperationException();
  }


  /*
  * Method for inserting a new value into the 2-3 tree
  * @param  root the node that is the root of the current tree
  * @param  key  the new value to be inserted
  * @return      a Node that is the new root of the tree
  */
  public static Node insertHelp(Node rt, Integer key) {
    /*Implement me!*/
    throw new UnsupportedOperationException();
  }

  private Node addLeft(Node newNode) {
    Node newRoot = new Node(lval, null, newNode, this, null); //newRoot will be the new root with the promoted value. this's lval is promoted, newNode is the left child of newRoot, this is the center child.
    left = center; //left is either empty or a duplicate of it's children from previous recursive calls, so it can be safely overwritten
    center = right; //this will now be a 2 node so everything is shuffled over
    right = null;
    lval = rval;
    rval = null;
    return newRoot; //newRoot is now the root of this and it and will be added to this's previous root
  }

  private Node addCenter(Node newNode) {
    newNode.center = new Node(rval, null, newNode.center, right, null); //newNode holds the middle value and so will represent the promoted value and the children will be shuffled into their correct positions based on that
    newNode.left = this;
    rval = null;
    right = null;
    return newNode;
  }

  private Node addRight(Node newNode) {
      Node newRoot = new Node(rval, null, this, newNode, null); //newRoot will be the new root with the promoted value
      right = null; rval = null;
      return newRoot;
  }

 /*
  * Assumes insert has figured out where a new node should be inserted already. 
  * This method handles the process of promoting and splitting if necessary.
  * Takes a new node, newNode, that may be the root of a subtree and attempts to
  * add it to this node. If this node has room, newNode's value and
  * subtrees are meshed with this node. If this node does not have room, the
  * children of newNode and this are shuffled as needed and a new root is created
  * to be a parent of both and returned, or newNode is made to be the parent of
  * this and new node and returned.
  *
  * @return  a node that will be the root of the subtree 
 */
  private Node add(Node newNode) {
    if(rval == null) { // Only one key, add here
      if(lval.compareTo(newNode.lval) < 0) {
        rval = newNode.lval; 
        center = newNode.left;
        right = newNode.center;
      }
      else {
        rval = lval;
        right = center;
        lval = newNode.lval;
        center = newNode.center;
        left = newNode.left;
      }
      return this;
    }
    else if (lval.compareTo(newNode.lval) >=0) { // Add left
     return addLeft(newNode);
    }
    else if(rval.compareTo(newNode.lval) >=0) { // Add center
      return addCenter(newNode);
    }
    else { // Add right
      return addRight(newNode);
    }
  }

  /*
  * Creates a string of a node's left and right value for printing
  * @return a string of the left and right values with labels
  */
  public String toString() {
    return "Left: " + lval + " Right: " + rval + " ";
  }

  /*
  * A method to print the 2-3 Tree in a user-friendly way, though it is
  * left-justified and so confusing for very large trees
  * @param root The root node of the tree to be printed
  */
  public static void printTree(Node root) {
    System.out.println("-----------------------");
    Queue<Node> toPrint = new LinkedList<Node>();
    Queue<Integer> levels = new LinkedList<Integer>();
    toPrint.add(root);
    levels.add(0);
    Integer prevLevel = 0;
    while(levels.peek() != null) {
      //can't encounter same node twice so won't bother checking
      Node next = toPrint.remove();
      if(levels.peek()!= prevLevel) System.out.println();
      prevLevel = levels.remove();
      if(next == null) continue; //skip over the null right nodes
      toPrint.add(next.left);
      levels.add(prevLevel+1);
      toPrint.add(next.center);
      levels.add(prevLevel+1);
      toPrint.add(next.right);
      levels.add(prevLevel+1);
      System.out.print(" |"+next.lval+"-"+next.rval+"| ");
    }
    System.out.println("\n--------------------------");
  }

  public static void main(String[] args) {
    Node testroot = null;
    testroot = insertHelp(testroot, 15);
    //testroot = insertHelp(testroot, 1);
    //testroot = insertHelp(testroot, 25);
    //testroot = insertHelp(testroot, 5);
    //testroot = insertHelp(testroot, 21);
    //testroot = insertHelp(testroot, 18);
    //testroot = insertHelp(testroot, 0);
    
    printTree(testroot);

    
  }

}
