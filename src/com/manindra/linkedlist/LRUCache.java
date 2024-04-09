package com.manindra.linkedlist;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, CacheNode> cacheMap;
    private int capacity, itemCount;
    private CacheNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        head = new CacheNode(0, 0);
        tail = new CacheNode(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        itemCount = 0;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println("Value for key 1: " + lruCache.get(1)); // returns 1
        lruCache.put(3, 3); // evicts key 2
        System.out.println("Value for key 2: " + lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4); // evicts key 1
        System.out.println("Value for key 1: " + lruCache.get(1)); // returns -1 (not found)
        System.out.println("Value for key 3: " + lruCache.get(3)); // returns 3
        System.out.println("Value for key 4: " + lruCache.get(4)); // returns 4
    }

    public void removeNode(CacheNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            CacheNode node = cacheMap.get(key);
            removeNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            CacheNode node = cacheMap.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {
            CacheNode newNode = new CacheNode(key, value);
            cacheMap.put(key, newNode);
            if (itemCount < capacity) {
                itemCount++;
            } else {
                cacheMap.remove(tail.pre.key);
                removeNode(tail.pre);
            }
            addToHead(newNode);
        }
    }

    private void addToHead(CacheNode node) {
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

    class CacheNode {
        int key;
        int value;
        CacheNode pre;
        CacheNode next;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
