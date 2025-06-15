import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ep84_Greg_Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 510;
        final int INF = (int) 1e9 + 10;
        int n = sc.nextInt();
        long dist[][] = new long[N][N];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        List<Integer> del_order = new ArrayList();

        for (int i = 0; i < n; i++) {
            del_order.add(sc.nextInt());
        }

        Collections.reverse(del_order);
        /*
        Question was given in a order to delete the nodes in order
         * we're revering the delete order Input,such that, we run the floyd warshall in this order to get the result in the way.
         */
        List<Long> ans = new ArrayList<>();

        for (int k = 0; k < n; k++) {
            int k_v = del_order.get(k); 
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    long newDist = dist[i][k_v] + dist[k_v][j];
                    dist[i][j] = Math.min(dist[i][j], newDist);
                }
            }
            long sum = 0;
            for (int i = 0; i <= k; i++) {
                for (int j = 0; j <= k; j++) {
                    sum += dist[del_order.get(i)][del_order.get(j)];
                }
            }
            ans.add(sum);
        }
        Collections.reverse(ans);
        for (Long a : ans) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}

/*
4
0 3 1 1
6 0 400 1
2 4 0 1
1 1 1 0
4 1 2 3

17 23 404 0 

*/