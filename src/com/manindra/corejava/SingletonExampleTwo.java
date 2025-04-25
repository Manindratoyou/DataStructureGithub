package com.manindra.corejava;

class SingletonEagar {
    private static SingletonEagar instance = new SingletonEagar();

    private SingletonEagar() {
    }

    public static SingletonEagar getInstance() {
        return instance;
    }
}

class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        if (instance == null)
            instance = new SingletonLazy();
        return instance;
    }
}

public class SingletonExampleTwo {

    public static void main(String[] args) {
        SingletonEagar instance1 = SingletonEagar.getInstance();
        System.out.println(instance1 + " : Singleton Eager initialization");

        SingletonLazy instance2 = SingletonLazy.getInstance();
        System.out.println(instance2 + " : Singleton Lazy initialization");
    }


}
