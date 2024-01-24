package com.manindra.leetcode;

import java.util.Arrays;

public class Solution1967 { //Number of Strings That Appear as Substrings in Word

    public static void main(String[] args) {

        String [] patterns = {"a","abc","bc","d"}; String word = "abc";
        System.out.println(numOfStrings(patterns,word));
        System.out.println(numOfStringsSolutionTwo(patterns,word));

    }
    static int numOfStrings(String[] patterns, String word) {
        int count=0;
        for (char c:word.toCharArray()) {
            for (String s:patterns) {
                if (s.indexOf(c)!=-1) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    static int numOfStringsSolutionTwo(String[] patterns, String word) {
        int count = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }
        return count;
    }

    //Time Complexity: O(n * m), where n is the length of the patterns array, and m is the length of the word.
    //Auxiliary Space: O(1)
    static int numOfStringsSolutionThree(String[] patterns, String word) {
        return (int) Arrays.stream(patterns)
                .filter(pattern -> word.contains(pattern))
                .count();
    }

    //Using Trie Data Structure
    private static TrieNode buildTrie(String[] patterns) {
        TrieNode root = new TrieNode();
        for (String pattern : patterns) {
            TrieNode node = root;
            for (char c : pattern.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }
        return root;
    }

    private static int countSubstrings(TrieNode root, String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = root;
            for (int j = i; j < word.length(); j++) {
                char c = word.charAt(j);
                if (node.children[c - 'a'] == null) {
                    break;
                }
                node = node.children[c - 'a'];
                if (node.isEnd) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

}
