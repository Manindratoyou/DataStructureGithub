package com.manindra.leetcode;

public class SolutionTwo {

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummyHead=new ListNode(0);
        ListNode current=dummyHead;
        int carry=0;

        while (l1 !=null || l2 !=null){
            int x=(l1 !=null) ? l1.data : 0;
            int y=(l2 !=null) ? l2.data : 0;

            int total=x+y+carry;
            carry=total/10;
            current.next=new ListNode(total%10);

            current=current.next;
            if (l1 !=null) l1=l1.next;
            if (l2 !=null) l2=l2.next;
        }
        if (carry>0)
            current.next=new ListNode(carry);
        return dummyHead.next;
    }

    public static void main(String[] args) {

        //Example 1
        ListNode l1=new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2=new ListNode(5,new ListNode(6,new ListNode(4)));
        SolutionTwo solution=new SolutionTwo();
        ListNode result=solution.addTwoNumbers(l1,l2); //result will be [7,0,8]
        printList(result);

        //Example 2
        l1=new ListNode(0);
        l2=new ListNode(0);
        result=solution.addTwoNumbers(l1,l2); //result will be [0]
        printList(result);

        //Example 3
        l1=new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new
                ListNode(9,new ListNode(9)))))));
        l2=new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));
        result=solution.addTwoNumbers(l1,l2); //result will be [8,9,9,9,0,0,0,1]
        printList(result);

    }
    public static void printList(ListNode head){
        ListNode current=head;
        while (current !=null){
            System.out.print(current.data +" - >");
            current=current.next;
        }
        System.out.println("null");
    }

    static class ListNode{
        int data;
        ListNode next;
        ListNode(int data){
            this.data=data;
        }
        ListNode(int data,ListNode next){
            this.data=data;
            this.next=next;
        }
    }
}
