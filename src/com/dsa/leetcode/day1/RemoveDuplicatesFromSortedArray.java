package com.dsa.leetcode.day1;

public class RemoveDuplicatesFromSortedArray {

    private static int removeDuplicates(int[] arr){
        int currNum = arr[0], lastIndex=0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] != currNum){
                arr[lastIndex+1] = arr[i];
                currNum = arr[i];
                lastIndex++;
            }
        }
        printArray(arr);
        return lastIndex+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3,3,4,4,4,4,5,5,5};
        System.out.println("Length of final array: " + removeDuplicates(arr));
    }

    private static void printArray(int[] arr){
        System.out.println("The final array is: ");
        for(int i: arr)
            System.out.print(i + ", ");
        System.out.println();
    }
}
