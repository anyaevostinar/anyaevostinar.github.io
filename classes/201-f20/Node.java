import java.util.*;

public class Node {
  private Integer lval;
  private Integer rval;
  private Node left;
  private Node right;
  private Node center;

  public Node() {center=left=right=null;}
  public Node(Integer lv, Integer rv, Node l, Node c, Node r) {
    lval = lv;
    rval = rv;
    left = l;
    right = r;
    center = c;
  }

  public boolean isLeaf() {return left ==null;}

  public static Node insertHelp(Node rt, Integer key) {
    Node retval; 
    if(rt == null) // Empty tree: create a leaf node for root
      return new Node(key, null, null, null, null);
    if(rt.isLeaf()) { // At leaf node: insert here
      return rt.add(new Node(key, null, null, null, null));
    }
    //Add to internal node
    if(key.compareTo(rt.lval) < 0) { //Insert left
      retval = insertHelp(rt.left, key);
      if(retval == rt.left) { 
        return rt;
      }
      else {
         return rt.add(retval);
      }
    } else if((rt.rval == null) || (key.compareTo(rt.rval) < 0)){
      retval = insertHelp(rt.center, key);
      if(retval==rt.center) return rt;
      else return rt.add(retval);
    }
    else { //Insert right
      retval = insertHelp(rt.right, key);
      if (retval == rt.right) return rt;
      else return rt.add(retval);
    } 
  }

  public Node add(Node it) {
    if(rval == null) { // Only one key, add here
      if(lval.compareTo(it.lval) < 0) {
        rval = it.lval; 
        center = it.left;
        right = it.center;
      }
      else {
        rval = lval;
        right = center;
        lval = it.lval;
        center = it.center;
        left = it.left;
      }
      return this;
    }
    else if (lval.compareTo(it.lval) >=0) { // Add left
      Node N1 = new Node(lval, null, it, this, null);
      left = center;
      center = right;
      right = null;
      lval = rval;
      rval = null;
      return N1;
    }
    else if(rval.compareTo(it.lval) >=0) { // Add center
      it.center = new Node(rval, null, it.center, right, null);
      it.left = this;
      rval = null;
      right = null;
      return it;
    }
    else { // Add right
      Node N1 = new Node(rval, null, this, it, null);
      it.left = right;
      right = null; rval = null;
      return N1;
    }
  }

  public String toString() {
    return "Left: " + lval + " Right: " + rval + " ";
  }

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
    testroot = insertHelp(testroot, 18);
    
    printTree(testroot);

    
  }

}
