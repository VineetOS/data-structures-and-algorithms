package com.dsa.linkedlists.part1;



public class ReverseLinkedList {

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


    // Function to reverse a linked list
    // using the 3-pointer approach
    public void reverseLinkedListIterative() {
        if(head == null || head.next == null) return;

        Node prev = head;
        Node curr = head.next;

        // Traverse the list, continue till
        // 'temp' reaches the end (NULL)
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        head.next = null;
        head = prev;
    }

    public Node reverseRecursive(Node head){
        if(head == null || head.next == null) return head;
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ReverseLinkedList ll = new ReverseLinkedList();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addFirst(3);
        ll.printList();
        ll.head = ll.reverseRecursive(ll.head);
        ll.printList();

    }


}
