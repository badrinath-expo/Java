//SPOJ NAKANJ
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EP79_ShortestPath {

    // x-coordinate
    static int getX(String s) {
        return s.charAt(0) - 'a';
    }

    // y-coordinate
    static int getY(String s) {
        return s.charAt(1) - '1';
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < 8 && y < 8; // x and y are <8 since we are subtracting '1' from Y coorinate then,
                                                   // the y-coordinate range is 0 to 7
    }

    static int bfs(String source, String dest, int[][] level, boolean[][] vis) {

        final int INF = (int) 1e9 + 7;
        final int N = (int) 1e5 + 10;
        ArrayList<Integer> g[] = new ArrayList[N];
        int movements[][] = { { -1, 2 }, { 1, 2 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { -2, -1 }, { -2, 1 } };

        int sourceX = getX(source);
        int sourceY = getY(source);
        int destX = getX(dest);
        int destY = getY(dest);

        Queue<int[]> q = new LinkedList<int[]>();

        q.add(new int[] { sourceX, sourceY });
        vis[sourceX][sourceY] = true;
        level[sourceX][sourceY] = 0;

        while (!q.isEmpty()) {
            int v[] = q.peek();
            int x = v[0], y = v[1];
            q.remove();
            for (int[] movement : movements) {
                int childX = movement[0] + x;
                int childY = movement[1] + y;
                if (!isValid(childX, childY))
                    continue;
                if (!vis[childX][childY]) {
                    q.add(new int[] { childX, childY });
                    level[childX][childY] = level[x][y] + 1;
                    vis[childX][childY] = true;
                }
            }
            if (level[destX][destY] != INF)
                break; // we were stopping while loop further once we got the level of destination

        }

        return level[destX][destY];
    }

    static void reset(int[][] level, boolean[][] vis) {
        final int INF = (int) 1e9 + 7;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                level[i][j] = INF;
                vis[i][j] = false;
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean vis[][] = new boolean[8][8];
        int level[][] = new int[8][8];

        while (n > 0) {
            n--;
            reset(level, vis);
            String s1 = sc.next(), s2 = sc.next();

            System.out.println(bfs(s1, s2, level, vis));
        }

    }
}
