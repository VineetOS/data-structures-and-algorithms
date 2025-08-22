package com.dsa.src.dsa_sheet.binary.search_tree;

import com.dsa.src.dsa_sheet.binary.tree.TreeNode;

public class LCAInBST {

    static TreeNode calculateLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root==null) return null;
        if(p.getData()> root.getData() && q.getData()> root.getData()) return calculateLCA(root.getRight(),p,q);
        else if(p.getData()< root.getData() && q.getData()< root.getData()) return calculateLCA(root.getLeft(),p,q);
        else return root;
    }
}
