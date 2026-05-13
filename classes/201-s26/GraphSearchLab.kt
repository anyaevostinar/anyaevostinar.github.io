import AdjListMap

class DfsSolver<V>(val graph: AdjListMap<V>) {
    val previous = mutableMapOf<V, V?>()
    private val visited = mutableSetOf<V>()

    init {
        dfsAll()
    }

    private fun dfsAll() {
        for (vertex in graph.getVertices()) {
            previous[vertex] = null
        }

        for (start in graph.getVertices()) {
            if (start !in visited) {
                dfs(start)
            }
        }
    }

    private fun dfs(vertex: V) {
        visited.add(vertex)
        val neighbors = graph.getNeighbors(vertex)
        if (neighbors == null) {
            return
        }
        for (neighbor in neighbors) {
            if (neighbor !in visited) {
                previous[neighbor] = vertex
                dfs(neighbor)
            }
        }
    }



}

fun main() {
    // Create a graph
    val graph = AdjListMap<Int>()
    graph.addVertex(0)
    graph.addVertex(1)
    graph.addVertex(2)
    graph.addVertex(3)
    
    graph.addEdge(0, 1)
    graph.addEdge(1, 2)
    graph.addEdge(2, 3)

    val dfsSolver = DfsSolver(graph)


    // Test DFS
    println("Depth first previous values:")
    println(dfsSolver.previous)

}
