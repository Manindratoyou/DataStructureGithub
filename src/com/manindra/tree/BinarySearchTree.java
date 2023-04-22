package com.manindra.tree;

public class BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree bst=new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.inOrderPrint(bst.root);
        System.out.println();
        if(null != bst.search(bst.root, 7)) {
            System.out.println("Key Found");
        }
        else
            System.out.println("Key Not found");
    }

    private TreeNode root;
    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data=data;
        }
    }
    //=========================================//

    public void insert(int value) {
        root = insert(root, value);
    }
    public TreeNode insert(TreeNode root,int value){
        if (root==null){
            root=new TreeNode(value);
            return root;
        }
        if (value<root.data)
            root.left=insert(root.left,value);
        else
            root.right=insert(root.right,value);
        return root;
    }
    //Search a key
    public TreeNode search(TreeNode root,int key){
        if (root==null || root.data==key)
            return root;
        if (key<root.data)
            return search(root.left,key);
        else
            return search(root.right,key);
    }

    //print
    public void inOrderPrint(TreeNode root){
        if (root==null)
            return;
        inOrderPrint(root.left);
        System.out.print(root.data +" ");
        inOrderPrint(root.right);
    }
}
