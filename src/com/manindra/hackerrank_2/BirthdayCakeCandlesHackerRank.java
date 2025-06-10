package com.manindra.hackerrank_2;

import java.util.ArrayList;
import java.util.Collections;
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
        System.out.println(birthdayCakeCandles2(li));
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

    public static int birthdayCakeCandles2(List<Integer> candles) {
        // Write your code here
        Collections.sort(candles);
        int count = 1;
        int largest = candles.get(candles.size()-1);
        for(int i=candles.size()-2;i>=0;i--){
            if(candles.get(i)!=largest){
                break;
            }else{
                count++;
            }
        }
        return count;
    }

}
