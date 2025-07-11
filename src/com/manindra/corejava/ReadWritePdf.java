package com.manindra.corejava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadWritePdf {

    public static void main(String[] args) {
        // Source and destination file paths
        Path sourcePath = Paths.get("C:/Users/Manindra/Downloads/assignment.pdf");
        Path destinationPath = Paths.get("C:/Users/Manindra/Downloads/assignment_copy.pdf");

        try {
            // Read PDF as bytes
            byte[] fileBytes = Files.readAllBytes(sourcePath);

            // Write bytes to new file
            Files.write(destinationPath, fileBytes);

            System.out.println("PDF copied successfully to: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Error occurred: " + e.getMessage());
        }
    }
}

