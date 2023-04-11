package com.manindra.searchsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuiltInMethodSearch {

    public static void main(String[] args) {

        arraySearch();
        System.out.println("================");
        collectionSearch();
    }

    static void arraySearch(){
        byte byteArr[] = {10,20,15,22,35};

        char charArr[] = {'g','p','q','c','i'};

        int intArr[] = {10,20,15,22,35};

        double doubleArr[] = {10.2,15.1,2.2,3.5};

        float floatArr[] = {10.2f,15.1f,2.2f,3.5f};

        short shortArr[] = {10,20,15,22,35};

        Arrays.sort(byteArr);
        Arrays.sort(charArr);
        Arrays.sort(intArr);
        Arrays.sort(doubleArr);
        Arrays.sort(floatArr);
        Arrays.sort(shortArr);

        byte byteKey = 35;
        char charKey = 'g';
        int intKey = 22;
        double doubleKey = 1.5;
        float floatKey = 35;
        short shortKey = 5;

        System.out.println(byteKey + " found at index = "
                +Arrays.binarySearch(byteArr,byteKey));
        System.out.println(charKey + " found at index = "
                +Arrays.binarySearch(charArr,charKey));
        System.out.println(intKey + " found at index = "
                +Arrays.binarySearch(intArr,intKey));
        System.out.println(doubleKey + " found at index = "
                +Arrays.binarySearch(doubleArr,doubleKey));
        System.out.println(floatKey + " found at index = "
                +Arrays.binarySearch(floatArr,floatKey));
        System.out.println(shortKey + " found at index = "
                +Arrays.binarySearch(shortArr,shortKey));
    }

    public static void collectionSearch()
    {
        List al = new ArrayList();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(10);
        al.add(20);

        // 10 is present at index 3.
        int index = Collections.binarySearch(al, 10);
        System.out.println(index);

        // 13 is not present. 13 would have been inserted
        // at position 4. So the function returns (-4-1)
        // which is -5.
        index = Collections.binarySearch(al, 15);
        System.out.println(index);
    }
}
