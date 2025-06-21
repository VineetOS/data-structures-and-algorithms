package com.dsa.src.arrays.sorting;

public class InsertionSort {

    private static void swap(int[] arr, int  i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void insertionSort(int[] arr){
        int n = arr.length;
        for(int i=1; i<n; i++){
            int j=i;
            while(j>0 && arr[j-1]> arr[j]) {
                swap(arr, j-1, j); // Shift larger elements to the right
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
