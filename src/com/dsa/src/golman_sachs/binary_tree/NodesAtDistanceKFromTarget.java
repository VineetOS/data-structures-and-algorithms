package com.dsa.src.golman_sachs.binary_tree;

import com.dsa.src.dsa_sheet.binary.tree.TreeNode;

import java.util.*;

public class NodesAtDistanceKFromTarget {

    static List<Integer> bfs(TreeNode root, TreeNode target, int k){
        if(root==null) return new ArrayList<>();
        int distance=0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        generateParentChildMap(root, parentMap, null);
        Set<TreeNode> visitedSet = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(target);
        visitedSet.add(target);
        while(!queue.isEmpty() && distance!=k){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();

                //add children and parent of curr node to the queue
                if(curr.getLeft()!=null && visitedSet.add(curr.getLeft())) queue.offer(curr.getLeft());
                if(curr.getRight()!=null && visitedSet.add(curr.getRight())) queue.offer(curr.getRight());
                TreeNode parent = parentMap.get(curr);
                if(parent!=null && visitedSet.add(parent)) queue.offer(parent);
            }
            distance++;
        }
        while (!queue.isEmpty()){
            ans.add(queue.poll().getData());
        }
        return ans;
    }


    static List<Integer> dfs(TreeNode root, TreeNode target, int k){
        if(root==null) return new ArrayList<>();
        Map<TreeNode, TreeNode> parentChildMap = new HashMap<>();
        Set<TreeNode> visitedSet = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        generateParentChildMap(root, parentChildMap, null);
        dfsHelper(target,k, parentChildMap, visitedSet, ans);
        return ans;

    }

    static void dfsHelper(TreeNode target,int k, Map<TreeNode,TreeNode> parentMap, Set<TreeNode> visitedSet, List<Integer> ans){
        if(visitedSet.contains(target)) return;
        if(k==0){
            visitedSet.add(target);
            ans.add(target.getData());
            return;
        }
        visitedSet.add(target);
        dfsHelper(target.getLeft(), k-1, parentMap, visitedSet, ans);
        dfsHelper(target.getRight(), k-1, parentMap, visitedSet, ans);
        dfsHelper(parentMap.get(target), k-1, parentMap, visitedSet,ans);
    }

    static void generateParentChildMap(TreeNode root, Map<TreeNode, TreeNode> parentChildMap, TreeNode parent){
        if(root==null) return;
        parentChildMap.put(root,parent);
        generateParentChildMap(root.getLeft(),parentChildMap, root);
        generateParentChildMap(root.getRight(),parentChildMap, root);
    }
}
