package com.manindra.hashing;

import java.util.HashSet;

public class HashSetExampleTwo {

    public static void main(String[] args) {

        HashSet<String> hashSet=new HashSet<>();
        hashSet.add("Manindra");
        hashSet.add("Kumar");
        hashSet.add("Sonu");
        System.out.println(hashSet.size());
        hashSet.remove("Sonu");
        System.out.println(hashSet.size());
        for (String s:hashSet) {
            System.out.println(s);
        }
        System.out.println(hashSet.isEmpty());
    }
}
