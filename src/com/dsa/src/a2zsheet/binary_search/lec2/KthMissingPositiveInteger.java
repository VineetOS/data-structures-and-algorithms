package com.dsa.src.a2zsheet.binary_search.lec2;

public class KthMissingPositiveInteger {

    private static int bruteForce(int[] arr, int k) {
        for(int i: arr)
            if(i<=k) k++;
            else break;
        return k;
    }

    private static int binarySearch(int[] arr, int k) {
        int left = 0, right = arr.length - 1;
        while(left<=right){
            int mid = left + (right - left)/2;
            int missingCount = arr[mid] - (mid + 1);
            if(missingCount< k) left = mid + 1;
            else right = mid - 1;
        }
        return  k + right + 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int result = bruteForce(arr, k);
        System.out.println("The " + k + "th missing positive integer is: " + result);
        result = binarySearch(arr, k);
        System.out.println("The " + k + "th missing positive integer using binary search is" + ": " + result);
    }
}
