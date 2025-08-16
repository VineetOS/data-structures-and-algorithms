package com.dsa.src.a2zsheet.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {


    private static List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        recursionHelper(nums, target,0,new ArrayList<>(), ans);
        return ans;
    }

    private static void recursionHelper(int[] nums, int sumLeft, int index, List<Integer> currList , List<List<Integer>> ans){
        if(sumLeft == 0){
            ans.add(new ArrayList<>(currList));
        }else if(sumLeft>0){
            for(int i=index; i<nums.length && nums[i]<=sumLeft; i++){
                if(i>index && nums[i] == nums[i-1]) continue;
                currList.add(nums[i]);
                recursionHelper(nums,sumLeft-nums[i],i+1,currList,ans);
                currList.remove(currList.size()-1);

            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,5,1,1};
        int target = 8;
        List<List<Integer>> ans = combinationSum(nums,target);
        printHelp(ans);
    }

    static void printHelp(List <List<Integer>>  ans) {
        System.out.println("Unique Combinations are as follow: ");
        System.out.println(ans.toString().replace(","," "));
    }
}
