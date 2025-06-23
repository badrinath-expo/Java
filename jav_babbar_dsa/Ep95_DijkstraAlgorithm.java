import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;

public class Ep95_DijkstraAlgorithm {

    public static class Pair<U, V> {
        public final U first;
        public final V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    	public static ArrayList < Integer > dijkstra(ArrayList< ArrayList < Integer > > vec, int vertices, int edges, int source){
		// Write your code here.
        // Write your code here.

        Map<Integer, ArrayList<Pair<Integer, Integer>>> adj = new HashMap<Integer, ArrayList<Pair<Integer, Integer>>>();

        for (int i = 0; i < vertices; i++) {

            int u = vec.get(i).get(0);

            int v = vec.get(i).get(1);

            int w = vec.get(i).get(2);

            // Initialize adjacency lists if not present

            adj.putIfAbsent(u, new ArrayList<Pair<Integer, Integer>>());

            adj.putIfAbsent(v, new ArrayList<Pair<Integer, Integer>>());

            adj.get(u).add(new Pair<Integer, Integer>(v, w));

            adj.get(v).add(new Pair<Integer, Integer>(u, w));
        }

            int dist[] = new int[vertices];

            Arrays.fill(dist, Integer.MAX_VALUE);

            Set<Pair<Integer, Integer>> st = new HashSet<>();

            dist[source] = 0;

            st.add(new Pair<>(0, source));

            Iterator<Pair<Integer, Integer>> iterator = st.iterator();

            while (!st.isEmpty()) {

                if (iterator.hasNext()) {

                    Pair<Integer, Integer> top = iterator.next();

                    int nodeDistance = top.first;

                    int topNode = top.second;

                    for (Pair<Integer, Integer> child : adj.getOrDefault(topNode,

                            new ArrayList<Pair<Integer, Integer>>())) {

                        if (nodeDistance + child.second < dist[child.first]) {

                            Pair<Integer, Integer> record = null;

                            st.forEach(p -> {

                                if (p.first == dist[child.first] && p.second == child.first) {

                                    st.remove(new Pair<>(p.first, p.second));

                                }

                            });

                            // update distance

                            dist[child.first] = nodeDistance + child.second;

                            // record push in set

                            st.add(new Pair<>(dist[child.first], child.first));

                        }

                    }

                }

            }


        return dist;
	}// failing: need to fix this with java syntax

    public static void main(String[] args) {

    }
}
