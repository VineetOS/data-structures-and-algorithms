package com.dsa.linkedlists.part1;

import com.dsa.linkedlists.Node;

public class MergeSortedLinkedLists {

    /*
    Time Complexity: O(N+M)
    Space Complexity: O(1)
    We are  not using extra space here, just changing the links
     */
    private static Node optimalApproach(Node list1, Node list2){
        if(list1.size() == 0 && list2.size()==0 || list2.size()==0) return list1;
        else if(list1.size()==0 && list2.size()>0) return list2;
        Node dummyNode = new Node(-1);
        Node temp = dummyNode;
        while(list1 != null || list2!=null){
            if( list2 == null ||
                    (list1 != null && list1.getData()<list2.getData())){
                temp.setNext(list1);
                list1 = list1.getNext();
            }
            else {
                temp.setNext(list2);
                list2 = list2.getNext();
            }
            temp = temp.getNext();
        }
        return dummyNode.getNext();
    }

    public static void main(String[] args) {
        Node list1 = new Node(1);
        list1.append(3);
        list1.append(3);
        list1.append(4);
        list1.append(4);
        list1.append(5);

        Node list2 = new Node(2);
        list2.append(4);
        list2.append(6);
        list2.append(7);
        list2.append(8);

        System.out.println("List 1:");
        list1.printList();

        System.out.println("List 2:");
        list2.printList();

        Node mergedList = optimalApproach(list1, list2);

        System.out.println("Merged List:");
        mergedList.printList();
    }
}
