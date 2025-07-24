package com.dsa.src.a2zsheet.binary_search.lec1;

public class MinOfSortedRotatedArray {

    private static int findMin(int[] arr) {
        int low = 0, high = arr.length - 1, ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[low] <= arr[mid]) {
                //left part is sorted
                ans = Math.min(ans, arr[low]);
                low = mid + 1; // Move to the right part
            } else {
                //right part is sorted
                ans = Math.min(ans, arr[mid]);
                high = mid - 1; // Move to the left part
            }
        }

        return ans; // This should never be reached if the input is a valid rotated sorted array
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 20, 30, 40, 1, 2, 4};
        int minElement = findMin(arr);
        System.out.println("Minimum element in the sorted rotated array: " + minElement);
    }
}
