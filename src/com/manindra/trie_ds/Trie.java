package com.manindra.trie_ds;

public class Trie {

    static final int ALPHABET_SIZE = 26;

    static TrieNode root;

    public static void main(String args[]) {

        String keys[] = {"bad", "bat", "geeks", "geeks", "cat", "cut"};

        String output[] = {"NO", "YES"};

        root = new TrieNode();

        int i;
        for (i = 0; i < keys.length; i++)
            insert(keys[i]);


        if (search("bad") == true)
            System.out.println("bad --- " + output[1]);
        else System.out.println("bad --- " + output[0]);

        if (search("geeks") == true)
            System.out.println("geeks --- " + output[1]);
        else System.out.println("geeks --- " + output[0]);

        if (search("ca") == true)
            System.out.println("ca --- " + output[1]);
        else System.out.println("ca --- " + output[0]);


    }


    static void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new TrieNode();

            pCrawl = pCrawl.children[index];
        }


        pCrawl.isEndOfWord = true;
    }


    static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }


    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }
    }

}
