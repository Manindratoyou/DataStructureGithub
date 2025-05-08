package com.manindra.linkedlist_leetcode;

class MyHashSet {

    private final boolean[] set;

    public MyHashSet() {
        set = new boolean[1_000_001]; // Max key = 10^6
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
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

