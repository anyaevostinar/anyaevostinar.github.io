import java.util.*;

public class Heap{
  Node root;
  public ArrayList<Node> nodes = new ArrayList<Node>();
  int numItems = 0;

  private class Node {
    Integer priority;
    String value;
    Node parent;


    public Node() {
      
    }

    public Node(int input, String val, Node parent){
      priority = input;
      value = val;
      this.parent = parent;
      if(parent!=null) {
        parent.addChild(this);
      }

    }

    public int compareTo(Node b) {
      return this.priority.compareTo(b.priority);
    }

    public String toString() {
      return "Priority: " + priority + " Value: " + value +"\n";
    }

    public void addChild(Node newChild) {

    }

    public void removeChild() {

    }
  }

  public Node parent(int childPos) {
    if(childPos <= 0) return null;
    int parentPos = (childPos-1)/2;
    return nodes.get(parentPos);
  }

  public void insert(int priority, String value) {
    if(numItems>0) {
      numItems++;
      Node newNode = new Node(priority, value, parent(numItems-1));
      nodes.add(newNode);
      heapifyUp(newNode);
    } else {
      numItems++;
      Node newNode = new Node(priority, value, null);
      nodes.add(newNode);
      root = newNode;
    }
  }

  private void swap(Node node1, Node node2) {
    //Just swap the stuff in the nodes so that the points stay consistent
    Integer temp1 = node1.priority;
    String value1 = node1.value;
    node1.priority = node2.priority;
    node1.value = node2.value;
    node2.priority = temp1;
    node2.value = value1;
  }

  private void heapifyUp(Node newNode) {
    if(newNode==root) return;
    if (newNode.compareTo(newNode.parent) > 0) {
      swap(newNode, newNode.parent);
      heapifyUp(newNode.parent);
    }
  }

  public Node removeMax() {
    Node toReturn = new Node();

    return toReturn;
  }


  private void heapifyDown(Node newNode) {
    
  }

/*
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
*/

  public static void main(String[] args) {
    Heap priorityQ = new Heap();
    priorityQ.insert(100, "test3");
    priorityQ.insert(1, "test1");
    priorityQ.insert(2, "test2");
    priorityQ.insert(101, "test4");

    //priorityQ.printHeap();
    System.out.println("Max: " + priorityQ.removeMax());

  }

}