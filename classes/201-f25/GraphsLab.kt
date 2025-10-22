// Adjacency Matrix & List graph representation
// Ported to Kotlin by Dave Musicant from Java code at
// https://www.programiz.com/dsa/graph-adjacency-matrix
// https://www.programiz.com/dsa/graph-adjacency-list
// Adapted for in-class lab by Jean Salac and Anya Vostinar

class AdjMatrixGraph(numVertices: Int) {
    var adjMatrix = Array<Array<Boolean>>(numVertices) {Array<Boolean>(numVertices) {false}}

    /**
     * Adds an edge to the graph between two existing nodes, start and end
     * param: index of start node, Int
     * param: index of end node, Int
     */
    fun addEdge(start: Int, end: Int) {
        
    }

    /**
     * Removes an edge from the graph between two existing nodes, start and end
     * param: index of start node, Int
     * param: index of end node, Int
     */
    fun removeEdge(start: Int, end: Int) {
        
    }

    // Implement a function to check if a given node/vertex is in the graph. 
    // Returns true if node/vertex is in the graph, false if not
    // When you're done, test your implementation in main
    fun hasNode(){

    }

    // Implement a function to check if a given edge is in the graph. 
    // Returns true if edge is in the graph, false if not
    // When you're done, test your implementation in main
    fun hasEdge(){

    }
    

    // Print the matrix
    override fun toString(): String {
        var s = StringBuilder()
        for (i in 0..<adjMatrix.count()) {
            s.append("$i: ")
            for (j in adjMatrix[i]) {
                s.append((if (j) 1 else 0).toString() + " ")
            }
            s.append("\n")
        }
        return s.toString()
    }
}

class AdjListGraph(numVertices: Int) {
    var adjList = mutableListOf<MutableList<Int>>()
    
    init{
        for (i in 0..<numVertices) {
            adjList.add(mutableListOf<Int>())
        }
    }

    // Add edge
    fun addEdge(s: Int, d: Int) {
        adjList[s].add(d)
        adjList[d].add(s)
    }

    // Implement a function to check if a given node/vertex is in the graph. 
    // Returns true if node/vertex is in the graph, false if not
    // When you're done, test your implementation in main
    fun hasNode(){

    }

    // Implement a function to check if a given edge is in the graph. 
    // Returns true if edge is in the graph, false if not
    // When you're done, test your implementation in main
    fun hasEdge(){

    }

    // Print the graph
    override fun toString(): String {
        var s = StringBuilder()
        for (i in 0..<adjList.count()) {
            s.append("\nVertex $i:")
            for (j in 0..<adjList[i].count()) {
                s.append(" -> ${adjList[i][j]}")
            }
            s.append("\n")
        }
        return s.toString()
    }

}

fun main(){
    // Adjacency Matrix Graph Representation
    val gMatrix = AdjMatrixGraph(4)

    gMatrix.addEdge(0, 1)
    gMatrix.addEdge(0, 2)
    gMatrix.addEdge(1, 2)
    gMatrix.addEdge(2, 0)
    gMatrix.addEdge(2, 3)

    println(gMatrix.toString())

    // Test your implementations of hasNode and hasEdge for Adjacency Matrix

    // Adjacency List Graph Representation
    val gList = AdjListGraph(5)
     
    gList.addEdge(0, 1)
    gList.addEdge(0, 2)
    gList.addEdge(0, 3)
    gList.addEdge(1, 2)

    println(gList.toString())

    // Test your implementations of hasNode and hasEdge for Adjacency List

}