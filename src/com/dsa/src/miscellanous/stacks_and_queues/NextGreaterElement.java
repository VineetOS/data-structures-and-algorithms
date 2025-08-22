package com.dsa.src.miscellanous.stacks_and_queues;

import java.util.Stack;

public class NextGreaterElement {

    static int[] nextGreaterElement(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek()<=arr[i]) stack.pop();

            if(stack.isEmpty()) result[i] = -1;
            else result[i] = stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    static int[] nextSmallerElement(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0; i--){
            while(!stack.isEmpty() && stack.peek()>=arr[i]) stack.pop();

            if(stack.isEmpty()) result[i] = -1;
            else result[i] = stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

    static int[] previousSmallerElement(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && stack.peek()>=arr[i]) stack.pop();

            if(stack.isEmpty()) result[i] = -1;
            else result[i] = stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

}
