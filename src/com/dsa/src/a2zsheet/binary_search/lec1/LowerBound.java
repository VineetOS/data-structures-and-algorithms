package com.dsa.src.a2zsheet.binary_search.lec1;

public class LowerBound {

    private static int lowerBound(int[] arr, int target){
        int left = 0, right = arr.length -1;
        int result = -1; // Initialize result to -1 to indicate not found
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(arr[mid] >= target){ // Check for lower bound condition
                result = mid; // Update result to current mid
                right = mid - 1; // Move left to find a potentially smaller index
            } else {
                left = mid + 1; // Move right to find a larger value
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 2;
        int result = lowerBound(arr, target);
        if (result != -1) {
            System.out.println("Lower bound of " + target + " is at index: " + result);
        } else {
            System.out.println("No lower bound found for " + target);
        }
    }
}
