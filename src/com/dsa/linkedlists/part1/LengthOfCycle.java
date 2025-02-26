package com.dsa.linkedlists.part1;

import java.util.HashMap;
import java.util.Map;

public class LengthOfCycle {
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


    public int lengthBrute(){
        Map<Node, Integer> store = new HashMap<>();
        Node temp = head;
        int timer = 1;
        while(temp!=null){
            if(store.containsKey(temp)) return timer - store.get(temp);
            store.put(temp, timer);
            temp = temp.next;
            timer++;
        }
        return 0;

    }

    public int cycleWithLengthOptimal(){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next !=null){
            slow =slow.next;
            fast = fast.next.next;
            if(slow == fast) return lengthOptimal(slow, fast);
        }
        return 0;
    }

    public int lengthOptimal(Node slow, Node fast){
        if(fast == null) return 0;
        int count=1;
        fast = fast.next;
        while(fast !=slow){
            count++;
            fast= fast.next;
        }
        return count;
    }

    public static void main(String[] args) {
        LengthOfCycle ll = new LengthOfCycle();
        ll.addLast(3);
        ll.addLast(5);
        ll.addLast(10);
        ll.addLast(21);
        ll.addLast(54);
        ll.addLast(100);
        ll.addLast(345);
        ll.addLast(1000);
        ll.createCycle(4);
        System.out.println("Brute force: "+ ll.lengthBrute());
        System.out.println("Optimal force: "+ ll.cycleWithLengthOptimal());


    }
}
