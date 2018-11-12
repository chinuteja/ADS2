/**.
 * Class for kruskal mst.
 */
public class KruskalMST {
    private static final double FLOATING_POINT_EPSILON = 1E-12;
    /**.
     * // weight of MST
     */
    private double weight;  
    /**.
     * { // edges in MST}
     */
    private Queue<Edge> mst = new Queue<Edge>();  

    /**.
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param G the edge-weighted graph
     */
    public KruskalMST(EdgeWeightedGraph G) {
        // more efficient to build heap by passing array of edges
        MinPQ<Edge> pq = new MinPQ<Edge>();
        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        // run greedy algorithm
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);
            if (!uf.connected(v, w)) { // v-w does not create a cycle
                uf.union(v, w);  // merge v and w components
                mst.enqueue(e);  // add edge e to mst
                weight += e.weight();
            }
        }

        // check optimality conditions
        //assert check(G);
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * TIme complexity is E as it iterates through all the edges
     * @return the edges in a minimum spanning tree (or forest) as
     *    an iterable of edges
     */
    public Iterable<Edge> edges() {
        return mst;
    }

    /**
     * Returns the sum of the edge weights in a minimum 
     * spanning tree (or forest).
     * Time complexity is constant as each statement is executed only once
     * @return the sum of the edge weights in a minimum 
     * spanning tree (or forest)
     */
    public double weight() {
        return weight;
    }
    /**.
     * // check optimality conditions
     *takes time proportional to E V lg* V
     * @param      G     { edge weighted graph }
     *
     * @return     { returns true if  graph is edge weighted
     * else returns flalse }
     */
    // private boolean check(EdgeWeightedGraph G) {

    //     // check total weight
    //     double total = 0.0;
    //     for (Edge e : edges()) {
    //         total += e.weight();
    //     }
    //     if (Math.abs(total - weight()) > FLOATING_POINT_EPSILON) {
    //         return false;
    //     }

    //     // check that it is acyclic
    //     UF uf = new UF(G.V());
    //     for (Edge e : edges()) {
    //         int v = e.either(), w = e.other(v);
    //         if (uf.connected(v, w)) {
    //             System.err.println("Not a forest");
    //             return false;
    //         }
    //         uf.union(v, w);
    //     }

    //     // check that it is a spanning forest
    //     for (Edge e : G.edges()) {
    //         int v = e.either(), w = e.other(v);
    //         if (!uf.connected(v, w)) {
    //             System.err.println("Not a spanning forest");
    //             return false;
    //         }
    //     }

    //     // check that it is a minimal spanning forest
    //     // (cut optimality conditions)
    //     for (Edge e : edges()) {

    //         // all edges in MST except e
    //         uf = new UF(G.V());
    //         for (Edge f : mst) {
    //             int x = f.either(), y = f.other(x);
    //             if (f != e) uf.union(x, y);
    //         }
            
    //         // check that e is min weight edge in crossing cut
    //         for (Edge f : G.edges()) {
    //             int x = f.either(), y = f.other(x);
    //             if (!uf.connected(x, y)) {
    //                 if (f.weight() < e.weight()) {
    //                     return false;
    //                 }
    //             }
    //         }

    //     }

    //     return true;
    // }

}

