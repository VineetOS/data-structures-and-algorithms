package com.dsa.src.golman_sachs.binary_tree;

import com.dsa.src.dsa_sheet.binary.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> levels(TreeNode root){
        if(root==null) return new ArrayList<>();
        List<List<Integer>> traversal = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelArr = new ArrayList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode curr = queue.poll();
                if(curr==null) continue;
                if(curr.getLeft()!=null) queue.offer(curr.getLeft());
                if(curr.getRight()!=null) queue.offer(curr.getRight());
                levelArr.add(curr.getData());
            }
            traversal.add(levelArr);
        }
        return traversal;
    }

    public List<Integer> levelOrderTraversal(TreeNode root){
        List<Integer> arr = new ArrayList<>();
        if(root==null) return arr;
        Queue<TreeNode> nodes = new LinkedList<>();

        nodes.add(root);
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.poll();
            if(curr.getLeft()!=null) nodes.offer(curr.getLeft());
            if(curr.getRight()!=null) nodes.offer(curr.getRight());
            arr.add(curr.getData());
        }
        return arr;
    }
}
