package com.dsa.src.linkedlists.part3;

import com.dsa.src.linkedlists.Node;

public class RotateALinkedlist {

    private static int lengthOfLL(Node head){
        if(head==null) return 0;
        int n=0;
        while(head!=null){
            n++;
            head = head.getNext();
        }
        return n;
    }

    private static Node bruteForce(Node list, int k){
        k = k % lengthOfLL(list);
        if(list == null || list.getNext() == null || k==0) return list;
        Node slow = list, fast=list;


        for(int i=0; i<k; i++){
            fast= fast.getNext();
        }
        while(fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext();
        }
        Node newHead = slow.getNext();
        slow.setNext(null);
        fast.setNext(list);
        return newHead;
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.append(2);
        list1.append(3);
        list1.append(4);
        list1.append(5);
        System.out.println("List: ");
        list1.printList();
        list1 = bruteForce(list1, 100);
        System.out.println("Brute: ");
        list1.printList();


    }
}
