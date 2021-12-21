import org.junit.Test;

import static org.junit.Assert.*;

public class Q01_05Test {

    @Test
    public void test1() {
        Q01_05 q01_05 = new Q01_05("pale");
        String editedString = "ple";
        boolean actual = q01_05.edited(editedString);

        assertTrue(actual);
    }

    @Test
    public void oneEditInsertOrRemove() {
        Q01_05 q01_05 = new Q01_05("pales");
        String editedString = "pale";
        boolean actual = q01_05.oneEditInsertedOrRemoved("pales", editedString);

        assertTrue(actual);
    }

    @Test
    public void oneEditRepalce() {
        Q01_05 q01_05 = new Q01_05("pale");
        String editedString = "bale";
        boolean actual = q01_05.oneEditReplace(editedString);
        assertTrue(actual);
    }

    @Test
    public void test4() {
        Q01_05 q01_05 = new Q01_05("pale");
        String editedString = "bae";
        boolean actual = q01_05.edited(editedString);

        assertFalse(actual);
    }
}