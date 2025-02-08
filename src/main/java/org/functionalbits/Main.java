package org.functionalbits;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running LSD sort");
        System.out.println("----------------");
        String[] testInput = new String[]{
                "4PGC938",
                "2IYE230",
                "3CIO720",
                "1ICK750",
                "1OHV845",
                "4JZY524",
                "1ICK750",
                "3CIO720",
                "1OHV845",
                "1OHV845",
                "2RLA629",
                "2RLA629",
                "3ATW723"
        };

        LSD.sort(testInput, 7);
    }
}