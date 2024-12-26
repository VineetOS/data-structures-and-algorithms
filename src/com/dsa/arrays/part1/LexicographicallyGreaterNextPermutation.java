package com.dsa.arrays.part1;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.*;

public class LexicographicallyGreaterNextPermutation {

    private static void nextPermutation(List<Integer> arr){
        int n = arr.size();
        int breakpoint = -1;
        for(int i=n-2; i>=0; i--){
            if(arr.get(i)<arr.get(i+1)){
                breakpoint = i;
                break;
            }
        }

        /*
            array is in descending order and there is no breakpoint so next permutation
            will be the lowest number, i.e. reverse the array
        */
        if(breakpoint == -1){
            Collections.reverse(arr);
            return;
        }

        for(int i=n-1; i>breakpoint; i--){
            if(arr.get(i)>arr.get(breakpoint)){
                //swap arr[i] and arr[breakpoint]
                int m =  arr.get(i);
                arr.set(i, arr.get(breakpoint));
                arr.set(breakpoint,m);
                break;
            }
        }

        //reverse the entire right half after breakpoint
        List<Integer> subList = arr.subList(breakpoint+1, n);
        Collections.reverse(subList);

    }


    public static void main(String[] args) {
        List<Integer> arr = asList(2, 1, 5, 4, 3, 0, 0);
        nextPermutation(arr);
        arr.forEach(i -> System.out.print(i + " "));
    }


}
