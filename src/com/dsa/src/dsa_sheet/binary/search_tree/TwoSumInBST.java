package com.dsa.src.dsa_sheet.binary.search_tree;

import com.dsa.src.dsa_sheet.binary.tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TwoSumInBST {

    static boolean twoSum(TreeNode root, int target){
        Set<Integer> elementSet = new HashSet<>();
        return recHelper(root, elementSet, target);
    }

    static boolean recHelper(TreeNode root,Set<Integer> elementSet, int target){
        if(root==null) return false;
        int rem = target- root.getData();
        if(elementSet.contains(rem)) return true;
        elementSet.add(root.getData());
        return recHelper(root.getLeft(),elementSet,target) || recHelper(root.getRight(), elementSet,target);
    }

    static boolean twoSumOptimal(TreeNode root, int k) {
        if (root == null) return false;

        // two stacks for simulating two iterators
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        leftPush(root, leftStack);
        rightPush(root, rightStack);

        int leftVal = getNextSmallest(leftStack);
        int rightVal = getNextGreatest(rightStack);
        while (leftVal < rightVal) {
            int sum = leftVal + rightVal;
            if (sum == k) return true;
            else if (sum > k) leftVal = getNextSmallest(leftStack);
            else rightVal = getNextGreatest(rightStack);
        }
        return false;
    }

    static void leftPush(TreeNode root, Stack<TreeNode> leftStack){
        while(root!=null){
            leftStack.push(root);
            root = root.getLeft();
        }
    }

    static void rightPush(TreeNode root, Stack<TreeNode> rightStack){
        while(root!=null){
            rightStack.push(root);
            root = root.getRight();
        }
    }

    static int getNextSmallest(Stack<TreeNode> leftStack){
        TreeNode root = leftStack.pop();
        int val = root.getData();
        leftPush(root.getRight(),leftStack);
        return val;
    }

    static int getNextGreatest(Stack<TreeNode> rightStack){
        TreeNode root = rightStack.pop();
        int val = root.getData();
        leftPush(root.getLeft(),rightStack);
        return val;
    }

    public static void main(String[] args) {
        int[] arr = {-4,0,1,2,3};
        BSTFromSortedArray bstBuilder = new BSTFromSortedArray();
        TreeNode root = bstBuilder.buildBST(arr);
        System.out.println("Result: "+ twoSum(root,-1));
    }
}
