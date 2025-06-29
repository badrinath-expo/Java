      int solve(String a, String b, int i,int j){
    //base case 
    if(i== a.length()){
      return b.length() - j; //deletion of remaining chars in b string
    }
    
    if(j == b.length()){
      return a.length() - i; //deletion operations of remaining chars in a string
    }
    
    int ans = 0;
    
    if(a.charAt(i) == b.charAt(j)){
      return solve(a,b,i+1,j+1); //No operations, moving indexes forward
    } else{
      /*
      Insertion:
      word1 = horse
      word2= ros
      
      after insertion in word1
      word1 = rhorse
      word2 = ros
      
      So, i won't change, but j moves forward
      */
      int insertAns = 1+ solve(a,b,i,j+1); 
       /*
      Deletion:
      word1 = horse      i at h
      word2= ros        j at r
      
      after delletion in word1
      word1 = orse       i moves forward
      word2 = ros       j still at r
      
      So, i won't change, but i moves forward
      */
      int deleteAns = 1 +  solve(a,b, i+1,j);
          /*
      Replace:
      word1 = horse     i at h
      word2= ros        j at r
      
      after replace in word1
      word1 = rorse       i moves forward
      word2 = ros       j also moves forward
      
      So, i & j both moves forward
      */
      int replaceAns = 1+  solve(a,b,i+1,j+1);
      
      ans = Math.min(insertAns, Math.min(deleteAns,replaceAns));
    }
    
    return ans;
  }

            int solveMem(String a, String b, int i,int j, int dp[][]){
    //base case 
    if(i== a.length()){
      return b.length() - j; //deletion of remaining chars in b string
    }
    
    if(j == b.length()){
      return a.length() - i; //deletion operations of remaining chars in a string
    }
    
    if(dp[i][j]!=-1) return dp[i][j];
    int ans = 0;
    
    if(a.charAt(i) == b.charAt(j)){
      return solveMem(a,b,i+1,j+1,dp); //No operations, moving indexes forward
    } else{
      /*
      Insertion:
      word1 = horse
      word2= ros
      
      after insertion in word1
      word1 = rhorse
      word2 = ros
      
      So, i won't change, but j moves forward
      */
      int insertAns = 1+ solveMem(a,b,i,j+1,dp); 
       /*
      Deletion:
      word1 = horse      i at h
      word2= ros        j at r
      
      after delletion in word1
      word1 = orse       i moves forward
      word2 = ros       j still at r
      
      So, i won't change, but i moves forward
      */
      int deleteAns = 1 +  solveMem(a,b, i+1,j,dp);
          /*
      Replace:
      word1 = horse     i at h
      word2= ros        j at r
      
      after replace in word1
      word1 = rorse       i moves forward
      word2 = ros       j also moves forward
      
      So, i & j both moves forward
      */
      int replaceAns = 1+  solveMem(a,b,i+1,j+1,dp);
      
      ans = Math.min(insertAns, Math.min(deleteAns,replaceAns));
    }
    
    return dp[i][j] = ans;
  }


    int solveTab(String a,String b){
         int dp[][] = new int[a.length()+1][b.length()+1];

        for(int j = 0; j< b.length();j++){
            dp[a.length()][j] = b.length() - j;
        }

        for(int i = 0;i<a.length();i++){
            dp[i][b.length()] = a.length() - i;
        }

        for(int i = a.length() -1;i>=0;i--){
            for(int j = b.length()-1;j>=0;j--){
    int ans = 0;
    
    if(a.charAt(i) == b.charAt(j)){
      ans = dp[i+1][j+1]; //No operations, moving indexes forward
    } else{
      int insertAns = 1+dp[i][j+1]; 
      int deleteAns = 1 +  dp[i+1][j];
      int replaceAns = 1+  dp[i+1][j+1];
      ans = Math.min(insertAns, Math.min(deleteAns,replaceAns));
    }
                dp[i][j] = ans;
            }
        }

        return dp[0][0];
    }


    int spaceOptimize(String a,String b){ //fix this
         if(a.isEmpty()){
             return b.length();
         }else if(b.isEmpty()){
             return a.length();
         }
         int  curr[] = new int[b.length()+1];
         int  next[] = new int[b.length()+1];

        for(int j = 0; j<=b.length(); j++){
            next[j] = b.length() - j;
        }


        for(int i = a.length()-1;i>=0;i--){
            for(int j = b.length()-1;j>=0;j--){
  curr[b.length()] = a.length() - i;
                int ans = 0;
    
    if(a.charAt(i) == b.charAt(j)){
      ans = next[j+1]; //No operations, moving indexes forward
    } else{
      int insertAns = 1 + curr[j+1]; 
      int deleteAns = 1 + next[j];
      int replaceAns = 1+  next[j+1];
      ans = Math.min(insertAns, Math.min(deleteAns,replaceAns));
    }
                curr[j] = ans;
            }
            next = curr.clone();
        }

        return next[0];
    }

    
    public int minDistance(String word1, String word2) {
       int dp[][] = new int[word1.length()][word2.length()];

        for(int[] x: dp){
            Arrays.fill(x,-1);
        }
        
      //  return solveMem(word1,word2,0,0,dp);
        //return solveTab(word1,word2);
    return spaceOptimize(word1,word2);
    }
