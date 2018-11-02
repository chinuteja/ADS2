import java.util.Scanner;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String synsetsFileName = scan.nextLine();
		String hypernymsFileName = scan.nextLine();
		WordNet wordNet = new WordNet("\\Files\\"+synsetsFileName, "\\Files\\"+hypernymsFileName);
		String line = scan.nextLine();
		switch (line) {
		case "Graph":
			wordNet.printGraph();
			break;
		case "Queries":
			break;
		default:
			break;
		}
	}
}
