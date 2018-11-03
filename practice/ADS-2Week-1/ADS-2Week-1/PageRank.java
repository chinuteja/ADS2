/**.
 * Class for page rank.
 */
class PageRank {
	Digraph digraph;
	double[] rank;
	double[] prevrank;
	PageRank(Digraph digraph) {
		this.digraph = digraph;
		int vertices = digraph.numberofVertices();
		prevrank = new double[vertices];
		rank = new double[vertices];
		for (int i = 0; i < vertices; i++) {
			rank[i] = (double) 1 / vertices;
		}
	}
	public double getPR(int vertex) {
		double sum = 0;
		for (int i : digraph.adj(vertex) ) {
			if (digraph.outdegree(i) == 0) {
				return 0;
			} else {
				sum += prevrank[i] / digraph.outdegree(i);
			}
		}
		return rank[vertex] = sum;
	}
	public  void calculation() {
		for (int i = 0; i < 1000; i++ ) {
			for (int j = 0; j < digraph.numberofVertices(); j++) {
				prevrank[j] = rank[j];
				rank[j] = getPR(j);
			}

		}
	}
	public  String toString() {
		String str = "";
		for (int i = 0; i < digraph.numberofVertices(); i++) {
			str = str +i +" - "+ rank[i] +"\n";
			
		}
		return str;
	}
}
