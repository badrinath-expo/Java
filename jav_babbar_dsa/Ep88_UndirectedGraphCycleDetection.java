import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Ep88_UndirectedGraphCycleDetection {


    static boolean isCyclicBFS(int src,boolean visited[]  ,Map<Integer, ArrayList<Integer>> adj,int n){
       int parent[] = new int[n+1];
     Queue<Integer> q = new LinkedList<>();
       parent[src] = -1;
       visited[src] = true;
        q.add(src);

        while (!q.isEmpty()) {
            int frontNode = q.peek();
            q.remove();
            for (Integer child : adj.getOrDefault(frontNode, new ArrayList<>())) {
                if(visited[child] && child!=parent[frontNode]){
                    return true;
                }else if (!visited[child]) { 
                    q.add(child);
                    visited[child] = true;
                    parent[child] = frontNode;
                }
            }
        }
        return false;
    }

    static boolean isCyclicDFS(int src,int parent, boolean visited[]  ,Map<Integer, ArrayList<Integer>> adj,int n){
        visited[src] = true;

        for (Integer child : adj.getOrDefault(src, new ArrayList<Integer>())) {
            if(!visited[child]){
               return isCyclicDFS(child, src, visited, adj, n);
            } else if(child!=parent){
                return true;
            }  
        }
        return false;
    } //Fix the failing cases in coding ninjas for DFS solution

    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer,ArrayList<Integer>>();

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            // Initialize adjacency lists if not present
            adj.putIfAbsent(u, new ArrayList<Integer>());
            adj.putIfAbsent(v, new ArrayList<Integer>());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean visited[] = new boolean[n+1];

        //handling disconnected components
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
             if(isCyclicBFS(i, visited, adj, n)){
                return "Yes";
             }
            }
        }

        return "NO";

    }
    public static void main(String[] args) {
        
    }
}
