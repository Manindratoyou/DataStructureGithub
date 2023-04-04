package com.manindra.singlylinkedlist;

import java.util.List;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        SinglyLinkedList sll=new SinglyLinkedList();

/*        sll.head=new ListNode(10);
        ListNode second=new ListNode(1);
        ListNode third=new ListNode(8);
        ListNode fourth=new ListNode(11);
        sll.head.next=second;
        second.next=third;
        third.next=fourth;*/

        //sll.insertFirst(11);
        //sll.insertFirst(8);
        //sll.insertFirst(1);

        //sll.insertLast(11);
        //sll.insertLast(8);
        //sll.insertLast(1);

      /*  sll.insertAtGivenPosition(1,11);
        sll.insertAtGivenPosition(2,18);
        sll.insertAtGivenPosition(3,18);
        sll.insertAtGivenPosition(4,20);
        sll.insertAtGivenPosition(5,35);
        sll.insertAtGivenPosition(6,40);
        sll.display();
        System.out.println("length is "+sll.findLength());*/

        //System.out.println(sll.deleteFirst().data);
        //sll.display();

        //sll.deleteAtGivenPosition(3);
        //sll.display();

       /* if (sll.findElement(sll.head,65))
             System.out.println("Search key Found");
        else
             System.out.println("Search key not found");
       */

        //ListNode rev=sll.reverse(sll.head);
        //sll.display1(rev);
        //ListNode middleNode=sll.getMiddleNode();
        //System.out.println("Middle Node Is "+middleNode.data);

        //ListNode nthNode=sll.getNthNodeFromEnd(2);
        //System.out.println("N th node from end is ="+nthNode.data);
       // sll.removeDuplicates();
       // sll.insertInSortedList(21);
        //sll.deleteNode(18);//first key will be deleted

