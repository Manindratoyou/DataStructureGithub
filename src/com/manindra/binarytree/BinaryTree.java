package com.manindra.binarytree;

public class BinaryTree {

    public static void main(String[] args) {

        BinaryTree binaryTree=new BinaryTree();
        binaryTree.createBinaryTree();
        binaryTree.preOrder(binaryTree.root);

    }

    private TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        public TreeNode(int data){
            this.data=data;
        }
    }

    //===========================================
    //create binary tree
    public void createBinaryTree(){
        TreeNode first=new TreeNode(1);
        TreeNode second=new TreeNode(2);
        TreeNode third=new TreeNode(3);
        TreeNode fourth=new TreeNode(4);
        TreeNode fifth=new TreeNode(5);

        root=first;
        first.left=second;
        first.right=third;

        second.left=fourth;
        second.right=fifth;

    }
    //recursive preorder traversal
    public void preOrder(TreeNode root){
        if (root==null)
            return;
        System.out.print(root.data+ " ");
        preOrder(root.left);
        preOrder(root.right);
    }
}
