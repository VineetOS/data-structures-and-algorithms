package com.dsa.src.a2zsheet.arrays.sorting;

public class RecursiveInsertionSort {

    private static void recursiveInsertionSort(int[] arr, int n){
        if(n <= 1) return;
        // Sort the first n-1 elements
        recursiveInsertionSort(arr, n-1);
        int key = arr[n-1];
        int j = n - 2;
        // Insert the last element at its correct position
        while(j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]; // Shift larger elements to the right
            j--;
        }
        arr[j + 1] = key; // Place the key at its correct position
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        recursiveInsertionSort(arr, arr.length);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
