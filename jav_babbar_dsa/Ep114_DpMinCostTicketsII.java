import java.util.Queue;
import java.util.LinkedList;

public class Ep114_DpMinCostTicketsII {

    int minimumCostTickets(int[] days, int[] costs) {
        int ans = 0;
    
         Queue<int[]> month = new LinkedList<>();
         Queue<int[]> week = new LinkedList<>();
    
          for (int day:days) {
            // Process 1-day pass  
            while (!month.isEmpty() && month.peek()[0] +30 <= day) {
                month.poll();
            }

            while (!week.isEmpty() && week.peek()[0] + 7 <= day) {
                week.poll();
            }
           
            week.offer(new int[] {day,ans + costs[1]});
            month.offer(new int[] {day,ans+costs[2]});

            ans = Math.min(ans +  costs[0], Math.min(week.peek()[1], month.peek()[1]));
        }  
        return ans;
    } 
    public static void main(String[] args) {
        
    }
}
