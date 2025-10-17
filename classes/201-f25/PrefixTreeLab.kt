/*
 * PrefixTree.kt
 * 
 * This is Dave Musicant's Trie.kt from Fall 2024,
 * which was ported by Dave from the Trie code at
 * https://www.geeksforgeeks.org/introduction-to-trie-data-structure-and-algorithm-tutorials.
 * 
 * Modified lightly by Tanya Amert for Spring 2025.
 * Modified further by Anya Vostinar for Fall 2025.
 * 
 * (Incomplete) Implementation of a Prefix Tree ("Trie").
 */

 data class TrieNode(
    var childNode: Array<TrieNode?> = Array<TrieNode?>(26) { null },

    // This will keep track of number of strings that are stored in
    // the prefix tree from root node to any Trie node.
    var wordCount: Int = 0
)

/*
 * Add a string to the prefix tree, character by character if needed.
 */
fun insert(root: TrieNode, key: String) {
    //TODO
}



/*
 * Checks whether a given string is present in the prefix tree.
 */
fun search(root: TrieNode, key: String): Boolean {
    //TODO
    return false
}

/*
 * Checks if a given prefix exists in the prefix tree.
 * Could be useful as a helper function?
 */
fun isPrefixExist(root: TrieNode, key: String): Boolean {
    //TODO
    return false
}

/*
 * Deletes a string from the prefix tree, clearing out pointers to
 * lower nodes if a node is no longer used.
 */
fun deleteKey(root: TrieNode, word: String): Boolean {
    //TODO
    return false
}

fun main() {
    // Make a root node for the prefix tree
    val root = TrieNode()

    // List out the strings that we want to *insert* in the prefix tree
    val inputStrings = listOf("and", "ant", "do", "geek", "dad", "ball", "an")

    // for (inputString in inputStrings) {
    //     insert(root, inputString)
    // }

    // // List out the strings that we want to *search* in the prefix tree
    // val searchQueryStrings = listOf("do", "geek", "bat", "an")

    // for (searchQueryString in searchQueryStrings) {
    //     println("Query String: $searchQueryString")
    //     if (search(root, searchQueryString)) {
    //         println("The query string is present in the Trie")
    //     }
    //     else {
    //         println("The query string is not present in the Trie")
    //     }
    // }

    // // List out the strings that we want to *delete* from the prefix tree
    // val deleteQueryStrings = listOf("geek", "tea")

    // for (deleteQueryString in deleteQueryStrings) {
    //     println("Query String: $deleteQueryString")
    //     if (deleteKey(root, deleteQueryString)) {
    //         println("The query string is successfully deleted")
    //     }
    //     else {
    //         println("The query string is not present in the Trie")
    //     }
    // }
}