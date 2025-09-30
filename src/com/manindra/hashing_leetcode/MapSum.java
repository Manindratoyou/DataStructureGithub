package com.manindra.hashing_leetcode;

import java.util.HashMap;
import java.util.Map;

class MapSum { //solution 677

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap")); // 3
        mapSum.insert("app", 2);
        System.out.println(mapSum.sum("ap")); // 5
    }
    private Map<String, Integer> map;

    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int total = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                total += entry.getValue();
            }
        }
        return total;
    }


}

