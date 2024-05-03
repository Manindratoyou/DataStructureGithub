package com.manindra.dequeue;

public class DequeExampleTwo { // Double linked list implementation of dequeue

    public static void main(String[] args) {
        DeQueueImplTwo deque = new DeQueueImplTwo();

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

    static class DeQueueImplTwo {

        // Node definition for doubly linked list
        class Node {
            int data;
            Node prev;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        private Node front;
        private Node rear;

        public DeQueueImplTwo() {
            front = null;
            rear = null;
        }

        // Check whether dequeue is empty or not
        public boolean isEmpty() {
            return front == null;
        }

        // Insert an element at front
        public void insertFront(int key) {
            Node newNode = new Node(key);
            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            } else {
                newNode.next = front;
                front.prev = newNode;
                front = newNode;
            }
        }

        // Insert an element at rear end of dequeue
        public void insertRear(int key) {
            Node newNode = new Node(key);
            if (isEmpty()) {
                front = newNode;
                rear = newNode;
            } else {
                rear.next = newNode;
                newNode.prev = rear;
                rear = newNode;
            }
        }

        // Delete element at front end of dequeue
        public void deleteFront() {
            if (isEmpty()) {
                System.out.println("Underflow: Deque is empty");
                return;
            }
            if (front == rear) {
                front = null;
                rear = null;
            } else {
                front = front.next;
                front.prev = null;
            }
        }

        // Delete elements at rear end of dequeue
        public void deleteRear() {
            if (isEmpty()) {
                System.out.println("Underflow: Deque is empty");
                return;
            }
            if (front == rear) {
                front = null;
                rear = null;
            } else {
                rear = rear.prev;
                rear.next = null;
            }
        }

        // Return front element of dequeue
        public int getFront() {
            if (isEmpty()) {
                System.out.println("Underflow: Deque is empty");
                return -1;
            }
            return front.data;
        }

        // Return rear element of dequeue
        public int getRear() {
            if (isEmpty()) {
                System.out.println("Underflow: Deque is empty");
                return -1;
            }
            return rear.data;
        }
    }
}

