/**.
 * Class for quick 3 string.
 */
public class Quick3string {
    /**.
     * Constructs the object for quick3String
     */
    protected Quick3string() {

    }
    /**.
     * CUTOFF to insertion sort
     */
    private static final int CUTOFF =  15;
    /** .
     * Rearranges the array of strings in ascending order.
     * Time complexity is O(n) bcz it uses overloaded sort function.
     * @param a the array to be sorted
     */
    public static void sort(final String[] a) {
        //StdRandom.shuffle(a);
        sort(a, 0, a.length - 1, 0);
        assert isSorted(a);
    }
    /**.
     * return the dth character of s, -1 if d = length of s
     *TIme complexity is constant bcz each statement is executed
     *only once
     * @param      s     { String  }.
     * @param      d     { dth character }.
     *
     * @return     { returns dth character of s }.
     */
    private static int charAt(final String s, final int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) {
            return -1;
        }
        return s.charAt(d);
    }

    /**
     * { sorts the elements in an array }.
     * Time complexity is O(N) bcz sort method is called recursively.
     * @param      a     { String array }.
     * @param      lo    The lower.
     * @param      hi    The higher.
     * @param      d     { intiger value }.
     */
    private static void sort(final String[] a, final int lo, final int hi,
                             final int d) {

        // cutoff to insertion sort for small subarrays
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }

        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if      (t < v) {
                exch(a, lt++, i++);
            } else if (t > v) {
                exch(a, i, gt--);
            } else     {
                i++;
            }
        }
        sort(a, lo, lt - 1, d);
        if (v >= 0) {
            sort(a, lt, gt, d + 1);
        }
        sort(a, gt + 1, hi, d);
    }
    /**.
     * insertion sort sorts all the elements in the array
     * Time complexity is O(N^2) bcz two for loop iterates for N times
     * @param      a     { array of string type }.
     * @param      lo    The lower.
     * @param      hi    The higher.
     * @param      d     { index of int type }.
     */
    private static void insertion(final String[] a, final int lo, final int hi,
                                  final int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**.
     * exchanges two elements in an array.
     *TIme complexity is constant bcz each statement is executed
     * @param      a     { String array }.
     * @param      i     { index of array }.
     * @param      j     { index of array }.
     */
    private static void exch(final String[] a, final int i, final int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /**.
     * less function compares  two charecters
     *Time complexity is O(n) bcz for loop iterates for l
     *max of length of string
     * @param      v     { String }
     * @param      w     { String }
     * @param      d     { integer type }
     *
     * @return     { returns true if v.charAt(i) < w.charAt(i)
     *               returns false if v.charAt(i) > w.charAt(i) }
     */
    private static boolean less(final String v, final String w, final int d) {
        assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) {
                return true;
            }
            if (v.charAt(i) > w.charAt(i)) {
                return false;
            }
        }
        return v.length() < w.length();
    }
    /**.
     * Determines if sorted.
     *Time complexity is O(n) bcz for loop iterates for length of loop
     * @param      a     { String array }
     *
     * @return     True if sorted, False otherwise.
     */
    private static boolean isSorted(final String[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }
}
