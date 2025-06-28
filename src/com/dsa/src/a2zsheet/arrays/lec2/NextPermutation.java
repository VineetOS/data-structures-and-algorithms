package com.dsa.src.a2zsheet.arrays.lec2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class NextPermutation {

    private static void nextPermutation(int[] arr){
        int breakpt = -1, n=arr.length;
        for(int i=n-2; i>=0; i--) {
            if (arr[i] < arr[i + 1]) {
                breakpt = i;
                break;
            }
        }

        if(breakpt==-1) {
            reverse(arr,0,n-1);
            return;
        }

        for(int i=n-1; i>breakpt;i-- ) {
            if (arr[i] > arr[breakpt]) {
                swap(arr, i, breakpt);
                reverse(arr, breakpt + 1, n - 1);
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,4,3,0,0};
        nextPermutation(arr);
        for(int i: arr) System.out.print(i+ " ");
    }

    private static void reverse(int[] arr, int left, int right){
        while (left<right){
            swap(arr,left++,right--);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
