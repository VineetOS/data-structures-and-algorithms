package com.dsa.src.golman_sachs.binary_tree;

import com.dsa.src.dsa_sheet.binary.tree.TreeNode;

public class SymmetricTree {

    boolean isSymmetric(TreeNode root){
        return checker(root, root);
    }

    boolean checker(TreeNode t1, TreeNode t2){
        if(t1 == null && t2==null) return true;
        else if(t1==null || t2==null) return false;
        if(t1.getData() == t2.getData()){
            return checker(t1.getLeft(), t2.getRight()) && checker(t1.getRight(), t2.getLeft());
        }
        return false;
    }
}
