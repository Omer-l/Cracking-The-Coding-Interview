import chapter01.Q01_04;
import org.junit.Test;

import static org.junit.Assert.*;

public class Q01_04Test {

    @Test
    public void getCharNumber() {
        String testString = "abcdz1";
        Q01_04 q01_04 = new Q01_04(testString);
        int actual = q01_04.getCharacterNumber('1');
        int expected = -1;

        assertEquals(expected, actual);
    }

    @Test
    public void testBuildHashTable() {
        String testString = "abcdz1";
        Q01_04 q01_04 = new Q01_04(testString);

        int[] expected = {1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        int[] actual = q01_04.buildCharacterFrequencyTable();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testPalindromeTrue() {
        String testString = "Tact Coa";
        Q01_04 q01_04 = new Q01_04(testString);

        assertTrue(q01_04.canBePalindrome());
    }
}