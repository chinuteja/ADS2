
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
		for (int i :digraph.adj(vertex) ) {
			if (digraph.outdegree(i) == 0) {
				return 0;
			}
			else {
				sum += prevrank[i] / digraph.outdegree(i);
			}
		}
		return rank[vertex] = sum;
	}
	public  double getCalculation() {
		double intialvalue = (1 / digraph.numberofVertices());
		//System.out.println(digraph.numberofVertices());
		System.out.println(intialvalue);
		for (int j = 0 ; j < 1000; j++) {
			for (int i = 0; i < digraph.numberofVertices() ; i++) {


			}
		}
		return intialvalue;
	}
	public  String toString() {
		return "";
	}

}