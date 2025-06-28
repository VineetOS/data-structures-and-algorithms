package com.dsa.src.a2zsheet.arrays.lec1;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {

    /*
    This algorithm is only correct when the numbers are >= 0: Note to handle the edge case of 0
     */
    private static int longestSubarrayOptimalForPositiveNumbers(int[] arr, int k) {
        int maxLen = 0, i = 0, j = 0, sum = arr[0];
        while (j < arr.length) {
            while (i<=j && sum > k) sum -= arr[i++];
            if (sum == k) maxLen = Math.max(maxLen, j - i + 1);

            j++;
            if(j<arr.length) sum += arr[j];
        }
        return maxLen;
    }


    /*
    This algorithm is the optimal solution when the array has positives and negatives both and is the better solution when array has only positives
     */
    private static int longestSubarrayPrefixSumApproach(int[] arr, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        int maxLen = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) maxLen = Math.max(maxLen, i + 1);
            int rem = sum - k;
            if (prefixSum.containsKey(rem)) {
                maxLen = Math.max(i - prefixSum.get(rem), maxLen);
            }
            if (!prefixSum.containsKey(sum)) prefixSum.put(sum, i);
        }
        return maxLen;
    }

    private static int longestSubArrayWithSumKBetter(int[] arr, int k) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                if (currSum == k) maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 0, 0, 1, 9};
        int k = 10;
        int res = longestSubArrayWithSumKBetter(arr, k);
        System.out.println("Better approach: " + res);
        res = longestSubarrayPrefixSumApproach(arr, k);
        System.out.println("Prefix Sum Approach: " + res);
        res = longestSubarrayOptimalForPositiveNumbers(arr, k);
        System.out.println("Optimal Approach for Positive Numbers: " + res);

    }
}
