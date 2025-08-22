package com.dsa.src.miscellanous.stacks_and_queues;

import java.util.Stack;

public class StockSpan {
    static int[] stockSpan(int[] prices){
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> store = new Stack<>();
        for(int i=0; i<n;i++){
            while (!store.isEmpty() && prices[store.peek()] <=prices[i]) store.pop();
            if(store.isEmpty()) span[i] = i+1;
            else span[i] = i- store.peek();
            store.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = stockSpan(prices);
        for (int j : span) {
            System.out.print(j + " ");
        }
    }

}
