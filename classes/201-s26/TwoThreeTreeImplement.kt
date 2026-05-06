

import Node
import TwoThreeTreeStarter
class TwoThreeTree : TwoThreeTreeStarter() {


    /* A helper method to find the leaf node where a new key should be inserted.
    * @param root The root node of the tree
    * @param key The key to be inserted
    * @return The leaf node where the key should be inserted
    */
    override fun findLeaf(root: Node, key: Int): Node {
        // You should implement this
        return root 
    }


    /* A helper method that makes the right child node when splitting a 4-node. It takes in the node to be split and returns a new node with the appropriate key and children.
    * @param splitNode The node that is being split
    * @return A new node that should become the right child of the split node's parent
    */
    override fun makeNewRightNode(splitNode: Node) : Node {
        // You should implement this
        return splitNode
    }

    /* A helper method that makes the left child node when splitting a 4-node. It takes in the node to be split and returns a new node with the appropriate key and children.
    * @param splitNode The node that is being split
    * @return A new node that should become the left child of the split node's parent
    */
    override fun makeNewLeftNode(splitNode: Node) : Node {
        // You should implement this
        return splitNode 
    }

    /* A helper method to handle creating a new root if the root had to split
    * @param leftChild The left child of the new root 
    * @param rightChild The right child of the new root
    * @param keyToPromote The key that is being promoted up to become the key in the new root
    * @sideeffect Sets the root of the tree to be the new root node
    */
    override fun createNewRoot(leftChild: Node, rightChild: Node, keyToPromote: Int) {
        // You should implement this
    }

    /* A helper method to replace a child node with two new nodes when splitting a 4-node. The old child node is removed and the two new nodes are added in its place.
    * @param parent The parent of the node being split
    * @param splitChild The child node that is being split
    * @param newLeft The new left child node that is replacing the split child
    * @param newRight The new right child node that is replacing the split child
    * @sideeffect Modifies the parent's children to remove the split child and add the two new nodes in the correct position
    */
    override fun replaceChild(parent: Node, splitChild: Node, newLeft: Node, newRight: Node) {
        // You should implement this
    }


    /* A method to split a 4-node into two 2-nodes and promote the middle key up. The new nodes are created using the helper methods above and the parent is updated accordingly.
    * @param node The node that is being split
    * @sideeffect Modifies the tree structure to split the node and promote the middle key. This may involve creating a new root if the split node is the root.
    */
    override fun split(node: Node) {
        // You should implement this
    }


}

// Driver Program to test the above functions
fun main() {
    var testTree = TwoThreeTree()

    // TEST0: Test findLeaf
    /*    
    println("Testing findLeaf:")
    val child1 = Node(mutableListOf(5), mutableListOf(), null)
    val child2 = Node(mutableListOf(15), mutableListOf(), null)
    val child3 = Node(mutableListOf(25), mutableListOf(), null)
    val parent0 = Node(mutableListOf(10, 20), mutableListOf(child1, child2, child3), null)
    child1.parent = parent0
    child2.parent = parent0
    child3.parent = parent0
    var leaf = testTree.findLeaf(parent0, 16)
    println("findLeaf found the correct leaf: ${leaf == child2}") // Should be true
    leaf = testTree.findLeaf(parent0, -1)
    println("findLeaf found the correct leaf: ${leaf == child1}") // Should be true
    leaf = testTree.findLeaf(parent0, 100)
    println("findLeaf found the correct leaf: ${leaf == child3}") // Should be true
    println()

    // TEST1: Testing insert after findLeaf implemented
    println("Testing insert after findLeaf implemented:")
    var realTree = TwoThreeTree()
    realTree.insert(15)
    realTree.insert(1)
    realTree.printTree()
    println()
    */

    // TEST2: Test makeNewRightNode and makeNewLeftNode
    /*
    println("Testing makeNewRightNode and makeNewLeftNode without children:")
    var testNode = Node(mutableListOf(10, 20, 30), mutableListOf(), null)
    var leftNode = testTree.makeNewLeftNode(testNode)
    var rightNode = testTree.makeNewRightNode(testNode)
    println("Left node keys: ${leftNode.keys}") // Should print [10]
    println("Right node keys: ${rightNode.keys}") // Should print [30]
    */

    // TEST3: Test makeNewRightNode and makeNewLeftNode with children
    /*
    println("Testing makeNewRightNode and makeNewLeftNode with children:")
    val child1_3 = Node(mutableListOf(5), mutableListOf(), null)
    val child2_3 = Node(mutableListOf(15), mutableListOf(), null)
    val child3_3 = Node(mutableListOf(25), mutableListOf(), null)
    val child4_3 = Node(mutableListOf(35), mutableListOf(), null)
    testNode = Node(mutableListOf(10, 20, 30), mutableListOf(child1_3, child2_3, child3_3, child4_3), null)
    leftNode = testTree.makeNewLeftNode(testNode)
    rightNode = testTree.makeNewRightNode(testNode)
    println("Left node has child1 and child2: ${leftNode.children.contains(child1_3) && leftNode.children.contains(child2_3)}") // Should be true
    println("Right node has child3 and child4: ${rightNode.children.contains(child3_3) && rightNode.children.contains(child4_3)}") // Should be true
    println()
    */

    // TEST4: Test replaceChild
    /*
    println("Testing replaceChild:")
    val parent = Node(mutableListOf(15), mutableListOf(), null)
    val leftChild = Node(mutableListOf(1, 5), mutableListOf(), parent)
    val oldRight = Node(mutableListOf(21, 25), mutableListOf(), parent)
    parent.addChild(leftChild)
    parent.addChild(oldRight)
    val newCenter = Node(mutableListOf(21), mutableListOf(), parent)
    val newRight = Node(mutableListOf(25), mutableListOf(), parent)
    testTree.replaceChild(parent, oldRight, newCenter, newRight)
    println("Parent's left child keys after replaceChild: ${parent.children[0].keys}") // Should print [1, 5]
    println("Parent's center child keys after replaceChild: ${parent.children[1].keys}") // Should print [21]
    println("Parent's right child keys after replaceChild: ${parent.children[2].keys}") // Should print [25]
    */

    // TEST5:Test createNewRoot
    /*
    testTree.createNewRoot(leftNode, rightNode, 20)
    println("Root keys after creating new root: ${testTree.root!!.keys}") // Should print [20]
    println("Root has left and right child: ${testTree.root!!.children.contains(leftNode) && testTree.root!!.children.contains(rightNode)}") // Should be true
    testTree.printTree()
    println()
    */

    // TEST6: Test createNewRoot with full tree
    /*
    println("Testing createNewRoot with full tree:")
    realTree.insert(25)
    realTree.insert(5)
    realTree.insert(21)
    realTree.printTree()
    println()
    */

    // TEST7: Test full insert implementation
    /*
    println("\nTesting full insert implementation:")
    realTree.insert(18)
    println("After inserting 18:")
    realTree.printTree()
    realTree.insert(0)
    println("After inserting 0:")
    realTree.printTree()
    */
    

    
}