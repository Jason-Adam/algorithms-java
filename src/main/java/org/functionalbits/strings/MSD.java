package org.functionalbits.strings;

import static org.functionalbits.sorting.Insertion.exchange;

/**
 * MSD is a class that provides a method for sorting an array of variable length strings using the
 * Most Significant Digit (MSD) recursive sorting algorithm.
 * n = input size
 * w = string length
 * r = radix / alphabet size
 * O(w * n) time | O((r * w) + n) space
 * The depth of recursion is the length of the longest string that is a prefix of two
 * or more of the strings to be sorted.
 */
public class MSD {
    private static final int CUTOFF = 15;
    private static String[] aux;

    private final Alphabet alphabet;
    private final int R;

    public MSD(Alphabet alphabet) {
        this.alphabet = alphabet;
        this.R = alphabet.radix();
    }

    public void sort(String[] input) {
        int n = input.length;
        aux = new String[n];
        // Recursively sort sub-arrays
        sort(input, 0, n - 1, 0);
    }

    private void sort(String[] inp, int lo, int hi, int d) {
        if (hi <= lo + CUTOFF) {
            // Insertion sort for strings whose first d characters are equal
            insertionSort(inp, lo, hi, d);
            return;
        }

        // Compute frequency counts
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(inp[i], d) + 2]++;
        }

        // Transform counts to indices
        for (int r = 0; r< R + 1; r++) {
            count[r + 1] += count[r];
        }

        // Distribute
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(inp[i], d) + 1]++] = inp[i];
        }

        // Copy back
        for (int i = lo; i <= hi; i++) {
            inp[i] = aux[i - lo];
        }

        // Recursively sort for each character value (excluding -1)
        for (int r = 0; r < R; r++) {
            sort(inp, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    private static void insertionSort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
                exchange(a, j, j - 1);
            }
        }
    }

    private static boolean less(String v, String w, int d) {
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) {
                return true;
            } else if (v.charAt(i) > w.charAt(i)) {
                return false;
            }
        }
        return v.length() < w.length();
    }

    private int charAt(String s, int d) {
        if (d < s.length()) {
            return alphabet.toIndex(s.charAt(d));
        } else {
            return -1;
        }
    }
}
