import chapter05.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Chapter5AllTests {

    /** <b> Q1 </b> */

    @Test
    public void testClearBit() {
        Q01 q01 = new Q01(111011111, 10011);

        System.out.println(q01.clearBit(11101111, 0));;
    }

    @Test
    public void mergeMtoN() {
        Q01 q01 = new Q01(100000000, 10011);

        int expected = 100010011;
        int actual = q01.mergeMToN(2, 6);

        assertEquals(expected, actual);
    }

    /** <b> Q2 </b> */
    /** <b> Q3 </b> */
    /** <b> Q4 </b> */
    /** <b> Q5 </b> */
    /** <b> Q6 </b> */
    /** <b> Q7 </b> */
    /** <b> Q8 </b> */
}