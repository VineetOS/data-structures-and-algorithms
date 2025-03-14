package com.dsa.linkedlists;
public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

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
}
