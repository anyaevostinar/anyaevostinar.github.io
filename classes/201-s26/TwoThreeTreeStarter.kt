/*
 * TwoThreeTreeStarter.kt
 * 
 * Starter code for a 2-3 Tree implementation
 * Author: Anya Vostinar
 * Date: Spring 2026
 */

class Node(var keys: MutableList<Int> = mutableListOf(),
           var children: MutableList<Node> = mutableListOf(),
           var parent: Node? = null) {

    fun isLeaf(): Boolean {
        return children.isEmpty()
    }

    fun numKeys(): Int {
        return keys.size
    }

    fun addChild(child: Node, index: Int? = null) {
        if (index == null) {
            children.add(child)
        } else {
            children.add(index, child)
        }
        child.parent = this
    }
}

open class TwoThreeTreeStarter {
    var root: Node? = null

    /* The method for inserting a new key into the tree.
    * @param key The new key to be inserted
    */
    fun insert(key: Int) {
        if (root == null) {
            root = Node()
            root!!.keys.add(key)
            return
        }

        var leaf = findLeaf(root!!, key)
        insertKey(leaf, key)
    }

    /* A helper method to find the leaf node where a new key should be inserted.
    * @param root The root node of the tree
    * @param key The key to be inserted
    * @return The leaf node where the key should be inserted
    */
    open fun findLeaf(root: Node, key: Int): Node {
        return root // Placeholder
    }


    /* A helper method that handles adding the key and knowing when to split.
    * @param node The node where the key should be added
    * @param key The key to be added
    */
    fun insertKey(node: Node, key: Int) {
        // Add the key and sort them
        node.keys.add(key)
        node.keys.sort()

        // If node becomes a 4-node (3 keys), we must split
        if (node.numKeys() == 3) {
            split(node)
        }
    }

    

    /* A helper method that makes the right child node when splitting a 4-node. It takes in the node to be split and returns a new node with the appropriate key and children.
    * @param splitNode The node that is being split
    * @return A new node that should become the right child of the split node's parent
    */
    open fun makeNewRightNode(splitNode: Node) : Node {
        return splitNode // Placeholder
    }


    /* A helper method that makes the left child node when splitting a 4-node. It takes in the node to be split and returns a new node with the appropriate key and children.
    * @param splitNode The node that is being split
    * @return A new node that should become the left child of the split node's parent
    */
    open fun makeNewLeftNode(splitNode: Node) : Node {
        return splitNode // Placeholder
    }

    /* A helper method to handle creating a new root if the root had to split
    * @param leftChild The left child of the new root 
    * @param rightChild The right child of the new root
    * @param keyToPromote The key that is being promoted up to become the key in the new root
    * @sideeffect Sets the root of the tree to be the new root node
    */
    open fun createNewRoot(leftChild: Node, rightChild: Node, keyToPromote: Int) {
        
    }

    /* A helper method to replace a child node with two new nodes when splitting a 4-node. The old child node is removed and the two new nodes are added in its place.
    * @param parent The parent of the node being split
    * @param splitChild The child node that is being split
    * @param newLeft The new left child node that is replacing the split child
    * @param newRight The new right child node that is replacing the split child
    * @sideeffect Modifies the parent's children to remove the split child and add the two new nodes in the correct position
    */
    open fun replaceChild(parent: Node, splitChild: Node, newLeft: Node, newRight: Node) {
        
    }


    /* A method to split a 4-node into two 2-nodes and promote the middle key up. The new nodes are created using the helper methods above and the parent is updated accordingly.
    * @param node The node that is being split
    * @sideeffect Modifies the tree structure to split the node and promote the middle key. This may involve creating a new root if the split node is the root.
    */
    open fun split(node: Node) {

    }


    /*
    * A method to print the 2-3 Tree in a user-friendly way, though it is
    * fragile ASCII art and so confusing for very large trees that don't fit on the screen.
    * @citation I used Gemini when writing this method.
    */
    fun printTree() {
        if (root == null) {
            println("Tree is empty")
            return
        }

        // Group nodes by level using an interesting algorithm that we'll revisit next week!
        val levelsMap = mutableMapOf<Int, MutableList<Node>>()
        val queue = mutableListOf<Pair<Node, Int>>()
        queue.add(root!! to 0)

        var maxLevel = 0
        while (queue.isNotEmpty()) {
            val (node, level) = queue.removeFirst()
            maxLevel = maxOf(maxLevel, level)
            levelsMap.getOrPut(level) { mutableListOf() }.add(node)
            for (child in node.children) {
                queue.add(child to level + 1)
            }
        }

        // Setup constants for spacing
        val nodeWidth = 10 
        val totalWidth = levelsMap[maxLevel]!!.size * nodeWidth

        println("--- 2-3 Tree ---")
        for (level in 0..maxLevel) {
            val nodes = levelsMap[level]!!
            val sectorWidth = totalWidth / nodes.size
            
            // Print the actual nodes
            val nodeLine = StringBuilder()
            for (node in nodes) {
                val lval = node.keys[0]
                val rval = if (node.keys.size > 1) node.keys[1] else " "
                val nodeStr = "[$lval|$rval]"
                
                val padding = (sectorWidth - nodeStr.length) / 2
                nodeLine.append(" ".repeat(padding) + nodeStr + " ".repeat(sectorWidth - nodeStr.length - padding))
            }
            println(nodeLine.toString())

            // Add connectors to the NEXT level (if it exists)
            if (level < maxLevel) {
                val connectorLine = StringBuilder()
                for (node in nodes) {
                    val childCount = node.children.size
                    val segment = when (childCount) {
                        2 -> "  /   \\  "  // Connectors for a 2-node
                        3 -> " /  |  \\ "  // Connectors for a 3-node
                        else -> "         "
                    }
                    val padding = (sectorWidth - segment.length) / 2
                    connectorLine.append(" ".repeat(padding) + segment + " ".repeat(sectorWidth - segment.length - padding))
                }
                println(connectorLine.toString())
            }
        }
    }

}
