package com.dsa.src.dsa_sheet.binary.search_tree;

import com.dsa.src.dsa_sheet.binary.tree.TreeNode;


public class KthSmallestElementInBST {

    static int kthSmallestElement(TreeNode root, int k){
        int[] ans = new int[1];
        int[] kArr = new int[]{k};
        recHelper(root,kArr,ans);
        return ans[0];
    }

    static void recHelper(TreeNode root, int[] kArr, int[] ans){
       if(root==null) return;
       recHelper(root.getLeft(),kArr, ans);
        if(kArr[0]==1) {
            ans[0] = root.getData();
            kArr[0]--;
            return;
        }
       kArr[0]--;
       recHelper(root.getRight(), kArr, ans);
    }

}
