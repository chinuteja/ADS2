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
        ArrayList<String> list = new ArrayList<String>();
        for(String word : tst.keys()) {
            String[] chars = word.split("");
            String str = "";
            for (String ch : chars) {
                if (ch.equals("a") || ch.equals("b") || ch.equals("c")) {
                    str = str + 2;
                }
                if (ch.equals("d") || ch.equals("e") || ch.equals("f")) {
                    str = str + 3;
                }
                if (ch.equals("g") || ch.equals("h") || ch.equals("i")) {
                    str = str + 4;
                }
                if (ch.equals("j") || ch.equals("k") || ch.equals("l")) {
                    str = str + 5;
                }
                if (ch.equals("m") || ch.equals("n") || ch.equals("o")) {
                    str = str + 6;
                }
                if (ch.equals("p") || ch.equals("q") || ch.equals("r") || ch.equals("s")) {
                    str = str + 7;
                }
                if (ch.equals("t") || ch.equals("u") || ch.equals("v")) {
                    str = str + 8;
                }
                if (ch.equals("w") || ch.equals("x") || ch.equals("y") || ch.equals("z")) {
                    str = str + 9;
                }
            }
            if (str.equals(t9Signature)) {
                if (tst.contains(word)) {
                    list.add(word);
                }
            }
        }
        return list;

        //return null;
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
