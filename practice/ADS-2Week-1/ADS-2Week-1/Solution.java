/**.
 * imports Scanner package
 */
import java.util.Scanner;
/**.
 * Class for web search.
 */
class WebSearch {

}
/**.
 * Class for solution.
 */
public final class Solution {
    /**.
     * Constructs the object for soluiton
     * @author Teja
     */
    private Solution() {
        
    }
    /**.
     * main method
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // read the first line of the input to get the number of vertices
        Scanner scan = new Scanner(System.in);
        int vertices = scan.nextInt();
        Digraph digraph = new Digraph(vertices);
        LinearProbingHashST<Integer, Integer> hs = new LinearProbingHashST<>();
        for (int i = 0; i <= vertices; i++) {
            String[] tokens = scan.nextLine().split(" ");
            for (int j = 1; j < tokens.length; j++ ) {
                digraph.addEdge(Integer.parseInt(tokens[0]), 
                    Integer.parseInt(tokens[j]));
                //System.out.println(tokens[0] + "......" +tokens[j]);
                hs.put(Integer.parseInt(tokens[0]), 
                    Integer.parseInt(tokens[j]));
            }
        }
        // iterate count of vertices times
        // to read the adjacency list from std input
        // and build the graph
        System.out.println(digraph.numberofVertices() + " vertices, "
                           + digraph.numberofEdges() + " edges");
        for (int i = 0; i < digraph.numberofVertices(); i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(i + ": ");
            for (int w : digraph.adj(i)) {
                sb.append(w + " ");
            }
            System.out.println(sb.toString());
        }
        PageRank pagerank = new PageRank(digraph);
        pagerank.calculation();
        System.out.println();
        System.out.println(pagerank.toString());
        //System.out.println(pagerank.getPR);


        // Create page rank object and pass the graph object to the constructor

        // print the page rank object

        // This part is only for the final test case

        // File path to the web content
        String file = "WebContent.txt";

        // instantiate web search object
        // and pass the page rank object and the file path to the constructor

        // read the search queries from std in
        // remove the q= prefix and extract the search word
        // pass the word to iAmFeelingLucky method of web search
        // print the return value of iAmFeelingLucky

    }
}
