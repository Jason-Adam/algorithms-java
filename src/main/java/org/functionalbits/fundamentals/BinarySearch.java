package org.functionalbits.fundamentals;

public class BinarySearch {
    public static int indexOf(int[] input, int key) {
        int low = 0;
        int high = input.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < input[mid]) {
                high = mid - 1;
            } else if (key > input[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
