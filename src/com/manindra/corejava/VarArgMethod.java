package com.manindra.corejava;

public class VarArgMethod {

    public static void main(String[] args) {

        varArgExample(44,3,3,1,48.5);
        varArgExample(new double[]{1,2,3});
        varArgExample();
    }

    static void varArgExample(double... numbers){
        if (numbers.length==0) {
            System.out.println("No argument passed");
            return;
        }
        double result=numbers[0];
        for (int i=0;i< numbers.length;i++){
            if (numbers[i]>result)
                result=numbers[i];
        }
        System.out.println(result);
    }
}
