package com.dsa.linkedlists.part2;

import com.dsa.linkedlists.Node;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {


    private static Node approach1(Node list1, Node list2){
        Set<Node> nodeSet = new HashSet<>();
        while(list1 != null){
            nodeSet.add(list1);
            list1 = list1.getNext();
        }
        while(list2 != null){
            if(nodeSet.contains(list2)){
                return list2;
            }
            list2 = list2.getNext();
        }
        //there is no Y intersection
        return null;
    }

    private static Node approach2(Node list1, Node list2){
        int diff = getDifference(list1, list2);
        if(diff>0)
            while(diff-- !=0) list1 = list1.getNext();
        else
            while(diff++ !=0) list2 = list2.getNext();

        while (list1 != null && list2 != null){
            if(list1 == list2) return list2;
            list1 = list1.getNext();
            list2 = list2.getNext();
        }
        return null;
    }

    private static int getDifference(Node list1, Node list2){
        int len1 = 0, len2=0;
        while(list1 != null){
            len1++;
            list1 = list1.getNext();
        }
        while(list2 != null){
            len2++;
            list2 = list2.getNext();
        }
        return len1-len2;
    }

    /*
    Take two dummy nodes for each list. Point each to the head of the lists.
    Iterate over them. If anyone becomes null,
    point them to the head of the opposite lists and continue iterating until they collide.
     */
    private static Node optimalApproach(Node list1, Node list2){
        Node temp1=list1, temp2=list2;
        while(temp1 != null || temp2 !=null){
            if(temp1==null) temp1 = list2;
            if(temp2==null) temp2 = list1;
            if(temp1 == temp2) return temp1;
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }
        return null;

    }

    public static void main(String[] args) {
        var listPair = getList();

        Node intersection1 = approach1(listPair.getKey(), listPair.getValue());
        Node intersection2 = approach2(listPair.getKey(), listPair.getValue());
        Node intersection3 = optimalApproach(listPair.getKey(), listPair.getValue());


        if(intersection1 == null)
            System.out.println("Approach 1: No Intersection Point");
        else
            System.out.println("Approach 1 Intersection Point: "+ intersection1.getData());

        if(intersection2 == null)
            System.out.println("Approach 2: No Intersection Point");
        else
            System.out.println("Approach 2 Intersection Point: "+ intersection2.getData());

        if(intersection3 == null)
            System.out.println("Optimal Approach: No Intersection Point");
        else
            System.out.println("Optimal Approach Intersection Point: "+ intersection3.getData());

    }


    private static AbstractMap.SimpleEntry<Node,Node> getList(){
        Node list1 = new Node(1);
        list1.append(3);
        list1.append(5);

        Node list2 = new Node(2);
        list2.append(4);

        Node common = new Node(100);
        Node temp = common;
        temp.setNext(new Node(101));
        temp = temp.getNext();
        temp.setNext(new Node(102));
        temp = temp.getNext();
        temp.setNext(new Node(103));

        Node tempList1 = list1;
        Node tempList2 = list2;
        while(tempList1.getNext()!=null) tempList1 = tempList1.getNext();
        while(tempList2.getNext()!=null) tempList2 = tempList2.getNext();

        tempList1.setNext(common);
        tempList2.setNext(common);

        System.out.println("List 1:");
        list1.printList();

        System.out.println("List 2:");
        list2.printList();
        return new AbstractMap.SimpleEntry<>(list1,list2);
    }
}
