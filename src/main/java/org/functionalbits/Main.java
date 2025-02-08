package org.functionalbits;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<File> currentImplementations = FileLister.list();
        System.out.println("Current implementations:");
        for (File file : currentImplementations) {
            System.out.println(file.getPath());
        }
    }
}