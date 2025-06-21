package com.dsa.src.linkedlists.part1;

import com.dsa.src.linkedlists.Node;

public class AddTwoNumbersAsLinkedLists {


    /*
    Time Complexity: O(Max(N,M))
    Space Complexity: O(Max(N,M))
     */
    private static Node betterApproach(Node num1, Node num2){
        if((num1 == null && num2 == null) || num1 != null && num2==null ) return num1;
        else if(num1==null) return num2;
        int carry = 0;
        Node dummy = new Node(-1);
        Node temp = dummy;
        while(num1 != null || num2 != null || carry==1){
            int sum=0;
            if(num1!=null) {
                sum+=num1.getData();
                num1 = num1.getNext();
            }
            if(num2!=null) {
                sum += num2.getData();
                num2 = num2.getNext();
            }
            sum+=carry;
            temp.setNext(new Node(sum%10));
            temp = temp.getNext();
            carry = sum/10;
        }
        return dummy.getNext();
    }



    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.append(3);
        list1.append(5);

        Node list2 = new Node(2);
        list2.append(4);
        list2.append(8);

        System.out.println("List 1:");
        list1.printList();

        System.out.println("List 2:");
        list2.printList();

        Node addedList = betterApproach(list1, list2);

        System.out.println("Merged List:");
        addedList.printList();
    }
}
