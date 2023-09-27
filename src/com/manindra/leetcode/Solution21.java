package com.manindra.leetcode;

public class Solution21 {

    private static class ListNode{
        int val;
        ListNode next;

        ListNode(){}

        ListNode(int val){
            this.val=val;
        }

        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }

    public static void main(String[] args) {

        ListNode l1=new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2=new ListNode(1,new ListNode(3,new ListNode(5)));
        //print the merge list
        System.out.println("Merge Sorted List : ");
        //merge the two list
        Solution21 solution21=new Solution21();
        ListNode mergeList=solution21.mergeTwoList(l1,l2);
        while (mergeList!=null){
            System.out.print(mergeList.val+" ");
            mergeList=mergeList.next;
        }

    }

    public ListNode mergeTwoList(ListNode list1,ListNode list2){
        ListNode dummyHead=new ListNode();
        ListNode current=dummyHead;

        while (list1!=null && list2!=null){
            if (list1.val<list2.val){
                current.next=list1;
                list1=list1.next;
            }else {
                current.next=list2;
                list2=list2.next;
            }
            current=current.next;
        }

        //if one of the list is exhausted ,append the remaining nodes from the other list
        if (list1 !=null)
            current.next=list1;
        else
            current.next=list2;

        return dummyHead.next;
    }
    public ListNode mergeTwoListSolTwo(ListNode list1,ListNode list2){

        if (list1==null)
            return list2;
        if (list2==null)
            return list1;
        if (list1.val< list2.val){
            list1.next=mergeTwoListSolTwo(list1.next,list2);
            return list1;
        }else {
            list2.next=mergeTwoListSolTwo(list1,list2.next);
            return list2;
        }

    }
}
