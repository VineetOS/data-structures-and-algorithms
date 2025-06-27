package com.dsa.src.a2zsheet.arrays.lec1;

public class SingleNumberFinder {

    private static int findSingleNumber(int[] arr) {
        int singleNumber = 0;
        for (int num : arr) {
            singleNumber ^= num; // XOR operation
        }
        return singleNumber;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println(findSingleNumber(arr));
    }
}
