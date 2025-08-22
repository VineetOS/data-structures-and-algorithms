package com.dsa.src.miscellanous.strings;

import java.util.Arrays;

public class LongestCommonSubsequence {

    static int longestCommonSubsequenceOptimised(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1]; // If characters match, include them in the count
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);// If characters don't match, explore both possibilities

            }
        }
        return dp[n][m]; // Return the length of the longest common subsequence
    }

    static int longestCommonSubsequenceDP(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp) {
            Arrays.fill(row, -1); // Initialize the dp array with -1
        }
        return dpHelper(s1, s2, n - 1, m - 1, dp);

    }

    static int dpHelper(String s1, String s2, int ind1, int ind2, int[][] dp){
        if(ind1<0 || ind2<0) return 0; // Base case: if either index is out of bounds, return 0
        if(dp[ind1][ind2] != -1) return dp[ind1][ind2]; // Return cached result if available
        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            dp[ind1][ind2] = 1 + dpHelper(s1, s2, ind1 - 1, ind2 - 1, dp); // If characters match, include them in the count
        }
        else {
            dp[ind1][ind2] = Math.max(dpHelper(s1, s2, ind1 - 1, ind2, dp),
                    dpHelper(s1, s2, ind1, ind2 - 1, dp)); // If characters don't match, explore both possibilities
        }
        return dp[ind1][ind2]; // Return the computed value
    }

    static int longestCommonSubsequence(String s1, String s2){
        return recHelper(s1, s2, s1.length()-1, s2.length()-1);
    }

    static int recHelper(String s1,String s2, int ind1, int ind2){
        if(ind1<0 || ind2<0) return 0; // Base case: if either index is out of bounds, return 0
        if(s1.charAt(ind1) == s2.charAt(ind2)) {
            return 1 + recHelper(s1, s2, ind1 - 1, ind2 - 1); // If characters match, include them in the count
        }
        return Math.max(recHelper(s1,s2,ind1-1, ind2),
                recHelper(s1,s2,ind1, ind2-1)); // If characters don't match, explore both possibilities
    }

    public static void main(String[] args) {
        String s1 = "ezupkr";
        String s2 = "ubmrapg";
        int result = longestCommonSubsequence(s1, s2);
        System.out.println("Length of Longest Common Subsequence: " + result);
        // Output: Length of Longest Common Subsequence: 3
        int resultDP = longestCommonSubsequenceDP(s1, s2);
        System.out.println("Length of Longest Common Subsequence using DP: " + resultDP);
        // Output: Length of Longest Common Subsequence using DP: 3
        int resultOptimised = longestCommonSubsequenceOptimised(s1, s2);
        System.out.println("Length of Longest Common Subsequence using Optimised DP: " + resultOptimised);
        // Output: Length of Longest Common Subsequence using Optimised DP: 3
    }
}
