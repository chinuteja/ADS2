/**.
 * Class for tst.
 *
 * @param      <Value>  The value
 */
public class TST<Value> {
    /**.
     * { // size }.
     */
    private int n;
    /**.
     * { // root of TST }.
     */
    private Node<Value> root;
    /**.
     * Class for node.
     *
     * @param      <Value>  The value
     */
    private static class Node<Value> {
        /**.
         * { character}.
         */
        private char c;
        /**.
         * { Node of left, mid , right }.
         */
        private Node<Value> left, mid, right;
        /**.
         * { val of Value type }.
         */
        private Value val;
    }
    /**.
     * Initializes an empty string symbol table.
     */
    public TST() {
    }

    /**.
     * Returns the number of key-value pairs in this symbol table.
     * Time complexity is constant as each statement executes only once.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }
    /**.
     * Does this symbol table contain the given key?.
     * Time complexity is constant as each statement executes only once.
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *     {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(final String key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to contains() is null");
        }
        return get(key) != null;
    }
    /**.
     * Returns the value associated with the given key.
     * Time complexity is L + lnN as it utilises search it where
     * L is length of longest substring
     * @param key the key
     * @return the value associated with given key if the key in symbol table
     *     and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(final String key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "calls get() with null argument");
        }
        if (key.length() == 0) {
            throw new IllegalArgumentException(
                "key must have length >= 1");
        }
        Node<Value> x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.val;
    }
    /**.
     * { this is overloaded get method }.
     *Time complexity is L + lnN as it utilises search it where
     * L is length of longest substring
     * @param      x     { node }
     * @param      key   The key
     * @param      d     { int }
     *
     * @return     { returns node x }
     */
    private Node<Value> get(final Node<Value> x, final String key,
                            final int d) {
        if (x == null) {
            return null;
        }
        if (key.length() == 0) {
            throw new IllegalArgumentException(
                "key must have length >= 1");
        }
        char c = key.charAt(d);
        if (c < x.c) {
            return get(x.left,  key, d);
        } else if (c > x.c) {
            return get(x.right, key, d);
        } else if (d < key.length() - 1) {
            return get(x.mid, key, d + 1);
        } else {
            return x;
        }
    }
    /**.
     * Inserts the key-value pair symbol table, overwriting the old value.
     * with the new value if the key is already in the symbol table.
     * Time complexity is L + lnN as it utilises search  where
     * L is length of longest substring
     * If the value is {@code null}, this effectively deletes the key
     * from the symbol table.
     * @param key the key
     * @param val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(final String key, final Value val) {
        if (key == null) {
            throw new IllegalArgumentException("calls put() with null key");
        }
        if (!contains(key)) {
            n++;
        }
        root = put(root, key, val, 0);
    }
    /**.
     * { over loaded put function }.
     *Time complexity is L + lnN as it utilises search it where
     * L is length of longest substring
     * @param      x     { NOde }
     * @param      key   The key
     * @param      val   The value
     * @param      d     { int type }
     *
     * @return     { returns node }
     */
    private Node<Value> put(final Node<Value> x, final String key,
                            final Value val, final int d) {
        char c = key.charAt(d);
        Node<Value> x1 = x;
        if (x1 == null) {
            x1 = new Node<Value>();
            x1.c = c;
        }
        if (c < x1.c) {
            x1.left  = put(x1.left,  key, val, d);
        } else if (c > x1.c) {
            x1.right = put(x1.right, key, val, d);
        } else if (d < key.length() - 1) {
            x1.mid = put(x1.mid,   key, val, d + 1);
        } else {
            x1.val   = val;
        }
        return x1;
    }
    /**.
     * Returns the string in the symbol table that is the longest.
     * Time complexity is N as while loop iterates till length of
     * query (i.e String)
     * prefix of {@code query},
     * or {@code null}, if no such string.
     * @param query the query string
     * @return the string in the symbol table that is the longest
     * prefix of {@code query},
     *     or {@code null} if no such string
     * @throws IllegalArgumentException if {@code query} is {@code null}
     */
    public String longestPrefixOf(final String query) {
        if (query == null) {
            throw new IllegalArgumentException(
                "calls longestPrefixOf() with null argument");
        }
        if (query.length() == 0) {
            return null;
        }
        int length = 0;
        Node<Value> x = root;
        int i = 0;
        while (x != null && i < query.length()) {
            char c = query.charAt(i);
            if (c < x.c) {
                x = x.left;
            } else if (c > x.c) {
                x = x.right;
            } else {
                i++;
                if (x.val != null) {
                    length = i;
                }
                x = x.mid;
            }
        }
        return query.substring(0, length);
    }
    /**.
     * Returns all keys in the symbol table as an {@code Iterable}.
     * Time complexiy is N as it calls collect method
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     * @return all keys in the symbol table as an {@code Iterable}
     */
    public Iterable<String> keys() {
        Queue<String> queue = new Queue<String>();
        collect(root, new StringBuilder(), queue);
        return queue;
    }
    /**.
     * Returns all of the keys in the set that start with {@code prefix}.
     * Time complexiy is N as it calls collect method
     * @param prefix the prefix
     * @return all of the keys in the set that start with {@code prefix},
     *     as an iterable
     * @throws IllegalArgumentException if {@code prefix} is {@code null}
     */
    public Iterable<String> keysWithPrefix(final String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException(
                "calls keysWithPrefix() with null argument");
        }
        Queue<String> queue = new Queue<String>();
        Node<Value> x = get(root, prefix, 0);
        if (x == null) {
            return queue;
        }
        if (x.val != null) {
            queue.enqueue(prefix);
        }
        collect(x.mid, new StringBuilder(prefix), queue);
        return queue;
    }
    /**
     * { helper function }.
     * time complexity is N as it calls back the collect function recursively
     * @param      x       { node }
     * @param      prefix  The prefix
     * @param      queue   The queue
     */
    private void collect(final Node<Value> x, final StringBuilder prefix,
        final Queue<String> queue) {
        if (x == null) {
            return;
        }
        collect(x.left,  prefix, queue);
        if (x.val != null) {
            queue.enqueue(prefix.toString() + x.c);
        }
        collect(x.mid,   prefix.append(x.c), queue);
        prefix.deleteCharAt(prefix.length() - 1);
        collect(x.right, prefix, queue);
    }
    /**.
     * { helper function }.
     *Time complexiy is N as it calls collect method
     * @param      x        { node }
     * @param      prefix   The prefix
     * @param      i        { int type }
     * @param      pattern  The pattern
     * @param      queue    The queue
     */
    private void collect(final Node<Value> x, final StringBuilder prefix,
        final int i, final String pattern, final Queue<String> queue) {
        if (x == null) {
            return;
        }
        char c = pattern.charAt(i);
        if (c == '.' || c < x.c) {
            collect(x.left, prefix, i, pattern, queue);
        }
        if (c == '.' || c == x.c) {
            if (i == pattern.length() - 1 && x.val != null) {
                queue.enqueue(prefix.toString() + x.c);
            }
            if (i < pattern.length() - 1) {
                collect(x.mid, prefix.append(x.c), i + 1, pattern, queue);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
        if (c == '.' || c > x.c) {
            collect(x.right, prefix, i, pattern, queue);
        }
    }
}
    