import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for page rank.
 */
class PageRank {
    /**
     * array for the page ranks.
     */
    double[] pageRank;
    /**
     * digraph onject.
     */
    Digraph digraph;
    /**
     * previous ranks array.
     */
    double[] prevRank;
    Digraph revGraph;
    /**
     * Constructs the object.
     * Time complexities is O(V)
     * V is number of vertices.
     *
     * @param      g     digraph object.
     */
    PageRank(final Digraph g) {
        //graph = g;
        int vertices = digraph.numberofVertices();
        pageRank = new double[vertices];
        prevRank = new double[vertices];
        for (int i = 0; i < vertices; i++) {
            pageRank[i] = 1.0 / vertices;
        }
        for (int i = 0; i < vertices; i++) {
            if (digraph.outdegree(i) == 0) {
                for (int j = 0; j < vertices; j++) {
                    if (j != i) {
                        digraph.addEdge(i, j);
                    }
                }
            }
        }
        // values = new Double[graph.V()];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < vertices; j++) {
                getPR(j);
            }
            pageRank = Arrays.copyOf(prevRank, prevRank.length);
        }

    }
    /**
     * Gets the pr.
     * Time complexities is O(E).
     * E is number of adjacent values to that vertex.
     *
     * @param      vertex  The vertex
     *
     * @return     The pr.
     */
    public double getPR(final int vertex) {
        double sum = 0;
        // int[] values = new int[graph.V()];
        if (digraph.indegree(vertex) == 0) {
            prevRank[vertex] = 0;
            return prevRank[vertex];
        }
        for (int v : digraph.reverse().adj(vertex)) {
            sum += (pageRank[v] / digraph.outdegree(v));
        }
        prevRank[vertex] = sum;
        return prevRank[vertex];
    }


    /**
     * this method to perform to add the pagerank to that vertex.
     * time complexity is O(V*1000)
     * V is number of vertices.
     */
    public void calculation() {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < digraph.numberofVertices(); j++) {
                prevRank[j] = pageRank[j];
                pageRank[j] = getPR(j);
                // if(prevRank[j] == pageRank[j]){
                //  break;
                // }
            }
        }
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is O(V).
     * V is number of vertices
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < digraph.numberofVertices(); i++) {
            str += i + " - " + pageRank[i] + "\n";
        }
        return str;
    }

}