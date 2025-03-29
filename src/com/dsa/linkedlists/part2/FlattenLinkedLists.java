package com.dsa.linkedlists.part2;

import com.dsa.linkedlists.HighNode;

import java.util.ArrayList;
import java.util.List;

public class FlattenLinkedLists {

    private static HighNode bruteForce(HighNode head){
        return null;
    }

    public static void main(String[] args) {
        HighNode head = prepareLL();
        head.printList();
        head.printParentList();
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
