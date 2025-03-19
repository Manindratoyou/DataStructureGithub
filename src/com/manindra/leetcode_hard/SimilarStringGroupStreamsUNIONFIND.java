package com.manindra.leetcode_hard;

import java.util.stream.IntStream;

public class SimilarStringGroupStreamsUNIONFIND {

    public static void main(String[] args) {
        SimilarStringGroupStreamsUNIONFIND solution = new SimilarStringGroupStreamsUNIONFIND();

        String[] strs1 = {"tars", "rats", "arts", "star"};
        String[] strs2 = {"omv", "ovm"};
        String[] strs3 = {"abc", "acb", "bac", "bca", "cab", "cba"};

        System.out.println(solution.numSimilarGroups(strs1)); // Output: 2
        System.out.println(solution.numSimilarGroups(strs2)); // Output: 1
        System.out.println(solution.numSimilarGroups(strs3)); // Output: 1
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);

        IntStream.range(0, n).forEach(i ->
                IntStream.range(i + 1, n).filter(j -> isSimilar(strs[i], strs[j])).forEach(j -> uf.union(i, j))
        );

        return uf.getCount();
    }

    private boolean isSimilar(String s1, String s2) {
        long count = IntStream.range(0, s1.length()).filter(i -> s1.charAt(i) != s2.charAt(i)).count();
        return count == 2 || count == 0;
    }

    static class UnionFind {
        private int[] parent;
        private int count;

        public UnionFind(int n) {
            parent = IntStream.range(0, n).toArray();
            count = n;
        }

        public int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }

        public void union(int x, int y) {
            int rootX = find(x), rootY = find(y);
            if (rootX != rootY) {
                parent[rootY] = rootX;
                count--;
            }
        }

        public int getCount() {
            return count;
        }
    }
}

