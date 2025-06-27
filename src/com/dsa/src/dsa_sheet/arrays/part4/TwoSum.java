package com.dsa.src.dsa_sheet.arrays.part4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /*
        Problem Statement:
        Given an integer array nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.
    */

    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    private static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int[] twoSumBetter(int[] nums, int target) {
        Map<Integer, Integer> mapStore = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(mapStore.containsKey(target - nums[i])){
                return new int[]{mapStore.get(target - nums[i]), i};
            }
            mapStore.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

    // Time Complexity: O(n + nlogn)
    // Space Complexity: O(1)
    private static int[] twoSumOptimal(int[] nums, int target) {
        //using two pointer approach
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSumBruteForce(nums, target);
        System.out.println("Brute force solution " + target + ": [" + result[0] + ", " + result[1] + "]");
        result = twoSumBetter(nums, target);
        System.out.println("Better approach solution " + target + ": [" + result[0] + ", " + result[1] + "]");
        result = twoSumOptimal(nums, target);
        System.out.println("Optimal approach (greedy) solution " + target + ": [" + result[0] + ", " + result[1] + "]");
    }
}
