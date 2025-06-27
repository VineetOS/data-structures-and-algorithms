package com.dsa.src.dsa_sheet.linkedlists.part2;

import com.dsa.src.dsa_sheet.linkedlists.HighNode;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class FlattenLinkedLists {

    /*
        Problem Statement: Given a LL with child pointers, flatten the list such that
        all nodes are in a single list in sorted order. Also, it be single list with all child nodes.
        It is given that the child nodes are sorted in ascending order.
     */

    private static HighNode mergeTwoLists(HighNode list1, HighNode list2){
        HighNode dummy = new HighNode(-1);
        HighNode res = dummy;
        while(list1!=null && list2!=null){
            if(list1.getData() < list2.getData()){
                dummy.setChild(list1);
                dummy = list1;
                list1 = list1.getChild();
            }else{
                dummy.setChild(list2);
                dummy = list2;
                list2 = list2.getChild();
            }
            dummy.setNext(null);
        }
        if(list1 == null) {
            dummy.setChild(list2);
        }
        else {
            dummy.setChild(list1);
        }
        return res.getChild();
    }

    /*
        Recursive Approach:
        1. Recursively merge the two lists.
        2. Merge the current node with the merged list.

        Time Complexity: O(N)*O(2M) = O(2*M*N).
        Space Complexity: O(N) for the recursive stack space.
     */
    private static HighNode recursiveApproach(HighNode head){
        if(head == null || head.getNext() == null){
            return head;
        }
        HighNode mergedHead = recursiveApproach(head.getNext());
        return mergeTwoLists(head, mergedHead);
    }

    /*
        Brute Force Approach:
        1. Traverse the list and add all the elements to an array.
        2. Sort the array.
        3. Create a new linked list with the sorted elements.

        Time Complexity: O(N*M)*2 + O(nlogn) for sorting the array where n = N+M.
        Space Complexity: O(N*M)*2 for the array and the new linked list.
     */
    private static HighNode bruteForce(HighNode head){
        List<Integer> arr = new ArrayList<>();
        HighNode temp = head;
        while(temp != null){
            HighNode temp2 = temp;
            while(temp2!=null){
                arr.add(temp2.getData());
                temp2 = temp2.getChild();
            }
            temp = temp.getNext();
        }
        Collections.sort(arr);
        HighNode newHead = new HighNode(arr.get(0));
        temp = newHead;
        for(int i=1; i<arr.size(); i++){
            HighNode temp2 = new HighNode(arr.get(i));
            temp.setChild(temp2);
            temp = temp.getChild();
        }
        return newHead;
    }

    public static void main(String[] args) {
        HighNode head = prepareLL();
        head.printList();
        HighNode bruteRes = bruteForce(head);
        System.out.println("Brute Force result: ");
        bruteRes.printList();
        HighNode recursiveRes = recursiveApproach(head);
        System.out.println("Recursive result: ");
        recursiveRes.printList();
    }

    private static HighNode prepareLL(){
        List<HighNode> childNodeList = new ArrayList<>();
        childNodeList.add(prepareChildList(new int[]{3}));
        childNodeList.add(prepareChildList(new int[]{2,10}));
        childNodeList.add(prepareChildList(new int[]{1,7,11,12}));
        childNodeList.add(prepareChildList(new int[] {4,9}));
        childNodeList.add(prepareChildList(new int[] {5,6,8}));
        HighNode head = childNodeList.get(0);
        HighNode temp = head;
        for(int i=1; i<childNodeList.size()-1; i++ ){
            temp.setNext(childNodeList.get(i));
            temp = temp.getNext();
        }
        return head;
    }

    private static HighNode prepareChildList(int[] arr){
        HighNode child = new HighNode(arr[arr.length-1]);
        for(int i=arr.length-2; i>=0;i--){
            child = new HighNode(arr[i], null, child);
        }
        return child;
    }
}
