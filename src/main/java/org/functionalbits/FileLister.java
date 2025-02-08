package org.functionalbits;

import java.io.File;
import java.util.*;

public class FileLister {
    private static final Set<String> EXCLUSIONS = new HashSet<>(Arrays.asList("Main.java", "FileLister.java"));
    private static final String SRC_DIR = "src/main/java/org/functionalbits";

    public static List<File> list() {
        List<File> javaFiles = new ArrayList<>();
        File directory = new File(SRC_DIR);

        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory path");
        }

        findJavaFiles(directory, javaFiles);
        return javaFiles;
    }

    private static void findJavaFiles(File directory, List<File> javaFiles) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    findJavaFiles(file, javaFiles);
                } else if (file.getName().endsWith(".java")) {
                    if (!EXCLUSIONS.contains(file.getName())) {
                        javaFiles.add(file);
                    }
                }
            }
        }
    }
}
