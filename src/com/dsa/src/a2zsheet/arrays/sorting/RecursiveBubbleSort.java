package com.dsa.src.a2zsheet.arrays.sorting;

public class RecursiveBubbleSort {

    private static void recursiveBubbleSort(int[] arr, int n){
        if(n<=1) return;
        // Perform one pass of bubble sort
        for(int i=0; i<n-1; i++){
            if(arr[i]> arr[i+1]){
                swap(arr, i, i+1); // Swap if the current element is greater than the next
            }
        }
        // Recursively call for the remaining elements
        recursiveBubbleSort(arr, n-1);
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90,55};
        recursiveBubbleSort(arr, arr.length);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
