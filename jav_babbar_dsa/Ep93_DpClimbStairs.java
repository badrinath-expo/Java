public class Ep93_DpClimbStairs {

/* ********** Distinct ways to climb stairs **************** */
    static int solve(int nStairs, int i){
        //base case
        if(i == nStairs){
            return 1;
        }

        if(i > nStairs){
            return 0;
        }
        return solve(nStairs, i+1) + solve(nStairs, i+2);
    }

     	public static long countDistinctWayToClimbStair(int nStairs) {
		// Write your code here.
        return solve(nStairs,0);
	}


    /*********** minimize cost to climb **********/

    //recursion
    static int solveCost(int cost[],int n){        
        //base case
        if(n == 0 || n==1){
            return cost[n];
        }

        return n == cost.length ? 0 : cost[n] + Math.min(solveCost(cost, n-1),solveCost(cost, n-2));
    }

  
//Dp
    static int solveCostDp(int cost[],int n,int[] dp){        
        //base case
        if(n == 0 || n==1){
            return cost[n];
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        return dp[n]= (n == cost.length ? 0 : cost[n] + Math.min(solveCostDp(cost, n-1,dp),solveCostDp(cost, n-2,dp)));
    }

    //Dp - Iterative
      static int optimizedSolveCostDp(int[] cost,int n){
         int[] dp = new int[n+1];
         
         dp[0] = cost[0];
         dp[1] = cost[1];

         for (int i = 2; i < n; i++) {
            dp[i] =cost[i] + Math.min(dp[i-1],dp[i-2]); 
         }

         return Math.min(dp[n-1],dp[n-2]);
      }

      //Space optimization
      static int spaceOptimizedSolveCost(int cost[], int n){
        int prev2 = cost[0];
        int prev1= cost[1];

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1,prev2);
      }

    public static void main(String[] args) {
        
    }
}
