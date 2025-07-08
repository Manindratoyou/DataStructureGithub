package com.manindra.leetcode_hard;

public class SimilarStringGroup { //Solution 839

    public static void main(String[] args) {
        SimilarStringGroup solution = new SimilarStringGroup();

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

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }

    private boolean isSimilar(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 2) return false;
            }
        }
        return diffCount == 2 || diffCount == 0;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}

