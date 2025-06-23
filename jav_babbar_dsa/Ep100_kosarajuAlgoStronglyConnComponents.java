import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class Ep100_kosarajuAlgoStronglyConnComponents {
    /*
     * Strongly connected component, a connected component inside a graph, where
     * each node can traverse through every node in it.
     */

    /*
     * Kosaraju Algorithm
     * i. Sort all nodes, basis on their finishing time (Topological sort)
     * ii. Transponse graph (reverse edge directions) - Since stack gives
     * topological sort in reverse order
     * iii.Apply DFS and find connected components
     */

    public static void topoOrder(int node, boolean[] visited, Stack<Integer> st, Map<Integer, ArrayList<Integer>> adj) {
        visited[node] = true;

        for (Integer child : adj.getOrDefault(node, new ArrayList<>())) {
            if (!visited[child]) {
                topoOrder(child, visited, st, adj);
            }
        }

        st.push(node);
    }

    public static void dfs(int node, boolean[] visited, Map<Integer, ArrayList<Integer>> adj) {
        visited[node] = true;

        for (Integer child : adj.getOrDefault(node, new ArrayList<>())) {
            if (!visited[child]) {
                dfs(child, visited, adj);
            }
        }
    }

    public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < edges.size(); i++) {
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);
            // Initialize adjacency lists if not present
            adj.putIfAbsent(a, new ArrayList<>());
            adj.putIfAbsent(b, new ArrayList<>());
            adj.get(a).add(b);
        }

        // topological sort
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[v + 1];

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topoOrder(i, visited, st, adj);
            }
        }

        // create a transpose graph
        Map<Integer, ArrayList<Integer>> transpose = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < v; i++) {
            for (Integer child : adj.getOrDefault(i, new ArrayList<>())) {
                transpose.putIfAbsent(i, new ArrayList<>());
                transpose.putIfAbsent(child, new ArrayList<>());

                transpose.get(child).add(i);
            }
        }

        Arrays.fill(visited,false);

        // dfs call using above ordering
        int cnt = 0;
        while (!st.isEmpty()) {
            int top = st.peek();
            st.pop();

            if (!visited[top]) {
                cnt++;
                dfs(top, visited, transpose);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

    }
}
