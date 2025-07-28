package com.dsa.src.a2zsheet.binary_search.lec1;

public class SearchInRotatedArrayWithDuplicates {

    private static int searchInRotatedArrayWithDuplicates(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] == target) return mid; // Target found
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
                continue;
            }

            if(arr[low]<= arr[mid])
                if(arr[low]<=target && target <= arr[mid]) high = mid -1; // Target is in the left sorted part
                else low = mid + 1; // Target is in the right part
            else
                if(arr[mid]<=target && target <= arr[high]) low = mid + 1; // Target is in the right sorted part
                else high = mid - 1; // Target is in the left part
        }
       return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 0, 1, 2};
        int target = 0;
        int result = searchInRotatedArrayWithDuplicates(arr, target);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the array.");
        }
    }
}
