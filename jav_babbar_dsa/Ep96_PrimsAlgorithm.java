import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class Ep96_PrimsAlgorithm {
    //Understand the concept: watch some other video
    /**
     * Spanning Tree: convert a graph into tree such that n nodes & n-1 edges.
     * Remember Tree has no cycles
     */
    public static class Pair<U, V> {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        Map<Integer, ArrayList<Pair<Integer, Integer>>> adj = new HashMap<Integer, ArrayList<Pair<Integer, Integer>>>();
        for (int i = 0; i < g.size(); i++) {
            int u = g.get(i).get(0);
            int v = g.get(i).get(1);
            int w = g.get(i).get(2);
            // Initialize adjacency lists if not present
            adj.putIfAbsent(u, new ArrayList<Pair<Integer, Integer>>());
            adj.putIfAbsent(v, new ArrayList<Pair<Integer, Integer>>());
            adj.get(u).add(new Pair<Integer, Integer>(v, w));
            adj.get(v).add(new Pair<Integer, Integer>(u, w));
        }

        int key[] = new int[n+1];
        boolean[] mst = new boolean[n+1];
        int parent[] = new int[n+1];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mst, false);
        Arrays.fill(parent, -1);

        key[1] = 0;
        parent[1] = -1;

        for (int i = 1; i < n; i++) {
            int mini = Integer.MAX_VALUE;
            int u =-1;
            //find min value node
            for (int v = 1; v <=n; v++) {
                if(mst[v] == false && key[v] < mini){
                    u = v;
                    mini = key[v];
                }
            }

            //mark mst as true
            mst[u] = true;

            //check its adjacent nodes
            for(Pair<Integer,Integer> it: adj.getOrDefault(u, new ArrayList<>())){
                int v = it.first;
                int w = it.second;

                if(mst[v]==false && w<key[v]){
                    parent[v] = u;
                    key[v]=w;
                }
            }
        }


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//why 2, since 1's parent is -1
        for (int i = 2; i <= n; i++) {
           ArrayList<Integer> tmp = new ArrayList<>();
           tmp.add(parent[i]);
           tmp.add(i);
           tmp.add(key[i]);

           result.add(tmp);
        }

        return result;
    }
    public static void main(String[] args) {
        
    }
}
