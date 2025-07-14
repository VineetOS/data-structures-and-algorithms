package com.dsa.src.a2zsheet.arrays.lec3;

public class MaxProductSubArray {

    private static int optimalApproach1(int[] arr) {
        int n= arr.length;
        int maxProduct = Integer.MIN_VALUE;
        int prevProduct = 1, suffixProduct = 1;
        for (int i = 0; i < n; i++) {
            if (prevProduct == 0) prevProduct = 1; // Reset if product becomes zero
            if (suffixProduct == 0) suffixProduct = 1; // Reset if product becomes zero
            prevProduct *= arr[i];
            suffixProduct *= arr[n - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(prevProduct, suffixProduct));
        }
        return maxProduct;
    }

    private static int bruteForce(int[] arr) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int currentProduct = 1;
            for (int j = i; j < arr.length; j++) {
                currentProduct *= arr[j];
                maxProduct = Math.max(maxProduct, currentProduct);
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, -1, 4,0, -6, 3, -2, 6};
        System.out.println("Maximum product subarray: " + bruteForce(arr));
        System.out.println("Maximum product subarray using optimal approach: " + optimalApproach1(arr));
    }
}
