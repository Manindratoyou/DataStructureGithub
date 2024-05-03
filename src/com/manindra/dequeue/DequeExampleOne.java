package com.manindra.dequeue;

public class DequeExampleOne { //Array impl of dequeue

    public static void main(String[] args) {
        DeQueueImplOne deque = new DeQueueImplOne(5);

        deque.insertFront(1);
        deque.insertRear(2);
        deque.insertFront(3);
        deque.insertRear(4);

        System.out.println("Front element: " + deque.getFront());
        System.out.println("Rear element: " + deque.getRear());

        deque.deleteFront();
        deque.deleteRear();

        System.out.println("Front element after deletion: " + deque.getFront());
        System.out.println("Rear element after deletion: " + deque.getRear());
    }

    static class DeQueueImplOne {

        private int[] arr;
        private int front;
        private int rear;
        private int size;

        public DeQueueImplOne(int size) {
            this.front = -1;
            this.rear = 0;
            this.size = size;
            this.arr = new int[size];
        }

        // Check whether deque is full or not
        public boolean isFull() {
            return (front == 0 && rear == size - 1) || (front == rear + 1);
        }

        // Check whether dequeue is empty or not
        public boolean isEmpty() {
            return front == -1;
        }

        // Insert an element at front
        public void insertFront(int key) {
            if (isFull()) {
                throw new IllegalStateException("Overflow: Deque is full");
            }
            if (front == -1) {
                front = 0;
                rear = 0;
            } else if (front == 0) {
                front = size - 1;
            } else {
                front = front - 1;
            }
            arr[front] = key;
        }

        // Insert an element at rear end of dequeue
        public void insertRear(int key) {
            if (isFull()) {
                throw new IllegalStateException("Overflow: Deque is full");
            }
            if (front == -1) {
                front = 0;
                rear = 0;
            } else if (rear == size - 1) {
                rear = 0;
            } else {
                rear = rear + 1;
            }
            arr[rear] = key;
        }

        // Delete element at front end of dequeue
        public void deleteFront() {
            if (isEmpty()) {
                throw new IllegalStateException("Underflow: Deque is empty");
            }
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (front == size - 1) {
                front = 0;
            } else {
                front = front + 1;
            }
        }

        // Delete elements at rear end of dequeue
        public void deleteRear() {
            if (isEmpty()) {
                throw new IllegalStateException("Underflow: Deque is empty");
            }
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (rear == 0) {
                rear = size - 1;
            } else {
                rear = rear - 1;
            }
        }

        // Return front element of dequeue
        public int getFront() {
            if (isEmpty()) {
                throw new IllegalStateException("Underflow: Deque is empty");
            }
            return arr[front];
        }

        // Return rear element of dequeue
        public int getRear() {
            if (isEmpty() || rear < 0) {
                throw new IllegalStateException("Underflow: Deque is empty");
            }
            return arr[rear];
        }
    }
}
