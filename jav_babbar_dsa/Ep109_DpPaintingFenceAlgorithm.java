import java.util.Arrays;

public class Ep109_DpPaintingFenceAlgorithm {
   static final int MOD = 1000_000_000 +7;
//check other tutorials or chatgpt for explanation

   //RRRGB - not valid coloring, question is given that not more than 2
// RGBBR - valid

/*
 * Last 2 elements can be same/diff
 * 
 * Let's say n=4 x x x x
 *
 * for 2 items 
 * RR
 * RB
 * BR
 * BG
 * GR
 * GB
 * 
 * Now apply last 2 same/diff for each one of the above 
 * 
 * So, we need to solve n-2 first for n.
 * 
 */

/* CORRECT THESE CODES */
 static int add(int a,int b){
   return (a%MOD + b%MOD)%MOD; 
 }

  static int mul(int a,int b){
   return (a%MOD * b%MOD)%MOD; 
 }

 static int solve(int n,int k){
   if(n==1){
      return k;
   }
   if(n==2){
      return add(k, mul(k,k-1));
   }

   int ans = add(mul(solve(n-2, k), k-1), mul(solve(n-1,k),k-1));
   //k-1 * (solve(n-2,k) + solve(n-1, k))
   return ans;
 }

  static int solveMem(int n,int k, int[] dp){
   if(n==1){
      return k;
   }
   if(n==2){
      return add(k, mul(k,k-1));
   }

   if(dp[n]!=-1) {
      return dp[n];
   }

   int ans = add(mul(solveMem(n-2, k, dp), k-1), mul(solveMem(n-1,k,dp),k-1));
   //k-1 * (solve(n-2,k) + solve(n-1, k))
   return dp[n] = ans;
 }

   static int solveTab(int n,int k){

     int[] dp = new int[n+1];
     Arrays.fill(dp,0);
     dp[1] = k;
     dp[2] = add(k,mul(k,k-1));

     for (int i = 0; i <=n; i++) {
      dp[i] = add(mul(dp[i-2],k-1), mul(dp[i-1],k-1));
     }

   return dp[n];
 }

    static int spaceOptimized(int n,int k){

     int[] dp = new int[n+1];
     Arrays.fill(dp,0);
     int prev2 = k;
     int prev1 = add(k,mul(k,k-1));

     for (int i = 0; i <=n; i++) {
      int ans = add(mul(prev2,k-1), mul(prev1,k-1));
   prev2 = prev1;
   prev1 = ans;  
   }

   return prev1;
 }

 static int numberOfWays(int n,int k){
  // return solve(n,k);

  int[] dp = new int[n+1];
  Arrays.fill(dp,-1);
  return solveMem(n,k,dp);
 }
   public static void main(String[] args) {
    
   } 
}
