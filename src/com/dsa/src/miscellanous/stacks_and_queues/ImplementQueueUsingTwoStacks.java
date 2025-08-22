package com.dsa.src.miscellanous.stacks_and_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class ImplementQueueUsingTwoStacks {

    Deque<Integer> inStack = new ArrayDeque<>();
    Deque<Integer> outStack = new ArrayDeque<>();

    void push(int x){
        // Push element x to the inStack.
        inStack.offerFirst(x);
    }

    Integer pop(){
        // Removes the element from the front of the queue.
        if(outStack.isEmpty()){
            // If outStack is empty, transfer elements from inStack to outStack.
            while(!inStack.isEmpty()){
                outStack.offerFirst(inStack.pollFirst());
            }
        }
        // Now pop the element from outStack.
        return outStack.pollFirst();
    }

    Integer peek(){
        // Removes the element from the front of the queue.
        if(outStack.isEmpty()){
            // If outStack is empty, transfer elements from inStack to outStack.
            while(!inStack.isEmpty()){
                outStack.offerFirst(inStack.pollFirst());
            }
        }
        // Now pop the element from outStack.
        return outStack.peekFirst();}
}
