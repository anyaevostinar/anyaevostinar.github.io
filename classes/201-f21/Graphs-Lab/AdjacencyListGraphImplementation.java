import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

/**
 * The goal of this lab is to implement an unweighted graph and contrast
 * an adjacency matrix and adjacency list implementation.
 * Some of the implementation is provided for you - read the lab instructions
 * for how to proceed.
 *
 */
public class AdjacencyListGraphImplementation implements UnweightedGraph {
    //Instance variables. Make the comment below more specific about how
    //exactly adjacencyLists is organized.
    private List<List<Integer>> adjacencyLists;//List of adjacency lists. Store edges here.
    private boolean directed;
    
    /**
     * Constructs an unweighted graph that is directed if
     * directed = true and undirected otherwise.
     * @param directed
     */
    public AdjacencyListGraphImplementation(boolean directed) {
        adjacencyLists = new ArrayList<List<Integer>>();
        this.directed = directed;
    }

    /** Adds a new vertex.
     * @return the ID of the added vertex.
     */
    @Override
    public int addVertex() {
        adjacencyLists.add(new LinkedList<Integer>());
        return adjacencyLists.size() - 1;
    }


    /** Checks whether an edge exists between two vertices.
     * In an undirected graph, this returns the same as hasEdge(end, begin).
     * @return true if there is an edge from begin to end.
     */
    @Override
    public boolean hasEdge(int begin, int end) {
        // TODO Auto-generated method stub
        return false;
    }


    /** 
     * Returns the out-degree of the specified vertex. The
     * out-degree is the number of outgoing edges.
     */
    @Override
    public int getDegree(int v) {
        // TODO: Implement me!
        return 0;
    }



    /** 
     *Returns the in-degree of the specified vertex. The
     * in-degree is the number of incoming edges.
     */
    @Override
    public int getInDegree(int v) {
        throw new UnsupportedOperationException("getInDegree not required for lab");
    }



    /** Returns an iterable object that allows iteration over the neighbors of
     * the specified vertex.  In particular, the vertex u is included in the
     * sequence if and only if there is an edge from v to u in the graph.
     * Note: The implementation below is not the best possible implementation.
     * It allows the client to change the graph structure. One extension of the
     * lab is to modify this implementation to not allow the client to change the
     * graph structure, without changing the time complexity of this method.
     */
    @Override
    public Iterable<Integer> getNeighbors(int v) {
        if(v < 0 || v >= adjacencyLists.size()) {
            throw new IndexOutOfBoundsException();
        }
        return adjacencyLists.get(v);
    }


    /** Returns the number of vertices in the graph. */
    @Override
    public int numVerts() {
        return adjacencyLists.size();
    }



    /** Returns the number of edges in the graph.
     * The result does *not* double-count edges in undirected graphs.
     */
    @Override
    public int numEdges() {
        throw new UnsupportedOperationException("numEdges not required for lab");
    }



    /** Returns true if the graph is directed. */
    @Override
    public boolean isDirected() {
        return directed;
    }


    /** Returns true if there are no vertices in the graph. */
    @Override
    public boolean isEmpty() {
        return adjacencyLists.isEmpty();
    }


    /** Removes all vertices and edges from the graph. */
    @Override
    public void clear() {
        adjacencyLists = new ArrayList<List<Integer>>();
    }


    /** Adds an unweighted edge between two vertices.
     * In an undirected graph, this has the same effect as addEdge(end, begin).
     * @return false if the edge was already in the graph.
     * @throws IndexOutOfBoundsException if either vertex ID is out of bounds.
     */
    @Override
    public boolean addEdge(int begin, int end) {
        // TODO Auto-generated method stub
        return false;
    }


