package com.manindra.queue_ds;

public class QueueExampleTwo { //implementation of queue using array

    public static void main(String[] args) {
        // Testing the Queue implementation
        QueueImplTwo queue = new QueueImplTwo(5); // Creating a queue with capacity 5

        // Enqueueing elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        // Trying to enqueue when the queue is full
        queue.enqueue(60); // This should not add 60 to the queue as it's already full

        // Displaying the front and rear elements
        System.out.println("Front element: " + queue.getFront()); // Should print 10
        System.out.println("Rear element: " + queue.getRear()); // Should print 50

        // Dequeueing elements
        queue.dequeue(); // Removing 10
        queue.dequeue(); // Removing 20

        // Displaying the front and rear elements after dequeue operations
        System.out.println("Front element after dequeue: " + queue.getFront()); // Should print 30
        System.out.println("Rear element after dequeue: " + queue.getRear()); // Should print 50

        // Checking size of the queue
        System.out.println("Size of the queue: " + queue.size()); // Should print 3
    }

    static class QueueImplTwo {

        int front, rear, size, capacity;
        int[] arr;

        QueueImplTwo(int c) {
            capacity = c;
            front = 0;
            rear = -1;
            size = 0;
            arr = new int[capacity];
        }

        void enqueue(int x) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot enqueue " + x);
                return;
            }
            rear = (rear + 1) % capacity;
            arr[rear] = x;
            size++;
        }

        void dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot dequeue.");
                return;
            }
            front = (front + 1) % capacity;
            size--;
        }

        int getFront() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            } else {
                return arr[front];
            }
        }

        int getRear() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            } else {
                return arr[rear];
            }
        }

        boolean isFull() {
            return size == capacity;
        }

        boolean isEmpty() {
            return size == 0;
        }

        int size() {
            return size;
        }
    }
}
