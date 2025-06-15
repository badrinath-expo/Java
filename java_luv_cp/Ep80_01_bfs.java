import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

//Directed graph, reverse no. of nodes to make shortest path
public class Ep80_01_bfs {
    final static int N = (int) 1e5 + 10;
    final static int INF = (int) 1e9 + 10;
    final static int level[] = new int[N];
    static int n, m;

    // At a time, queue contains 2 levels
    // Chef and reversing question code chef
    // Make all reverse edge nodes and set their weights as 1
    static int o1bfs(ArrayList<List<Integer>>[] graph) {
        Deque<Integer> q = new ArrayDeque<>();
        q.addFirst(1);
        level[1] = 0;

        while (!q.isEmpty()) {
            int currNode = q.peekFirst();
            q.remove();

            for (List<Integer> child : graph[currNode]) {
                int child_node = child.get(0);
                int child_wt = child.get(1);
                /*
                 * First time, levels were Infinity, so first time processing would be this
                 * Second time, levels would be processed with 1/0 wt.
                 * Tip:: In bfs once level is set we can skip checking it, we can use it as a visited array
                 */
                if(level[currNode] + child_wt < level[child_node]){ //Avoids multiple times adding, processes 2 times, that's why we don't need visited array, we can use level array.
                     level[child_node] = level[currNode] + child_wt;
                     if(child_wt == 1){
                        q.addLast(child_node);
                     }else{
                        q.addFirst(child_node);
                     }
                }
            }
        }

        return level[n] == INF ? -1 : level[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        ArrayList<List<Integer>> graph[] = new ArrayList[N];
        int lev[] = new int[N];

        for (int i = 0; i < lev.length; i++) {
            lev[i] = INF;
        }

        for (int index = 0; index < graph.length; index++) {
            graph[index] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            if(x==y) continue; //ignoring self loop 
            graph[x].add(Arrays.asList(y, 0)); 
            graph[y].add(Arrays.asList(x, 1)); //adding reverse edge
        }

        System.out.println(o1bfs(graph));

    }
}
