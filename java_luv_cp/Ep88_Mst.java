import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ep88_Mst {
    static int N = (int) 2e3 + 10;

    static int parent[] = new int[N];
    static int size[] = new int[N];

    static class City {
        int u, v;

        long wt;

        City(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    static class Edge {
        int u, v;

        long wt;

        Edge(int u, int v, long wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }

    static void make(int v) {
        parent[v] = v;
        size[v] = 1;
    }

    static int find(int v) {
        if (v == parent[v])
            return v;

        return parent[v] = find(parent[v]); // path compression, every find run will move the lower level nodes to up
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
        // ArrayList<City> cities = new ArrayList<>();

        City[] cities = new City[N + 1];

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            cities[i] = new City(u, v);
            // cities.add(new City(u, v));
        }

        int c[] = new int[n + 1];
        int k[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            c[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            k[i] = sc.nextInt();
        }

        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            edges.add(new Edge(0, i, c[i])); // cost of node to 0 th node as an edge
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int dist = Math.abs(cities[i].u - cities[j].u) + Math.abs(cities[i].v - cities[j].v);

                long cost = dist * 1L * (k[i] + k[j]);

                edges.add(new Edge(i, j, cost));
            }
        }

        edges.sort((a, b) -> (int) (a.wt - b.wt));

        for (int i = 1; i <= n; i++) {
            make(i);
        }

        long total_ct = 0;
        List<Integer> power_stations = new ArrayList<>();
        List<City> connections = new ArrayList<>();
        for (Edge edge : edges) {
            long wt = edge.wt;
            int u = edge.u;
            int v = edge.v;

            if (find(u) == find(v))
                continue; // avoiding cycle formation

            union(u, v);
            total_ct += wt;

            if (u == 0 || v == 0)
                power_stations.add(Math.max(u, v)); //non-zero node
            else
                connections.add(new City(u, v));
            // System.out.println(u + " " + v);
        }

        System.out.println(total_ct);
        System.out.println(power_stations.size());
        for (int station : power_stations) {
            System.out.print(station + " ");
        }
        System.out.println();
        System.out.println(connections.size());
        for (City connection : connections) {
            System.out.println(connection.u + " " + connection.v);
        }
        System.out.println();
    }
}

/*
 * 
 * //Input:=
 * 3
 * 2 3
 * 1 1
 * 3 2
 * 3 2 3
 * 3 2 3
 * 
 * 
 * 
 * 0 2
 * 0 1
 * 0 3
 * 
 * //Output:
 * 8
 * 3
 * 2 1 3
 * 0
 */