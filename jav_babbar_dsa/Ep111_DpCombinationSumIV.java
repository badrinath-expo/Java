import java.util.Arrays;

public class Ep111_DpCombinationSumIV {

    int solve(int[] nums, int target) {
        if (target < 0) return 0;
        if (target == 0) return 1;

        int ans = 0;
        for (int num : nums) {
            ans += solve(nums, target - num);
        }
        return ans;
    }

        int solveMem(int[] nums, int target, int dp[]) {
        if (target < 0) return 0;
        if (target == 0) return 1;

        if(dp[target] != -1) return dp[target];


        int ans = 0;
        for (int num : nums) {
            ans += solveMem(nums, target - num,dp);
        }
        return dp[target] = ans;
    }

    int solveTab(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1; // Base case: one way to make target 0

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

int findWays(int[] nums, int target) {
   // return solve(nums, target);
   int[] dp = new int[target + 1];
   Arrays.fill(dp, -1);
   return solveMem(nums, target, dp);
}
    public static void main(String[] args) {
        
    }
}
