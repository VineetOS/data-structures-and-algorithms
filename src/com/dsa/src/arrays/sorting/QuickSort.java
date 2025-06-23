package com.dsa.src.arrays.sorting;

public class QuickSort {

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low < high) {
            int partitionIndex = partition(arr, low, high); // Partition index after placing the pivot
            quickSort(arr, low, partitionIndex - 1); // Recursively sort the left part
            quickSort(arr, partitionIndex + 1, high); // Recursively sort the right part

        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choosing the last element as pivot
        int i = low - 1; // Pointer for the smaller element
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // If current element is smaller than pivot
                i++; // Increment the index of smaller element
                swap(arr, i, j); // Swap the elements
            }
        }
        swap(arr, i + 1, high); // Place the pivot element in the correct position
        return i + 1; // Return the partition index
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
