package com.manindra.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack { // solution 225 implement stack using queue

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int top;

    //initialization
    public MyStack(){
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    //push element x into stack
    public void push(int x){
        queue1.add(x);
        top=x;
    }
    //remove the element on top of the stack and return that element
    public int pop(){
        while (queue1.size()>1){
            top= queue1.remove();
            queue2.add(top);
        }
        int poppedElement= queue1.remove();
        //swap the reference of queue1 and queue2
        Queue<Integer> temp=queue1;
        queue1=queue2;
        queue2=temp;

        return poppedElement;
    }

    //get the top element
    public int top(){
        return top;
    }

    //return whether stack is empty
    public boolean empty(){
        return queue1.isEmpty();
    }

    public static void main(String[] args) {

        MyStack stack=new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println("top element "+ stack.top());
        System.out.println("pop " +stack.pop());
        System.out.println("is empty "+ stack.empty());
    }
}
