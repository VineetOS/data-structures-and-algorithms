package com.dsa.src.golman_sachs.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfDataStream {

    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;
    
    public MedianOfDataStream(){
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightHeap = new PriorityQueue<>();
    }

    public void addNum(int val){
        if(leftHeap.isEmpty() || val<=leftHeap.peek()) leftHeap.offer(val);
        else rightHeap.offer(val);
        
        if(rightHeap.size() > leftHeap.size() +1) leftHeap.add(rightHeap.poll());
        else if(leftHeap.size() > rightHeap.size() + 1) rightHeap.add(leftHeap.poll());
    }

    public double findMedian(){
        if((leftHeap.size() + rightHeap.size())%2 == 0)
            return leftHeap.peek()!=null && rightHeap.peek()!=null?  (((double)leftHeap.peek() + (double)rightHeap.peek())/2.0): 0;
       else
           if(leftHeap.size()> rightHeap.size()) return (double) leftHeap.peek();
           else if(rightHeap.peek()!=null) return (double) rightHeap.peek();
       return 0;
    }

}
