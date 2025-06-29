import java.util.*;

//DP + Hashing   3D Dp
public class Main {
  
//Ap -  a, a+d, a + 2d, a+ 3d.... 
/* Find other solutions */

int solve(int index, int diff,Integer A[]){
   //backward check
   if(index < 0) return 0;
   
   int ans  = 0;
   for(int j = index-1;j>=0;j--){
     if(A[index] - A[j] == diff){
       ans = Math.max(ans, 1 + solve(j,diff,A));
     }
   }
   return ans;
 }
    int solvelengthOfLongestAP(Integer[] arr) {
        int n = arr.length;
        // code here
         if(n <= 2){ return n;}
    
    int ans = 0;
    
    for(int i = 0;i<n;i++){
      for(int j = i+1;j<n;j++){
        ans = Math.max(ans, 2 + solve(i,arr[j] - arr[i], arr));
      }
    }
    return ans;
        
    }
    
    
    /********* correct this Map********/
    
    int solveMem(int index, int diff,Integer A[], Map<Integer,Integer> dp[]){
   //backward check
   if(index < 0) return 0;
   
   if(dp[index].count(diff)){
     return dp[index][diff];
   }
   
   int ans  = 0;
   for(int j = index-1;j>=0;j--){
     if(A[index] - A[j] == diff){
       ans = Math.max(ans, 1 + solveMem(j,diff,A, dp));
     }
   }
   return dp[index][diff] = ans;
 }
    
    
    //dp[i][diff] means, length of longest AP with a difference diff till ith index
    int solvelengthOfLongestAPMem(Integer[] arr) {
    int n = arr.length;
        // code here
    if(n <= 2){ return n;}
    
    int ans = 0;
    
    Map<Integer,Integer> dp[] = new HashMap<Integer,Integer>[n+1];
    
    for(int i = 0;i<n;i++){
      for(int j = i+1;j<n;j++){
        ans = Math.max(ans, 2 + solveMem(i,arr[j] - arr[i], arr,dp));
      }
    }
    return ans;
        
    }
    /***************/
    
    int lengthOfLongestAPTab(int A[], int n){
      if(n <=2){
        return n;
      }
      int ans = 0;
      Map<Integer,Integer> dp[] = new HashMap<Integer,Integer>[n+1];
      for(int i = 0; i<=n;i++){
        dp[i] = new HashMap<Integer,Integer>();
      }

for(int i = 1; i <n;i++){
  for(int j = 0;j<i;j++){
    int diff = A[i] - A[j];
    
    int cnt = 1;
    
    //check if answer already present
    if(dp[j].count(diff)){ //fix this Map iteration
      cnt = dp[j][diff];
    }
    
   
    
    dp[i][diff] = 1 + cnt;
    dp[i][diff] = Math.max(ans,dp[i][diff])
  
  }
}

return ans;
    }
    
    /*
    Homework, Optimize it using 
   i. 
    Relation, (a + c)/2  = b
    
    a,b,c 
    a,a+d, a + 2d...
    a + (a + 2d) = 2a + 2d = 2(a + d) = 2b
    
    ii. 3 elements AP
    
    */
    
  
    public static void main(String[] args) {
      System.out.println("Hello, World!");
  }
}
