import java.util.Arrays;
import java.util.List;

public class Ep101_BellmanFordAlgo {
    /*
     * Dijkstra can't work on -ve weights
     * (Directed graphs)Bellman ford Algorithm works on -ve weights, but doesn't works on -ve weighted cycles
     * Using Bellman Ford Algorithm, we can find -ve weighted cycles
     */

     /*
      * To apply Bellman ford to directed graphs, create both directional nodes
      */

      /* Bellman Ford Algorithm steps:
       * i. Apply n-1 times
       * if(dist[u] + wt < dist[v]){
       * dist[v] = dist[u] + wt;
       * }
       * 
       * ii. Apply same formula 1 more time
       * if dist update, it means -ve cycle exists
       */

        public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        // Write your code here.

        int dist[] = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 1; i <= n; i++) {
           for (int j = 0; j < m; j++) {
            int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int wt = edges.get(j).get(2);

            if(dist[u]!=Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                dist[v] = dist[u] + wt;
            }
           } 
        }

        //check for -ve cycles

        boolean flag = false;

for (int j = 0; j < m ;j++) {
    int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int wt = edges.get(j).get(2);

            if(dist[u]!=Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                flag = true;
            }
}

// if(!flag){
// return dist[dest]; //distance of destination
// }

// return -1;

return dist;
        
    } //Dry run with the failed test cases, we can find where it is failing
    public static void main(String[] args) {
        
    }
}
