import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Ep82_Dijkstra {
    /*
     * It finds the shortest path from a source node to all other nodes in a
     * weighted graph (no negative weights).
     */
    /*
     * Initially set distances for all nodes to INF, when running BFS,set to the
     * weight if we can minimize it.
     * Smallest weight should be retrieved first while retrieving from queue
     */
    // final static int N = (int) 1e3 + 10;
    // final static int INF = (int) 1e9 + 10;
    // static ArrayList<Edge>[] graph = new ArrayList[N];

    static class Edge {
        int to, wt;

        Edge(int to, int wt) {
            this.to = to;
            this.wt = wt;
        }
    }

    static int dijkstra(int source, int n, ArrayList<Edge>[] graph) {
        final int N = (int) 1e3 + 10;
        final int INF = (int) 1e9 + 10;

        int dist[] = new int[N];
        Arrays.fill(dist, INF);

        boolean vis[] = new boolean[N];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.wt));
      
    
        pq.add(new Edge(source, 0));
        dist[source] = 0;

        while (!pq.isEmpty()) {
            Edge node = pq.peek();
            pq.remove(pq.peek());
            int v = node.to, distance = node.wt;
            if (vis[v])
                continue;

            vis[v] = true;

            for (Edge child : graph[v]) {
                int child_v = child.to;
                int wt = child.wt;

                if (dist[v] + wt < dist[child_v]) {
                    dist[child_v] = dist[v] + wt;
                    pq.add(new Edge(child_v, dist[child_v]));
                }
            }

        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF)
                return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;

    } //O(V+ElogV)

    public static int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] g = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<Edge>();
        }

        for (int[] vec : times) {
            g[vec[0]].add(new Edge(vec[1], vec[2]));
        }
        return dijkstra(k, n, g);
    }

    public static void main(String[] args) {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4, k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }
}
