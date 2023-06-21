package com.manindra.pattern;

public class AToZPattern {

    public static void main(String[] args) {

        int rows=5;
        int cols=5;
        char currentChar='A';

        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                System.out.print(currentChar + " ");
                currentChar++;
            }
            System.out.println();
        }
    }
}
