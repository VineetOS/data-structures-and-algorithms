package com.dsa.src.a2zsheet.arrays.lec2;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static boolean twoSumOptimal(int[] arr, int target) {
        // Use a two-pointer technique after sorting the array
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                return true; // Found a pair
            } else if (sum < target) {
                left++; // Move left pointer to increase sum
            } else {
                right--; // Move right pointer to decrease sum
            }
        }
        return false; // No pair found
    }

    private static int[] twoSumHashing(int[] arr, int target) {
        // Create a hash map to store the numbers and their indices
        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i = 0; i<arr.length; i++) {
            int complement = target - arr[i];
            // Check if the complement exists in the map
            if(numMap.containsKey(complement)) {
                // If it exists, return the indices
                return new int[] {numMap.get(complement), i};
            }
            // Otherwise, add the current number and its index to the map
            numMap.put(arr[i], i);
        }
        return new int[]{-1,-1}; // Return -1, -1 if no solution is found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumHashing(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
        boolean found = twoSumOptimal(nums, target);
        System.out.println("Pair found using two-pointer technique: " + found);
    }

}
