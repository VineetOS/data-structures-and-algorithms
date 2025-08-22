package com.dsa.src.dsa_sheet.binary.tree;

public class TreeNode {

    static int idx = -1;

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.val = data;
        left = null;
        right = null;
    }

    public int getData() {
        return this.val;
    }

    public void setData(int data) {
        this.val = data;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static TreeNode buildTree(int[] nodes){
        idx++;
        if(nodes[idx] == -1){
            return null;
        }
        TreeNode newTreeNode = new TreeNode(nodes[idx]);
        newTreeNode.left = buildTree(nodes);
        newTreeNode.right = buildTree(nodes);
        return newTreeNode;
    }


}
