import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ep85_Graphs {

    static class Graph {
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

        void addEdge(int u, int v, boolean direction) {
            // direction = 0 -- undirected
            // direction=1 -- directed

            if (adj.get(u) != null) {
                adj.get(u).add(v);
            } else {
                ArrayList<Integer> x = new ArrayList<>();
                x.add(v);
                adj.put(u, x);
            }

            if (!direction) {

                if (adj.get(v) != null) {
                    adj.get(v).add(u);
                } else {
                    ArrayList<Integer> x = new ArrayList<>();
                    x.add(u);
                    adj.put(v, x);
                }

            }
        }

        void printAdjList() {
            for (Integer i : adj.keySet()) {
                System.out.print(i + " ");
                for (Integer j : adj.get(i)) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph g = new Graph();
        System.out.println("enter no.of nodes");
        int n = sc.nextInt();

        System.out.println("enter no.of edges");
        int m = sc.nextInt();

        while (m > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v, false);
            m--;
        }

        g.printAdjList();
    }
}

/*
 * Node -> an entity to store data
 * edge -> connection b/w nodes
 * Undirected Graph
 * Degree(node) - no.of edges connected to it
 * 
 * Directed
 * InDegree(node) - no. of edges getting inwards
 * OutDegree(node) - no. of edges going outwards
 * 
 * Acyclic graph - no cycle exists
 */