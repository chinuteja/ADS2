/**.
 * imports iterator
 */
import java.util.Iterator;
/**.
 * imports nosuch element exception
 */
import java.util.NoSuchElementException;
/**.
 * Class for adj matrix graph.
 */
public class AdjMatrixGraph {
    private static final String NEWLINE = System.getProperty("line.separator");
    /**.
     * number of vertices
     */
    private final int V;
    /**.
     * number of edges
     */
    private int E;
    /**.
     * adjcent matrix of boolean type
     */
    private boolean[][] adj;

    /**
     * Constructs the object for Adjmatrixgraph
     *
     * @param      V     { number of vertices }
     */
    public AdjMatrixGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Too few vertices");
        this.V = V;
        this.E = 0;
        this.adj = new boolean[V][V];
    }
    /**.
     * number of vertices
     * Time complesxity is constant as each statement is executed only once
     * @return     { returns number of vertices }
     */
    public int V() { return V; }
    /**.
     * { number of edges }
     * Time complesxity is constant as each statement is executed only once
     * @return     { returns number of edges }
     */
    public int E() { return E; }
    /**.
     * Adds an edge.
     *
     * @param      v     { integer type }
     * @param      w     { integer type }
     */
    public void addEdge(int v, int w) {
        if (v == w) return;
        if (!adj[v][w]) E++;
        adj[v][w] = true;
        adj[w][v] = true;
    }
    /**.
     * checks if given components are connected or not
     *
     * @param      v     { integer type }
     * @param      w     { integer type  }
     *
     * @return     { returns true if the two components are connected
     *             else returns false }
     */
    public boolean contains(int v, int w) {
        return adj[v][w];
    }

    // return list of neighbors of v
    public Iterable<Integer> adj(int v) {
        return new AdjIterator(v);
    }

    // support iteration over graph vertices
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int v;
        private int w = 0;

        AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<Integer> iterator() {
            return this;
        }
        /**.
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w]) return true;
                w++;
            }
            return false;
        }
        /**
         *
         *
         * @return     { returns integer type }
         */
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return w++;
        }
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is N^2 as each for loop iterates for N times.
     * @return     String representation of the object.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V(); i++) {
            for (int j = 0; j < V(); j++) {
                if (adj[i][j] == true)
                    sb.append("1 ");
                else
                    sb.append("0 ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }

}
