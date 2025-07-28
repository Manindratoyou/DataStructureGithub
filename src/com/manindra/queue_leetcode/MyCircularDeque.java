package com.manindra.queue_leetcode;

public class MyCircularDeque { //solution 641

    public static void main(String[] args) {

        MyCircularDeque deque = new MyCircularDeque(3);

        System.out.println(deque.insertLast(1));   // true
        System.out.println(deque.insertLast(2));   // true
        System.out.println(deque.insertFront(3));  // true
        System.out.println(deque.insertFront(4));  // false, full
        System.out.println(deque.getRear());       // 2
        System.out.println(deque.isFull());        // true
        System.out.println(deque.deleteLast());    // true
        System.out.println(deque.insertFront(4));  // true
        System.out.println(deque.getFront());      // 4
    }

    private int[] deque;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        deque = new int[capacity];
        front = 0;
        rear = capacity - 1;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        deque[rear] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return deque[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return deque[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

}

