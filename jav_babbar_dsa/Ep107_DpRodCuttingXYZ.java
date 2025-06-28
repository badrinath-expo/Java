import java.util.Arrays;

public class Ep107_DpRodCuttingXYZ {

    static int solve(int n,int x,int y, int z){
        if(n==0){
            return 0;
        }

        if(n < 0){
            return Integer.MIN_VALUE; 
        }

        int a  = 1 + solve(n-x, x, y, z);
        int b  = 1 + solve(n-y, x, y, z);
        int c  = 1 + solve(n-z, x, y, z);

        return Math.max(a,Math.max(b,c));
    }

     static int solveMem(int n,int x,int y, int z,int[] dp){
        if(n==0){
            return 0;
        }

        if(n < 0){
            return Integer.MIN_VALUE; 
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        int a  = 1 + solveMem(n-x, x, y, z,dp);
        int b  = 1 + solveMem(n-y, x, y, z,dp);
        int c  = 1 + solveMem(n-z, x, y, z,dp);

        return dp[n]= Math.max(a,Math.max(b,c));
    }


    static int solveTab(int n,int x,int y,int z){
         int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MIN_VALUE);

        dp[0] = 0;

        for (int i = 1; i <=n; i++) {

            if(i-x >= 0){
                dp[i] = Math.max(dp[i], dp[i-x]+1);
        }
            if(i-y >= 0){
                dp[i] = Math.max(dp[i], dp[i-y]+1);
            }
            if(i-z >= 0){
                dp[i] = Math.max(dp[i], dp[i-z]+1);        
            }
        }

        return dp[n] < 0 ? 0 : dp[n]; 
    } // T.C -  O(N)   S.C - O(N)

    int cutSegments(int n,int x,int y,int z){
        // int ans = solve(n, x, y, z);
        // return ans  < 0 ? 0 : ans;
       
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        
        int ans = solveMem(n, x, y, z,dp);
        return ans < 0 ? 0 : ans;

    }
    public static void main(String[] args) {
        
    }
}
