// DAG - Direct Acyclic Graph

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class Ep94_ShortestPathInWeightedDAG {
    // Topological sort can be helpful, since we get ordering node what comes first
    public static class Pair<U, V> {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Graph {
        Map<Integer, ArrayList<Pair<Integer, Integer>>> adj = new HashMap<Integer, ArrayList<Pair<Integer, Integer>>>();

        void addEdge(int u, int v, int wt) {
            // Initialize adjacency lists if not present
            adj.putIfAbsent(u, new ArrayList<Pair<Integer, Integer>>());
            adj.putIfAbsent(v, new ArrayList<Pair<Integer, Integer>>());
            adj.get(u).add(new Pair<Integer, Integer>(v, wt));
        }

        void printAdj() {
            for (Integer key : adj.keySet()) {
                System.out.print(key + " -> ");
                for (Pair<Integer, Integer> p : adj.getOrDefault(key, new ArrayList<>())) {
                    System.out.print("{" + p.first + "," + p.second + "}");

                }
                System.out.println();
            }
        }

        void dfs(int src, boolean[] visited, Stack<Integer> s) {
            visited[src] = true;
            for (Pair<Integer, Integer> child : adj.getOrDefault(src, new ArrayList<Pair<Integer, Integer>>())) {
                if (!visited[child.first]) {
                    dfs(child.first, visited, s);
                }
            }
            s.add(src);
        }

        void getShortestPath(int src, int[] dist, Stack<Integer> topo) {
            dist[src] = 0;

            while (!topo.isEmpty()) {
                int top = topo.peek();
                topo.pop();

                if (dist[top] != Integer.MAX_VALUE) {
                    for (Pair<Integer, Integer> child : adj.getOrDefault(top,
                            new ArrayList<Pair<Integer, Integer>>())) {
                        if (dist[top] + child.second < dist[child.first]) {
                            dist[child.first] = dist[top] + child.second;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 2, 2);
        g.addEdge(1, 3, 6);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);

        g.printAdj();

        int n = 6;

        boolean[] visited = new boolean[n + 1];
        Stack<Integer> s = new Stack<Integer>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                g.dfs(i, visited, s);
            }
        }
        // System.out.println("printing stack: " + s.isEmpty());
        // while (!s.empty()) {
        // System.out.print(s.peek() +" ");
        // s.pop();
        // }
        // System.out.println();

        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        g.getShortestPath(1, dist, s);
 
        System.out.println("print ans");

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    } //T.C = O(N+E) S.C - O(N+E)
}
