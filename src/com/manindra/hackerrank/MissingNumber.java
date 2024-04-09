package com.manindra.hackerrank;

import java.util.*;

public class MissingNumber {

    public static void main(String[] args) {

        List<Integer> list1=new ArrayList<>(Arrays.asList(202,203,204,205,206,207,208));
        List<Integer> list2=new ArrayList<>(Arrays.asList(202,203,204,205,206,207,208,203,208));

        List<Integer> missingNumber=findMissingNumber(list1,list2);
        System.out.println(missingNumber);

    }

    static List<Integer> findMissingNumber(List<Integer> list1,List<Integer> list2){
        Map<Integer,Integer> map=new HashMap<>();

        for(int number : list2)
            map.put(number, map.getOrDefault(number,0)+1);

        for (int number : list1)
            map.put(number,map.get(number)-1);

        List<Integer> missingNumber=new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry :map.entrySet()){
            int number= entry.getKey();
            int frequency= entry.getValue();

            if (frequency>0)
                missingNumber.add(number);
        }

        missingNumber.sort(null);

        return missingNumber;

    }

    static int[] findMissingNumberArray(int [] arr,int [] brr){

        TreeMap<Integer,Integer> integerFrequencyMap=new TreeMap<>();

        //add element to original list
        for (int i: brr){
            int freq=integerFrequencyMap.getOrDefault(i,0);
            freq++;
            integerFrequencyMap.put(i,freq);
        }

        //remove element of new list
        for (int i: arr){
            int freq=integerFrequencyMap.get(i);
            freq--;
            if (freq==0)
                integerFrequencyMap.remove(i);
            else
                integerFrequencyMap.put(i,freq);
        }

        //create the result array
        int [] result=new int[integerFrequencyMap.size()];
        int i=0;
        for (Map.Entry<Integer,Integer> integerIntegerEntry : integerFrequencyMap.entrySet())
            result[i++]=integerIntegerEntry.getKey();

        return result;
    }
}
