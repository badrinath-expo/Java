import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;   
import java.util.Scanner;

public class Ep87_kruskal_Algorithm { // Minimum spanning tree
    static int N = (int) 1e5 + 10;

    static int parent[] = new int[N];
    static int size[] = new int[N];
    static Map<Integer, Integer> sizes = new HashMap<>();

    static class Edge {
        int u, v, wt;

        Edge(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static void make(int v) {
        parent[v] = v;
        size[v] = 1;
        sizes.put(1, sizes.getOrDefault(1, 0) + 1);
    }

    static int find(int v) {
        if (v == parent[v])
            return v;

        return parent[v] = find(parent[v]); // path compression, every find run will move the lower level nodes to up
    }

    static void merge(int a, int b) {
        int val = sizes.get(size[a]);

        if (val == 1) {
            sizes.remove(size[a]);
        } else {
            sizes.put(size[a], val--);
        }

        sizes.put(size[a] + size[b], sizes.getOrDefault(size[a] + size[b], 0) + 1);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        // Use size/rank basis to merge, rank -> depth
        if (a != b) {
            if (size[a] < size[b]) { // Union by size
                int temp = a;
                a = b;
                b = temp;
            }

            parent[b] = a;
            size[a] += size[b];
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Edge> edges = new ArrayList<>(); // new PriorityQueue<>(Comparator.comparingInt(a -> a.wt));
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), wt = sc.nextInt();
            edges.add(new Edge(u, v, wt));
        }
        edges.sort((a, b) -> a.wt - b.wt);

        for (int i = 0; i <= n; i++) {
            make(i);
        }

        int total_ct = 0;
        for (Edge edge : edges) {
            int wt = edge.wt;
            int u = edge.u;
            int v = edge.v;

            if (find(u) == find(v))
                continue; // avoiding cycle formation

            union(u, v);
            total_ct += wt;
            System.out.println(u + " " + v);
        }

        System.out.println(total_ct);

    }
}

/*
INPUT:=
6 9
5 4 9
1 4 1
5 1 4
4 3 5
4 2 3
1 2 2
3 2 3
3 6 8
2 6 7

OUTPUT:=
1 4
1 2
3 2
5 1
2 6
17


*/