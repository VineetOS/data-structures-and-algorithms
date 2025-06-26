package com.dsa.src.arrays.a2zsheet.lec1;

public class LeftRotateArrayByOne {

    private static void leftRotateByOne(int[] arr){
        if(arr.length<2) return;
        int firstElement = arr[0];
        for(int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = firstElement;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original Array:");
        printArray(arr);
        leftRotateByOne(arr);
        System.out.println("Array after left rotation by one:");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
