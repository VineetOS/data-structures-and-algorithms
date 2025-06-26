package com.dsa.src.arrays.dsa_sheet.part1;

import java.util.Arrays;

public class SortArrayOf0s1s2s {

    private static int[] sortArray(int[] arr){
        int n = arr.length, zeros = 0, ones = 0, twos = 0;
        for (int j : arr) {
            switch (j) {
                case 0 -> zeros++;
                case 1 -> ones++;
                case 2 -> twos++;
            }
        }

        for(int i=0; i<zeros; i++){
            arr[i] = 0;
        }

        for(int i=zeros; i<zeros+ones; i++){
            arr[i] = 1;
        }

        for(int i=zeros+ones; i<n; i++){
            arr[i] = 2;
        }
        return arr;
    }

    private static int[] dutchNationalFlagAlgorithm(int[] arr){
        int n = arr.length, low = 0, mid = 0, high = n-1;
        while(mid<high){
            if(arr[mid] == 0){
                arr[mid] = arr[low];
                arr[low] = 0;
                low++;
            }
            else if(arr[mid] == 2) {
                arr[mid] = arr[high];
                arr[high] = 2;
                high--;
            }
            mid++;
        }
        return arr;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 0, 1, 1, 0, 2, 2, 1, 0};
        System.out.println(Arrays.toString(sortArray(arr)));
        System.out.println(Arrays.toString(dutchNationalFlagAlgorithm(arr)));
    }
}
