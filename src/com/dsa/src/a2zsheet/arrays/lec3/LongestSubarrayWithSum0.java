package com.dsa.src.a2zsheet.arrays.lec3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSum0 {

    private static int optimalApproach(int[] arr) {
        int n = arr.length;
        int maxLength = 0;
        int sum = 0;
        Map<Integer, Integer> preSumStore = new HashMap<>();
        for(int i=0; i<n; i++){
            sum+= arr[i];
            if(sum == 0){
                maxLength = i+1;
            }else if(preSumStore.containsKey(sum)){
                maxLength = Math.max(maxLength, i - preSumStore.get(sum));
            } else {
                preSumStore.put(sum, i);
            }
        }
        return maxLength;
    }

    private static int bruteForce(int[] arr){
        int n = arr.length;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == 0) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = { 1, -1,-3, 2, -2, 3, 5, 4, -4 };
        System.out.println("Brute Force Result: " + bruteForce(arr));
        System.out.println("Optimal Approach Result: " + optimalApproach(arr));
    }
}
