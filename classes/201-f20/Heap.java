import java.util.*;

public class Heap{
  Node root;
  public ArrayList<Node> nodes = new ArrayList<Node>();
  int numItems = 0;

  private class Node {
    Integer priority;
    String value;
    Node parent;


    public Node(int input, String val, Node parent){

    }

    public int compareTo(Node b) {
        return 0;
    }

    public String toString() {
      return "Priority: " + priority + " Value: " + value +"\n";
    }

  }

  public void test() {

  }

  public Node parent(int childPos) {
    return new Node(0,"null",null);
  }

  public void insert(int priority, String value) {

  }

  private void swap(Node node1, Node node2) {

  }

  private void heapifyUp(Node newNode) {

  }

public void printHeap() {
    System.out.println("-----------------------");
    Queue<Node> toPrint = new LinkedList<Node>();
    Queue<Integer> levels = new LinkedList<Integer>();
    toPrint.add(root);
    levels.add(0);
    Integer prevLevel = 0;
    while(toPrint.peek() != null) {
      //can't encounter same node twice so won't bother checking
      Node next = toPrint.remove();
      if(levels.peek()!= prevLevel) System.out.println();
      prevLevel = levels.remove();
      toPrint.add(next.left);
      levels.add(prevLevel+1);
      toPrint.add(next.right);
      levels.add(prevLevel+1);
      System.out.print(" |"+next.priority+"| ");
    }
    System.out.println("\n--------------------------");
  }


  public static void main(String[] args) {

  }

}