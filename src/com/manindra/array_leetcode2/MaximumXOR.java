package com.manindra.array_leetcode2;

public class MaximumXOR { //solution 421

    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println("Maximum XOR is: " + findMaximumXOR(nums));  // Output: 28
    }

    public static int findMaximumXOR(int[] nums) {
        int max = 0;

        for (int num : nums) {
            insert(num);
        }

        for (int num : nums) {
            max = Math.max(max, findMaxXOR(num));
        }

        return max;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[2];
    }

    static TrieNode root = new TrieNode();

    // Insert number into Trie
    static void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    // Find maximum XOR for current number with existing Trie
    static int findMaxXOR(int num) {
        TrieNode node = root;
        int maxXOR = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = (num >>> i) & 1;
            int oppositeBit = 1 - bit;

            if (node.children[oppositeBit] != null) {
                maxXOR |= (1 << i);
                node = node.children[oppositeBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXOR;
    }


    public int findMaximumXOR2(int[] nums) { //Brut force approach
        int maxXOR = 0;

        // Try every pair of numbers
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                maxXOR = Math.max(maxXOR, xor);
            }
        }

        return maxXOR;
    }
}
