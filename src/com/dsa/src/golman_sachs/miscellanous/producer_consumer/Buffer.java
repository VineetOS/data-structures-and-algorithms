package com.dsa.src.golman_sachs.miscellanous.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    int capacity;
    Queue<Integer> queue = new LinkedList<>();

    public Buffer(int capacity){
        this.capacity = capacity;
    }

    public synchronized void produce(int val){
        try {
            while (queue.size() == capacity) {
                wait();
            }
        }catch (InterruptedException ex){
            System.out.println("Error occurred while produce.");
        }
        queue.add(val);
        System.out.println("Produced item successfully: "+ val);
        notifyAll();
    }

    public synchronized int consume(){
        try {
            while (queue.isEmpty()){
                wait();
            }
        }catch (InterruptedException ex){
            System.out.println("Error occurred while consume.");
        }
        int val = !queue.isEmpty()?queue.poll():0;
        System.out.println("Consumed item successfully: "+ val);
        notifyAll();
        return val;
    }
}
