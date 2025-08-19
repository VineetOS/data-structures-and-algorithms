package com.dsa.src.dsa_sheet.binary.tree;

public class HeightBalancedBinaryTree {

    static boolean isHeightBalanced(TreeNode root){
        int res = recHelper(root);
        return res != -1;
    }

    static int recHelper(TreeNode root){
        if(root==null) return 0;
        int left = recHelper(root.left);
        if(left==-1) return -1;
        int right = recHelper(root.right);
        if(right==-1) return -1;
        if(Math.abs(left-right)>1) return -1;
        return 1 + Math.max(left,right);
    }

    public static void main(String[] args) {

    }
}
