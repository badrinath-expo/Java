import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ep78_BFS {

    static void bfs(ArrayList<Integer>[] graph, int n, boolean[] vis, int root, int[] level) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(root);
        vis[root] = true;
        while (!q.isEmpty()) {
            int currNode = q.peek();
            q.remove();
            System.out.print(currNode + " ");
            for (int child : graph[currNode]) {
                if (!vis[child]) {
                    q.add(child);
                    vis[child] = true;
                    level[child] = level[currNode] + 1;
                }
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }
        boolean[] vis = new boolean[n + 1];
        int level[] = new int[n + 1];
        bfs(graph, n, vis, 1, level); // V nodes , E edges  O(V + E)

        for (int i = 1; i < level.length; i++) {
            System.out.print(level[i] + " ");
        }
        System.out.println();
    }
}

/*
 * 
13
1 2
1 3
1 13
2 5
5 6
5 7
5 8
8 12
3 4
4 9
4 10
10 11
 */