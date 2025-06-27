package com.dsa.src.dsa_sheet.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preOrder(Node root){
            if(root == null) return;
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }

        public static void levelOrderTraversal(Node root){
            Queue<Node> store = new LinkedList<>();
            if(root == null) return;
            store.add(root);
            store.add(null);
            while(!store.isEmpty()){
                Node currentNode = store.remove();

                if(currentNode == null) {
                    System.out.println();
                    if (store.isEmpty()) break;
                    else store.add(null);
                }
                else{
                    System.out.print(currentNode.data + " ");
                    if(currentNode.left != null) store.add(currentNode.left);
                    if(currentNode.right != null) store.add(currentNode.right);
                }
            }
        }


        public static int countNodes(Node root){
            if(root == null) return 0;

            int left = countNodes(root.left);
            int right = countNodes(root.right);
            return left+right+1;
        }

        public static int depth(Node root){
            if(root==null) return 0;
            return 1 + Math.max(depth(root.left), depth(root.right));
        }
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        Node root = BinaryTree.buildTree(nodes);
        assert root != null;
        System.out.println(root.data);
        System.out.println("Preorder print" );
        BinaryTree.preOrder(root);
        System.out.println();
        System.out.println("LevelOrder print" );
        BinaryTree.levelOrderTraversal(root);
        System.out.println("Count of nodes: "+ BinaryTree.countNodes(root));
        System.out.println("Depth of tree: "+ BinaryTree.depth(root));
    }
}
