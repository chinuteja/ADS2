import java.util.Scanner;
import java.util.Arrays;
public final class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noofstrings = scan.nextInt();
		scan.nextLine();
		String[] a = new String[noofstrings];
		Quick3string quick3string = new Quick3string();
		for (int i = 0; i < noofstrings; i++) {
			a[i] = scan.nextLine();
		}
		quick3string.sort(a);
		//System.out.println(quick3string.sort(a));
		String str = "[";
		int i;
		for ( i = 0; i < noofstrings - 1 ; i++ ) {
			
			str = str + a[i] + ", ";
		}
		str = str + a[i] + "]";
		System.out.println(str);

	}
}