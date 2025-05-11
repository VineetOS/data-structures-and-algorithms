package com.dsa.linkedlists.part3;

import com.dsa.linkedlists.NodeRan;

public class CopyListWithNextAndRandomPointer {

    private static NodeRan bruteForce(NodeRan head){
        NodeRan dummy = new NodeRan(-1), temp = head, temp2 = head;
        while(temp != null){
            temp.setNext(temp2.getNext());
            temp = temp.getNext();
            temp2 = temp2.getNext();
        }
        return dummy.getNext();
    }

    public static void main(String[] args) {

    }
}
