package com.dsa.src.dsa_sheet.binary.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    static List<Integer> levelOrderTraversal(TreeNode head){
        if(head==null) return new ArrayList<>();
        List<Integer> levelOrderTraversalList = new ArrayList<>();
        Queue<TreeNode> levelStore = new LinkedList<>();
        levelStore.offer(head);
        while(!levelStore.isEmpty()){
            TreeNode currNode = levelStore.poll();
            levelOrderTraversalList.add(currNode.val);
            if(currNode.left!=null) levelStore.offer(currNode.left);
            if(currNode.right!=null) levelStore.offer(currNode.right);
        }
        return levelOrderTraversalList;
    }

    public static void main(String[] args) {

    }
}
