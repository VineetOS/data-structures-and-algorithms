package com.dsa.src.golman_sachs.stacks;

import java.util.Stack;

public class NextGreaterElement {

    static int[] nge(int[] arr){
        int n=arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[i]>=stack.peek()) stack.pop();
            if(stack.isEmpty()) nge[i] = -1;
            else nge[i] = stack.peek();
            stack.push(arr[i]);
        }
        return nge;
    }

    static int[] nse(int[] arr){
        int n=arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!stack.isEmpty() && arr[i]<=stack.peek()) stack.pop();
            if(stack.isEmpty()) nse[i] = -1;
            else nse[i] = stack.peek();
            stack.push(arr[i]);
        }
        return nse;
    }

    static int[] pge(int[] arr){
        int n=arr.length;
        int[] pge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while (!stack.isEmpty() && stack.peek()<=arr[i]) stack.pop();
            if(stack.isEmpty()) pge[i] = -1;
            else pge[i] = stack.peek();
            stack.push(arr[i]);
        }
        return pge;
    }

    static int[] pse(int[] arr){
        int n=arr.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while (!stack.isEmpty() && stack.peek()>=arr[i]) stack.pop();
            if(stack.isEmpty()) pse[i] = -1;
            else pse[i] = stack.peek();
            stack.push(arr[i]);
        }
        return pse;
    }

    public static void main(String[] args) {

    }
}
