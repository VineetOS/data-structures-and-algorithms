package com.dsa.src.dsa_sheet.binary.search_tree;

import com.dsa.src.dsa_sheet.binary.tree.TreeNode;

public class FindElementInBST {

    static boolean isElementPresent(TreeNode root, TreeNode node){
        if(root==null) return false;
        int val = node.getData();
        if(val == root.getData()) return true;
        else if (val > root.getData()) return isElementPresent(root.getRight(), node);
        else return isElementPresent(root.getLeft(), node);
    }
}
