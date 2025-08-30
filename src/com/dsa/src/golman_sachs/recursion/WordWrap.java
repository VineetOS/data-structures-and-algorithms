package com.dsa.src.golman_sachs.recursion;

import java.util.Arrays;

public class WordWrap {
    static int dpWordWrap(int[] nums, int k){
        int[][] dp = new int[nums.length][k];
        for(int[] row: dp) Arrays.fill(row,-1);
        return dpHelper(nums, k, 1, nums[0], dp);
    }

    static int dpHelper(int[] nums, int k, int curr, int spaces, int[][] dp){
        if(curr==nums.length) return 0;
        if(dp[curr][spaces]!=-1) return dp[curr][spaces];
        int newSpaces = nums[curr]+spaces+1;
        int a = 0;
        if(newSpaces<=k) a = recHelper(nums, k, curr+1, newSpaces);

        int b = (k-spaces)*(k-spaces) + recHelper(nums, k, curr+1,nums[curr]);
        dp[curr][spaces] = Math.min(a,b);
        return dp[curr][spaces];
    }

    static int recursiveWordWrap(int[] nums, int k){
        return recHelper(nums, k, 1, nums[0]);
    }

    static int recHelper(int[] nums, int k, int curr, int spaces){
        if(curr==nums.length) return 0;
        int newSpaces = nums[curr]+spaces+1;
        int a = 0;
        if(newSpaces<=k) a = recHelper(nums, k, curr+1, newSpaces);

        int b = (k-spaces)*(k-spaces) + recHelper(nums, k, curr+1,nums[curr]);
        return Math.min(a,b);
    }
}
