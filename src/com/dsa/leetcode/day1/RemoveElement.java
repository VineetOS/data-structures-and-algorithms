package com.dsa.leetcode.day1;

public class RemoveElement {

    private static int removeElement(int[] nums, int val) {
        int k=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] !=val) {
                nums[k] = nums[i];
                k++;
            }

        }
        printArray(nums);
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
    }

    private static void printArray(int[] arr){
        System.out.println("The final array is: ");
        for(int i: arr)
            System.out.print(i + ", ");
        System.out.println();
    }
}
