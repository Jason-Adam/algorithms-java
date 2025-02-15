package fundamentals;

import org.junit.jupiter.api.Test;

import static org.functionalbits.fundamentals.BinarySearch.indexOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {
    @Test
    public void valuePresent() {
        int[] sortedInput = new int[]{1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10};
        int expectedIndex = 4;
        assertEquals(indexOf(sortedInput, 4), expectedIndex);
    }

    @Test
    public void valueNotPresent() {
        int[] sortedInput = new int[]{1, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10};
        int expectedIndex = -1;
        assertEquals(indexOf(sortedInput, 11), expectedIndex);
    }
}
