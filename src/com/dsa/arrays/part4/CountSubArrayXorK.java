package com.dsa.arrays.part4;

import java.util.HashMap;
import java.util.Map;

public class CountSubArrayXorK {

    private static int betterApproach(int[] arr, int k){
        int n = arr.length, count=0;
        for(int i=0; i<n; i++){
            int xor = 0;
            for(int j=i; j<n; j++){
                xor^=arr[j];
                if(xor==k) count++;
            }
        }
        return count;
    }

    private static int optimalAproach(int[] arr, int k){
        Map<Integer, Integer> storeMap = new HashMap<>();
        int count=0, prefixXor=0;
        storeMap.put(0,1);
        for(int i: arr){
            prefixXor^=i;
            if(storeMap.containsKey(prefixXor^k))
                count+=storeMap.get(prefixXor^k);
            storeMap.put(prefixXor, storeMap.getOrDefault(prefixXor,0)+1);
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
