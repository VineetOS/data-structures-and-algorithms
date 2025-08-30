package com.dsa.src.golman_sachs.binary_tree;

import com.dsa.src.dsa_sheet.binary.tree.TreeNode;

import java.util.LinkedList;

public class FlattenBinaryTreeToLinkedList {

    static TreeNode flatten(TreeNode root){
        if(root == null) return null;
        TreeNode curr = root;
        while(curr!=null){
            if(curr.getLeft()!=null){
                TreeNode pred = curr.getLeft();
                while (pred!=null) pred = pred.getRight();

                pred.setRight(curr.getRight());
                curr.setRight(curr.getLeft());
                curr.setLeft(null);
            }
            curr = curr.getRight();
        }
        return root;
    }

    static TreeNode flattenRecursive(TreeNode root){
        //move right -> left -> root (reverse preorder traversal)
        rcHelper(root, null);
        return root;
    }

    static TreeNode rcHelper(TreeNode root, TreeNode prev){
        if(root == null) return prev;

        prev = rcHelper(root.getRight(), prev);
        prev = rcHelper(root.getLeft(),prev);

        root.setRight(prev);
        root.setLeft(null);
        return root;
    }
}
