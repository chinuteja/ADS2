import java.util.Scanner;
class Soluiton {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int vertices = scan.nextInt();
        int edges = scan.nextInt();
        scan.nextLine();
        Digraph digraph = new Digraph(vertices);
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(" ");
            digraph.addEdge(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]));
        }
        DirectedCycle directedcycle = new DirectedCycle(digraph);
        if(directedcycle.hasCycle()) {
            System.out.println("Cycle exists");
        }
        else {
            System.out.println("Cycle doesn't exists");
        }
    }
}