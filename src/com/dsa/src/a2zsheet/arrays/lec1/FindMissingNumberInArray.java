package com.dsa.src.a2zsheet.arrays.lec1;

public class FindMissingNumberInArray {

    private static int findMissingNumber(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2; // Sum of first n natural numbers
        int actualSum = 0;
        for (int num : arr) {
            actualSum += num; // Calculate the sum of the elements in the array
        }
        return expectedSum - actualSum; // The difference is the missing number
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5}; // Example array with a missing number
        int n = arr.length + 1; // Since one number is missing, the size should be n+1
        int missingNumber = findMissingNumber(arr, n);
        System.out.println("The missing number is: " + missingNumber);
    }
}
