package com.dsa.leetcode.day1;

import java.util.Arrays;

public class MergeSortedArrays {

    private static int[] bruteForce(int[] nums1, int m, int[] nums2, int n){
        /*
        time complexity: O(KlogK) where K = m+n
        space complexity: O(1)
         */

        if(n==0) return nums1;
        int p1 = 0, p2 = 0;
        while(p1<m+n && p2<n){
            if(nums1[p1]  == 0){
                nums1[p1] = nums2[p2];
                p2++;
            }
            p1++;
        }
        return Arrays.stream(nums1).sorted().toArray();
    }

    private static int[] optimalApproach(int[] nums1, int m, int[] nums2, int n){
        /*
        time complexity: O(K) where K = m+n
        space complexity: O(1)
         */

        if(n==0) return nums1;
        int p1 = m-1, p2 = n-1, i = m+n-1;
        while(p1>=0 && p2>=0){
            if(nums1[p1] > nums2[p2]){
                //swap
                int temp = nums1[i];
                nums1[i] = nums1[p1];
                nums1[p1] = temp;
                p1--;
            }
            else{
                //swap
                int temp = nums1[i];
                nums1[i] = nums2[p2];
                nums2[p2] = temp;
                p2--;
            }
            i--;
        }
        while (i>=0 && p2>=0){
            nums1[i] = nums2[p2];
            p2--;
            i--;
        }
        return nums1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        int  n=nums2.length, m=nums1.length - n;
        var bruteForceResponse = bruteForce(nums1, m, nums2, n);

        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        nums2 = new int[]{2, 5, 6};
        var optimalApproachResponse = optimalApproach(nums1, m, nums2, n);
        System.out.print("Brute force response: ");
        printArray(bruteForceResponse);
        System.out.print("Optimal Approach response: ");
        printArray(optimalApproachResponse);
    }

    private static void printArray(int[] arr){
        for(int i: arr)
            System.out.print(i + ", ");
        System.out.println();
    }
}
