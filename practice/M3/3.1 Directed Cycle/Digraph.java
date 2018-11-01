/**.
 * imports NoSuchElementException
 */
import java.util.NoSuchElementException;
/**.
 * Class for digraph.
 */
public class Digraph {
    /**.
     * New line 
     */
    private static final String NEWLINE = System.getProperty("line.separator");
    /**.
     * { number of vertices in this digraph }
     */
    private final int vertices;
    /**.
     * number of edges in this digraph
     */
    private int edges;
    /**.
     * adj[v] = adjacency list for vertex v
     */
    private Bag<Integer>[] adj;
    /**.
     *  indegree[v] = indegree of vertex v
     */
    private int[] indegree;       
    /**
     * Constructs the object. for digraph
     *
     * @param      V     { vertex }
     */
    public Digraph(int V) {
        this.vertices = V;
        this.edges = 0;
        indegree = new int[vertices];
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * Initializes a new digraph that is a deep copy of the specified digraph.
     *
     * @param  G the digraph to copy
     */
    public Digraph(Digraph G) {
        this(G.numberofVertices());
        this.edges = G.numberofEdges();
        for (int v = 0; v < vertices; v++)
            this.indegree[v] = G.indegree(v);
        for (int v = 0; v < G.numberofVertices(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
        
    /**.
     * Returns the number of vertices in this digraph.
     *
     * @return the number of vertices in this digraph
     */
    public int numberofVertices() {
        return vertices;
    }

    /**.
     * Returns the number of edges in this digraph.
     *
     * @return the number of edges in this digraph
     */
    public int numberofEdges() {
        return edges;
    }
    /**
     * checks if the given vertex is valid or not
     *
     * @param      v     { vertex of int type }
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= vertices)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (vertices-1));
    }

    /**.
     * Adds the directed edge v→w to this digraph.
     *
     * @param  v the tail vertex
     * @param  w the head vertex
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        indegree[w]++;
        edges++;
    }
    /**
     * Returns the number of directed edges incident from vertex {@code v}.
     * This is known as the <em>outdegree</em> of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the outdegree of vertex {@code v}               
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int outdegree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns the number of directed edges incident to vertex {@code v}.
     * This is known as the <em>indegree</em> of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the indegree of vertex {@code v}               
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int indegree(int v) {
        validateVertex(v);
        return indegree[v];
    }
    /**
     * Returns the vertices adjacent from vertex {@code v} in this digraph.
     *
     * @param  v the vertex
     * @return the vertices adjacent from vertex {@code v} in this digraph, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

}
