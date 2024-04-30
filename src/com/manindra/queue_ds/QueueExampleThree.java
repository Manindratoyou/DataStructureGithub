package com.manindra.queue_ds;

public class QueueExampleThree { //implementation of queue using linked list(sll)

    public static void main(String[] args) {

        QueueImplThree queue = new QueueImplThree();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        // Print the queue
        System.out.println("Queue:");
        queue.printQueue();

        // Dequeue elements
        queue.dequeue();
        queue.dequeue();

        // Print the queue after dequeue
        System.out.println("Queue after dequeue:");
        queue.printQueue();
    }

    static class QueueImplThree {
        Node front, rear;

        public QueueImplThree() {
            this.front = this.rear = null;
        }

        void enqueue(int key) {
            Node temp = new Node(key);
            if (this.rear == null) {
                this.front = this.rear = temp;
                return;
            }
            this.rear.next = temp;
            this.rear = temp;
        }

        void dequeue() {
            if (this.front == null)
                return;
            Node temp = this.front;
            this.front = this.front.next;
            if (this.front == null)
                this.rear = null;
        }

        // Method to print the queue
        void printQueue() {
            Node current = front;
            while (current != null) {
                System.out.print(current.key + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    static class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

}
