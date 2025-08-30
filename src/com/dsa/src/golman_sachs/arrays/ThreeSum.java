package com.dsa.src.golman_sachs.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    static List<List<Integer>> threeSum(int[] arr, int k){
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n-2; i++){
            if(i!=0 && arr[i]==arr[i-1]) continue;
            int left=i+1, right=n-1;
            while(left<right){
                int temp = arr[i] +arr[left] + arr[right];
                if(temp==k){
                    ans.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    while(left<right && arr[right] == arr[right+1]) right--;
                    while(left<right && arr[left]==arr[left-1]) left++;
                }
                else if(temp>k){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { -1,0,1,2,-1,-4};
        int k=0;
        var ans = threeSum(nums,k);
        for(List<Integer> row: ans) System.out.println(row);
    }
}
