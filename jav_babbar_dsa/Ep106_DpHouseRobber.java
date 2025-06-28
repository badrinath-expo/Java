import java.util.ArrayList;

public class Ep106_DpHouseRobber {

    long solveSpaceOptimized(ArrayList<Long> nums){
        int n = nums.size();
        long  prev2 = 0;
        long prev1 = nums.get(0);

        for (int i = 1; i < n; i++) {
            long incl = prev2 + nums.get(i);
            long excl = 0 + prev1;

            long ans = Math.max(incl,excl);
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }

    long houseRobber(long[] valueInHouse){
      int n = valueInHouse.length;

      if(n == 1){
        return valueInHouse[0];
      }

      ArrayList<Long> first =  new ArrayList<>();
      ArrayList<Long> second =  new ArrayList<>();
      
      for (int i = 0; i < n; i++) {
        if(i!=n-1){ //since houses are in circluar, first and last index will be adjacent each other, so we should avoid these houses
           first.add(valueInHouse[i]);
        }
        if(i!=0){ //ignoring first element
        second.add(valueInHouse[i]);
        }
      }

      return Math.max(solveSpaceOptimized(first),solveSpaceOptimized(second));
    }
    public static void main(String[] args) {
        
    }
}