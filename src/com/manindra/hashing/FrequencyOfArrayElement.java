package com.manindra.hashing;

import java.util.HashMap;

public class FrequencyOfArrayElement {

    public static void main(String[] args) {
        int [] arr={10,20,20,30,10};
        //printFrequency(arr);
        printFrequencySolTwo(arr);

    }

    static void printFrequency(int [] arr){
        for (int i=0;i< arr.length;i++){
            boolean flag=false;
            for (int j=0;j<i;j++){
                if (arr[i]==arr[j]){
                    flag=true;
                    break;
                }
            }
            if (flag==true)
                continue;
            int frequency=1;
            for (int j=i+1;j< arr.length;j++)
                if (arr[i]==arr[j])
                    frequency++;
            System.out.println(arr[i]+" "+frequency);
        }
    }
    static void printFrequencySolTwo(int [] arr){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int x :arr){
            hashMap.put(x,hashMap.getOrDefault(x,0)+1);
        }
        hashMap.forEach((key,value)-> System.out.println(key+" "+value));
    }
}
