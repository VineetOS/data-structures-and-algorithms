package com.dsa.src.a2zsheet.arrays.lec3;

public class CountInversionsInAnArray {

    private static int countInversionBruteForce(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int countInversions(int[] arr, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = countInversions(arr, left, mid) + countInversions(arr, mid + 1, right);
        count += mergeAndCount(arr, left, mid, right);
        return count;
    }

    private static int mergeAndCount(int[] arr, int left, int mid, int right){
        int i=left, j=mid+1, k=0;
        int[] temp = new int[right - left + 1];
        int count = 0;
        while(i<=mid && j<=right){
            if(arr[i]>arr[j]){
                count += (mid - i + 1); // All elements from i to mid are greater than arr[j]
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println("Count of inversions in the array brute force: " + countInversionBruteForce(arr));
        System.out.println("Count of inversions in the array using merge sort: " + countInversions(arr, 0, arr.length - 1));
    }
}
