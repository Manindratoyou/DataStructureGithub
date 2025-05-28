package com.manindra.segment_and_binary_indexed_trees;

public class UpdateQuery {

    static int CST(int ss, int se, int si, int arr[], int tree[]) {
        if (ss == se) {
            tree[si] = arr[ss];
            return arr[ss];
        }

        int mid = (ss + se) / 2;

        tree[si] = CST(ss, mid, 2 * si + 1, arr, tree)
                + CST(mid + 1, se, 2 * si + 2, arr, tree);

        return tree[si];
    }

    static void updateRec(int ss, int se, int i, int si, int diff, int tree[]) {
        if (i < ss || i > se)
            return;

        tree[si] = tree[si] + diff;

        if (se > ss) {
            int mid = (ss + se) / 2;

            updateRec(ss, mid, i, 2 * si + 1, diff, tree);
            updateRec(mid + 1, se, i, 2 * si + 2, diff, tree);
        }
    }

    public static void main(String args[]) {
        int arr[] = {10, 20, 30, 40}, n = arr.length;
        int tree[] = new int[4 * n];

        CST(0, n - 1, 0, arr, tree);

        int indexToUpdate = 1;
        int newValue = 25;
        int diff = newValue - arr[indexToUpdate];

        arr[indexToUpdate] = newValue;
        updateRec(0, n - 1, indexToUpdate, 0, diff, tree);

        // Print updated segment tree
        for (int i = 0; i < 2 * n; i++) {
            System.out.print(tree[i] + " ");
        }
    }
}

