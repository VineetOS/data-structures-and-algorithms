package com.dsa.src.leetcode.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementN2 {

    private static int bruteForce(int[] nums){
        /*
        space complexity: O(N)
        time complexity: O(N)
         */

        Map<Integer, Integer> numberFrequencyMap = new HashMap<>();
        for(int i: nums) {
            if (numberFrequencyMap.containsKey(i)) {
                var count = numberFrequencyMap.get(i) + 1;
                if(count> nums.length/2) return i;
                numberFrequencyMap.put(i, count);
            } else {
                numberFrequencyMap.put(i, 1);
            }
        }
        return 0;
    }

    private static int sortingApproach(int[] nums){
        /*
        space complexity: O(1)
        time complexity: O(NlogN)
         */


        nums = Arrays.stream(nums).sorted().toArray();
        //since majority element is more than n/2 times
        //hence, majority element will always be the central element
        return nums[nums.length/2];
    }

    private static int mooreVotingAlgorithm(int[] nums){
        int majorityElement = nums[0], votes = 1;
        for(int i=1; i<nums.length; i++){
            if(votes == 0) {
                votes++;
                majorityElement = nums[i];
            }
            else if(nums[i] == majorityElement) votes++;
            else votes--;

        }
        return majorityElement;
    }


    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println("Brute Force Approach Majority Element: "+ bruteForce(nums));
        System.out.println("Sorting Approach Majority Element: "+ sortingApproach(nums));
        System.out.println("Moore's Voting Algorithm Majority Element: "+ mooreVotingAlgorithm(nums));

    }
}
