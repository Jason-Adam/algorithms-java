package strings;

import org.functionalbits.strings.Alphabet;
import org.functionalbits.strings.LSD;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LSDTest {
    @Test
    public void simple7CharacterSort() {
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
        String[] expectedOutput = new String[]{
                "1ICK750",
                "1ICK750",
                "1OHV845",
                "1OHV845",
                "1OHV845",
                "2IYE230",
                "2RLA629",
                "2RLA629",
                "3ATW723",
                "3CIO720",
                "3CIO720",
                "4JZY524",
                "4PGC938"
        };

        LSD lsd = new LSD(Alphabet.EXTENDED_ASCII);
        lsd.sort(testInput, 7);
        assertArrayEquals(expectedOutput, testInput);
    }
}
