import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class Ep89_cycleDetectInDirectedGraphs {
  
   static boolean isCyclicDFS(int src, boolean visited[], boolean[] dfsVisited  ,Map<Integer, ArrayList<Integer>> adj,int n){
        visited[src] = true;
    dfsVisited[src] = true;
        for (Integer child : adj.getOrDefault(src, new ArrayList<Integer>())) {
            if(!visited[child]){
               return isCyclicDFS(child, visited, dfsVisited, adj, n);
            } else if(dfsVisited[child]){
                return true;
            }  
        }
        dfsVisited[src] = false;
        return false;
    }
  
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
    // Write your code here.
          // Write your code here.
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer,ArrayList<Integer>>();

        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);

            // Initialize adjacency lists if not present
            adj.putIfAbsent(u, new ArrayList<Integer>());
            adj.putIfAbsent(v, new ArrayList<Integer>());

            adj.get(u).add(v);
        }

        boolean visited[] = new boolean[n+1];
        boolean dfsVisited[] = new boolean[n+1];
        //handling disconnected components
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
             if(isCyclicDFS(i, visited, dfsVisited, adj, n)){
                return true;
             }
            }
        }
        return false;
  }  //fixed 
 
    public static void main(String[] args) {
        
    }
}
