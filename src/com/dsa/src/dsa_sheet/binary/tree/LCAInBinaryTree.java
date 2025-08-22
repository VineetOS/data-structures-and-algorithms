package com.dsa.src.dsa_sheet.binary.tree;

import java.util.Objects;

public class LCAInBinaryTree {

    static TreeNode calculateLCA(TreeNode head, TreeNode p, TreeNode q){
        if(head==null) return null;
        if(head.getData()==p.getData() || head.getData()==q.getData()) return head;
        TreeNode left = calculateLCA(head.left, p, q);
        TreeNode right = calculateLCA(head.right, p, q);
        if(left!=null && right!=null) return head;
        else if(left!=null) return left;
        else return right;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        TreeNode head = TreeNode.buildTree(nodes);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(6);
        System.out.println("LCA is: "+ (Objects.nonNull(calculateLCA(head, p, q)) ? calculateLCA(head, p, q).getData(): null));
    }
}
