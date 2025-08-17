package com.dsa.src.a2zsheet.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class UniqueuSubsets {

    private static List<List<Integer>> uniqueSubsets(List<Integer> nums){
        List<List<Integer>> ans = new ArrayList<>();
        Collections.sort(nums);
        recursionHelper(nums, 0,new ArrayList<>(), ans);
        return ans;
    }

    //1,2,2,2,3,3
    private static void recursionHelper(List<Integer> nums, int ind, List<Integer> currList, List<List<Integer>> ans){
        ans.add(new ArrayList<>(currList)); //since currList keeps on getting updated, save new ArrayList everytime

        for(int i=ind; i<nums.size(); i++){
            if(i>ind && Objects.equals(nums.get(i), nums.get(i - 1))) continue;
            currList.add(nums.get(i));
            recursionHelper(nums,i+1, currList, ans);
            currList.remove(currList.size()-1); //remove current element added to currList to explore next options
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1,2,2,2,3,3));
        List<List<Integer>> ans = uniqueSubsets(nums);
        System.out.println("Answer: ");
        printHelp(ans);
    }

    static void printHelp(List <List<Integer>>  ans) {
        System.out.println("The unique subsets are ");
        System.out.println(ans.toString().replace(","," "));
    }
}
