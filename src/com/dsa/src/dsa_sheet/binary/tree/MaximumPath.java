package com.dsa.src.dsa_sheet.binary.tree;


public class MaximumPath {

    static int maxPath(TreeNode root){
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        recHelper(root, ans);
        return ans[0];
    }

    static int recHelper(TreeNode root,int[] ans){
        if(root==null) return 0;
        int left = Math.max(recHelper(root.left,ans),0);
        int right = Math.max(recHelper(root.right,ans),0);
        ans[0] = Math.max(root.val+ left+right, ans[0]);
        return root.val+Math.max(left,right);
    }

    public static void main(String[] args) {

    }
}
