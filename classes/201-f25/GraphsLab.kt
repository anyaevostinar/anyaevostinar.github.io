// Adjacency Matrix & List graph representation
// Ported to Kotlin by Dave Musicant from Java code at
// https://www.programiz.com/dsa/graph-adjacency-matrix
// https://www.programiz.com/dsa/graph-adjacency-list
// Adapted for in-class lab by Jean Salac and Anya Vostinar

class AdjMatrixGraph(numVertices: Int) {
    var adjMatrix = Array<Array<Boolean>>(numVertices) {Array<Boolean>(numVertices) {false}}

    /**
     * Add an edge to the graph
     * param: int, starting vertex for edge
     * param: int, ending vertex for edge
     */
    fun addEdge(i: Int, j: Int) {
        //Student TODO
               
    }

    /**
     * Remove edge from graph
     * param: int, starting vertex for edge
     * param: int, ending vertex for edge
     */
    fun removeEdge(i: Int, j: Int) {
        //Student TODO
        
    }

    /**
     * Check if edge exists in graph
     * param: int, starting vertex for edge
     * param: int, ending vertex for edge
     * return: Boolean with result
     */
    fun hasEdge(v1 : Int, v2 : Int) : Boolean{
        //Student TODO
        return false
    }

    /**
     * Get the neighbors of a vertex 
     * param: int, vertex to retrieve neighbors of
     * return: MutableList<Int> of neighbors
     */
    fun getNeighbors(vertex : Int) : MutableList<Int> {
        //Student TODO
        
        var neighbors = mutableListOf<Int>()

        return neighbors
    }
    

    /**
     * Create string visualization of the graph, to be used with println
     * return: string
     */
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

    /**
     * Add a vertex to the graph with no neighbors
     */
    fun addVertex() {
        //Student TODO

    }
}

class AdjListGraph(numVertices: Int) {
    var adjList = mutableListOf<MutableList<Int>>()
    
    init{
        for (i in 0..<numVertices) {
            adjList.add(mutableListOf<Int>())
        }
    }

    /**
     * Add an edge to the graph
     * param: int, starting vertex for edge
     * param: int, ending vertex for edge
     */
    fun addEdge(s: Int, d: Int) {
        //Student TODO
         
    }

    /**
     * Remove edge from graph
     * param: int, starting vertex for edge
     * param: int, ending vertex for edge
     */
    fun removeEdge(i: Int, j: Int) {
        //Student TODO
    }

    /**
     * Check if edge exists in graph
     * param: int, starting vertex for edge
     * param: int, ending vertex for edge
     * return: Boolean with result
     */
    fun hasEdge(v1 : Int, v2: Int) : Boolean{
        //Student TODO
        return false

    }

    /**
     * Get the neighbors of a vertex 
     * param: int, vertex to retrieve neighbors of
     * return: MutableList<Int> of neighbors
     */
    fun getNeighbors(vertex : Int): MutableList<Int> {
        //Student TODO
        var neighbors = mutableListOf<Int>()

        return neighbors
    }

    /**
     * Create string visualization of the graph, to be used with println
     * return: string
     */
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

    /**
     * Add a vertex to the graph with no neighbors
     */
    fun addVertex() {
        //Student TODO
        
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

    // println("hasEdge 0 1: " + gMatrix.hasEdge(0, 1))
    // println("hasEdge 0 7: " + gMatrix.hasEdge(0, 7))

    // gMatrix.removeEdge(2, 0)
    // println("hasEdge 0 2 should be false: " + gMatrix.hasEdge(0, 2))

    // println("getNeighbors for 1: " + gMatrix.getNeighbors(1))

    // gMatrix.addVertex()
    // println(gMatrix)

    // Adjacency List Graph Representation
    val gList = AdjListGraph(5)
     
    gList.addEdge(0, 1)
    gList.addEdge(0, 2)
    gList.addEdge(1, 2)
    gList.addEdge(2, 0)
    gList.addEdge(2, 3)

    // println(gList)

    // println("hasEdge 0 1: " + gList.hasEdge(0, 1))
    // println("hasEdge 0 7: " + gList.hasEdge(0, 7))

    // gList.removeEdge(2, 0)
    // println("hasEdge 0 2 should be false: " + gList.hasEdge(0, 2))

    // println("getNeighbors for 1: " + gList.getNeighbors(1))

    // gList.addVertex()
    // println(gList)

}