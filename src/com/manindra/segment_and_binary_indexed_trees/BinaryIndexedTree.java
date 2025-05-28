package com.manindra.segment_and_binary_indexed_trees;

public class BinaryIndexedTree {

    private int[] bit; // Binary Indexed Tree
    private int size;

    public BinaryIndexedTree(int n) {
        size = n + 1; // 1-based indexing
        bit = new int[size];
    }

    // Update BIT at index `i` with value `delta`
    public void update(int i, int delta) {
        while (i < size) {
            bit[i] += delta;
            i += i & -i;
        }
    }

    // Query prefix sum from 1 to `i`
    public int query(int i) {
        int sum = 0;
        while (i > 0) {
            sum += bit[i];
            i -= i & -i;
        }
        return sum;
    }

    // Range sum from l to r (inclusive)
    public int rangeQuery(int l, int r) {
        return query(r) - query(l - 1);
    }

    // Initialize BIT with an array
    public void buildFromArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            update(i + 1, arr[i]); // Convert to 1-based index
        }
    }

    // Display internal tree (for debugging)
    public void printBIT() {
        for (int i = 1; i < size; i++) {
            System.out.print(bit[i] + " ");
        }
        System.out.println();
    }

    // Main method with test cases
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        BinaryIndexedTree bit = new BinaryIndexedTree(arr.length);
        bit.buildFromArray(arr);

        System.out.println("Initial prefix sum up to index 3: " + bit.query(3)); // Output: 6
        System.out.println("Range sum [2, 4]: " + bit.rangeQuery(2, 4));        // Output: 9

        bit.update(3, 2); // Add 2 to index 3
        System.out.println("After update, prefix sum up to index 3: " + bit.query(3)); // Output: 8
        System.out.println("After update, range sum [2, 4]: " + bit.rangeQuery(2, 4)); // Output: 11

        System.out.print("Current BIT: ");
        bit.printBIT(); // Debug
    }
}

