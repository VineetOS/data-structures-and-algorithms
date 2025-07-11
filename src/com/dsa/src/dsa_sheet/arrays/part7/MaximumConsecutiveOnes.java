package com.dsa.src.dsa_sheet.arrays.part7;

public class MaximumConsecutiveOnes {

    private static int bruteForce(int[] arr){
        int sum=0, maxSum=0;
        for(int i: arr){
            if(i==1) sum++;
            else sum = 0;
            maxSum = Math.max(sum, maxSum);

        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,1,1,0,0,0,1,1,1,1,0,1,1,1,1,1};
        System.out.println("Brute force: "+ bruteForce(arr));
    }
}
