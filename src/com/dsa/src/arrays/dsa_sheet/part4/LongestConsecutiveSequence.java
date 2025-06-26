package com.dsa.src.arrays.dsa_sheet.part4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    private static int betterApproach(int[] a){
        a = Arrays.stream(a).sorted().toArray();
        int res=0, count=0, currentSmallest= Integer.MIN_VALUE;
        for(int i:a){
            if(currentSmallest+1==i){
                count++;
                currentSmallest=i;
            }else if(currentSmallest!=i){
                count=1;
                currentSmallest=i;
            }
            res = Math.max(res,count);
        }
        return res;
    }

    private static int optimal(int[] a){
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int i:a){
            set.add(i);
        }
        for(int i: set){
            if(!set.contains(i-1)){
                int cnt=1;
                while(set.contains(i+cnt)){
                    cnt++;
                }
                res = Math.max(cnt, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 204, 1, 2,2,2, 3,3,3, 4, 5, 5, 6, 7, 8, 9, 100, 101,101, 102};
        System.out.println("Better Approach: "+ betterApproach(a));
        System.out.println("Optimal Approach: "+ optimal(a));
    }
}
