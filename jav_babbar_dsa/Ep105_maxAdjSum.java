public class Ep105_maxAdjSum {
    

    static int solve(int[] nums, int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            return nums[0];
        }

        int incl = solve(nums,n-2) + nums[n];
        int excl = solve(nums,n-1)+0;

        return Math.max(incl,excl);
    }

    static int solveMemDp(int nums[],int n, int[] dp){
        if(n<0){
            return 0;
        }
        if(n==0){
            return dp[0] = nums[0];
        }

        if(dp[n]!=-1){
            return dp[n];
        }
        int incl = solveMemDp(nums,n-2,dp) + nums[n];
        int excl = solveMemDp(nums,n-1,dp)+0;
        return dp[n] = Math.max(incl,excl);
    }

    int solveTab(int nums[]){
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int incl = i-2 >=0 ?  nums[i] + dp[i - 2] : nums[i];
            int excl = 0 + dp[i - 1];

            dp[i] = Math.max(incl,excl);
        }

        return dp[n-1];
    }

    int solveSpaceOptimized(int nums[]){
        int n = nums.length;
        int  prev2 = 0;
        int prev1 = nums[0];

        for (int i = 1; i < n; i++) {
            int incl = prev2 + nums[i];
            int excl = 0 + prev1;

            int ans = Math.max(incl,excl);
            prev2 = prev1;
            prev1 = ans;
        }

        return prev1;
    }

    int maximumNonAdjacentSum(int[] nums){
        int n = nums.length;
        int ans = solve(nums,n-1);
        return ans;
    }
    
    
    public static void main(String[] args) {
        
    }
}
