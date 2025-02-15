package org.functionalbits;

import java.io.File;
import java.util.*;

/**
 * FileLister is a utility class that lists all the Java files in the project
 */
public class FileLister {
    private static final Set<String> EXCLUSIONS = new HashSet<>(Arrays.asList("Main.java", "FileLister.java"));
    private static final String SRC_DIR = "src/main/java/org/functionalbits";

    /**
     * list returns a list of all Java files in the project
     * @return a list of all Java files in the project
     */
    public static List<File> list() {
        List<File> javaFiles = new ArrayList<>();
        File directory = new File(SRC_DIR);

        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory path");
        }

        findJavaFiles(directory, javaFiles);
        return javaFiles;
    }

    /**
     * findJavaFiles is a helper method that recursively searches for Java files in the given directory
     * @param directory the directory to search
     * @param javaFiles the list to store the Java files
     */
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
