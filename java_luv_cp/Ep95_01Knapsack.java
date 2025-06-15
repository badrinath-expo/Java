import java.util.Arrays;
import java.util.Scanner;

public class Ep95_01Knapsack {
    static final int N = (int) 2e5 + 10;
    static int wt[] = new int[105];
    static int val[] = new int[105];
    static long dp[][] = new long[100][100005];

    static long func(int index, int wt_left) {
        if (wt_left == 0) // func(index, 0)
            return 0;
        if (index < 0) // func(-1, wt_left), []
            return 0;

        if (dp[index][wt_left] != -1)
            return dp[index][wt_left];

        long ans = func(index - 1, wt_left); // Not chosen item at index
        if (wt_left - wt[index] >= 0)
            ans = Math.max(ans, func(index - 1, wt_left - wt[index]) + val[index]); // item choosen at index
        return dp[index][wt_left] = ans;
    }

    public static void main(String[] args) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), w = sc.nextInt();
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }

        System.out.println(func(n - 1, w));
    }
}

/*
 * Input:=
 * 3 8
 * 3 30
 * 4 50
 * 5 60
 * 
 * Output:=
 * 90
 */