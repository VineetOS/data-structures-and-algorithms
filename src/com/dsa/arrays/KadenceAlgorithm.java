package com.dsa.arrays;

import java.util.Arrays;
import java.util.List;

public class KadenceAlgorithm {

    private static long kadenceAlgorithmPrintSubArray(int[] arr){
        long maxi = Long.MIN_VALUE; // maximum sum
        long sum = 0;

        int start = 0, n = arr.length;
        int ansStart = -1, ansEnd = -1;
        for (int i = 0; i < n; i++) {

            if (sum == 0) start = i; // starting index

            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;

                ansStart = start;
                ansEnd = i;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }

        //printing the subArray:
        System.out.print("The subArray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");

        if (maxi < 0) maxi = 0;

        return maxi;
    }

    private static long kadenceAlgorithm(int[] arr){
        long sum=0, maxSum= Long.MIN_VALUE;
        for (Integer integer : arr) {
            sum += integer;
            maxSum = Math.max(sum, maxSum);
            sum = Math.max(sum, 0);
        }
        if (maxSum < 0) maxSum = 0;
        return maxSum;

    }

    public static void main(String[] args) {
       int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(kadenceAlgorithm(arr));
        kadenceAlgorithmPrintSubArray(arr);
    }
}

