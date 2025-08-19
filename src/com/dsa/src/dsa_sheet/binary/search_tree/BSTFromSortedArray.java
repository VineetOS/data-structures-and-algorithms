package com.dsa.src.dsa_sheet.binary.search_tree;

import com.dsa.src.dsa_sheet.binary.tree.TreeNode;

public class BSTFromSortedArray {

    static TreeNode buildBST(int[] arr){
        if(arr==null || arr.length==0) return null;
        int n=arr.length;
        return buildHelper(arr,0,n-1);
    }

    static TreeNode buildHelper(int[] arr, int left, int right){
        if(left<0 || right>arr.length-1) return null;
        int mid=left + (right-left)/2;
        TreeNode root = new TreeNode(arr[mid]);
        TreeNode leftNode = buildHelper(arr, left, mid-1);
        TreeNode rightNode = buildHelper(arr,mid+1, right);
        root.setLeft(leftNode);
        root.setRight(rightNode);
        return root;
    }
}
