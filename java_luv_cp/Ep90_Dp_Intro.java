import java.util.Arrays;
import java.util.Scanner;

public class Ep90_Dp_Intro {
    static final int N = (int) 1e5 + 10;
    static int dp[] = new int[N];

    // Top down
    static int fib(int n) {
        if (n == 0 || n == 1)
            return n;

        if (dp[n] != -1)
            return dp[n];

        return dp[n] = fib(n - 1) + fib(n - 2);
    }

    // Recursion: 1+2+4+8+... ~ O(2^(n+1)) calls : recursion tree
    // Dp: n calls
    // DP converts exponentials to linear, factorial to 2^n

    public static void main(String[] args) {
        Arrays.fill(dp, -1);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // System.out.println(fib(n));

        //Bottom up
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }
}
