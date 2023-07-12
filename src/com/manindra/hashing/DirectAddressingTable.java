package com.manindra.hashing;

public class DirectAddressingTable {

    static int [] table=new int[100];

    static void insert(int i){
        table[i]=1;
    }
    static void delete(int i){
        table[i]=0;
    }
    static int search(int i){
        return table[i];
    }

    public static void main(String[] args) {
        insert(10);
        System.out.println(search(10));
        delete(10);
        System.out.println(search(10));
    }
}
