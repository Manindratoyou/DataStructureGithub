package com.manindra.tree;

import java.util.Arrays;

public class MaxHeap {

    private int[] heap;  // Array to store heap elements
    private int size;    // Current size of the heap
    private int capacity; // Maximum capacity of the heap

    // Constructor to initialize the heap
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Main method to test the Max-Heap implementation
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(7);
        maxHeap.insert(25);

        maxHeap.printHeap(); // Expected: [25, 20, 5, 7, 10]

        System.out.println("Extracted Max: " + maxHeap.extractMax()); // Expected: 25
        maxHeap.printHeap(); // Expected: [20, 10, 5, 7]

        maxHeap.insert(30);
        maxHeap.printHeap(); // Expected: [30, 20, 5, 7, 10]
    }



    // Get the index of the parent
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Get the index of the left child
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Get the index of the right child
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Check if the heap is full
    private boolean isFull() {
        return size == capacity;
    }

    // Check if the heap is empty
    private boolean isEmpty() {
        return size == 0;
    }

    // Insert a new element into the heap
    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full");
        }

        // Insert the new element at the end
        heap[size] = value;
        size++;

        // Heapify up to maintain the heap property
        heapifyUp(size - 1);
    }

    // Heapify up to maintain the Max-Heap property
    private void heapifyUp(int index) {
        while (index > 0 && heap[parent(index)] < heap[index]) {
            // Swap the current node with its parent
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Remove and return the maximum element (root)
    public int extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        // Store the maximum element (root)
        int max = heap[0];

        // Replace the root with the last element
        heap[0] = heap[size - 1];
        size--;

        // Heapify down to maintain the Max-Heap property
        heapifyDown(0);

        return max;
    }

    // Heapify down to maintain the Max-Heap property
    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        // Find the largest among the parent, left, and right child
        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        // If the largest is not the parent, swap and continue heapifying
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Print the heap as an array
    public void printHeap() {
        System.out.println("Heap: " + Arrays.toString(Arrays.copyOf(heap, size)));
    }
}

