package com.manindra.hashing;

import java.util.ArrayList;
import java.util.LinkedList;

class MyHash{
    int BUCKET;
    ArrayList<LinkedList<Integer>> table;

    MyHash(int size){
        BUCKET=size;
        table= new ArrayList<>();//table=new ArrayList<LinkedList<Integer>>();
        for (int i=0;i<size;i++){
            table.add(new LinkedList<>());//table.add(new LinkedList<Integer>());
        }
    }
    void insert(Integer k){
        int i=k%BUCKET;
        table.get(i).add(k);
    }
    boolean search(Integer k){
        int i=k%BUCKET;
        return table.get(i).contains(k);
    }
    void delete(Integer k){
        int i=k%BUCKET;
        table.get(i).remove();
    }
}
public class HashChaining {

    public static void main(String[] args) {

        MyHash hash=new MyHash(7);
        hash.insert(70);
        hash.insert(71);
        hash.insert(9);
        hash.insert(56);
        hash.insert(72);
        System.out.println(hash.search(70));
        hash.delete(72);
        System.out.println(hash.search(15));
    }
}
