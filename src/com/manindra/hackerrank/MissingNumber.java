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
}
