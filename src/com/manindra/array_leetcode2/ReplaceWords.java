package com.manindra.array_leetcode2;

import java.util.*;

public class ReplaceWords { //solution 648

    public static void main(String[] args) {
        List<String> dictionary = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";

        String replaced = replaceWords(dictionary, sentence);
        System.out.println(replaced); // Output: "the cat was rat by the bat"
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null; // stores the complete word if it's a root
    }

    static class Trie {
        TrieNode root = new TrieNode();

        // Insert word into Trie
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.children.computeIfAbsent(c, k -> new TrieNode());
            }
            node.word = word;
        }

        // Search for the shortest prefix
        public String findShortestPrefix(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                    if (node.word != null) return node.word;
                } else {
                    break;
                }
            }
            return word;
        }
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String root : dictionary) {
            trie.insert(root);
        }

        StringBuilder result = new StringBuilder();
        for (String word : sentence.split(" ")) {
            if (result.length() > 0) result.append(" ");
            result.append(trie.findShortestPrefix(word));
        }

        return result.toString();
    }

}

