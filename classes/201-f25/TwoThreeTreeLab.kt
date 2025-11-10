/*
 * 23TreeLab.kt
 * 
 * Starter code for a 2-3 Tree implementation
 * Author: Anya Vostinar
 * Date: Fall 2025
 * Ported from my Java version.
 */

class TwoThreeTree {

  
    private data class Node(var lval: Int,
                            var rval: Int? = null,
                            var left: Node? = null,
                            var center: Node? = null,
                            var right: Node? = null)

    // Nobody needs to know about the root of our tree
    private var root: Node? = null

    /**
     * Method for inserting a new value into the 2-3 tree
     * @param  key  the new value to be inserted
     */
    fun insert(key : Int) {
        root = insertHelp(root, key)
    }

    /*
    * Helper method for actually inserting a new key into the 2-3 tree
    * @param  root the node that is the root of the current tree
    * @param  key  the new value to be inserted
    * @return      a Node that is the new root of the tree
    */
    private fun insertHelp(subroot: Node?, key: Int) : Node? {
        //TODO
        return null
    }


    /**
     * Helper method for handling inserting to the left node
     * @param subroot, the node that is the root of the current tree
     * @param key, the new value to be insert
     * @return a node that is the new root of the current tree
     */
    private fun insertLeft(subroot: Node?, key : Int) : Node?{
        //TODO
        return null
    }

    /**
     * Helper method for handling inserting to the center node
     * @param subroot, the node that is the root of the current tree
     * @param key, the new value to be insert
     * @return a node that is the new root of the current tree
     */
    private fun insertCenter(subroot: Node?, key : Int) : Node?{
        //TODO
        return null
    }

    /**
     * Helper method for handling inserting to the right node
     * @param subroot, the node that is the root of the current tree
     * @param key, the new value to be insert
     * @return a node that is the new root of the current tree
     */
    private fun insertRight(subroot: Node?, key : Int) : Node?{
        //TODO
        return null
    }

    private fun addLeft(subRoot: Node, newNode: Node) : Node {
        //newRoot will be the new root with the promoted value. 
        //subroot's lval is promoted, newNode is the left child of 
        //newRoot, subRoot is the center child.
        var newRoot = Node(subRoot.lval, null, newNode, subRoot, null)

        //left is either empty or a duplicate of it's children 
        //from previous recursive calls, so it can be safely overwritten
        subRoot.left = subRoot.center

        //subroot will now be a 2 node so everything is shuffled over
        subRoot.center = subRoot.right
        subRoot.right = null
        subRoot.lval = subRoot.rval!!
        subRoot.rval = null
        return newRoot
    }

    private fun addCenter(subRoot: Node, newNode: Node) : Node {
        //newNode holds the middle value and so will represent the 
        //promoted value and the children will be shuffled into their 
        //correct positions based on that
        newNode.center = Node(subRoot.rval!!, null, newNode.center, subRoot.right, null)
        newNode.left = subRoot
        subRoot.rval = null
        subRoot.right = null
        return newNode
    }

    private fun addRight(subRoot: Node, newNode: Node) : Node {
        //newRoot will be the new root with the promoted value
        var newRoot = Node(subRoot.rval!!, null, subRoot, newNode, null)
        subRoot.right = null
        subRoot.rval = null
        return newRoot
    }

     /*
    * Assumes insert has figured out where a new node should be inserted already. 
    * This method handles the process of splitting and distributing children if necessary.
    * Takes a new node, newNode, that may be the root of a subtree and attempts to
    * add it to subRoot node. If subRoot node has room, newNode's value and
    * subtrees are meshed with subRoot's node. If subRoot's node does not have room, the
    * children of newNode and subRoot are distributed as needed and a new root is created
    * to be a parent of both and returned, or newNode is made to be the parent of
    * subRoot and new node and returned.
    *
    * @return  a node that will be the root of the subtree 
    */
    private fun add(subRoot: Node, newNode : Node) : Node {
        if(subRoot.rval == null) { //Only one key, add here
            if(subRoot.lval  < newNode.lval) {
                subRoot.rval = newNode.lval
                subRoot.center = newNode.left
                subRoot.right = newNode.center
            } else {
                subRoot.rval = subRoot.lval
                subRoot.right = subRoot.center
                subRoot.lval = newNode.lval
                subRoot.center = newNode.center
                subRoot.left = newNode.left
            }
            return subRoot
        } else if (subRoot.lval >= newNode.lval) { // Add left
            return addLeft(subRoot, newNode)
        } else if ((subRoot.rval ?: Int.MIN_VALUE) >= newNode.lval) { //Add center
            return addCenter(subRoot, newNode)
        } else { //Add right
            return addRight(subRoot, newNode)
        }
    }


    /*
    * A method to print the 2-3 Tree in a user-friendly way, though it is
    * left-justified and so confusing for very large trees
    * @param root The root node of the tree to be printed
    */
    fun printTree() {
        println("-----------------------")
        var toPrint = mutableListOf<Node?>()
        var levels = mutableListOf<Int>()

        toPrint.add(root)
        levels.add(0)
        var prevLevel = 0
        while(!levels.isEmpty()) {
            var next = toPrint.removeFirst()
            if(levels.first() != prevLevel) println()
            prevLevel = levels.removeFirst()
            if(next == null) continue
            toPrint.add(next.left)
            levels.add(prevLevel+1)
            toPrint.add(next.center)
            levels.add(prevLevel+1)
            toPrint.add(next.right)
            levels.add(prevLevel+1)
            print(" |"+next.lval+"-"+next.rval+"| ")
        }
        println("\n--------------------------")
    }

}

// Driver Program to test the above functions
fun main() {
    var testTree = TwoThreeTree()
    testTree.insert(15)
    // testTree.insert(1)
    // testTree.insert(25)
    // testTree.insert(5)
    // testTree.insert(21)
    // testTree.insert(18)
    // testTree.insert(0)
    testTree.printTree()

    
}