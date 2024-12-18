package com.dsa.arrays;

public class DuplicateInArrayOfIntegers {

    private static int findDuplicateInteger(int[] arr){
        int n= arr.length, originalSum=0, expectedSum = (n*(n-1))/2;
        for(int i: arr) originalSum+=i;
        return originalSum - expectedSum;
    }
    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};
        System.out.println(findDuplicateInteger(arr));
    }
}
