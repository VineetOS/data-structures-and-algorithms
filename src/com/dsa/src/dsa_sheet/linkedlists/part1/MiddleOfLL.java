package com.dsa.src.dsa_sheet.linkedlists.part1;

public class MiddleOfLL {
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

    public Node middleOfLL(){
        if(head == null || head.next == null) return head;
        Node fast = head;
        Node slow = head;
        while(fast !=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        MiddleOfLL ll = new MiddleOfLL();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addFirst(3);
        ll.addLast(54);
        ll.addLast(35);
        ll.addLast(28);
        ll.addFirst(10);
        ll.printList();
        System.out.println();
        Node middle = ll.middleOfLL();
        System.out.println("Middle node is: "+ middle.data);
    }


}
