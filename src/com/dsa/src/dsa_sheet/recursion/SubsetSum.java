package com.dsa.src.dsa_sheet.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SubsetSum {

    private static List<Integer> calculateSubsetSum(int[] nums){
        List<Integer> ans = new ArrayList<>();
        subsetSumHelper(0, nums, ans,0);
        Collections.sort(ans);
        return ans;
    }

    private static void subsetSumHelper(int ind, int[] nums , List<Integer> ans, int sum){
        if(ind == nums.length){
            ans.add(sum);
            return;
        }
        //every index has 2 options
        subsetSumHelper(ind + 1, nums, ans, sum + nums[ind]);
        //element is not picked
        subsetSumHelper(ind + 1, nums, ans, sum);

    }

    public static void main(String[] args) {
        int[] nums = {3,1,4};
        List<Integer> ans = calculateSubsetSum(nums);
        System.out.print("Subset sums: ");
        System.out.print(ans.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
