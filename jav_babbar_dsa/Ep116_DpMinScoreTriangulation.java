public class Ep116_DpMinScoreTriangulation {
   //i=0 -----k------ j = n-1
   // 0 1 2 3 4 5 6
    int solve(int[] v, int i,int j){
        if(i+1 == j) return 0; // base case, no triangle can be formed with just 2 adj vertices
        int ans = Integer.MAX_VALUE;
        for(int k = i+1; k < j; k++){
            int score = v[i] * v[k] * v[j];
            ans = Math.min(ans, score + solve(v, i, k) + solve(v, k, j));
        }
        return ans;
    }

        int solveMem(int[] v, int i,int j,int[][] dp){
        if(i+1 == j) return 0; // base case, no triangle can be formed
        
        if(dp[i][j] != -1) return dp[i][j]; // check if already computed
        
        int ans = Integer.MAX_VALUE;
        for(int k = i+1; k < j; k++){
            int score = v[i] * v[k] * v[j];
            ans = Math.min(ans, score + solve(v, i, k) + solve(v, k, j));
        }
        return dp[i][j] = ans;
    }

    int solveTab(int[] v, int n) {
        int[][] dp = new int[n][n];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 2; j < n; j++) { // j must be at least i + 2 to form a triangle, i+1 is the next vertex, we can't form a triangle with just two vertices
                int ans = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++) { // k is the vertex that completes the triangle with vertices i and j. So k should be between i and j
                    int score = v[i] * v[k] * v[j];
                    ans = Math.min(ans, score + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][n - 1];
    }

    int minSocreTriangular(int[] v) {
        int n = v.length;
      //  return solve(v, 0, n - 1);

        int[][] dp = new int[n][n];
        for(int[] row : dp) {
            for(int j = 0; j < n; j++) {
                row[j] = -1; // initialize dp array with -1
            }
        }
        return solveMem(v, 0, n - 1, dp);
    }
   
    public static void main(String[] args) {
       /*
       Home works:
       1.Gap Strategy for this solution in leetcode
       2.MCM pattern type solution in leetcode
       3. Find the no.of ways to triangulate a polygon with n vertices (hint: catalan number)
       */ 
    }
}
