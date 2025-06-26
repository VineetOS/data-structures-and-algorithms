package com.dsa.src.arrays.dsa_sheet.part4;

import java.util.*;

public class ThreeSum {

    /*
        Problem Statement:
        Given an integer array nums, return all the unique triplets [nums[i], nums[j], nums[k]] such that
         i!=j, j!=k, k!=i, and their sum is equal to zero.
     */


    /*
        ** Time Complexity: O(n^3)*O(log{no. of unique triplets}))
            Side Note: O(log{no. of unique triplets}) is for adding to the set.
            We are not considering sorting time complexity since we are only sorting 3 elements each time.
        ** Space Complexity: O(2*no. of unique triplets)
     */
    private static List<List<Integer>> bruteForce(int[] nums) {

        int n= nums.length;
        if (n < 3) {
            return new ArrayList<>();
        }
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                        triplet.sort(null);
                        resultSet.add(triplet);

                    }
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

    /*
        ** Time Complexity: O(n^2)*O(log{no. of unique triplets}))
            Side Note: O(log{no. of unique triplets}) is for adding to the set.
            We are not considering sorting time complexity since we are only sorting 3 elements each time.
        ** Space Complexity: O(N)+O(2*no. of unique triplets)
            Side Note: O(N) is for the tempSet and O(2*no. of unique triplets) is for the resultSet.
     */
    private static List<List<Integer>> betterApproach(int[] nums){
        if(nums.length < 3) return new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            Set<Integer> tempSet = new HashSet<>();
            for(int j=i+1; j<nums.length; j++){
                int complement = -nums[i] - nums[j];
                if(tempSet.contains(complement)){
                    List<Integer> triplet = new ArrayList<>(List.of(nums[i], nums[j], complement));
                    triplet.sort(null);
                    resultSet.add(triplet);
                }
                tempSet.add(nums[j]);
            }
        }
        return new ArrayList<>(resultSet);
    }

    /*
        ** Time Complexity: O(n^2*nlogn)
        ** Space Complexity: O(1)
     */
    private static List<List<Integer>> optimalApproach(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
        List<List<Integer>> resultSet = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            int j=i+1, k=nums.length-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    List<Integer> triplet = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                    resultSet.add(triplet);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        return resultSet;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = bruteForce(nums);
        System.out.println("Brute Force Result: ");
        printResult(result);
        result = betterApproach(nums);
        System.out.println("Better Approach Result: ");
        printResult(result);
        result = optimalApproach(nums);
        System.out.println("Optimal Approach Result: ");
        printResult(result);
    }

    private static void printResult(List<List<Integer>> result ) {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> triplet : result) {
            sb.append(triplet).append("\n");
        }
        System.out.println(sb);
    }
}
