package com.dsa.src.a2zsheet.arrays.lec2;

public class KadaneAlgorithm {

    private static int maxSubArraySum(int[] arr) {
        int currSum = 0;
        int maxSum = 0;
        for (int j : arr) {
            currSum += j;
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
}

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArraySum(arr));
    }
}
