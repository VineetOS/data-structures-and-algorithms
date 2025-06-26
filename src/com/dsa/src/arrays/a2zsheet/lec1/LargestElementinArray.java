package com.dsa.src.arrays.a2zsheet.lec1;

public class LargestElementinArray {

    private static int largestElement(int[] arr){
        int largest = arr[0]; // Assume the first element is the largest
        for(int i: arr){
            largest = Math.max(largest, i); // Compare each element with the current largest
        }
        return largest; // Return the largest element found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int largest = largestElement(arr);
        System.out.println("Largest element in the array is: " + largest);
    }
}
