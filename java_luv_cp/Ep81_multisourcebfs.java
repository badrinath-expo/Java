import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ep81_multisourcebfs {

    /*
     * //CodeChef : Snakes and transition from Capitalism to Socialism
     * At the beginning itself, we add all nodes (all sources) into the queue. All
     * these nodes are at level O
     * -> childs will be added with level 1
     */

    final static int N = (int) 1e3 + 10;
    final static int INF = (int) 1e9 + 10;
    static int val[][] = new int[N][N];
    static boolean vis[][] = new boolean[N][N];
    static int level[][] = new int[N][N];
    static int n, m;
    static int[][] movements = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

    static void reset() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = false;
                level[i][j] = INF;
            }
        }
    }

    static boolean isValid(int i, int j) {
        return i >= 0 && j >= 0 && i < n && j < m;
    }

    static int bfs() {
        int mx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mx = Math.max(mx, val[i][j]);
            }
        }

        Queue<List<Integer>> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mx == val[i][j]) {
                    q.add(Arrays.asList(i, j));
                    level[i][j] = 0;
                    vis[i][j] = true;
                }
            }
        }
        int ans = 0;

        while (!q.isEmpty()) {
            List<Integer> v = q.peek();
            int v_x = v.get(0);
            int v_y = v.get(1);
            q.remove();
            for (int[] movement : movements) {
                int child_x = movement[0] + v_x;
                int child_y = movement[1] + v_y;
                if (!isValid(child_x, child_y) || vis[child_x][child_y])
                    continue;
                q.add(Arrays.asList(child_x, child_y));
                level[child_x][child_y] = level[v_x][v_y] + 1;
                vis[child_x][child_y] = true;
                ans = Math.max(ans, level[child_x][child_y]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            reset();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    val[i][j] = sc.nextInt();
                }
            }
            System.out.println(bfs());
            t--;
        }


    }
}

/*
INPUT:=
3
2 2
1 1
1 1
2 2
1 1
1 2
3 4
1 2 1 2
1 1 1 2
1 1 2 2

OUTPUT:
0
1
2

*/