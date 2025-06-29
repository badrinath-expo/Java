import java.util.*;

public class Main {
  //LeetCode:Reducing Dishes
  
   int solve(int[] statisfaction,int index,int time){
     
     //base case:
     if(index == statisfaction.length){
      return 0;
     }
     
     int include = statisfaction[index]*(time+1) + solve(statisfaction,index+1,time+1);
     int exclude = 0 + solve(statisfaction ,index + 1, time)

return Math.max(include,exclude);       
   }
   
   int solveMem(int[] statisfaction,int index,int time, int[][] dp){
     
     //base case:
     if(index == statisfaction.length){
      return 0;
     }
     
     if(dp[index][time] != -1) return dp[index][time]
     int include = statisfaction[index]*(time+1) + solveMem(statisfaction,index+1,time+1, dp);
     int exclude = 0 + solveMem(statisfaction ,index + 1, time, dp)

return dp[index][time] =  Math.max(include,exclude);       
   }
   
   
   int solveTab(int[] statisfaction){
     Arrays.sort(statisfaction);
     //return solve(statisfaction, 0, 0);
     int n = statisfaction.length;
     int[][] dp = new int[n+1][n+1];
     
     for(int[] arr: dp){
       Arrays.fill(arr,0);
     }
     
     for(int index = n-1;index>=0;index--){
       for(int time = index;time>=0;time--){
         int include = statisfaction[index]*(time+1) + dp[index+1][time+1];
         int exclude = 0 + dp[index+1][time];
         dp[index][time] = Math.max(include,exclude);
       }
     }
     return dp[0][0];
   }
   
   int solveTab2(int[] statisfaction){
     Arrays.sort(statisfaction);
     //return solve(statisfaction, 0, 0);
     int n = statisfaction.length;
     int curr[] = new int[n+1];
     int next[] = new int[n+1];
     
     for(int[] arr: dp){
       Arrays.fill(arr,0);
     }
     
     for(int index = n-1;index>=0;index--){
       for(int time = index;time>=0;time--){
         int include = statisfaction[index]*(time+1) + next[time+1];
         int exclude = 0 + next[time];
         dp[index][time] = Math.max(include,exclude);
       }
       next = curr.clone();
     }
     return next[0];
   }
   
   int maxSatisfaction(int[] statisfaction){
     Arrays.sort(statisfaction);
     //return solve(statisfaction, 0, 0);
     int n = statisfaction.length;
     int[][] dp = new int[n+1][n+1];
     
     for(int[] arr: dp){
       Arrays.fill(arr,-1);
     }
     
     return solveMem(statisfaction, 0,0, dp)
   }
   
   
  /*
  Find Optimized O(1) space approach
  Find Greedy Approach
  */
    public static void main(String[] args) {
      System.out.println("Hello, World!");
  }
}
