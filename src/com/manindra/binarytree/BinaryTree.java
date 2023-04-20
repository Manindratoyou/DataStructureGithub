package com.manindra.binarytree;

import java.util.Stack;

public class BinaryTree {

    public static void main(String[] args) {

        BinaryTree binaryTree=new BinaryTree();
        binaryTree.createBinaryTree();
        //binaryTree.preOrderRecursive(binaryTree.root);
        //binaryTree.preOrderIterative(binaryTree.root);
        binaryTree.inOrderRecursive(binaryTree.root);

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
    public void preOrderRecursive(TreeNode root){
        if (root==null)
            return;
        System.out.print(root.data+ " ");
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }
    //iterative preorder traversal
    public void preOrderIterative(TreeNode root){
        if (root==null)
            return;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp=stack.pop();
            System.out.print(temp.data+ " ");
            if (temp.right!=null)
                stack.push(temp.right);
            if (temp.left!=null)
                stack.push(temp.left);
        }
    }

    //recursive inorder traversal
    public void inOrderRecursive(TreeNode root){
        if (root==null)
            return;
        inOrderRecursive(root.left);
        System.out.print(root.data+ " ");
        inOrderRecursive(root.right);
    }

}
