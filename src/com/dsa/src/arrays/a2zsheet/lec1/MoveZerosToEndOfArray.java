package com.dsa.src.arrays.a2zsheet.lec1;

public class MoveZerosToEndOfArray {

    private static void moveZerosToEnd(int[] arr) {
        if(arr.length<2) return;
        int nonZeroIndex = 0, i=0;
        while(i<arr.length){
            if(arr[i] != 0) {
                arr[nonZeroIndex++] = arr[i];
            }
            i++;
        }
        while(nonZeroIndex < arr.length) {
            arr[nonZeroIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3,0 ,0,11,45,678,0,0,0,0,5,6,7854,0,0,0,0,0,0,0,0,0,0 };
        System.out.println("Original Array:");
        printArray(arr);
        moveZerosToEnd(arr);
        System.out.println("Array after moving zeros to the end:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
