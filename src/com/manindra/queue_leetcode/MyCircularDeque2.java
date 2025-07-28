package com.manindra.queue_leetcode;

class MyCircularDeque2 { //solution 641

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);

        System.out.println(deque.insertLast(1));   // true
        System.out.println(deque.insertLast(2));   // true
        System.out.println(deque.insertFront(3));  // true
        System.out.println(deque.insertFront(4));  // false
        System.out.println(deque.getRear());       // 2
        System.out.println(deque.isFull());        // true
        System.out.println(deque.deleteLast());    // true
        System.out.println(deque.insertFront(4));  // true
        System.out.println(deque.getFront());      // 4
    }

    private class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;
    private int size, capacity;

    public MyCircularDeque2(int k) {
        capacity = k;
        size = 0;
        head = new Node(-1); // dummy head
        tail = new Node(-1); // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        Node next = head.next;

        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;

        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        Node prev = tail.prev;

        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;

        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        Node front = head.next;
        Node next = front.next;

        head.next = next;
        next.prev = head;

        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        Node last = tail.prev;
        Node prev = last.prev;

        prev.next = tail;
        tail.prev = prev;

        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return head.next.val;
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return tail.prev.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

}

