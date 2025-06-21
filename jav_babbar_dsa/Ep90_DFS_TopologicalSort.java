import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.ArrayList;

public class Ep90_DFS_TopologicalSort {
    //Topological sort can only be applied to Directed Acyclic Graph
    //It is the linear ordering of vertices such that for every edge u - v, u always appears before v in that ordering
    //we can't get a valid linear ordering from cyclic graph, this case can also used for finding a cycle in graph
    
    //T.C - O(N+E)
//S>C - O(N)  



static void topoSort(int src, boolean[] visited,Stack<Integer> s,Map<Integer, ArrayList<Integer>> adj, int v){
        visited[src] = true;
        for (Integer child : adj.getOrDefault(src, new ArrayList<Integer>())) {
            if(!visited[child]){
            topoSort(child, visited, s, adj,v);
            } 
        }
        s.push(src);
}

    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        // Write your code here.
          // Write your code here.
        Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer,ArrayList<Integer>>();

        for (int i = 0; i < e; i++) {
            int a = edges.get(i).get(0);
            int b = edges.get(i).get(1);

            // Initialize adjacency lists if not present
            adj.putIfAbsent(a, new ArrayList<Integer>());
            adj.putIfAbsent(b, new ArrayList<Integer>());

            adj.get(a).add(b);
        }

        boolean visited[] = new boolean[v+1];
        Stack<Integer> s = new Stack<>();
        //handling disconnected components
        for (int i = 0; i < v; i++) {
            if(!visited[i]){
             topoSort(i, visited,s, adj, v);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!s.empty()) {
            ans.add(s.peek());
            s.pop();
        }
return ans;
    }
     public static void main(String[] args) {
        
    }
}
