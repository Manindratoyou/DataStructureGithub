package com.manindra.heap_ds;

public class BinaryHeap_HeapifyAndExtract {

    public static void main(String[] args) {
        MinHeap h = new MinHeap(11);
        h.insert(3);
        h.insert(2);
        h.insert(15);
        h.insert(20);
        h.insert(5);
        h.insert(4);
        h.insert(45);

        System.out.println("Heap array:");
        h.printHeap();

        System.out.println("Extracted min: " + h.extractMin());
        System.out.println("Heap array after extracting min:");
        h.printHeap();

        System.out.println("Extracted min: " + h.extractMin());
        System.out.println("Heap array after extracting min:");
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

        void minHeapify(int i) {
            int lt = left(i);
            int rt = right(i);
            int smallest = i;
            if (lt < size && arr[lt] < arr[i])
                smallest = lt;
            if (rt < size && arr[rt] < arr[smallest])
                smallest = rt;
            if (smallest != i) {
                int temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;
                minHeapify(smallest);
            }
        }

        int extractMin() {
            if (size < 0)
                return Integer.MAX_VALUE;
            if (size == 1) {
                size--;
                return arr[0];
            }
            int temp = arr[0];
            arr[0] = arr[size - 1];
            arr[size - 1] = temp;
            size--;
            minHeapify(0);
            return arr[size];
        }
                /*
                int extractMin() {
            if (size <= 0)
                return Integer.MAX_VALUE;
            if (size == 1) {
                size--;
                return arr[0];
            }
            int root = arr[0];
            arr[0] = arr[size - 1];
            size--;
            minHeapify(0);
            return root;
        }

         */

        void printHeap() {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
