public class Ep91_TopSortKhansAlgo {
    // Find indegree of all nodes
    // queue - 0 indegree nodes insert
       public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) {

        // Write your code here.
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 0; i < e; i++) {
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);

            // Initialize adjacency lists if not present
            adj.putIfAbsent(a, new ArrayList<Integer>());
            adj.putIfAbsent(b, new ArrayList<Integer>());

            adj.get(a).add(b);
        }

        boolean visited[] = new boolean[v + 1];

        int indegree[] = new int[v + 1];

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

        ArrayList<Integer> ans = new ArrayList<Integer>();

        while (!q.isEmpty()) {

            int front = q.peek();
            q.remove();
            ans.add(front);
            for (Integer child : adj.getOrDefault(front, new ArrayList<>())) {
                indegree[child]--;
                if (indegree[child] == 0) {
                    q.add(child);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /*
         * 
         * Understand the concept from chatgpt
         */
    }
}