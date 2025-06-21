package com.dsa.src.linkedlists.cycle;

import java.util.HashMap;
import java.util.Map;

public class StartOfCycle {
    Node head;
    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next !=null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList(){
        if(head == null) {
            System.out.print("The linked list is empty");
            return;
        }
        Node currNode = head;
        while (currNode !=null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.print("NULL");
    }

    public void createCycle(int pos) {
        if (pos < 0) return;

        Node temp = head, cycleNode = null;
        int index = 0;
        while (temp.next != null) {
            if (index == pos) {
                cycleNode = temp;
            }
            temp = temp.next;
            index++;
        }
        if (cycleNode != null) {
            temp.next = cycleNode;
        }
    }


    public Node cycleStartBrute(){
        Map<Node, Integer> store = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            if(store.containsKey(temp)) return temp;
            store.put(temp, 1);
            temp = temp.next;
        }
        return null;

    }

    public Node cycleStartOptimal(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next !=null){
            slow =slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return null;
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast=fast.next;
        }
        return fast;
    }


    public static void main(String[] args) {
        StartOfCycle ll = new StartOfCycle();
        ll.addLast(3);
        ll.addLast(5);
        ll.addLast(10);
        ll.addLast(21);
        ll.addLast(54);
        ll.addLast(100);
        ll.addLast(345);
        ll.addLast(1000);
        ll.createCycle(5);
        System.out.println("Brute force: "+ ll.cycleStartBrute().data);
        System.out.println("Optimal force: "+ ll.cycleStartOptimal().data);


    }

}
