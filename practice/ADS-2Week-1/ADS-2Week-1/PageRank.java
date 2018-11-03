
class PageRank {
	Digraph digraph;
	PageRank(Digraph digraph) {
		this.digraph = digraph;
	}
	public double getPR(int vertex) {
		return 0;
	}
	private double getCalculation() {
		double intialvalue = (1/digraph.numberofVertices());
		System.out.println(intialvalue);
		for (int j = 0 ; j < 1000; j++) {
			for (int i = 0; i < digraph.numberofVertices() ; i++) {


			}
		}
		return 0.0;
	}
	public  String toString() {
		return "";
	}

}