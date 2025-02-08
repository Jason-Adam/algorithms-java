package org.functionalbits.strings;

import java.util.Arrays;

/*
LSD is a class that provides a static method for sorting an array of strings using the
Least Significant Digit (LSD) radix sort algorithm.
 */
public class LSD {
    public static void sort(String[] input, int stringLength) {
        validateInput(input, stringLength);

        int n = input.length;
        int R = 256;
        String[] aux = new String[n];

        // Sort by key-indexed counting on dth character
        for (int d = stringLength - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            // Compute frequency counts
            for (String s : input) {
                count[s.charAt(d) + 1]++;
            }

            // Transform counts to indices
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // Distribute
            for (String s : input) {
                aux[count[s.charAt(d)]++] = s;
            }

            // Copy back
            System.arraycopy(aux, 0, input, 0, n);
        }
    }

    /*
    validateInput enforces the invariant:
        Each string in the array must be of the same length
     */
    private static void validateInput(String[] input, int stringLength) {
        for (String s : input) {
            if (s.length() != stringLength) {
                throw new IllegalArgumentException("Input strings must all be the same length");
            }
        }
    }
}
