import java.util.Arrays;
import java.util.Scanner;

public class Ep91_Frog2 {

    static final int N = (int) 1e5 + 10;
    static int h[] = new int[N];
    static int dp[] = new int[N];
    static int k;

    static int func(int i, int k) {
        if (i == 0)
            return 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        int cost = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {

            if (i - j >= 0)
                cost = Math.min(cost, func(i - j, k) + Math.abs(h[i] - h[i - j]));

        }

        return dp[i] = cost;

    } // O(N*K)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(dp, -1);
        int n = sc.nextInt(), k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        System.out.println(func(n - 1, k));
    }
}

/*
 * 
 * Input
 * 5 3
 * 10 30 40 50 20
 * 
 * Output:
 * 30
 */