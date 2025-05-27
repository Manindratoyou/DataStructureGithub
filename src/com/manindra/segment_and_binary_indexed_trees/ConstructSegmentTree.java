package com.manindra.segment_and_binary_indexed_trees;

public class ConstructSegmentTree {

    private int[] segmentTree;
    private int[] inputArray;
    private int n;

    public ConstructSegmentTree(int[] arr) {
        this.inputArray = arr;
        this.n = arr.length;
        this.segmentTree = new int[4 * n];
        buildSegmentTree(0, n - 1, 0);
    }

    // Method to build the Segment Tree
    private int buildSegmentTree(int start, int end, int treeIndex) {
        if (start == end) {
            segmentTree[treeIndex] = inputArray[start];
            return inputArray[start];
        }

        int mid = (start + end) / 2;
        segmentTree[treeIndex] = buildSegmentTree(start, mid, 2 * treeIndex + 1)
                + buildSegmentTree(mid + 1, end, 2 * treeIndex + 2);

        return segmentTree[treeIndex];
    }

    // Optional: Method to print the segment tree
    public void printSegmentTree() {
        System.out.print("Segment Tree: ");
        for (int i = 0; i < 2 * n; i++) {
            System.out.print(segmentTree[i] + " ");
        }
        System.out.println();
    }

    // Optional: Get root node value (sum of all elements)
    public int getTotalSum() {
        return segmentTree[0];
    }

    // You can later add range query and update methods here
}
