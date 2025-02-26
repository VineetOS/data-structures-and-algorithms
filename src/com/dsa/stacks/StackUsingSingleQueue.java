package com.dsa.stacks;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingSingleQueue {
    private Queue<Integer> queue;

    public StackUsingSingleQueue() {
        queue = new LinkedList<>();
    }

    // Push operation (O(n))
    public void push(int x) {
        queue.add(x);
        // Move all elements before the last inserted element to the end
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }

    // Pop operation (O(1))
    public int pop() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue.remove();
    }

    // Top operation (O(1))
    public int top() {
        if (queue.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return queue.peek();
    }

    // Check if stack is empty (O(1))
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingSingleQueue stack = new StackUsingSingleQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());  // Output: 3
        System.out.println(stack.top());  // Output: 2
        System.out.println(stack.pop());  // Output: 2
        System.out.println(stack.isEmpty()); // Output: false
    }
}
