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
            for (String str1 : chars) {
                if (str1.equals("a") || str1.equals("b") || str1.equals("c")) {
                    str = str + 2;
                }
                if (str1.equals("d") || str1.equals("e") || str1.equals("f")) {
                    str = str + 3;
                }
                if (str1.equals("g") || str1.equals("h") || str1.equals("i")) {
                    str = str + 4;
                }
                if (str1.equals("j") || str1.equals("k") || str1.equals("l")) {
                    str = str + 5;
                }
                if (str1.equals("m") || str1.equals("n") || str1.equals("o")) {
                    str = str + 6;
                }
                if (str1.equals("p") || str1.equals("q") || str1.equals("r") || str1.equals("s")) {
                    str = str + 7;
                }
                if (str1.equals("t") || str1.equals("u") || str1.equals("v")) {
                    str = str + 8;
                }
                if (str1.equals("w") || str1.equals("x") || str1.equals("y") || str1.equals("z")) {
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
        MaxPQ<Integer> maxpq = new MaxPQ<Integer>();
        for (String i : words) {
            int x = tst.get(i);
            maxpq.insert(x);
        }
        for (int i = 0; i < k; i++) {
            int maxval = maxpq.delMax();
            for (String word : words) {
                if (maxval == tst.get(word)) {
                    list.add(word);
                }
            }
        }
        //Collections.sort(list);
        return list;
    }
    // final output
    // Don't modify this method.
    public Iterable<String> t9(String t9Signature, int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}
