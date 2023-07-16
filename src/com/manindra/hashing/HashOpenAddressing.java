package com.manindra.hashing;

class MyHash1{
    int [] arr;
    int capacity,size;
    MyHash1(int c){
        capacity=c;
        size=0;
        arr=new int[capacity];
        for (int i=0;i<capacity;i++)
            arr[i]=-1;
    }
    int hash(int key){
        return key%capacity;
    }
    boolean insert(int key){
        if (size==capacity)
            return false;
        int i=hash(key);
        while (arr[i] != -1 && arr[i]!= -2 && arr[i]!=key)
            i=(i+1)%capacity;
            if (arr[i]==key)
                return false;
            else {
                arr[i]=key;
                size++;
                return true;
            }
    }

    boolean search(int key){
        int h=hash(key);
        int i=h;
        while (arr[i]!=-1){
            if (arr[i]==key)
                return true;
            i=(i+1)%capacity;
            if (i==h)
                return false;
        }
        return false;
    }

    boolean erase(int key){
        int h=hash(key);
        int i=h;
        while (arr[i]!=-1){
            if (arr[i]==key){
                arr[i]=-2;
                return true;
            }
            i=(i+1)%capacity;
            if (i==h)
                return false;
        }
        return false;
    }

}

public class HashOpenAddressing {

    public static void main(String[] args) {

        MyHash1 myHash1=new MyHash1(7);
        myHash1.insert(49);
        myHash1.insert(56);
        myHash1.insert(72);
        if (myHash1.search(56)==true)
            System.out.println("YES");
        else
            System.out.println("NO");
        myHash1.erase(56);
        if (myHash1.search(56)==true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