    /**
     * Unit tests for the graph implementation.
     * This tests many of the things you might want to test, but not all of them.
     * If you have extra time, brainstorm some more tests and add them.
     * @param args
     */
    public static void main(String[] args) {
        //Tests undirected - testing directed is left as an exercise
        UnweightedGraph g = new AdjacencyListGraphImplementation(false);
        boolean passedAllTests = true;
        //First, some tests to make sure a newly created graph is really empty. You could
        //add more tests here if you wanted.
        if(!g.isEmpty()) {
            System.err.println("Newly created graph is not empty");
            passedAllTests = false;
        }
        if(g.numVerts() != 0) {
            System.err.println("Expected 0 vertices for a new graph, found: " + g.numVerts());
            passedAllTests = false;
        }
        //Now add some vertices and edges and test how things went.
        int numVertices = 18;
        for(int i = 0; i < numVertices; i++) {
            int newVertex = g.addVertex();
            if(g.numVerts() != i+1) {
                System.err.println("Added " + (i+1) + " vertices, but graph says it has " + g.numVerts() + " vertices.");
                passedAllTests = false;
            }
            if(newVertex != i) {
                System.err.println("Added vertex that should have index " + i + " but had index " + newVertex + ".");
                passedAllTests = false;
            }
        }

        //Now let's add edges so that there's an edge from each even numbered vertex to every other
        //vertex, except the final vertex (so that one shouldn't have any edges).
        //We also don't include self loops (you might think through whether your
        //method would be correct with self loops.)
        for(int i = 0; i < numVertices-1; i+=2) {
            for(int j = 0; j < numVertices-1; j++) {
                if(i != j) {
                    g.addEdge(i,j);
                    if(!g.hasEdge(i,j)) {
                        System.err.println("Added edge (" + i + ", " + j + "), but hasEdge returned false.");
                    }
                    if(!g.hasEdge(j,i)) {//Undirected graph, so adding (i,j) should get us (j,i) too
                        System.err.println("Added edge (" + i + ", " + j + "), but hasEdge for opposite order returned false.");
                    }
                }
            }
        }
        //Go through the vertices and make sure edges, in degree, out degree, and neighbors are correct
        for(int i = 0; i < numVertices; i++) {
            int expectedNumNeighbors = 9;
            if(i % 2 == 0) {
                expectedNumNeighbors = 16;
            } else if(i == 17) {
                expectedNumNeighbors = 0;
            }
            //Checking that the neighbor iterator is correct
            int numNeighborsFound = 0;
            Iterable<Integer> neighbors = g.getNeighbors(i);
            for(int v : neighbors) {
                numNeighborsFound++;
                if((i % 2 == 1 && v % 2 == 1) || i == 17 || v == 17) {
                    //Shouldn't have an edge between two odd vertices or any edges involving final vertex!
                    System.err.println("Found an unexpected edge between " + i + " and " + v);
                    passedAllTests = false;
                }   
            }
            if(numNeighborsFound != expectedNumNeighbors) {
                System.err.println("vertex: " + i + "; expected " + expectedNumNeighbors + " neighbors, but found " + numNeighborsFound);
                passedAllTests = false;
            }
            //Now check in and out degree. Since we're not directed, they should both equal expected num neighbors.
            if(g.getDegree(i) != expectedNumNeighbors) {
                System.err.println("Expected degree " + expectedNumNeighbors + " but found degree " + g.getDegree(i));
                passedAllTests = false;
            }
        }

        //Check that calling with negative or too large numbers results in IndexOutOfBoundsException
        try {
            g.getDegree(150);
            System.err.println("Called getDegree with too large of a vertex and no exception was thrown.");
            passedAllTests = false;
        } catch(IndexOutOfBoundsException e) {
            ;
        }

        try {
            g.getDegree(-5);
            System.err.println("Called getDegree with too small of a vertex and no exception was thrown.");
            passedAllTests = false;
        } catch(IndexOutOfBoundsException e) {
            ;
        }
        try {
            g.getNeighbors(150);
            System.err.println("Called getNeighbors with too large of a vertex and no exception was thrown.");
            passedAllTests = false;
        } catch(IndexOutOfBoundsException e) {
            ;
        }
        try {
            g.getNeighbors(-5);
            System.err.println("Called getNeighbors with too small of a vertex and no exception was thrown.");
            passedAllTests = false;
        } catch(IndexOutOfBoundsException e) {
            ;
        }
        System.out.println("All tests passed: " + passedAllTests);


    }


}
