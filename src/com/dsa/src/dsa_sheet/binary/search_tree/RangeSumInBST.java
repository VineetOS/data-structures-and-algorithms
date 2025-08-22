package com.dsa.src.dsa_sheet.binary.search_tree;

import com.dsa.src.dsa_sheet.binary.tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Objects;

public class RangeSumInBST {

    static int rangeSum(TreeNode root, int low, int high){
        int[] ans = new int[1];
        rangeSumHelper(root,low,high,ans);
        return ans[0];
    }

    static void rangeSumHelper(TreeNode root, int low, int high, int[] ans){
        if(root==null) return;
        if(root.getData()>=low && root.getData()<=high){
            ans[0]+= root.getData();
            rangeSumHelper(root.getLeft(), low, high, ans);
            rangeSumHelper(root.getRight(),low,high,ans);
        }else if(root.getData()>high) rangeSumHelper(root.getLeft(),low,high,ans);
        else rangeSumHelper(root.getRight(),low,high,ans);
    }
}
