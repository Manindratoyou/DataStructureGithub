package com.manindra.segment_and_binary_indexed_trees;

public class SegmentTree { //chat gpt

    int[] segmentTree;
    int n;

    // Constructor: Build tree from input array
    SegmentTree(int[] arr) {
        n = arr.length;
        segmentTree = new int[4 * n]; // Sufficient space
        build(arr, 0, n - 1, 0);
    }

    // Build the segment tree
    private void build(int[] arr, int start, int end, int treeIndex) {
        if (start == end) {
            segmentTree[treeIndex] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        build(arr, start, mid, 2 * treeIndex + 1);
        build(arr, mid + 1, end, 2 * treeIndex + 2);

        segmentTree[treeIndex] = segmentTree[2 * treeIndex + 1] + segmentTree[2 * treeIndex + 2];
    }

    // Range sum query from qs to qe
    public int getSum(int qs, int qe) {
        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    private int getSumUtil(int ss, int se, int qs, int qe, int treeIndex) {
        // Total overlap
        if (qs <= ss && qe >= se)
            return segmentTree[treeIndex];

        // No overlap
        if (se < qs || ss > qe)
            return 0;

        // Partial overlap
        int mid = (ss + se) / 2;
        return getSumUtil(ss, mid, qs, qe, 2 * treeIndex + 1) +
                getSumUtil(mid + 1, se, qs, qe, 2 * treeIndex + 2);
    }

    // Update a single index with new value
    public void update(int index, int newVal, int[] arr) {
        int diff = newVal - arr[index];
        arr[index] = newVal;
        updateUtil(0, n - 1, index, diff, 0);
    }

    private void updateUtil(int ss, int se, int index, int diff, int treeIndex) {
        if (index < ss || index > se)
            return;

        segmentTree[treeIndex] += diff;

        if (ss != se) {
            int mid = (ss + se) / 2;
            updateUtil(ss, mid, index, diff, 2 * treeIndex + 1);
            updateUtil(mid + 1, se, index, diff, 2 * treeIndex + 2);
        }
    }

}
