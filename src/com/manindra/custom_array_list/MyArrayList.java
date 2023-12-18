package com.manindra.custom_array_list;

import java.util.Arrays;

public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY=10;
    private Object[] array;
    private int size;

    public MyArrayList(){
        array=new Object[DEFAULT_CAPACITY];
        size=0;
    }

    public void add(T element){
        ensureCapacity();
        array[size++]=element;
    }

    public T get(int index){
        if (index<0 || index>=size)
            throw new IndexOutOfBoundsException("Index" +index+" "+"size "+size);
        return (T) array[index];
    }

    public void remove(int index){
        if (index<0 || index>=size)
            throw new IndexOutOfBoundsException("Index" +index+" "+"size "+size);
        System.arraycopy(array,index+1,array,index,size-index-1);
        array[--size]=null;
    }

    public int getSize(){
        return size;
    }

    private void ensureCapacity(){
        if (size== array.length){
            int newCapacity= array.length *2;
            array= Arrays.copyOf(array,newCapacity);
        }
    }

    public static void main(String[] args) {

        MyArrayList<Integer> myArrayList=new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        System.out.println("Elements in the list");
        for (int i=0;i< myArrayList.size;i++){
            System.out.println(myArrayList.get(i));
        }

        myArrayList.remove(1);
        System.out.println("After removing element at index at 1");
        for (int i=0;i< myArrayList.size;i++){
            System.out.println(myArrayList.get(i));
        }
    }
}
