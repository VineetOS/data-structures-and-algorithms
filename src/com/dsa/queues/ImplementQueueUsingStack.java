package com.dsa.queues;

import java.util.Stack;

public class ImplementQueueUsingStack {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    //use two stacks
    //push operation - transfer all elements from s1 -> s2
    //push new element to s1
    //push all elements from s2 -> s1


    //input stack, output stack
    public void push(int n){
        input.push(n);
    }

    public int top(){
        if(!output.isEmpty()) return output.peek();
        for(var i: input){
            output.push(i);
        }
        return output.peek();
    }

    public void pop(){
        if(!output.isEmpty())  output.pop();
        for(var i: input){
            output.push(i);
        }
        output.pop();
    }



}
