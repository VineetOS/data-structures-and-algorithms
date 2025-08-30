package com.dsa.src.golman_sachs.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;

public class MaxInSubArrayOfSizeK {

    static int[] maxInSubarrayOfSizeK(int[] a, int k){
        //[1, 3, -1, -3, 5, 3, 6, 7]
        // k=3
        int noOfSubArr = a.length -k +1, idx=0;
        int[] ans = new int[noOfSubArr];
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<a.length; i++){
            while(!queue.isEmpty() && queue.peekFirst()<i-k+1) queue.pollFirst();
            while(!queue.isEmpty() && a[queue.peekLast()]<a[i]) queue.pollLast();
            queue.offerLast(i);
            System.out.println(queue);
            if(i>=k-1 && Objects.nonNull(queue.peekFirst())) ans[idx++] = a[queue.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,-2,3,6,7};
        int k = 2;
        System.out.println(Arrays.toString(maxInSubarrayOfSizeK(nums, k)));
    }
}
