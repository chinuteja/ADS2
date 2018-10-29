import java.util.Scanner;
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String type = scan.nextLine();
		int vertices = scan.nextInt();
		int edges = scan.nextInt();
		scan.nextLine();
		LinearProbingHashST<Integer, String> hashst = new LinearProbingHashST<>();
		String[] places = scan.nextLine().split(",");
		for (int i = 0; i < places.length; i++) {
			hashst.put(i, places[i]);
		}
		switch (type) {
		case "List":
			Graph graph = new Graph(vertices);
			while (scan.hasNext()) {
				String[] tokens = scan.nextLine().split(" ");
				graph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
			}

			System.out.println(graph.V() + " vertices, " + graph.E() + " edges");
			if (graph.E() == 0) {
				System.out.println("No edges");
				break;
			}
			for (int i = 0; i < graph.V(); i++) {
				StringBuffer str = new StringBuffer();
				str.append(hashst.get(i) + ": ");
				for (int w : graph.adj(i)) {
					str.append(hashst.get(w) + " ");
				}
				System.out.println(str.toString().trim());
			}

		}
		//System.out.println(type);

	}


}