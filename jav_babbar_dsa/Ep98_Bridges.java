import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;

//Dry run and observe why it works
public class Ep98_Bridges {
    /*
     * Bridge is an edge, if we remove it, it increases the no.of connected components
     */
    /*
     * Disc: when we discovered the node
     * Low: min time to get to the node
     * parent: parent array
     * vis: visited
     */
    /*
     * To check bridge,
     * low[neighbour] > dist[node], which means its the only way no backedge
     */
    public static class Pair<U, V> {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }


    public static void dfs(int node,int parent, AtomicInteger timer,int[] disc,int[] low,boolean[] visited,List<List<Integer>> result, Map<Integer, ArrayList<Integer>> adj){
      
        visited[node] = true;
        disc[node] = low[node]= timer.getAndIncrement();

        for(Integer nbr: adj.getOrDefault(node,new ArrayList<>())){
            if(nbr == parent){
                continue;
            }
            if(!visited[nbr]){
                dfs(nbr, node, timer, disc, low, visited, result, adj);
                   low[node]= Math.min(low[node], low[nbr]);

                   //check edge is bridge
                   if(low[nbr] > disc[node]){ //why??
                         List<Integer> ans = new ArrayList<>();
                         ans.add(node);
                         ans.add(nbr);
                         result.add(ans);
                   }
            }else{
                //back edge
low[node]= Math.min(low[node],disc[nbr]);
            }
        }



    }
        public static List<List<Integer>> findBridges(int[][] edges, int v, int e) {
 Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < edges.length; i++) {
            int a =edges[i][0];
            int b = edges[i][1];
            // Initialize adjacency lists if not present
            adj.putIfAbsent(a, new ArrayList<>());
            adj.putIfAbsent(b, new ArrayList<>());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        AtomicInteger timer = new AtomicInteger(0);
        int disc[] = new int[v];
        int low[] = new int[v];
        int parent = -1;
        boolean[] visited = new boolean[v+1];

        for (int i = 0; i < v; i++) {
            disc[i] = -1;
            low[i] = -1;
        }
        
        List<List<Integer>> result = new ArrayList<>();
        //dfs
        for (int i = 0; i < v; i++) {
            if(!visited[i]){
                dfs(i,parent,timer,disc,low,visited,result,adj);
            }
        }
    return result;

    }
    public static void main(String[] args) {
        
    }
}
