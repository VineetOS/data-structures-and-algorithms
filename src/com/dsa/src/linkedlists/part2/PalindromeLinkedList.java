package com.dsa.src.linkedlists.part2;

import com.dsa.src.linkedlists.Node;

import java.util.Stack;

public class PalindromeLinkedList {

    /*
    Time Complexity: O(N)
    Space Complexity: O(N)
     */
    private static boolean bruteForce(Node head){
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while (temp!= null){
            stack.push(temp.getData());
            temp = temp.getNext();
        }
        while(head!=null){
            if(stack.peek() != head.getData()) return false;
            stack.pop();
            head = head.getNext();
        }
        return true;
    }

    private static boolean optimalApproach(Node head){
        if(head == null || head.getNext() == null) return true;
        Node slow = head, fast = head;
        //find middle point using tortoise and hare approach
        while(fast.getNext()!= null && fast.getNext().getNext()!=null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        //reverse the second half of the linked list
        slow.setNext(slow.getNext().reverse());

        //iterate through the first and second half to check if all values are same
        Node temp1 = head, temp2 = slow.getNext();
        while(temp1!=null && temp2!=null){
            if(temp1.getData() != temp2.getData()) return false;
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }

        //reverse second half again to get original linked list
        slow.setNext(slow.getNext().reverse());
        return true;

    }

    public static void main(String[] args) {
        Node list = new Node(1);
        list.append(3);
        list.append(5);
        list.append(6);
        list.append(5);
        list.append(3);
        list.append(1);
        System.out.println("List 1: ");
        list.printList();
        System.out.println("Brute force 1: "+ bruteForce(list));
        System.out.println("Optimal 1: "+ optimalApproach(list));


        list.append(10);
        System.out.println("List 2: ");
        list.printList();
        System.out.println("Brute force 2: "+ bruteForce(list));
        System.out.println("Optimal 2: "+ optimalApproach(list));


    }
}
