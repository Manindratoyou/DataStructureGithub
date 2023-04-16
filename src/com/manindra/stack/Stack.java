package com.manindra.stack;

import java.util.EmptyStackException;

public class Stack {

    public static void main(String[] args) {

        Stack stack=new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }

    private ListNode top;
    private int length;

    public Stack(){
        top=null;
        length=0;
    }

    private class ListNode{

        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
        }
    }

    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }

    //push operation
    public void push(int data){
        ListNode temp=new ListNode(data);
        temp.next=top;
        top=temp;
        length++;
    }
    //pop operation
    public int pop(){
        if (isEmpty())
            throw new EmptyStackException();
        int result= top.data;
        top=top.next;
        length--;
        return result;
    }
    //peek operation
    public int peek(){
        if (isEmpty())
            throw new EmptyStackException();
        return top.data;
    }
}
