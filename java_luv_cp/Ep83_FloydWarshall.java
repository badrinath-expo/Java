import java.util.Scanner;

public class Ep83_FloydWarshall {
    // Works on directed and undirected graphs, handles -ve weights, can't handle
    // -ve weighted cycles
    // All pair shortest path algorithm
    /*
     * k=0 no vertex inbetween
     * k =1, 1 vertex in between
     * k =2 , 1 or 2 vertex in between
     */

    /*
     * Explanation i -> j
     * k = 1,2,3,4,5,6...k uptil k nodes we can go
     * Adding k th node, upto k nodes
     * Cases: =
     * 1. Shortest path -> Not effected on adding kth node , i-> j same
     * 2. Shortest path Affected on adding k+1th node
     * -> (i -> k) + (k -> j)
     * dist[i][j] = dist[i][k] + dist[k][j];
     */
    final static int N = 510;
    final static int INF = (int) 1e9 + 10;
    final static int dist[][] = new int[N][N];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = INF;
            }
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(), y = sc.nextInt(), wt = sc.nextInt();
            dist[x][y] = wt;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) // handles -ve weights
                        /*
                         * -ve weights handling::
                         * Assume, there is no node between i and j, dist[i][k] = -ve weight &
                         * dist[k][j] = INF
                         * Then, due to dist[i][k] + dist[k][j] , we get INF-1 or INF-somevalues would
                         * exist, these are not actual distances and there is no path exist in them.
                         */
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        } //O(N^3)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("I ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

/*
 * 
 * INPUT:=
 6 9
1 2 1
1 3 5
2 3 2
3 5 2
2 5 1
2 4 2
4 5 3
4 6 1
5 6 2

OUTPUT:=
0 1 3 3 2 4 
I 0 2 2 1 3 
I I 0 I 2 4 
I I I 0 3 1
I I I I 0 2
I I I I I 0

 */