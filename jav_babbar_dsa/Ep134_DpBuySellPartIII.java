import java.util.*;

/*
We can still use previous problem by passing k in the limit
*/

//In this code, we try to solve with operations count

//Buy and Sell with tx fee
public class Main {
              int solve(int index,int operationNo, int prices[],int fee){
    if(index == prices.length) return 0;

          int profit = 0;
     if(operationNo%2 == 0){ //even buy
       int doBuy = -prices[index] + solve(index+1,operationNo+1,prices,fee);
      int skipBuy = 0 +solve(index+1,operationNo,prices,fee);
      profit = Math.max(doBuy,skipBuy);
    }else{
      int doSell = prices[index] - fee + solve(index+1,operationNo+1,prices,fee);
      int skipSell = 0 + solve(index+1,operationNo,prices,fee);
      profit = Math.max(doSell,skipSell);    
     }
     
     return profit;
  }
    public int maxProfit(int[] prices, int fee) {
        return solve(0,0,prices,fee);
    }
  
  int maxProfit(int k,int[] prices){
    int n = prices.length;
    int dp[][] = new int[n][3];
    for(int[] x:dp){
      Arrays.fill(x,-1);
    }
    
    return solveMem(0,0,prices,dp);
  }
    public static void main(String[] args) {
      System.out.println("Hello, World!");
  }
}
