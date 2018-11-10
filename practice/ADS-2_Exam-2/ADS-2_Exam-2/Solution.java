/**.
 * imports Scanner package
 */
import java.util.Scanner;
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object.
     * @author Teja
     */
    private Solution() {

    }
    /**.
     * main function which performs operations
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner scan = new Scanner(System.in);
        int vertices = Integer.parseInt(scan.nextLine());
        int edges = Integer.parseInt(scan.nextLine());
        //scan.nextLine();
        EdgeWeightedGraph edgeweightedgraph =
            new EdgeWeightedGraph(vertices);
        for (int i = 0; i < edges; i++) {
            String[] tokens = scan.nextLine().split(" ");
            Edge edge = new Edge(Integer.parseInt(tokens[0]),
                                 Integer.parseInt(tokens[1]),
                                 Double.parseDouble(tokens[2]));

            edgeweightedgraph.addEdge(edge);
            // System.out.println(edgeweightedgraph.toString());
        }
        String caseToGo = scan.nextLine();
        switch (caseToGo) {
        case "Graph":
            System.out.println(edgeweightedgraph.toString());
            break;
        case "DirectedPaths":
            String[] tokens1 = scan.nextLine().split(" ");
            DijkstraSP dijkstrasp = new DijkstraSP(edgeweightedgraph,
                                       Integer.parseInt(tokens1[0]));
            if (dijkstrasp.hasPathTo(Integer.parseInt(tokens1[1]))) {
                System.out.println(dijkstrasp.getDistance(
                                   Integer.parseInt(tokens1[1])));
            } else {
                System.out.println("No Path Found.");
            }
            break;
        case "ViaPaths":
            String[] tokens2 = scan.nextLine().split(" ");
            DijkstraSP dijkstra1 =
            new DijkstraSP(edgeweightedgraph, Integer.parseInt(tokens2[0]));
            DijkstraSP dijkstra2 =
            new DijkstraSP(edgeweightedgraph, Integer.parseInt(tokens2[1]));
            if (dijkstra1.hasPathTo(Integer.parseInt(tokens2[1]))
               && dijkstra2.hasPathTo(Integer.parseInt(tokens2[2]))) {
                 double c1 = dijkstra1.distTo(Integer.parseInt(tokens2[1]));
                 double c2 = dijkstra2.distTo(Integer.parseInt(tokens2[2]));
                System.out.println(c1 + c2);
                System.out.println(dijkstra1.pathTo(
                    Integer.parseInt(tokens2[1])) + " "
                             + dijkstra2.pathTo(Integer.parseInt(tokens2[2])));
            } else {
                System.out.println("No Path Found.");
            }
            break;
        default:
            break;
        }

    }
}


