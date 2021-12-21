import org.junit.Test;

import static org.junit.Assert.*;

public class Q01_06Test {

    @Test
    public void compress() {
        String testString = "aabcccccaaa";
        Q01_06 q01_06 = new Q01_06(testString);

        String expected = "a2b1c5a3";
        String actual = q01_06.compress();

        assertArrayEquals(expected.toCharArray(), actual.toCharArray());
    }
}