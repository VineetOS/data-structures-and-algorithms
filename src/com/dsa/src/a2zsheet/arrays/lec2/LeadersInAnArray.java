package com.dsa.src.a2zsheet.arrays.lec2;

public class LeadersInAnArray {

    private static void printLeaders(int[] arr){
        int currLeader=-1;
        for(int i=arr.length-1; i>=0;i--){
            if(arr[i]>currLeader){
                currLeader = arr[i];
                System.out.print(currLeader + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 12, 3, 0, 6};
        printLeaders(arr);
    }
}
