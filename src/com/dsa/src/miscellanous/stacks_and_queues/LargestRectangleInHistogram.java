package com.dsa.src.miscellanous.stacks_and_queues;

import java.util.Stack;

public class LargestRectangleInHistogram {

    static int optimalSolution(int[] heights){
        int n=heights.length;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && heights[stack.peek()]>heights[i]){
                int prev = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[prev] * width;
                ans = Math.max(ans, area);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int element = stack.pop();
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int width = n - pse - 1;
            int area = heights[element] * width;
            ans = Math.max(ans, area);
        }
        return ans;
    }

    static int largestRectangleArea(int[] heights){
        int[] pses = previousSmallerElement(heights);
        int[] nses = nextSmallerElement(heights);
        int n = heights.length;
        int maxArea = 0;
        for(int i=0; i<n; i++){
            int width = nses[i] - pses[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    static int[] previousSmallerElement(int[] arr){
        int n= arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();
            if(stack.isEmpty()) result[i] = -1;
            else result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }

    static int[] nextSmallerElement(int[] arr){
        int n=arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) stack.pop();
            if(stack.isEmpty()) result[i] = n;
            else result[i] = stack.peek();
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {3,2,10,11,5,10,6,3};
        int maxArea = largestRectangleArea(heights);
        System.out.println("Largest Rectangle Area: " + maxArea);
        // Output: Largest Rectangle Area: 10
        int maxAreaOptimal = optimalSolution(heights);
        System.out.println("Largest Rectangle Area (Optimal): " + maxAreaOptimal);
    }
}
