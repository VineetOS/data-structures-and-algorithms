package com.dsa.linkedlists.part3;

import com.dsa.linkedlists.Node;

public class ReverseNodesInKGroups {

    private static Node reverseNodesInKGroups(Node head, int k){
        if(head == null || k == 1) return head;
        Node dummy = new Node();
        dummy.setNext(head);
        Node curr = dummy, nex, pre = dummy;
        int count=0;
        //find out the length of the linked list
        while(curr.getNext()!=null) {
            count++;
            curr = curr.getNext();
        }

        while (count>=k){
            //this is the core logic
            curr = pre.getNext();
            nex = curr.getNext();
            for(int i=1; i<k; i++){
                //perform this set of actions for all the nodes
                //try to visualise this
                curr.setNext(nex.getNext());
                nex.setNext(pre.getNext());
                pre.setNext(nex);
                nex = curr.getNext();
            }
            pre = curr;
            count-=k;
        }
        return dummy.getNext();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        for(int i=1; i<8; i++) head.append(i+1);
        System.out.println("Input List: ");
        head.printList();
        head = reverseNodesInKGroups(head, 3);
        System.out.println("Output List: ");
        head.printList();

    }

}
