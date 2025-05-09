package com.manindra.linkedlist_leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache2 extends LinkedHashMap<Integer, Integer> { //solution 146

    private final int capacity;

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2); // capacity = 2
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1)); // returns -1
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }

    public LRUCache2(int capacity) {
        super(capacity, 0.75f, true); // access-order = true
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

