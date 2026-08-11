import java.util.*;
class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
       int m = word1.length();
       int n = word2.length(); 
       dp = new int[m+1][n+1];
       for(int[] val : dp){
        Arrays.fill(val,-1);
       }
       return helper(word1,word2,m,n);
    }

    private int helper(String s1,String s2,int i , int j){
        
       if(i == 0) return j;
       if(j == 0) return i;

       if(dp[i][j] != -1) return dp[i][j];
       if(s1.charAt(i-1) == s2.charAt(j-1)){
        return  dp[i][j] = 0 + helper(s1,s2,i-1,j-1);
       } 
       else{
          return dp[i][j]= Math.min(1+ helper(s1,s2,i-1,j),Math.min(1+helper(s1,s2,i,j-1),1+helper(s1,s2,i-1,j-1)));
       }
    }
      
}