import java.util.ArrayList;
import java.util.Scanner;

public class Ep71_Loop_ConnecedComp {

    static void dfs(ArrayList<Integer> graph[], ArrayList<Integer> connectedComps, boolean vis[], int vertex) {
        vis[vertex] = true;
        connectedComps.add(vertex);
        // Traverse all the children of the vertex
        for (Integer child : graph[vertex]) {
            if (!vis[child])
                dfs(graph, connectedComps, vis, child);
        }
    }

    // Count connected components in a graph using DFS
    static int connectedComponents(ArrayList<Integer> graph[], int n) {
        boolean vis[] = new boolean[n + 10];
        int count = 0;
        ArrayList<Integer> connectedComps[] = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                connectedComps[count] = new ArrayList<>();
                dfs(graph, connectedComps[count], vis, i);
                count++;
            }
        }

        for (ArrayList<Integer> connectedComp : connectedComps) {
            if (connectedComp == null)
                continue; // Skip null lists
            for (Integer vertex : connectedComp) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }

        return count;
    }

    // Cycle detection in undirected graph using DFS
    static boolean isCyclicUtil(ArrayList<Integer> graph[], int vertex, boolean vis[], int parent) {
        vis[vertex] = true;
        boolean isLoopExists = false;
        for (Integer child : graph[vertex]) {
            if (vis[child]) {
                if (child != parent)
                    return true;
                continue;
            }
            isLoopExists |= isCyclicUtil(graph, child, vis, vertex);
        }
        return isLoopExists;
    }


    static void checkLoops(ArrayList<Integer> graph[], int n) {
        boolean vis[] = new boolean[n + 10];
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                if (isCyclicUtil(graph, i, vis, -1)) {
                    System.out.println("Loop exists in the graph");
                    return;
                }
            }
        }
        System.out.println("No loop exists in the graph");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), e = sc.nextInt();
        ArrayList<Integer> graph[] = new ArrayList[n + 10];
        for (int i = 0; i < n + 10; i++) {
            graph[i] = new ArrayList<>();
        }
        // Read the edges of the graph

        while (e > 0) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(v2);
            graph[v2].add(v1);
            e--;
        }

        /*
         * Input:
         * 8 5
         * 1 2
         * 2 3
         * 2 4
         * 3 5
         * 6 7
         */
        System.out.println("connected components: " + connectedComponents(graph, n));
        // Output:
        // connected components: 1 2 3 4 5
        // 6 7
        // 8
        // connected components: 3

        // Cycle detection in undirected graph using DFS
        
    }
}
