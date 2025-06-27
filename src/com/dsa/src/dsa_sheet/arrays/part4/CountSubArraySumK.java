package com.dsa.src.dsa_sheet.arrays.part4;

import java.util.HashMap;
import java.util.Map;

public class CountSubArraySumK {

    private static int betterApproach(int[] arr, int k){
        int n=arr.length, res=0;
        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=i; j<n; j++){
                sum+=arr[j];
                if(sum==k)
                    res++;
            }
        }
        return res;
    }

    private static int optimalAproach(int[] arr, int k){
        Map<Integer,Integer> storeMap = new HashMap<>();
        int count=0, preSum=0;
        storeMap.put(0,1);
        for(int i: arr){
            preSum += i;
            if(storeMap.containsKey(preSum-k))
                count+=storeMap.get(preSum-k);
            storeMap.put(preSum, storeMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,-3,1,1, 1,4, 2, 4,-3};
        int k=3;
        System.out.println("Better Approach: "+ betterApproach(arr,k));
        System.out.println("Optimal Approach: "+ optimalAproach(arr,k));
    }
}
