package com.dsa.src.a2zsheet.binary_search.lec2;

public class KthMissingPositiveInteger {

    private static int bruteForce(int[] arr, int k) {
        for(int i: arr)
            if(i<=k) k++;
            else break;
        return k;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int result = bruteForce(arr, k);
        System.out.println("The " + k + "th missing positive integer is: " + result);
    }
}
