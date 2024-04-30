package com.manindra.queue_ds;

public class QueueExampleOne { //implementation of queue using array

    public static void main(String[] args) {
        QueueImplOne queue = new QueueImplOne(5); // Creating a queue with capacity 5

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
        System.out.println("Rear element: " + queue.getRear()); // Should print 4

        // Dequeueing elements
        queue.dequeue(); // Removing 10
        queue.dequeue(); // Removing 20

        // Displaying the front and rear elements after dequeue operations
        System.out.println("Front element after dequeue: " + queue.getFront()); // Should print 2 (index of 30)
        System.out.println("Rear element after dequeue: " + queue.getRear()); // Should print 3

        // Checking size of the queue
        System.out.println("Size of the queue: " + queue.size()); // Should print 3
    }


    static class QueueImplOne {

        int size, capacity;
        int[] arr;

        QueueImplOne(int c) {
            capacity = c;
            size = 0;
            arr = new int[capacity];
        }

        void enqueue(int x) {
            if (isFull())
                return;
            arr[size] = x;
            size++;
        }

        void dequeue() {
            if (isEmpty())
                return;
            for (int i = 0; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
            size--;
        }

        int getFront() {
            if (isEmpty())
                return -1;
            else
                return arr[0]; // Return the first element in the array
        }

        int getRear() {
            if (isEmpty())
                return -1;
            else
                return arr[size - 1]; // Return the last element in the array
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
