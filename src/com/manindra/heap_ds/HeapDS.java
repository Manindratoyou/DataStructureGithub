package com.manindra.heap_ds;

public class HeapDS { // Basic Binary Heap Implementation

                /*
                    2
                   / \
                  3  15
                 /
                20

               */

    public static void main(String[] args) {
        MinHeap h = new MinHeap(11);
        h.insert(3);
        h.insert(2);
        h.insert(15);
        h.insert(20);
        h.printHeap();
    }

    static class MinHeap {
        int arr[];
        int size;
        int capacity;

        MinHeap(int cap) {
            size = 0;
            capacity = cap;
            arr = new int[cap];
        }

        int left(int i) {
            return (2 * i + 1);
        }

        int right(int i) {
            return (2 * i + 2);
        }

        int parent(int i) {
            return (i - 1) / 2;
        }

        void insert(int x) {
            if (size == capacity) {
                System.out.println("Heap is full");
                return;
            }
            arr[size] = x;
            int i = size;
            size++;

            // Heapify-up
            while (i != 0 && arr[parent(i)] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[parent(i)];
                arr[parent(i)] = temp;

                i = parent(i);
            }
        }

        void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
