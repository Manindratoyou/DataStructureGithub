package com.manindra.trie_ds;

public class CountDistinctRowsBinaryMatrix {

    static final int M = 4, N = 3;
    static int mat[][] = {{1, 0, 0},
            {1, 1, 1},
            {1, 0, 0},
            {0, 1, 0}};

    static TrieNode root;

    public static void main(String args[]) {

        System.out.println(countDis());

    }


    static boolean insert(TrieNode root, int row) {
        TrieNode curr = root;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            int index = mat[row][i];

            if (curr.child[index] == null) {
                curr.child[index] = new TrieNode();
                flag = true;
            }

            curr = curr.child[index];
        }

        return flag;
    }


    static int countDis() {
        TrieNode root = new TrieNode();

        int res = 0;

        for (int row = 0; row < M; row++) {
            if (insert(root, row))
                res++;
        }

        return res;
    }

    static class TrieNode {
        TrieNode[] child = new TrieNode[2];

    }


}
