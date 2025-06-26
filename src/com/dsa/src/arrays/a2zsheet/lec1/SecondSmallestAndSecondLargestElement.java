package com.dsa.src.arrays.a2zsheet.lec1;

public class SecondSmallestAndSecondLargestElement {

    private static int[] optimalApproach(int[] arr) {
        int secondSmallest = Integer.MAX_VALUE, secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE;

        for(int i: arr){
            if(i< smallest){
                secondSmallest = smallest;
                smallest = i;
            } else if(i < secondSmallest && i != smallest) {
                secondSmallest = i;
            }

            if(i> largest){
                secondLargest = largest;
                largest = i;
            } else if(i > secondLargest && i != largest) {
                secondLargest = i;
            }
        }

        return new int[]{secondSmallest, secondLargest};
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 1,3,3,34, 10, 34, 1};
        int [] result = optimalApproach(arr);
        System.out.println("Second Smallest Element: " + result[0]);
        System.out.println("Second Largest Element: "+ result[1] );

    }
}
