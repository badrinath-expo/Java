import java.util.Arrays;

public class Ep112_DpMinSquaresSum {

    int solve(int n){
        if(n == 0) return 0;

        int ans = n;
        for(int i = 1; i * i <= n; i++){
            int square = i * i;
            ans = Math.min(ans, 1 + solve(n - square));
        }
        return ans;
    }

    int solveMemo(int n, int[] dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];

        int ans = n;
        for(int i = 1; i * i <= n; i++){
            int square = i * i;
            ans = Math.min(ans, 1 + solveMemo(n - square, dp));
        }
        return dp[n] = ans;
    }

    int solveTab(int n){
        int dp[] = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            dp[i] = i; // maximum squares needed is i (1^2 + 1^2 + ... + 1^2)
            for(int j = 1; j * j <= i; j++){
                int square = j * j;
                if(i - square >= 0){
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
                }
            }
        }
        return dp[n];
    }

    int minSquares(int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return solveMemo(n, dp);
    }
    public static void main(String[] args) {
        
    }
}