/*        ListNode first=new ListNode(1);
        ListNode second=new ListNode(2);
        ListNode third=new ListNode(3);
        ListNode fourth=new ListNode(4);
        ListNode fifth=new ListNode(5);
        ListNode sixth=new ListNode(6);

        sll.head=first;
        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=sixth;
        sixth.next=third;

        System.out.println("loop found at node "+sll.containsLoop().data);
        sll.removeLoop();
        sll.display();*/

        SinglyLinkedList sll1=new SinglyLinkedList();
        sll1.insertLast(9);
        sll1.insertLast(9);
        sll1.insertLast(9);

        SinglyLinkedList sll2=new SinglyLinkedList();
        sll2.insertLast(1);
        sll2.insertLast(1);


        sll1.display();
        sll2.display();

       // ListNode result=merge(sll1.head,sll2.head);
       // sll.display1(result);

        ListNode result=addTwoSll(sll1.head,sll2.head);
        sll.display1(result);


    }
    public void insertFirst(int value){
        ListNode newNode=new ListNode(value);
        newNode.next=head;
        head=newNode;
    }
    public void insertLast(int value){
        ListNode newNode=new ListNode(value);
        if (head==null){
            head=newNode;
            return;
        }
        ListNode current=head;
        while (null!=current.next){
            current=current.next;
        }
        current.next=newNode;
    }

    public void insertAtGivenPosition(int position,int value){

        ListNode node=new ListNode(value);

        if (position==1){
            node.next=head;
            head=node;
        }else {
            ListNode previous=head;
            int count=1;
            while (count<position-1){
                previous=previous.next;
                count++;
            }
            ListNode current=previous.next;
            previous.next=node;
            node.next=current;
        }
    }

    //delete first node of a singly linked list
    public ListNode deleteFirst(){
        if (head==null)
            return null;
        ListNode temp=head;
        head=head.next;
        temp.next=null;
        return temp;
    }

    //delete last node of a singly linked list
    public ListNode deleteLast(){
        if (head==null||head.next==null)
            return head;
        ListNode current=head;
        ListNode previous=null;
        while (current.next!=null){
            previous=current;
            current=current.next;
        }
        previous.next=null;//break the chain
        return current;
    }
    //delete node of a singly linked list from given position
    public void deleteAtGivenPosition(int position){
        if (position==1)
            head=head.next;
        else {
            ListNode previous=head;
            int count=1;
            while (count<position-1){
                previous=previous.next;
                count++;
            }
            ListNode current=previous.next;
            previous.next=current.next;
        }
    }

    //search an element in a singly linked list
    public boolean findElement(ListNode head,int searchKey){
        if (head==null)
            return false;
        ListNode current=head;
        while (current!=null){
            if (current.data==searchKey)
                return true;
            current=current.next;

        }
        return false;
    }
    //reverse a sll
    public ListNode reverse(ListNode head){
        if (head==null)
            return head;
        ListNode current=head;
        ListNode previous=null;
        ListNode next=null;
        while (current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        return previous;
    }
    // find middle node in a sll
    public ListNode getMiddleNode(){
        if (head==null)
            return null;
        ListNode slowPointer=head;
        ListNode fastpointer=head;
        while (fastpointer!=null && fastpointer.next!=null){
            slowPointer=slowPointer.next;
            fastpointer=fastpointer.next.next;
        }
        return slowPointer;
    }
    //nth node from end of sll
    public ListNode getNthNodeFromEnd(int n){
        if (head==null)
            return null;
        if (n<=0)
            throw new IllegalArgumentException("Inavlid value n"+n);
        ListNode mainPointer=head;
        ListNode refPointer=head;
        int count=0;
        while (count<n){
            if (refPointer==null)
                throw new IllegalArgumentException(n+"n is greater than the no of nodes in list");
            refPointer=refPointer.next;
            count++;
        }
        while (refPointer!=null){
            refPointer=refPointer.next;
            mainPointer=mainPointer.next;
        }
        return mainPointer;
    }
    //remove duplicate from sorted sll
    public void removeDuplicates(){
        if (head==null)
            return ;
        ListNode current=head;
        while (current!=null && current.next!=null){
            if (current.data==current.next.data)
                current.next=current.next.next;
            else
                current=current.next;
        }
    }
    //insert a node in a sorted sll
    public ListNode insertInSortedList(int value){
        ListNode newNode=new ListNode(value);
        if (head==null)
            return newNode;
        ListNode current=head;
        ListNode temp=null;
        while (current!=null && current.data<newNode.data){
            temp=current;
            current=current.next;
        }
        newNode.next=current;
        temp.next=newNode;
        return head;
    }
    //remove a given key from sll
    public void deleteNode(int key){
        ListNode current=head;
        ListNode temp=null;
        if (current!=null && current.data==key){
            head=head.next;
            return;
        }
        while (current!=null && current.data!=key){
            temp=current;
            current=current.next;
        }
        if (current==null)
            return;
        temp.next=current.next;
    }
    //detect a loop in a sll
    /*public boolean containsLoop(){
        ListNode fastPointer=head;
        ListNode slowPointer=head;
        while (fastPointer!=null && fastPointer.next!=null){
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
            if (slowPointer==fastPointer) {
                return true;
            }
        }
        return false;
    }*/

    //start of a loop
    public ListNode containsLoop(){
        ListNode fastPointer=head;
        ListNode slowPointer=head;
        while (fastPointer!=null && fastPointer.next!=null){
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
            if (slowPointer==fastPointer) {
                return getStartingNode(slowPointer);
            }
        }
        return null;
    }
    public ListNode getStartingNode(ListNode slowPointer){
        ListNode temp=head;
        while (slowPointer!=temp){
            temp=temp.next;
            slowPointer=slowPointer.next;
        }
        return temp;
    }
    public void removeLoop(){
        ListNode fastPointer=head;
        ListNode slowPointer=head;
        while (fastPointer!=null && fastPointer.next!=null){
            fastPointer=fastPointer.next.next;
            slowPointer=slowPointer.next;
            if (fastPointer==slowPointer){
                removeLoopFromNode(slowPointer);
                return;
            }
        }
    }
    private void  removeLoopFromNode(ListNode slowPointer){
        ListNode temp=head;
        while (temp.next!=slowPointer.next){
            temp=temp.next;
            slowPointer=slowPointer.next;
        }
        slowPointer.next=null;
    }
    //merge two sorted list
    public static ListNode merge(ListNode a, ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while (a!=null && b!=null){
            if (a.data<=b.data){
                tail.next=a;
                a=a.next;
            }else {
                tail.next=b;
                b=b.next;
            }
            tail=tail.next;
        }
        if (a==null)
            tail.next=b;
        else
            tail.next=a;
        return dummy.next;
    }
    //add two sll
    public static ListNode addTwoSll(ListNode a,ListNode b){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        int carry=0;
        while (a!=null || b!=null){
            int x=(a!=null)?a.data:0;
            int y=(b!=null)?b.data:0;
            int sum=carry+x+y;
            carry=sum/10;
            tail.next=new ListNode(sum%10);
            tail=tail.next;
            if (a!=null) a=a.next;
            if (b!=null) b=b.next;
        }
        if (carry>0)
            tail.next=new ListNode(carry);
        return dummy.next;
    }



    public void display(){
        ListNode current=head;
        while (current!=null){
            System.out.print(current.data +"->");
            current=current.next;
        }
        System.out.println("null");
    }
    public void display1(ListNode head){
        ListNode current=head;
        while (current!=null){
            System.out.print(current.data +"->");
            current=current.next;
        }
        System.out.println("null");
    }
    public int findLength(){
        if (head==null)
            return 0;
        int count=0;
        ListNode current=head;
        while (current !=null){
            count++;
            current=current.next;
        }
        return count;
    }
}
