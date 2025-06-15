import java.util.ArrayList;
import java.util.Scanner;

public class EP75_Tree_Diameter {
    /*
     * 1. With any root, find max depth node. There is a proof that this node will
     * be one end of the diameter.
     * 2. With that node as root, find max depth
     */
    static void dfs(ArrayList<Integer>[] graph, int vertex, int par, int[] depth) {
        for (int child : graph[vertex]) {
            if (child != par) {
                depth[child] = depth[vertex] + 1;
                dfs(graph, child, vertex, depth);
            }
        }
    }

    static void print(int[] depth){
        System.out.println("depths: ");
        for (int i : depth) {
            System.out.print(i + " ");
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
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        int depth[] = new int[n + 1];

        dfs(graph, 1, 0, depth);
        print(depth);

        int maxDepth = depth[1];
        int maxDepthNode = 1;
        for (int i = 2; i < depth.length; i++) {
            if (depth[i] >= maxDepth) {
                maxDepth = depth[i];
                maxDepthNode = i;
            }
        }
        depth = new int[n + 1];

        dfs(graph, maxDepthNode, 0, depth);
        maxDepth = -1;
        print(depth);
        for (int i : depth) {
            maxDepth = Math.max(i, maxDepth);
        }

        System.out.println(maxDepth);

    }
}

/* 
13
1 2
1 3
1 13
2 5
3 4
5 6
5 7
5 8
8 12
4 9
4 10
10 11

OUTPUT = 8
 */