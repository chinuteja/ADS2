/**.
 * imports iterator packagae
 */
import java.util.Iterator;
/**.
 * imports nosuchelementexception
 */
import java.util.NoSuchElementException;
/**.
 * Class for bag.
 *
 * @param      <Item>  The item
 */
public class Bag<Item> implements Iterable<Item> {
    /**.
     * number of elements in bag
     */
    private int N;
    /**.
     * beginning of bag
     */
    private Node first;
    /**.
     * Class for node.
     */
    private class Node {
        /**.
         * item of type item
         */
        private Item item;
        /**.
         * next of NOde type
         */
        private Node next;
    }

    /**.
      * Create an empty stack.
      */
    public Bag() {
        first = null;
        N = 0;
    }

    /**.
      * Is the BAG empty?
      * Time complesxity is constant as each statement is executed only once
      * @return is boolean type
      */
    public boolean isEmpty() {
        return first == null;
    }

    /**.
      * Return the number of items in the bag.
      * Time complesxity is constant as each statement is executed only once
      * @return returns size of bag of int type
      */
    public int size() {
        return N;
    }
    /**.
      * Add the item to the bag.
      * Time complesxity is constant as each statement is executed only once
      *@param Item
      */
    public void add(final Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    /**.
      * Return an iterator that iterates over the items in the bag.
      * @return Listiterator
      */
    public Iterator<Item> iterator()  {
        return new ListIterator();
    }
    /**.
     * Class for list iterator.
     */
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  {
            return current != null;
        }
        public void remove()      { 
            throw new UnsupportedOperationException();  
        }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
