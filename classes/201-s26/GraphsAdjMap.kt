// Adapted from https://runestone.academy/ns/books/published/kotlinds/graphs_implementation.html?mode=browsing


class AdjListMap<T>(): {

    // T represents the type of the id for each vertex.
    // Each vertex maps to a set of neighbors.
    var neighbors = mutableMapOf<T, MutableSet<T>>()

    // Returns true if vertex added,
    // false if not (because it was already there)
    fun addVertex(id: T): Boolean {
        if (id !in neighbors) {
            neighbors[id] = mutableSetOf()
            return true
        } else {
            return false
        }
    }

    // Adds edge if not previously present
    fun addEdge(begin: T, end: T) {
        //TODO
    }

    // Removes edge if present, does nothing if not present
    fun removeEdge(begin: T, end: T) {
        //TODO
    }

    // Returns true if vertex is present, false if not
    fun hasVertex(id: T): Boolean {
        return id in neighbors
    }

    // Returns true if edge is present, false if not
    override fun hasEdge(begin: T, end: T): Boolean {
        val beginNeighbors = neighbors[begin]
        return beginNeighbors != null && end in beginNeighbors
    }

    // Returns a set of all vertex keys in the graph
    override fun getVertices(): Set<T> {
        return neighbors.keys
    }

    // Returns a set of all neighbors to a vertex.
    // Returns null if the vertex is not in the graph.
    override fun getNeighbors(id: T): Set<T>? {
        return neighbors[id]?.keys
    }

    override fun toString(): String {
        var result = ""
        for (vertex in neighbors.keys) {
            result += vertex.toString() + ": " + neighbors[vertex].toString() + "\n"
        }
        return result
    }
}