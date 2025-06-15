import java.util.ArrayList;
import java.util.Scanner;

public class Ep76_LCA {

    static void dfs(ArrayList<Integer>[] graph, int vertex, int parent, int[] parents) {
        // parents[vertex] = parent;
        for (Integer child : graph[vertex]) {
            if (child != parent) {
                parents[child] = vertex;
                dfs(graph, child, vertex, parents);
            }
        }
    }

    static int findLCA(int v1, int v2, int[] parents) {
        int lca = -1;
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        while (v1 != 0) {
            path1.add(v1);
            v1 = parents[v1];
        }
        while (v2 != 0) {
            path2.add(v2);
            v2 = parents[v2];
        }

        path1.sort((a, b) -> a - b);
        path2.sort((a, b) -> a - b);

        System.out.println("paths: ");
        for (Integer p : path1) {
            System.out.print(p + " ");
        }
        System.out.println();
        System.out.println("paths: ");
        for (Integer p : path2) {
            System.out.print(p + " ");
        }
        System.out.println();

        int i = 0;
        int j = 0;

        while (i < path1.size() && j < path2.size()) {
            if (path1.get(i) == path2.get(j)) {
                lca = path1.get(i);
            } else {
                break;
            }
            i++;
            j++;
        }

        return lca;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 10];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            System.out.println("reading x: reading y:");
            int x = sc.nextInt(), y = sc.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }

        int parents[] = new int[n + 1];

        dfs(graph, 1, 0, parents);

        for (int i = 0; i < parents.length; i++) {
            System.out.print(parents[i] + " ");
        }
        System.out.println();
        int lca = findLCA(6, 7, parents);

        System.out.println(lca);
    }
}

/*
 * 
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
 */