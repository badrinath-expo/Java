import java.util.ArrayList;
import java.util.Scanner;

public class EP74_PreCompueDFS {
    /*
     * *Given Q Queries,Q<=10^5
     * In each query given V,
     * Print subtree sum of V &
     * Number of even numbers in subtree V
     * 
     */
    // In problems we get different value for each vertex in a tree,But now we are
    // considering the "vertex as the value"
    // In problems we get different value for each vertex in a tree,But now we are
    // considering the "vertex as the value"
    // Unoptimized way : considering running dfs on every vertex asked in the query
    // to find, better way is to precompute.
    static void dfs(ArrayList<Integer>[] graph, int vertex, int par, int[] subtree_sum, int[] even_count) {
        // Take action on vertex after entering the vertex
        // going down section

        if (vertex % 2 == 0) {
            even_count[vertex]++;
        }
        subtree_sum[vertex] += vertex; // initially at vertex position in subtree_sum,we added that vertex
        for (int child : graph[vertex]) {

            // Take action on child before entering the child node
            // going down section
            // subtree_sum[vertex]+=val[vertex]; // if value of a vertex is given

            if (child == par)
                continue;

            dfs(graph, child, vertex, subtree_sum, even_count);
            // Take action on child after exiting child node
            // going up section
            subtree_sum[vertex] += subtree_sum[child];
            even_count[vertex] += even_count[child];
        }
        // Take action on child before exiting child node
        // going up section
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> graph[] = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) // In trees n nodes n-1 edges
        {
            int x = sc.nextInt(), y = sc.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }

        int subtree_sum[] = new int[n + 1];
        int even_count[] = new int[n + 1];
        dfs(graph, 1, 0, subtree_sum, even_count);

        for (int i = 1; i <= n; i++) {
            System.out.print(subtree_sum[i] + " " + even_count[i]);
        }
    }
}

// refer notes to watch tree

/*
 * INPUT:==
 * 13
 * 1 2
 * 1 3
 * 1 13
 * 2 5
 * 3 4
 * 5 6
 * 5 7
 * 5 8
 * 8 12
 * 4 9
 * 4 10
 * 10 11
 * 
 * OUTPUT:==
 * 91 6
 * 40 4
 * 37 2
 * 34 2
 * 38 3
 * 6 1
 * 7 0
 * 20 2
 * 9 0
 * 21 1
 * 11 0
 * 12 1
 * 13 0
 * 
 * 
 */