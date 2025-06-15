import java.util.ArrayList;
import java.util.Scanner;

public class Ep70_DFS {

    static void dfs(ArrayList<Integer> g[], Integer vertex, boolean vis[]) {
        /* Take action on vertex after entering the vertex */
        System.out.println(vertex);
        vis[vertex] = true;
        for (Integer child : g[vertex]) {
            System.out.println("parent: " + vertex + " child:" + child);
            /* Take action on child before entering the child node */
            if (!vis[child]) {   
                dfs(g, child, vis);
                /* Take action on child after exiting child node */
            }
        }
         /*Take action on child before  exiting child node   */
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() + 1, m = sc.nextInt();
        ArrayList<Integer> g[] = new ArrayList[n + 1];
        for (int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt(), v2 = sc.nextInt();
            g[v1].add(v2);
            g[v2].add(v1);
        }

        boolean vis[] = new boolean[n];
        dfs(g, 1, vis);

    }
}