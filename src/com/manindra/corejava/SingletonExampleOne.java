package com.manindra.corejava;

public class SingletonExampleOne {

    private static SingletonExampleOne single_instance=null;

    public String s;

    private SingletonExampleOne(){
        s="Hello i am string part of Singleton class";
    }

    public static SingletonExampleOne getInstance(){
        if (single_instance==null)
            single_instance=new SingletonExampleOne();

        return single_instance;
    }

}
