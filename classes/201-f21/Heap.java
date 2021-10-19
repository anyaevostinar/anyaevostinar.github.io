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
    return null;
  }

  public void insert(int priority, String value) {

  }

  private void swap(Node node1, Node node2) {

  }

  private void heapifyUp(Node newNode) {

  }

  public String toString() {
    String returnString = "";
    for(Node curNode : nodes) {
      returnString += curNode;
    }
    return returnString;
}



  public static void main(String[] args) {

  }

}
