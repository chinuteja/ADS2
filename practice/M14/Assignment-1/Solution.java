import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		String[] words = loadWords();
		//Your code goes here..
		// for (int i = 0;i < words.length;i++ ) {
		// 	System.out.println(words[i]);
			
		// }
		Scanner scan = new Scanner(System.in);
		String prefix = scan.nextLine();
		int count = 0;
		TST<Integer> tst = new TST<>();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++ ) {
				tst.put(words[i].substring(j), j);
			}

		}
		for (String str : tst.keysWithPrefix(prefix) ) {
			System.out.println(str);
		}


	}

	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}