import java.util.Scanner;

public class Ep86_city_FloodDSU {

    static int N = (int) 1e5 + 10;

    static int parent[] = new int[N];
    static int size[] = new int[N];

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
        int n = sc.nextInt(), k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            make(i);
        }
        while (k > 0) {
            int u = sc.nextInt(), v = sc.nextInt();
            union(u, v);
            k--;
        }

        int connected_ct = 0;
        for (int i = 1; i <= n; i++) {
            if (find(i) == i) { // if the parent of i is i, then it's a root node of the component
                connected_ct++;
            }
        }

        System.out.println(connected_ct);
    }
}
