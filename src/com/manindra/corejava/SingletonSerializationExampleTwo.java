package com.manindra.corejava;

import java.io.Serializable;

public class SingletonSerializationExampleTwo implements Serializable {

    private static final long serialVersionUID = 1L;

    private static SingletonSerializationExampleTwo instance;

    private SingletonSerializationExampleTwo() {
        // Private constructor to prevent instantiation
    }

    public static SingletonSerializationExampleTwo getInstance() {
        if (instance == null) {
            instance = new SingletonSerializationExampleTwo();
        }
        return instance;
    }

    // New method to ensure single instance during deserialization
    protected Object readResolve() {
        return getInstance();
    }
}

