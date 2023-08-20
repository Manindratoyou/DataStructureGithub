package com.manindra.corejava;

import java.io.Serializable;

public class SingletonSerializationExampleOne implements Serializable {

    private static final long serialVersionUID = 1L;

    private static SingletonSerializationExampleOne instance;

    private SingletonSerializationExampleOne() {
        // Private constructor to prevent instantiation
    }

    public static SingletonSerializationExampleOne getInstance() {
        if (instance == null) {
            instance = new SingletonSerializationExampleOne();
        }
        return instance;
    }
}

