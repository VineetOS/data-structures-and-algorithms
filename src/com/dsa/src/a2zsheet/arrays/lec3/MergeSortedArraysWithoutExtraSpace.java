package com.dsa.src.a2zsheet.arrays.lec3;

import java.util.Arrays;

public class MergeSortedArraysWithoutExtraSpace {

    private static void mergeSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int len = n+m;
        int gap = (len/2) + (len%2);
        while(gap>0){
            int left = 0;
            int right = gap;
            while(right < len){
                if(right < n && left < n) {
                    // Both indices are in arr1
                    if(arr1[left] > arr1[right]) {
                        swap(arr1, arr1, left, right);
                    }
                } else if(left < n && right >= n) {
                    // left is in arr1 and right is in arr2
                    if(arr1[left] > arr2[right - n]) {
                        swap(arr1, arr2, left, right - n);
                    }
                } else {
                    // Both indices are in arr2
                    if(arr2[left - n] > arr2[right - n]) {
                        swap(arr2, arr2, left - n, right - n);
                    }
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap/2) + (gap%2);
        }
    }

    private static void mergeSortedArraysOptimal1(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        // Start from the end of first array and start of second array
        int left = n - 1;
        int right = 0;
        while (left>=0 && right<m){
            if(arr1[left] > arr2[right]) {
                // If the current element in arr1 is greater than the current element in arr2,
                // swap them
                swap(arr1, arr2, left, right);
                left--;
                right++;
            }else break;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        mergeSortedArraysOptimal1(arr1, arr2);
        System.out.print("Merged Array Optimal Approach 1: ");
        printMergedArrays(arr1, arr2);

        int[] arr3 = {1, 3, 5, 7};
        int[] arr4 = {2, 4, 6, 8};

        mergeSortedArrays(arr3, arr4);
        System.out.print("Merged Array Optimal Approach 2: ");
        printMergedArrays(arr3, arr4);

    }

    private static void swap(int[] arr1, int[] arr2, int i, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }

    private static void printMergedArrays(int[] arr1, int[] arr2) {
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
