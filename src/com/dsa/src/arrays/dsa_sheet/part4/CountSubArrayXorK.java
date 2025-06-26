package com.dsa.src.arrays.dsa_sheet.part4;

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

    /*
    IMPORTANT POINT:

    Example: 4 2 2 6 4

    if unto element 4 : PreXOR
    from element 1-2 : x
    from element 3-4: subXOR

    then:
        x^subXOR = PreXOR
        (x^subXOR)^subXOR = PreXOR^subXOR
        x = PreXOR^subXOR

        for checking if subArray is having XOR k, replace subXOR -> k
        x = PreXOR^k (similar to PreSum - K)
     */

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
