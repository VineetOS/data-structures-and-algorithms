package com.dsa.src.arrays.a2zsheet.lec1;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {

    //The union of two arrays can be defined as the common and distinct elements in the two arrays.
    //NOTE: Elements in the union should be in ascending order.

    private static int[] findUnion(int[] arr1, int[] arr2){
        int n = arr1.length, m = arr2.length, lastElement = -1;
        List<Integer> unionList = new ArrayList<>();
        int i = 0, j = 0;
        while(i<n && j<m){
            if(arr1[i] == arr2[j] && arr1[i] != lastElement) {
                unionList.add(arr1[i]);
                lastElement = arr1[i];
                i++;
                j++;
            }else if(arr1[i]< arr2[j]){
                if(arr1[i] != lastElement) {
                    unionList.add(arr1[i]);
                    lastElement = arr1[i];
                }
                i++;
            }else{
                if(arr2[j] != lastElement) {
                    unionList.add(arr2[j]);
                    lastElement = arr2[j];
                }
                j++;
            }
        }

        while(i<n){
            if(arr1[i] != lastElement) {
                unionList.add(arr1[i]);
                lastElement = arr1[i];
            }
            i++;
        }

        while(j<m){
            if(arr2[j] != lastElement) {
                unionList.add(arr2[j]);
                lastElement = arr2[j];
            }
            j++;
        }
        return unionList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = {2, 3, 4, 4, 5, 11, 12};

        int[] union = findUnion(arr1, arr2);
        System.out.print("Union of the two sorted arrays: ");
        for (int num : union) {
            System.out.print(num + " ");
        }
    }
}
