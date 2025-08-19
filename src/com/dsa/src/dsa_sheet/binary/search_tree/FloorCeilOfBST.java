package com.dsa.src.dsa_sheet.binary.search_tree;

import com.dsa.src.dsa_sheet.binary.tree.TreeNode;

public class FloorCeilOfBST {

    static int floor(TreeNode root, int k){
        if(root==null) return -1;
        //greatest value <=k
        if(root.getData()<=k){
            //search in right half
            int res = floor(root.getRight(),k);
            return res!=-1 && res> root.getData()?res:root.getData();
        }
        else{
            //search in left half
            int res = floor(root.getLeft(),k);
            return res<=k? res: -1;
        }
    }

    static int ceil(TreeNode root, int k){
        if(root==null) return -1;
        //smallest value >=k
        if(root.getData()>=k){
            //search in left half
            int res = ceil(root.getLeft(),k);
            return res!=-1 && res< root.getData()?res:root.getData();
        }
        else{
            //search in right half
            int res = ceil(root.getRight(),k);
            return res>=k? res: -1;
        }
    }


}
