package com.dsa.arrays.part2;

import java.util.Arrays;

public class FindDuplicateInArrayOfIntegers {

    public static int findDuplicate(int[] arr){
        int n = arr.length, actualSum, expectedSum;
        expectedSum = (n-1)*((n)/2);
        actualSum = Arrays.stream(arr).sum();
        return actualSum - expectedSum;
    }

    public static void main(String[] args) {
        /*
        Find duplicate in an array of N+1 Integers
         */
        int[] arr = {1,2,3,4,5,6,9,7};
        System.out.print(findDuplicate(arr));

    }
}
