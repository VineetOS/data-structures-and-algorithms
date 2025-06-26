package com.dsa.src.arrays.a2zsheet.lec1;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromSortedArray {

    private static int[] removeDuplicatesWithoutExtraSpace(int[] arr){
        if(arr.length<2) return arr;
        int i=0, j=1;
        while(j<arr.length){
            if(arr[i] != arr[j]) {
                arr[i+1] = arr[j];
                i++;
            }
            j++;
        }
        i++;
        while(i< arr.length) arr[i++] = 0;
        return arr;
    }

    private static List<Integer> removeDuplicates(int[] arr) {
        List<Integer> res = new ArrayList<>();
        if(arr.length<2 ) {
            for(int i: arr){
                res.add(i);
            }
            return res;
        };
        int currentElement = -1;
        for (int j : arr) {
            if (j != currentElement) {
                res.add(j);
                currentElement = j;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5};
        System.out.println("Result with extra space: ");
        List<Integer> result = removeDuplicates(arr);
        result.forEach(i -> System.out.print(i + " "));
        int[] resultWithoutExtraSpace = removeDuplicatesWithoutExtraSpace(arr);
        System.out.println();
        System.out.println("Result without extra space");
        for(int i: resultWithoutExtraSpace){
            System.out.print(i + " ");
        }
    }

}
