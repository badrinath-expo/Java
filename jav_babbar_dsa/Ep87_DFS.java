import java.util.*;

public class Ep87_DFS {

    static void dfs(int node, Map<Integer, Boolean> visited, Map<Integer,ArrayList<Integer>> adj, ArrayList<Integer> component){

        component.add(node);
        visited.put(node,true);
        for (Integer child : adj.getOrDefault(node, new ArrayList<>())) {
            if(!visited.getOrDefault(child, false)){
                dfs(child, visited, adj, component);
            }
        }
    }  

    public static ArrayList<ArrayList<Integer>> depthFirstSearch(int v, int e, ArrayList<ArrayList<Integer>> edges) {
      Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

      for (int i = 0; i < edges.size(); i++) {
        int a = edges.get(i).get(0);
        int b = edges.get(i).get(1);

        
        ArrayList<Integer> aChilds = adj.getOrDefault(a, new ArrayList<Integer>()); 
        adj.put(a,aChilds);
        ArrayList<Integer> bChilds = adj.getOrDefault(b, new ArrayList<Integer>());
        adj.put(b,bChilds);
      }


      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

      for (int i = 0; i <=v ; i++) {
        ans.add(new ArrayList<>());
      }


      Map<Integer,Boolean> visited = new HashMap<>();

      for (int i = 0; i < v; i++) {
        if(!visited.getOrDefault(i ,false)){
            ArrayList<Integer> component = new ArrayList<>();
            dfs(i, visited, adj, component);
            ans.add(component);
        }
      }

      return ans;

    }
    public static void main(String[] args) {
        
    }
}
