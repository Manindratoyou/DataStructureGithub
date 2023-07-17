package com.manindra.hashing;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExampleOne {

    public static void main(String[] args) {

        HashSet<String> hashSet=new HashSet<>();
        hashSet.add("Manindra");
        hashSet.add("Kumar");
        hashSet.add("Sonu");
        System.out.println(hashSet);
        System.out.println(hashSet.contains("Manindra"));
        Iterator<String> iterator= hashSet.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next() + " ");
    }
}
