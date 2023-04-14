package com.manindra.util;

import java.util.ArrayList;
import java.util.List;

public class BirthdayCakeCandlesHackerRank {

    public static void main(String[] args) {
        List<Integer> li=new ArrayList<>();
        li.add(1);
        li.add(6);
        li.add(6);
        li.add(8);
        li.add(8);
        li.add(8);
        System.out.println(birthdayCakeCandles(li));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int max=candles.get(0);
        for(int i=1;i<candles.size();i++){
            if(max<candles.get(i))
                max=candles.get(i);
        }
        int nb=0;
        for(int j=0;j<candles.size();j++){
            if(candles.get(j)==max)
                nb++;
        }
        return nb;
    }

}
