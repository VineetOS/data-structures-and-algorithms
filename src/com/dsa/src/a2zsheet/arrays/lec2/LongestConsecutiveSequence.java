package com.dsa.src.a2zsheet.arrays.lec2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    private static int bruteForce(int[] arr){
        int longest=1;
        for (int j : arr) {
            int curr = j;
            int count = 1;
            while (linearSearch(arr, curr + 1)) {
                count++;
                curr++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }

    private static int betterApproachSorting(int[] arr){
        Arrays.sort(arr);
        int longest=1, count=1;
        for(int i=1; i<arr.length; i++){
            if(arr[i] == arr[i-1]+1){
                count++;
            }else{
                longest = Math.max(longest,count);
                count=1;
            }
        }
        return longest;
    }

    private static int optimalSetApproach(int[] arr){
        Set<Integer> store = new HashSet<>();
        int longest = 0;
        for(int i: arr) store.add(i);
        for(int i: arr){
            if(!store.contains(i-1)){
                int count=1;
                while(store.contains(i+1)){
                    i++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] arr = {100, 101, 103, 102, 4, 6, 5, 105, 104, 2, 1000, 3};
        System.out.println("Brute approach: "+ bruteForce(arr));
        System.out.println("Better Approach: "+ betterApproachSorting(arr));
        System.out.println("Optimal Approach: "+ optimalSetApproach(arr));
    }

    public static boolean linearSearch(int []a, int num) {
        for (int j : a) {
            if (j == num)
                return true;
        }
        return false;
    }
}
