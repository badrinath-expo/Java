import java.util.*;

/*
We can still use previous problem by passing k in the limit
*/

//In this code, we try to solve with operations count
public class Main {
      int solve(int index,int operationNo,int k, int prices[]){
    if(index == prices.length) return 0;

     if(operationNo == 2*k){ //buy & sell k times
       return 0;
     }

          int profit = 0;
     if(operationNo%2 == 0){ //even buy
       int doBuy = -prices[index] + solve(index+1,operationNo+1,k,prices);
      int skipBuy = 0 +solve(index+1,operationNo,k,prices);
      profit = Math.max(doBuy,skipBuy);
    }else{
      int doSell = prices[index] + solve(index+1,operationNo+1,k,prices);
      int skipSell = 0 + solve(index+1,operationNo,k,prices);
      profit = Math.max(doSell,skipSell);    
     }
     
     return profit;
  }
  
  
       int solveMem(int index,int operationNo,int k, int prices[], int dp[][]){
    if(index == prices.length) return 0;

     if(operationNo == 2*k){ //buy & sell k times
       return 0;
     }
     
     if(dp[index][operationNo]!=-1) return dp[index][operationNo];

          int profit = 0;
     if(operationNo%2 == 0){ //even buy
       int doBuy = -prices[index] + solveMem(index+1,operationNo+1,k,prices,dp);
      int skipBuy = 0 +solveMem(index+1,operationNo,k,prices,dp);
      profit = Math.max(doBuy,skipBuy);
    }else{
      int doSell = prices[index] + solveMem(index+1,operationNo+1,k,prices,dp);
      int skipSell = 0 + solveMem(index+1,operationNo,k,prices,dp);
      profit = Math.max(doSell,skipSell);    
     }
     
     return dp[index][operationNo] = profit;

  }
  
  int maxProfit(int k,int[] prices){
    int n = prices.length;
    int dp[][] = new int[n][2*k];
    for(int[] x:dp){
      Arrays.fill(x,-1);
    }
    
    return solveMem(0,0,k,prices,dp);
  }
    public static void main(String[] args) {
      System.out.println("Hello, World!");
  }
}
