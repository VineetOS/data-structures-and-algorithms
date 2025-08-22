package com.dsa.src.miscellanous.stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DailyTemperatures {

    static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && temperatures[stack.peekFirst()] <= temperatures[i]) stack.pollFirst();

            if(stack.isEmpty()) result[i] = 0;
            else result[i] = stack.peekFirst() - i;
            stack.offerFirst(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temperatures);
        for (int days : result) {
            System.out.print(days + " ");
        }
    }
}
