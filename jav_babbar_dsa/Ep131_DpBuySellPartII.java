import java.util.*;

/*
Buy and sell many times, must buy before sell. we can't rebuy without selling previously bought one.
*/
public class Main {
  
  int solve(int index, boolean buy, int prices[]){
    if(index == prices.length){
      return 0;
    }
    
    int profit = 0;
    
    if(buy){
      int doBuy = (-prices[index] + solve(index+1,false, prices));
      int skipBuy = (0 + solve(index+1,true, prices));
      profit = Math.max(doBuy,skipBuy);
    }else{
      int doSell = (prices[index] + solve(index+1,true, prices));
      int skipSell = (0 + solve(index+1,false, prices));
      profit = Math.max(doSell,skipSell);    
    }
  
    return profit;
  }
  
  
  int solveMem(int index, boolean buy, int prices[], int dp[][]){
    if(index == prices.length){
      return 0;
    }
    
    if(dp[index][buy ? 1: 0] !=-1){
      return dp[index][buy ? 1 : 0];
    }
    
    int profit = 0;
    
    if(buy){
      int doBuy = (-prices[index] + solveMem(index+1,false, prices,dp));
      int skipBuy = (0 + solveMem(index+1,true, prices,dp));
      profit = Math.max(doBuy,skipBuy);
    }else{
      int doSell = (prices[index] + solveMem(index+1,true, prices,dp));
      int skipSell = (0 + solveMem(index+1,false, prices,dp));
      profit = Math.max(doSell,skipSell);    
    }
  
    return dp[index][buy ? 1 : 0] = profit;
  }
  
  int solveTab(int[] prices){
      int n = prices.length;
      int dp[][]= new int[n][2];
      
      for(int index = n-1;index >= 0;index--){
        for(int buy = 0; buy<=1;buy++){
          int profit = 0;
    
    if(buy == 1){
      int doBuy = -prices[index] + dp[index+1][0];
      int skipBuy = 0 + dp[index+1][1];
      profit = Math.max(doBuy,skipBuy);
    }else{
      int doSell = prices[index] + dp[index+1][1];
      int skipSell = 0 + dp[index+1][0];
      profit = Math.max(doSell,skipSell);    
    }
    dp[index][buy] = profit;
        }
      }
      return dp[0][1];
  }
  
   int spaceOptimize(int[] prices){
      int n = prices.length;
      int curr[]= new int[2];
      int next[]= new int[2];
      
      for(int index = n-1;index >= 0;index--){
        for(int buy = 0; buy<=1;buy++){
          int profit = 0;
    
    if(buy == 1){
      int doBuy = -prices[index] + next[0];
      int skipBuy = 0 + next[1];
      profit = Math.max(doBuy,skipBuy);
    }else{
      int doSell = prices[index] + next[1];
      int skipSell = 0 + next[0];
      profit = Math.max(doSell,skipSell);    
    }
    curr[buy] = profit;
        }
        next = curr.clone();
      }
      return next[1];
  }
  
  
   public int maxProfit(int[] prices) {
      // return solve(0, true, prices); 
      int n = prices.length;
      
      int dp[][]= new int[n][2];
      
      for(int[] x:dp){
        Arrays.fill(x,-1);
      }
      
      return solveMem(0,true,prices,dp);
    }
    
    public static void main(String[] args) {
      System.out.println("Hello, World!");
  }
}
