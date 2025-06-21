import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Ep86_BFS {

    void bfs(Map<Integer, List<Integer>> adjList, Map<Integer, Boolean> visited, List<Integer> ans, int node) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visited.put(node, true);

        while (!q.isEmpty()) {
            int frontNode = q.peek();
            q.remove();

            ans.add(frontNode);
            for (Integer i : adjList.getOrDefault(frontNode, new ArrayList<>())) {
                if (!visited.getOrDefault(i, false)) {
                    q.add(i);
                    visited.put(i, true);
                }
            }
        }

    }

    public static void main(String[] args) {

    }
}
