package com.dsa.src.dsa_sheet.linkedlists.part1;

public class ReverseDoublyLL {
    Node head;
    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
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
        newNode.prev = currNode;
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


    // Function to reverse a linked list
    // using the 3-pointer approach
    public void reverseLinkedListIterative() {
        if(head == null || head.next == null) return;

        Node prev = null;
        Node curr = head;

        // Traverse the list, continue till
        // 'temp' reaches the end (NULL)
        while(curr != null){
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;
            curr = curr.prev;
        }
        head = prev.prev;
    }



    public static void main(String[] args) {
        ReverseDoublyLL ll = new ReverseDoublyLL();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addFirst(3);
        ll.addLast(50);
        ll.addLast(39);
        ll.printList();
        System.out.println();
        ll.reverseLinkedListIterative();
        ll.printList();

    }

}
