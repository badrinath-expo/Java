import java.util.Arrays;

public class Ep108_DpCountDerangements {
    static int MOD = 1000_000_000 + 7;
//get the explanation from chatgpt
    public static long solve(int n) {
        // Write your code here.
        // base case
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        long ans = ((n - 1) % MOD * 1L * ((solve(n - 1) % MOD) + (solve(n - 2) % MOD))) % MOD;

        return ans;
    }

    public static long solveMem(int n, long dp[]) {
        // Write your code here.
        // base case
        if (n == 1) {
            return 0;
        }

        if (n == 2) {
            return 1;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        long ans = ((n - 1) % MOD * 1L * ((solveMem(n - 1, dp) % MOD) + (solveMem(n - 2, dp) % MOD))) % MOD;

        return dp[n] = ans;
    }

        public static long solveTab(int n) {
        // Write your code here.
      long dp[] = new long[n+1];
       Arrays.fill(dp,0);
        // base case
         dp[1] = 0;
         dp[2] = 1;


         for (int i = 3; i <= n; i++) {
            long first = dp[i-1]%MOD;
            long second = dp[i-2]%MOD;
            long sum = (first + second)%MOD;
            long ans = ((i-1)*sum)%MOD;
            dp[i] = ans;
         }

        return dp[n];
    }


    static long spaceOptimized(int n){
        long prev2 = 0;
        long prev1 = 1;


         for (int i = 3; i <= n; i++) {
            long first = prev1%MOD;
            long second = prev2%MOD;
            long sum = (first + second)%MOD;
            long ans = ((i-1)*sum)%MOD;
            prev2 = prev1;
            prev1= ans;
         }

        return prev1;
    }

    static long countDerangements(int n) {
       // return solve(n);

       long dp[] = new long[n+1];
       Arrays.fill(dp,-1);
       return solveMem(n,dp);
    }

    public static void main(String[] args) {

    }
}

/**
 * 
 * arr: 0,1,3..........n
 * 
 * 
 * The possibility of any other element at 0th index is
 * n-2*[solution of sub problem] ==>answer
 * 
 * why n-2, since 0 is swapped to new place
 * 
 */
