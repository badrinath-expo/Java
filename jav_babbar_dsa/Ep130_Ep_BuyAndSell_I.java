import java.util.*;

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
