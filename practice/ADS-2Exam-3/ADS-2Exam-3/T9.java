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
		//tst.keysWithPrefix(words);
		MaxPQ<String> maxpq = new MaxPQ<>();
		for (String key : words) {
			int count = 0;
			String tokens = key;
			for (String word : tst.keysWithPrefix(tokens)) {
				maxpq.insert(word);
				count ++;
			}
		}
		return null;
		// for (int i = 0; i < 5; i++)
		// 	return maxpq.delMax();
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(String t9Signature, int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}
