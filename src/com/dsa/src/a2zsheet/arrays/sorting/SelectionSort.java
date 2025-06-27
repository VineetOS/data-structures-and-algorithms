package com.dsa.src.a2zsheet.arrays.sorting;

public class SelectionSort {

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void insertionSort(int[] arr){
        int n= arr.length;
        for(int i=0; i<n; i++){
            int minIndex = i;
            for(int j=i; j<n; j++)
               if(arr[j] < arr[minIndex])
                   minIndex = j;

            // Swap the found minimum element with the first element
            swap(arr, i, minIndex);
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
