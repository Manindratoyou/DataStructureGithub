package com.manindra.segment_and_binary_indexed_trees;

public class SegmentTreeRangeSum { //chat gpt
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        SegmentTree st = new SegmentTree(arr);

        System.out.print(st.getSum(0, 2) + " "); // 10+20+30 = 60
        System.out.print(st.getSum(1, 3) + " "); // 20+30+40 = 90

        st.update(1, 60, arr); // arr[1] = 60

        System.out.print(st.getSum(0, 2) + " "); // 10+60+30 = 100
        System.out.print(st.getSum(1, 3) + " "); // 60+30+40 = 130
    }
}

