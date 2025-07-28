package com.dsa.src.a2zsheet.binary_search.lec1;

public class SearchInRotatedArray {

    private static int searchInRotatedArray(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) {
                return mid; // Target found
            }
            if(arr[low]<=arr[mid])
                if(arr[low]<=target && target<=arr[mid]) high = mid - 1; // Target is in the left sorted part
                else low = mid + 1; // Target is in the right part
            else
                if(arr[mid]<=target && target<=arr[high]) low = mid + 1; // Target is in the right sorted part
                else high = mid - 1; // Target is in the left part
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int target = 9;
        int result = searchInRotatedArray(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
