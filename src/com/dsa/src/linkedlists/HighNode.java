package com.dsa.src.linkedlists;

public class HighNode {
    int data;
    HighNode next;
    HighNode child;

    public HighNode(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }

    public HighNode(int data, HighNode next, HighNode child){
        this.data = data;
        this.next = next;
        this.child = child;
    }

    // Print the linked list
    public void printList() {
        // Print the child list
        HighNode parent = this;
        while (parent !=null) {
            HighNode temp = parent;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.child;
            }
            System.out.print(" null");
            System.out.println();
            parent = parent.next;
        }
    }

    public void printParentList(){
        System.out.println("\nThis is the parent list: ");
        HighNode parent = this;
        while (parent !=null) {
            System.out.print(parent.data + " -> ");
            parent = parent.next;
        }
        System.out.print("null");
        System.out.println();

    }

    public int getData(){
        HighNode temp = this;
        return temp.data;
    }

    public HighNode getNext(){
        HighNode temp = this;
        return temp.next;
    }

    public HighNode getChild(){
        HighNode temp = this;
        return temp.child;
    }

    public void setData(int data){
        this.data = data;
    }

    public void setNext(HighNode next){
        this.next = next;
    }

    public void setChild(HighNode child){
        this.child = child;
    }

}
