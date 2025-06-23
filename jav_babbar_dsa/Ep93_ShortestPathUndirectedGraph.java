import java.util.LinkedList;
import java.util.*;
import java.util.ArrayList;

public class Ep93_ShortestPathUndirectedGraph {

    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
        // Write your code here.
        // Write your code here.
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            // Initialize adjacency lists if not present
            adj.putIfAbsent(a, new ArrayList<Integer>());
            adj.putIfAbsent(b, new ArrayList<Integer>());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean visited[] = new boolean[n + 1];
        int parent[] = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        parent[s] = -1;
        visited[s] = true;
        while (!q.isEmpty()) {
            int front = q.peek();
            q.remove();

            for (Integer child : adj.getOrDefault(front, new ArrayList<>())) {
                if (!visited[child]) {
                    q.add(child);
                    visited[child] = true;
                    parent[child] = front;
                }
            }
        }


        LinkedList<Integer> ans = new LinkedList<Integer>();
    
          int currentNode = t;
          ans.add(t);

          while (currentNode!=s) {
            currentNode = parent[currentNode];
            ans.add(currentNode);
          }


          Collections.reverse(ans);
          return ans;
    } //O(N+E)

    public static void main(String[] args) {

    }
}