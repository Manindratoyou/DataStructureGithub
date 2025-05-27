package com.manindra.segment_and_binary_indexed_trees;

public class ConstructSegmentTreeMain {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};

        ConstructSegmentTree segmentTree = new ConstructSegmentTree(arr);

        System.out.println("Total sum of array: " + segmentTree.getTotalSum());
        segmentTree.printSegmentTree(); // Optional visualization
    }
}

