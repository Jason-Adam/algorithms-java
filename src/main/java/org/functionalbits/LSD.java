package org.functionalbits;

import java.util.Arrays;

public class LSD {
    public static void sort(String[] input, int stringLength) {
        validateInput(input, stringLength);
        System.out.println("Pre-Sorted:" + Arrays.toString(input));

        int n = input.length;
        int R = 256;
        String[] aux = new String[n];

        for (int d = stringLength - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            for (String s : input) {
                count[s.charAt(d) + 1]++;
            }

            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            for (int i = 0; i < n; i++) {
                aux[count[input[i].charAt(d)]++] = input[i];
            }

            System.arraycopy(aux, 0, input, 0, n);
        }

        System.out.println("Sorted:" + Arrays.toString(input));
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
