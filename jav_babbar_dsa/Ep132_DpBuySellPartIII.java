import java.util.*;

/*
Buy and sell many times, must buy before sell. we can't rebuy without selling previously bought one.
Atmost 2 transactions(Buy & Sell)
*/
public class Main {
  
  int solve(int index, int buy, int prices[], int limit){
    if(index == prices.length || limit == 0){
      return 0;
    }
    
    int profit = 0;
    
    if(buy == 1){
      int doBuy = (-prices[index] + solve(index+1,0, prices,limit));
      int skipBuy = (0 + solve(index+1,1, prices, limit));
      profit = Math.max(doBuy,skipBuy);
    }else{
      int doSell = (prices[index] + solve(index+1,1, prices, limit-1));
      int skipSell = (0 + solve(index+1,0, prices,limit));
      profit = Math.max(doSell,skipSell);    
    }
  
    return profit;
  }
  
  
    int solveMem(int index, int buy, int prices[], int limit,int dp[][][]){
    if(index == prices.length || limit == 0){
      return 0;
    }
    
    if(dp[index][buy][limit]!=-1) return dp[index][buy][limit];
    int profit = 0;
    
    if(buy == 1){
      int doBuy = (-prices[index] + solveMem(index+1,0, prices,limit,dp));
      int skipBuy = (0 + solveMem(index+1,1, prices, limit,dp));
      profit = Math.max(doBuy,skipBuy);
    }else{
      int doSell = (prices[index] + solveMem(index+1,1, prices, limit-1,dp));
      int skipSell = (0 + solveMem(index+1,0, prices,limit,dp));
      profit = Math.max(doSell,skipSell);    
    }
  
    return dp[index][buy][limit] = profit;
  }
  
   int solveTab(int[] prices){
      int n = prices.length;
      int dp[][][]= new int[n+1][2][3];
      
      
      for(int index = n-1;index >= 0;index--){
        for(int buy = 0; buy<=1;buy++){
          
          for(int limit = 1;limit<=2;limit++){
          int profit = 0;
    
    if(buy == 1){
      int doBuy = -prices[index] + dp[index+1][0][limit];
      int skipBuy = 0 + dp[index+1][1][limit];
      profit = Math.max(doBuy,skipBuy);
    }else{
      int doSell = prices[index] + dp[index+1][1][limit-1];
      int skipSell = 0 + dp[index+1][0][limit];
      profit = Math.max(doSell,skipSell);    
    }
    dp[index][buy][limit] = profit;
        }
      }
      }
      return dp[0][1][2];
  }
  
   int spaceOptimize(int[] prices){
      int n = prices.length;
      int curr[][] = new int[2][3];
      int next[][] = new int[2][3];
      
       for(int index = n-1;index >= 0;index--){
        for(int buy = 0; buy<=1;buy++){
          for(int limit = 1;limit<=2;limit++){
          int profit = 0;
    
    if(buy == 1){
      int doBuy = -prices[index] + next[0][limit];
      int skipBuy = 0 + next[1][limit];
      profit = Math.max(doBuy,skipBuy);
    }else{
      int doSell = prices[index] + next[1][limit-1];
      int skipSell = 0 + next[0][limit];
      profit = Math.max(doSell,skipSell);    
    }
    curr[buy][limit] = profit;
        }
        next = curr.clone();
      }
      }
      return next[1][2];
  }
  
  
   public int maxProfit(int[] prices) {
      // return solve(0, true, prices); 
      int n = prices.length;
      
      int dp[][][] = new int[n][2][3];
      
      for(int[][] x:dp){
        for(int[] y:x){
          Arrays.fill(y,-1);
        }
      }
      
      return solveMem(0,1,prices, 2,dp);
    }
    
    public static void main(String[] args) {
      System.out.println("Hello, World!");
  }
}
