package com.manindra.util;

import java.util.HashMap;
import java.util.Map;

public class PrintCharacterFrequency {

    public static void main(String[] args) {

        String str = "ascbakhbesiakkava";
        int[] feq = getFrequencyByArray(str);
        int temp = 97;
        for (int s : feq) {
            String s1 = (char) temp++ + "   " + s;
            System.out.println(s1);
        }
        System.out.println();
        Map<Character, Integer> byHashMap = getFrequencyByHashMap(str);
        //byHashMap.forEach((key,val)-> System.out.println("char="+key+" "+"count=" +val));

        for (Map.Entry<Character, Integer> entry : byHashMap.entrySet()) {
            Character k = entry.getKey();
            Integer v = entry.getValue();
            System.out.println("Key: " + k + ", Value: " + v);
        }
    }

    static int[] getFrequencyByArray(String input) {
        int[] frequency = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            frequency[currentCharacter - 'a']++;
        }
        return frequency;
    }

    static Map<Character, Integer> getFrequencyByHashMap(String input) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            int freq = frequencyMap.getOrDefault(currentCharacter, 0);
            frequencyMap.put(currentCharacter, ++freq);
        }
        return frequencyMap;
    }

    /*
    public static void main(String[] args) {
        String test="I am a software developer";
        int[] feq = characterCount(test);
        int temp=0;
        for (int i : feq) {
                String s1 = (char) temp++ + "   " + i;
                System.out.println(s1);

        }
    }

    static int[] characterCount(String input){
        int [] result=new int[256];
        for (int i=0;i<input.length();i++){
            char currentCharacter=input.charAt(i);
            result[currentCharacter]++;
        }
        return result;
    }
     */

}
