package com.manindra.singlylinkedlist;

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

        sll.insertAtGivenPosition(1,11);
        sll.insertAtGivenPosition(2,8);
        sll.insertAtGivenPosition(3,10);
        sll.insertAtGivenPosition(4,65);
        sll.insertAtGivenPosition(5,40);

        sll.display();
        System.out.println("length is "+sll.findLength());

        //System.out.println(sll.deleteFirst().data);
        //sll.display();

        //sll.deleteAtGivenPosition(3);
        //sll.display();

        if (sll.findElement(sll.head,65))
             System.out.println("Search key Found");
        else
             System.out.println("Search key not found");

        //ListNode rev=sll.reverse(sll.head);
        //sll.display1(rev);
        ListNode middleNode=sll.getMiddleNode();
        System.out.println("Middle Node Is "+middleNode.data);

       // sll.display();


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
