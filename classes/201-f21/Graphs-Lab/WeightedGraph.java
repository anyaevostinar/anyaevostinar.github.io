/**
 * An interface for weighted graphs.  For more discussion of the structure and
 * use of this interface, see the Graph interface.
 *   The return value of getWeight() may be a "sentinel" value that indicates
 * the requested edge is absent from the graph.  Typical sentinels include
 * positive or negative infinity, zero, or NaN.  Classes that implement this
 * interface should specify what sentinel value they use, or allow the user to
 * choose their own sentinel.
 *   Note that any of these methods may throw an IndexOutOfBoundsException if
 * any of the input vertex IDs are out of bounds.
 * @author Jadrian Miles
 */
public interface WeightedGraph extends Graph {
    /** Adds a weighted edge between two vertices.
     * In an undirected graph, this has the same effect as
     * addEdge(end, begin, weight).
     * @return false if the edge was already in the graph.
     */
    public boolean addEdge(int begin, int end, double weight);
    
    /** Sets the weight of an edge already in the graph.
     * @return false if the edge is not in the graph.
     */
    public boolean setWeight(int begin, int end, double weight);
    
    /** Gets the weight of the edge between two vertices.
     * In an undirected graph, this returns the same as getWeight(end, begin).
     * @return the weight of the edge from begin to end, or the sentinel value
     *   if no such edge exists.
     */
    public double getWeight(int begin, int end);
    
    /** Returns the "sentinel" weight value for edges not in the graph. */
    public double missingEdgeSentinel();
}
