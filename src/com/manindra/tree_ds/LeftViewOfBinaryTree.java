package com.manindra.tree_ds;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

    public static void main(String[] args) {

        /*
         10
        /  \
      20    30
     / \     \
   40   50    70

         */

        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right = new Node(30);
        root.right.right = new Node(70);

        printLeftViewSolutionOne(root);
        System.out.println();
        printLeftViewSolutionTwo(root);

    }

    static void printLeftViewSolutionOne(Node root){ //recursive solution
        printLeft(root,1);
    }
    static int maxLevel=0;
    static void printLeft(Node root,int level){
        if (root==null)
            return;
        if (maxLevel<level){
            System.out.print(root.key+" ");
            maxLevel=level;
        }
        printLeft(root.left,level+1);
        printLeft(root.right,level+1);
    }

    static void printLeftViewSolutionTwo(Node root){ //iterative solution
        if (root==null)
            return;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (queue.isEmpty()==false){
            int count=queue.size();
            for (int i=0;i<count;i++){
                Node current=queue.poll();
                if (i==0)
                    System.out.print(current.key+" ");
                if (current.left !=null)
                    queue.add(current.left);
                if (current.right !=null)
                    queue.add(current.right);
            }
        }
    }


    static class Node {

        int key;
        Node left;
        Node right;

        Node(int k) {
            key = k;
            left = right = null;
        }
    }
}
