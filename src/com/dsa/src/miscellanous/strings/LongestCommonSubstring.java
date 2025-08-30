package com.dsa.src.miscellanous.strings;

public class LongestCommonSubstring {

    static int longestCommonSubstring(String s1, String s2){
        int n = s1.length(), m = s2.length(), maxlen=0, endIndex=-1;
        int[][] dp = new int[n+1][m+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    if(dp[i][j] > maxlen){
                        maxlen = dp[i][j];
                        endIndex = i-1;
                    }
                }
                else dp[i][j] = 0;

            }
        }
        System.out.println("substring with maxLen: "+ s1.substring(endIndex-maxlen+1,endIndex+1));
        return maxlen;
    }

}
