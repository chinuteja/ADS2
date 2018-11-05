public class SAP {

	// constructor takes a digraph (not necessarily a DAG)
	// Digraph G = new Digrape	h(wordNet.processSynsets(String synsets));
	Digraph G;

	public SAP(Digraph G) {
		this.G  = G; 
	}

	// length of shortest ancestral path between v and w; -1 if no such path
	public int length(int v, int w) {
		BreadthFirstDirectedPaths bfs1 = new BreadthFirstDirectedPaths(G, v);
		BreadthFirstDirectedPaths bfs2 = new BreadthFirstDirectedPaths(G, w);
		return 0;
	}

	// a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
	public int ancestor(int v, int w) {
		return 0;
	}

	// length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
	public int length(Iterable<Integer> v, Iterable<Integer> w) {
		return 0;
	}

	// a common ancestor that participates in shortest ancestral path; -1 if no such path
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		return 0;
	}

	// do unit testing of this class
	//public static void main(String[] args)
}
