package com.dsa.src.a2zsheet.arrays.sorting;

public class MergeSort {

    private static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            mergeSort(arr, left, (left + right) / 2); // Sort first half
            mergeSort(arr, (left + right) / 2 + 1, right); // Sort second half
            merge(arr, left, (left + right) / 2, right); // Merge the sorted halves
        }
    }

    private static void merge(int[] arr, int left, int mid, int right ){
        int n1 = mid - left+1, n2 = right - mid, i=left, j=mid+1, k=0;
        int[] L = new int[n1+n2];
        while(n1>0 && n2>0){
            if(arr[i] <= arr[j]){
                L[k++] = arr[i++];
                n1--;
            } else {
                L[k++] = arr[j++];
                n2--;
            }
        }
        if(n1 > 0) {
            while(n1 > 0) {
                L[k++] = arr[i++];
                n1--;
            }
        } else {
            while(n2 > 0) {
                L[k++] = arr[j++];
                n2--;
            }
        }
        // Copy the merged elements back to the original array
        System.arraycopy(L, 0, arr, left, L.length);
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
