import java.util.*;

/**
 * A class for implementing a Binary Search Tree using BSTNode objects.
 */
public class BST {
    private BSTNode root;

    /**
     * Displays an ASCII-art sort of representation of this tree (image-like text).
     */
    public void printTree() {
        int maxLevel = maxLevel(root);
        List<BSTNode> rootList = new ArrayList<BSTNode>();
        rootList.add(root);
        printNodeInternal(rootList, 1, maxLevel);
    }

    /**
     * A method for searching the tree for a key and returning the associated value
     * @param key the key that is associated with the value you want
     * @return int the value associatd with the given key
     */
    public Integer get(String key) {
        return getHelper(root, key);
        
    }

    private Integer getHelper(BSTNode subRoot, String key) {
        if(subRoot == null) {
            return null;
        } else if(subRoot.key().equals(key)) {
            return subRoot.value();
        } else if (subRoot.key().compareTo(key) > 0) {
            return getHelper(subRoot.left(), key);
        } else {
            return getHelper(subRoot.right(), key);
        }
    }

    public void inOrderTraversal() {
        inOrderHelper(root);
    }

    private void inOrderHelper(BSTNode subRoot) {
        if(subRoot == null) {
            return;
        }
        inOrderHelper(subRoot.left());
        System.out.println(subRoot.key() + " : " + subRoot.value());
        inOrderHelper(subRoot.right());
    }

    /**
     * Adds a new key, value pair to the binary search tree.
     * If the key is a duplicate, returns false, otherwise returns true.
     * @param key the key that should be used to determine placement in the tree
     * @param val the value that should be associated with the key
     * @return boolean, whether the key/value pair was added successfully or not
     */
    public boolean add(String key, int val){
        BSTNode newNode = new BSTNode(key, val);

        if (root == null) {
            root = newNode;
            return true;
        } else {
            return addHelper(root, newNode);
        }

    }

    /**
     * Assumes that subRoot is not null
     * @param subRoot
     * @param newNode
     * @return
     */
    private boolean addHelper(BSTNode subRoot, BSTNode newNode) {

        //Compare the new node to the subRoot
        //If the new node is less than the subRoot, compare will be negative
        //If the new node is greater than the subRoot, compare will be positive
        //If the new node is equal to the subRoot, compare will be 0

        //Bad base case:
        // if (subRoot == null) {
        //     subRoot = newNode;
        //     return true;
        // }
        int compare = newNode.key().compareTo(subRoot.key());
        if(compare == 0) {
            //New node and subRoot have the same key, duplicates not allowed!
            return false;
        } else if (compare < 0) {
            //newNode < subRoot
            //newNode goes to the left of subRoot
            if(subRoot.left() == null) {
                //subRoot has no left child, so newNode is now it
                subRoot.setLeft(newNode);
                return true;
            } else {
                //subRoot has a left child, so insert newNode into left subtree
                return addHelper(subRoot.left(), newNode);
            }
        } else {
            //new Node goes to the right of subRoot
            if(subRoot.right() == null) {
                //subRoot has no right child, so newNode is now it
                subRoot.setRight(newNode);
                return true;
            } else {
                //subRoot has a right child, so insert newNode into right subtree
                return addHelper(subRoot.right(), newNode);
            }
        }
    }

    /**
     * Creates a small BST manually so that it can be displayed 
     * before add is implemented
     */
    public void test() {
        root = new BSTNode("K", 33);
        root.setLeft(new BSTNode("F", 3));
        root.setRight(new BSTNode("S", 50));
        root.left().setLeft(new BSTNode("A", 1));
        root.right().setLeft(new BSTNode("L", 4));

    }


    public static void main(String[] args) {
        BST test = new BST();
        test.add("K", 10);
        test.add("Z", 5);
        test.add("B", 8);
        test.add("A", 7);
        test.add("C", 9);
        test.printTree();

        test.inOrderTraversal();
        
    }

    /****
     * You can ignore all code below this point!  
     * This code takes care of printing.
     * 
     * Lightly modified from user post on stack overflow:
     * http://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
     * and code provided by Anna Rafferty.
     */
    private void printNodeInternal(List<BSTNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || areAllElementsNull(nodes)) {
            return;
        }
        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
    
        printWhitespaces(firstSpaces);
    
        List<BSTNode> newNodes = new ArrayList<BSTNode>();
        for (BSTNode node : nodes) {
            if (node != null) {
                System.out.print(node.key());
                newNodes.add(node.left());
                newNodes.add(node.right());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
    
            printWhitespaces(betweenSpaces);
        }
        System.out.println("");
    
        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }
    
                if (nodes.get(j).left() != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);
    
                printWhitespaces(i + i - 1);
    
                if (nodes.get(j).right() != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);
    
                printWhitespaces(edgeLines + edgeLines - i);
            }
    
            System.out.println("");
        }
    
        printNodeInternal(newNodes, level + 1, maxLevel);
    }
    
    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }
    
    private static int maxLevel(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.left()), maxLevel(node.right())) + 1;
    }
    
    private static boolean areAllElementsNull(List<BSTNode> list) {
        for (BSTNode object : list) {
            if (object != null)
                return false;
        }
        return true;
    }
}
