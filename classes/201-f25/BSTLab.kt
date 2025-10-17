/*
 * BSTLab.kt
 * 
 * Based on Dave Musicant's BinarySearchTree.kt from Fall 2024,
 * which was ported by Dave from the BST code at
 * https://www.programiz.com/dsa/binary-search-tree.
 * 
 * Modified by Tanya Amert for Spring 2025.
 * Further modified for in class lab by Anya Vostinar in Fall 2025.
 * 
 * (Incomplete) Implementation of a BST.
 */

class BinarySearchTree {

    
    private data class Node(var key: Int,
                            var left: Node? = null,
                            var right: Node? = null)

    // Nobody needs to know about the root of our tree
    private var root: Node? = null

    /**
     * Inserts new key into BinarySearchTree
     * param: key, Int
     * Return: None
     */
    fun insert(key: Int) {
        root = insertKey(root, key)
    }

    /**
     * Helper function for insert to do the recursion
     * param: root of the current subtree, Node?
     * param: key to be inserted, Int
     * return: Node?, the new root of the subtree (in case it had to change)
     */
    private fun insertKey(root: Node?, key: Int): Node? {
        // Return a new node if the tree is empty
        if (root == null) {
            return Node(key)
        }

        // Traverse to the right place and insert the node
        //TODO

        return root
    }

    // Perform an in-order tree traversal, printing as we go
    fun inorder() {
        inorderRec(root)
    }

    // We'll actually do this recursively, again starting at the root
    private fun inorderRec(root: Node?) {
        if (root != null) {
            inorderRec(root.left)
            print("${root.key} -> ")
            inorderRec(root.right)
        }
    }

    /**
     * Delete a specified key from the tree
     * param: key to be deleted, Int
     */
    fun deleteKey(key: Int) {
        root = deleteRec(root, key)
    }

    /**
     * Helper function for deleteKey, recursive
     * param: root of the current subtree, Node?
     * param: key to be deleted, Int
     * return: Node?, the new root of the subtree, in case it changed
     */
    private fun deleteRec(root: Node?, key: Int): Node? {
        // Return if the tree is empty
        if (root == null)
            return root

        // Find the node to be deleted
        if (key < root.key) {
            root.left = deleteRec(root.left, key)
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key)
        } else {
            // We found the node to delete!  It's easy if it has one
            // or no children...
            
            //TODO

            // If the node has two children, place the in-order successor
            // in the position of the node to be deleted
            
            //TODO

            // Delete the in-order successor
            
            //TODO
        }

        return root
    }

    /**
     * A helper function for deletion, finds the minimum value of a tree
     * param: root of the subtree, Node
     * return: Int, the minimum value found
     */
    private fun minValue(root: Node): Int {
        var current = root
        var minv = current.key
        while (current.left != null) {
            minv = current.left!!.key
            current = current.left!!
        }
        return minv
    }
}

// Driver Program to test the above functions
fun main() {
    val tree = BinarySearchTree()

    tree.insert(8)
    tree.insert(3)
    tree.insert(1)
    tree.insert(6)
    tree.insert(7)
    tree.insert(10)
    tree.insert(14)
    tree.insert(4)

    print("Inorder traversal: ")
    tree.inorder()

    println("\n\nAfter deleting 10")
    tree.deleteKey(10)
    print("Inorder traversal: ")
    tree.inorder()
}