package com.manindra.corejava;

import java.util.HashMap;
import java.util.Map;

final class StudentImmutable {

    //member attributes of final class
    private final String name;

    private final int regNumber;

    private final Map<String,String> metaData;

    //parameterized constructor of immutable class
    StudentImmutable(String name, int regNumber, Map<String, String> metaData) {
        //this keyword refers to current instance itself
        this.name = name;
        this.regNumber = regNumber;

        //Creating Map object with reference to HashMap
        Map<String,String> tempMap=new HashMap<>();
        //iterating using for-each loop
        for (Map.Entry<String,String> entry: metaData.entrySet()){
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.metaData = metaData;
    }

    //there should not be any setters
    //getter
     public String getName(){
        return name;
     }
     public int getRegNumber(){
        return regNumber;
    }
    public Map<String,String> getMetaData(){
        Map<String,String> tempMap=new HashMap<>();
        //iterating using for-each loop
        for (Map.Entry<String,String> entry: this.metaData.entrySet()){
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}
