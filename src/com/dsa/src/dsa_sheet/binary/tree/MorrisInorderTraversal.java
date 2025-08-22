package com.dsa.src.dsa_sheet.binary.tree;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {

    static List<Integer> preOrderTraversal(TreeNode head){
        TreeNode curr = head;
        List<Integer> preOrderTraversalList = new ArrayList<>();
        while(curr != null){
            if(curr.getLeft() == null){
                preOrderTraversalList.add(curr.getData());
                curr = curr.getRight();
            }
            else{
                TreeNode prev = curr.getLeft();
                while (prev.getRight()!=null && prev.getRight()!=curr) prev = prev.getRight();

                if(prev.getRight() == null){
                    prev.setRight(curr);
                    preOrderTraversalList.add(curr.getData());
                    curr= curr.getLeft();
                }else{
                    prev.setRight(null);
                    curr = curr.getRight();
                }
            }
        }
        return preOrderTraversalList;
    }

    static List<Integer> inOrderTraversal(TreeNode head){
        TreeNode curr = head;
        List<Integer> inOrderTraversalList = new ArrayList<>();
        while(curr != null){
            if(curr.getLeft() == null){
                inOrderTraversalList.add(curr.getData());
                curr = curr.getRight();
            }
            else{
                TreeNode prev = curr.getLeft();
                while (prev.getRight()!=null && prev.getRight()!=curr) prev = prev.getRight();

                if(prev.getRight() == null){
                    prev.setRight(curr);
                    curr= curr.getLeft();
                }else{
                    prev.setRight(null);
                    inOrderTraversalList.add(curr.getData());
                    curr = curr.getRight();
                }
            }
        }
        return inOrderTraversalList;
    }


    public static void main(String[] args) {
        TreeNode head = buildSampleTree();
        List<Integer> ans = inOrderTraversal(head);
        System.out.println("InOrder Traversal");
        ans.forEach(i -> System.out.print(i + " "));
        ans = preOrderTraversal(head);
        System.out.println("\nPreOrder Traversal");
        ans.forEach(i -> System.out.print(i + " "));

    }

    static TreeNode buildSampleTree() {
        TreeNode n1  = new TreeNode(1);
        TreeNode n2  = new TreeNode(2);
        TreeNode n3  = new TreeNode(3);
        TreeNode n4  = new TreeNode(4);
        TreeNode n5  = new TreeNode(5);
        TreeNode n6  = new TreeNode(6);
        TreeNode n7  = new TreeNode(7);
        TreeNode n8  = new TreeNode(8);
        TreeNode n9  = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        TreeNode n11 = new TreeNode(11);
        TreeNode n12 = new TreeNode(12);
        TreeNode n13 = new TreeNode(13);
        TreeNode n14 = new TreeNode(14);
        TreeNode n15 = new TreeNode(15);

        n1.setLeft(n2);
        n1.setRight(n3);

        n2.setLeft(n4);
        n2.setRight(n5);

        n3.setLeft(n6);
        n3.setRight(n7);

        n4.setLeft(n8);
        n4.setRight(n9);

        n5.setLeft(n10);
        n5.setRight(n11);

        n6.setLeft(n12);
        n6.setRight(n13);

        n7.setLeft(n14);
        n7.setRight(n15);

        return n1;
    }
}
