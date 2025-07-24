package com.dsa.src.a2zsheet.binary_search.lec1;

public class CountOccurrencesInSortedArray {

    private static int firstOccurrence(int[] arr, int target){
        int low = 0, high = arr.length-1;
        int res = -1; // Initialize result to -1 to indicate not found
        while(low<=high){
            int mid = low + (high - low) / 2;
            if(arr[mid] == target){
                res = mid;
                high = mid - 1; // Move left to find the first occurrence
            }else if(arr[mid]< target) low = mid + 1;
            else high = mid - 1;
        }
        return res;
    }

    private static int lastOccurrence(int[] arr, int target){
        int low = 0, high = arr.length-1;
        int res = -1; // Initialize result to -1 to indicate not found
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == target) {
                res = mid;
                low = mid + 1; // Move right to find the last occurrence
            }else if(arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return res;
    }

    private static int countOccurrences(int[] arr, int target) {
        int first = firstOccurrence(arr, target);
        if (first == -1) return 0; // Target not found
        int last = lastOccurrence(arr, target);
        return last - first + 1; // Count is last index - first index + 1
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int count = countOccurrences(arr, target);
        System.out.println("Count of " + target + " in the array: " + count);
    }
}
