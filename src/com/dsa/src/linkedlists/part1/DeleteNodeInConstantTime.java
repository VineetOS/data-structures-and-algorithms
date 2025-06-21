package com.dsa.src.linkedlists.part1;

import com.dsa.src.linkedlists.Node;

import static com.dsa.src.linkedlists.Node.getNode;

public class DeleteNodeInConstantTime {

    private static void optimalApproach(Node deleteNode){
        Node temp = deleteNode.getNext();
        while(temp.getNext() != null){
            deleteNode.setData(temp.getData());
            temp = temp.getNext();
            deleteNode = deleteNode.getNext();
        }
        deleteNode.setData(temp.getData());
        deleteNode.setNext(null);
    }


    public static void main(String[] args) {
        Node list = new Node(2);
        list.append(4);
        list.append(6);
        list.append(8);
        list.append(9);
        list.append(10);
        list.append(12);

        System.out.println("List:");
        list.printList();

        Node deleteNode = getNode(list, 6);

        optimalApproach(deleteNode);

        System.out.println("Updated List:");
        list.printList();
    }
}
