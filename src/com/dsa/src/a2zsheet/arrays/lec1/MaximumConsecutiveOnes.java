package com.dsa.src.a2zsheet.arrays.lec1;

public class MaximumConsecutiveOnes {

    private static int findMaxConsecutiveOnes(int[] arr){
        int maxCount = 0,currentCount = 0;
        for(int num : arr){
            if(num == 1) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(arr));
    }
}
