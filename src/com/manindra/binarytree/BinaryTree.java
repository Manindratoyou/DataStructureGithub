package com.manindra.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public static void main(String[] args) {

        BinaryTree binaryTree=new BinaryTree();
        binaryTree.createBinaryTree();
        //binaryTree.preOrderRecursive(binaryTree.root);
        //binaryTree.preOrderIterative(binaryTree.root);
        //binaryTree.inOrderRecursive(binaryTree.root);
        //binaryTree.inOrderIterative(binaryTree.root);
        //binaryTree.postOrderRecursive(binaryTree.root);
        //binaryTree.postOrderIterative(binaryTree.root);
        binaryTree.levelOrderTraversal(binaryTree.root);
        System.out.println();
        System.out.println(binaryTree.findMax(binaryTree.root));

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
    //iterative inorder traversal
    public void inOrderIterative(TreeNode root){
        if (root==null)
            return;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode temp=root;
        while (!stack.isEmpty() || temp!=null){
          if (temp!=null){
              stack.push(temp);
              temp=temp.left;
          }
          else {
              temp=stack.pop();
              System.out.print(temp.data +" ");
              temp=temp.right;
          }
        }
    }
    //Recursive Postorder traversal of a Binary Tree
    public void postOrderRecursive(TreeNode root){
        if (root==null)
            return;
        inOrderRecursive(root.left);
        inOrderRecursive(root.right);
        System.out.print(root.data+ " ");
    }
    //Iterative Postorder traversal of a Binary Tree
    public void postOrderIterative(TreeNode root){

        TreeNode current=root;
        Stack<TreeNode> stack=new Stack<>();
        while (current!=null || !stack.isEmpty()){
            if (current!=null){
                stack.push(current);
                current=current.left;
            }
            else {
                TreeNode temp=stack.peek().right;
                if (temp==null){
                    temp=stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp==stack.peek().right){
                        temp=stack.pop();
                        System.out.print(temp.data + " ");
                    }
                }else {
                   current=temp;
                }
            }
        }
    }
    //Level order traversal of a Binary Tree
    public void levelOrderTraversal(TreeNode root){
        if (root==null)
            return;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left!=null)
                queue.offer(temp.left);
            if (temp.right!=null)
                queue.offer(temp.right);
        }
    }

    //find maximum value in a binary tree recursively
    public int findMax(TreeNode root){
        if (root==null)
            return Integer.MIN_VALUE;
        int result=root.data;
        int left=findMax(root.left);
        int right=findMax(root.right);
        if (left>result)
            result=left;
        if (right>result)
            result=right;
        return result;
    }

}
