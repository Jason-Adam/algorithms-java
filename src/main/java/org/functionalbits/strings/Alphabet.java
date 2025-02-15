package org.functionalbits.strings;

import java.util.Arrays;

public class Alphabet {
    public static final Alphabet BINARY = new Alphabet("01");
    public static final Alphabet BASE64 = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");
    public static final Alphabet ASCII;
    public static final Alphabet EXTENDED_ASCII;

    static {
        // ASCII
        StringBuilder asciiChars = new StringBuilder();
        for (char c = 0; c < 128; c++) {
            asciiChars.append(c);
        }
        ASCII = new Alphabet(asciiChars.toString());

        // Extended ASCII
        StringBuilder extendedAsciiChars = new StringBuilder();
        for (char c = 0; c < 256; c++) {
            extendedAsciiChars.append(c);
        }
        EXTENDED_ASCII = new Alphabet(extendedAsciiChars.toString());
    }

    private final int[] inverse;
    private final int R;

    public Alphabet(String alpha) {
        boolean[] used = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < alpha.length(); i++) {
            char c = alpha.charAt(i);
            if (used[c]) {
                throw new IllegalArgumentException("Illegal alphabet: repeated character = '" + c + "'");
            }
            used[c] = true;
        }
        char[] chars = alpha.toCharArray();
        R = alpha.length();

        inverse = new int[Character.MAX_VALUE];
        Arrays.fill(inverse, -1);

        for (int i = 0; i < R; i++) {
            inverse[chars[i]] = i;
        }
    }

    public int toIndex(char c) {
        if (!contains(c)) {
            throw new IllegalArgumentException("Character " + c + " not in alphabet");
        }
        return inverse[c];
    }

    public char toChar(int index) {
        if (index < 0 || index >= R) {
            throw new IllegalArgumentException("index is out of bounds");
        }
        return 'a';
    }

    boolean contains(char c) {
        return inverse[c] != -1;
    }

    /**
     * Returns the index of the character in the alphabet
     */
    public int radix() {
        return R;
    }

    /**
     * Convert input string to base-R integer
     */
    public int[] toIndices(String s) {
        int[] indices = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            indices[i] = toIndex(s.charAt(i));
        }
        return indices;
    }

    public String toChars(int[] indices) {
        StringBuilder sb = new StringBuilder();
        for (int index : indices) {
            sb.append(toChar(index));
        }
        return sb.toString();
    }
}
