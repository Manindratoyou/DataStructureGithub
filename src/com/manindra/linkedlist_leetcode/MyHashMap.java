package com.manindra.linkedlist_leetcode;

class MyHashMap { //solution 706

    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new Node(-1, -1); // dummy head
        }
        Node prev = find(buckets[index], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) return -1;
        Node prev = find(buckets[index], key);
        return (prev.next == null) ? -1 : prev.next.value;
    }

    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) return;
        Node prev = find(buckets[index], key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }

    // Helper method to find the previous node of target key
    private Node find(Node head, int key) {
        Node prev = head;
        Node curr = head.next;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    // Test example
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 1);              // map = {1:1}
        map.put(2, 2);              // map = {1:1, 2:2}
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(3)); // -1 (not found)
        map.put(2, 1);              // update key 2 to value 1
        System.out.println(map.get(2)); // 1
        map.remove(2);             // remove key 2
        System.out.println(map.get(2)); // -1
    }
}

