import java.util.ArrayList;
import java.util.Scanner;

//InterviewBit Delete Edge
public class Ep77_EdgeDeletion {

    static void dfs(ArrayList<Integer>[] graph, int vertex, int parent, int[] subtree_sum, int[] val) {

        subtree_sum[vertex] += val[vertex];
        for (int child : graph[vertex]) {
            if (child != parent) {
                dfs(graph, child, vertex, subtree_sum, val);
                subtree_sum[vertex] += subtree_sum[child];
            }
        }
    }

    public int deleteEdge(int[] A, int[][] B) {
        int n = A.length;
        ArrayList<Integer> graph[] = new ArrayList[n + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : B) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);

        }

        int subtree_sum[] = new int[n + 1];
        dfs(graph, 1, 0, subtree_sum, A);

        long ans = 0;

        int M = (int) 1e9 + 7;

        for (int i = 2; i <= n; i++) {
            long part1 = subtree_sum[i];
            long part2 = subtree_sum[1] - part1;
            ans = Math.max(ans, (part1 * part2));
        }
        return (int) (ans % M);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer> graph[] = new ArrayList[n + 1];
        int val[] = new int[n + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         * for (int i = 0; i < n - 1; i++) {
         * int x = sc.nextInt(), y = sc.nextInt();
         * 
         * graph[x].add(y);
         * graph[y].add(x);
         * }
         * 
         * int subtree_sum[] = new int[n + 1];
         * dfs(graph, 1, 0, subtree_sum, val);
         * 
         * long ans = 0;
         * 
         * int M = (int) 1e9+7;
         * 
         * for (int i = 2; i <=n; i++) {
         * int part1 = subtree_sum[i];
         * int part2 = subtree_sum[1] - part1;
         * ans = Math.max(ans ,(part1* part2)% M) ;
         * }
         * System.out.println(ans);
         */

    }
}
