package com.dsa.src.a2zsheet.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum1 {

    private static List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        recursionHelper(nums, target,0,new ArrayList<>(),0, ans);
        return ans;
    }

    private static void recursionHelper(int[] nums, int target, int index, List<Integer> currList ,int sum, List<List<Integer>> ans){
        if(sum == target){
            ans.add(new ArrayList<>(currList));
            return;
        }

        for(int i=index; i<nums.length; i++){
            if(i>index && nums[i] == nums[i-1]) continue;
            if(sum+nums[i]<=target){
                currList.add(nums[i]);
                recursionHelper(nums,target,i,currList,sum+nums[i],ans);
                currList.remove(currList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2};
        int target = 2;
        List<List<Integer>> ans = combinationSum(nums,target);
        printHelp(ans);
    }

    static void printHelp(List <List<Integer>>  ans) {
        System.out.println("Unique Combinations are as follow: ");
        System.out.println(ans.toString().replace(","," "));
    }
}
