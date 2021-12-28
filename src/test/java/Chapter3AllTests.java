import chapter03.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Chapter3AllTests {

    /** <b> Q1 </b> */

    @Test
    public void addAndResize4Stacks() {
        Q01<Integer> q01 = new Q01<>(4, 1, 5);

        q01.push(0, 5);
        q01.push(0, 25);
        q01.push(0, 889);
        q01.push(0, 5);
        q01.push(0, 25);
        q01.push(1, 55);
        q01.push(1, 12345);
        q01.push(2, 500);
        q01.push(2, 123123123);
        q01.push(2, 123123123);
        q01.push(2, 123123123);
        q01.push(2, 9999999);
        q01.push(3, 8999999);
        q01.push(3, 8899999);
        q01.push(3, 8889999);
        q01.push(3, 8888999);
    }

    @Test
    public void pop() {
        Q01<Integer> q01 = new Q01<>(3, 5, 5);

        q01.push(0, 5);
        q01.push(0, 25);
        q01.push(0, 889);
        q01.push(0, 5);
        q01.push(0, 25);
        q01.push(1, 55);
        q01.push(1, 12345);
        q01.push(2, 500);
        q01.push(2, 123123123);
        q01.push(2, 9999999);
        q01.push(2, 292929292);

        Integer expected = null;
        q01.pop(2);
        q01.pop(2);
        q01.pop(2);
        q01.pop(2);
        q01.pop(2);
        Integer actual = q01.pop(2);

        assertEquals(expected, actual);
    }

    /** <b> Q2 </b> */
}