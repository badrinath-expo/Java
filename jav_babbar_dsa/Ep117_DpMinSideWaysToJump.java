public class Ep117_DpMinSideWaysToJump {
 /* e.g: obstacle[i] = 2, on ith pos, obstacle is on 2nd pos  */
   
 int solve(int[] obstacles, int currLane, int currPos, int[][] dp) {
        if (currPos == obstacles.length - 1) return 0; // Reached the end
        if (dp[currLane][currPos] != -1) return dp[currLane][currPos]; // Already computed
        
        int ans = Integer.MAX_VALUE;
        
        // Jump to the next position
        if (obstacles[currPos + 1] != currLane) { //no obstacle on lane at our next position
            ans = Math.min(ans, solve(obstacles, currLane, currPos + 1, dp));
        }else{
        
        // Jump sideways to the next possible position
        for (int i = 1; i <= 3; i++) {
            if (i != currLane && obstacles[currPos] != i) { // k is not the current lane and no obstacle on that lane
                ans = Math.min(ans, 1+ solve(obstacles, i, currPos, dp)); //adding 1 for the sideways jump
            }
        }
    }
        
        return dp[currLane][currPos] = ans;
    }

    int solveTabCopilot(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[4][n];
        
        // Initialize dp array with a large value
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        //dp[i][j] represents the minimum jumps needed to reach position j from lane i
        // Base case: at the last position, no jumps needed
        for (int i = 1; i <= 3; i++) {
            dp[i][n - 1] = 0;
        }
        
        // Fill the dp table in reverse order
        for (int pos = n - 2; pos >= 0; pos--) {
            for (int lane = 1; lane <= 3; lane++) {
                if (obstacles[pos + 1] != lane) { // No obstacle on the next position
                    dp[lane][pos] = Math.min(dp[lane][pos], dp[lane][pos + 1]); // Jump to the next position
                }
                
                // Check for sideways jumps
                // Try jumping to all other lanes
                for (int i = 1; i <= 3; i++) {
                    if (i != lane && obstacles[pos] != i) { // k is not the current lane and no obstacle on that lane
                        dp[lane][pos] = Math.min(dp[lane][pos], 1 + dp[i][pos]);
                    }
                }
            }
        }
        
        return Math.min(dp[1][0], Math.min(dp[2][0], dp[3][0])); // Minimum jumps from the starting position for all lanes  
    }

    //based on recursion with memoization
    int solveTab(int[] obstacles) {
        int n = obstacles.length - 1;
        int[][] dp = new int[4][n];
        
        // Initialize dp array with a large value
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        
        // Base case: at the last position, no jumps needed
        for (int i = 0; i <= 3; i++) {
            dp[i][n] = 0;
        }
        
        // Fill the dp table in reverse order
        for (int pos = n - 1; pos >= 0; pos--) {
            for (int lane = 1; lane <= 3; lane++) {
                if (obstacles[pos + 1] != lane) { // No obstacle on the next position
                    dp[lane][pos] = dp[lane][pos + 1]; // Jump to the next position
                }else{
                int ans  = Integer.MAX_VALUE;
                // Check for sideways jumps
                for (int i = 1; i <= 3; i++) {
                    if (i != lane && obstacles[pos] != i) { // k is not the current lane and no obstacle on that lane
                        ans = Math.min(ans, 1 + dp[i][pos + 1]);
                    }
                    dp[lane][pos] = Math.min(dp[lane][pos], ans); // Update the dp value for the current lane and position
                }
            }
            }
        }
        
        return Math.min(dp[1][0], Math.min(dp[2][0], dp[3][0])); // Minimum jumps from the starting position for all lanes  
    }
 
 public static void main(String[] args) {
        
    }
}
