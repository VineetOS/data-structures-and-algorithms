package com.dsa.src.a2zsheet.arrays.lec1;

public class LeftRotateArrayByDPlaces {

    private static void leftRotateByDPlacesMyApproach(int[] arr, int d) {
        if (arr.length < 2 || d <= 0 || d >= arr.length) return;
        //swap the first d elements with the last n-d elements
        for(int i = 0; i < d; i++) {
            swap(arr, i, arr.length - d + i);
        }
        //reverse the first n-d elements
        reverse(arr, 0, arr.length - d - 1);
        //reverse first n - 2d elements
        reverse(arr, 0, arr.length - 2*d-1);
        //reverse middle d elements
        reverse(arr, arr.length - 2*d, arr.length - d - 1);
    }

    private static void leftRotateByDPlaces(int[] arr, int d) {
        if (arr.length < 2 || d <= 0 || d >= arr.length) return;
        // Normalize d to avoid unnecessary rotations
        d %= arr.length;

        // Reverse the first d elements
        reverse(arr, 0, d - 1);
        // Reverse the remaining n-d elements
        reverse(arr, d, arr.length - 1);
        // Reverse the entire array
        reverse(arr, 0, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int d = 3; // Number of places to rotate
        System.out.println("Original Array:");
        printArray(arr);
        leftRotateByDPlaces(arr, d);
        System.out.println("Array after left rotation by " + d + " places:");
        printArray(arr);

        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        leftRotateByDPlacesMyApproach(arr, d);
        System.out.println("Array after left rotation by " + d + " places using my approach:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
