import java.util.ArrayList;
import java.util.Scanner;

public class Ep69_TreeRepresentation {

    static void adjacencyMatrix() {
        // Adjacency Matrix
        final int N = 3;
        int graph[][] = new int[N][N];

        for (int ar[] : graph) {
            for (int i : ar) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1][v2] = graph[v2][v1] = 1;
        }
    }

    static void adjacencyList() {
        Scanner sc = new Scanner(System.in);
        final int n = 3;
        ArrayList<Integer> graph[] = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        int m = sc.nextInt();

        while (m > 0) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(v2);
            graph[v2].add(v1);
            m--;
        }

        for (ArrayList<Integer> g : graph) {
            for (Integer x : g) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    static class Edge {
        int dest;
        int wt;

        public Edge(int dest, int wt) {
            this.dest = dest;
            this.wt = wt;
        }

    }

    static void adjacencyListWithWeights() {
        try (Scanner sc = new Scanner(System.in)) {
            final int n = sc.nextInt();
            sc.nextLine();
            ArrayList<Edge> graph[] = new ArrayList[n+1];
            for (int i = 0; i < graph.length; i++) {
                graph[i] = (new ArrayList<>());
            }

            int m = sc.nextInt();
            sc.nextLine();
            while (m > 0) {
                int v1 = sc.nextInt();
                sc.nextLine();
                int v2 = sc.nextInt();
                sc.nextLine();
                int wt = sc.nextInt();
                sc.nextLine();

                Edge edge1 = new Edge(v2, wt);
                graph[v1].add(edge1);

                Edge edge2 = new Edge(v1, wt);
                graph[v2].add(edge2);

                m--;
            }
  

        for (int i = 0; i < graph.length; i++) {
            for (Edge edge : graph[i]) {
                System.out.println("v1 : " + i + " v2: " + edge.dest + " wt: " + edge.wt);
            }
        }
    }
    }

    public static void main(String[] args) {
        // adjacencyList();
        adjacencyListWithWeights();
    }
}
