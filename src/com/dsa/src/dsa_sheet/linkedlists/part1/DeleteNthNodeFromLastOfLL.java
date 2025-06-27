package com.dsa.src.dsa_sheet.linkedlists.part1;

public class DeleteNthNodeFromLastOfLL {

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

    public void bruteForce(int n){
        if(head==null) return;

        int count = 0;
        Node temp = head;
        while(temp!=null) {
            count++;
            temp = temp.next;
        }
        if(count == n) head = head.next;
        if(n>count) return;

        temp = head;
        int res = count-n;
        while(temp!=null){
            res--;
            if(res==0) break;
            temp = temp.next;
        }
        if(temp !=null)
            temp.next = temp.next.next;

    }

    public void optimalDelete(int n){
        if(head == null) return;
        Node slow = head;
        Node fast = head;
        int pt = n;
        //n=3
        while(fast!=null){
            fast = fast.next;
            pt--;
            if(pt==0) break;
        }

        if(fast==null){
            head = head.next;
            return;
        }

        while(fast.next !=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
    }


    public static void main(String[] args) {
        DeleteNthNodeFromLastOfLL ll = new DeleteNthNodeFromLastOfLL();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addFirst(3);
        ll.addLast(54);
        ll.addLast(35);
        ll.addLast(28);
        ll.printList();
        System.out.println();
        ll.optimalDelete(2);
        ll.printList();

    }


}
