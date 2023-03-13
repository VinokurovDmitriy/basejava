package com.urise.webapp.utils;

import java.io.File;
import java.io.IOException;

public class FileOperations {
    private static final File file = new File("./");
    public static void printFiles(File dir) throws IOException {
        File[] list = dir.listFiles();
        assert list != null;
        for(File file : list) {
            if(file.isDirectory()){
                System.out.println(file.getCanonicalPath());
                if(!file.getName().equals(".git")) {
                    printFiles(file);
                }
            } else {
                System.out.println("   " + file.getName());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        printFiles(file);
    }
}
