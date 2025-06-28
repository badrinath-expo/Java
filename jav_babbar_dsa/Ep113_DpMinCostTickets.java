import java.util.Arrays;

public class Ep113_DpMinCostTickets {

    int solveMem(int[] days, int[] costs, int i, int[] dp) {
        if (i >= days.length) return 0;
        if (dp[i] != -1) return dp[i];

        int ans = Integer.MAX_VALUE;

        // 1-day pass
        ans = Math.min(ans, costs[0] + solveMem(days, costs, i + 1,dp));

        // 7-day pass
        int j = i;
        while (j < days.length && days[j] < days[i] + 7) j++; //after taking 7-day pass, we can skip all days that are within the next 7 days
        ans = Math.min(ans, costs[1] + solveMem(days, costs, j,dp));

        // 30-day pass
        j = i;
        while (j < days.length && days[j] < days[i] + 30) j++;
        ans = Math.min(ans, costs[2] + solveMem(days, costs, j,dp));

        return dp[j] = ans;
    }

        int solve(int[] days, int[] costs, int i) {
        if (i >= days.length) return 0;

        int ans = Integer.MAX_VALUE;
        // 1-day pass
        ans = Math.min(ans, costs[0] + solve(days, costs, i + 1));

        // 7-day pass
        int j = i;
        while (j < days.length && days[j] < days[i] + 7) j++; //after taking 7-day pass, we can skip all days that are within the next 7 days
        ans = Math.min(ans, costs[1] + solve(days, costs, j));

        // 30-day pass
        j = i;
        while (j < days.length && days[j] < days[i] + 30) j++;
        ans = Math.min(ans, costs[2] + solve(days, costs, j));

        return ans;
    }


    int solveTab(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0; // base case: no days left to process
       
        for (int k = n - 1; k >= 0; k--) {
  
            // 1-day pass
            int option1 = costs[0] + dp[k + 1];

            // 7-day pass
            int i;
            for (i = k; i < n && days[i] < days[k] + 7; i++);

            int option2 = costs[1] + dp[i];

            // 30-day pass
            for (i = k; i < n && days[i] < days[k] + 30; i++);
            int option3 = costs[2] + dp[i];

            dp[k] = Math.min(option1, Math.min(option2, option3));

        }
return dp[0];
    }
    int minimumCostTickets(int[] days, int[] costs) {
      //  return solve(days, costs, 0);

        int n = days.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        return solveMem(days, costs, 0, dp);
    }
    public static void main(String[] args) {
        
    }
}
