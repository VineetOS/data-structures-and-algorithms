package com.dsa.src.miscellanous.sliding_window;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxValueInEachSlidingWindowK {

    static int[] maxValueInSlidingWindow(int[] a, int k){
        if(a.length==0 || k>a.length) return new int[0];
        int n=a.length, index=0;
        int[] ans = new int[n-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0; i<n; i++){
            //remove indices out of the window
            if(!deque.isEmpty() && deque.peekFirst()<=i-k) deque.pollFirst();

            //remove smaller indices from the back
            while(!deque.isEmpty() && a[deque.peekLast()]<a[i]) deque.pollLast();

            deque.offerLast(i);
            if(i>=k-1 && !deque.isEmpty()) ans[index++] = a[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxValueInSlidingWindow(a, k);
        for (int value : result) {
            System.out.print(value + " ");
        }
        // Output: 3 3 5 5 6 7
    }
}
