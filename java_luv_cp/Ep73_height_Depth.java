import java.util.ArrayList;
import java.util.Scanner;

public class Ep73_height_Depth {

    static void computeDepth(ArrayList<Integer>[] graph, int[] depth, int[] height, int vertex, int par) {

        for (Integer child : graph[vertex]) {
            if (child != par) {
                depth[child] = depth[vertex] + 1;
                computeDepth(graph, depth, height, child, vertex);
                height[vertex] = Math.max(height[vertex], height[child] + 1);
            }
        }
    }

    static void print(int arr[], int str) {
        System.out.print(str);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // n = number of vertices, e = number of edges
        // Create an adjacency list for the graph
        ArrayList<Integer> graph[] = new ArrayList[n + 2];
        for (int i = 0; i < n + 2; i++) {
            graph[i] = new ArrayList<>();
        }

        // Read the edges of the graph, mentioned n-1 edges
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u); // For undirected graph
        }

        int depth[] = new int[n + 1];
        int height[] = new int[n + 1];

        computeDepth(graph, depth, height, 1, 0);
        print(height, n);
        print(depth, n);

    }
}
