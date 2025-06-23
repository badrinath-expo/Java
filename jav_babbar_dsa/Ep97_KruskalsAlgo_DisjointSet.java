import java.util.ArrayList;
public class Ep97_KruskalsAlgo_DisjointSet {


    static void makeSet(int parent[], int[] rank, int n){
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int findParent(int[] parent,int node){
        if(parent[node] == node){
            return node;
        }

        return parent[node] = findParent(parent, parent[node]);
    }

    static void UnionSet(int u, int v, int parent[],int rank[]){
       u = findParent(parent, u);
       v = findParent(parent,v);

       if(rank[u] < rank[v]){
            parent[u] = v;
            rank[v]++; //we can also avoid this line
       } else if(rank[v]<rank[u]){
            parent[v]=u;
            rank[u]++; // we can also avoid this line
       }else{
        parent[v]=u; //u or v is fine
        rank[u]++; //u or v is fine
       }

    }
    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
		edges.sort((a,b) -> a.get(2) - b.get(2));
        //Your code goes here
        int[] parent = new int[n];
        int[] rank = new int[n];
        makeSet(parent, rank, n);

        int minWeight = 0;
        for (int i = 0; i <edges.size(); i++) {
            int u = findParent(parent,edges.get(i).get(0));
            int v = findParent(parent,edges.get(i).get(1));
            int wt = edges.get(i).get(2);
       
            if(u!=v){
                minWeight+=wt;
                UnionSet(u,v,parent,rank);
            }
        }
        return minWeight;
	} //O(mlogm) + makeSet&Union (O(4alpha))
//S.C - O(N)
    public static void main(String[] args) {
        
    }
}
