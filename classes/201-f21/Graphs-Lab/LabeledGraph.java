

/**
 * This interface is very similar to the Graph interface, but it allows
 * nodes to be labeled with some object.
 * 
 * @author Anna Rafferty
 */
public interface LabeledGraph<T> {
    /** Adds a new vertex, if the vertex doesn't already exist.
     * @return whether a vertex was added
     */
    public boolean addVertex(T label);
    
    /** Checks whether an edge exists between two vertices.
     * In an undirected graph, this returns the same as hasEdge(end, begin).
     * @return true if there is an edge from begin to end.
     */
    public boolean hasEdge(T begin, T end);
    
    /** Returns the out-degree of the specified vertex. */
    public int getDegree(T v);
    
    /** Returns the in-degree of the specified vertex. */
    public int getInDegree(T v);
    
    /** Returns an iterable object that allows iteration over the neighbors of
     * the specified vertex.  In particular, the vertex u is included in the
     * sequence if and only if there is an edge from v to u in the graph.
     */
    public Iterable<T> getNeighbors(T v);
    
    /** Returns the number of vertices in the graph. */
    public int numVerts();
    
    /** Returns the number of edges in the graph.
     * The result does *not* double-count edges in undirected graphs.
     */
    public int numEdges();
    
    /** Returns true if the graph is directed. */
    public boolean isDirected();
    
    /** Returns true if there are no vertices in the graph. */
    public boolean isEmpty();
    
    /** Removes all vertices and edges from the graph. */
    public void clear();
}
