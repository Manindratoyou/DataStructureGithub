package com.manindra.greedy_ds;

import java.util.PriorityQueue;

public class Huffmancoding {

    public static void main(String[] args) {
        printHcodes(new char[]{'a', 'd', 'e', 'f'}, new int[]{30, 40, 80, 60});
    }

    public static void printHcodes(char[] arr, int[] freq) {
        PriorityQueue<Node> h = new PriorityQueue<>((n1, n2) -> n1.freq - n2.freq);
        for (int i = 0; i < arr.length; i++)
            h.add(new Node(arr[i], freq[i], null, null));
        while (h.size() > 1) {
            Node l = h.poll();
            Node r = h.poll();
            h.add(new Node('$', l.freq + r.freq, l, r));
        }
        printRec(h.peek(), "");
    }

    public static void printRec(Node root, String s) {
        if (root == null) return;
        if (root.ch != '$') {
            System.out.println(root.ch + ": " + s);
            return;
        }
        printRec(root.left, s + "0");
        printRec(root.right, s + "1");
    }


    static class Node {
        char ch;
        int freq;
        Node left;
        Node right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }
}
