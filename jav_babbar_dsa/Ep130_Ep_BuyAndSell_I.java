import java.util.*;
//Buy and sell part 1
//buy and sell only 1 time to get maximum profit
public class Main {
  
  int maxProfit(int prices[]){
    int mini = prices[0];
    
    int profit = 0;
    for(int i = 1;i<prices.length; i++){
        int diff = prices[i] - mini;
        profit = Math.max(profit, diff);
        mini = Math.min(mini, prices[i]);
      
    }
    
    return profit;
  }
    public static void main(String[] args) {
      System.out.println("Hello, World!");
  }
}
