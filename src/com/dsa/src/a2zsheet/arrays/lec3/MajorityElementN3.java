package com.dsa.src.a2zsheet.arrays.lec3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementN3 {

    private static int[] extendedBoyerMooreVotingAlgorithm(int[] arr) {
        int n = arr.length, count1 = 0, count2 = 0, candidate1 = -1, candidate2 = -1;
        for(int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        // Verify the candidates
        count1 = 0; count2 = 0;
        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        if(count1 > n / 3 && count2 > n / 3) {
            return new int[]{candidate1, candidate2}; // Both candidates are valid majority elements
        } else if (count1 > n / 3) {
            return new int[]{candidate1}; // Only candidate1 is a valid majority element
        } else if (count2 > n / 3) {
            return new int[]{candidate2}; // Only candidate2 is a valid majority element
        }
        return new int[]{-1,-1}; // No majority elements found
    }

    private static int[] findMajorityElementFrequencyApproach(int[] arr) {
        int n = arr.length, resIndex=0;
        int majorityCount = n / 3;
        int[] result = new int[2]; // To store the two majority elements
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num,0) + 1); // Increment the count for the number
            if(countMap.containsKey(num) && countMap.get(num) > majorityCount && resIndex<2) {
                 result[resIndex++] = num; // If the number already has a count greater than or equal to majorityCount, add it to result
            }
        }
        return result; // If no majority element found
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 3, 3, 5, 3, 5, 5, 5, 3, 3, 3, 13, 3, 5};
        System.out.println("Majority Element Frequency Approach: " + Arrays.toString(findMajorityElementFrequencyApproach(arr)));
        System.out.println("Majority Element Extended Boyer-Moore Voting Algorithm: " + Arrays.toString(extendedBoyerMooreVotingAlgorithm(arr)));
    }
}
