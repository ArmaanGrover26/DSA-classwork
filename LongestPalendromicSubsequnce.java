import java.util.*;
class Solutions {
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
         int n = s1.length();
        int m = s.length();
        dp = new int[n+1][m+1];
        for(int[] val : dp){
            Arrays.fill(val , -1);
        }
      
        return helper(s,s1,n,m);
    }

    private int helper(String s1 , String s2 , int n , int m){
       if(n==0 || m == 0) return 0;
       if(dp[n][m] != -1) return dp[n][m];

       if(s1.charAt(n-1) == s2.charAt(m-1)){
        dp[n][m] =  1 + helper(s1,s2,n-1,m-1);
       }
       else{
        dp[n][m] = Math.max(helper(s1,s2,n-1,m),helper(s1,s2,n,m-1));
       }
       return dp[n][m];
    }
}