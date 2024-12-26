package com.dsa.leetcode.day1;

public class RemoveDuplicates2 {
    private static int removeDuplicates(int[] nums){
        int k=2;
        if(nums.length<=2) return nums.length;
        for(int i=2; i<nums.length; i++){
            if(nums[i] != nums[k-2]){
                nums[k] = nums[i];
                k++;
            }
        }
        printArray(nums,k);
        return k;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,2,3,3,3,4,4,4,4,5,5,5};
        System.out.println("Length of final array: " + removeDuplicates(arr));
    }

    private static void printArray(int[] arr, int length){
        System.out.println("The final array is: ");
        for(int i=0; i<length; i++)
            System.out.print(arr[i] + ", ");
        System.out.println();
    }
}
