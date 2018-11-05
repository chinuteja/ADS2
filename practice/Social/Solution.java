import java.util.*;
class Solution {
    Solution() {

    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int vertices = scan.nextInt();
        Digraph digraph = new Digraph(vertices);
        LinearProbingHashST<String, Integer> hs = new LinearProbingHashST<>();
        int i = 0;
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split("follows");
            //String[] tokens1 = tokens.split(",");
            hs.put(tokens[0], i);
            i++;
            // for (int j = 0; j < tokens1.length; j++) {
            //     int x =  hs.get(tokens[j]);
            // }
        }
        

    }
}


