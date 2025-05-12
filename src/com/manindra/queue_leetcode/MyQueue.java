package com.manindra.queue_leetcode;

import java.util.Stack;

public class MyQueue { //solution 232 Implement Queue using Stacks

    private Stack<Integer> stack1; //main stack
    private Stack<Integer> stack2; //auxiliary stack

    //initialize data structure here
    public MyQueue(){
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    //push element x to the back of the queue
    public void push(int x){
        //push the element onto the main stack
        stack1.push(x);
    }

    //remove the element from in front of queue and returns that element.
    public int pop(){
        //if the auxiliary stack is empty ,transfer elements from stack1 to stack2
        if (stack2.isEmpty()){
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        //pop the element from stack2
        return stack2.pop();
    }

    //get the front element
    public int peek(){
        //if the auxiliary stack is empty ,transfer element from stack1 to stack2
        if (stack2.isEmpty()){
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        //peek at the front element in stack2
        return stack2.peek();
    }

    //return whether the queue is empty
    public boolean empty(){
        //both stack should be empty for the queue to be empty
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek()); //output :1
        System.out.println(myQueue.pop());  //output :1
        System.out.println(myQueue.empty()); //output : false
    }
}
