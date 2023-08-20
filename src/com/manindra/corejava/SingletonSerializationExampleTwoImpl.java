package com.manindra.corejava;

import java.io.*;

public class SingletonSerializationExampleTwoImpl {

    public static void main(String[] args) {
        SingletonSerializationExampleTwo originalInstance = SingletonSerializationExampleTwo.getInstance();

        try {
            // Serialize the singleton object
            FileOutputStream fileOut = new FileOutputStream("singleton.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(originalInstance);
            out.close();
            fileOut.close();

            // Deserialize the object
            FileInputStream fileIn = new FileInputStream("singleton.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            SingletonSerializationExampleTwo deserializedInstance = (SingletonSerializationExampleTwo) in.readObject();
            in.close();
            fileIn.close();

            // Compare the instances
            System.out.println("Original instance hash code: " + originalInstance.hashCode());
            System.out.println("Deserialized instance hash code: " + deserializedInstance.hashCode());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


