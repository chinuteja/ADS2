/**.
 * imports Scanner package
 */
import java.util.Scanner;
/**.
 * class for Solution
 */
public final class Solution {
	/**.
	 * Constructs the object.
	 * @author Teja
	 */
	private Solution() {

	}
	/**.
	 * main function which performs operations
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int noofstrings = scan.nextInt();
		scan.nextLine();
		String[] a = new String[noofstrings];
		Quick3string quick3string = new Quick3string();
		for (int i = 0; i < noofstrings; i++) {
			a[i] = scan.nextLine();
		}
		quick3string.sort(a);
		String str = "[";
		int i;
		for ( i = 0; i < noofstrings - 1 ; i++ ) {
			
			str = str + a[i] + ", ";
		}
		str = str + a[i] + "]";
		System.out.println(str);
	}
}
