package com.dsa.src.arrays.a2zsheet.lec1;

public class CheckIfArraySorted {

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 5,7,3};
        boolean result = isSorted(arr);
        System.out.println("Is the array sorted? " + result);
    }
}
