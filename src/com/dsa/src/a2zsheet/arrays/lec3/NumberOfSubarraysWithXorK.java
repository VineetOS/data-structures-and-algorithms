package com.dsa.src.a2zsheet.arrays.lec3;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubarraysWithXorK {

    private static int optimalApproach(int[] arr, int k) {
        int count = 0;
        int xor = 0;

        Map<Integer,Integer> preXorStore = new HashMap<>();
        preXorStore.put(xor,1); // Initialize with 0 XOR having one occurrence
        for (int j : arr) {
            xor ^= j;
            if (preXorStore.containsKey(xor ^ k)) {
                count += preXorStore.get(xor ^ k);
            }
            preXorStore.put(xor, preXorStore.getOrDefault(xor, 0) + 1);
        }
        return count;
    }

    private static int bruteForce(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for(int i=0; i<n; i++){
            int xor = 0;
            for(int j=i; j<n; j++){
                xor ^= arr[j];
                if(xor == k){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println("Number of subarrays with XOR " + k + ": " + bruteForce(arr, k));
        System.out.println("Optimal Approach Result: " + optimalApproach(arr, k));
    }
}
