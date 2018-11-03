import java.util.Scanner;
class PageRank {

}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner scan = new Scanner(System.in);
		int vertices = scan.nextInt();
		Digraph digraph = new Digraph(vertices);
		for (int i = 0; i < vertices; i++) {
			String[] tokens = scan.nextLine().split(" ");
			for (int j = 1; j < tokens.length; j++ ) {
                  digraph.addEdge(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[j]));
			}
		}
		// iterate count of vertices times
		// to read the adjacency list from std input
		// and build the graph
		System.out.println(digraph.numberofVertices() + " vertices, "
                               + digraph.numberofEdges() + " edges");
        System.out.println(digraph.toString());

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
