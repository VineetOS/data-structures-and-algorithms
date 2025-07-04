package com.dsa.src.dsa_sheet.linkedlists;


public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    public Node(){}

    // Append a new node at the end of the list
    public void append(int data) {
        Node temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    // Print the linked list
    public void printList() {
        Node temp = this;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int getData(){
        Node temp = this;
        return temp.data;
    }

    public Node getNext(){
        Node temp = this;
        return temp.next;
    }

    public Node reverse(){
        Node head = this;
        if(head.next == null) return head;

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
        return head;
    }

    public void setData(int data){
        this.data = data;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public int size(){
        Node temp = this;
        int res = 0;
        while(temp != null){
            res++;
            temp = temp.next;
        }
        return res;
    }

    public static Node getNode(Node head, int val) {
        if(head==null)
            return null;
        while(head.data != val) head = head.next;

        return head;
    }
}
