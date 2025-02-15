package org.functionalbits.strings;

import java.util.Arrays;

/**
 * LSD is a class that provides a method for sorting an array of fixed length strings using the
 * Least Significant Digit (LSD) radix sorting algorithm.
 * n = input size
 * w = string length
 * r = radix / alphabet size
 * O(w * n) time | O(n + r) space
 */
public class LSD {
    private final Alphabet alphabet;
    private final int R;

    public LSD(Alphabet alphabet) {
        this.alphabet = alphabet;
        this.R = alphabet.radix();
    }

    public void sort(String[] input, int stringLength) {
        validateInput(input, stringLength);

        int n = input.length;
        String[] aux = new String[n];

        // Sort by key-indexed counting on dth character
        for (int d = stringLength - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            // Compute frequency counts
            for (String s : input) {
                count[alphabet.toIndex(s.charAt(d)) + 1]++;
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

    /**
     * validateInput is a helper method that enforces the invariant that all strings in the
     * input array are of the same length.
     * @param input the array of strings to validate
     * @param stringLength the expected length of each string in the input array
     */
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
