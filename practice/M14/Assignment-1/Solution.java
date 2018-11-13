/**.
 * imports Scanner package
 */
import java.util.Scanner;
/**.
 * Class for solution.
 * @author Teja
 */
public final class Solution {
    /**.
     * Constructs the object for SOlution
     */
    private Solution() {

    }
    /**.
     * main function which performs the operations
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        String[] words = loadWords();
        //Your code goes here..
        // for (int i = 0;i < words.length;i++ ) {
        //  System.out.println(words[i]);
        // }
        Scanner scan = new Scanner(System.in);
        String prefix = scan.nextLine();
        TST<Integer> tst = new TST<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                tst.put(words[i].substring(j), j);
            }
        }
        for (String str : tst.keysWithPrefix(prefix)) {
            System.out.println(str);
        }
    }
    /**.
     * Loads words.
     *
     * @return     { returns words from file }
     */
    public static  String[] loadWords() {
        In in = new In("/Files/dictionary-algs4.txt");
        String[] words = in.readAllStrings();
        return words;
    }
}

