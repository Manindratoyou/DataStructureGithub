package com.manindra.hashing;

import java.util.HashMap;
import java.util.Map;

public class HashMapExampleOne {

    public static void main(String[] args) {

        HashMap<String,Integer> hashMap=new HashMap<>();
        hashMap.put("Manindra",10);
        hashMap.put("Kumar",15);
        hashMap.put("Sonu",20);
        System.out.println(hashMap);
        System.out.println("size= " +hashMap.size());
        for (Map.Entry<String,Integer> e: hashMap.entrySet()) {
            System.out.println(e.getKey()+" "+e.getValue());
        }

        System.out.println(hashMap.containsKey("Manindra"));
        hashMap.remove("Sonu");
        System.out.println("size= " +hashMap.size());
        System.out.println(hashMap.get("Kumar"));
    }
}
