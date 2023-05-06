package com.manindra.test;

public class NameCountInString {

    public static void main(String[] args) {
        System.out.println(nameCount("manindramanindra"));//manindramaninnndra
    }

    public static int  nameCount(String s){

        String name="manindra";
        int index=0;
        int count=0;

        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==name.charAt(index))
                index++;
            if (index==name.length()) {
                count++;
                index=0;
            }
        }
        return count;
    }
}
