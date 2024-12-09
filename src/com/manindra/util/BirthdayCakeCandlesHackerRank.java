package com.manindra.util;

import java.util.ArrayList;
import java.util.List;

public class BirthdayCakeCandlesHackerRank {

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(6);
        li.add(6);
        li.add(8);
        li.add(8);
        li.add(8);
        System.out.println(birthdayCakeCandles(li));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int maximum = Integer.MIN_VALUE;

        //get the height of tallest candle
        for (Integer candle : candles) {
            if (candle >= maximum)
                maximum = candle;
        }

        //count how many tallest candles are present
        int result = 0;
        for (Integer candle : candles) {
            if (candle == maximum)
                result++;
        }
        return result;

    }

}
