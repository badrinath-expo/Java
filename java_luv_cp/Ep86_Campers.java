import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Ep86_Campers {

    static int N = (int) 1e5 + 10;

    static int parent[] = new int[N];
    static int size[] = new int[N];
    static Map<Integer, Integer> sizes = new HashMap<>();

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

        int n = sc.nextInt(), q = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            make(i);
        }

        while (q > 0) {
            q--;
            int u = sc.nextInt(), v = sc.nextInt();
            union(u, v);
            if (sizes.size() == 1) {
                System.out.println(0);
            } else {
                /**
                 * haven't completed due to multiset not found in java
                 */

            }
        }
    }
}
