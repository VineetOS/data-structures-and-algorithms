package com.dsa.src.a2zsheet.recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    static List<List<String>> palindromePartitionsDP(String s){
        List<List<String>> ans = new ArrayList<>();
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = s.length()-1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j) &&
                        (j-i <= 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                }
            }
        }

        recursionHelperDP(s,0,new ArrayList<>(), ans, dp);
        return ans;
    }

    static void recursionHelperDP(String s, int start, List<String> currPart, List<List<String>> ans,boolean[][] dp){
        if(start==s.length()){
            ans.add(new ArrayList<>(currPart));
            return;
        }
        for(int end=start; end<s.length(); end++){
            if(dp[start][end]){
                currPart.add(s.substring(start,end+1));
                recursionHelperDP(s,end+1,currPart,ans, dp);
                currPart.remove(currPart.size()-1);
            }
        }
    }


    static List<List<String>> palindromePartitions(String s){
        List<List<String>> ans = new ArrayList<>();
        recursionHelper(s,0,new ArrayList<>(), ans);
        return ans;
    }

    static void recursionHelper(String s, int start, List<String> currPart, List<List<String>> ans){
        if(start==s.length()){
            ans.add(new ArrayList<>(currPart));
            return;
        }
        for(int end=start; end<s.length(); end++){
            if(isPalindrome(s, start,end)){
                currPart.add(s.substring(start,end+1));
                recursionHelper(s,end+1,currPart,ans);
                currPart.remove(currPart.size()-1);
            }
        }
    }

    static boolean isPalindrome(String s, int start, int end){
        while(start<=end)
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "aabb";
        var palindromePartitions = palindromePartitions(s);
        var palindromePartitionsDP = palindromePartitionsDP(s);
        System.out.println(palindromePartitions);
        System.out.println(palindromePartitionsDP);
    }
}
