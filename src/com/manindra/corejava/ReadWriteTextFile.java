package com.manindra.corejava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadWriteTextFile {

    public static void main(String[] args) {
        // Path to input and output text files
        Path inputPath = Paths.get("C:/Users/Manindra/Downloads/Empty Form-1.txt");
        Path outputPath = Paths.get("C:/Users/Manindra/Downloads/Empty Form-1-copy.txt");

        try {
            // Read content from input file (Java 11+)
            String content = Files.readString(inputPath);

            // Write content to output file (Java 11+)
            Files.writeString(outputPath, content);

            System.out.println("File copied successfully to: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
