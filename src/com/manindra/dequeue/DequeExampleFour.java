package com.manindra.dequeue;

import java.util.ArrayDeque;

public class DequeExampleFour {

    public static void main(String[] args) {

        exampleOne();//Array Deque as queue
        System.out.println("=========");
        exampleTwo();//Array Deque as stack
        System.out.println("==============");
        exampleThree();
    }

    static void exampleOne() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(10);
        arrayDeque.offer(20);
        //return the front of the queue
        System.out.println(arrayDeque.peek());
        //return and remove the front of the queue
        System.out.println(arrayDeque.poll());
        //add 40 to the last of the queue
        arrayDeque.offer(40);
        System.out.println(arrayDeque.peek());
    }

    static void exampleTwo() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        //pushing the item to the deque using add
        arrayDeque.push(10);
        arrayDeque.push(20);
        //return the top of the stack
        System.out.println(arrayDeque.peek());
        //return and remove the top of the stack
        System.out.println(arrayDeque.pop());
    }

    static void exampleThree() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.offerFirst(10);
        arrayDeque.offerFirst(20);
        arrayDeque.offerFirst(30);
        arrayDeque.offerFirst(40);
        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque.peekLast());
        System.out.println(arrayDeque.pollFirst());
        System.out.println(arrayDeque.peekFirst());
        System.out.println(arrayDeque.pollLast());
        System.out.println(arrayDeque.peekLast());
    }
}
