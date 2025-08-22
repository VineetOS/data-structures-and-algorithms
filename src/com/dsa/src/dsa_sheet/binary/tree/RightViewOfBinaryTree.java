package com.dsa.src.dsa_sheet.binary.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBinaryTree {

    static List<Integer> preOrderRightView(TreeNode head, int level){
        List<Integer> ans = new ArrayList<>();
        recHelper(head,  0, ans);
        return ans;
    }

    static void recHelper(TreeNode head, int level, List<Integer> ans){
        if(head==null) return;
        if(level == ans.size()) ans.add(head.val);
        recHelper(head.right, level+1, ans); //right traversal
        recHelper(head.left, level+1, ans); //left traversal
    }

    static List<Integer> levelOrderRightView(TreeNode head){
        if(head==null) return new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> levels = new LinkedList<>();
        levels.offer(head);
        while (!levels.isEmpty()){
            int levelSize = levels.size();
            for(int i=0; i<levelSize;i++) {
                TreeNode currNode = levels.poll();
                if (currNode != null) {
                    if (currNode.left != null) levels.offer(currNode.left);
                    if (currNode.right != null) levels.offer(currNode.right);
                    if (i == levelSize - 1) ans.add(currNode.val);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
