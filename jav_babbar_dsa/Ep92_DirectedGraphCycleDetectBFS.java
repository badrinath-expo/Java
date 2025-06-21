public class Ep92_DirectedGraphCycleDetectBFS {
//DAG - gets valid topological sort
//cyclic grah - invalid topological sort

//Find in chatgpt why topological sort works, why
 public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        // Write your code here.
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < e; i++) {
            int a = edges.get(i).get(0) - 1;
            int b = edges.get(i).get(1) - 1;

            // Initialize adjacency lists if not present
            adj.putIfAbsent(a, new ArrayList<Integer>());
            adj.putIfAbsent(b, new ArrayList<Integer>());
            adj.get(a).add(b);
        }

        int indegree[] = new int[v +1];

        for (Integer key : adj.keySet()) {
            for (Integer i : adj.getOrDefault(key, new ArrayList<>())) {
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;

        while (!q.isEmpty()) {

            int front = q.peek();
            q.remove();
            cnt++;

            for (Integer child : adj.getOrDefault(front, new ArrayList<>())) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    q.add(child);
                }
            }
        }
        return cnt !=n; //cnt can only be equal acyclic graph, find why count
    } //T.C - O(N+E)  S.C - O(N+E)
public static void main(String[] args) {
        
    }
}