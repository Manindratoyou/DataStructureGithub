package com.manindra.stack_ds;

public class KStack {

    public static void main(String[] args) {
        int k = 3; // Number of stacks
        int n = 10; // Total size of the array
        KStack ks = new KStack(k, n);

        // Push elements into different stacks
        ks.push(0, 1);
        ks.push(0, 2);
        ks.push(0, 3);

        ks.push(1, 4);
        ks.push(1, 5);

        ks.push(2, 6);

        // Pop elements from stacks
        System.out.println("Popped element from stack 0: " + ks.pop(0)); // Output: 3
        System.out.println("Popped element from stack 1: " + ks.pop(1)); // Output: 5
        System.out.println("Popped element from stack 2: " + ks.pop(2)); // Output: 6
    }
    private int[] arr;          // Array to store elements of all stacks
    private int[] top;          // Array to store the top index of each stack
    private int[] next;         // Array to store the next index of each element
    private int free;           // Index of the first available slot in the array
    private int k;              // Number of stacks

    // Constructor to initialize k stacks in an array of size n
    public KStack(int k, int n) {
        this.k = k;
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        // Initialize top of all stacks as -1
        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }

        // Initialize next index of all elements
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1; // -1 indicates end of array, i.e., no more free space
        free = 0;         // Initially, the first slot is free
    }

    // Function to push an element onto stack number 'sn'
    public void push(int sn, int item) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }

        int i = free;        // Store index of the free slot
        free = next[i];      // Update free to next free slot

        next[i] = top[sn];   // Update next of the new element to previous top
        top[sn] = i;         // Update top of the stack to point to the new element

        arr[i] = item;       // Store the item in the array at index i
    }

    // Function to pop an element from stack number 'sn'
    public int pop(int sn) {
        if (isEmpty(sn)) {
            System.out.println("Stack Underflow");
            return Integer.MIN_VALUE;
        }

        int i = top[sn];       // Store index of the top element of the stack
        top[sn] = next[i];     // Update top of the stack to next element

        next[i] = free;        // Update next of the popped element to free slot
        free = i;              // Update free to popped element's index

        return arr[i];         // Return the popped element
    }

    // Function to check if stack number 'sn' is empty
    public boolean isEmpty(int sn) {
        return (top[sn] == -1);
    }

    // Function to check if all stacks are full
    public boolean isFull() {
        return (free == -1);
    }
}

