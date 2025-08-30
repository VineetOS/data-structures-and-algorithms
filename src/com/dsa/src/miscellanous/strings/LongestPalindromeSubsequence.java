package com.dsa.src.miscellanous.strings;

import java.util.Arrays;

public class LongestPalindromeSubsequence {

    static int lps1DOptimisation(String s){
        int n = s.length();
        //we need the next row here for generating current row
        // also need the bottom left element in prevDiagonal variable
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        //we move from right to left
        for(int i=n-2; i>=0; i--){
            int prevDiagonal = 0;
            for(int j=i+1; j<n; j++){
                int temp = dp[j];
                if(s.charAt(i) == s.charAt(j)) dp[j] = 2 + prevDiagonal;
                else dp[j] = Math.max(dp[j],dp[j-1]);
                prevDiagonal = dp[j];
            }
        }
        return dp[n-1];
    }

    static int lpsTabulation(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        //edge cases
        for(int i=0; i<n; i++) dp[i][i] = 1;

        for(int len=2; len<=n; len++){
            for(int i=0; i+len-1<n; i++){
                int j = i+len-1;
                boolean condition = s.charAt(i) == s.charAt(j);
                if(condition && len==2) dp[i][j] = 2;
                else if(condition) dp[i][j] = 2 + dp[i+1][j-1];
                else dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }
        System.out.println("Print the dp table");
        for(int[] row: dp) System.out.println(Arrays.toString(row));
        return dp[0][n-1];
    }

    static int lpsDp(String s){
        int n = s.length();
        int[][] dp = new int[n][n];
        dpHelper(s, 0, n-1, dp);
        return dp[0][n-1];
    }

    static int dpHelper(String s, int i, int j, int[][] dp){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=0) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)) dp[i][j] =  2 + dpHelper(s,i+1,j-1,dp);
        else dp[i][j] = Math.max(
                dpHelper(s,i+1,j,dp),
                dpHelper(s,i,j-1,dp)
            );
        return dp[i][j];
    }

    static int lpsBruteForce(String s){
        return bruteForceHelper(s, 0, s.length()-1);
    }

    static int bruteForceHelper(String s, int i, int j){
        if(i>j) return 0;
        if(i==j) return 1;
        if(s.charAt(i) == s.charAt(j)) return 2 + bruteForceHelper(s,i+1,j-1);
        return Math.max(bruteForceHelper(s,i+1,j), bruteForceHelper(s,i,j-1));
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println("Brute force: " + lpsBruteForce(s));
        System.out.println("Memoization Solution: " +lpsDp(s));
        System.out.println("Tabulation format: "+ lpsTabulation(s));
    }
}
