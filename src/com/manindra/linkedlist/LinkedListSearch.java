package com.manindra.linkedlist;

public class LinkedListSearch {

    public static void main(String[] args) {

        ListNode head=new ListNode(10);
        head.next=new ListNode(20);
        head.next.next=new ListNode(30);
        printList(head);
        System.out.println();
        //System.out.println(searchIterative(head,20));
        System.out.println(searchRecursive(head,30));
    }

    static int searchIterative(ListNode head,int key){
        int position=1;
        ListNode current=head;
        while (current !=null){
            if (current.val==key)
                return position;
            else {
                position++;
                current=current.next;
            }
        }
        return -1;
    }
    static int searchRecursive(ListNode head,int key){
        if (head==null) return -1;
        if (head.val==key) return 1;
        else {
            int result=searchRecursive(head.next,key);
            if (result == -1) return -1;
            else return (result+1);
        }
    }

    static void printList(ListNode head){
        ListNode current=head;
        while (current !=null){
            System.out.print(current.val+ "->");
            current=current.next;
        }
        System.out.println("null");
    }

    private static class ListNode{

        private int val;

        ListNode next;

        ListNode(){}

        ListNode (int val){
            this.val=val;
        }
    }
}
