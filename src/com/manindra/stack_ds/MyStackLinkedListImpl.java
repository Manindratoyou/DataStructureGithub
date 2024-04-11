package com.manindra.stack_ds;

public class MyStackLinkedListImpl {

    public static void main(String[] args) {
        MyStackLinkedListImpl stack = new MyStackLinkedListImpl();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack size: " + stack.size());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after popping: " + stack.size());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size after popping: " + stack.size());
    }

    StackNode head;
    int size;

    MyStackLinkedListImpl(){
        head = null;
        size = 0;
    }

    void push(int x){
        StackNode temp = new StackNode(x);
        temp.next = head;
        head = temp;
        size++;
    }

    int pop(){
        if (isEmpty())
            return Integer.MIN_VALUE;
        int result = head.data;
        head = head.next;
        size--;
        return result;
    }

    int peek(){
        if (isEmpty())
            return Integer.MAX_VALUE;
        return head.data;
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size == 0;
    }

    static class StackNode{
        int data;
        StackNode next;

        StackNode(int d){
            data = d;
            next = null;
        }
    }
}
