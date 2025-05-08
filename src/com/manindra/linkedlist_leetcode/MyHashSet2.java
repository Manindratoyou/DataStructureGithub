package com.manindra.linkedlist_leetcode;

import java.util.LinkedList;

class MyHashSet2 {

    private static final int SIZE = 769; // A prime number reduces collisions
    private Bucket[] buckets;

    public MyHashSet2() {
        buckets = new Bucket[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new Bucket();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void add(int key) {
        int index = hash(key);
        buckets[index].insert(key);
    }

    public void remove(int key) {
        int index = hash(key);
        buckets[index].delete(key);
    }

    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].exists(key);
    }

    // Bucket (linked list)
    static class Bucket {
        private final LinkedList<Integer> container;

        public Bucket() {
            container = new LinkedList<>();
        }

        public void insert(Integer key) {
            if (!container.contains(key)) {
                container.addFirst(key);
            }
        }

        public void delete(Integer key) {
            container.remove(key);
        }

        public boolean exists(Integer key) {
            return container.contains(key);
        }
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1)); // true
        System.out.println(hashSet.contains(3)); // false
        hashSet.add(2);
        System.out.println(hashSet.contains(2)); // true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2)); // false
    }
}

