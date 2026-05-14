/*
 * TwoThreeTreeStarter.kt
 * 
 * Starter code for a 2-3 Tree implementation
 * Author: Anya Vostinar
 * Date: Spring 2026
 */

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

    fun addKey(key: Int) {
        keys.add(key)
        keys.sort()
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
            root!!.addKey(key)
            return
        }

        var leaf = findLeaf(root!!, key)
        leaf.addKey(key)

        // If node becomes overfull (3 keys), we must split and keep splitting up the tree until we reach a node that doesn't need to split or we create a new root
        var curNode: Node? = leaf
        while (curNode != null && curNode.numKeys() == 3) {
            split(curNode)
            curNode = curNode.parent
        }
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
