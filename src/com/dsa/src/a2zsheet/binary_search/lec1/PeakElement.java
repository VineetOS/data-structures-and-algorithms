package com.dsa.src.a2zsheet.binary_search.lec1;

public class PeakElement {

    private static int findPeakElement(int[] arr) {
        int n = arr.length;
        //handle edge cases
        if (n == 1) return arr[0];
        if (arr[0] >= arr[1]) return arr[0];
        if (arr[n - 1] >= arr[n - 2]) return arr[n - 1];

        // Binary search for peak element
        int left = 1, right = n - 2;
        while(left<=right){
            int mid  = left + (right - left) / 2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(arr[mid]<arr[mid-1]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0};
        System.out.println("Peak Element: " + findPeakElement(arr));
    }
}
