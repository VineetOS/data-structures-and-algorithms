package com.dsa.linkedlists.cycle;

import java.util.HashMap;
import java.util.Map;

public class LoopInLL {

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
        System.out.println();
    }

    public boolean isCycleBruteForce(){
        Map<Node, Integer> store = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            if(store.containsKey(temp)) return true;
            store.put(temp, 1);
        }
        return false;
    }

    public boolean isCycleOptimal(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next !=null){
            slow =slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
    public void createLL(){
        head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;
    }

    public static void main(String[] args) {
        LoopInLL ll = new LoopInLL();
        ll.createLL();
        System.out.println("Brute: "+ ll.isCycleBruteForce());

        System.out.println("Optimal: "+ ll.isCycleOptimal());

    }
}
