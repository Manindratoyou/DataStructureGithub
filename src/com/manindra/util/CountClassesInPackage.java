package com.manindra.util;

import java.io.File;


public class CountClassesInPackage {

    public static void main(String[] args) {
        // Path to source folder (not classpath root)
        String sourceRoot = "D:/Practice/DataStructureGithub/src";
        String packageName = "com.manindra.leetcode"; // Target package

        int count = countJavaFilesInPackage(sourceRoot, packageName);
        System.out.println("Total number of .java classes in package '" + packageName + "' is: " + count);
    }

    public static int countJavaFilesInPackage(String sourceRoot, String packageName) {
        String packagePath = packageName.replace('.', File.separatorChar);
        File packageDir = new File(sourceRoot, packagePath);

        if (!packageDir.exists() || !packageDir.isDirectory()) {
            System.out.println("Package directory not found: " + packageDir.getAbsolutePath());
            return 0;
        }

        File[] javaFiles = packageDir.listFiles((dir, name) -> name.endsWith(".java"));
        return javaFiles != null ? javaFiles.length : 0;
    }
}


