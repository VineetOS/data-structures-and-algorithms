package com.dsa.src.dsa_sheet.binary.search_tree;

import com.dsa.src.dsa_sheet.binary.tree.TreeNode;

import java.util.Objects;

public class ValidateBST {

    static boolean validateBST(TreeNode root){
        return recHelper(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean recHelper(TreeNode root, long min, long max){
        if(root==null) return true;
        if(root.getData()<=min || root.getData()>=max) return false;
        return recHelper(root.getLeft(),min, root.getData())
            && recHelper(root.getRight(), root.getData(), max);
    }
}
