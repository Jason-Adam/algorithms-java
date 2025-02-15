package strings;

import org.functionalbits.strings.Alphabet;
import org.functionalbits.strings.MSD;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MSDTest {
    @Test
    public void simpleSort() {
        String[] testInput = new String[]{
                "she",
                "sells",
                "seashells",
                "by",
                "the",
                "sea",
                "shore",
                "the",
                "shells",
                "she",
                "sells",
                "are",
                "surely",
                "seashells"
        };
        String[] expectedOutput = new String[]{
                "are",
                "by",
                "sea",
                "seashells",
                "seashells",
                "sells",
                "sells",
                "she",
                "she",
                "shells",
                "shore",
                "surely",
                "the",
                "the",
        };

        MSD msd = new MSD(Alphabet.BASE64);
        msd.sort(testInput);
        assertArrayEquals(expectedOutput, testInput);
    }
}
