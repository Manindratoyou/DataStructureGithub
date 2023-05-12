package com.manindra.string;

public class ExampleOne {

    public static void main(String[] args) {

        exampleOne();
        exampleTwo();
        exampleThree();
    }

    static void exampleOne(){
        String s1="Manindra";
        String s2="Manindra";
        if (s1==s2)
            System.out.println("yes");
        else
            System.out.println("no");
        String s3=new String("Manindra");
        if (s1==s3)
            System.out.println("yes");
        else
            System.out.println("no");
    }
    static void exampleTwo(){
        String s1="manindrafortest";
        String s2="for";
        System.out.println(s1.contains(s2));

        String s3="StringExample";
        String s4="Example";
        int res=s3.compareTo(s4);
        if (res==0)
            System.out.println("Same");
        if (res>0)
            System.out.println("s3 greater");
        if (res<0)
            System.out.println("s4 smaller");
    }

    static void exampleThree(){
        String s1="ManindraTest";
        String s2="Manindra";
        System.out.println(s1.indexOf(s2));
        System.out.println(s1.indexOf(s2,1));

        String s3="Laptop";
        String s4=s3;
        s3=s3+"Dell";//s3=s3.concat("Dell");
        System.out.println(s3);
        System.out.println(s3==s4);
    }
}
