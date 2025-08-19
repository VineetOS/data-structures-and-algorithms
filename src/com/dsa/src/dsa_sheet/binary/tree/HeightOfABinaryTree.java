package com.dsa.src.dsa_sheet.binary.tree;

public class HeightOfABinaryTree {

    static int heightOfABinaryTree(TreeNode root){
        if(root==null) return 0;
        int left = heightOfABinaryTree(root.left);
        int right = heightOfABinaryTree(root.right);
        return 1 + Math.max(left,right);
    }

}
