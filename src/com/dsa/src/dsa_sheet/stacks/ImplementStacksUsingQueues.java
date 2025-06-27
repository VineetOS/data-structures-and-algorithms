package com.dsa.src.dsa_sheet.stacks;

import com.dsa.src.dsa_sheet.queues.ImplementQueueUsingStack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStacksUsingQueues {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public ImplementStacksUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();

    }

    // Push operation (O(1))
    public void push(int x) {
        queue1.add(x);
    }


    // Pop operation (O(n))
    public int pop() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // Move all elements except last from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // Remove and return the last element
        int poppedElement = queue1.remove();

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return poppedElement;
    }

    // Top operation (O(n))
    public int top() {
        if (queue1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        // Move all elements except last from queue1 to queue2
        while (queue1.size() > 1) {
            queue2.add(queue1.remove());
        }

        // Get the last element
        int topElement = queue1.peek();
        queue2.add(queue1.remove()); // Move it to queue2 as well

        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;

        return topElement;
    }

    // Check if stack is empty (O(1))
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStack stack = new ImplementQueueUsingStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());  // Output: 2
        stack.pop();  // Output: 3
        System.out.println(stack.top());  // Output: 2
        stack.pop() ; // Output: 2
    }

}
