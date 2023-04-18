package com.manindra.queue;

import java.util.NoSuchElementException;

public class Queue {

    public static void main(String[] args) {

        Queue queue=new Queue();
        queue.enqueue(10);
        queue.enqueue(15);
        queue.enqueue(20);
        queue.print();

        System.out.println(queue.dequeue());
        queue.print();
        System.out.println(queue.first());
        System.out.println(queue.last());
    }

    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue(){
        this.front=null;
        this.rear=null;
        this.length=0;
    }

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data=data;
            this.next=null;
        }
    }
    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length==0;
    }

    //enqueue operation
    public void enqueue(int data){
        ListNode temp=new ListNode(data);
        if (isEmpty())
            front=temp;
        else{
            rear.next=temp;
        }
        rear=temp;
        length++;
    }
    //dequeue
    public int dequeue(){
        if (isEmpty())
            throw new NoSuchElementException();
        int result= front.data;
        front=front.next;
        if (front==null)
            rear=null;
        length--;
        return result;
    }
    //first
    public int first(){
        if (isEmpty())
            throw new NoSuchElementException("Queue is already empty");
        return front.data;
    }
    //last
    public int last(){
        if (isEmpty())
            throw new NoSuchElementException("Queue is already empty");
        return rear.data;
    }

    //print
    public void print(){
        if (isEmpty())
            return;
        ListNode current=front;
        while (current!=null){
            System.out.print(current.data+"->");
            current=current.next;
        }
        System.out.println("null");
    }
 }
