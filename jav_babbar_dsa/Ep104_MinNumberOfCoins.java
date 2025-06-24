import java.util.Arrays;

public class Ep104_MinNumberOfCoins {

    static int solveRec(int nums[], int x) {
        // base case
        if (x == 0) {
            return 0;
        }

        if (x < 0) {
            return Integer.MAX_VALUE;
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int ans = solveRec(nums, x - nums[i]);
            if (ans != Integer.MAX_VALUE) {
                mini = Math.min(mini, 1 + ans);
            }
        }

        return mini;
    }

    static int solveRecDp(int nums[], int x, int dp[]) {
        // base case
        if (x == 0) {
            return 0;
        }

        if (x < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[x] != -1)
            return dp[x];

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int ans = solveRecDp(nums, x - nums[i], dp);
            if (ans != Integer.MAX_VALUE) {
                mini = Math.min(mini, 1 + ans);
            }
        }

        return dp[x] = mini;
    }

    // Dp-Iterative
    int solveIterativeDp(int nums[], int x) {
        int[] dp = new int[x + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= x; i++) {
            // solve for every amount 1 to x
            for (int j = 0; j < nums.length; j++) {
                if (((i - nums[j]) >= 0) && dp[i - nums[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1+ dp[i - nums[j]]);
                }
            }

        }
        return dp[x] == Integer.MAX_VALUE ? -1:dp[x];

    }

    int minElements(int nums[], int x) {
        // int ans = solveRec(nums, x);
        // if(ans == Integer.MAX_VALUE){
        // return -1;
        // }
        // return ans;

        // Recursion DP case
        int[] dp = new int[x + 1];
        Arrays.fill(dp, -1);
        int ans = solveRecDp(nums, x, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {

    }
}
