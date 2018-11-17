import java.util.*;
class T9 {
    TST<Integer> tst;
    public T9(BinarySearchST<String, Integer> st) {
        // your code goes here
        tst = new TST<Integer>();
        for (int i = 0; i < st.size(); i++) {
            String temp = st.select(i);
            tst.put(temp, i);
        }

    }

    // get all the prefixes that match with given prefix.
    public Iterable<String> getAllWords(String prefix) {
        // your code goes here
        return tst.keysWithPrefix(prefix);
        //return null;
    }

    public Iterable<String> potentialWords(String t9Signature) {
        // your code goes here

        return null;
    }

    // return all possibilities(words), find top k with highest frequency.
    public Iterable<String> getSuggestions(Iterable<String> words, int k) {
       ArrayList<String> list = new ArrayList<String>();
        MaxPQ<Integer> pq = new MaxPQ<Integer>();
        for (String i : words) {
            pq.insert(tst.get(i));
        }
        for (int i = 0; i < k; i++) {
            int maxval = pq.delMax();
            for (String word : words) {
                if (maxval == tst.get(word)) {
                    list.add(word);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
        //return maxpq;
    
    // final output
    // Don't modify this method.
    // ArrayList<String> list = new ArrayList<String>();
        

    public Iterable<String> t9(String t9Signature, int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}
