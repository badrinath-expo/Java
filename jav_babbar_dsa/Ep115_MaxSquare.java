import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Ep115_MaxSquare {

        int solve(int[][] matrix, int i,int j, AtomicInteger maxi) {
          if(i >= matrix.length  || j >= matrix[0].length) {
            return 0;
          }

          int right = solve(matrix, i,j + 1, maxi); //gives 1 s in the right direction
          int down = solve(matrix, i + 1,j, maxi); //gives 1 s in the down direction
          int diagonal = solve(matrix, i + 1,j + 1, maxi);  //gives 1 s in the diagonal direction

            if(matrix[i][j] == 1) {
            int ans =  1 + Math.min(right, Math.min(down, diagonal)); // Let's say we are at (i,j) and we have 1, then we can form a square of size 1 + min(right, down, diagonal)
                maxi.set(Math.max(maxi.get(), ans)); // Update the maximum size found so far
                return ans;    
        
        } else {
                return 0;
            } 
        }


        int solveMem(int[][] matrix, int i,int j, AtomicInteger maxi, int[][] dp) {
          if(i >= matrix.length  || j >= matrix[0].length) {
            return 0;
          }

          if(dp[i][j] != 0) {
            return dp[i][j]; // If we have already computed the value for this cell, return it
          }

          int right = solveMem(matrix, i,j + 1, maxi,dp); //gives 1 s in the right direction
          int down = solveMem(matrix, i + 1,j, maxi,dp); //gives 1 s in the down direction
          int diagonal = solveMem(matrix, i + 1,j + 1, maxi,dp);  //gives 1 s in the diagonal direction

            if(matrix[i][j] == 1) {
            int ans =  1 + Math.min(right, Math.min(down, diagonal)); // Let's say we are at (i,j) and we have 1, then we can form a square of size 1 + min(right, down, diagonal)
                maxi.set(Math.max(maxi.get(), ans)); // Update the maximum size found so far
                return dp[i][j] = ans;    
        
        } else {
             return dp[i][j] = 0;
            } 
        }

         int maxSquare(int n, int m, int[][] matrix) {
            // AtomicInteger maxi = new AtomicInteger(0);
            // solve(matrix, 0, 0, maxi);
            // return maxi.get() * maxi.get(); // Return area of the largest square
           int[][] dp = new int[n][m];

           for (int i = 0; i < n; i++) {
               Arrays.fill(dp[i], -1);
           }
           AtomicInteger maxi = new AtomicInteger(0);
           solveMem(matrix, 0, 0, maxi, dp);
           return maxi.get() * maxi.get(); // Return area of the largest square
        }

        int solveMem(int row, int col, int[][] matrix) {
        int[][] dp = new int[row + 1][col + 1];
        int max = 0;

        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--) {

              int right = dp[i][j+1];
              int diagonal = dp[i+1][j+1];
              int down = dp[i+1][j];

                
              if (matrix[i][j] == 1) {
              dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));
              max = Math.max(max, dp[i][j]);
              }else{
                dp[i][j] = 0;
              }
            }
        }
        return max; // Return area of the largest square
    }


    int spaceOptimize(int row, int col, int[][] matrix) {
        int[] curr = new int[row + 1];
        int[] next = new int[col + 1];
       
        int max = 0;

        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--) {

              int right = curr[j+1];
              int diagonal = next[j+1];
              int down = next[j];

                
              if (matrix[i][j] == 1) {
              curr[j] = 1 + Math.min(right, Math.min(down, diagonal));
              max = Math.max(max, curr[j]);
              }else{
                curr[j] = 0;
              }
            }
            next = curr.clone(); // Move current row to next row for the next iteration
       
          }
        return max; // Return area of the largest square
    }

    /* Home work:
     *  Find O(1) space solution
     * 
     */
    
    public static void main(String[] args) {
        
    }
}
